package Task1;

import com.sun.xml.internal.stream.Entity;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Rectangle> recObsList = new LinkedList<>();
    static List<Circle> circlesObsList = new LinkedList<>();
    static List<Tank> tankList = new LinkedList<>();
    static List<Gun> listOfGuns = new LinkedList<>();

    public static void main(String[] args) {
        initialize("src/Task1/Task1.txt");
        for (Gun gun : listOfGuns) {
            System.out.println(gun.getName());
            for (Tank tank : tankList) {
                if (scanVert(tank, gun.getX(), gun.getY(), gun) || scanHor(tank, gun.getX(), gun.getY(), gun))
                    System.out.println(tank.name + " hit");
                 else
                    System.out.println(tank.name + " not hit");
            }

        }
    }

    static boolean scanVert(Tank tank, double gunX, double gunY, Gun gun) {
        for (double i = tank.getOriginX(); i < tank.getOriginX() + tank.getWidth(); i++) {

            if (gun.isDotInTriangle(i, tank.getOriginY()))
                if (istObstaclesOnLine(new Line(gunX, gunY, i, tank.getOriginY()), tank)) return true;

            if (gun.isDotInTriangle(i, tank.getOriginY() + tank.getHeight()))
                if(istObstaclesOnLine(new Line(gunX, gunY, i, tank.getOriginY() + tank.getHeight()), tank)) return true;
        }
        return false;
    }

    static boolean scanHor(Tank tank, double gunX, double gunY, Gun gun) {
        for (double i = tank.getOriginY(); i < tank.getOriginY() + tank.getHeight(); i++) {

            if (gun.isDotInTriangle(tank.getOriginX(), i))
                if (istObstaclesOnLine(new Line(gunX, gunY, tank.getOriginX(), i), tank)) return true;

            if (gun.isDotInTriangle(tank.getOriginX() + tank.getWidth(), i))
                if (istObstaclesOnLine(new Line(gunX, gunY, tank.getOriginX() + tank.getWidth(), i), tank)) return true;
        }
        return false;
    }

    static boolean istObstaclesOnLine(Line line, Tank ignoreTank){
        Boolean isHitOnTarget=true;
        for (Rectangle rec : recObsList) if (line.isIntersect(rec)) { isHitOnTarget=false; }
        for (Circle cir : circlesObsList) if (line.isIntersect(cir)){ isHitOnTarget=false; }
        for (Tank tank : tankList) if (tank != ignoreTank && line.isIntersect(tank.toRectangle())) { isHitOnTarget=false; }
        return isHitOnTarget;
    }

    static void initialize(String filename) {
        BufferedReader readingBuffer = null;
        try {
            readingBuffer  = new BufferedReader(new FileReader(filename));
            readTargets(readingBuffer);
            readGuns(readingBuffer);
            readObstacles(readingBuffer);
        }catch (IOException e) {
            System.out.println("Task reading failed: "+e.getLocalizedMessage());
        }finally {
            if (readingBuffer != null) {
                try {
                    readingBuffer.close();
                } catch (IOException e) {
                    System.out.println("Can't close task file: "+e.getLocalizedMessage());
                }
            }
        }
    }

    static void readTargets(BufferedReader readingBuffer) throws IOException{
        String line = readingBuffer.readLine();
        if(isEmptyLine(line)) {
            throw new IOException("Number of targets expected but not found");
        }

        int targetsCount = Integer.parseInt(line);
        if(targetsCount <= 0) {
            throw new IOException("Number of targets must be positive");
        }

        for (int i = 0; i < targetsCount; i++) {
            line = readingBuffer.readLine();
            if(isEmptyLine(line)){
                throw new IOException("Target description expected but not found");
            }

            String[] readerData = line.split(" ");
            double x = Double.parseDouble(readerData[0]);
            double y = Double.parseDouble(readerData[1]);
            double width = Double.parseDouble(readerData[2]);
            double height = Double.parseDouble(readerData[3]);
            String name = readerData[4];
            Tank tank = new Tank(x, y, width, height, name);
            tankList.add(tank);
        }
    }

    static void readGuns(BufferedReader readingBuffer) throws IOException{
        String line = readingBuffer.readLine();
        if(isEmptyLine(line)) {
            throw new IOException("Number of guns expected but not found");
        }

        int gunsCount = Integer.parseInt(line);
        if(gunsCount <= 0) {
            throw new IOException("Number of guns must be positive");
        }

        for (int i = 0; i < gunsCount; i++) {
            line = readingBuffer.readLine();
            if(isEmptyLine(line)){
                throw new IOException("Gun description expected but not found");
            }

            String[] readerData = line.split(" ");
            double x = Double.parseDouble(readerData[0]);
            double y = Double.parseDouble(readerData[1]);
            String name = readerData[2];
            Gun gun = new Gun(x, y, name);
            listOfGuns.add(gun);
        }
    }

    static void readObstacles(BufferedReader readingBuffer) throws IOException{
        String line = readingBuffer.readLine();
        if(isEmptyLine(line)) {
            return;
        }

        int obstaclesCount = Integer.parseInt(line);
        if(obstaclesCount < 0) {
            throw new IOException("Number of obstacles must not be negative");
        }

        for (int i = 0; i < obstaclesCount; i++) {
            line = readingBuffer.readLine();
            if(isEmptyLine(line)){
                throw new IOException("Obstacle description expected but not found");
            }

            String[] readerData = line.split(" ");
            int type = Integer.parseInt(readerData[0]);
            double x = Double.parseDouble(readerData[1]);
            double y = Double.parseDouble(readerData[2]);

            if (type == 0) {
                // circle
                double radius = Double.parseDouble(readerData[3]);
                Circle circle = new Circle(x, y, radius);
                circlesObsList.add(circle);
            }else if(type == 1){
                // rectangle
                double width = Double.parseDouble(readerData[3]);
                double height = Double.parseDouble(readerData[4]);
                Rectangle rectangle = new Rectangle(x, y, width, height);
                recObsList.add(rectangle);
            }
        }
    }

    static Boolean isEmptyLine(String line){
        return line == null || line.length() == 0;
    }
}
