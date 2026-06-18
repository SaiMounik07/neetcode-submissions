class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

    for (int[] point : points) {
        int dist = point[0] * point[0] + point[1] * point[1];

        pq.offer(new int[]{dist, point[0], point[1]});

        if (pq.size() > k) {
            pq.poll();
        }
    }

    int[][] result = new int[k][2];

    for (int i = 0; i < k; i++) {
        int[] curr = pq.poll();
        result[i][0] = curr[1];
        result[i][1] = curr[2];
    }

    return result;
}
}
