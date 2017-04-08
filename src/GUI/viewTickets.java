package GUI;

import Classes.Commuter;
import Classes.Ticket;
import Classes.Warrant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class viewTickets extends JFrame implements ActionListener, MouseListener {

    private Object[][] viewTickets;
    private Object[][] viewWarrants;
    private Object[][] viewCommuter;
    private Object[][] viewOfficer;
    private ArrayList<Commuter> tmpCommuter;    
    private String trn;
    
    public viewTickets() {
        initComponents();
        registerListeners();
        windowProperties();
        getTickets();
        getWarrants();
    }
    
    public void registerListeners() {
        btnFilterTrn.addActionListener(this);
        tblWarrants.addMouseListener(this);
        menuLogout.addActionListener(this);
    }
    
     public void windowProperties() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void getTickets() {
        Ticket vwTck = new Ticket();
        viewTickets = vwTck.viewAllTicket();
        
        String[] columnNames = {"TicketNum", "Description", "Location", "TotalDue", "TRN", "Badge", "Issue Date", "Court Date", "Status"};
        DefaultTableModel ticketModel = new DefaultTableModel(viewTickets, columnNames) { };
        tblTickets.setModel(ticketModel);
    }
    
    public void getWarrants() {
        Warrant war = new Warrant();
        viewWarrants = war.viewWarrants();
        
        String[] columnNames = {"TRN", "Offence", "TicketNum"};
        DefaultTableModel warrantModel = new DefaultTableModel(viewWarrants, columnNames) { };
        tblWarrants.setModel(warrantModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblWarrants = new javax.swing.JTable();
        txtFIlterTrn = new javax.swing.JTextField();
        btnFilterTrn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblTrn = new javax.swing.JLabel();
        lblPlate = new javax.swing.JLabel();
        lblViewName = new javax.swing.JLabel();
        lblViewTrn = new javax.swing.JLabel();
        lblViewPlate = new javax.swing.JLabel();
        lblViewBal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNwTicket = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuLogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TicketNum", "Description", "Location", "TotalDue", "TRN", "Badge", "Issue Date", "Court Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTickets);

        jTabbedPane1.addTab("Tickets", jScrollPane3);

        tblWarrants.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "TRN", "Offence", "TicketNum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblWarrants);

        jTabbedPane1.addTab("Warrants", jScrollPane4);

        btnFilterTrn.setText("View Tickets");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Commutor Information");

        lblName.setText("Name:");

        lblTrn.setText("TRN:");

        lblPlate.setText("Plate #:");


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel1, Alignment.LEADING)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblName, Alignment.LEADING)
        						.addComponent(lblTrn, Alignment.LEADING))
        					.addGap(66)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblViewTrn, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(lblViewName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGap(2))))
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addComponent(lblPlate)
        					.addGap(58)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblViewBal, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblViewPlate, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblName)
        				.addComponent(lblViewName))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblTrn)
        				.addComponent(lblViewTrn))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPlate)
        				.addComponent(lblViewPlate))
        			.addGap(18)
        			.addComponent(lblViewBal)
        			.addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jMenu1.setText("File");

        menuNwTicket.setText("New Ticket");
        jMenu1.add(menuNwTicket);
        jMenu1.add(jSeparator1);

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtFIlterTrn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFilterTrn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFIlterTrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterTrn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuLogoutActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilterTrn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPlate;
    private javax.swing.JLabel lblTrn;
    private javax.swing.JLabel lblViewBal;
    private javax.swing.JLabel lblViewName;
    private javax.swing.JLabel lblViewPlate;
    private javax.swing.JLabel lblViewTrn;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuNwTicket;
    private javax.swing.JTable tblTickets;
    private javax.swing.JTable tblWarrants;
    private javax.swing.JTextField txtFIlterTrn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //View Ticket for specific Commutor
        if (e.getSource().equals(btnFilterTrn)) {
            trn = txtFIlterTrn.getText();
                if (trn.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Please Enter a Valid TRN"); 
                } else {
                    viewTicketsTRN vwTKTRN = new viewTicketsTRN();
                    vwTKTRN.getTickets(Integer.parseInt(trn));
                    txtFIlterTrn.setText("");
                    vwTKTRN.setVisible(true);
                }            
        }
        
        if (e.getSource().equals(menuLogout)) {
            this.dispose();
            JOptionPane.showMessageDialog(rootPane, "Logged Out"); 
            login log = new login();
            log.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int c, d = 0;
        if (e.getClickCount() == 1) {
            int col = tblWarrants.getSelectedColumn();
            int row = tblWarrants.getSelectedRow();
            String trrn = (String) tblWarrants.getModel().getValueAt(row, col);
            
            Commuter com = new Commuter();
            tmpCommuter = com.viewCommutor(trrn);
            for (Commuter n:tmpCommuter) {
               lblViewTrn.setText(n.getTRN()); 
               lblViewName.setText(n.getFirstName() + " " + n.getLastName());
               lblViewPlate.setText(n.getPlateNumber());
            }            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}