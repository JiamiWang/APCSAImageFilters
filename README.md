# APCSAImageFilters
Run the `class/PictureTester.java` class to see a complete picture of something!
## Known Issues
* TODO: At the time of writing starting at the line 226, method setUpPreviousAndNextButtons() when invoked should also be including a gif image for the icons when changing the coordinate in the gui. However, it throws the below exception instead. This is not an urgent issue and does not need to be fixed immediately. (edit 1) It looks like other people do not have this issue after importing the project to replit. Looks like I messed up something when making the commit via Git.
```Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.net.URL.toString()" because "url" is null
    at java.desktop/sun.awt.SunToolkit.getImageFromHash(SunToolkit.java:699)
    at java.desktop/sun.awt.SunToolkit.getImage(SunToolkit.java:735)
    at java.desktop/javax.swing.ImageIcon.<init>(ImageIcon.java:215)
    at PictureExplorer.setUpNextAndPreviousButtons(PictureExplorer.java:229)
    at PictureExplorer.createLocationPanel(PictureExplorer.java:329)
    at PictureExplorer.createInfoPanel(PictureExplorer.java:413)
    at PictureExplorer.createWindow(PictureExplorer.java:212)
    at PictureExplorer.<init>(PictureExplorer.java:109)
    at SimplePicture.explore(SimplePicture.java:422)
    at PictureTester.testCircleBoxBlur(PictureTester.java:114)
    at PictureTester.main(PictureTester.java:164)```
