/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photoeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alexander
 */
public class NewJFrame extends javax.swing.JFrame {
    private BufferedImage image;
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        setTitle("Фото фильтр");
        setSize(640, 480);
        setExtendedState(MAXIMIZED_BOTH);
         
        FileChooser = new javax.swing.JFileChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Clear = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        blur = new javax.swing.JMenuItem();
        sharpen = new javax.swing.JMenuItem();
        brighter = new javax.swing.JMenuItem();
        darker = new javax.swing.JMenuItem();
        edgeDetect = new javax.swing.JMenuItem();
        negative = new javax.swing.JMenuItem();
        grayscale = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        info = new javax.swing.JMenuItem();

        FileChooser.setDialogTitle("Мой открытый диалог");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));

        file.setText("Файл");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Открыть");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        file.add(Open);

        Clear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Clear.setText("Очистить");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        file.add(Clear);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Сохранить");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        file.add(Save);
        file.add(jSeparator1);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Выход");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        file.add(Exit);

        jMenuBar1.add(file);

        edit.setText("Редактировать");

        
        blur.setText("Размытость");
        blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blurActionPerformed(evt);
            }
        });
        edit.add(blur);

        sharpen.setText("Резкость");
        sharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sharpenActionPerformed(evt);
            }
        });
        edit.add(sharpen);

        


        jMenuBar1.add(edit);

        help.setText("Помощь");

        info.setText("О программе");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        help.add(info);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);
        
        // Прорисовка изображения.
        add(new JComponent() {
            public void paintComponent(Graphics g) {
                if (image != null) {
                    int Width;
                    int Height;
                    int w = this.getWidth();
                    int h = this.getHeight();
                    int wi = image.getWidth();
                    int hi = image.getHeight();
                    double k;

                    k = ((double) w)/wi; 
                    if (hi*k > h) 
                        k =((double) h)/hi;
                    Height = (int)(hi*k);
                    Width = (int)(wi*k);
                    
                    int gapH = (h - Height)/2;
                    int gapW = (w - Width)/2;
                    
                    g.drawImage(image, gapW, gapH, Width, Height, null);
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Clear = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        blur = new javax.swing.JMenuItem();
        sharpen = new javax.swing.JMenuItem();
        brighter = new javax.swing.JMenuItem();
        darker = new javax.swing.JMenuItem();
        edgeDetect = new javax.swing.JMenuItem();
        negative = new javax.swing.JMenuItem();
        grayscale = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        info = new javax.swing.JMenuItem();

        FileChooser.setDialogTitle("Мой открытый диалог");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(423, 310));

        file.setText("Файл");

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Открыть");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        file.add(Open);

        Clear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Clear.setText("Очистить");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        file.add(Clear);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Сохранить");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        file.add(Save);
        file.add(jSeparator1);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Выход");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        file.add(Exit);

        jMenuBar1.add(file);

        edit.setText("Редактировать");

        blur.setText("Размытость");
        blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blurActionPerformed(evt);
            }
        });
        edit.add(blur);

        sharpen.setText("Резкость");
        sharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sharpenActionPerformed(evt);
            }
        });
        edit.add(sharpen);

        brighter.setText("Ярче");
        brighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brighterActionPerformed(evt);
            }
        });
        edit.add(brighter);

        darker.setText("Темнее");
        darker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkerActionPerformed(evt);
            }
        });
        edit.add(darker);

        edgeDetect.setText("Обнаружение края");
        edgeDetect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edgeDetectActionPerformed(evt);
            }
        });
        edit.add(edgeDetect);

        negative.setText("Негатив");
        negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeActionPerformed(evt);
            }
        });
        edit.add(negative);

        grayscale.setText("Оттенки серого");
        grayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayscaleActionPerformed(evt);
            }
        });
        edit.add(grayscale);

        jMenuBar1.add(edit);

        help.setText("Помощь");

        info.setText("О программе");
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        help.add(info);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Открываем картинку
    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        JFileChooser jfc = new JFileChooser("C:\\Users\\a_v_k\\Desktop");
        String[] extensions = ImageIO.getReaderFileSuffixes();
        jfc.setFileFilter(new FileNameExtensionFilter("Image files", extensions));
        if (jfc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)  return;
        try
        {
            Image img = ImageIO.read(jfc.getSelectedFile());
            image = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            image.getGraphics().drawImage(img, 0, 0, null);
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        repaint();
    }//GEN-LAST:event_OpenActionPerformed

    // Очистка экрана от картинки
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        image = null;
        repaint();
    }//GEN-LAST:event_ClearActionPerformed

    // Сохраняем картинку
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        JFileChooser chooser = new JFileChooser("C:\\Users\\a_v_k\\Desktop");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(image,"jpg", chooser.getSelectedFile());
                JOptionPane.showMessageDialog(this, "Файл '" + chooser.getSelectedFile() + " сохранен");
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_SaveActionPerformed

    // Выход из программы
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    // Информация о программе
    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        JOptionPane.showMessageDialog(this, "Это курсовая работа студента ИС-Б14 Кузнецова Александра. С помощью данной программы можно применять некоторые фильтры к изображениям.");
    }//GEN-LAST:event_infoActionPerformed

    // Размытие
    private void blurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurActionPerformed
        float weight = 1.0f / 9.0f;
        float[] elements = new float[9];
        for (int i = 0; i < 9; i++)
        elements[i] = weight;
        convolve(elements);
    }//GEN-LAST:event_blurActionPerformed

    // Резкость 
    private void sharpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sharpenActionPerformed
        float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 5.f, -1.0f, 0.0f, -1.0f, 0.0f };
        convolve(elements);
    }//GEN-LAST:event_sharpenActionPerformed
    // Яркость
    private void brighterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brighterActionPerformed
        float a = 1.3f;
        float b = 1.0f;
        RescaleOp op = new RescaleOp(a, b, null);
        filter(op);
    }//GEN-LAST:event_brighterActionPerformed
    // Обнаружение краев
    private void darkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkerActionPerformed
        float a = 0.8f;
        float b = 1.0f;
        RescaleOp op = new RescaleOp(a, b, null);
        filter(op);
    }//GEN-LAST:event_darkerActionPerformed
    // Негатив
    private void edgeDetectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edgeDetectActionPerformed
        float[] elements = { 0.0f, -1.0f, 0.0f, -1.0f, 4.f, -1.0f, 0.0f, -1.0f, 0.0f };
        convolve(elements);
    }//GEN-LAST:event_edgeDetectActionPerformed

     // Оттенки серого
    private void negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeActionPerformed
        short[] negative = new short[256 * 1];
        for (int i = 0; i < 256; i++)
        negative[i] = (short) (255 - i);
        ShortLookupTable table = new ShortLookupTable(0, negative);
        LookupOp op = new LookupOp(table, null);
        filter(op);
    }//GEN-LAST:event_negativeActionPerformed

    // Уменьшение яркости
    private void grayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayscaleActionPerformed
        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                Color c = new Color(image.getRGB(x, y));
                int red = (int) (c.getRed() * 0.299);
                int green =(int) (c.getGreen() * 0.587);
                int blue = (int) (c.getBlue() *0.114);
                int sum = red+green+blue;
                Color newColor = new Color(sum, sum, sum);
                image.setRGB(x,y,newColor.getRGB());
            }
        }
        repaint();
    }//GEN-LAST:event_grayscaleActionPerformed

    
    // Применяем фильтр и перерисовываем картинку
    // @param op the image operation to apply
    private void filter(BufferedImageOp op) {
        if (image == null) return;
        image = op.filter(image, null);
        repaint();
    }
    
    // Применяем свертку и перерисовываем картинку
    // @param elements the convolution kernel (an array of 9 matrix elements)
    private void convolve(float[] elements) {
        Kernel kernel = new Kernel(3, 3, elements);
        ConvolveOp op = new ConvolveOp(kernel);
        filter(op);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Clear;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem blur;
    private javax.swing.JMenuItem brighter;
    private javax.swing.JMenuItem darker;
    private javax.swing.JMenuItem edgeDetect;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem grayscale;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem info;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem negative;
    private javax.swing.JMenuItem sharpen;
    // End of variables declaration//GEN-END:variables
}
