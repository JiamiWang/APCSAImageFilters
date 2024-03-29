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
 *
 * Modified by student for work submission on 03.25.2024
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author (Co) Jiaming Wang jiamingwang@spicycombo.net
 * @
 * @see DigitalPicture
 * @version 2.1a
 *
 */
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

  /** Grayscale the picture */
  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();

    for (int r = 0; pixels.length > r; r++) {
      for (int c = 0; pixels[r].length > c; c++) {
        Pixel cur = pixels[r][c];
        int average = (cur.getRed() + cur.getGreen() + cur.getBlue()) / 3;
        cur.setRed(average); cur.setGreen(average); cur.setBlue(average);
      }
    }
  }

  /** Reverse the colors in the picture */
  public void negate() {
    Pixel[][] pixels = this.getPixels2D();

    for (int r = 0; pixels.length > r; r++) {
      for (int c = 0; pixels[r].length > c; c++) {
        Pixel cur = pixels[r][c];
        cur.setRed(255 - cur.getRed());
        cur.setGreen(255 - cur.getGreen());
        cur.setBlue(255 - cur.getBlue());
      }
    }
  }

  /**
   * Mirrors diagonally across the entire image, best if used on a square image!!
   */
  public void mirrorDiagonal() {
    Pixel[][] pixels = this.getPixels2D();
    
    int length = pixels.length > pixels[0].length ? 
      pixels[0].length : pixels.length;
      
    for (int r = 0; length > r; r++) {
      for (int c = 0; r > c; c++) {
        pixels[c][r].setColor(pixels[r][c].getColor());
      }
    }

  }

  /**
   * Mirrors the entire image bottom to top
   */
  public void mirrorHorizontalBottomToTop() {
    Pixel[][] pixels = this.getPixels2D();
    
    for (int r = pixels.length / 2 - 1; 0 < r; r--) {
      for (int c = pixels[r].length - 1; 0 < c; c--) {
        pixels[r][c].setColor(
          pixels[pixels.length - r - 1][c].getColor()
        );
      }
    }
  }

  /**
   * Mirrors the whole image horizontally
   */
  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    
    for (int r = 0; pixels.length / 2 > r; r++) {
      for (int c = 0; pixels[r].length > c; c++) {
        pixels[pixels.length - r - 1][c].setColor(
          pixels[r][c].getColor()
        );
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

  /** Method that mirrors the pixels of a image from right to the left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = width / 2; col < width; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
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

  /** Method to set the red and the green values to 0 */
  public void keepOnlyBlue() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel [] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  /** Method to set the green and the blue values to 0 */
  public void keepOnlyRed() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel [] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setBlue(0);
        pixelObj.setGreen(0);
      }
    }
  }

  /** Method to set the red and the blue values to 0 */
  public void keepOnlyGreen() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel [] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        pixelObj.setRed(0);
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to make the image blurry as in box blur, as for the whole image
   * @param strength The intensity level of the box blur
   */
  public void boxBlur(int strength) {
    Pixel[][] pixels = this.getPixels2D().clone();
    Pixel[][] curImage = this.getPixels2D();
    
    for (int row = 0; pixels.length > row; row++) {
      for (int col = 0; pixels[row].length > col; col++) {
        boxBlurPixel(row, col, strength, pixels, curImage);
      }
    }
  }
  
  /**
   * Create the box blur effect as a circle.
   * @param centerX The x coordinate of the center coordinate.
   * @param centerY The y coordinate of the center coordinate
   * @param startX The x coordinate where this rectangular blur should start at (useful if blurBackground is set to true)
   * @param startY The y coordinate where this rectangular blur should start at (useful if blurBackground is set to true)
   * @param blurBackground Set to true if you want a clear circle with blurred background.
   * @param endX The x coordinate where this rectangular blur should end at (useful if blurBackground is set to true)
   * @param endY The y coordinate where this rectangular blur should end at (useful if blurBackground is set to true)
   * @param radius The radius of the circle to create
   * @param strength The strength level of the blur.
   */
  public void boxBlurCircle(int centerX, int centerY, int startX, int endX, int startY, int endY,
                                    int radius, int strength, boolean blurBackground) {
    Pixel[][] pixels = this.getPixels2D().clone();
    Pixel[][] curImage = this.getPixels2D();

    startX = Math.max(0, startX);
    startY = Math.max(0, startY);
    endX = Math.min(pixels.length, endX);
    endY = Math.min(pixels[0].length, endY);

    for (int row = startX; endX > row; row++) {
        for (int col = startY; endY > col; col++) {
            if (blurBackground ? 
                    (Math.pow(row-centerX, 2) + Math.pow(col-centerY, 2)) > Math.pow(radius, 2) :
                    (Math.pow(row-centerX, 2) + Math.pow(col-centerY, 2)) < Math.pow(radius, 2))
                        boxBlurPixel(row, col, strength, pixels, curImage);
        }
    }
  }
  
  /**
   *  Perform box blur on a single pixel
   * @param row The row/x coordinate of the pixel
   * @param col The column/y coordinate of the pixel
   * @param strength The intensity of the blur
   * @param pixels The copied, unaffected array containing data of the image
   * @param curImage The array to affect for the blur
   */
  public static void boxBlurPixel(int row, int col, int strength, Pixel[][] pixels, Pixel[][] curImage) {
    ArrayList<Pixel> surroundingPixels = new ArrayList<Pixel>();
    for (int r_offset = -strength; strength >= r_offset; r_offset++) {
      int r = row + r_offset;
        if (curImage[0].length > r && r >= 0) {
          for (int c_offset = -strength; strength >= c_offset; c_offset++) {
          int c = c_offset + col;
          if (curImage.length > c && c >= 0) {
            surroundingPixels.add(pixels[r][c]);
          }
        }
      }
    }
    
    int r = 0, g = 0, b = 0;
    
    for (Pixel pixel : surroundingPixels) {
      r += pixel.getRed();
      g += pixel.getGreen();
      b += pixel.getBlue();
    }
        
    r /= surroundingPixels.size();
    g /= surroundingPixels.size();
    b /= surroundingPixels.size();
        
    curImage[row][col].setRed(r);
    curImage[row][col].setBlue(b);
    curImage[row][col].setGreen(g);
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
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    * @param ignoreColor Pixel color to ignore
      when copying over the image
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol, Color ignoreColor)
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
        if (ignoreColor != null && fromPixel.getColor().equals(ignoreColor)) continue;
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
    this.copy(flower1,0,0, null);
    this.copy(flower2,100,0, null);
    this.copy(flower1,200,0, null);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0, null);
    this.copy(flower1,400,0, null);
    this.copy(flower2,500,0, null);
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

  /**
   * Creates a random jitter effect
   * @param maximum The maximum length from a pixel to affect
   * */
  public void randomJitter(int maximum) {
    Pixel[][] pixels = this.getPixels2D();

    for (int r = 0; r < pixels.length; r++) {
      for (int c = 0; c < pixels[r].length; c++) {
        int right = (int) (Math.random() * maximum);
        while (c + right >= pixels[r].length) {
          right = (int) (Math.random() * maximum);
        }
        pixels[r][c].setColor(pixels[r][c + right].getColor());
      }
    }
  }

  /**
   * Combine the filters edgeDetection, and randomJitter to create an effect
   * @param edgeStrength The parameter to be passed to edgeDetection
   * @param jitterMax The jitter distance to be passed to randomJitter
   */
  public void jitterEdges(int edgeStrength, int jitterMax) {
    Picture edge = new Picture(this);
    edge.edgeDetection(edgeStrength);

    this.copy(edge, 0, 0, Color.WHITE);

//    this.boxBlurCircle(494, 1008,
//            0, mainGuiou.getWidth() - 1, 0, mainGuiou.getHeight() -1,
//            300, 5, false);
    this.randomJitter(jitterMax);
  }

  public static void main(String[] args)
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }


} // this } is the end of class Picture, put all new methods before this
