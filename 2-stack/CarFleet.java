/**
 * https://neetcode.io/problems/car-fleet/question?list=neetcode150
 * 
 * There are n cars traveling to the same destination on a one-lane highway.
 * You are given two arrays of integers position and speed, both of length n.
 * position[i] is the position of the ith car (in miles) 
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 * 
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 * Return the number of different car fleets that will arrive at the destination.
 * 
 * Constraints:
 * n == position.length == speed.length.
 * 1 <= n <= 1000
 * 0 < target <= 1000
 * 0 < speed[i] <= 100
 * 0 <= position[i] < target
 * All the values of position are unique.
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] a = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            a[i][0] = position[i];
            a[i][1] = speed[i];
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        Deque<Double> dq = new ArrayDeque<>();
        dq.addLast((double) (target - a[0][0]) / a[0][1]);

        for (int i = 1; i < a.length; i++) {
            double t = (double) (target - a[i][0]) / a[i][1];
            while(!dq.isEmpty() && dq.getLast() <= t) dq.removeLast();
            dq.add(t);
        }

        return dq.size();
    }
}