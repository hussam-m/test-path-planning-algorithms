package Algorithm;

import Graph.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author hussam
 */
public class AStar extends Algorithm {

    Distance.Type distanceType;
    public AStar(Distance.Type distanceType)
    {
        super();
        this.distanceType = distanceType;
    }
    @Override
    public Node[] run(Node start, Node goal, Graph graph) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("AStar running");
        //Set<Node> open = new LinkedHashSet<Node>();
        //Set<Node> closed = new LinkedHashSet<Node>();
        
        PriorityQueue<Node> frontier = new PriorityQueue<Node>();
        
        
        frontier.add(start);
        start.distanceFromStart=0;
        graph.marke(start);
        Node current;
        while( !frontier.isEmpty())
        {
            
            current = frontier.poll();
            
            if(current.equals(goal))
            {
                // create the path
                System.out.println("create path");
                List<Node> path = new ArrayList<Node>();
                do
                {
                        path.add(current);
                        current = current.previousNode;
                }
                while(current!=null);
                return path.toArray(new Node[path.size()]);
            }
            
            for(Node node: graph.neighbours(current))
            {
                if(node.empty)
                    if(!node.marked)
                    {
                        graph.marke(node);
                        node.distanceFromStart = current.distanceFromStart+1;
                        if(distanceType==Distance.Type.Diagonal)
                            node.distanceToEnd = Distance.Diagonal(node, goal);
                        if(distanceType==Distance.Type.Euclidean)
                            node.distanceToEnd = Distance.Euclidean(node, goal);
                        if(distanceType==Distance.Type.Manhattan)
                            node.distanceToEnd = Distance.Manhattan(node, goal);
                        node.previousNode=current;
                        frontier.add(node);
                    }
                    else if((frontier.contains(node)) &&  node.distanceFromStart<current.previousNode.distanceFromStart)
                    {
                        current.previousNode = node;
                        current.distanceFromStart = node.distanceFromStart+1;
                        //frontier.add(node);
                        
                    }
            }  
        }
        
        return null;
    }

    void sort(List<Node> nodes) {
        for (int i = nodes.size() - 1; i > 0 && nodes.get(i).compareTo(nodes.get(i - 1)) < 0; i--) {
            Collections.swap(nodes, i, i - 1);
        }
    }

}
