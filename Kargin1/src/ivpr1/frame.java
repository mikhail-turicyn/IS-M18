/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ivpr1;
import java.awt.Toolkit; 
import java.awt.event.WindowEvent; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import javax.swing.DefaultListModel; 
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Граф Де Бюси
 */
public class frame extends javax.swing.JFrame {
    DefaultListModel Dm = new DefaultListModel();
 
    public frame() {
        initComponents();
        Licer1();
        Licer2();
        Licer3();
        
       
        
    }
    public String kolvo1; // путь к директории из которой требуется взять файлы 
    public String kolvo2;
    public String kolvo3;
    public String kolvo4;
    public String kolvo5;
    public int x;
    public int y;
    public int z;
    public int l;
    public int k;
                    
    public int x1;
    public int y1;
    public int z1;
    public int l1;
    public int k1;
    public int r1;
    public int t1;
                            
    public String helper1 = "";
    public String helper = "";
    public String helper2 = "";
    public String helper3 = "";
    public String helper4 = "";
    public String helper11 = "";
    public String helpere = "";
    public String helper21 = "";
    public String helper31 = "";
    public String helper41 = "";
    public String helper51 = "";
    public String helper61 = "";
    public String chak = "";
    public String chak1 = "";
    
     private void add (String name){
     jList1.setModel(Dm);
     Dm.addElement(name);
     }
     private void Licer1() {
        try{
    Class.forName("org.sqlite.JDBC");
    Connection c = DriverManager.getConnection("jdbc:sqlite:G://TT.db");
    Statement s = c.createStatement();
    String querry = "select Направленность from Вид_специальности";
    ResultSet rs = s.executeQuery(querry);
    while (rs.next()) {
    String kolvo2 = rs.getString("Направленность");
    jComboBox3.addItem(kolvo2);}
    } catch (Exception e) {};
   
     
    
         }
     private void Licer2() {
         
        try{
    Class.forName("org.sqlite.JDBC");
    Connection c = DriverManager.getConnection("jdbc:sqlite:G://TT.db");
    Statement s = c.createStatement();
    String querry = "select Образование from Предыдущее_образование";
    ResultSet rs = s.executeQuery(querry);
    while (rs.next()) {
    String kolvo3 = rs.getString("Образование");
    jComboBox2.addItem(kolvo3);
    
    
     
    }
        } catch (Exception e) {}; }
     private void Licer3() {
        try{
    Class.forName("org.sqlite.JDBC");
    Connection c = DriverManager.getConnection("jdbc:sqlite:G://TT.db");
    Statement s = c.createStatement();
    String querry = "select Сумма from Заработная_плата";
    ResultSet rs = s.executeQuery(querry);
    while (rs.next()) {
    String kolvo4 = rs.getString("Сумма");
    jComboBox4.addItem(kolvo4);
    }
        } catch (Exception e) {};
      
     
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jLabel1.setFont(new java.awt.Font("a_AntiqueTradyRgh", 0, 24)); // NOI18N
        jLabel1.setText("Тест на профпригодность");

        jLabel3.setText("Твоё образование");

        jLabel4.setText("Твоя желаемая направленность");

        jLabel5.setText("Желаемая заработная плата");

        jButton1.setText("Проверить!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Добавить свои значения");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Для работодателя");

        jTextField1.setText("Укажите свои качества");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Дополнительно");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(148, 148, 148)
                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(127, 127, 127)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(211, 211, 211)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(279, 279, 279)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Dm.clear();
jList1.setModel(Dm);
String rekolvo2 = jComboBox2.getSelectedItem().toString();
String rekolvo3 = jComboBox3.getSelectedItem().toString();
String rekolvo4 = jComboBox4.getSelectedItem().toString();
       if (rekolvo3.equals("Не имеет значения") ){
        try{
    Class.forName("org.sqlite.JDBC");
    Connection c = DriverManager.getConnection("jdbc:sqlite:G://TT.db");
    Statement s = c.createStatement();
    String querry = "select Имя_профессии from Профессии where Предыдущее_образование like ('"+rekolvo2+"') and Заработная_плата like ('"+rekolvo4+"') ";
    ResultSet rs = s.executeQuery(querry);
 while (rs.next()) {
    String kolvo5 = rs.getString("Имя_профессии");
    System.out.println(kolvo5);
        
        
      String Vivod = "Предлагаемая профессия: "+kolvo5+"";
       add (Vivod);
       
    }
 
  
 } catch (Exception e) {}
        
     
       }
       else {
       try{
    Class.forName("org.sqlite.JDBC");
    Connection c = DriverManager.getConnection("jdbc:sqlite:G://TT.db");
    Statement s = c.createStatement();
    String querry = "select Имя_профессии from Профессии where Предыдущее_образование like ('"+rekolvo2+"') and Заработная_плата like ('"+rekolvo4+"') and Вид_специализации like ('"+rekolvo3+"') ";
    ResultSet rs = s.executeQuery(querry);
 while (rs.next()) {
    String kolvo5 = rs.getString("Имя_профессии");
    System.out.println(kolvo5);
        
       String Vivod = "Предлагаемая профессия: "+kolvo5+"";
      add (Vivod);
    }
 } catch (Exception e) {}
      
        
       }
       chak = jComboBox3.getSelectedItem().toString();
     if (chak.equals("Творческая") ) {
         x=x+1;
         helper= "Творческая";
     }
     if (chak.equals("Техническая") ) {
         y=y+1;
          helper1= "Техническая";
     }
     if (chak.equals("Химико-биологическая") ) {
         z=z+1;
          helper2= "Химико-биологическая";
     }
     if (chak.equals("Менеджмент") ) {
         l=l+1;
          helper3= "Менеджмент";
     }
     if (chak.equals("Социальная") ) {
         k=k+1;
          helper4= "Социальная";
     }
 chak1 = jComboBox4.getSelectedItem().toString();
     if (chak1.equals("8 000 - 10 000") ) {
         x1=x1+1;
         helpere= "8 000 - 10 000";
     }
     if (chak1.equals("10 000 - 17 000") ) {
         y1=y1+1;
         helper11= "10 000 - 17 000";
     }
     if (chak1.equals("17 000 - 25 000") ) {
         z1=z1+1;
         helper21= "17 000 - 25 000";
     }
     if (chak1.equals("25 000 - 40 000") ) {
         l1=l1+1;
         helper31= "25 000 - 40 000";
     }
     if (chak1.equals("40 000 - 80 000") ) {
         k1=k1+1;
         helper41= "40 000 - 80 000";
     }
     if (chak1.equals("80 000 - 120 000") ) {
         r1=r1+1;
         helper51= "80 000 - 120 000";
     }
     if (chak1.equals("120 000 - ...") ) {
         t1=t1+1;
         helper61= "120 000 - ...";
     }
 
       if (x>y && x>z && x>l && x>k){
        jLabel6.setText("Также часто вводят '"+helper+"'");
        };
        if (y>x && y>z && y>l && y>k){
        jLabel6.setText("Также часто вводят '"+helper1+"'");
        };
        if (z>y && z>x && z>l && z>k){
        jLabel6.setText("Также часто вводят '"+helper2+"'");
        };
        if (l>y && l>z && l>x && l>k){
        jLabel6.setText("Также часто вводят '"+helper3+"'");
        };
        if (k>y && k>z && k>l && k>x){
        jLabel6.setText("Также часто вводят '"+helper4+"'");
        };
        if (x1>y1 && x1>z1 && x1>l1 && x1>k1 && x1>r1 && x1>t1){
        jLabel7.setText("Также часто вводят '"+helpere+"'");
        };
        if (y1>x1 && y1>z1 && y1>l1 && y1>k1 && y1>r1 && y1>t1){
        jLabel7.setText("Также часто вводят '"+helper11+"'");
        };
       if (z1>y1 && z1>x1 && z1>l1 && z1>k1 && z1>r1 && z1>t1){
        jLabel7.setText("Также часто вводят '"+helper21+"'");
        };
        if (l1>y1 && l1>z1 && l1>x1 && l1>k1 && l1>r1 && l1>t1){
        jLabel7.setText("Также часто вводят '"+helper31+"'");
        };
        if (k1>y1 && k1>z1 && k1>l1 && k1>x1 && k1>r1 && k1>t1){
        jLabel7.setText("Также часто вводят '"+helper41+"'");
        };
        if (r1>y1 && r1>z1 && r1>l1 && r1>k1 && r1>x1 && r1>t1){
        jLabel7.setText("Также часто вводят '"+helper51+"'");
        };
        if (t1>y1 && t1>z1 && t1>l1 && t1>k1 && t1>r1 && t1>x1){
        jLabel7.setText("Также часто вводят '"+helper61+"'");
        };
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       frame1 liciy = new frame1();
       liciy.setVisible(true);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
