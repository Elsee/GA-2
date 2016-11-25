clc;
clear all;
close all;

% read from file
inputMap = imread('map.png');
inputMap = rgb2gray(inputMap);
colorsAtImage = unique(inputMap);
[rowSize, columnSize] = size(inputMap);

% figure images with different colors
test_images(1:length(colorsAtImage-1), 1:rowSize, 1:columnSize) = 0;
for c = 1:length(colorsAtImage)
    for i = 1:rowSize
        for j = 1:columnSize
            if inputMap(i,j) == colorsAtImage(c)
                test_images(c,i,j) = 1;
%                 test_images(c,i,j) = colorsAtImage(c);
            end
        end
    end
    img(:,:) = reshape(test_images(c,:,:),[rowSize columnSize]);
    figure
    imshow(img)
end

% start and finish points
[st_x, st_y] = find(reshape(test_images(2,:,:), [rowSize columnSize]) == 1);
[fin_x, fin_y] = find(reshape(test_images(3,:,:), [rowSize columnSize]) == 1);

% spaceMap - where we can go
spaceMap = reshape((test_images(5,:,:) + test_images(2,:,:) + test_images(3,:,:)),[rowSize columnSize]);

% radiationMap - map of radiation sources
radiationMap = reshape(test_images(4,:,:),[rowSize columnSize]);

% printing Maps
figure
imshow(spaceMap)
figure
imshow(radiationMap)

% compution radiation at each point
radiation = zeros(rowSize, columnSize);
parfor i = 1: rowSize 
    for j = 1: columnSize
        if radiationMap(i,j) > 0
            radiation = radiation + radiationCalc(i,j);
        end
    end
i
end



