package Algorithm;

import Graph.Graph;
import Graph.Node;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hussam
 */
public class ShadowAStar extends Algorithm {

    Color shadowColor = new Color(50, 50, 50, 100);
    
    @Override
    public Node[] run(Node start, Node goal, Graph graph) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //int [][] o = {{20,20},{30,30},{15,8}};
        
        
        
        List<Node> obstacls = new ArrayList<Node>();
        for(int y=0;y<graph.hieght;y++)
            for(int x=0;x<graph.width;x++)
                if(!graph.getNode(x, y).empty)
                    obstacls.add(graph.getNode(x, y));
                else
                    graph.getNode(x, y).color=null;
        
        //List<Integer> xl = new ArrayList<Integer>();
        //List<Integer> yl = new ArrayList<Integer>();
        int i=0;
        for(Node n:obstacls)
        {
            //if(i++>4) break;
            
            //graph.getNode(n[0], n[1]).empty=false;
        for(int x=n.x-1;x>0;x--)
            if(graph.getNode(x, n.y).color!=shadowColor)
                graph.getNode(x, n.y).color = shadowColor;
            else
                break;
        
        for(int x=n.x+1;x<graph.width;x++)
            if(graph.getNode(x, n.y).color!=shadowColor)
                graph.getNode(x, n.y).color = shadowColor;
            else
                break;
        
        for(int y=n.y-1;y>0;y--)
            if(graph.getNode(n.x, y).color != shadowColor)
                graph.getNode(n.x, y).color = shadowColor;
            else   
                break;
        
        for(int y=n.y+1;y<graph.hieght;y++)
            if(graph.getNode(n.x, y).color != shadowColor)
                graph.getNode(n.x, y).color = shadowColor;
            else   
                break;
        }
            
//        graph.getNode(20, 20).empty=false;
//        
//        for(int x=0;x<graph.width;x++)
//            graph.getNode(x, 20).color = shadowColor;
//        
//        for(int y=0;y<graph.hieght;y++)
//            graph.getNode(20, y).color = shadowColor;
        
        return null;
    }
    
}
