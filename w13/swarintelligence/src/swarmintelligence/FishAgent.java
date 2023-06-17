package swarmintelligence;

import jade.core.Agent;
import java.awt.Color;

/**
 *
 * @author WillyUgarte
 */
public class FishAgent extends Agent {
   public int x;
   public int y;
   public int status; // 1:beware,2:nom nom nom,3:swim up,4:swim down
   public Color color;
   public int size;
   public int speed;
   
   public FishAgent() {
       x = (int) (1300 * Math.random());
       y = (int) (500 * Math.random());
       color = new Color((int)(Math.random() * 0x1000000));
       size = (int) (25 * Math.random() + 5);
       speed = 10 * 25 / size;
   }
   
   public void defineStatus() {
       if (y < 500) {
           status = 1;
           if (x > 100 + HostAgent.x_center)
               status = 4;
       }
       else if (y > 900) {
           status = 2;
           if (x < 30 + HostAgent.x_center)
               status = 3;
       }
       else {
           if (x < 30 + HostAgent.x_center)
               status = 3;
           else
               status = 4;
       }
   }
   
   public void swim(){
       switch (status) {
           case 1 -> x += speed;
           case 2 -> x -= speed;
           case 3 -> y -= speed;
           case 4 -> y += speed;
       }
   }
}
