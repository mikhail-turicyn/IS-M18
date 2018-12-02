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
public class InvertFilter implements Java2DImageFilter {

    public BufferedImage processImage(BufferedImage image) {
        // create 256 color array and invert colors 
        byte[] invertArray = new byte[256];
        for (int counter = 0; counter < 256; counter++) {
            invertArray[counter] = (byte) (255 - counter);
        }

        // create filter to invert colors 
        BufferedImageOp invertFilter = new LookupOp(new ByteLookupTable(0, invertArray), null);

        // apply filter to displayImage 
        return invertFilter.filter(image, null);
    } // end method processImage
}
