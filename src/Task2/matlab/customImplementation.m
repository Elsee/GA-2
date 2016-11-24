clc
clear;
close all;

% constants
fieldSize = 50;
numberOfPoints = 10;


% initialize img with random points
points = randi([1 fieldSize],2,numberOfPoints);
points = sortrows(points',2)' % sorting points by y-coordinate
img(1:fieldSize,1:fieldSize) = 255;
for i = 1:length(points)
    img(points(2,i), points(1,i)) = 0;
end

% animation of sweep line going through 
pointer = 1;
points_empty = 'false'; % analog of prorityQueue.empty
for i = 1:fieldSize
    img_t = img;
    
    % changing colour of points
    while (strcmp(points_empty,'false') && points(2,pointer) == i)
        if pointer <= length(points)
            if pointer == length(points)
                points_empty = 'true';
            end
            fprintf('Go through point %d. point: %d, %d\n', pointer, points(1,pointer), points(2,pointer));
            img(points(2,pointer), points(1,pointer)) = 30;
            pointer = pointer + 1;
        else
            break
        end
    end
    
    % printing sweep line
    img_t(i, :) = zeros(fieldSize,1);
    image(img_t);
    pause(1/10)
end
image(img);







