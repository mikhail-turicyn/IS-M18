/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dexample;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImagePanel extends javax.swing.JPanel {

    private BufferedImage displayImage;
    private BufferedImage originalImage;
    private Image image;

    public ImagePanel(URL imageURL) {
        image = Toolkit.getDefaultToolkit().createImage("F:\\cat.jpg");
        // create MediaTracker for image
        MediaTracker mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(image, 0);
        // wait for Image to load
        try {
            mediaTracker.waitForAll();
        } // exit program on error     
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } // create BufferedImages from Image 
        originalImage = new BufferedImage(image.getWidth(null),
                image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        displayImage = originalImage;
        // get BufferedImage’s graphics context 
        Graphics2D graphics = displayImage.createGraphics();
        graphics.drawImage(image, null, null);
    }    // end ImagePanel constructor

    // apply Java2DImageFilter to Image   
    public void applyFilter(Java2DImageFilter filter) {
        // process Image using Java2DImageFilter 
        displayImage = filter.processImage(displayImage);
        repaint();
    }

    // set Image to originalImage 
    public void displayOriginalImage() {
        displayImage = new BufferedImage(image.getWidth(null),
                image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = displayImage.createGraphics();
        graphics.drawImage(originalImage, null, null);
        repaint();
    }

    // draw ImagePanel 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(displayImage, 0, 0, null);
    }

    // get preferred ImagePanel size 
    public Dimension getPreferredSize() {
        return new Dimension(displayImage.getWidth(), displayImage.getHeight());
    }

    // get minimum ImagePanel size 
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
