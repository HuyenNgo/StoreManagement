/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Account;
import controller.AccountController;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.WindowConstants;
/**
 *
 * @author huyen
 */
public class FManagement extends MyFrame {

    /**
     * Creates new form FManagement
     */
    public Account account;
    public ArrayList<MyFrame> queueForm=null;
    
    private static FManagement instance;
    public static FManagement getInstance(){
        if(instance==null)
        {
            instance=new FManagement();
            instance.queueForm=new ArrayList<>();
        }
        return instance;
    }
    private FManagement() {
        initComponents();
        SetIcon();
    }
    public void setAccount(Account acc)
    {
        this.account=acc;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSeachCategory = new javax.swing.JButton();
        btnSearchCustomer = new javax.swing.JButton();
        btnSearchProduct = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnImportProduct = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnReportInventory = new javax.swing.JButton();
        btnReportRevenue = new javax.swing.JButton();
        graphPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSearchProduct = new javax.swing.JMenuItem();
        menuSearchCustomer = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuReportInventory = new javax.swing.JMenuItem();
        menuReportRevenue = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(171, 0, 107));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý cửa hàng Moij");
        jLabel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(171, 0, 107));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra cứu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 204, 0))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSeachCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSeachCategory.setText("Tra cứu loại sản phẩm");
        btnSeachCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachCategoryActionPerformed(evt);
            }
        });

        btnSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchCustomer.setText("Tra cứu khách hàng");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        btnSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchProduct.setText("Tra cứu sản phẩm");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeachCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSeachCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(171, 0, 107));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lập phiếu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 204, 0))); // NOI18N

        btnImportProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImportProduct.setText("Lập phiếu nhập hàng");
        btnImportProduct.setName(""); // NOI18N
        btnImportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportProductActionPerformed(evt);
            }
        });

        btnBill.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBill.setText("Lập hóa đơn");
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnBill, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnImportProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnBill, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(171, 0, 107));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Báo cáo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 204, 0))); // NOI18N

        btnReportInventory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReportInventory.setText("Báo cáo tồn");
        btnReportInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportInventoryActionPerformed(evt);
            }
        });

        btnReportRevenue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReportRevenue.setText("Báo cáo doanh thu");
        btnReportRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportRevenueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportInventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnReportRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReportInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        graphPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chúc một ngày tốt lành", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        graphPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphPanelMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Images/bookbackground.jpg"))); // NOI18N

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Tra cứu");

        menuSearchProduct.setText("Sản phẩm");
        menuSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSearchProductActionPerformed(evt);
            }
        });
        jMenu1.add(menuSearchProduct);

        menuSearchCustomer.setText("Khách hàng");
        menuSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSearchCustomerActionPerformed(evt);
            }
        });
        jMenu1.add(menuSearchCustomer);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Báo cáo");

        menuReportInventory.setText("Báo cáo tồn");
        menuReportInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportInventoryActionPerformed(evt);
            }
        });
        jMenu2.add(menuReportInventory);

        menuReportRevenue.setText("Báo cáo doanh thu");
        menuReportRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportRevenueActionPerformed(evt);
            }
        });
        jMenu2.add(menuReportRevenue);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Giới thiệu");

        menuAboutUs.setText("Về chúng tôi");
        menuAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutUsActionPerformed(evt);
            }
        });
        jMenu3.add(menuAboutUs);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        graphPanel.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("Màn hình chính");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeachCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachCategoryActionPerformed
       addFormToQueue(FCategoryProduct.getInstance());
    }//GEN-LAST:event_btnSeachCategoryActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE );
        FManagement.getInstance().removeFormInQueue(FManagement.getInstance());
        FLogin.getInstance().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
       addFormToQueue(FCustomer.getInstance());
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
       addFormToQueue(FBill.getInstance());
    }//GEN-LAST:event_btnBillActionPerformed

    private void btnImportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportProductActionPerformed
      addFormToQueue(FImportProduct.getInstance());
    }//GEN-LAST:event_btnImportProductActionPerformed

    private void btnReportInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportInventoryActionPerformed
       
    }//GEN-LAST:event_btnReportInventoryActionPerformed

    private void btnReportRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportRevenueActionPerformed
       
    }//GEN-LAST:event_btnReportRevenueActionPerformed

    private void menuSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSearchProductActionPerformed
        // TODO add your handling code here:
        addFormToQueue(FProduct.getInstance());
    }//GEN-LAST:event_menuSearchProductActionPerformed

    private void menuSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSearchCustomerActionPerformed
        // TODO add your handling code here:
        addFormToQueue(FCustomer.getInstance());
    }//GEN-LAST:event_menuSearchCustomerActionPerformed

    private void menuReportInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportInventoryActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuReportInventoryActionPerformed

    private void menuReportRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportRevenueActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_menuReportRevenueActionPerformed

    private void menuAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutUsActionPerformed
        // TODO add your handling code here:
        addFormToQueue(FAboutUs.getInstance());
    }//GEN-LAST:event_menuAboutUsActionPerformed

    private void graphPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphPanelMouseClicked
        // TODO add your handling code here:
        //Graphics g = graphPanel.getGraphics();
        //g.drawLine(0, 0, 0, 200);
        //g.drawLine(0, 0, 200, 0);
    }//GEN-LAST:event_graphPanelMouseClicked

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        // TODO add your handling code here:
        
        addFormToQueue(FProduct.getInstance());
    }//GEN-LAST:event_btnSearchProductActionPerformed

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
            java.util.logging.Logger.getLogger(FManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FManagement.getInstance().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnImportProduct;
    private javax.swing.JButton btnReportInventory;
    private javax.swing.JButton btnReportRevenue;
    private javax.swing.JButton btnSeachCategory;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JMenuItem menuAboutUs;
    private javax.swing.JMenuItem menuReportInventory;
    private javax.swing.JMenuItem menuReportRevenue;
    private javax.swing.JMenuItem menuSearchCustomer;
    private javax.swing.JMenuItem menuSearchProduct;
    // End of variables declaration//GEN-END:variables

    public void addFormToQueue(MyFrame f){
        f.reload();
        f.addAction();
        f.setVisible(true);
        if(queueForm.size()>0)
            queueForm.get(queueForm.size()-1).setVisible(false);
        queueForm.add(f);
    }
    
    public void removeFormInQueue(MyFrame f){
        f.releaseAction();
        f.setVisible(false);
        queueForm.remove(f);
        if(queueForm.size()>0)
        {
            queueForm.get(queueForm.size()-1).releaseAction();
            queueForm.get(queueForm.size()-1).update();
            queueForm.get(queueForm.size()-1).addAction();
            queueForm.get(queueForm.size()-1).setVisible(true);
        }
    }

    @Override
    public void reload() {
        
    }

    @Override
    public void releaseAction() {

    }

    @Override
    public void update() {

    }

    @Override
    public void addAction() {

    }

    private void SetIcon() {
       
    }
}
