
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class praktikum3 extends javax.swing.JFrame {

    private int totalPembayaranDihitung = 0;
    public praktikum3() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtbs = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbjanuari = new javax.swing.JCheckBox();
        cbfebruari = new javax.swing.JCheckBox();
        cbmaret = new javax.swing.JCheckBox();
        cbapril = new javax.swing.JCheckBox();
        cbmei = new javax.swing.JCheckBox();
        cbjuni = new javax.swing.JCheckBox();
        cbjuli = new javax.swing.JCheckBox();
        cbagustus = new javax.swing.JCheckBox();
        cbseptember = new javax.swing.JCheckBox();
        cboktober = new javax.swing.JCheckBox();
        cbnovember = new javax.swing.JCheckBox();
        cbdesember = new javax.swing.JCheckBox();
        buttonrt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txttps = new javax.swing.JTextField();
        buttonreset = new javax.swing.JButton();
        buttonkeluar = new javax.swing.JButton();
        buttonsimpan = new javax.swing.JButton();
        buttonct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PENCATATAN PEMBAYARAN SPP");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 33, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BIAYA SPP :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 33, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 184;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 18, 0, 28);
        jPanel2.add(txtnama, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 184;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 14, 28);
        jPanel2.add(txtbs, gridBagConstraints);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 100));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setText("TAHUN");

        cbjanuari.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbjanuari.setText("JANUARI");

        cbfebruari.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbfebruari.setText("FEBRUARI");

        cbmaret.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbmaret.setText("MARET");

        cbapril.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbapril.setText("APRIL");

        cbmei.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbmei.setText("MEI");

        cbjuni.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbjuni.setText("JUNI");

        cbjuli.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbjuli.setText("JULI");

        cbagustus.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbagustus.setText("AGUSTUS");

        cbseptember.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbseptember.setText("SEPTEMBER");

        cboktober.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cboktober.setText("OKTOBER");

        cbnovember.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbnovember.setText("NOVEMBER");

        cbdesember.setFont(new java.awt.Font("Clarendon BT", 0, 12)); // NOI18N
        cbdesember.setText("DESEMBER");

        buttonrt.setFont(new java.awt.Font("Imprint MT Shadow", 0, 12)); // NOI18N
        buttonrt.setForeground(new java.awt.Color(51, 51, 0));
        buttonrt.setText("RESET TAHUN");
        buttonrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonrtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbjuni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbmei, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbapril, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbmaret, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbjanuari, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbfebruari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbjuli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbagustus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboktober, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cbseptember)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbnovember)
                            .addComponent(cbdesember))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(157, 157, 157))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(buttonrt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbjanuari)
                    .addComponent(cbjuli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbfebruari)
                    .addComponent(cbagustus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmaret)
                    .addComponent(cbseptember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbapril)
                    .addComponent(cboktober))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmei)
                    .addComponent(cbnovember))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbjuni)
                    .addComponent(cbdesember))
                .addGap(18, 18, 18)
                .addComponent(buttonrt)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 370, 280));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Pembayaran SPP :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 19, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        txttps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttpsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 132;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 0, 0);
        jPanel4.add(txttps, gridBagConstraints);

        buttonreset.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        buttonreset.setText("RESET");
        buttonreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(89, 6, 15, 0);
        jPanel4.add(buttonreset, gridBagConstraints);

        buttonkeluar.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        buttonkeluar.setText("KELUAR");
        buttonkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonkeluarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(89, 12, 15, 0);
        jPanel4.add(buttonkeluar, gridBagConstraints);

        buttonsimpan.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        buttonsimpan.setText("SIMPAN");
        buttonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsimpanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 25, 15, 0);
        jPanel4.add(buttonsimpan, gridBagConstraints);

        buttonct.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        buttonct.setText("CEK TAGIHAN");
        buttonct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonctActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 6, 15, 6);
        jPanel4.add(buttonct, gridBagConstraints);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 400, 180));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Tagihan", "JAN", "FEB", "MAR", "APR", "MEI", "JUNI", "JULI", "AGU", "SEP", "OKT", "NOV", "DES", "KET"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 770, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttpsActionPerformed

    private void buttonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsimpanActionPerformed
        // TODO add your handling code here:
    if (txtnama.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Isi kolom nama terlebih dahulu", "PERINGATAN !!!", JOptionPane.WARNING_MESSAGE);
    return;
}

if (!cbjanuari.isSelected() && !cbfebruari.isSelected() && !cbmaret.isSelected() && !cbapril.isSelected() && 
    !cbmei.isSelected() && !cbjuni.isSelected() && !cbjuli.isSelected() && !cbagustus.isSelected() && 
    !cbseptember.isSelected() && !cboktober.isSelected() && !cbnovember.isSelected() && !cbdesember.isSelected()) {
    JOptionPane.showMessageDialog(this, "Pilih minimal satu bulan", "PERINGATAN !!!", JOptionPane.WARNING_MESSAGE);
    return;
}

if (txttps.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Isi harga terlebih dahulu", "PERINGATAN !!!", JOptionPane.WARNING_MESSAGE);
    return;
}

