package Graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hussam
 */
public class Graph {
    public int hieght, width;
    Node [] [] matrix;
    //public ArrayList<Node> marked = new ArrayList<Node>();
    public Set<Node> marked = new LinkedHashSet<Node>();
    
    public Graph(int hieght,int width){
        this.hieght=hieght;
        this.width=width;
        
        matrix = new Node [hieght] [];
        for(int h=0; h<hieght;h++)
        {
            matrix[h] = new Node [width];
            for(int w=0; w<width;w++)
                matrix[h][w] = new Node(h,w);
        }
    }
    
    public void marke(int x, int y)
    {
        marked.add(matrix[x][y]);
    }
    public void marke(Node node)
    {
        marked.add(node);
        node.marked = true;
    }
    public void resetMarked()
    {
        marked.clear();
    }
    public Node getNode(int x,int y)
    {
        return matrix[x][y];
    }
    public boolean isMarked(int x, int y)
    {
        return matrix[x][y].marked;
    }
    public boolean isEmpty(int x, int y)
    {
        return matrix[x][y].empty;
    }
    public void reset()
    {
        //System.out.println("Graph size:"+width+","+hieght);
        for(int i=0;i<hieght;i++)
            for(int j=0;j<width;j++)
            {
                    //Node o = new Node(i,j,null);
                //System.out.println(i+","+j);
                //System.out.println("Graph reset:"+i+","+j);
                matrix[i][j].distanceFromStart=0;
                matrix[i][j].distanceToEnd=0;
                matrix[i][j].previousNode=null;
                matrix[i][j].marked=false;
            }
    }
    public void empty()
    {
        for(int i=0;i<width;i++)
            for(int j=0;j<hieght;j++)
                matrix[i][j].empty=true;
    }
    
    public List<Node> neighbours(Node node)
    {
        List<Node> n = new ArrayList<Node>();
            
//        if(node.x+1<width && node.y+1<hieght)
//                n.add( matrix[node.x+1][node.y+1]);
        if(node.x+1<width)
                n.add( matrix[node.x+1][node.y]);
        if(node.y+1<hieght)
                n.add( matrix[node.x][node.y+1]);

        if(node.x-1>=0)
                n.add( matrix[node.x-1][node.y]);
        if(node.y-1>=0)
                n.add( matrix[node.x][node.y-1]);
//        if(node.x-1>=0 && node.y-1>=0)
//                n.add( matrix[node.x-1][node.y-1]);

//        if(node.x+1<width && node.y-1>=0)
//                n.add( matrix[node.x+1][node.y-1]);
//        if(node.x-1>=0 && node.y+1<hieght)
//                n.add( matrix[node.x-1][node.y+1]);
        
        
        return n;
    }
    
    
}
