package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import DataGathering.*;

public class DataGUI {

    private static JFrame frame = new JFrame();
    private GUI previousState;
    private DataGUI.Information information;

    /**
     * The GUI is created from here.
     * @param mainGUI The previous state is remembered so that the page can eb restored if necessary.
     */
    DataGUI(GUI mainGUI){
        try{
            previousState = mainGUI;
            information = new Information();
            createGUI();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Creates the display for the GUI.
     */
    public void createGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("<html><h1>Ancillary Data</h1></html>"), BorderLayout.PAGE_START);

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
     * Creates the dynamic output for the auxiliary data found.
     * Currently the only data interpreted is the json file which is data
     * on the current measurements of the shoreline.
     */
    class Information extends JPanel{
        Information() throws FileNotFoundException {
            jsonInterpreter coastLength = new
                    jsonInterpreter("EA_ShorelineManagementPlanMapping/data/Shoreline_Management_Plan_Mapping.json");

            add(new JLabel(coastLength.searchMap(previousState.getLocation()) + " on 10th July 2020"));
        }
    }

    /**
     * Closes the GUI. No longer visible.
     */
    public void closeWindow() {
        frame.setVisible(false);
    }

}
