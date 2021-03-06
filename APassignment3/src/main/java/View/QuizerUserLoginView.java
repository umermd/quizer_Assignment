/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import DAO.UserDao;
import Entity.User;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
/**
 *
 * @author Muhammad Umer
 */
public class QuizerUserLoginView extends javax.swing.JFrame {

    /**
     * Creates new form QuizerUserLoginView
     */
    public QuizerUserLoginView() {
        initComponents();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernamefield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        adduserbutton = new javax.swing.JButton();
        passwordfield = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(usernamefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 104, 223, -1));

        jLabel1.setText("User Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 107, -1, -1));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 133, -1, -1));

        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(loginbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 161, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Login");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 110, 32));

        adduserbutton.setText("Add User");
        adduserbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduserbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(adduserbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 161, -1, -1));
        getContentPane().add(passwordfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 130, 223, -1));

        setSize(new java.awt.Dimension(545, 257));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        // TODO add your handling code here:
        User usr=new User(usernamefield.getText(),passwordfield.getText());
        UserDao ud=new UserDao();
        User newuser=ud.getUser(usr);
        if(newuser.getUserName()==null){
            JOptionPane.showMessageDialog(null, "Username or Password incorrect!");
        }
        else if(("Instructor".equals(newuser.getRole()))||"instructor".equals(newuser.getRole())){
            JOptionPane.showMessageDialog(null,"Login Successful!");
            QuizerUserLoginView.this.dispose();
            InstructorView iv=new InstructorView();
            iv.setVisible(true);
            
        }
        else if(("Student".equals(newuser.getRole()))||"student".equals(newuser.getRole())){
            JOptionPane.showMessageDialog(null,"Login Successful!");
            QuizerUserLoginView.this.dispose();
            StudentView sv=new StudentView();
            sv.setVisible(true);
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void adduserbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduserbuttonActionPerformed
        // TODO add your handling code here:
        AddUserView auv=new AddUserView();
        auv.setVisible(true);
    }//GEN-LAST:event_adduserbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(QuizerUserLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizerUserLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizerUserLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizerUserLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizerUserLoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adduserbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}
