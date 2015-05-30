import java.util.*;

/**
 * Created by svetlana on 27/09/14.
 */
public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("v0");
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v0.adjacencies = new Edge[]{new Edge(v1, 5),
                new Edge(v2, 10),
                new Edge(v3, 8)};
        v1.adjacencies = new Edge[]{new Edge(v0, 5),
                new Edge(v2, 3),
                new Edge(v4, 7)};
        v2.adjacencies = new Edge[]{new Edge(v0, 10),
                new Edge(v1, 3)};
        v3.adjacencies = new Edge[]{new Edge(v0, 8),
                new Edge(v4, 2)};
        v4.adjacencies = new Edge[]{new Edge(v1, 7),
                new Edge(v3, 2)};
        Vertex[] vertices = {v0, v1, v2, v3, v4};
        computePaths(v0);
        for (Vertex v : vertices) {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<Vertex> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
    }

    public static void computePaths(Vertex source) {
        source.minDistance = 0.0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            //visit each edge exiting from u
            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }


    static class Vertex implements Comparable<Vertex> {
        public final String name;
        public Edge[] adjacencies;
        public double minDistance = Double.POSITIVE_INFINITY;
        public Vertex previous;

        public Vertex(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        @Override
        public int compareTo(Vertex o) {
            return Double.compare(minDistance, o.minDistance);
        }
    }

    static class Edge {
        public Vertex target;
        public final double weight;

        public Edge(Vertex target, double weight) {
            this.target = target;
            this.weight = weight;
        }

    }
}
