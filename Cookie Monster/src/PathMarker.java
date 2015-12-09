
/* Use this class to represent the current "position" of a path.
 * Why do we only need row, col and total? */

public class PathMarker implements Comparable<PathMarker> {
    public int row;
    public int col;
    public int total;

    public PathMarker(int r, int c, int t) {
        row = r;
        col = c;
        total = t;
    }

    /* Comparable */
    public int compareTo(PathMarker other) {
        return this.total - other.total;
    }
}
