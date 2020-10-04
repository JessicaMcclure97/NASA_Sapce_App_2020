package GUIs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static JFrame frame = new JFrame();

    private  String location;
    private JLabel changed;
    private ImageIcon hazardImage;

    private Buttons buttons = new GUI.Buttons(this);
    private KeyInformation information;

    /**
     * Automatically creates the main GUI.
     * @param imageFile Resize's and displays the image where the hazard was detected.
     * @param location Location where the hazard was detected is displayed.
     * @param changed This is what was changed and by how much.
     */
    public GUI(String imageFile, String location, String changed){
        hazardImage = new ImageIcon(imageFile);
        Image image = hazardImage.getImage(); // transform it
        Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        hazardImage = new ImageIcon(newimg);

        this.location = location;
        this.changed = new JLabel("Changed: " + changed);
        information = new GUI.KeyInformation();

        createGUI();
    }

    /**
     * @return The location the hazard is detected.
     */
    public String getLocation() {
        return location;
    }

    /**
     * The creates the main GUI that is shown.
     */
    public void createGUI(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setLayout(new BorderLayout());

        frame.add(new JLabel("<html><h1>Coastal Erosion Detection</h1></html>"), BorderLayout.PAGE_START);
        frame.add(new JLabel(hazardImage), BorderLayout.WEST);
        frame.add(information, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }

    /**
     * This is the key information. This is displayed
     * next to the hazard image.
     */
    class KeyInformation extends JPanel{
        KeyInformation(){
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridLayout(2,1));
            add(new JLabel("Location: " + location));
            add(changed);
        }
    }

    /**
     * This shows all the buttons on the bottom of the GUI. This
     * is where the action for what happens when the button is
     * pressed is decided.
     */
    class Buttons extends JPanel {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        Buttons(GUI main) {
            setLayout(new GridLayout(1, 2));

            JButton data = new JButton("Ancillary Data");
            data.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get current state to determine next state of board
                    new DataGUI(main);
                    //update display
                    closeWindow();
                }
            });

            JButton dataInterpretation = new JButton("Data Interpretation");
            dataInterpretation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get current state to determine next state of board
                    new DataInterpretationGUI(main);
                    //update display
                    closeWindow();
                }
            });

            JButton impact = new JButton("Impact");
            impact.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get current state to determine next state of board
                    new ImpactGUI(main);
                    //update display
                    closeWindow();
                }
                });

            JButton scope = new JButton("Scope");
            scope.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get current state to determine next state of board
                    new ScopeGUI(main);
                    //update display
                    closeWindow();
                }
            });

            add(data);
            add(dataInterpretation);
            add(impact);
            add(scope);

        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    }

    /**
     * This closes the window.
     */
    public void closeWindow() {
        frame.setVisible(false);
    }

}
