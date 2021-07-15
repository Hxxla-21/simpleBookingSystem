package hla_jeddahproject;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Signup extends javax.swing.JFrame {

    public Signup() {
        initComponents();

    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        fullName = new javax.swing.JTextField();
        userEmail = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/hotel.jpg"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Tekton Pro Ext", 2, 24)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Full Name:");

        jLabel3.setText("Email");

        jLabel4.setText("Phone Number");

        jLabel5.setText("Password");

        userPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullName)
                    .addComponent(userEmail)
                    .addComponent(phoneNumber)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(userPassword))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPasswordActionPerformed

    }//GEN-LAST:event_userPasswordActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*
        When the user clicks on Confirrm 
        1- Check all the fildes are not empty
        2- Store user entered data into varaibles to deal with it 
        3- Check if the email and phone are matching the correct regex
        4- Write the new user information into (System Database.txt) file
        Catching File and IO Errors 
        */
        boolean noEmpty = checkIsNotEmpty();
        if (noEmpty) {
            String fullName = this.fullName.getText();
            String email = userEmail.getText();
            String phoneNumber = this.phoneNumber.getText();
            String password = userPassword.getText();
            boolean checkPhoneEmail = checkPhoneAndEmail(email, phoneNumber);
            if (checkPhoneEmail) {
                try {
                    FileWriter fileWriter = new FileWriter("System Database.txt", true);
                    BufferedWriter bw = new BufferedWriter(fileWriter);
                    bw.write(fullName + "\n" + email + "\n" + phoneNumber + "\n" + password + "\n");
                    bw.close();
                    Login login = new Login();
                    login.getjPanel1().setBackground(jPanel1.getBackground());
                    login.setResizable(false);
                    login.setVisible(true);
                    this.setVisible(false);
                } catch (FileNotFoundException exception) {
                    System.out.println("File Not Found");
                } catch (IOException exception) {
                    System.out.println("File Wtrite Error");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill all information");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fullName;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JTextField userEmail;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables

    /*
     checkIsNotEmpty Method is for making sure that all required fildes are not Empty 
     returns true if all fildes are not empty 
     returns false if one or more fildes are empty 
     */
    private boolean checkIsNotEmpty() {
        return !fullName.getText().isEmpty() && !userEmail.getText().isEmpty()
                && !phoneNumber.getText().isEmpty() && !userPassword.getText().isEmpty();
    }

    /*
        checkPhoneAndEmail method is for making sure that the email and phone number
        are matching the specified regex for each one 
        return true if the email and phone number are correct 
        return false if one of them are mismatching the regex
     */
    private boolean checkPhoneAndEmail(String email,String phoneNumber) {
        String emReg = "[a-zA-Z]+@[a-zA-Z]+\\.com";
        String phoneReg = "^05\\d{8}+";
        if (!email.matches(emReg)) {
            JOptionPane.showMessageDialog(null, "Invalid Email");
        }
        if (!phoneNumber.matches(phoneReg)) {
            JOptionPane.showMessageDialog(null, "Invalid Phone number");
        }
        return email.matches(emReg) && phoneNumber.matches(phoneReg);
    }
}
