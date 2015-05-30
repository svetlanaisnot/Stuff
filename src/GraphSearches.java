import java.util.ArrayList;
import java.util.List;

/**
 * Created by svetlana on 28/09/14.
 */
public class GraphSearches {

    public static void main(String[] args) {
        Vertex start = new Vertex(1);

        Vertex v10 = new Vertex(10);
        Vertex v11 = new Vertex(11);


        start.adjancies.add(v10);
        start.adjancies.add(v11);

        v11.adjancies.add(start);

        Vertex v20 = new Vertex(20);
        Vertex v201 = new Vertex(201);
        start.adjancies.add(v20);
        v20.adjancies.add(v201);

        Vertex v101 = new Vertex(101);
        v10.adjancies.add(v101);
        Vertex v110 = new Vertex(110);
        v11.adjancies.add(v110);

        System.out.println(bfsRecursive(201, start));


    }

    public static Vertex bfsRecursive(int value, Vertex start) {
        System.out.println("Analysing vertex with value " + start.value);
        if (start.value == value) {
            start.visited = true;
            return start;
        }

        for (Vertex adjVertex : start.adjancies) {
            if (!adjVertex.visited) {
                adjVertex.visited = true;
                System.out.println("Analysing vertex with value " + adjVertex.value);
                if (adjVertex.value == value) {
                    return adjVertex;
                }
            }
        }

        for (Vertex adjVertex : start.adjancies) {
            Vertex vertex = bfsRecursive(value, adjVertex);
            if (vertex != null) {
                return vertex;
            }
        }

        return null;
    }

    public static Vertex bfsNonRecursive(int value, Vertex start) {
        Queue<Vertex> vertexQueue = new Queue<Vertex>();

        vertexQueue.push(start);

        while (!vertexQueue.isEmpty()) {
            Vertex currentVertex = vertexQueue.pop();
            System.out.println("Analysing vertex with value " + currentVertex.value);
            if (currentVertex.value == value) {
                return currentVertex;
            } else {
                currentVertex.visited = true;
                for (Vertex adjVertex : currentVertex.adjancies) {
                    if (!adjVertex.visited) {
                        vertexQueue.push(adjVertex);
                    }
                }
            }
        }
        return null;
    }


    public static Vertex DFSRecursion(int value, Vertex start) {
        System.out.println("Analysing vertex with value " + start.value);
        if (start.value == value) {
            start.visited = true;
            return start;
        }

        for (Vertex adjVertex : start.adjancies) {
            if (!adjVertex.visited) {
                adjVertex.visited = true;
                Vertex vertex = DFSRecursion(value, adjVertex);
                if (vertex != null) {
                    return vertex;
                }
            }
        }

        return null;
    }

    public static Vertex DFSNonRecursial(int value, Vertex start) {

        Stack<GraphSearches.Vertex> vertexes = new Stack<Vertex>();

        vertexes.push(start);
        while (!vertexes.isEmpty()) {
            Vertex vertex = vertexes.pop();
            System.out.println("Analysing vertex with value " + vertex.value);
            if (vertex.value == value) {
                return vertex;
            } else {
                vertex.visited = true;
                for (Vertex adjVertexes : vertex.adjancies) {
                    if (!adjVertexes.visited) {
                        vertexes.push(adjVertexes);
                    }
                }
            }
        }

        return null;
    }


    static class Vertex{
        int value;
        boolean visited;

        List<Vertex> adjancies = new ArrayList<Vertex>();

        Vertex(int val) {
            this.value = val;
        }

        public String toString() {
            return "Vertex is " + value;
        }
    }
}
