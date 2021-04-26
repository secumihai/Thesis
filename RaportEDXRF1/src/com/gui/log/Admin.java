package com.gui.log;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.database.Account;
import com.database.ManageAccount;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Cary60_1
 */
public class Admin extends javax.swing.JFrame implements Runnable{
    private int hour,minutes,seconds;
    private ManageAccount manageAccount;
    private Thread t=null;

    /**
     * Creates new form Admin
     */
    public Admin() {
        super("Admin");
        setResizable(false);
        manageAccount = new ManageAccount();
        initComponents();
        showUser();
        currentDate();
        t= new Thread(this);
        t.start();
    }

    public void showUser(){
        List<Account> list = manageAccount.listUsers();
        Object[] row = {"Utilizator", "Nume şi Prenume", "Accept"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i <list.size() ; i++) {
            if(!(list.get(i).getUserName().equals("admin"))){
                row[0]= list.get(i).getUserName();
                row[1] = list.get(i).getName();
                row[2]= list.get(i).isAccept();
                model.addRow(row);
            }
        }
        jTable1.setModel(model);
        model.fireTableDataChanged();
    }

    public void currentDate(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year =  cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        dateTxt.setText(String.format("Data : %02d/%02d/%04d",day,(month+1),year));

      /*  int seconds = cal.get(Calendar.SECOND);
        int minutes =  cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);

        timeTxt.setText(String.format("   Ora: %02d:%02d:%02d",hour,minutes,seconds));*/

    }

    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        updateMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closeMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        backjMenuItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        deleteMenuItem = new javax.swing.JMenuItem();
        dateTxt = new javax.swing.JMenu();
        timeTxt = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Utilizator", "Nume şi Prenume", "Accept"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(60);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Administrare", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        updateBtn.setText("Actualizare Date");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        backBtn.setText("Înapoi");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        deleteBtn.setText("Şterge Utilizator");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(deleteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        jMenu1.setForeground(new java.awt.Color(153, 0, 153));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14));

        updateMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        updateMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        updateMenuItem.setText("Actualizare Date");
        updateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(updateMenuItem);
        jMenu1.add(jSeparator1);

        closeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        closeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        closeMenuItem.setText("Close");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(closeMenuItem);
        jMenu1.add(jSeparator2);

        backjMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        backjMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        backjMenuItem.setText("Înapoi");
        backjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(backjMenuItem);

        jMenuBar1.add(jMenu1);

        EditMenu.setForeground(new java.awt.Color(153, 0, 153));
        EditMenu.setText("Edit");
        EditMenu.setFont(new java.awt.Font("Segoe UI", 1, 14));

        deleteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        deleteMenuItem.setText("Şterge Utilizator");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(deleteMenuItem);

        jMenuBar1.add(EditMenu);

        dateTxt.setForeground(new java.awt.Color(153, 0, 153));
        dateTxt.setText("Data");
        dateTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(dateTxt);

        timeTxt.setForeground(new java.awt.Color(153, 0, 153));
        timeTxt.setText("Timpul");
        timeTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(timeTxt);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int row= jTable1.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Nu aţi selectat nici un utilizator",
                    "Lipsesc Date", JOptionPane.WARNING_MESSAGE);
        }else {
            String cell = jTable1.getModel().getValueAt(row, 0).toString();
            try {
                Object[] options = {"Da", "Nu"};
                int n = JOptionPane.showOptionDialog(this,
                        "Doriţi să ştergeţi utilizatorul " +cell+"?",
                        "Întrebare",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);
                if(n==0) {
                    JOptionPane.showMessageDialog(null, "Utilizatorul "+cell+" a fost şters din Baza de Date!!!");
                    manageAccount.deleteUser(cell);
                    showUser();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try{
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for(int i=0;i<model.getRowCount();i++) {
                if ((boolean)(model.getValueAt(i, 2))==true){
                    manageAccount.updateUserStatus(model.getValueAt(i, 0).toString(), true);
                }else{
                    manageAccount.updateUserStatus(model.getValueAt(i, 0).toString(), false);
                }
            }
            JOptionPane.showMessageDialog(null, "Baza de Date a fost actualizată!!!");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Object[] options = {"Da", "Nu"};
        int n = JOptionPane.showOptionDialog(this,
                "Doriţi să ieşiţi? ",
                "Întrebare",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if(n==0) {
            close();
        }
    }

    private void updateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        updateBtnActionPerformed(evt);
    }

    private void backjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
    }

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        deleteBtnActionPerformed(evt);
    }

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setVisible(false);
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenu EditMenu;
    private javax.swing.JButton backBtn;
    private javax.swing.JMenuItem backjMenuItem;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenu dateTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu timeTxt;
    private javax.swing.JButton updateBtn;
    private javax.swing.JMenuItem updateMenuItem;
    // End of variables declaration


    @Override
    public void run() {
        try {
            while (true) {
                Calendar cal = new GregorianCalendar();
                seconds = cal.get(Calendar.SECOND);
                minutes = cal.get(Calendar.MINUTE);
                hour = cal.get(Calendar.HOUR);

                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = cal.getTime();
                String time = dateFormat.format(date);
                timeTxt.setText(" Ora: " + time);
                t.sleep(10);
            }
        }catch (Exception e){}
    }
}
