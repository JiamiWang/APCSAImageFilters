import java.awt.*;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson
 * @author (Co) Jiaming Wang jiamingwang@spicycombo.net
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("guiou-square.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue()
  {
    Picture pic = new Picture("guiou-square.jpg");
    pic.explore();
    pic.keepOnlyBlue();
    pic.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
    Picture pic = new Picture("guiou-square.jpg");
    pic.explore();
    pic.keepOnlyGreen();
    pic.explore();
  }
  
  public static void testKeepOnlyRed()
  {
    Picture pic = new Picture("guiou-square.jpg");
    pic.explore();
    pic.keepOnlyRed();
    pic.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("guiou-square.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  public static void testGrayscale() {
      Picture image = new Picture("guiou-square.jpg");
      image.explore();
      image.grayscale();
      image.explore();
  }
    
  public static void testMirrorVertical()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVertical();
    beach.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }

  public static void testHorizontal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }
  
  public static void testHorizontalMirrorBottomToTop()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBottomToTop();
    beach.explore();
  }
  
  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  public static void testOnlyBlue() {
      Picture image = new Picture("guiou-square.jpg");
      image.explore();
      image.keepOnlyBlue();
      image.explore();
  }
  public static void testBoxBlur() {
      Picture image = new Picture("beach.jpg");
      image.explore();
      image.boxBlur(20);
      image.explore();
  }

  public static void testCircleBoxBlur(boolean background) {
      Picture image = new Picture("../images/beach.jpg");
      image.explore();
      image.boxBlurCircle(image.getHeight() / 2, image.getWidth() / 2,
              -1, -1, -1, -1, 100, 10, background);
      image.explore();
  }

  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("../images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    
    try {
       String currentPath = new java.io.File(".").getCanonicalPath();
       System.out.println("Current dir:" + currentPath);

       String currentDir = System.getProperty("user.dir");
       System.out.println("Current dir using System:" + currentDir);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Modify the code to print full stacktrace");
    }

    Picture guiou = new Picture("../images/guiou-square.jpg");
    guiou.explore();
//    guiou.jitterEdges(9, 16, 25);
    guiou.jitterEdges(9, 25);
    guiou.explore();
    guiou.explore();

//    testCircleBoxBlur(true);
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}