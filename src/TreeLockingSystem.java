import java.util.*;
import java.io.*;

public class TreeLockingSystem {

    static class TreeNode {
        String name;
        TreeNode parent;
        List<TreeNode> children;
        int lockedBy;  // 0 means unlocked, otherwise stores user id
        int lockedDescendantCount;  // count of locked descendants

        TreeNode(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.lockedBy = 0;
            this.lockedDescendantCount = 0;
        }
    }

    private Map<String, TreeNode> nodeMap;

    public TreeLockingSystem() {
        nodeMap = new HashMap<>();
    }

    // Build the tree from input
    public void buildTree(String[] nodeNames, int m) {

        for (String name : nodeNames) {
            nodeMap.put(name, new TreeNode(name));
        }

        for (int i = 0; i < nodeNames.length; i++) {
            TreeNode current = nodeMap.get(nodeNames[i]);

            // Set parent (except for root)
            if (i > 0) {
                int parentIndex = (i - 1) / m;
                TreeNode parent = nodeMap.get(nodeNames[parentIndex]);
                current.parent = parent;
                parent.children.add(current);
            }
        }
    }

    private boolean hasLockedAncestor(TreeNode node) {
        TreeNode current = node.parent;
        while (current != null) {
            if (current.lockedBy != 0) {
                return true;
            }
            current = current.parent;
        }
        return false;
    }

    // Check if any descendant is locked
    private boolean hasLockedDescendant(TreeNode node) {
        return node.lockedDescendantCount > 0;
    }

    private void updateAncestorCounts(TreeNode node, int delta) {
        TreeNode current = node.parent;
        while (current != null) {
            current.lockedDescendantCount += delta;
            current = current.parent;
        }
    }

    private boolean allDescendantsLockedBySameUser(TreeNode node, int userId) {
        if (node.lockedBy != 0) {
            return node.lockedBy == userId;
        }

        for (TreeNode child : node.children) {
            if (!allDescendantsLockedBySameUser(child, userId)) {
                return false;
            }
        }
        return true;
    }

    private void unlockAllDescendants(TreeNode node) {
        if (node.lockedBy != 0) {
            node.lockedBy = 0;
        }

        for (TreeNode child : node.children) {
            unlockAllDescendants(child);
        }
    }

    public boolean lock(String nodeName, int userId) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;

        if (node.lockedBy != 0) {
            return false;
        }

        if (hasLockedAncestor(node)) {
            return false;
        }

        if (hasLockedDescendant(node)) {
            return false;
        }

        // Lock the node
        node.lockedBy = userId;
        updateAncestorCounts(node, 1);
        return true;
    }

    public boolean unlock(String nodeName, int userId) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;

        if (node.lockedBy != userId) {
            return false;
        }

        node.lockedBy = 0;
        updateAncestorCounts(node, -1);
        return true;
    }

    public boolean upgradeLock(String nodeName, int userId) {
        TreeNode node = nodeMap.get(nodeName);
        if (node == null) return false;

        // Check if node is already locked
        if (node.lockedBy != 0) {
            return false;
        }

        if (node.lockedDescendantCount == 0) {
            return false;
        }

        if (hasLockedAncestor(node)) {
            return false;
        }

        if (!allDescendantsLockedBySameUser(node, userId)) {
            return false;
        }

        unlockAllDescendants(node);
        node.lockedBy = userId;

        updateAncestorCounts(node, 1 - node.lockedDescendantCount);
        node.lockedDescendantCount = 0;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        int q = Integer.parseInt(br.readLine().trim());

        String[] nodeNames = new String[n];
        for (int i = 0; i < n; i++) {
            nodeNames[i] = br.readLine().trim();
        }

        TreeLockingSystem system = new TreeLockingSystem();
        system.buildTree(nodeNames, m);

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().trim().split(" ");
            int operationType = Integer.parseInt(query[0]);
            String nodeName = query[1];
            int userId = Integer.parseInt(query[2]);

            boolean result = false;
            switch (operationType) {
                case 1:
                    result = system.lock(nodeName, userId);
                    break;
                case 2:
                    result = system.unlock(nodeName, userId);
                    break;
                case 3:
                    result = system.upgradeLock(nodeName, userId);
                    break;
            }

            System.out.println(result ? "true" : "false");
        }
    }
}