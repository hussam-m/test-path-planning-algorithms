package Graph;

import java.awt.Color;

/**
 *
 * @author hussam
 */
public class Node implements Comparable<Node> {
    public int x,y;
    public boolean empty=true;
    public boolean marked=false;
    public Node previousNode;
    public double distanceFromStart;
    public double distanceToEnd;
    public  Color color = null;
    
    public Node(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    @Override
    public int compareTo(Node n) {
	double thisTotalDistanceFromGoal = (this.distanceToEnd+this.distanceFromStart);
	double otherTotalDistanceFromGoal = (n.distanceToEnd+n.distanceFromStart);
            
        if (thisTotalDistanceFromGoal < otherTotalDistanceFromGoal) {
                return -1;
        } else if (thisTotalDistanceFromGoal > otherTotalDistanceFromGoal) {
                return 1;
        } else {
                return 0;
        }
    }
}
