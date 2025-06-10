class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // column -> row -> minHeap(values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int row = t.row, col = t.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) queue.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) queue.offer(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty())
                    colList.add(nodes.poll());
            }
            result.add(colList);
        }
        return result;
    }

    class Tuple {
        TreeNode node;
        int row, col;
        Tuple(TreeNode n, int r, int c) { node = n; row = r; col = c; }
    }
}
