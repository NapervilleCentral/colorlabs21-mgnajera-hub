
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
        Picture CyberP = new Picture("images\\CyberpunkPoster.jpg");
        Picture CyberP2 = new Picture("images\\CyberpunkPoster.jpg");
        Picture CyberP3 = new Picture("images\\CyberpunkPoster.jpg");
        Picture CyberP4 = new Picture("images\\CyberpunkPoster.jpg");
        Picture CyberP5 = new Picture("images\\CyberpunkPoster.jpg");
        Picture Canvas = new Picture("images\\canvas.jpg");
        Picture Flowers = new Picture("images\\whiteFlower.jpg");
        
        //Color Black = new Color(0,0,0);
        //Canvas.explore();
        
        
        //Flowers.explore();
        //copytoCanvas(Flowers, Canvas, 0, 0);
        
        //Canvas.explore();
        
        //edgeDetect(Flowers, 150);
        //edgeDetect(Naoya, 100);
        //Naoya.explore();
        //Flowers.explore();
        
        
        //Shrink(Flowers, Flowers.getHeight(), Flowers.getWidth(), 0, 0);
        //negate(Flowers);
        //Flowers.explore();
        
        CyberP.explore();
        Shrink(CyberP, CyberP.getHeight(), CyberP.getWidth(), 0, 0);
        CyberP.explore();
        
        edgeDetect(CyberP2,200);
        CyberP2.explore();
        
        mirrorVertical(CyberP4);
        CyberP4.explore();
        
        negate(CyberP5);
        CyberP5.explore();
        
        spiral(CyberP3);
        CyberP3.explore();
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
        
        int Xoffset = StartX + (Width - newWidth)/2;
        int Yoffset = StartY + (Height - newHeight)/2;
        
        if (newHeight <= 1)
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
                pix2 = target.getPixel(Xoffset + x,Yoffset + y);
                pix2.setColor(pix1.getColor());
            }
        }

        Shrink(aPic, newHeight, newWidth, Xoffset, Yoffset);
    }
    
    
    public static void negate(Picture pic)
    {
        
        Pixel pix = null;
        int negate_val = 0;
        int randd = 0;
        
        
        for (int y = 0; y < pic.getHeight(); y++)
        {
            for (int x = 0; x < pic.getWidth(); x++)
            {
                randd = (int)Math.floor((Math.random()*30));
                
                
                pix = pic.getPixel(x, y);
                negate_val = (255+randd-pix.getRed());
                pix.setRed(negate_val);
                negate_val = (255+randd - pix.getGreen());
                pix.setGreen(negate_val);
                negate_val = (255+randd - pix.getBlue());
                pix.setBlue(negate_val);
            }
        }

    }
    
    public static void spiral(Picture apic)
    {
        Pixel pix = null;
        Pixel newPix = null;
        
        int newX = 0;
        int newY = 0; //cords of new pixel
        
        
        int centerX = apic.getWidth()/2;
        int centerY = apic.getHeight()/2; 
        
        int r;
        double theta;
        double theta_helper; //ratio to put in the atan function
        
        for (int y = 0; y < apic.getHeight()/2; y++)
        {
            for (int x = 0; x < apic.getWidth()/2; x++)
            {   
                pix = apic.getPixel(x, y);
                r = (int)Math.sqrt(Math.pow(x-centerX, 2) + Math.pow(y-centerY, 2));
                
                System.out.println(r);
                
                theta_helper = Math.abs(y-centerY)/Math.abs(x-centerX);
                
                theta = Math.atan(theta_helper);
                
                System.out.println(theta*(180/Math.PI));
                
                
                theta = theta + 1.0; //rotate pixel
                r = r-4; //shrink radius
                
                newX = (int)(centerX + r*Math.cos(theta));
                System.out.println(newX);
                newY = (int)(r*Math.sin(theta));
                System.out.println(newY);
                
                newPix = apic.getPixel(newX, newY);
                newPix.setColor(pix.getColor());
                
            }
        }
    }
    
}
