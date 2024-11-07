/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class formModul5 extends javax.swing.JFrame {
    
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
   
    public formModul5() {
        initComponents();
       
        // Inisialisasi koneksi ke database
        conn = koneksi.getConnection();
        
        // Inisialisasi model untuk tabel karyawan
        modelKaryawan = new DefaultTableModel();
        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
        tbl_karyawan.setModel(modelKaryawan);

        // Inisialisasi model untuk tabel proyek
        modelProyek = new DefaultTableModel();
        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi");
        tbl_proyek.setModel(modelProyek);

        // Inisialisasi model untuk tabel transaksi
        modelTransaksi = new DefaultTableModel();
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Peran");
        tbl_transaksi.setModel(modelTransaksi);
        
        

        // Muat data ke tabel masing-masing
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();

    }
    
    private void loadDataKaryawan(){
    modelKaryawan.setRowCount(0);

    try{
        String sql = "SELECT * FROM karyawan";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           modelKaryawan.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            });
//            model.addRow(row);;
        }
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    }
}
    
    
    private void loadDataProyek(){
    modelProyek.setRowCount(0);

    try{
        String sql = "SELECT * FROM proyek";
        PreparedStatement pryk = conn.prepareStatement(sql);
        ResultSet rs = pryk.executeQuery();

        while (rs.next()) {
           modelProyek.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getInt("durasi_pengerjaan")
            });
//            model.addRow(row);;
        }
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    }
}
    
    private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0);
    try {
        String sql = "SELECT k.nama as nama_karyawan, p.nama_proyek, " +
                     "t.peran, t.id_karyawan, t.id_proyek " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.id_karyawan = k.id " +
                     "JOIN proyek p ON t.id_proyek = p.id " +
                     "ORDER BY k.nama, p.nama_proyek";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek"),
                rs.getString("peran"),
                rs.getInt("id_karyawan"),
                rs.getInt("id_proyek")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi: " + e.getMessage());
    }
}
    
    
      private void loadComboBoxKaryawan() {
    combobox_karyawan.removeAllItems();
    try {
        String sql = "SELECT id, nama FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("%d - %s", 
                rs.getInt("id"),
                rs.getString("nama")
            );
            combobox_karyawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}
    
   private void loadComboBoxProyek() {
    combobox_proyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("%d - %s", 
                rs.getInt("id"),
                rs.getString("nama_proyek")
            );
            combobox_proyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
   private int getSelectedId(String comboBoxText) {
    if (comboBoxText == null || comboBoxText.isEmpty()) return -1;
    try {
        // Format combo box: "1 - Nama"
        return Integer.parseInt(comboBoxText.split(" - ")[0]);
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}
   
   private void SimpanTransaksi() {
    try {
        if (combobox_karyawan.getSelectedItem() == null || combobox_proyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String selectedKaryawan = combobox_karyawan.getSelectedItem().toString();
        String selectedProyek = combobox_proyek.getSelectedItem().toString();
        
        int idKaryawan = getSelectedId(selectedKaryawan);
        int idProyek = getSelectedId(selectedProyek);
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(null, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        // Menghapus pengecekan apakah kombinasi sudah ada
        // Jika belum ada, tambahkan data baru
        String sql ="INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, tfperan.getText().trim());
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Transaksi berhasil ditambahkan");
        loadDataTransaksi();
        clearTransaksiFields();
        
    } catch (SQLException e) {
        System.out.println("Error Tambah Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
    }
}

   
   
   private void updateTransaksi() {
    try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(combobox_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(combobox_proyek.getSelectedItem().toString());
        
        ps.setString(1, tfperan.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
}

   private void hapusTransaksi() {
    try {
        // Memastikan pengguna sudah memilih karyawan dan proyek dari ComboBox
        if (combobox_karyawan.getSelectedItem() == null || combobox_proyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }

        // Mendapatkan ID karyawan dan proyek dari ComboBox
        int idKaryawan = getSelectedId(combobox_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(combobox_proyek.getSelectedItem().toString());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data transaksi ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
                loadDataTransaksi();
                clearTransaksiFields();  // Membersihkan field setelah menghapus data
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah terhapus");
            }
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
   
    private void hapusProyek() {
    try {
        int id = Integer.parseInt(id_proyek.getText());
        
        // Mulai transaksi
        conn.setAutoCommit(false);
        
        try {
            // Hapus data di tabel proyek
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Reset auto increment dan reorder ID
            String resetSql = "SET @count = 0";
            String updateSql = "UPDATE proyek SET id = @count:= @count + 1";
            String alterSql = "ALTER TABLE proyek AUTO_INCREMENT = 1";
            
            Statement stmt = conn.createStatement();
            stmt.execute(resetSql);
            stmt.execute(updateSql);
            stmt.execute(alterSql);
            
            // Commit transaksi
            conn.commit();
            
            JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
            loadDataProyek();
            loadDataTransaksi();
            loadComboBoxProyek();
            clearProyekFields();
            
        } catch (SQLException ex) {
            // Rollback jika terjadi error
            conn.rollback();
            throw ex;
        } finally {
            // Kembalikan auto commit ke true
            conn.setAutoCommit(true);
        }
        
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Proyek: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
}
    
    
    private void tambahProyek(){
         try{
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement pryk = conn.prepareStatement(sql);
//        stmt.setInt(1, Integer.parseInt(id));
        pryk.setString(1, nama_proyek.getText());
        pryk.setString(2, durasipengerjaan_proyek.getText());
        pryk.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek(); 
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    
    }
    }
    
    private void editProyek(){
        try (Connection conn = koneksi.getConnection()) {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama_proyek.getText());
            stmt.setString(2, durasipengerjaan_proyek.getText());
            stmt.setInt(3, Integer.parseInt(id_proyek.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil diubah.");
            loadDataProyek();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    
    private void tambahKaryawan(){
        try{
        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, Integer.parseInt(id));
        stmt.setString(1, nama_karyawan.getText());
        stmt.setString(2, jabatan_karyawan.getText());
        stmt.setString(3, departemen_karyawan.getText());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data karyawan berhasil ditambahkan.");
        loadDataKaryawan(); // Memuat ulang data karyawan
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    
    }
    }
    
    private void editKaryawan(){
        try (Connection conn = koneksi.getConnection()) {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama_karyawan.getText());
            stmt.setString(2, jabatan_karyawan.getText());
            stmt.setString(3, departemen_karyawan.getText());
            stmt.setInt(4, Integer.parseInt(id_karyawan.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diubah.");
            loadDataKaryawan();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    private void hapusKaryawan(){
         try {
        int id = Integer.parseInt(id_karyawan.getText());
        
        // Mulai transaksi
        conn.setAutoCommit(false);
        
        try {
            // Hapus data di tabel karyawan
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Reset auto increment dan reorder ID
            String resetSql = "SET @count = 0";
            String updateSql = "UPDATE karyawan SET id = @count:= @count + 1";
            String alterSql = "ALTER TABLE karyawan AUTO_INCREMENT = 1";
            
            Statement stmt = conn.createStatement();
            stmt.execute(resetSql);
            stmt.execute(updateSql);
            stmt.execute(alterSql);
            
            // Commit transaksi
            conn.commit();
            
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
            loadDataKaryawan();
            loadDataTransaksi();
            loadComboBoxKaryawan();
            clearKaryawanFields();
            
        } catch (SQLException ex) {
            // Rollback jika terjadi error
            conn.rollback();
            throw ex;
        } finally {
            // Kembalikan auto commit ke true
            conn.setAutoCommit(true);
        }
        
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }

    }
   
   
   
   // Tambahkan method untuk membersihkan field
private void clearTransaksiFields() {
    tfperan.setText("");
    combobox_karyawan.setSelectedIndex(0);
    combobox_proyek.setSelectedIndex(0);
} 
 private void clearKaryawanFields() {
    id_karyawan.setText("");
    nama_karyawan.setText("");
    jabatan_karyawan.setText("");
    departemen_karyawan.setText("");
}

private void clearProyekFields() {
    id_proyek.setText("");
    nama_proyek.setText("");
    durasipengerjaan_proyek.setText("");
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        nama_karyawan = new javax.swing.JTextField();
        jabatan_karyawan = new javax.swing.JTextField();
        departemen_karyawan = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        tambah_karyawan = new javax.swing.JButton();
        edit_karyawan = new javax.swing.JButton();
        hapus_karyawan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        durasipengerjaan_proyek = new javax.swing.JTextField();
        nama_proyek = new javax.swing.JTextField();
        id_proyek = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        tambah_proyek = new javax.swing.JButton();
        edit_proyek = new javax.swing.JButton();
        hapus_proyek = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        combobox_karyawan = new javax.swing.JComboBox<>();
        combobox_proyek = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tfperan = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Id :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 24, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nama :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 24, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Jabatatan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 24, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Departemen :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 24, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 0, 23);
        jPanel4.add(id_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 0, 23);
        jPanel4.add(nama_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 0, 23);
        jPanel4.add(jabatan_karyawan, gridBagConstraints);

        departemen_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departemen_karyawanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 43, 29, 23);
        jPanel4.add(departemen_karyawan, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        tambah_karyawan.setBackground(new java.awt.Color(204, 255, 204));
        tambah_karyawan.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        tambah_karyawan.setText("Tambah");
        tambah_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_karyawanActionPerformed(evt);
            }
        });
        jPanel5.add(tambah_karyawan);

        edit_karyawan.setBackground(new java.awt.Color(204, 255, 153));
        edit_karyawan.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        edit_karyawan.setText("Edit");
        edit_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_karyawanActionPerformed(evt);
            }
        });
        jPanel5.add(edit_karyawan);

        hapus_karyawan.setBackground(new java.awt.Color(255, 204, 204));
        hapus_karyawan.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        hapus_karyawan.setText("Hapus");
        hapus_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_karyawanActionPerformed(evt);
            }
        });
        jPanel5.add(hapus_karyawan);

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_karyawan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel5.setText("Id :");

        jLabel6.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel6.setText("Nama Proyek :");

        jLabel7.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel7.setText("Durasi Pengerjaan :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(durasipengerjaan_proyek))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(durasipengerjaan_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        tambah_proyek.setBackground(new java.awt.Color(255, 153, 102));
        tambah_proyek.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tambah_proyek.setText("Tambah");
        tambah_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_proyekActionPerformed(evt);
            }
        });
        jPanel7.add(tambah_proyek);

        edit_proyek.setBackground(new java.awt.Color(204, 153, 0));
        edit_proyek.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        edit_proyek.setText("Edit");
        edit_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_proyekActionPerformed(evt);
            }
        });
        jPanel7.add(edit_proyek);

        hapus_proyek.setBackground(new java.awt.Color(255, 204, 153));
        hapus_proyek.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hapus_proyek.setText("Hapus");
        hapus_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_proyekActionPerformed(evt);
            }
        });
        jPanel7.add(hapus_proyek);

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_proyek);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proyek", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel10.setBackground(new java.awt.Color(255, 204, 204));

        combobox_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        combobox_proyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Bell MT", 1, 12)); // NOI18N
        jLabel8.setText("Peran :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tfperan, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addComponent(combobox_karyawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combobox_proyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(combobox_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combobox_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfperan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel11.setLayout(new java.awt.BorderLayout());

        tbl_transaksi.setBackground(new java.awt.Color(204, 204, 204));
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        btn_simpan.setBackground(new java.awt.Color(204, 255, 204));
        btn_simpan.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel8.add(btn_simpan);

        btn_hapus.setBackground(new java.awt.Color(255, 102, 0));
        btn_hapus.setFont(new java.awt.Font("Bodoni Bd BT", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel8.add(btn_hapus);

        btn_update.setBackground(new java.awt.Color(255, 153, 153));
        btn_update.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel8.add(btn_update);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi Proyek", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departemen_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departemen_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departemen_karyawanActionPerformed

    private void tambah_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_karyawanActionPerformed
      tambahKaryawan();
    }//GEN-LAST:event_tambah_karyawanActionPerformed

    private void edit_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_karyawanActionPerformed
      editKaryawan();
    }//GEN-LAST:event_edit_karyawanActionPerformed

    private void hapus_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_karyawanActionPerformed
      hapusKaryawan();
    }//GEN-LAST:event_hapus_karyawanActionPerformed

    private void tambah_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_proyekActionPerformed
     tambahProyek();
    }//GEN-LAST:event_tambah_proyekActionPerformed

    private void edit_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_proyekActionPerformed
         editProyek();
    }//GEN-LAST:event_edit_proyekActionPerformed

    private void hapus_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_proyekActionPerformed
       hapusProyek();
    }//GEN-LAST:event_hapus_proyekActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here
        SimpanTransaksi();
        
        
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        updateTransaksi();
    }//GEN-LAST:event_btn_updateActionPerformed

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
            java.util.logging.Logger.getLogger(formModul5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formModul5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formModul5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formModul5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formModul5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combobox_karyawan;
    private javax.swing.JComboBox<String> combobox_proyek;
    private javax.swing.JTextField departemen_karyawan;
    private javax.swing.JTextField durasipengerjaan_proyek;
    private javax.swing.JButton edit_karyawan;
    private javax.swing.JButton edit_proyek;
    private javax.swing.JButton hapus_karyawan;
    private javax.swing.JButton hapus_proyek;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JTextField id_proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jabatan_karyawan;
    private javax.swing.JTextField nama_karyawan;
    private javax.swing.JTextField nama_proyek;
    private javax.swing.JButton tambah_karyawan;
    private javax.swing.JButton tambah_proyek;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tfperan;
    // End of variables declaration//GEN-END:variables
}
