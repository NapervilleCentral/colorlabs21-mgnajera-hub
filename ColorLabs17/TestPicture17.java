/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;//acsesses color class in awt library
import java.util.*; // * lets you import everything
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
     /**/
     
     //opens a pictue using an absolute path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //relative path         directary/folder/file (MUST BHAVE THE FOLDER OR FILE IN THE SMAE DIRECTERY (folder) AS YOUR CODE)
     //Picture apic = new Picture("images\\beach.jpg");
     Picture flowers = new Picture("images\\whiteFlower.jpg");
     Picture Canvas = new Picture("images\\canvas.jpg");
     Picture Naoya = new Picture("images\\hideonaaaa.jpg");
     //Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     //Picture gorge = new Picture("images/2000 gorge.jpg");
     //Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     
     Naoya.explore();
     mirrorVertical(flowers);
     
     mirrorVertical(Naoya);
     Naoya.explore();
     
     
     flowers.explore();
     copytoCnavas(flowers, Canvas);
     flowers.explore();
     
     
     //apic.explore(); //!!!!!!!!!!!!!!!!! DISPLAYS the picture
     //ferris1.explore();
    //gorge.explore();
     
     //to chnage color of picture get all of the pixels
     //makes an array of pixels
     Pixel[] pixels;
     
     //gets pixels from picture and assigns to pixels array
         //pixels = ferris1.getPixels();
   
     //how many pixels or how large array
    //System.out.println("This is a large array"+pixels.length  );


    /*
    //access each index, array notation
    System.out.println(pixels[17]);
    //access each pixel picture.method.getPixel();
    Pixel spot = ferris1.getPixel(100,100);
    Pixel spot2 = ferris1.getPixel(50,50);
    Color grey = new Color(92, 194, 214);
   
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
   
    Pixel spot17 = pixels[17];
    spot17.setRed(200);
    spot17.setBlue(255);
    spot17.setGreen(220);
    //need to re-explore everytime
    spot.setColor(Color.yellow);
    //spot2.setColor(Color.grey);
    ferris1.explore();
   
    
    */
    
    
    /*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);
    ferris1.explore();
    /**/

   // loop to access indexes of array or collection
    //for each loop spot  is a ?
    
    /*
    int red;
    for (Pixel spot1 : pixels)
    {
        //System.out.println(spot1);
        red=spot1.getRed();
        red = (int)(red*.25);
        spot1.setRed(red);
    }
    ferris1.explore();
    ferris1.write("images/SFTry1.jpeg");
    
    
    int green;
    Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
    pixels = ferris2.getPixels();
    for (Pixel spot1 : pixels)
    {
        green = spot1.getGreen();
        green = (int)(green * 0.25);
        spot1.setGreen(green);
    }
    ferris2.explore();
   
    
    
    */
    
     /**/

     /**
      * Method to clear red from picture
      * @param none
      * @return none
      */
     /*
        for (Pixel pixelObj : pixels)
        {
            //set the red value of the current pixel to the new value
           

        }
    ferris1.explore();
   
    /**/
     /**
      * Method to reduce red from picture by a factor of n
      * @param none
      * @return none
      */
/*
    int value;
    final double  FACTOR = .5;
        for (Pixel pixelObj : pixels)
        {

            //get the redvalue
            value = pixelObj.getRed();
            //System.out.println(value);

            //decrease the red value by 50%
       
            //set the red value of the current pixel to the new value
       

        }
    // use new picture when changing or it will make changes to
    // pic you already changed
    //ferris1.explore();
    //ferris2.explore();

    /**/
    //write/save a picture as a file
    //ferris1.write("images/ferris11.jpg");

    /**/
    }//main
    
    /**
     * Method to mirror around a vertical line in the middle of the picture
     * based on width
     */
    public static void mirrorVertical(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows
        for(int y = 0; y < apic.getHeight(); y++)
        {
            //loop from 0 to the middle (mirror point)
            for (int x = 0; x < mirrorPoint; x++)
            {
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
                leftPixel.setColor(leftPixel.getColor());
                
                
            }
        }
    }
    
    
    /**
     * add two ints to aparams and place you want target to go onto the canvas
     */
    
    public static void copytoCnavas(Picture source, Picture target)
    {
        //recursive copy to a x,y on the source
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        //loop thru the columns (targetX is starting point on Canvas) sourceX += 2 (larger sX = xS + 0.5)
        for (int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //go thru the rows                                              sourceY+=2 (larger sY = sY + 0.5)
            for (int sourceY = 0, targetY = 0; sourceY < source.getWidth(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
            
        }
    }
    
    
    
    
    
}//class