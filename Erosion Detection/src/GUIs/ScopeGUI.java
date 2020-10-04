package GUIs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScopeGUI {

    private static JFrame frame = new JFrame();
    private GUI previousState;
    private ScopeGUI.Information information;

    /**
     * The GUI is automatically displayed from this constructor.
     * @param mainGUI Previous state stored so the page can be restored later.
     */
    ScopeGUI(GUI mainGUI) {
        previousState = mainGUI;
        information = new Information();
        createGUI();
    }

    /**
     * Where the display is created.
     */
    public void createGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("<html><h1>Scope</h1></html>"), BorderLayout.PAGE_START);

        frame.add(information, BorderLayout.CENTER);

        JButton back = new JButton("Back to Main Page");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get current state to determine next state of board
                GUI mainGUI = previousState;
                mainGUI.createGUI();
                //update display
                closeWindow();
            }
        });
        frame.add(back, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    /**
     * Static content is displayed about the scope of the
     * impact of Coastal Erosion.
     */
    class Information extends JTextPane{
        Information() {

            setSize(new Dimension(800, 800));
            setBorder(new EmptyBorder(10, 10, 10, 10));

            String location = previousState.getLocation();

            setText("The specific area which has been effected by Coastal Erosion is " +
                    location + ". The erosion could effect other parts of the coastline " +
                    "further down or up from " + location +" . This is because this area " +
                    "is no longer protected against erosion.");

        }
    }

    /**
     * Closes the display of the GUI.
     */
    public void closeWindow() {
        frame.setVisible(false);
    }

}
