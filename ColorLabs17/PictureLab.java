
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
        
        pixels = ferris.getPixels();// 
        
        
        
        
        for (Pixel spot1 : pixels)
        {
            //System.out.println(spot1);
            red=spot1.getRed();
            red = (int)(red*.25);
            spot1.setRed(red);
        }
    
    }
}
