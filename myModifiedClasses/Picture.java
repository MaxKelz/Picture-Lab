import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++; //For Activity 7 Exercise 1
      }
    }
    System.out.println(count); //For Activity 7 Exercise 1
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /**
   * Method to only keep the blue RGB value for a pixel, setting the red and green values' to zero.
   * Activity 5 Exercise 3
   */
  public void keepOnlyBlue()
  {
      Pixel[][] pixelArr = this.getPixels2D();
      for(Pixel[] r : pixelArr)
      {
          for(Pixel p : r)
          {
              p.setRed(0);
              p.setGreen(0);
          }
      }
  }
  
  /**
   * Method to negate an image
   * Activity 5 Exercise 4
   */
  public void negate()
  {
    Pixel[][] pixelArr = this.getPixels2D();
    for(Pixel[] r : pixelArr)
      {
          for(Pixel p : r)
          {
              p.setRed(255-p.getRed());
              p.setGreen(255-p.getGreen());
              p.setBlue(255-p.getBlue());
          }
      }
  }
  
  /**
   * Method to grayscale an image
   * Activity 5 Exercise 5
   */
  public void grayscale()
  {
      Pixel[][] pixelArr = this.getPixels2D();
      for(Pixel[] r : pixelArr)
      {
          for(Pixel p : r)
          {
              int avgVal = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
              p.setRed(avgVal);
              p.setGreen(avgVal);
              p.setBlue(avgVal);
          }
      }
  }
  
  /**
   * Method to (try to) make the fish easier to see
   * Activity 5 Exercise 6
   */
  public void fixUnderwater()
  {
      Pixel[][] pixelArr = this.getPixels2D();
      for(Pixel[] r : pixelArr)
      {
          for(Pixel p : r)
          {
              if(p.getBlue() > 165)
              {
                  if(p.getBlue() + 50 > 255)
                  {
                      p.setBlue(255);
                  } else {
                      p.setBlue(p.getBlue() + 50);
                      p.setGreen(p.getGreen() + 50);
                      p.setRed(p.getRed() + 50);
                  }
              } else {
                  if(p.getBlue() - 25 < 0)
                  {
                      p.setBlue(0);
                  } else {
                      p.setBlue(p.getBlue() - 25);
                      p.setGreen(p.getGreen() - 25);
                      p.setRed(p.getRed() - 25);
                  }
              }
          }
      }
  }
  
  /**
   * Method to mirror an image vertically from right to left.
   * Activity 6 Exercise 1
   */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length - 1;
    for(int row = 0; row < pixels.length; row++)
    {
        for(int col = width; col > width/2; col--)
        {
            rightPixel = pixels[row][col];
            leftPixel = pixels[row][width - col];
            leftPixel.setColor(rightPixel.getColor());            
        }
    }
  }
  
  /**
   * Mirrors an image horizontally from top to bottom
   * Activity 6 Exercise 2
   */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel origPixel = null;
    Pixel mirPixel = null;
    int height = pixels.length - 1;
    for(int row = 0; row < height/2; row++)
    {
        for(int col = 0; col < pixels[0].length; col++)
        {
            origPixel = pixels[row][col];
            mirPixel = pixels[height-1-row][col];
            mirPixel.setColor(origPixel.getColor());
        }
    }
  }
  
  /**
   * Mirrors horizontal from bottom to top
   * Activity 6 Exercise 3
   */
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel origPixel = null;
    Pixel mirPixel = null;
    int height = pixels.length - 1;
    for(int row = height; row > height/2; row--)
    {
        for(int col = 0; col < pixels[0].length; col++)
        {
            origPixel = pixels[row][col];
            mirPixel = pixels[height-row][col];
            mirPixel.setColor(origPixel.getColor());
        }
    }
  }
  
  /**
   * Mirrors arms of the snowman in snowman.jpg to have 4 arms total
   * Activity 7 Exercise 2
   */
  public void mirrorArms()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel origPixel = null;
    Pixel mirPixel = null;
    for(int row = 158; row < 191; row++)
    {
        for(int col = 104; col < 170; col++)
        {
            origPixel = pixels[row][col];
            mirPixel = pixels[191 - row + 191][col];
            mirPixel.setColor(origPixel.getColor());
        }
    }
    for(int row = 172; row < 196; row++)
    {
        for(int col = 239; col < 294; col++)
        {
            origPixel = pixels[row][col];
            mirPixel = pixels[196 - row + 196][col];
            mirPixel.setColor(origPixel.getColor());
        }
    }
  }
  
  /**
   * Mirrors the segall in the opposite direction in seagull.jpg
   * Activity 7 Exercise 3
   */
  public void mirrorGull()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel origPixel = null;
    Pixel mirPixel = null; 
    for(int row = 235; row < 321; row++)
    {
        for(int col = 238; col < 343; col++)
        {
            origPixel = pixels[row][col];
            mirPixel = pixels[row][343 - col + 343];
            mirPixel.setColor(origPixel.getColor());
        }
    }
  }
  
  /**
   * Enhanced version of the copy method
   * Activity 8 Exercise 1
   */
  public void copy2(Picture fromPic, int fromStartRow, int fromStartCol, 
                    int fromEndRow, int fromEndCol, int toStartRow, int toStartCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fromStartRow, toRow = toStartRow; 
         fromRow <= fromEndRow &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = fromStartCol, toCol = toStartCol; 
           fromCol <= fromEndCol &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  /**
   * Create a custom collage
   * Activity 8 Exercise 2
   */
  public void myCollage()
  {
      Picture seagullNegate = new Picture("seagull.jpg");
      seagullNegate.negate();
      Picture seagullGrayscale = new Picture("seagull.jpg");
      seagullGrayscale.grayscale();
      this.copy2(seagullNegate, 235, 238, 321, 343, 10, 10);
      Picture robot = new Picture("robot.jpg");
      robot.edgeDetection(10);
      this.copy(robot, 100, 100);
      this.copy2(seagullGrayscale, 100, 100, 200, 200, 400, 80);
      this.mirrorVertical();
      this.write("enhancedCollage.jpg");
  }
  
  /**
   * Edge Detection vertically and horizontally
   * Activity 9 Exercise 1
   */
  public void edgeDetection2(int edgeDist)
  {
      Picture reference = new Picture(this);
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel[][] pixelsOG = this.getPixels2D();
      Color rightColor = null;
      for(int row = 0; row < pixelsOG.length; row++)
      {
          for(int col = 0; col < pixelsOG[0].length -1; col++)
          {
              leftPixel = pixelsOG[row][col];
              rightPixel = pixelsOG[row][col+1];
              rightColor = rightPixel.getColor();
              if(leftPixel.colorDistance(rightColor) > edgeDist)
              {
                  leftPixel.setColor(Color.BLACK);
              } else {
                  rightPixel.setColor(Color.WHITE);
              }
          }
      }
      
      Pixel topPixel = null;
      Pixel botPixel = null;
      Color botColor = null;
      Pixel[][] pixelsTB = reference.getPixels2D();
      for(int row = 0; row < pixelsTB.length -1; row++)
      {
          for(int col = 0; col < pixelsTB[0].length; col++)
          {
              topPixel = pixelsTB[row][col];
              botPixel = pixelsTB[row+1][col];
              botColor = botPixel.getColor();
              if(topPixel.colorDistance(botColor) > edgeDist)
              {
                  pixelsOG[row][col].setColor(Color.BLACK);
              } else {
                  pixelsOG[row][col].setColor(Color.WHITE);
              }
          }
      }
      
  }
  
  /**
   * Alternate edge detection algorithm
   * Activity 9 Exercise 2
   */
  public void alternateEdgeDetection(int colorDifference)
  {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      int avgLeftColor = 0;
      int avgRightColor = 0;
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
          for(int col = 0; col < pixels[0].length - 1; col++)
          {
              leftPixel = pixels[row][col];
              avgLeftColor = (leftPixel.getRed() + leftPixel.getBlue() + leftPixel.getGreen()) / 3;
              rightPixel = pixels[row][col+1];
              avgRightColor = (rightPixel.getRed() + rightPixel.getBlue() + rightPixel.getGreen()) / 3;
              if(Math.abs(avgRightColor - avgLeftColor) > colorDifference)
              {
                  leftPixel.setColor(Color.BLACK);
              } else {
                  leftPixel.setColor(Color.WHITE);
              }
          }
      }
      
  }
} // this } is the end of class Picture, put all new methods before this
