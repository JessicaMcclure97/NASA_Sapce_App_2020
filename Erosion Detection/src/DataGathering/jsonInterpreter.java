package DataGathering;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * This reads a json File.
 */
public class jsonInterpreter {

    InputStream in;
    Map<String, Double> coastline = new HashMap<>();

    public jsonInterpreter(String pathFile) throws FileNotFoundException {
        in = new FileInputStream(new File(pathFile));
        setMap();
    }

    /**
     * A map of the desired data is created.
     * This is the location mapped against the length of the area.
     */
    public void setMap(){


        JsonParserFactory factory = Json.createParserFactory(null);
        JsonParser parser = factory.createParser(in);

        String location = null;
        double length = 0;
        boolean receiveLocation = false;
        boolean receiveLength = false;


        while (parser.hasNext()) {
            JsonParser.Event e = parser.next();
            //detect the event
            switch (e) {
                case KEY_NAME:
                    String fieldName = parser.getString();
                    if(fieldName.equals("length_km")){
                        receiveLength = true;
                    }else if(fieldName.equals("location")){
                        receiveLocation = true;
                    }
                    break;

                case VALUE_STRING:
                    if (receiveLocation) {
                        location = parser.getString();
                        receiveLocation = false;
                    }else if(receiveLength){
                        length = Double.parseDouble(parser.getString());
                        receiveLength = false;
                    }

                default:
                    //don't care about other information
                    break;
            }

            if(location != null && length != 0){
                coastline.put(location, length);
                //reset
                location = null;
                length = 0;
            }

        }

    }

    /**
     * This searches the map. This can be used
     * to compare multiple of these JSON files to see
     * if any points have decreased. If the have then the
     * coastline would have eroded.
     * @param location Location required.
     * @return An output stating the length of the desired area.
     */
    public String searchMap(String location) {
         String output = "The length of coastline at " + location + " is " +
                coastline.get(location) + "km.";

         return output;

    }


}
