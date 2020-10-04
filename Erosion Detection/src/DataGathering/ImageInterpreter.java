package DataGathering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * This interprets a black and white image to see
 * how many white pixels are in the image. This was never implemented
 * since the data showed no difference in coastlines.
 */
public class ImageInterpreter {

    public static void main(String[] args) throws IOException {

        ImageInterpreter c = new ImageInterpreter("images/coast-2020.jpg", "Britain Coast 2020");
        ImageInterpreter d = new ImageInterpreter("images/coast-1970.jpg", "Britain Coast 1970");

        comparePixelNumber(c, d);

    }

    public File imageFile; // a black and white image file
    public String name;

    ImageInterpreter(String imageFile, String name) {
        this.imageFile = new File(imageFile);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * This looks at the pixels within an image
     * @return The number of white pixels in the image
     */
    //https://www.geeksforgeeks.org/image-processing-java-set-2-get-set-pixels/?ref=rp
    public int pixelNumber(){
        //read image file
        BufferedImage imgReader = null;
        try {
            imgReader = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Image not found: " + e);
        }

        //get number of white pixels
        int numberPixels = 0;

        //get image width and height
        int width = imgReader.getWidth();
        int height = imgReader.getHeight();

        int black = Color.black.getRGB();

        for (int w = 0; w <= width - 1; w++) {
            for (int h = 0; h <= height - 1; h++) {
                if (black != (imgReader.getRGB(w, h))) {
                    numberPixels = numberPixels + 1;
                }
            }
        }
        return numberPixels;
    }

    public static void comparePixelNumber(ImageInterpreter a, ImageInterpreter b){
        if(a.pixelNumber() < b.pixelNumber()){
            System.out.println(a.getName() + " is smaller than " + b.getName());
        }else if(a.pixelNumber() > b.pixelNumber()){
            System.out.println(b.getName() + " is smaller than " + a.getName());
        }else if(a.pixelNumber() == b.pixelNumber()){
            System.out.println("Both images are equal");
        }
    }


}







