class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(i);
            }
        }

        Set<Integer> visitedRoutes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;

        // Initialize the queue with routes that have the source stop.
        for (int route : stopToRoutes.get(source)) {
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
                        if (!visitedRoutes.contains(nextRoute)) {
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