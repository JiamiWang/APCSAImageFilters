# APCSAImageFilters
<p align="left">
    <a href="https://java.com">
        <img src="https://img.shields.io/badge/made%20with-java-blue" 
            alt="made with java"></a>
</p>
Run the `class/PictureTester.java` class to see a complete picture of something!
## Project information
The main file is `PictureTester.java`. Please modify the main method there to change the filters you would like to use.
## How do I run this?
* If you are in Replit,  **AND** that you have enough memory, you can simply click on the button and run.
* If using IntelliJ, a run configuration has already been created for you. You can simply press run.
* If using BlueJ, a run configuration has already been created for you. You can simply press run.
* **NOTE:** You may need to change the directory path, depending on what you are using to run the project.
## Known Issues
* TODO: At the time of writing starting at the line 226, method setUpPreviousAndNextButtons() when invoked should also 
be including a gif image for the icons when changing the coordinate in the gui. However, it throws the below 
exception instead. This is not an urgent issue and does not need to be fixed immediately. (edit 1) It looks like 
other people do not have this issue after importing the project to replit. Looks like I messed up something when 
making the commit via Git.
```
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.net.URL.toString()" because "url" is null
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
    at PictureTester.main(PictureTester.java:164)
```
## Notice from the cook
I'm trying to make this as funny and Joe Biden Connect as possible. Btw, I spent a lot of time trying to figure out why 
code simply breaks on Replit, and attempting to use Git properly... So, initially this was all busy work. I guess I 
learned something from it though. If you want to know more about something, **let me know**. 