try {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    String Nama = txtnama.getText();
    String Status = "BELUM LUNAS"; 
    int Harga = Integer.parseInt(txttps.getText());
    
    int Bulan = 0;

    if (cbjanuari.isSelected()) Bulan++;
    if (cbfebruari.isSelected()) Bulan++;
    if (cbmaret.isSelected()) Bulan++;
    if (cbapril.isSelected()) Bulan++;
    if (cbmei.isSelected()) Bulan++;
    if (cbjuni.isSelected()) Bulan++;
    if (cbjuli.isSelected()) Bulan++;
    if (cbagustus.isSelected()) Bulan++;
    if (cbseptember.isSelected()) Bulan++;
    if (cboktober.isSelected()) Bulan++;
    if (cbnovember.isSelected()) Bulan++;
    if (cbdesember.isSelected()) Bulan++;

    if (Bulan == 12) {
        Status = "LUNAS";
    }

    int Total = Harga * (12 - Bulan);
    
    Object[] dataBaru = new Object[15];
    dataBaru[0] = Nama;
    dataBaru[1] = Total;
    dataBaru[2] = cbjanuari.isSelected();
    dataBaru[3] = cbfebruari.isSelected();
    dataBaru[4] = cbmaret.isSelected();
    dataBaru[5] = cbapril.isSelected();
    dataBaru[6] = cbmei.isSelected();
    dataBaru[7] = cbjuni.isSelected();
    dataBaru[8] = cbjuli.isSelected();
    dataBaru[9] = cbagustus.isSelected();
    dataBaru[10] = cbseptember.isSelected();
    dataBaru[11] = cboktober.isSelected();
    dataBaru[12] = cbnovember.isSelected();
    dataBaru[13] = cbdesember.isSelected();
    dataBaru[14] = Status;
    
    model.addRow(dataBaru);
    
    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "FORMAT ANGKA TIDAK VALID", "KESALAHAN !!!", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_buttonsimpanActionPerformed

    private void buttonctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonctActionPerformed
        // TODO add your handling code here:
        int sppPerBulan = Integer.parseInt(txtbs.getText());
int totalPembayaranDihitung = 0;

if (cbjanuari.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbfebruari.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbmaret.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbapril.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbmei.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbjuni.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbjuli.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbagustus.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbseptember.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cboktober.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbnovember.isSelected()) totalPembayaranDihitung += sppPerBulan;
        if (cbdesember.isSelected()) totalPembayaranDihitung += sppPerBulan;

txttps.setText(String.valueOf(totalPembayaranDihitung));


    }//GEN-LAST:event_buttonctActionPerformed

    private void buttonresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonresetActionPerformed
        // TODO add your handling code here:
        txtnama.setText("");     
txttps.setText("");     
txtbs.setText("");      

cbjanuari.setSelected(false);   
cbfebruari.setSelected(false);  
cbmaret.setSelected(false);     
cbapril.setSelected(false);     
cbmei.setSelected(false);       
cbjuni.setSelected(false);      
cbjuli.setSelected(false);      
cbagustus.setSelected(false);   
cbseptember.setSelected(false); 
cboktober.setSelected(false);   
cbnovember.setSelected(false);  
cbdesember.setSelected(false);  

    }//GEN-LAST:event_buttonresetActionPerformed

    private void buttonkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonkeluarActionPerformed

    private void buttonrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonrtActionPerformed
        // TODO add your handling code here:
cbjanuari.setSelected(false);   
cbfebruari.setSelected(false);  
cbmaret.setSelected(false);     
cbapril.setSelected(false);     
cbmei.setSelected(false);       
cbjuni.setSelected(false);      
cbjuli.setSelected(false);      
cbagustus.setSelected(false);   
cbseptember.setSelected(false); 
cboktober.setSelected(false);   
cbnovember.setSelected(false);  
cbdesember.setSelected(false);  
    }//GEN-LAST:event_buttonrtActionPerformed

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
            java.util.logging.Logger.getLogger(praktikum3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(praktikum3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(praktikum3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(praktikum3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new praktikum3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonct;
    private javax.swing.JButton buttonkeluar;
    private javax.swing.JButton buttonreset;
    private javax.swing.JButton buttonrt;
    private javax.swing.JButton buttonsimpan;
    private javax.swing.JCheckBox cbagustus;
    private javax.swing.JCheckBox cbapril;
    private javax.swing.JCheckBox cbdesember;
    private javax.swing.JCheckBox cbfebruari;
    private javax.swing.JCheckBox cbjanuari;
    private javax.swing.JCheckBox cbjuli;
    private javax.swing.JCheckBox cbjuni;
    private javax.swing.JCheckBox cbmaret;
    private javax.swing.JCheckBox cbmei;
    private javax.swing.JCheckBox cbnovember;
    private javax.swing.JCheckBox cboktober;
    private javax.swing.JCheckBox cbseptember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tabel;
    private javax.swing.JTextField txtbs;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttps;
    // End of variables declaration//GEN-END:variables
}
