package Task6;

public class Vertex {
    private int x;
    private int y;
    public boolean isVisited = false;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vertex (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
