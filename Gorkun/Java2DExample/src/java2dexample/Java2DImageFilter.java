
package java2dexample;

import java.awt.*;
import java.awt.image.*;

public interface Java2DImageFilter {
    // apply filter to Image 

    public BufferedImage processImage(BufferedImage image);
}
