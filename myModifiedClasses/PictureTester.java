/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
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
    Picture swan = new Picture("swan.jpg");
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
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    testMirrorVertical();
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
  
  /**
   * Activity 5 Exercise 3 Tester
   */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /**
   * Activity 5 Exercise 4 Tester
   */
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /**
   * Activity 5 Exercise 5 Tester
   */
  public static void testGrayscale()
  {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.grayscale();
      beach.explore();
  }
  
  /**
   * Activity 5 Exercise 6 Tester
   */
  public static void testFixUnderwater()
  {
      Picture water = new Picture("water.jpg");
      water.explore();
      water.fixUnderwater();
      water.explore();
  }
  
  /** 
   * Activity 6 Exercise 1 Tester
  */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  /**
   * Activity 6 Exercise 2 Tester
   */
  public static void testMirrorHorizontal()
  {
      Picture arch = new Picture("arch.jpg");
      arch.explore();
      arch.mirrorHorizontal();
      arch.explore();
  }
  
  /**
   * Activity 6 Exercise 3 Tester
   */
  public static void testMirrorHorizontalBotToTop()
  {
      Picture arch = new Picture("arch.jpg");
      arch.explore();
      arch.mirrorHorizontalBotToTop();
      arch.explore();
  }
  
  /**
   * Activity 7 Exercise 2 Tester
   */
  public static void testMirrorArms()
  {
      Picture snowman = new Picture("snowman.jpg");
      snowman.explore();
      snowman.mirrorArms();
      snowman.explore();
  }
  
  /**
   * Activity 7 Exercise 3 Tester
   */
  public static void testMirrorGull()
  {
      Picture seagull = new Picture("seagull.jpg");
      seagull.explore();
      seagull.mirrorGull();
      seagull.explore();
  }
  
  /**
   * Activity 8 Exercise 1 Tester
   */
  public static void testCopy2()
  {
      Picture beach = new Picture("beach.jpg");
      Picture seagull = new Picture("seagull.jpg");
      beach.copy2(seagull, 235, 238, 321, 343, 300, 300);
      beach.explore();
  }
  /**
   * Activity 8 Exercise 2 Tester
   */
  public static void testMyCollage()
  { 
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /**
   * Activity 9 Exercises 1 and 2 Testers
   */
  public static void compareEdgeDetections()
  {
      
      Picture swanControl = new Picture("swan.jpg");
      swanControl.edgeDetection(10);
      swanControl.explore();
      
      Picture swanEdge2 = new Picture("swan.jpg");
      swanEdge2.edgeDetection2(10);
      swanEdge2.explore();
      
      Picture swanAlt = new Picture("swan.jpg");
      swanAlt.alternateEdgeDetection(10);
      swanAlt.explore();
      
      
  }
}