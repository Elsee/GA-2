function r = radiationCalc(x1,y1)
    
    x_line(1,:) = ((1:700) - x1) .^ 2;
    x = repmat(x_line,700,1);
    x = x';

    y_line(1,:) = ((1:700) - y1) .^ 2;
    y = repmat(y_line,700,1);

    %     d = sqrt((x2-x1)^2 + (y-y1)^2);
    %     r = (10^5) / (d^2);

    d = x+y;
    r = (10^5) ./ d;

end

 