package com.liucalvin.boggle.solver;

public class TernarySearchTree<T> {

    private Node root;
    private int n;

    public int size() {
        return n;
    }

    public void put(String key, T value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, T value, int depth) {
        char c = key.charAt(depth);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c) {
            node.left = put(node.left, key, value, depth);
        } else if (c > node.c) {
            node.right = put(node.right, key, value, depth);
        } else if (depth + 1 < key.length()) {
            // if key has more chars to fill, add in middle, and go to next char in key
            node.mid = put(node.mid, key, value, depth + 1);
        } else {
            // end of key reached, put the value
            if (node.value == null) {
                // if value doesn't exist, increment count
                // otherwise just update the value
                n++;
            }
            node.value = value;
        }
        return node;
    }

    public T get(String key) {
        Node node = get(root, key, 0);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node get(Node node, String key, int depth) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(depth);
        if (c < node.c) {
            return get(node.left, key, depth);
        } else if (c > node.c) {
            return get(node.right, key, depth);
        } else if (depth + 1 < key.length()) {
            // key not reached yet but the current char matches
            return get(node.mid, key, depth + 1);
        } else {
            // key matches
            return node;
        }
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public boolean containsPrefix(String prefix) {

        // non-recursive implementation
        Node node = root;
        int depth = 0;
        while (node != null) {
            char c = prefix.charAt(depth);
            if (c < node.c) {
                node = node.left;
            } else if (c > node.c) {
                node = node.right;
            } else if (depth + 1 < prefix.length()) {
                node = node.mid;
                depth++;
            } else {
                return true;
            }
        }
        return false;

        // recursive implementation
        // if (prefix == null || prefix.length() == 0) {
        //     throw new IllegalArgumentException("Prefix cannot be empty");
        // }
        // Node node = get(root, prefix, 0);
        // return node != null;
    }

    private Node search(Node node, String key, int depth) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(depth);
        if (c < node.c) {
            return search(node.left, key, depth);
        } else if (c > node.c) {
            return search(node.right, key, depth);
        } else return node;
    }

    public void clear() {
        root = null;
        n = 0;
    }

    private class Node {
        private Node left, mid, right;
        private char c;
        private T value;
    }

    public static void main(String[] args) {
        TernarySearchTree<Integer> tree = new TernarySearchTree<>();
        String[] strings = {
                "HAT", "HAIR", "BAT", "BEAR", "BEARS", "BEERS",
                "TRAIN", "HELMET", "HELM", "TRADE", "HAPPY"
        };
        for (int i = 0; i < strings.length; i++) {
            tree.put(strings[i], i);
        }
        System.out.println(tree.contains("HAT"));
        System.out.println(tree.contains("HAIR"));
        System.out.println(tree.contains("HELMET"));
        System.out.println(tree.contains("BAT"));
        System.out.println(tree.contains("TRAIN"));
        System.out.println(tree.contains("HELM"));
        System.out.println();
        System.out.println(tree.contains("HIR"));
        System.out.println(tree.contains("HATIR"));
        System.out.println(tree.contains("HBAT"));
        System.out.println(tree.contains("HELME"));
        System.out.println(tree.contains("TRA"));
        System.out.println();
        System.out.println(tree.containsPrefix("H"));
        System.out.println(tree.containsPrefix("HA"));
        System.out.println(tree.containsPrefix("HELME"));
        System.out.println(tree.containsPrefix("HAP"));
        System.out.println(tree.containsPrefix("BEA"));
        System.out.println(tree.containsPrefix("HELMET"));
        System.out.println();
        System.out.println(tree.containsPrefix("HI"));
        System.out.println(tree.containsPrefix("HAE"));
        System.out.println(tree.containsPrefix("TH"));
        System.out.println(tree.containsPrefix("HT"));
    }
}

