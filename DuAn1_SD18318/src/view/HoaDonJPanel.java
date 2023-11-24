
package view;

import com.barcodelib.barcode.a.g.m.q;
import com.fpt.utils.Excel;
import com.fpt.utils.MsgBox;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.HoaDon;
import model.HoaDonCT;
import model.LichSuHoaDon;
import service.HDCTService;
import service.HoaDonService;
import service.KhachHangService;
import service.LSHDService;
import service.NhanVienService;
import service.SanPhamChiTietServiceImpl;
import service.SanPhamServiceImpl;

/**
 *
 * @author PC
 */
public class HoaDonJPanel extends javax.swing.JPanel {
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel hdd,hdct,lshd = new DefaultTableModel();
    HoaDonService serviceHoaDon = new HoaDonService();
    NhanVienService serviceNv = new NhanVienService();
    KhachHangService serviceKH = new KhachHangService();
    LSHDService serviceLS = new LSHDService();
    HDCTService serviceHDCT = new HDCTService();
    SanPhamChiTietServiceImpl serviceSPCT = new SanPhamChiTietServiceImpl();
    SanPhamServiceImpl serviceSP = new SanPhamServiceImpl();
    List<HoaDon> list  = new ArrayList<>();
    List<LichSuHoaDon> listLS = new ArrayList<>();
    List<HoaDonCT> listHDCT = new ArrayList<>();
     int page = 1;
     int pageLS = 1;
    int limitHD = 5;
    int limitLS = 5;
    int max = serviceHoaDon.getMaxPage(limitHD);
    int maxLS = serviceLS.getMaxPage(limitLS);
    public HoaDonJPanel() {
        initComponents();
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        hdd = (DefaultTableModel) tbTraHang.getModel();
        hdct = (DefaultTableModel) tbHoaDonCT.getModel();
        lshd = (DefaultTableModel) tbLSHD.getModel();
        list = serviceHoaDon.paging(page, limitHD);
        listLS = serviceLS.paging(pageLS, limitLS);
        listHDCT = serviceHDCT.getAll();
        btnNext.setEnabled(true);
        showDataQuay(list);
//        showDataHDCT(listHDCT);
//        showDataTraHang(list);
//        System.out.println(listLS);
//        showDataLSHD(listLS);
    }
    // showdata hóa đơn
    
    void showDataQuay(List<HoaDon>list){
        int indexHoaDon = 0;
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            indexHoaDon++;
            String maNV = serviceNv.getById(hd.getIdNV()).getMaNV();
            String tenKh = serviceKH.getByID(hd.getIdKH()).getTenKH();
            dtm.addRow(new Object[]{
                indexHoaDon,
                hd.getMaHD(),
                maNV,
                tenKh,
                hd.getNgayDat(),
                hd.getNgayGiao(),
                hd.getTongTien(),
                hd.getGhiChu(),
                hd.isTrangThai() == true ?"Đã Thanh Toán":"Chưa Thanh Toán"
            });
        }
    }
    // showdate trả hàng
    
