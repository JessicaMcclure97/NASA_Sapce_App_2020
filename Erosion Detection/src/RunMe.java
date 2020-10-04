import GUIs.GUI;

public class RunMe {

    /**
     * This should be dynamically created in the future.
     */
    static String location = "Broad Haven North";
    static String changed = "No information currently.";

    public static void main(String[] args) {
        //need to gather two satellite images to compare

        //need to get secondary information

        //display
        GUI gui = new GUI("images/Britain-Oct-2020.jpg", location, changed);
    }
}
