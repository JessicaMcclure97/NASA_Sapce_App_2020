package GUIs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataInterpretationGUI {

    private static JFrame frame = new JFrame();
    private GUI previousState;

    public static JFrame getFrame() {
        return frame;
    }

    DataInterpretationGUI(GUI mainGUI){
        previousState = mainGUI;
        createGUI();
    }

    public void createGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html 11 Feb
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("<html><h1>Data Interpretation</h1></html>"), BorderLayout.PAGE_START);

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

    public void closeWindow() {
        frame.setVisible(false);
    }

}
