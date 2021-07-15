package hla_jeddahproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        userEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/hotel.jpg"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Tekton Pro Ext", 2, 24)); // NOI18N
        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Email");

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
                    .addComponent(userEmail)
                    .addComponent(userPassword)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPasswordActionPerformed

    }//GEN-LAST:event_userPasswordActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*
        When the user clicks on Login 
        1- Check all the fildes are not empty
        2- Store user entered data into varaibles to deal with it 
        3- Iterate over (System Database.txt) and store the information for single 
           user into variables by each itreation and check for the entered email and 
           password if its matching with the one in the file break the loop and go to 
           the next page 
           if not matching read the next user information and so on until the end 
           of (System Database.txt) file 
        4- if match found transfer the user full name to the next frame to print welcome message 
           also transfer the current frame color to the next frame 
        5- Go to next page if match found otherwise display error message 
        Catching File and IO Errors 
         */
        boolean noEmpty = checkIsNotEmpty();
        String userEmail = this.userEmail.getText();
        String userPassword = this.userPassword.getText();
        boolean isFound = false;
        if (noEmpty) {
            try {
                Scanner input = new Scanner(new File("System Database.txt"));
                while (input.hasNext()) {
                    String fullName = input.nextLine();
                    String email = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String password = input.nextLine();
                    isFound = checkEmailAndPassowrd(userEmail, userPassword, email, password);
                    if (isFound) {
                        Welcome welcome = new Welcome();
                        welcome.getWelcomeLabel().setText("Welcome " + fullName);
                        welcome.getjPanel1().setBackground(jPanel1.getBackground());
                        welcome.setResizable(false);
                        welcome.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                }
                if (!isFound) {
                    JOptionPane.showMessageDialog(null, "Wrong Email OR Password");
                }
            } catch (FileNotFoundException exception) {
                System.out.println("File not found ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill all information");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField userEmail;
    private javax.swing.JPasswordField userPassword;
    // End of variables declaration//GEN-END:variables

    /*
     checkIsNotEmpty Method is for making sure that all required fildes are not Empty 
     returns true if all fildes are not empty 
     returns false if one or more fildes are empty 
     */
    private boolean checkIsNotEmpty() {
        return !userEmail.getText().isEmpty() && !userPassword.getText().isEmpty();
    }

    /*
     checkEmailAndPassowrd method is for making sure That the enterd email and password 
     are matching with the one registred in the (System Database.txt) file 
     return true if they are equal 
     return false if they are not equal 
     */
    private boolean checkEmailAndPassowrd(String userEmail, String userPassword, String email, String password) {
        return userEmail.equalsIgnoreCase(email) && userPassword.equals(password);
    }
}
