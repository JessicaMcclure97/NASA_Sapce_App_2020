package GUIs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ImpactGUI {

    private static JFrame frame = new JFrame();
    private GUI previousState;
    private ImpactGUI.Information information = new Information();

    /**
     * Immediately creates and displays the GUI.
     * @param mainGUI Previous state of the home page so that this can be restored.
     */
    ImpactGUI(GUI mainGUI){
        previousState = mainGUI;
        createGUI();
    }

    /**
     * The interface design of the impact GUI
     * This is pretty standard and basic.
     */
    public void createGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html 11 Feb
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("<html><h1>Impact</h1></html>"), BorderLayout.PAGE_START);
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
     * Holds the dynamic data content. Due to inexperience this is currently static
     * however in later version's should be updated to improve with machine learning.
     */
    class Information extends JTextPane{
        Information() {

            setSize(new Dimension(800, 800));
            setBorder(new EmptyBorder(10, 10, 10, 10));

            setText("There is a big impact from Coastal Erosion. There are two main impacts " +
                    "from Coastal Erosion, this can either be human or environment related.\n\n" +
                    "Human Causes Of Erosion\nThe increase in tourism can effect this. There has been " +
                    "problems of tourists taking the sand off of beaches. When a lot of people do this " +
                    "there is a significant decrease in the amount of sand. This is a problem as sand is a natural " +
                    "barrier against erosion. \n\n" +
                    "Environmental related\n" +
                    "This can be caused by weather. If there is an increase in storms in an area the erosion process" +
                    "will be sped up.");

        }
    }

    /**
     * Closes the GUI window.
     */
    public void closeWindow() {
        frame.setVisible(false);
    }

}
