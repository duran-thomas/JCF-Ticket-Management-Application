package GUI;

import Classes.Commuter;
import Classes.Officer;
import Classes.Ticket;
import Classes.Warrant;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.JTextComponent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class adminDesk extends JFrame {
    
    private Object[][] tmpOfficerView;
    private Object[][] tmpCommuterView;
    
    public adminDesk() {        
        setWindowProperties();
        initComponents();
        registerListeners();
        getOfficerInfo();
        //hidePasswords();
        getCommuterInfo();
    }
    
    public void hidePasswords() {
        JPasswordField passF = new JPasswordField(); 
        passF.setBorder( new LineBorder(Color.black) );
        TableCellEditor editor = new DefaultCellEditor(passF);
        tblOfficers.getColumnModel().getColumn(4).setCellEditor(editor);        
    }
    
    private void setWindowProperties() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
    }
    
    private void registerListeners() {
        
    }
    
    private void getOfficerInfo() {
        Officer off = new Officer();
        tmpOfficerView = off.viewOff();
        
        String[] columnName = {"Badge", "FirstName", "LastName", "Precinct", "Password"};
        DefaultTableModel officerModel = new DefaultTableModel(tmpOfficerView, columnName) { };
        tblOfficers.setModel(officerModel);
    }
    
    private void getCommuterInfo() {
        Commuter comp = new Commuter();
        tmpCommuterView = comp.viewcommuter();
        
        String[] columnNames = {"TRN", "FirstName", "LastName", "PlateNumber", "DOB", "Password"};
        DefaultTableModel commuteModel = new DefaultTableModel(tmpCommuterView, columnNames) { };
        tblCommute.setModel(commuteModel);
    }

    @SuppressWarnings({ "unchecked", "serial" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        tblAdmin = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCommute = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogOut = new javax.swing.JMenuItem();
        menuAct = new javax.swing.JMenu();
        subMenOff = new javax.swing.JMenu();
        menuAddOff = new javax.swing.JMenuItem();
        menuEditOff = new javax.swing.JMenuItem();
        menuDeleteOff = new javax.swing.JMenuItem();
        subMenuComm = new javax.swing.JMenu();
        menuAddCom = new javax.swing.JMenuItem();
        menuAddCom.setAction(action);
        menuEditCom = new javax.swing.JMenuItem();
        menuDeleteCom = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOfficers = new javax.swing.JTable();
        
                tblOfficers.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                    },
                    new String [] {
                        "Badge", "First Name", "Last Name", "Precinct", "Password"
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                    };
        
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                jScrollPane1.setColumnHeaderView(tblOfficers);
                
                        tblAdmin.addTab("Officers", jScrollPane1);

        tblCommute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            	{null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            	
            },
            new String [] {
                "TRN", "FirstName", "LastName", "Plate Number", "DOB", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

            
        jScrollPane2.setViewportView(tblCommute);

        tblAdmin.addTab("Commuters", jScrollPane2);

        jMenu1.setText("File");

        menuLogOut.setText("Log Out");
        jMenu1.add(menuLogOut);

        jMenuBar1.add(jMenu1);

        menuAct.setText("Actions");

        subMenOff.setText("Officers");

        menuAddOff.setText("Add");
        subMenOff.add(menuAddOff);
        
        menuAddOff.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {

				
			}});

    
        
        menuEditOff.setText("Edit");
        subMenOff.add(menuEditOff);

        menuDeleteOff.setText("Delete");
        subMenOff.add(menuDeleteOff);

        menuAct.add(subMenOff);

        subMenuComm.setText("Commuters");

        menuAddCom.setText("Add");
        subMenuComm.add(menuAddCom);

        menuEditCom.setText("Edit");
        subMenuComm.add(menuEditCom);

        menuDeleteCom.setText("Delete");
        subMenuComm.add(menuDeleteCom);

        menuAct.add(subMenuComm);

        jMenuBar1.add(menuAct);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(tblAdmin, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(tblAdmin, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(60, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(adminDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDesk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDesk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAct;
    private javax.swing.JMenuItem menuAddCom;
    private javax.swing.JMenuItem menuAddOff;
    private javax.swing.JMenuItem menuDeleteCom;
    private javax.swing.JMenuItem menuDeleteOff;
    private javax.swing.JMenuItem menuEditCom;
    private javax.swing.JMenuItem menuEditOff;
    private javax.swing.JMenuItem menuLogOut;
    private javax.swing.JMenu subMenOff;
    private javax.swing.JMenu subMenuComm;
    private javax.swing.JTabbedPane tblAdmin;
    private javax.swing.JTable tblCommute;
    private javax.swing.JTable tblOfficers;
    private final Action action = new SwingAction();
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}