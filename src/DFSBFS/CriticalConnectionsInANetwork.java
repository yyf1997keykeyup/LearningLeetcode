package DFSBFS;

import java.util.*;

/**
 * From: https://leetcode.com/problems/critical-connections-in-a-network/
 * Refer to: https://leetcode.com/problems/critical-connections-in-a-network/discuss/382638/DFS-detailed-explanation-O(orEor)-solution
 * 1192. Critical Connections in a Network (Hard)
 */
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        Set<List<Integer>> connectionsSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, connectionsSet);
        return new ArrayList<>(connectionsSet);
    }

    private int dfs(List<Integer>[] graph, int node, int depth, int[] rank, Set<List<Integer>> connectionsSet) {
        // already visited node. return its rank
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int minDepthFound = depth; // can be Integer.MAX_VALUE also
        for (Integer neighbor : graph[node]) {
            // ignore the parent
            if (rank[neighbor] == depth - 1) {
                continue;
            }
            int minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet);
            minDepthFound = Math.min(minDepthFound, minDepth);
            if (minDepth <= depth) {
                // remove both combinations of (x,y) and (y,x)
                connectionsSet.remove(Arrays.asList(node, neighbor));
                connectionsSet.remove(Arrays.asList(neighbor, node));
            }
        }
        return minDepthFound;
    }
}