//    void showDataTraHang(List<HoaDon> list){
//        hdd.setRowCount(0);
//        int indexHoaDon = 1;
//        for (HoaDon hd : list) {
//            String maNV = serviceNv.getById(hd.getIdNV()).getMaNV();
//            hdd.addRow(new Object[]{
//                indexHoaDon++,
//                hd.getMaHD(),
//                maNV,
//                hd.getTenNguoiNhan(),
//                hd.getSDT(),
//                hd.getDiaChi(),
//                hd.getNgayTao(),
//                hd.getPhiVanChuyen(),
//                hd.getTongTien(),
//                hd.isTrangThai() == true ? "Đã Thanh Toán" : "Chưa Thanh Toán"
//            });
//        }
//    }
    // show data Hóa đơn chi tiết

    // showdata lịch sử
    
    void showDataLSHD(List<LichSuHoaDon> list){
        lshd.setRowCount(0);
        int indexCT =0;
        for (LichSuHoaDon ls : list) {
            indexCT ++;
            String maHD = serviceHoaDon.getById(ls.getIdHD()).getMaHD();
            System.out.println(maHD);
            String sdt = serviceHoaDon.getById(ls.getIdHD()).getSDT();
            String tenNguoiNhan = serviceHoaDon.getById(ls.getIdHD()).getTenNguoiNhan();
            boolean trangThai = (Boolean) serviceHoaDon.getById(ls.getIdHD()).isTrangThai();
//            float tongTien = (Float) serviceHoaDon.getById(ls.getIdHD()).getTongTien();
            lshd.addRow(new Object[]{
                indexCT,
                ls.getNgayTao(),
                ls.getNguoiTao(),
                tenNguoiNhan,
//                ls.getTongTien(),
//               ls.getNgayDat(),
                trangThai== true ? "Đã Thanh Toán":"Chưa Thanh Toán"
            });
        }
        
    }
