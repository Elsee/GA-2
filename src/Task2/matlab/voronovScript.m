clc
clear;
close all;

% constants
fieldSize = 150;
numberOfPoints = 15;


% initialize img with random points
points = randi([1 fieldSize],2,numberOfPoints);
points = [points; randi([1 255],1,numberOfPoints)];
    


points = sortrows(points',2)'; % sorting points by y-coordinate
img(1:fieldSize,1:fieldSize) = 255;
for i = 1:length(points)
    img(points(2,i), points(1,i)) = 0;
end

distance = zeros(length(points),fieldSize,fieldSize);
for i = 1:length(points)
    distance(i,:,:) = distanceCalc(points(1,i), points(2,i), fieldSize);
end

% distance = distanceCalc(points(1,1), points(2,1), fieldSize);
img(1:fieldSize,1:fieldSize) = points(3,1);
% 
% color = 10;

% d = reshape(distance(1,:,:), [fieldSize fieldSize]);
d = distance(1,:,:);
color = 10;

for i = 1:length(points)
    diff = distance(i,:,:) - d;
    diff(diff>0) = 0;
    img(diff<0) = randi([1,255],1,1);
    d = d + diff;
    for j = 1:length(points)
    	img(points(1,i), points(2,i)) = 0;
    end
    image(img,'CDataMapping','scaled');
    pause(1/2)
end  
