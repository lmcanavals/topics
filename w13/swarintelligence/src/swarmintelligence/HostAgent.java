package swarmintelligence;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.wrapper.AgentController;
import jade.wrapper.PlatformController;
import java.util.ArrayList;

/**
 *
 * @author WillyUgarte
 */
public class HostAgent extends Agent {
    public static MainFrame frame = null;
    public static int numberFishes = 5_000;
    public static ArrayList<FishAgent> fishes = new ArrayList<>();
    public static boolean ENABLED = false;
    public static int x_center = 0;
    
    @Override
    public void setup() {
        try {
            // create a description
            DFAgentDescription dfd = new DFAgentDescription();
            // set id as name
            dfd.setName(getAID());
            // initialize frame
            frame = new MainFrame(this);
            frame.setVisible(true);
            //
            initialize();
            //            
            addBehaviour(new CyclicBehaviour(this) {
                @Override
                public void action() { MainFrame.panel_principal.repaint(); }
            });
            //
            addBehaviour(new TickerBehaviour(this, 100) {
                @Override
                protected void onTick() {
                    for (FishAgent pez : fishes) {
                        pez.defineStatus();
                        pez.swim();
                    }
                }
            });
            addBehaviour(new TickerBehaviour(this, 1000) {
                @Override
                protected void onTick() { x_center += 5; }
            });
        }
        catch(Exception e) {
            System.err.println("exception " + e);
            e.printStackTrace();
        }
    }
    
    public void initialize(){
        PlatformController container = getContainerController();
        try {
            for (int i = 0; i < numberFishes; i++) {
                fishes.add(new FishAgent());
                String localName = "pez_" + i;
                AgentController ac = container.createNewAgent(localName, "swarmintelligence.FishAgent", null);
                ac.start();                
            }
            MainFrame.panel_principal.setEnabled(true);
            ENABLED = true;
        }
        catch(Exception e) {
            System.err.println("exception " + e);
            e.printStackTrace();
        }
    }
}