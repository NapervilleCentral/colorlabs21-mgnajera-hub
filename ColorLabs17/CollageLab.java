
/**
 * Write a description of class CollageLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.awt.*;
import java.util.*;
import java.util.List;

public class CollageLab
{
    public static void main(String[] args)
    {
        Picture Naoya = new Picture("images\\hideonaaaa.jpg");
        Picture Canvas = new Picture("images\\canvas.jpg");
        Picture Flowers = new Picture("images\\whiteFlower.jpg");
        
        //Color Black = new Color(0,0,0);
        //Canvas.explore();
        
        
        Flowers.explore();
        copytoCanvas(Flowers, Canvas, 0, 0);
        
        //Canvas.explore();
        
        //edgeDetect(Flowers, 150);
        //edgeDetect(Naoya, 100);
        //Naoya.explore();
        Flowers.explore();
        
        
        Shrink(Flowers, Flowers.getHeight(), Flowers.getWidth(), 0, 0);
        Flowers.explore();
    }
    
    
    
    /**
     * add two ints to aparams and place you want target to go onto the canvas
     */
    
    public static void copytoCanvas(Picture source, Picture target, int startX, int startY)
    {
        //recursive copy to a x,y on the source
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        //loop thru the columns (targetX is starting point on Canvas) sourceX += 2 (larger sX = xS + 0.5)
        for (int sourceX = 0, targetX = 0 + startX; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            //go thru the rows                                              sourceY+=2 (larger sY = sY + 0.5)
            for (int sourceY = 0, targetY = 0 + startY; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
            }
            
        }
    }
    
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
     * Edge Detection
     */
    public static void edgeDetect(Picture aPic, int range)
    {
        Pixel prevPix = null;
        Pixel nextPix = null;
        int prevColor = 0;
        int nextColor = 0;
        
        int threshold = range;
        
        for(int y = 0; y < aPic.getHeight(); y++)
        {
            for (int x = 1; x < aPic.getWidth(); x++)
            {
                prevPix = aPic.getPixel(x - 1, y);
                nextPix = aPic.getPixel(x, y);
                
                prevColor = prevPix.getRed() + prevPix.getGreen() + prevPix.getBlue();
                nextColor = nextPix.getRed() + nextPix.getGreen() + nextPix.getBlue(); 
                
                if (Math.abs(prevColor - nextColor) > threshold && prevColor > 0)
                {
                    prevPix.setColor(Color.black);
                }
                else
                {
                    nextPix.setColor(Color.white);
                }
                
            }
        }
        
        
    }
    
    
    
    /**
     * Shrinks an image
     */
    
    public static void Shrink(Picture aPic, int Height, int Width, int StartX, int StartY)
    {
        //recursive copy to a x,y on the source
        
        Picture source = aPic;
        Picture target = aPic;
        
        int newWidth = Width/2;
        int newHeight = Height/2;
        
        int Xoffset = (Width - newWidth)/2;
        int Yoffset = (Height - newHeight)/2;
        
        if (newHeight <= 10)
        {
            return;
        }
        
        Pixel pix1 = null;
        Pixel pix2 = null;
        
        for (int y = 0; y < newHeight; y++)
        {
            for (int x = 0; x < newWidth; x++)
            {
                pix1 = source.getPixel(StartX + x * 2, StartY + y * 2); //original source picture
                pix2 = target.getPixel(StartX + Xoffset + x, StartY + Yoffset + y);
                pix2.setColor(pix1.getColor());
            }
        }
        
        System.out.println(newHeight);
        System.out.println(Xoffset);
        System.out.println(Yoffset);
        //fix the recursive method; does not work!!!
        Shrink(aPic, newHeight, newWidth, Xoffset, Yoffset);
    }
}
