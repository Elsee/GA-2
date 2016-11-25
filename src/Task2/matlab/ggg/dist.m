function [ dist ] = dist(x1,y1,x2,y2,x3,y3)
%DIST Summary of this function goes here
%   Detailed explanation goes here
    dist1 = sqrt((x1-x2).^2 + (y1-y2).^2);
    dist2 = sqrt((x1-x3).^2 + (y1-y3).^2);
    dist2/dist1
    p = polyfit(x2, y2, 2)
end

