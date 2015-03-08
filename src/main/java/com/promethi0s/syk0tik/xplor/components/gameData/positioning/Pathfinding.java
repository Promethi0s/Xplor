package com.promethi0s.syk0tik.xplor.components.gameData.positioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Pathfinding {

    protected static int scale;
    private static boolean[] validNodes;
    private static int width;
    private static Comparator<Node> nodeComparator = new Comparator<Node>() {

        @Override
        public int compare(Node n1, Node n2) {

            if (n1.f > n2.f) return 1;
            if (n1.f < n2.f) return -1;
            return 0;
        }

    };

    public static void createValidNodes(int width, int height, int scale) {

        validNodes = new boolean[width * height];
        Arrays.fill(validNodes, true);
        Pathfinding.width = width;
        Pathfinding.scale = scale;

    }

    public static void setInvalidNode(Coordinates loc) {

        int pos = loc.x / scale + loc.y / scale * width;
        validNodes[pos] = false;

    }

    // A* search algorithm; finds path of nodes b
    public static ArrayList<Node> getPath(Coordinates beginning, Coordinates finish) {

        Vector start = new Vector(beginning);
        Vector goal = new Vector(finish);
        ArrayList<Node> closedSet = new ArrayList<Node>();
        ArrayList<Node> openSet = new ArrayList<Node>();
        double distance = getDistance(start, goal);
        Node current = new Node(start, null, 0, distance);
        openSet.add(current);
        while (openSet.size() > 0) {

            Collections.sort(openSet, nodeComparator);
            current = openSet.get(0);
            if (vecInList(openSet, goal)) {

                for (Node n : openSet) {
                    if (n.vec.equals(goal)) current = n;
                }
                ArrayList<Node> path = new ArrayList<Node>();

                while (current.parent != null) {

                    path.add(current);
                    current = current.parent;

                }

                closedSet.clear();
                return path;

            }

            openSet.remove(current);
            closedSet.add(current);

            for (int i = 0; i < 9; i++) {

                if (i % 2 == 0) continue;
                int x = current.vec.x + ((i % 3) - 1);
                int y = current.vec.y + ((i / 3) - 1);

                if (validNode(x, y)) {

                    Vector vec = new Vector(x, y);
                    double g = current.g + getDistance(current.vec, vec);
                    double h = getDistance(vec, goal);
                    Node node = new Node(vec, current, g, h);
                    if (vecInList(closedSet, vec) && g >= node.g) continue;
                    if (!vecInList(openSet, vec) || g < node.g) openSet.add(node);

                }
            }
        }

        closedSet.clear();
        return null;

    }

    private static boolean vecInList(ArrayList<Node> list, Vector vec) {

        for (Node n : list) {
            if (n.vec.equals(vec)) return true;
        }

        return false;
    }

    private static double getDistance(Vector start, Vector goal) {

        double dX = start.x - goal.x;
        double dy = start.y - goal.y;
        return Math.sqrt(dX * dX + dy * dy);

    }


    private static boolean validNode(int x, int y) {

        int loc = x + y * width;
        if (loc >= 0 && loc < validNodes.length) return validNodes[loc];
        return false;

    }

}
