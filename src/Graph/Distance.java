package Graph;

/**
 *
 * @author hussam
 */
public class Distance {

    public enum Type {

        Manhattan, Euclidean, Diagonal
    }

    public static int Manhattan(Node from, Node to) {
        int dx = Math.abs(from.x - to.x);
        int dy = Math.abs(from.y - to.y);
        return dx + dy;
    }

    public static int Euclidean(Node from, Node to) {
        int dx = from.x - to.x;
        int dy = from.y - to.y;
        return (int) Math.sqrt((dx * dx) + (dy * dy));
    }

    final static double D2 = Math.sqrt(2);
    final static int D = 1;

    public static double Diagonal(Node from, Node to) {
        int dx = Math.abs(from.x - to.x);
        int dy = Math.abs(from.y - to.y);
        return D * (dx + dy) + (D2 - 2 * D) * Math.min(dx, dy);
    }
}
