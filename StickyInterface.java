//BJordon

package stickynote;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StickyInterface extends javax.swing.JFrame {

    public StickyInterface() {
        initComponents();
    }
                      
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TimeCreated = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textbox = new javax.swing.JTextArea();
        saveNote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java StickyNote");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(240, 240, 102));
        setMaximumSize(new java.awt.Dimension(345, 291));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(240, 240, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(345, 291));

        TimeCreated.setBackground(new java.awt.Color(240, 240, 102));
        TimeCreated.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); 
        TimeCreated.setText("Time Created:");

        jScrollPane1.setBackground(new java.awt.Color(240, 240, 102));
        jScrollPane1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); 

        textbox.setBackground(new java.awt.Color(240, 240, 102));
        textbox.setColumns(20);
        textbox.setFont(new java.awt.Font("MS PGothic", 0, 14)); 
        textbox.setLineWrap(true);
        textbox.setRows(5);
        textbox.setText("TEXT HERE");
        textbox.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textbox);

        saveNote.setBackground(new java.awt.Color(240, 240, 102));
        saveNote.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); 
        saveNote.setText("Save Note");
        saveNote.setBorderPainted(false);
        saveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNoteActionPerformed(evt);
            }
        });
        saveNote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saveNoteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveNote))))
                    .addComponent(TimeCreated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimeCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveNote)
                .addContainerGap())
        );

        TimeCreated.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );


        pack();
    }                                                     

    private void saveNoteActionPerformed(java.awt.event.ActionEvent evt) {                                         

        
        String textEntered = textbox.getText();
        Date now = Calendar.getInstance().getTime();
        TimeCreated.setText("Time Created: " + now);
    	//Save file as note.txt

            File file = new File("note.txt");
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(file));
                    out.write(textEntered);
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    System.out.println("Error saving");
                }
    }                                        

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StickyInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StickyInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StickyInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StickyInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StickyInterface().setVisible(true);
            }
        });
    }
         
    private javax.swing.JLabel TimeCreated;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveNote;
    private javax.swing.JTextArea textbox;
                  
}
