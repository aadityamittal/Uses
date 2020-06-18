import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
class generator{
    Random r = new Random();
    public Shape randomShape(){
        switch(r.nextInt(10)) {
          default:
          case 0: return new Line2D.Double(r.nextInt(1000),r.nextInt(2000),r.nextInt(1000),r.nextInt(2000));
          case 1: return new Rectangle2D.Double(r.nextInt(3000),r.nextInt(2500),r.nextInt(3000),r.nextInt(2500));
          case 2: return new Ellipse2D.Double(r.nextInt(1000),r.nextInt(2000),r.nextInt(1000),r.nextInt(2000));
         }
    }
}
class component extends JComponent{
  public void paintComponent(Graphics g){
      Graphics2D g2d = (Graphics2D) g;
      generator g1 = new generator();
      Random r = new Random();
      for(int i=1;i<r.nextInt(100);i++)
         g2d.draw(g1.randomShape());
   }
}
public class viewer{
	   public static void main(String[] args){
	      JFrame jf = new JFrame();
	      final int fw=1366;
	      final int fh=768;
	      jf.setSize(fw,fh);
	      jf.setTitle("Shape Viewer");
	      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      component c = new component();
	      jf.add(c);
	      jf.setVisible(true);
	}
}
