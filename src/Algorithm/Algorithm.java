package Algorithm;

import Graph.Graph;
import Graph.Node;
import java.util.ArrayList;
/**
 *
 * @author hussam
 */
public abstract class Algorithm {
    //Node start,goal;
    String name;
    
    void ini()
    {
        
    }
    
    public Result start(Node start, Node goal, Graph graph)
    {
        Result result=new Result();
        long startTime,endTime;
        
        //ini
        graph.resetMarked();
        graph.reset();
        //
        
        startTime=System.currentTimeMillis();
        result.path=run(start,goal,graph);
        endTime=System.currentTimeMillis();
        
        result.runtime=endTime-startTime;
        result.length=result.path!=null?result.path.length-1:-1;
        result.visted = graph.marked.size();
        
        return result;
    }
    
    public abstract Node [] run(Node start, Node goal,Graph graph);
    
    static public class Result{
        public Node [] path; // set of nodes
        public long runtime; // runtime in ms
        public int visted; // how many node was visited
        public int length; // the length of the path
    }
}
