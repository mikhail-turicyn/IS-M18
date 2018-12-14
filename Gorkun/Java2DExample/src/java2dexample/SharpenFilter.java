/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dexample;

import java.awt.image.*;

/**
 *
 * @author Gorku
 */
public class SharpenFilter implements Java2DImageFilter {

    // apply edge-sharpening filter to BufferedImage 
    public BufferedImage processImage(BufferedImage image) {
// array used to detect edges in image 
        float[] sharpenMatrix = {0.0f, -1.0f, 0.0f, 
                                -1.0f, 5.0f, -1.0f, 
                                 0.0f, -1.0f, 0.0f};
        // create filter to sharpen edges 
        BufferedImageOp sharpenFilter = new ConvolveOp(new Kernel(3, 3, sharpenMatrix), ConvolveOp.EDGE_NO_OP, null);
        // apply sharpenFilter to displayImage       
        return sharpenFilter.filter(image, null);
    } // end method processImage
}