//    void showDataHDCT(List<HoaDonCT>listHDCT){
//        hdct.setRowCount(0);
//        int stt = 0;
//        for (HoaDonCT ct : listHDCT) {
//            stt++;
//            hdct.addRow(new Object[]{
//                stt,
//                ct.getMaSP(),
//                ct.getTenSP(),
//                ct.getSoLuong(),
//                ct.getThanhTien()
//                
//            });
//        }
//    }
//    void TimKiemTheoBang() {
//        
//        hdct.setRowCount(0);
//        String mahd = (String) tbHoaDon.getValueAt(tbHoaDon.getSelectedRow(), 2);
//        try {
////            List<HoaDonCT> listHDCT = serviceHDCT.getByKeyword(mahd);
//               
//            int stt = 0;
//        for (HoaDonCT ct : listHDCT) {
//            stt++;
//            String tenSP = serviceSP.getById(ct.getId()).getTenSp();
//            String maSP = serviceSP.getById(ct.getId()).getMaSp();
//            String tenNguoiNhan = serviceHoaDon.getById(ct.getIdHD()).getTenNguoiNhan();
//            hdct.addRow(new Object[]{
//                stt,
//                maSP,
//                tenNguoiNhan,
//                ct.getSoLuong(),
//                ct.getThanhTien()
//                
//            });
//            System.out.println(tenSP+""+maSP);
//        }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "loi truy van du lieu!");
//            e.printStackTrace();
//        }
//    }
    void TimKiemTheoBang() {
    try {
        hdct.setRowCount(0);

        // Kiểm tra xem có hàng được chọn không
        int selectedRow = tbHoaDon.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng trong bảng hóa đơn.");
            return;
        }

        String mahd = (String) tbHoaDon.getValueAt(selectedRow, 2);

        // Kiểm tra xem danh sách có phần tử không
        if (listHDCT != null && !listHDCT.isEmpty()) {
            int stt = 0;
            for (HoaDonCT ct : listHDCT) {
                stt++;
                
                // Kiểm tra xem serviceSP và serviceHoaDon có được khởi tạo không
                if (serviceSP != null && serviceHoaDon != null) {
                    String tenSP = serviceSP.getById(ct.getId()).getTenSp();
                    String maSP = serviceSP.getById(ct.getId()).getMaSp();
                    String tenNguoiNhan = serviceHoaDon.getById(ct.getIdHD()).getTenNguoiNhan();

                    hdct.addRow(new Object[]{
                            stt,
                            maSP,
                            tenNguoiNhan,
                            ct.getSoLuong(),
                            ct.getThanhTien(),
                            ct.isTrangThai()
                    });

                    System.out.println(tenSP + " " + maSP);
                } else {
                    JOptionPane.showMessageDialog(this, "Dịch vụ không được khởi tạo đúng.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Danh sách hóa đơn chi tiết trống hoặc null.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        e.printStackTrace();
    }
}

    // tìm kiếm
    

    // xuất file excel
    
    public void excelHoaDon() throws IOException {
        Excel.outExcel((DefaultTableModel) tbHoaDon.getModel());
        MsgBox.alert(this, "Xuất file thành công");
    }
    // load lên textfied lịch sử hóa đơn
//    public void getFormData(LichSuHoaDon ls){
//        txtMaHD.setText(serviceHoaDon.getById(ls.getIdHD()).getMaHD());
//        txtSDT.setText(serviceKH.getByID(ls.getId()).getSdt());
//        txtTongTien.setText(serviceHoaDon.getById(ls.getIdHD()).getTongTien()+"");
//        txtNgayDat.setText(serviceHoaDon.getById(ls.getIdHD()).getNgayDat()+"");
//        txtNgayGiao.setText(serviceHoaDon.getById(ls.getIdHD()).getNgayGiao()+"");
//        txtDiaChi.setText(serviceHoaDon.getById(ls.getIdHD()).getDiaChi()+"");
//        txtTrangThai.setText(serviceHoaDon.getById(ls.getIdHD()).isTrangThai()== true ? "Đã Thanh Toán":"Chưa Thanh Toán");
//        
//    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbbHinhThuc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearchQuay = new com.fpt.utils.TextField();
        dateDat = new com.toedter.calendar.JDateChooser();
        dateGiao = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnTimNgay = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbHoaDonCT = new javax.swing.JTable();
        lblSoTrang = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLSHD = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtSearch1 = new com.fpt.utils.TextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTraHang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(879, 521));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnPre.setBackground(new java.awt.Color(180, 220, 241));
        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(180, 220, 241));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnIn.setBackground(new java.awt.Color(180, 220, 241));
        btnIn.setText("in hóa đơn");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        btnXuatExcel.setBackground(new java.awt.Color(180, 220, 241));
        btnXuatExcel.setText("xuất danh sách");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        jLabel1.setText("Trạng Thái Hóa Đơn");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thanh Toán", "Chưa Thanh Toán", "Tất Cả", " " }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        jLabel2.setText("Hình Thức Thanh Toán");

        cbbHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản", "Tất Cả", " " }));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        jLabel3.setText("Tìm Kiếm Hóa Đơn");

        btnSearch.setBackground(new java.awt.Color(180, 220, 241));
        btnSearch.setText("tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearchQuay.setLabelText("MaHD-MaNV-TênKH");

        dateDat.setDateFormatString("yyyy-MM-dd");

        dateGiao.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setText("Đến");

        btnTimNgay.setBackground(new java.awt.Color(180, 220, 241));
        btnTimNgay.setText("Lọc");
        btnTimNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNgayActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MaHD", "MaNV", "Tên Người Nhận", "Ngày Tạo", "Ngày Giao", "Tổng Tiền", "Ghi Chú", "Trạng Thái"
            }
        ));
        tbHoaDon.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbHoaDonAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbHoaDon);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn Chi Tiết"));

        tbHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số Lượng", "Tổng Tiền", "Trạng Thái"
            }
        ));
        jScrollPane6.setViewportView(tbHoaDonCT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Lịch sử hóa đơn"));

        tbLSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày Tạo", "Người Tạo", "Tên Người Nhận", "Trạng Thái"
            }
        ));
        tbLSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLSHDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLSHD);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnTaoHoaDon.setBackground(new java.awt.Color(180, 220, 241));
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(426, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchQuay, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnSearch)
                                .addGap(31, 31, 31)
                                .addComponent(dateDat, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimNgay))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(91, 91, 91)
                                            .addComponent(btnPre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7)
                                            .addComponent(btnNext)
                                            .addGap(168, 168, 168)
                                            .addComponent(btnTaoHoaDon)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnIn)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnXuatExcel))))))
                        .addGap(0, 56, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchQuay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimNgay)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(dateDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(btnIn)
                        .addComponent(btnPre)
                        .addComponent(btnTaoHoaDon)
                        .addComponent(btnXuatExcel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(288, 288, 288))
        );

        jTabbedPane1.addTab("Hóa Đơn Tại Quầy", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Mã HD");

        jLabel18.setText("     Số Điện Thoại");

        jLabel19.setText("Khách Hàng");

        jLabel20.setText("Ngày Đặt");

        jLabel21.setText("Ngày Giao");

        jLabel22.setText("Địa Chỉ");

        jLabel23.setText("Trạng Thái");

        jLabel24.setText("Tổng Tiền");

        jLabel4.setText("Người Nhận");

        jLabel5.setText("Mã NV");

        jLabel26.setText("Tiền Ship");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel26)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel4))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 0, 10)); // NOI18N
        jLabel25.setText("Tìm Kiếm Hóa Đơn");

        jButton4.setBackground(new java.awt.Color(180, 220, 241));
        jButton4.setText("tìm kiếm");

        txtSearch1.setLabelText("MaHD-MaNV-TênKH");
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm"));

        tbTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên SP", "Giá", "Số Lượng", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tbTraHang);

        jButton1.setBackground(new java.awt.Color(180, 220, 241));
        jButton1.setText("Trả Hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(33, 33, 33)
                        .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Trả Hàng", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void tbLSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLSHDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbLSHDMouseClicked

    private void tbHoaDonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbHoaDonAncestorAdded
//                getFormDataHD(serviceHoaDon.getAll().get(tbHoaDon.getSelectedRow()));
//                    int sel = tbHoaDon.getSelectedRow();
                   
            
    }//GEN-LAST:event_tbHoaDonAncestorAdded

    private void btnTimNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNgayActionPerformed
        try {
            SimpleDateFormat sds = new SimpleDateFormat("yyyy-MM-dd");
            Date ngayDat = sds.parse(sds.format(dateDat.getDate()));
            Date ngayGiao = sds.parse(sds.format(dateGiao.getDate()));
            java.sql.Date sqlDate = new java.sql.Date(ngayDat.getTime());
            java.sql.Date sqlDate1 = new java.sql.Date(ngayGiao.getTime());
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn tìm kiếm không ?") == 0) {
                list = serviceHoaDon.timTheoNgay(sqlDate, sqlDate1);
                showDataQuay(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể thực hiện tìm kiếm. Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimNgayActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn tìm kiếm không ?") == 0) {
                showDataQuay(serviceHoaDon.search(txtSearchQuay.getText()));
                System.out.println(serviceHoaDon.search(txtSearchQuay.getText()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "khong tim thay");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        String selectedItem = (String) cbbTrangThai.getSelectedItem();
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        try {
            excelHoaDon();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x== JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.page++;
        btnPre.setEnabled(true);
        if (page>=max) {
            btnNext.setEnabled(false);
        }
        list = serviceHoaDon.paging(page, limitHD);
        showDataQuay(list);
        lblSoTrang.setText(String.valueOf(page)+"/"+max);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        this.page--;
        btnNext.setEnabled(true);
        if (page<2) {
            btnPre.setEnabled(false);
        }
        list = serviceHoaDon.paging(page, limitHD);
        showDataQuay(list);
        lblSoTrang.setText(String.valueOf(page)+"/"+max);
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int sel = tbHoaDon.getSelectedRow();
        if (sel>=0) {
            TimKiemTheoBang();
        }
    }//GEN-LAST:event_tbHoaDonMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnTimNgay;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cbbHinhThuc;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser dateDat;
    private com.toedter.calendar.JDateChooser dateGiao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbHoaDonCT;
    private javax.swing.JTable tbLSHD;
    private javax.swing.JTable tbTraHang;
    private com.fpt.utils.TextField txtSearch1;
    private com.fpt.utils.TextField txtSearchQuay;
    // End of variables declaration//GEN-END:variables
}
