function d = distanceCalc(x1,y1,size)
    
    x_line(1,:) = ((1:size) - x1) .^ 2;
    x = repmat(x_line,size,1);
    x = x';

    y_line(1,:) = ((1:size) - y1) .^ 2;
    y = repmat(y_line,size,1);

    %     d = sqrt((x2-x1)^2 + (y-y1)^2);
    %     r = (10^5) / (d^2);

    d = x+y;
%     r = (10^5) ./ d;

end

 