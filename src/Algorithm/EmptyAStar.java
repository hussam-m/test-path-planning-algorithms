package Algorithm;

import Graph.Graph;
import Graph.Node;
import java.awt.Color;

/**
 *
 * @author hussam
 */
public class EmptyAStar extends Algorithm {

    Color emptyColor = new Color(0,255,0,50);
    @Override
    public Node[] run(Node start, Node goal, Graph graph) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        int size=3;
        while(size<graph.hieght && size<graph.width)
        {
            //for(int i=0;i<)
            size*=2;
        }
        
        return null;
    }
    static class Block
    {
        int size;
        int x;
        int y;
        boolean empty;
        int obstcals=0;
        Block [] children;
        Block(int x,int y, int size,boolean empty)
        {
            if(size>1)
                children= new Block[9];
            this.x=x;
            this.y=y;
            this.size=size;
            this.empty=empty;
        }
    }
}
