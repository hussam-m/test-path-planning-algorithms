package GUI;

import Graph.Graph;
import Graph.Node;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author hussam
 */
public class ImageJPanel extends javax.swing.JPanel {

    Point start=new Point();
    Point end=new Point();
    public Graph graph;
    public Node [] path;
    
    
    /**
     * Creates new form ImageJPanel
     */
    public ImageJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    		@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
                    if(graph==null) return;
	            Graphics2D gg = (Graphics2D) g;
//	            gg.setColor(Color.BLUE);
//	            gg.fillRect(10, 10, 200, 200);
	            //gg.setComposite(AlphaComposite.SrcOver);
                    //gg.setColor(Color.BLACK);
//	            gg.drawRect(50, 50, 100, 100);
	            
                    // Draw the all the nodes in the graph
	            for(int i=0; i < graph.hieght; i++)
	            	for(int j=0; j<graph.width; j++)
	            	{
	            		
                            gg.setColor(Color.BLACK);
                            if(graph.isEmpty(i, j))
                                gg.drawRect(i*10, j*10, 10, 10);
                            else
                                gg.fillRect(i*10, j*10, 10, 10);
	            		
                            if(graph.isMarked(i, j))
                            {
                                gg.setColor(new Color(255, 0, 255, 100));
	            		gg.fillRect(i*10, j*10, 10, 10);
                                gg.setColor(Color.BLACK);
                            }
                            
                            if(graph.getNode(i, j).color!=null)
                            {
                                gg.setColor(graph.getNode(i, j).color);
                                gg.fillRect(i*10, j*10, 10, 10);
                            }
                            
	            	}
	            		
	            
	            
	            // Draw the path
                    if(path != null)
                    {
                        //System.out.println("path="+path.length);
                        gg.setColor(new Color(0, 255, 255, 150));
                        for(Node node:path)
                            gg.fillRect(node.x*10, node.y*10, 10, 10);
                    }
                    
                    
                    // draw the start and the goal nodes
                    gg.setColor(Color.BLUE);
	            gg.fillRect(start.x*10, start.y*10, 10, 10);
	            gg.setColor(Color.RED);
	            gg.fillRect(end.x*10, end.y*10, 10, 10);
	            
	        
	    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
