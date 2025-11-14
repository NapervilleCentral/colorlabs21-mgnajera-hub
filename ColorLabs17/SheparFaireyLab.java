
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
         // Picture apic = new Picture("images\\beach.jpg");
         //change with selfie picture
         // Picture me = new Picture("images/ShepardFerryPics//orignal.jpg");
         Picture me = new Picture("images/original.jpeg");
         Picture me2 = new Picture("images/original.jpeg");
         Picture me3 = new Picture("images/original.jpeg");
         // Picture me1 = new Picture("images/beach.jpg");
         // Picture me2 = new Picture("images/beach.jpg");
         
         Pixel[] pixel_list;
         pixel_list = me.getPixels();
         
         //SHEPARD FERRY COLORS;
         Color Darkblue = new Color(15,21,128);
         Color Red = new Color(252,3,28);
         Color LightBlue = new Color(95,207,227);
         Color OffWhite = new Color(247,225,227);
         
         /**/
         
         /*
         
         //First Method
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
            if (spot.getRed() > 191) spot.setColor(Darkblue);
            else if (spot.getRed() > 127) spot.setColor(Red);
            else if (spot.getRed() > 64) spot.setColor(LightBlue);
            else spot.setColor(OffWhite);
         }
         //me.explore();
         
         //Second Method
         
         Pixel[] pixel_list2;
         pixel_list2 = me2.getPixels();
         
         total = 0;
         avg = 0;
         for (Pixel spot : pixel_list2)
         {
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            avg = (int)(total/3);
            spot.setRed(avg);
            spot.setGreen(avg);
            spot.setBlue(avg);
         }
         //max = 255
         //min = 5,5,5
         //range = 250
         
         //Slightly adjusted bucket ranges:
         for (Pixel spot : pixel_list2)
         {
            if (spot.getRed() > 170) spot.setColor(Darkblue);
            else if (spot.getRed() > 120) spot.setColor(Red);
            else if (spot.getRed() > 50) spot.setColor(LightBlue);
            else spot.setColor(OffWhite);
         }
         me2.explore();
         
         */
         
         
         //CUSTOM METHOD
         
         Pixel[] pixel_list3;
         pixel_list3 = me3.getPixels();
         
         //Custom Colors
         
         Color offBlue = new Color(193,191,207);
         Color Blue = new Color(40,21,154);
         Color LimeYellow = new Color (222,222,2);
         Color Gold = new Color(222,176,2);
         Color Purple = new Color(99,9,148);
         
         int total = 0;
         int avg = 0;
         for (Pixel spot : pixel_list3)
         {
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            avg = (int)(total/3);
            spot.setRed(avg);
            spot.setGreen(avg);
            spot.setBlue(avg);
         }

         for (Pixel spot : pixel_list3)
         {
            if (spot.getRed() > 200) spot.setColor(Purple);
            else if (spot.getRed() > 150) spot.setColor(Blue);
            else if (spot.getRed() > 100) spot.setColor(LimeYellow);
            else if (spot.getRed() > 50) spot.setColor(Gold);
            else spot.setColor(offBlue);
         }
         me3.explore();
         
         
         
         
         /**
          * method 2 change
          * 
          */
         
         /**
          * custom color palette
          */

         
    }//main       
}//class
