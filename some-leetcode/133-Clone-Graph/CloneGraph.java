
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// dfs version
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(cloneNode.label, cloneNode);
        
        for (UndirectedGraphNode nei : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(nei));
        }

        return cloneNode;
    }
}

// rewrote one loop version, BFS
// public class Solution {
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null) {
//             return node;
//         }
        
//         HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
//         Queue<UndirectedGraphNode> queue = new LinkedList<>();
//         // traverse the graph for once to create all needed new nodes and copy th neighbors list
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode cur = queue.poll();
//             // get the new node
//             UndirectedGraphNode newNode;
//             if (!map.containsKey(cur.label)) {
//                 newNode = new UndirectedGraphNode(cur.label);
//                 map.put(newNode.label, newNode);
//             }
//             else {
//                 newNode = map.get(cur.label);
//             }
            
//             // if the newNode's neighbors list is empty, means not yet be visited
//             if (newNode.neighbors.isEmpty()) {
//                 // scan the neighbors list and offer uncopy nodes into queue
//                 for (UndirectedGraphNode nei : cur.neighbors) {
//                     UndirectedGraphNode newNei;
//                     if (!map.containsKey(nei.label)) {
//                         // create a new node
//                         newNei = new UndirectedGraphNode(nei.label);
//                         map.put(newNei.label, newNei);
//                         queue.offer(nei);
//                     }
//                     else {
//                         newNei = map.get(nei.label);
//                     }
//                     newNode.neighbors.add(newNei);
//                 }
//             }
//         }

//         return map.get(node.label);
//     }
// }

// public class Solution {
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null) {
//             return null;
//         }
        
//         // queue to do BFS traversal
//         Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
//         // HashMap used as visited bits and save the new nodes
//         HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
//         // clone the root
//         UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
//         // put newRoot into map
//         map.put(newRoot.label, newRoot);
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode originalNode = queue.poll();
//             UndirectedGraphNode cloneNode = map.get(originalNode.label);
            
//             for (int i = 0; i < originalNode.neighbors.size(); ++i) {
//                 UndirectedGraphNode originalNei = originalNode.neighbors.get(i);
//                 UndirectedGraphNode cloneNei;
//                 // clone this neighbors if necessary
//                 if (!map.containsKey(originalNei.label)) {
//                     cloneNei = new UndirectedGraphNode(originalNei.label);
//                     map.put(originalNei.label, cloneNei);
//                     // add the none finished node into queue
//                     queue.offer(originalNei);
//                 }
//                 else {
//                     cloneNei = map.get(originalNei.label);
//                 }
                
//                 // add this neighbors into neighbor list
//                 cloneNode.neighbors.add(cloneNei);
//             }
//         }
        
//         return newRoot;
//     }
// }


// two loops version
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// public class Solution {
//     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//         if (node == null) {
//             return node;
//         }
        
//         HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
//         Queue<UndirectedGraphNode> queue = new LinkedList<>();
//         // traverse the graph for once to create all needed new nodes
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode cur = queue.poll();
//             // create a new node
//             UndirectedGraphNode newNode = new UndirectedGraphNode(cur.label);
//             map.put(newNode.label, newNode);
//             // scan the neighbors list and offer uncopy nodes into queue
//             for (UndirectedGraphNode nei : cur.neighbors) {
//                 if (!map.containsKey(nei.label)) {
//                     queue.offer(nei);
//                 }
//             }
//         }
        
//         // traverse the graph again to copy the neighbors list
//         queue.offer(node);
//         while (!queue.isEmpty()) {
//             UndirectedGraphNode cur = queue.poll();
//             // copy current node's neighbors list
//             UndirectedGraphNode copyNode = map.get(cur.label);
//             // if the neighbors list is not empty, means visited
//             if (copyNode.neighbors.isEmpty()) {
//                 for (UndirectedGraphNode nei : cur.neighbors) {
//                     copyNode.neighbors.add(map.get(nei.label));
//                     queue.offer(nei);
//                 }
//             }
//         }
        
//         return map.get(node.label);
//     }
// }