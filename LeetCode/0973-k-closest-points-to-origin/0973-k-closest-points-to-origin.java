class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        int[][] answer = new int[k][2];
        
        for (int[] point : points) pq.offer(new Point(point));
        
        for (int i = 0; i < k; i++) answer[i] = pq.poll().coordinates;
        
        return answer;
    }
    
    static class Point {
        
        int[] coordinates;
        int distance;
        
        Point(int[] coordinates) {
            this.coordinates = coordinates;
            int x = coordinates[0];
            int y = coordinates[1];
            distance = x * x + y * y;
        }
        
    }
}