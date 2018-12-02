/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dexample;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.net.*;

// Java extension packages 
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Gorku
 */
public class Java2DExample extends JFrame {

    private JMenu filterMenu;
    private ImagePanel imagePanel;

    // image filters 
    private Java2DImageFilter invertFilter;
    private Java2DImageFilter sharpenFilter;

    // initialize JMenuItems 
    public Java2DExample() {
        super("Java 2D Image Processing Demo"); // create Java2DImageFilters 
        sharpenFilter = new SharpenFilter();
        invertFilter = new InvertFilter();

        // initialize ImagePanel
        imagePanel = new ImagePanel(Java2DExample.class.getResource("images/ajhtp.png"));

        // create JMenuBar     
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // create JMenu 
        filterMenu = new JMenu("Image Filters");
        filterMenu.setMnemonic('I');
        // create JMenuItem for displaying original Image 
        JMenuItem originalMenuItem = new JMenuItem("Display Original");
        originalMenuItem.setMnemonic('O');
        originalMenuItem.addActionListener(new ActionListener() {
            // show original Image 
            public void actionPerformed(ActionEvent action) {
                imagePanel.displayOriginalImage();
            }
        } // end anonymous inner class 
        );
// create JMenuItems for Java2DImageFilters 
        JMenuItem invertMenuItem = createMenuItem("Invert", 'I', invertFilter);
        JMenuItem sharpenMenuItem = createMenuItem("Sharpen", 'S', sharpenFilter);
// add JMenuItems to JMenu 
        filterMenu.add(originalMenuItem);
        filterMenu.add(invertMenuItem);
        filterMenu.add(sharpenMenuItem);
        // add JMenu to JMenuBar 
        menuBar.add(filterMenu);

        getContentPane().add(imagePanel, BorderLayout.CENTER);
    } // end Java2DExample constructor 
    // create JMenuItem and ActionListener for given filter 

    public JMenuItem createMenuItem(String menuItemName,
            char mnemonic, final Java2DImageFilter filter) {
        // create JMenuItem      
        JMenuItem menuItem = new JMenuItem(menuItemName);
        // set Mnemonic 
        menuItem.setMnemonic(mnemonic);
        menuItem.addActionListener(new ActionListener() {
            // apply Java2DImageFilter when MenuItem accessed 
            public void actionPerformed(ActionEvent action) {
                imagePanel.applyFilter(filter);
            }
        }
        // end anonymous inner class      
        );
        return menuItem;
    } // end method createMenuItem 
// start program

    public static void main(String[] args) {
        Java2DExample application = new Java2DExample();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
        application.pack();
        application.setVisible(true);
    }

}
