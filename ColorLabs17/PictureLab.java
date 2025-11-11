
/**
 * PictureLab
 * Practice using picture class
 * Manny N
 * 11/10/2025
 */


import java.awt.*;//acsesses color class in awt library
import java.util.*; // * lets you import everything
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class PictureLab
{
    public static void main(String[] args)
    {
    
        Picture ferris = new Picture("images/2000 ferris wheel2.jpg");
        Pixel[] pixels; // Set pixels as an array of Pixel from the class
        
        pixels = ferris.getPixels(); // make pixles an array of this
                                     // picture's pixles
        
        //Adjust Red(Double red) by 150%
        int red;
        //Defines what the spot is and what its iterating through
        for (Pixel spot : pixels)
        {
            red = spot.getRed();
            red = (int)(red*1.5); //cast as an int(can't be a double)   
            spot.setRed(red);
        }
        //ferris.explore();
        
        ferris = new Picture("images/2000 ferris wheel2.jpg");
        pixels = ferris.getPixels();
        // reopen pictures to reset it along with the array
        
        //Negate
        int negate_val;
        for (Pixel spot : pixels)
        {
            negate_val = (255-spot.getRed());
            spot.setRed(negate_val);
            negate_val = (255 - spot.getGreen());
            spot.setGreen(negate_val);
            negate_val = (255 - spot.getBlue());
            spot.setBlue(negate_val);
        }
        //ferris.explore();
        
        //Grayscale
        ferris = new Picture("images/2000 ferris wheel2.jpg");
        Pixel[] pixel_list;
        pixel_list = ferris.getPixels();
        
        int num;
        int avg;
        for (Pixel spot : pixel_list)
        {
            num = spot.getRed() + spot.getBlue() + spot.getGreen();
            avg = (int)(num/3);
            spot.setRed(avg);
            spot.setGreen(avg);
            spot.setBlue(avg);
        }
        //ferris.explore();
        
        
        //Lighten (50%)
        
        ferris = new Picture("images/2000 ferris wheel2.jpg");
        //Pixel[] pixel_list;  //Already made a new pixel list
        pixel_list = ferris.getPixels();
        
        double light_factor = 1.5;
        int r, g, b;
        for (Pixel spot : pixel_list)
        {
            r = (int)(spot.getRed() * light_factor);
            g = (int)(spot.getGreen() * light_factor);
            b = (int)(spot.getBlue() * light_factor);
        
        }
        ferris.explore();
    }
}
