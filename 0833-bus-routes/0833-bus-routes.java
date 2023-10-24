class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(i);
            }
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        boolean[] seen_routes = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;

        // Initialize the queue with routes that have the source stop.
        for (int route : stopToRoutes.get(source)) {
            seen_routes[route] = true;
            queue.offer(route);
            visitedRoutes.add(route);
        }

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentRoute = queue.poll();
                for (int nextStop : routes[currentRoute]) {
                    if (nextStop == target) return level;  // Found the target.
                    for (int nextRoute : stopToRoutes.get(nextStop)) {
                        if (!visitedRoutes.contains(nextRoute) && !seen_routes[nextRoute]) {
                            visitedRoutes.add(nextRoute);
                            queue.offer(nextRoute);
                        }
                    }
                }
            }
        }
        return -1;
    }
}