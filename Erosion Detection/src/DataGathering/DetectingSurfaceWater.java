package DataGathering;

/**
 * This was never implemented since none of the desired data was found.
 */
public class DetectingSurfaceWater {

    public static void main(String[] args) {
        DetectingSurfaceWater dsw = new DetectingSurfaceWater();
        dsw.calculatingSurfaceWater(0, 0);
    }

    /**
     * Besy method to detect surface water from multispectral images.
     * @param green
     * @param nir
     */
    public void calculatingSurfaceWater(double green, double nir){

        double ndwi = (green - nir)/(green + nir); //normalised difference water index

        if(ndwi > 0){
            System.out.println("Water appearing the most");
        }else if(ndwi <= 0){
            System.out.println("Water not appearing");
        }

    }

}
