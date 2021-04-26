package com.gui.log;


import com.database.*;
import com.gui.working.Home;

import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Cary60_1
 */
public class Loading extends javax.swing.JFrame implements Runnable{
    int s=0;
    Thread thread;
    public static String username;
    List<EdxrfDB> edxrfs;
    List<Image> images;
    List<DataEntryDB> dataEntries;
    List<AccountSavePath> accountSavePaths;
    ManageAccountSavePath manageAccountSavePath;
    ManageAccount manageAccount;
    ManageImage manageImage;
    ManageEdxrfDB manageEdxrfDB;
    ManageDataEntryDB manageDataEntryDB;


    /**
     * Creates new form Loading
     */
    public Loading(String username) {
        super("Se încarcă");
        setResizable(false);
        initComponents();
        thread= new Thread((Runnable)this);
        this.username=username;
        manageAccount = new ManageAccount();
        manageAccountSavePath = new ManageAccountSavePath();
        manageImage = new ManageImage();
        manageEdxrfDB = new ManageEdxrfDB();
        manageDataEntryDB = new ManageDataEntryDB();
        edxrfs = manageEdxrfDB.listOfFiles(username);
        images = manageImage.listOfImages(username);
        dataEntries = manageDataEntryDB.listOfFiles(username);
        accountSavePaths = manageAccountSavePath.listOfPath(username);

    }

    public void setUploading(){
        setVisible(false);
        thread.start();
    }


    public void run(){
        try{
            for(int i=0;i<=200;i++){
                s=s+1;
                int max= progressBar.getMaximum();
                int value = progressBar.getValue();
                if(value<max){
                    progressBar.setValue(progressBar.getValue()+1);
                }else{
                    i=201;
                    setVisible(false);
                    if (edxrfs.size()==0 && images.size()==0 && dataEntries.size()==0 && accountSavePaths.size()==0) {
                        Home ob = new Home();
                        ob.setVisible(true);
                    }else{
                        Object[] options = {"Continuă cu Vechiul Raport", "Șterge Vechiul Raport"};
                        int n = JOptionPane.showOptionDialog(this,
                                "Dvs. deja aveți un Raport început. Doriți să continuați să redactați vechiul raport sau să îl ștergeți?",
                                "Întrebare",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[1]);
                        if(n==0) {
                            Home ob = new Home();
                            ob.setVisible(true);
                        }else{
                            for (int j = 0; j < edxrfs.size(); j++) {
                                manageEdxrfDB.deleteFiles(edxrfs.get(j).getEdxrfId());

                            }

                            for (int j = 0; j < images.size(); j++) {
                                manageImage.deleteFiles(images.get(j).getPhotoId());
                            }

                            for (int j = 0; j <dataEntries.size() ; j++) {
                                manageDataEntryDB.deleteData(dataEntries.get(j).getDataEntryId());
                            }

                            for (int j = 0; j < accountSavePaths.size(); j++) {
                                manageAccountSavePath.deleteFiles(accountSavePaths.get(j).getPathSaveId());
                            }
                            JOptionPane.showMessageDialog(null, "Toate datele au fost șterse din baza de date.");
                            Home ob = new Home();
                            ob.setVisible(true);

                        }
                    }
                }Thread.sleep(50);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Vă rugăm aşteptaţi...");

        progressBar.setStringPainted(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("#Raport EDXRF 1.2 ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(25, 25, 25))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(117, 117, 117))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(84, 84, 84))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

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
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loading(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration
}
