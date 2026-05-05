
/**
 * Write a description of class PantheonPractice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PantheonPractice
{
   public static void main(String[] args)
   {
       Picture Temple = new Picture("images\\temple.jpg");
       Temple.explore();
       Fix(Temple);
       Temple.explore();
   }
   
   
       
    /**
     * Method to mirror around a vertical line in the middle of the picture
     * based on width
     */
    public static void Fix(Picture apic)
    {
        int width = apic.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows
        for(int y = 0; y < apic.getHeight()/4; y++)
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
}
