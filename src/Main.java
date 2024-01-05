import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    public static void main(String[] args) {
        Main frame = new Main();
        PanelMidpoint panelMidpoint = new PanelMidpoint();
//        Ex4 ex4 = new Ex4();
        Ex5 ex5 = new Ex5();
//        frame.add(panelMidpoint);
//        frame.add(ex4);
        frame.add(ex5);
        frame.setVisible(true);
    }
}
class PanelMidpoint extends JPanel{
    public PanelMidpoint(){
        setSize(500,500);
        setLayout(null);
    }
    public void paint(Graphics g){
        midpointCircle(g,350,350,80);
    }
    void plotQ(Graphics g,int xcenter,int ycenter,int X,int Y){
        g.fillOval(xcenter+X,ycenter+Y,5,5); //Q1
        g.fillOval(xcenter+Y,ycenter+X,5,5); //Q2
        g.fillOval(xcenter+Y,ycenter-X,5,5); //Q3
        g.fillOval(xcenter+X,ycenter-Y,5,5); //Q4
        g.fillOval(xcenter-X,ycenter-Y,5,5); //Q5
        g.fillOval(xcenter-Y,ycenter-X,5,5); //Q6
        g.fillOval(xcenter-Y,ycenter+X,5,5); //Q7
        g.fillOval(xcenter-X,ycenter+Y,5,5); //Q8
    }
    void midpointCircle(Graphics g,int xcenter,int ycenter,int r){
        int X=0;
        int Y=r;
        int PK = 1-r;
        g.setColor(Color.pink);
        plotQ(g,xcenter,ycenter,X,Y);
        while (X<=Y){
            X=X+1;
            if (PK<0){
                PK = PK+2*X+1;
            }else{
                Y=Y-1;
                PK = PK+2*X+1-2*Y;
            }
            plotQ(g,xcenter,ycenter,X,Y);
        }
    }
}

class Ex4 extends JPanel{
    Ex4(){
        setSize(700,700);
        setLayout(null);
    }
    public void paint(Graphics g){
        midpointCircle(g,200,200,140);
    }
    void plotQ(Graphics g,int xcenter,int ycenter,int X,int Y){
//        g.fillOval(xcenter+X,ycenter+Y,5,5); //Q1
//        g.fillOval(xcenter+Y,ycenter+X,5,5); //Q2
        g.fillOval(xcenter+Y,ycenter-X,5,5); //Q3
        g.fillOval(xcenter+X,ycenter-Y,5,5); //Q4
        g.fillOval(xcenter-X,ycenter-Y,5,5); //Q5
        g.fillOval(xcenter-Y,ycenter-X,5,5); //Q6
//        g.fillOval(xcenter-Y,ycenter+X,5,5); //Q7
//        g.fillOval(xcenter-X,ycenter+Y,5,5); //Q8
    }
    void midpointCircle(Graphics g,int xcenter,int ycenter,int r){
        int X=0;
        int Y=r;
        int PK = 1-r;
        g.setColor(Color.pink);
        plotQ(g,xcenter,ycenter,X,Y);
        while (X<=Y){
            X=X+1;
            if (PK<0){
                PK = PK+2*X+1;
            }else{
                Y=Y-1;
                PK = PK+2*X+1-2*Y;
            }
            plotQ(g,xcenter,ycenter,X,Y);
        }
    }
}


class Ex5 extends JPanel{
    Ex5(){
        setSize(700,700);
        setLayout(null);
    }
    public void paint(Graphics g){
        midpointCircle(g,200,200,140);
        drawLine(g,100,100,300,100);
        drawLine(g,-100,100,-300,100);
    }
    void plotQ(Graphics g,int xcenter,int ycenter,int X,int Y){

        g.fillOval(xcenter+X,ycenter+Y,5,5); //Q1
//        g.fillOval(xcenter+Y,ycenter+X,5,5); //Q2
//        g.fillOval(xcenter+Y,ycenter-X,5,5); //Q3
        g.fillOval(xcenter+X,ycenter-Y,5,5); //Q4
        g.fillOval(xcenter-X,ycenter-Y,5,5); //Q5
//        g.fillOval(xcenter-Y,ycenter-X,5,5); //Q6
//        g.fillOval(xcenter-Y,ycenter+X,5,5); //Q7
        g.fillOval(xcenter-X,ycenter+Y,5,5); //Q8
    }
    void midpointCircle(Graphics g,int xcenter,int ycenter,int r){
        int X=0;
        int Y=r;
        int PK = 1-r;
        g.setColor(Color.pink);
        plotQ(g,xcenter,ycenter,X,Y);
        while (X<=Y){
            X=X+1;
            if (PK<0){
                PK = PK+2*X+1;
            }else{
                Y=Y-1;
                PK = PK+2*X+1-2*Y;
            }
            plotQ(g,xcenter,ycenter,X,Y);
        }
    }
    void drawLine(Graphics g,int x1,int y1,int x2,int y2){
        g.setColor(Color.pink);

        int p = 2 * (y2 - y1);
        int x = x1;
        int y = y1;

        while (x < x2) {

            if (p > 0) {

                x++;

                p -= 2;
            } else {

                y++;

                p += 2;
            }
            g.drawOval(x, y,5,5);
        }
//        g.translate(0,0);
    }
}
