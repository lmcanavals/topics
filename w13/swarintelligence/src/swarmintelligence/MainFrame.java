package swarmintelligence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author WillyUgarte
 */
public class MainFrame extends JFrame {
    public static AmbientPanel panel_principal;
    protected HostAgent host;
    
    public MainFrame(HostAgent host) {
        this.host = host;
        try { initialize(); }
        catch(Exception e) {
            System.err.println("exception " + e);
            e.printStackTrace();
        }
    }
    
    public void initialize() {
        // maximize frame
        final GraphicsConfiguration config = getGraphicsConfiguration();
        final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
        final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
        final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = screenSize.width - left - right;
        final int height = screenSize.height - top - bottom;     
        setResizable(false);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);
        //
        panel_principal = new AmbientPanel();
        panel_principal.setBackground(Color.BLUE);
        //
        add(panel_principal, BorderLayout.CENTER);    
   }
}