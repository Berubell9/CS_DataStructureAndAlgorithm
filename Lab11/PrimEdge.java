package Lab10;

class PrimEdge {
    private int u;
    private int v;
    private int weight;

    PrimEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.weight = w;;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        String s = u + " " + v + " " + weight;
        return s;
    }
}