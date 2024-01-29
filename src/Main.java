import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public Main() {
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        // setLayout(new BorderLayout());
    }

    public static void main(String[] args) {
        Main frame = new Main();
        // PanelMidpoint panelMidpoint = new PanelMidpoint();
        Ex4 ex4 = new Ex4();
        Ex5 ex5 = new Ex5();
        Ex6 ex6 = new Ex6();
        // frame.add(panelMidpoint);
        // frame.add(ex4, BorderLayout.WEST); 
        // frame.add(ex5, BorderLayout.CENTER);
        // frame.add(ex6, BorderLayout.EAST);
        frame.add(ex6);
        frame.setVisible(true);
    }
}

class PanelMidpoint extends JPanel {
    public PanelMidpoint() {
        setSize(500, 500);
        setLayout(null);
    }

    public void paint(Graphics g) {
        midpointCircle(g, 350, 350, 80);
    }

    void plotQ(Graphics g, int xcenter, int ycenter, int X, int Y) {
        g.fillOval(xcenter + X, ycenter + Y, 5, 5); // Q1
        g.fillOval(xcenter + Y, ycenter + X, 5, 5); // Q2
        g.fillOval(xcenter + Y, ycenter - X, 5, 5); // Q3
        g.fillOval(xcenter + X, ycenter - Y, 5, 5); // Q4
        g.fillOval(xcenter - X, ycenter - Y, 5, 5); // Q5
        g.fillOval(xcenter - Y, ycenter - X, 5, 5); // Q6
        g.fillOval(xcenter - Y, ycenter + X, 5, 5); // Q7
        g.fillOval(xcenter - X, ycenter + Y, 5, 5); // Q8
    }

    void midpointCircle(Graphics g, int xcenter, int ycenter, int r) {
        int X = 0;
        int Y = r;
        int PK = 1 - r;
        g.setColor(Color.pink);
        plotQ(g, xcenter, ycenter, X, Y);
        while (X <= Y) {
            X = X + 1;
            if (PK < 0) {
                PK = PK + 2 * X + 1;
            } else {
                Y = Y - 1;
                PK = PK + 2 * X + 1 - 2 * Y;
            }
            plotQ(g, xcenter, ycenter, X, Y);
        }
    }
}

class Ex4 extends JPanel {
    Ex4() {
        setSize(700, 700);
        setLayout(null);
    }

    public void paint(Graphics g) {
        midpointCircle(g, 200, 200, 140);
    }

    void plotQ(Graphics g, int xcenter, int ycenter, int X, int Y) {
        // g.fillOval(xcenter+X,ycenter+Y,5,5); //Q1
        // g.fillOval(xcenter+Y,ycenter+X,5,5); //Q2
        g.fillOval(xcenter + Y, ycenter - X, 5, 5); // Q3
        g.fillOval(xcenter + X, ycenter - Y, 5, 5); // Q4
        g.fillOval(xcenter - X, ycenter - Y, 5, 5); // Q5
        g.fillOval(xcenter - Y, ycenter - X, 5, 5); // Q6
        // g.fillOval(xcenter-Y,ycenter+X,5,5); //Q7
        // g.fillOval(xcenter-X,ycenter+Y,5,5); //Q8
    }

    void midpointCircle(Graphics g, int xcenter, int ycenter, int r) {
        int X = 0;
        int Y = r;
        int PK = 1 - r;
        g.setColor(Color.pink);
        plotQ(g, xcenter, ycenter, X, Y);
        while (X <= Y) {
            X = X + 1;
            if (PK < 0) {
                PK = PK + 2 * X + 1;
            } else {
                Y = Y - 1;
                PK = PK + 2 * X + 1 - 2 * Y;
            }
            plotQ(g, xcenter, ycenter, X, Y);
        }
    }
}

class Ex5 extends JPanel {
    Ex5() {
        setSize(700, 700);
        setLayout(null);
    }

    public void paint(Graphics g) {
        midpointCircle(g, 200, 200, 140);
    }

    void plotQ(Graphics g, int xcenter, int ycenter, int X, int Y) {

        g.fillOval(xcenter + X, ycenter + Y, 5, 5); // Q1
        // g.fillOval(xcenter+Y,ycenter+X,5,5); //Q2
        // g.fillOval(xcenter+Y,ycenter-X,5,5); //Q3
        g.fillOval(xcenter + X, ycenter - Y, 5, 5); // Q4
        g.fillOval(xcenter - X, ycenter - Y, 5, 5); // Q5
        // g.fillOval(xcenter-Y,ycenter-X,5,5); //Q6
        // g.fillOval(xcenter-Y,ycenter+X,5,5); //Q7
        g.fillOval(xcenter - X, ycenter + Y, 5, 5); // Q8
    }

