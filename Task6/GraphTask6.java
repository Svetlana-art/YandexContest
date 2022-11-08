package Task6;

import java.util.Arrays;

public class GraphTask6 {
    VertexTask6[] vertexList;
    private int curN;
    private int[][] matrix;
    private Queue queue = new Queue();

    public GraphTask6(int maxN) {
        vertexList = new VertexTask6[maxN];
        matrix = new int[maxN][maxN];
        curN = 0;
    }

    public void addVertex(int x, int y) {
        vertexList[curN] = new VertexTask6(x,y);
        curN++;
    }

    public double distance (VertexTask6 a, VertexTask6 b) {
        return Math.sqrt((b.getX() - a.getX())*(b.getX() - a.getX()) + (b.getY() - a.getY())*(b.getY() - a.getY()));
        //return Math.abs(b.getX() - a.getX()) + Math.abs(b.getY() - a.getY());
        //return Point2D.distance(a.getX(), a.getY(), b.getX(), b.getY());
    }

    public void addEdge(int maxN, int k) {

        for (int i = 0; i < maxN; i++) {
            for (int j = 0; j < maxN; j++) {
                double distance = distance(vertexList[i],vertexList[j]);
                if ((distance <= k) && (distance != 0)){
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                } else {
                    matrix[i][j] = 0;
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public int check(int v) {
        for (int i = 0; i < curN; i++) {
            if ( matrix[v][i] == 1 && vertexList[i].isVisited == false) {
                return i;
            }
        }
        return -1;
    }

    public int[] passInWidht(int start) {
        vertexList[start].isVisited = true;
        queue.add(start);
        int[] distances = new int[vertexList.length];
        Arrays.fill(distances, -1);
        distances[start] = 0;

        int vertex;
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            while ((vertex = check(temp)) != -1) {
                vertexList[vertex].isVisited = true;
                distances[vertex] = distances[temp] + 1;
                queue.add(vertex);
            }
        }
        for (int i = 0; i < curN; i++) {
            vertexList[i].isVisited = false;
        }
        return distances;
    }
}
