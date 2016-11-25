clc
clear;
close all;

t = [0;1];
[X,Y,Z] = cylinder(t, 300);


% initialize img with random points
points = randi([1 fieldSize],2,numberOfPoints);
points = sortrows(points',2)' % sorting points by y-coordinate
img(1:fieldSize,1:fieldSize) = 255;
for i = 1:length(points)
    img(points(2,i), points(1,i)) = 0;
end

figure;
clf;

surf(X,Y,Z,'FaceColor','r','EdgeColor','r');
% alpha(.5)

hold all

surf(X+1,Y,Z);
% alpha(.5);
% view(6)
axis equal


view(0, -90);