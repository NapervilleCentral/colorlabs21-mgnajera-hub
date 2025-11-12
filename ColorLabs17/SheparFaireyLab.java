
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
         /**/
         // String fileName = FileChooser.pickAFile();
         // Picture pictObj = new Picture(fileName);
         // pictObj.explore();
         
         //relative path
         Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         Picture me = new Picture("images/beach.jpg");
         // Picture me1 = new Picture("images/beach.jpg");
         // Picture me2 = new Picture("images/beach.jpg");
         
         Pixel[] pixel_list;
         pixel_list = me.getPixels();
         
         int total;
         int avg;
         for (Pixel spot : pixel_list)
         {
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            avg = (int)(total/3);
            spot.setRed(avg);
            spot.setGreen(avg);
            spot.setBlue(avg);
         }
         
         for (Pixel spot : pixel_list)
         {
            if pixel.getRed() > 
            
            
            
         }
         
         
         
         
         
         /*
         
         
         //Pixel[] sorted_list;
         //sorted_list = me.getPixels();
         
         boolean done = false;
         while(!done)
         {
             for (Pixel spot : pixel_list)
             {
                 strength =    
                
                
             }
            
            
            
            
         }
         
         me.explore();
         */
         
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

         
    }//main       
}//class
