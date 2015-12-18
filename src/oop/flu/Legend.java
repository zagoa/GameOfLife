package oop.flu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Bais on 18/12/2015.
 */
public class Legend extends JFrame {

    public Legend(){
        setTitle("Flu Simulation Legend");
        setSize(500,350);
        setResizable(false);

        Container contents = getContentPane();
        contents.setLayout(new BoxLayout(contents, BoxLayout.PAGE_AXIS));
        LegendPanel l=new LegendPanel();
        contents.add(l);
        setVisible(true);
    }



    class LegendPanel extends JPanel {

        public LegendPanel() {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public Dimension getPreferredSize() {
            return new Dimension(290,100);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawLegend(g,15,15,oop.flu.Type.HUMAN);
            drawLegend(g,15,75,oop.flu.Type.CHICKEN);
            drawLegend(g,15,135,oop.flu.Type.DUCK);
            drawLegend(g,15,195,oop.flu.Type.PIG);

            //Legend for dead beings
            g.setColor(Color.BLACK);
            g.fillRect(15,255,60,30);
            g.drawString("Dead (any type)",15+80,255+20);


        }
        public void drawLegend(Graphics g,int x,int y,oop.flu.Type type){
            switch(type){
                case HUMAN:
                    g.setColor(new Color(0,0,255));
                    g.fillRect(x,y,12,30);
                    g.setColor(new Color(0,0,160));
                    g.fillRect(x+12,y,12,30);
                    g.setColor(new Color(0,0,100));
                    g.fillRect(x+24,y,12,30);
                    g.setColor(new Color(142,161,255));
                    g.fillRect(x+36,y,12,30);
                    g.setColor(new Color(100,100,100));
                    g.fillRect(x+48,y,12,30);
                    g.setColor(Color.black);
                    g.drawString("Humans (Healthy,Sick,Contagious,Immunised,Vaccinated)",x+80,y+20);
                    break;
                case CHICKEN:
                    g.setColor(new Color(255,255,0));
                    g.fillRect(x,y,20,30);
                    g.setColor(new Color(180,180,0));
                    g.fillRect(x+20,y,20,30);
                    g.setColor(new Color(100,100,0));
                    g.fillRect(x+40,y,20,30);
                    g.setColor(Color.black);
                    g.drawString("Chicken (Healthy,Sick,Contagious)",x+80,y+20);
                    break;
                case DUCK:
                    g.setColor(new Color(0,255,0));
                    g.fillRect(x,y,20,30);
                    g.setColor(new Color(0,180,0));
                    g.fillRect(x+20,y,20,30);
                    g.setColor(new Color(0,100,0));
                    g.fillRect(x+40,y,20,30);
                    g.setColor(Color.black);
                    g.drawString("Ducks (Healthy,Sick,Contagious)",x+80,y+20);
                    break;
                case PIG:
                    g.setColor(new Color(255,0,255));
                    g.fillRect(x,y,20,30);
                    g.setColor(new Color(180,0,180));
                    g.fillRect(x+20,y,20,30);
                    g.setColor(new Color(100,0,100));
                    g.fillRect(x+40,y,20,30);
                    g.setColor(Color.black);
                    g.drawString("Pigs (Healthy,Sick,Contagious)",x+80,y+20);
                    break;
            }
        }
    }
}
