package com.liucalvin.boggle.solver;

import com.liucalvin.boggle.entity.Board;

import java.util.HashSet;
import java.util.Set;

public class Solver {

    private final TernarySearchTree<Integer> dictionary;
    private Set<String> words;

    public Solver(String[] dictionary) {
        this.dictionary = new TernarySearchTree<>();
        for (int i = 0; i < dictionary.length; i++) {
            this.dictionary.put(dictionary[i], i);
        }
    }

    public Iterable<String> getAllValidWords(Board board) {

        // dfs
        words = new HashSet<>();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                boolean[][] marked = new boolean[board.getRows()][board.getCols()];
                // Node current = new Node(board.getLetter(i, j));
                // String current = String.valueOf(board.getLetter(i, j));
                getWords(board, i, j, "", marked);
                // search(board, digraph, i, j, marked);
            }
        }
        return words;
    }

    private boolean getWords(Board board, int i, int j, String word,
                             boolean[][] marked) {
        String current = word;
        if (i < 0 || j < 0 || i >= board.getRows() || j >= board.getCols()) {
            // outside of board, do not unmark
            return false;
        }

        if (marked[i][j]) {
            // already reached, do not unmark
            return false;
        }

        // special case for 'Q'
        char c = board.letterAt(i, j);
        if (c == 'Q') {
            current += "QU";
        } else {
            current += c;
        }

        // System.out.println("Current: " + current);
        marked[i][j] = true;
        // System.out.println(Arrays.deepToString(marked));

        if (dictionary.contains(current) && current.length() >= 3) {
            words.add(current);
        }

        if (!dictionary.containsPrefix(current)) {
            return true;
        }

        // recursively search all 8 neighbouring tiles
        if (getWords(board, i + 1, j + 1, current, marked)) marked[i + 1][j + 1] = false;
        if (getWords(board, i + 1, j, current, marked)) marked[i + 1][j] = false;
        if (getWords(board, i + 1, j - 1, current, marked)) marked[i + 1][j - 1] = false;
        if (getWords(board, i, j + 1, current, marked)) marked[i][j + 1] = false;
        if (getWords(board, i, j, current, marked)) marked[i][j] = false;
        if (getWords(board, i, j - 1, current, marked)) marked[i][j - 1] = false;
        if (getWords(board, i - 1, j + 1, current, marked)) marked[i - 1][j + 1] = false;
        if (getWords(board, i - 1, j, current, marked)) marked[i - 1][j] = false;
        if (getWords(board, i - 1, j - 1, current, marked)) marked[i - 1][j - 1] = false;

        // there are possible valid words but none to be found, unmark for other paths
        return true;
    }

    private Iterable<String> lastSavedWords() {
        return words;
    }

    // returns the score if in dictionary, according to Boggle scoring rules
    public int scoreOf(String word) {

        if (!dictionary.contains(word)) {
            return 0;
        }

        int n = word.length();
        if (n < 3) {
            return 0;
        }
        switch (n) {
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            default:
                return 11;
        }
    }

    public static void main(String[] args) {
//
//        // Board boggleBoard = new Board("board4x4.txt");
//        Board boggleBoard = new Board("board-q.txt");
//        // Board boggleBoard = new Board("board-antidisestablishmentarianisms.txt");
//        System.out.println(boggleBoard.toString());
//        // BoggleSolver solver = new BoggleSolver(new In("dictionary-algs4.txt").readAllStrings());
//        BoggleSolver solver = new BoggleSolver(new In("dictionary-yawl.txt").readAllStrings());
//        Iterable<String> words = solver.getAllValidWords(boggleBoard);
//        words.forEach(System.out::println);
//
//        // TST<Integer> tst = new TST<>();
//        // for (int i = 0; i < dictionary.length; i++) {
//        //     tst.put(dictionary[i], i);
//        // }
//        // Iterable<String> tstSet = tst.keysThatMatch("A..");
//        // tstSet.forEach(System.out::println);
//
//        // boolean test = solver.dictionary.containsPrefix("YE");
//        // System.out.println(test);
//        // System.out.println(solver.dictionary.get("YET"));
    }
}

