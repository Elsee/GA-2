clc
clear all;
close all;

t_size = 18;

% dist(1,1,2,2)

figure
plot(0,0, 'o');


for i = 0:t_size
    start_point = [0,i];
    x = (-10:1:10);
    y = x.^2 + start_point(2)/2;
    start_point_x(1:length(x)) = start_point(1);
    start_point_y(1:length(x)) = start_point(2);
    z = zeros(1,length(x));
    dist(start_point_x,start_point_y,x,y,x,z);
%     plot(start_point, 'o');
    plot(start_point(1),start_point(2), 'o');
    hold on;
    plot(x,y);
    hold off;
    pause(1/10);
end



% import java.util.LinkedList
% q = LinkedList();
% q.add('item1');
% q.add(2);
% q.add([3 3 3]);
% item = q.remove()
% item = q.remove()
% item = q.remove()
% 
% q.add('item4');

% import java.util.PriorityQueue
% pq = PriorityQueue(10);
% pq.add([1,4]);
% pq.add([2,4]);
% % pq.add(2);
% % pq.add(6);
% pq.remove
% % pq.add({'text1',5});
% % pq.add({'text2',2});