    void midpointCircle(Graphics g, int xcenter, int ycenter, int r) {
        int X = 0;
        int Y = r;
        int PK = 1 - r;
        g.setColor(Color.pink);
        plotQ(g, xcenter, ycenter, X, Y);
        while (X <= Y) {
            X = X + 1;
            if (PK < 0) {
                PK = PK + 2 * X + 1;
            } else {
                Y = Y - 1;
                PK = PK + 2 * X + 1 - 2 * Y;
            }
            plotQ(g, xcenter, ycenter, X, Y);
        }

        BresenhamLine(g, xcenter - X, ycenter + Y, xcenter + X, ycenter - Y); // 8 4
        BresenhamLine(g, xcenter + X, ycenter + Y, xcenter - X, ycenter - Y); // 1 5
    }

    void BresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            g.setColor(Color.pink); // Set pixel color (can be changed)
            // g.drawLine(x1, y1, x1, y1); // Draw individual pixel
            g.drawOval(x1, y1, 5, 5);
            g.drawOval(x2, y2, 5, 5);
            if (x1 == x2 && y1 == y2) {
                break; // End if both endpoints reached
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }
}

class Ex6 extends JPanel {
    int WidthX = 690;
    int Height = 690;
    Ex6() {
        setSize(700, 700);
        setLayout(null);
    }

    public void paint(Graphics g) {
        int temps = 15;
        
        midpointCircle(g, WidthX/2, 100, 80+temps);
        midpointCircle(g, WidthX/2, 100, 60+temps);
        midpointCircle(g, WidthX/2, 100, 40+temps);
        midpointCircle(g, WidthX/2, 100, 20+temps);
        midpointCircle(g, WidthX/2, 100, 0+temps);

        int tempsX2 = 200;
        int tempsY2 = 400;
        midpointCircle(g, WidthX/2-tempsX2, tempsY2, 80+temps);
        midpointCircle(g, WidthX/2-tempsX2, tempsY2, 60+temps);
        midpointCircle(g, WidthX/2-tempsX2, tempsY2, 40+temps);
        midpointCircle(g, WidthX/2-tempsX2, tempsY2, 20+temps);
        midpointCircle(g, WidthX/2-tempsX2, tempsY2, 0+temps);


        midpointCircle(g, WidthX/2+tempsX2, tempsY2, 80+temps);
        midpointCircle(g, WidthX/2+tempsX2, tempsY2, 60+temps);
        midpointCircle(g, WidthX/2+tempsX2, tempsY2, 40+temps);
        midpointCircle(g, WidthX/2+tempsX2, tempsY2, 20+temps);
        midpointCircle(g, WidthX/2+tempsX2, tempsY2, 0+temps);


        BresenhamLine(g, WidthX/2 , 100, WidthX/2-tempsX2, tempsY2);
        BresenhamLine(g, WidthX/2 , 100, WidthX/2+tempsX2, tempsY2);
        BresenhamLine(g, WidthX/2-tempsX2, tempsY2, WidthX/2+tempsX2, tempsY2);
    }

    void midpointCircle(Graphics g, int xcenter, int ycenter, int r) {
        int X = 0;
        int Y = r;
        int PK = 1 - r;
        g.setColor(Color.pink);
        plotQ(g, xcenter, ycenter, X, Y);
        while (X <= Y) {
            X = X + 1;
            if (PK < 0) {
                PK = PK + 2 * X + 1;
            } else {
                Y = Y - 1;
                PK = PK + 2 * X + 1 - 2 * Y;
            }
            plotQ(g, xcenter, ycenter, X, Y);
        }
        
    }

    void plotQ(Graphics g, int xcenter, int ycenter, int X, int Y) {

        g.fillOval(xcenter + X, ycenter + Y, 2, 2); // Q1
        g.fillOval(xcenter + Y, ycenter + X, 2, 2); // Q2
        g.fillOval(xcenter + Y, ycenter - X, 2, 2); // Q3
        g.fillOval(xcenter + X, ycenter - Y, 2, 2); // Q4
        g.fillOval(xcenter - X, ycenter - Y, 2, 2); // Q5
        g.fillOval(xcenter - Y, ycenter - X, 2, 2); // Q6
        g.fillOval(xcenter - Y, ycenter + X, 2, 2); // Q7
        g.fillOval(xcenter - X, ycenter + Y, 2, 2); // Q8
    }

    void BresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            g.setColor(Color.pink); // Set pixel color (can be changed)
            // g.drawLine(x1, y1, x1, y1); // Draw individual pixel
            g.drawOval(x1, y1, 2, 2);
            g.drawOval(x2, y2, 2, 2);
            if (x1 == x2 && y1 == y2) {
                break; // End if both endpoints reached
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

}