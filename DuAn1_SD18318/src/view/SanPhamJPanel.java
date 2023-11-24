package view;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CachThucDongCua;
import model.ChatLieu;
import model.KieuDang;
import model.KieuMu;
import model.LopAo;
import model.MauSac;
import model.SanPham;
import model.SanPhamChiTiet;
import model.Size;
import service.ChatLieuServiceImpl;
import service.KhoaCaiServiceImpl;
import service.KieuDangServiceImpl;
import service.LopServiceImpl;
import service.MauSacServiceIml;
import service.MuServiceImpl;
import service.SanPhamChiTietServiceImpl;
import service.SanPhamService;
import service.SanPhamServiceImpl;
import service.SizeServiceImpl;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.SQLServerConnection;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.MsgBox;
import model.excel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC
 */
public class SanPhamJPanel extends javax.swing.JPanel {

    DefaultTableModel modelSp = new DefaultTableModel();
    DefaultTableModel modelSpct = new DefaultTableModel();
    DefaultTableModel modelThuocTinh = new DefaultTableModel();
    SanPhamServiceImpl serviceSp = new SanPhamServiceImpl();
    SizeServiceImpl serviceSize = new SizeServiceImpl();
    MauSacServiceIml serviceMauSac = new MauSacServiceIml();
    ChatLieuServiceImpl serviceChatLieu = new ChatLieuServiceImpl();
    MuServiceImpl serviceMu = new MuServiceImpl();
    KieuDangServiceImpl serviceKd = new KieuDangServiceImpl();
    LopServiceImpl serviceLop = new LopServiceImpl();
    KhoaCaiServiceImpl serviceKhoaCai = new KhoaCaiServiceImpl();
    SanPhamChiTietServiceImpl serviceSpct = new SanPhamChiTietServiceImpl();
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private int pageSp = 1;
    private int pageSpct = 1;
//    private int itemsPerPage = 5; // Số lượng dữ liệu trên mỗi trang
    List<SanPham> listSp = new ArrayList<>();
    List<SanPhamChiTiet> listSpct = new ArrayList<>();
//    private final int maxPage = (int) Math.ceil((double) listSpct / itemsPerPage);
    DefaultComboBoxModel<Size> cbbModelSize = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<MauSac> cbbModelMauSac = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<ChatLieu> cbbModelChatLieu = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<KieuDang> cbbModelKieuDang = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<LopAo> cbbModelLop = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<CachThucDongCua> cbbModelCtdc = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<KieuMu> cbbModelMu = new DefaultComboBoxModel<>();
    int maxSpct = serviceSpct.getMaxPages(5);
    int maxSp = serviceSp.getMaxPagesSp(5);

    public SanPhamJPanel() {
        initComponents();
        cbbModelMauSac = (DefaultComboBoxModel) cbbMauSac.getModel();
        cbbModelSize = (DefaultComboBoxModel) cbbSize.getModel();
        cbbModelChatLieu = (DefaultComboBoxModel) cbbChatLieu.getModel();
        cbbModelKieuDang = (DefaultComboBoxModel) cbbKieuDang.getModel();
        cbbModelLop = (DefaultComboBoxModel) cbbLop.getModel();
        cbbModelCtdc = (DefaultComboBoxModel) cbbKhoaCai.getModel();
        cbbModelMu = (DefaultComboBoxModel) cbbMu.getModel();
        modelSp = (DefaultTableModel) tbSanPham.getModel();
        modelSpct = (DefaultTableModel) tbSpct.getModel();
        modelThuocTinh = (DefaultTableModel) tbThuocTinh.getModel();
        listSp = serviceSp.phanTrang(pageSp, 5);
        listSpct = serviceSpct.phanTrang(pageSpct, 5);
        loaiMauSac();
        loaiSize();
        loaiChatLieu();
        loaiKieuDang();
        soLop();
        loaiKhoaCai();
        loaiMu();
        lbSoTrangSp.setText("1/" + maxSp);
        lbSoTrang.setText("1/" + maxSpct);
        btnPrev.setEnabled(false);
        btnPrevSp.setEnabled(false);
        showDataSanPham(listSp);
        showDataSize(serviceSize.getAll());
        showDataFullSpct(listSpct);
        showDetailDongDauSp();
        showDetailDongDauSpct();
    }

//-----------------load cbb--------------------------------
    void loaiMauSac() {
        cbbMauSac.removeAllItems();
        for (MauSac ms : serviceMauSac.getCbbMs()) {
//            System.out.println(ms);
            cbbModelMauSac.addElement(ms);
        }
    }

    void loaiMu() {
        cbbMu.removeAllItems();
        for (KieuMu mu : serviceMu.getCbbMu()) {

            cbbModelMu.addElement(mu);
        }
    }

    void soLop() {
        cbbLop.removeAllItems();
        for (LopAo lop : serviceLop.getCbbLop()) {
//            System.out.println(lop);
            cbbModelLop.addElement(lop);
        }
    }

    void loaiSize() {
        cbbSize.removeAllItems();
        for (Size s : serviceSize.getSize()) {
//            System.out.println(s);
            cbbModelSize.addElement(s);
        }
    }

    void loaiKhoaCai() {
        cbbKhoaCai.removeAllItems();
        for (CachThucDongCua ctdc : serviceKhoaCai.getCbbKhoaCai()) {
//            System.out.println(s);
            cbbModelCtdc.addElement(ctdc);
        }
    }

    void loaiKieuDang() {
        cbbKieuDang.removeAllItems();
        for (KieuDang kd : serviceKd.getCbbKd()) {
            cbbModelKieuDang.addElement(kd);
        }
    }

    void loaiChatLieu() {
        cbbChatLieu.removeAllItems();
        for (ChatLieu cl : serviceChatLieu.getCbbChatLieu()) {
            cbbModelChatLieu.addElement(cl);
        }
    }
//----------------------end-----------------------------------
//-------------------------------showData------------------------------------------

    void showDataFullSpct(List<SanPhamChiTiet> list) {
        int index = 1;
        modelSpct.setRowCount(0);
        for (SanPhamChiTiet spct : list) {
            String maSp = serviceSp.getById(spct.getIdSp()).getMaSp();
            String tenSp = serviceSp.getById(spct.getIdSp()).getTenSp();
            String size = serviceSize.get_By_Id(spct.getIdSize()).getTenSize();
            String ms = serviceMauSac.get_By_Id(spct.getIdMs()).getTenMauSac();
            String chatLieu = serviceChatLieu.get_By_Id(spct.getIdCl()).getTenChatLieu();
            String kieuDang = serviceKd.get_By_Id(spct.getIdKd()).getTenKd();
            String khoa = serviceKhoaCai.get_By_Id(spct.getIdCtdc()).getTenCachThuc();
            String lop = serviceLop.get_By_Id(spct.getIdLop()).getSoLop() + "";
            String mu = serviceMu.get_By_Id(spct.getIdMs()).getTenKieuMu();
//            System.out.println(mu);
            modelSpct.addRow(new Object[]{
                index++,
                maSp,
                tenSp,
                spct.getSoLuong(),
                spct.getGia(),
                size,
                ms,
                chatLieu,
                kieuDang,
                khoa,
                lop,
                mu,
                spct.getMoTa(),
                spct.isTrangThai() == true ? "Còn" : "Hết"
            });
        }
    }

    void showDataSanPham(List<SanPham> list) {
        int indexSp = 1;
        modelSp.setRowCount(0);
        System.out.println(list.toString());
        for (SanPham sanPham : list) {
            modelSp.addRow(new Object[]{
                indexSp++,
                sanPham.getMaSp(),
                sanPham.getTenSp(),
                serviceSp.getSoLuongByID(Integer.parseInt(sanPham.getIdSp() + "")),
                sanPham.getIdSp()
            });
        }
    }

//    void showDataSpct(List<SanPhamChiTiet> list) {
//        int indexSpct = 1;
//        modelSpct.setRowCount(0);
//        for (SanPhamChiTiet spct : list) {
//            String maSp = serviceSp.getById(spct.getIdSp()).getMaSp();
//            String tenSp = serviceSp.getById(spct.getIdSp()).getTenSp();
//            modelSpct.addRow(new Object[]{
//                indexSpct++,
//                maSp,
//                tenSp,
//                spct.getSoLuong(),
//                spct.getGia(),
//                spct.getMoTa(),
//                spct.isTrangThai() == true ? "Còn" : "Hết"
//            });
//        }
//    }
    void showDataSize(List<Size> list) {
        int indexSize = 1;
        modelThuocTinh.setRowCount(0);
        for (Size size : list) {
            modelThuocTinh.addRow(new Object[]{
                indexSize++,
                size.getMaSize(),
                size.getTenSize()
            });
        }
    }

    void showDataChatLieu(List<ChatLieu> list) {
        int indexCl = 1;
        modelThuocTinh.setRowCount(0);
        for (ChatLieu cl : list) {
            modelThuocTinh.addRow(new Object[]{
                indexCl++,
                cl.getMaChatLieu(),
                cl.getTenChatLieu()
            });
        }
    }

    void showDataMu(List<KieuMu> list) {
        int indexMu = 1;
        modelThuocTinh.setRowCount(0);
        for (KieuMu mu : list) {
            modelThuocTinh.addRow(new Object[]{
                indexMu++,
                mu.getMaKieuMu(),
                mu.getTenKieuMu()
            });
        }
    }

    void showDataMauSac(List<MauSac> list) {
        int indexMs = 1;
        modelThuocTinh.setRowCount(0);
        for (MauSac ms : list) {
            modelThuocTinh.addRow(new Object[]{
                indexMs++,
                ms.getMaMauSac(),
                ms.getTenMauSac()
            });
        }
    }

    void showDataKieuDang(List<KieuDang> list) {
        int indexKd = 1;
        modelThuocTinh.setRowCount(0);
        for (KieuDang kd : list) {
            modelThuocTinh.addRow(new Object[]{
                indexKd++,
                kd.getMaKd(),
                kd.getTenKd()
            });
        }
    }

    void showDataLop(List<LopAo> list) {
        int indexLop = 1;
        modelThuocTinh.setRowCount(0);
        for (LopAo lop : list) {
            modelThuocTinh.addRow(new Object[]{
                indexLop++,
                lop.getMaLop(),
                lop.getSoLop()
            });
        }
    }

    void showDataKhoaCai(List<CachThucDongCua> list) {
        int indexKhoa = 1;
        modelThuocTinh.setRowCount(0);
        for (CachThucDongCua khoaCai : list) {
            modelThuocTinh.addRow(new Object[]{
                indexKhoa++,
                khoaCai.getMaCachThuc(),
                khoaCai.getTenCachThuc()
            });
        }
    }
//----------------------------------------End------------------------------------------------

//-----------------------------Mã Tự Sinh-----------------------
    private static Random generator = new Random();

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
//-------------------end-----------------------

    void showDetailDongDauSp() {
        SanPham index = serviceSp.getAll().get(0);
        tfMaSanPham.setText(index.getMaSp());
        tfTenSanPham.setText(index.getTenSp());
        tbSanPham.setRowSelectionInterval(0, 0);
    }

    void showDetailDongDauSpct() {
        SanPham index = serviceSp.getById(1);
        tfThemThuocTinh.setText(index.getMaSp());
        tfTenSpct.setText(index.getTenSp());
        SanPhamChiTiet indexSpct = serviceSpct.getAll().get(0);
        tfSoLuong.setText(indexSpct.getSoLuong() + "");
        tfGia.setText(indexSpct.getGia() + "");
        taMoTa.setText(indexSpct.getMoTa());
        tbSpct.setRowSelectionInterval(0, 0);
    }

    void showDetail() {
        int indexSp = tbSanPham.getSelectedRow();
        tfMaSanPham.setText(tbSanPham.getValueAt(indexSp, 1).toString());
        tfTenSanPham.setText(tbSanPham.getValueAt(indexSp, 2).toString());
    }

    void showDetailThongTinSp() {
        int index = tbThuocTinh.getSelectedRow();
        tfMaThuocTinh.setText(tbThuocTinh.getValueAt(index, 1).toString());
        tfTenThuocTinh.setText(tbThuocTinh.getValueAt(index, 2).toString());
    }

    void showDetailSpct() {
        int index = tbSpct.getSelectedRow();
//        tfThemThuocTinh.setText(tbSpct.getValueAt(index, 1).toString());
        tfTenSpct.setText(tbSpct.getValueAt(index, 2).toString());
        tfSoLuong.setText(tbSpct.getValueAt(index, 3).toString());
        tfGia.setText(tbSpct.getValueAt(index, 4).toString());
        taMoTa.setText(tbSpct.getValueAt(index, 5).toString());
        cbbSize.setSelectedItem(index);
    }

    boolean checkFormSpct() {
        if (tfTenSpct.getText().trim().isEmpty()) {
            return false;
        }
        if (tfSoLuong.getText().trim().isEmpty()) {
            return false;
        }
        if (tfGia.getText().trim().isEmpty()) {
            return false;
        }
        if (taMoTa.getText().trim().isEmpty()) {
            return false;
        }
        if (tfSoLuong.getText().matches("^[0-9]+$")) {
            return false;
        }
        if (tfGia.getText().matches("^[0-9]+$")) {
            return false;
        }

        return true;
    }
//    SanPham getSpByRowinTable(){
//        int rowTbSp = tbSanPham.getSelectedRow();
//        String id = String.valueOf(tbSanPham.getValueAt(rowTb, 4));
//        if (rowTbSp>=0) {
//            SanPham sp = 
//        }
//    }
//------------------------Thuộc Tính---------------------------------------
    MauSac getFormMauSac() {
        return new MauSac(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }
    private boolean checkFormMauSac() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (MauSac s : serviceMauSac.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(s.getTenMauSac())) {
            JOptionPane.showMessageDialog(this, "Đã có màu này");
            return false;
        }
        }
        return true;
    }
    Size getFormSize() {
        return new Size(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }

    private boolean checkFormSize() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (Size s : serviceSize.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(s.getTenSize())) {
            JOptionPane.showMessageDialog(this, "Đã có size này");
            return false;
        }
        }
        return true;
    }
    LopAo getFormLop() {
        return new LopAo(randomAlphaNumeric(8), Integer.parseInt(tfTenThuocTinh.getText()), true);
    }

    private boolean checkFormLop() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lớp");
            return false;
        }
        for (LopAo lop : serviceLop.getAll()) {
            if (tfTenThuocTinh.getText().equalsIgnoreCase(lop.getSoLop()+"")) {
                JOptionPane.showMessageDialog(this, "Đã có số lớp này");
                return false;
            }
        }
        String checkSo = "^-?[1-7]\\d*$";
        if (!tfTenThuocTinh.getText().matches(checkSo)) {
            JOptionPane.showMessageDialog(this, "Số lớp lỗi kĩ tự");
            return false;
        }
        return true;
    }
    ChatLieu getFormCl() {
        return new ChatLieu(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }

    private boolean checkFormCl() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (ChatLieu cl : serviceChatLieu.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(cl.getTenChatLieu())) {
            JOptionPane.showMessageDialog(this, "Đã có chất liệu này");
            return false;
        }
        }
        return true;
    }
    KieuDang getFormKD() {
        return new KieuDang(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }

    private boolean checkFormKD() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (KieuDang kd : serviceKd.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(kd.getTenKd())) {
            JOptionPane.showMessageDialog(this, "Đã có chất liệu này");
            return false;
        }
        }
        return true;
    }
    CachThucDongCua getFormCTDC() {
        return new CachThucDongCua(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }

    private boolean checkFormCTDC() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (CachThucDongCua ctdc : serviceKhoaCai.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(ctdc.getTenCachThuc())) {
            JOptionPane.showMessageDialog(this, "Đã có chất liệu này");
            return false;
        }
        }
        return true;
    }
    KieuMu getFormMu() {
        return new KieuMu(randomAlphaNumeric(8), tfTenThuocTinh.getText(), true);
    }

    private boolean checkFormMu() {
        if (tfTenThuocTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên");
            return false;
        }
        for (KieuMu mu : serviceMu.getAll()) {
        if (tfTenThuocTinh.getText().equalsIgnoreCase(mu.getTenKieuMu())) {
            JOptionPane.showMessageDialog(this, "Đã có chất liệu này");
            return false;
        }
        }
        return true;
    }
//------------------------end--------------------------------------
    SanPham getSPbyRowinTable(){
        int rowTbSP = tbSanPham.getSelectedRow();
        String id = String.valueOf(tbSanPham.getValueAt(rowTbSP, 4));
        if (rowTbSP >=0) {
            SanPham sp = serviceSp.getById(Integer.parseInt(id));
            if (sp!=null) {
                return sp;
            }
        }
        return new SanPham();
    }
    SanPhamChiTiet getFormSpct() {

        SanPhamChiTiet spct = new SanPhamChiTiet();
        SanPham sp = getSPbyRowinTable();   
        KieuDang kd = (KieuDang) cbbKieuDang.getSelectedItem();
        Size s = (Size) cbbSize.getSelectedItem();
        ChatLieu cl = (ChatLieu) cbbChatLieu.getSelectedItem();
        MauSac ms = (MauSac) cbbMauSac.getSelectedItem();
        LopAo lop = (LopAo) cbbLop.getSelectedItem();
        KieuMu mu = (KieuMu) cbbMu.getSelectedItem();
        CachThucDongCua ctdc = (CachThucDongCua) cbbKhoaCai.getSelectedItem();
        spct.setIdCl(cl.getIdChatLieu());
        spct.setIdCtdc(ctdc.getIdCachThuc());
        spct.setIdKd(kd.getIdKd());
        spct.setIdLop(lop.getIdLop());
        spct.setIdMs(ms.getIdMauSac());
        spct.setIdMu(mu.getIdKieuMu());
        spct.setIdSize(s.getIdSize());
        spct.setIdSp(sp.getIdSp());
        spct.setGia(Float.parseFloat(tfGia.getText()));
        spct.setMoTa(taMoTa.getText());
        spct.setSoLuong(Integer.parseInt(tfSoLuong.getText()));
        spct.setTrangThai(true);
        return spct;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jpSP = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfTenSanPham = new javax.swing.JTextField();
        tfMaSanPham = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btnXuatExcelSp = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jButton26 = new javax.swing.JButton();
        btnPrevSp = new javax.swing.JButton();
        btnNextSp = new javax.swing.JButton();
        lbSoTrangSp = new javax.swing.JLabel();
        tfTimKiemSp = new com.fpt.utils.TextField();
        jpSpct = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfThemThuocTinh = new javax.swing.JTextField();
        tfTenSpct = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfGia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taMoTa = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbbMu = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbKieuDang = new javax.swing.JComboBox<>();
        cbbKhoaCai = new javax.swing.JComboBox<>();
        cbbLop = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnXuatExcelSpct = new javax.swing.JButton();
        btnSize = new javax.swing.JButton();
        btnMs = new javax.swing.JButton();
        btnCl = new javax.swing.JButton();
        btnKieuDang = new javax.swing.JButton();
        btnKhoaCai = new javax.swing.JButton();
        btnLop = new javax.swing.JButton();
        btnMu = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lbSoTrang = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbSpct = new javax.swing.JTable();
        tfTimKiemSpct = new com.fpt.utils.TextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        rdSize = new javax.swing.JRadioButton();
        rdKhoaCai = new javax.swing.JRadioButton();
        rdMauSac = new javax.swing.JRadioButton();
        rdChatLieu = new javax.swing.JRadioButton();
        rdKieuDang = new javax.swing.JRadioButton();
        rdLop = new javax.swing.JRadioButton();
        rdMu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMaThuocTinh = new javax.swing.JTextField();
        tfTenThuocTinh = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbThuocTinh = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jpSP.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Mã Sản Phẩm");

        jLabel7.setText("Tên Sản Phẩm");

        tfMaSanPham.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(59, 59, 59))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton9.setBackground(new java.awt.Color(204, 204, 255));
        jButton9.setText("Thêm");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 204, 255));
        jButton10.setText("Sửa");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(204, 204, 255));
        jButton11.setText("Chi Tiết Sản Phẩm");

        jButton12.setBackground(new java.awt.Color(204, 204, 255));
        jButton12.setText("Làm mới");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        btnXuatExcelSp.setBackground(new java.awt.Color(204, 204, 255));
        btnXuatExcelSp.setText("Xuất file Excel");
        btnXuatExcelSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(btnXuatExcelSp, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(btnXuatExcelSp)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Dạnh Sách Sản Phẩm"));

        jLabel8.setText("Tìm Kiếm");

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);
        if (tbSanPham.getColumnModel().getColumnCount() > 0) {
            tbSanPham.getColumnModel().getColumn(4).setMinWidth(0);
            tbSanPham.getColumnModel().getColumn(4).setPreferredWidth(0);
            tbSanPham.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N

        btnPrevSp.setText("<<");
        btnPrevSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevSpActionPerformed(evt);
            }
        });

        btnNextSp.setText(">>");
        btnNextSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextSpActionPerformed(evt);
            }
        });

        lbSoTrangSp.setText("jLabel3");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btnPrevSp)
                        .addGap(39, 39, 39)
                        .addComponent(lbSoTrangSp)
                        .addGap(39, 39, 39)
                        .addComponent(btnNextSp))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(tfTimKiemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(195, 195, 195)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfTimKiemSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevSp)
                    .addComponent(btnNextSp)
                    .addComponent(lbSoTrangSp))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpSPLayout = new javax.swing.GroupLayout(jpSP);
        jpSP.setLayout(jpSPLayout);
        jpSPLayout.setHorizontalGroup(
            jpSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSPLayout.createSequentialGroup()
                .addGroup(jpSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSPLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jpSPLayout.setVerticalGroup(
            jpSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sản Phẩm", jpSP);

        jpSpct.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jLabel9.setText("Thêm Thuộc Tính");

        jLabel10.setText("Tên SP");

        jLabel11.setText("Số Lượng");

        jLabel12.setText("Giá");

        jLabel13.setText("Mô Tả");

        tfThemThuocTinh.setEditable(false);

        taMoTa.setColumns(20);
        taMoTa.setRows(5);
        jScrollPane2.setViewportView(taMoTa);

        jLabel14.setText("Size");

        jLabel15.setText("Màu Sắc");

        jLabel16.setText("Chất Liệu");

        jLabel17.setText("Kiểu Dáng");

        jLabel18.setText("Khoá Cài");

        jLabel19.setText("Lớp");

        jLabel20.setText("Mũ");

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Len", "Bông", "Da" }));

        cbbKieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thời Trang", "Lịch Sự", "Thể Thao", "Giới Trẻ" }));

        cbbKhoaCai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoá Kéo", "Cúc Bấm" }));

        cbbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Thêm Sản Phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Cập Nhật Sản Phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setText("Làm Mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setText("Ẩn Sản Phẩm");

        btnXuatExcelSpct.setBackground(new java.awt.Color(204, 204, 255));
        btnXuatExcelSpct.setText("Xuất file Excel");
        btnXuatExcelSpct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelSpctActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXuatExcelSpct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(btnXuatExcelSpct)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addGap(25, 25, 25))
        );

        btnSize.setBackground(new java.awt.Color(204, 204, 255));
        btnSize.setText("+");
        btnSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeActionPerformed(evt);
            }
        });

        btnMs.setBackground(new java.awt.Color(204, 204, 255));
        btnMs.setText("+");
        btnMs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMsActionPerformed(evt);
            }
        });

        btnCl.setBackground(new java.awt.Color(204, 204, 255));
        btnCl.setText("+");
        btnCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClActionPerformed(evt);
            }
        });

        btnKieuDang.setBackground(new java.awt.Color(204, 204, 255));
        btnKieuDang.setText("+");
        btnKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKieuDangActionPerformed(evt);
            }
        });

        btnKhoaCai.setBackground(new java.awt.Color(204, 204, 255));
        btnKhoaCai.setText("+");
        btnKhoaCai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaCaiActionPerformed(evt);
            }
        });

        btnLop.setBackground(new java.awt.Color(204, 204, 255));
        btnLop.setText("+");
        btnLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLopActionPerformed(evt);
            }
        });

        btnMu.setBackground(new java.awt.Color(204, 204, 255));
        btnMu.setText("+");
        btnMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(tfGia)
                    .addComponent(tfSoLuong)
                    .addComponent(tfTenSpct)
                    .addComponent(tfThemThuocTinh))
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbKieuDang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbKhoaCai, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbLop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbMu, 0, 111, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMu)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSize)
                        .addComponent(btnMs)
                        .addComponent(btnKieuDang)
                        .addComponent(btnKhoaCai)
                        .addComponent(btnLop))
                    .addComponent(btnCl, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(40, 40, 40)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfThemThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSize))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfTenSpct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMs))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(cbbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKieuDang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cbbKhoaCai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKhoaCai))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLop))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(cbbMu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMu)))))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Dạnh Sách Sản Phẩm"));

        jLabel21.setText("Tìm Kiếm");

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lbSoTrang.setText("jLabel3");

        tbSpct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số Lượng", "Giá", "Size", "Màu Sắc", "Chất Liệu", "Kiểu Dáng", "Khoá Cài", "Lớp", "Mũ", "Mô Tả", "Trạng Thái"
            }
        ));
        tbSpct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSpctMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbSpct);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTimKiemSpct, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(btnPrev)
                        .addGap(39, 39, 39)
                        .addComponent(lbSoTrang)
                        .addGap(37, 37, 37)
                        .addComponent(btnNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tfTimKiemSpct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(lbSoTrang)
                    .addComponent(btnNext))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpSpctLayout = new javax.swing.GroupLayout(jpSpct);
        jpSpct.setLayout(jpSpctLayout);
        jpSpctLayout.setHorizontalGroup(
            jpSpctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSpctLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSpctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jpSpctLayout.setVerticalGroup(
            jpSpctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSpctLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Sản Phẩm Chi Tiết", jpSpct);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết Lập Thuộc Tính"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setText("Ẩn");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(204, 204, 255));
        jButton19.setText("Sửa");

        jButton28.setBackground(new java.awt.Color(204, 204, 255));
        jButton28.setText("Làm mới");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton19)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton28)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Size");

        jLabel23.setText("Màu Sắc");

        jLabel24.setText("Chất Liệu");

        jLabel25.setText("Kiểu Dáng");

        jLabel26.setText("Khoá Cài");

        jLabel27.setText("Lớp");

        jLabel28.setText("Mũ");

        buttonGroup1.add(rdSize);
        rdSize.setSelected(true);
        rdSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdSizeMouseClicked(evt);
            }
        });
        rdSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSizeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdKhoaCai);
        rdKhoaCai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdKhoaCaiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdMauSac);
        rdMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdChatLieu);
        rdChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChatLieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdKieuDang);
        rdKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdKieuDangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdLop);
        rdLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLopActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdMu);
        rdMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(14, 14, 14)
                        .addComponent(rdKieuDang))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdSize)
                                    .addComponent(rdMauSac)
                                    .addComponent(rdChatLieu))))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdMu))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdLop))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(rdKhoaCai)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdSize)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26)
                    .addComponent(rdKhoaCai))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(rdMauSac, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdLop, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(rdMu)
                    .addComponent(jLabel24)
                    .addComponent(rdChatLieu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdKieuDang)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã Thuộc Tính");

        jLabel2.setText("Tên Thuộc Tính");

        tfMaThuocTinh.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMaThuocTinh)
                    .addComponent(tfTenThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Thuộc Tính"));

        tbThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Thuộc TÍnh", "Tên Thuộc Tính"
            }
        ));
        tbThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbThuocTinh);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thuộc Tính Sản Phẩm", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {

            JOptionPane.showMessageDialog(this, "Đã Thêm");

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
//        showDataFullSpct(serviceSpct.getAll());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (rdChatLieu.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    ChatLieu cl = getFormCl();
                        serviceChatLieu.addCl(cl);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataChatLieu(serviceChatLieu.getAll());
                        tfTenThuocTinh.setText("");
                        loaiChatLieu();
                }
        }else if (rdSize.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    Size s = getFormSize();
                        serviceSize.AddSize(s);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataSize(serviceSize.getAll());
                        tfTenThuocTinh.setText("");
                        loaiSize();
                }
        }else if (rdLop.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    LopAo lop = getFormLop();
                        serviceLop.addLop(lop);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataLop(serviceLop.getAll());
                        tfTenThuocTinh.setText("");
                        soLop();
                }
        }else if (rdMauSac.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    MauSac ms = getFormMauSac();
                        serviceMauSac.addMs(ms);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataMauSac(serviceMauSac.getAll());
                        tfTenThuocTinh.setText("");
                }
        }else if (rdKieuDang.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    KieuDang kd = getFormKD();
                        serviceKd.addKD(kd);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataKieuDang(serviceKd.getAll());
                        tfTenThuocTinh.setText("");
                        loaiMauSac();
                }
        }else if (rdKhoaCai.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    CachThucDongCua ctdc = getFormCTDC();
                        serviceKhoaCai.addCTDC(ctdc);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataKhoaCai(serviceKhoaCai.getAll());
                        tfTenThuocTinh.setText("");
                        loaiKhoaCai();
                }
        }else if (rdMu.isSelected()) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {
                    KieuMu mu = getFormMu();
                        serviceMu.addMu(mu);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        showDataMu(serviceMu.getAll());
                        tfTenThuocTinh.setText("");
                        loaiMu();
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        // TODO add your handling code here:
//        SanPham sp = serviceSp.getAll().get(tbSanPham.getSelectedRow());
//        SanPham sp = new SanPham();
//        for (SanPhamChiTiet spct : listSpct) {
//            if (spct.equals(serviceSp.getById(spct.getIdSp()).getTenSp())) {
//                showDataSpct(listSpct);
//            }
//        }

        try {
            if (evt.getClickCount() == 2) {
                int row = tbSanPham.getSelectedRow();
                listSpct = serviceSpct.phanTrang(pageSpct, 5);
                showDataFullSpct(listSpct);
                String name = tbSpct.getValueAt(row, 2).toString();
//                jpSpct.setEnabled(true);
                showDataFullSpct(serviceSpct.getAllByName(name));
            }
        } catch (Exception e) {
        }
        showDetail();
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void rdSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdSizeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rdSizeMouseClicked

    private void rdSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSizeActionPerformed
        // TODO add your handling code here:
        showDataSize(serviceSize.getAll());
    }//GEN-LAST:event_rdSizeActionPerformed

    private void rdMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMauSacActionPerformed
        // TODO add your handling code here:
        showDataMauSac(serviceMauSac.getAll());
    }//GEN-LAST:event_rdMauSacActionPerformed

    private void rdChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChatLieuActionPerformed
        // TODO add your handling code here:
        showDataChatLieu(serviceChatLieu.getAll());
    }//GEN-LAST:event_rdChatLieuActionPerformed

    private void rdMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMuActionPerformed
        // TODO add your handling code here:
        showDataMu(serviceMu.getAll());
    }//GEN-LAST:event_rdMuActionPerformed

    private void rdKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdKieuDangActionPerformed
        // TODO add your handling code here:
        showDataKieuDang(serviceKd.getAll());
    }//GEN-LAST:event_rdKieuDangActionPerformed

    private void rdKhoaCaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdKhoaCaiActionPerformed
        // TODO add your handling code here:
        showDataKhoaCai(serviceKhoaCai.getAll());
    }//GEN-LAST:event_rdKhoaCaiActionPerformed

    private void rdLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLopActionPerformed
        // TODO add your handling code here:
        showDataLop(serviceLop.getAll());
    }//GEN-LAST:event_rdLopActionPerformed

    private void tbThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThuocTinhMouseClicked
        // TODO add your handling code here:
        //tb
        int row = tbThuocTinh.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn 1 dòng");
            return;
        }
        if (rdChatLieu.isSelected()) {
            ChatLieu cl = serviceChatLieu.getAll().get(row);
//            setFormTTCL(cl);
        } else if (rdSize.isSelected()) {
            Size s = serviceSize.getAll().get(row);
//            setFormTTCPU(cpu);
        } else if (rdKieuDang.isSelected()) {
            KieuDang kd = serviceKd.getAll().get(row);
//            setFormTTDL(dl);
        } else if (rdKhoaCai.isSelected()) {
            CachThucDongCua ctdc = serviceKhoaCai.getAll().get(row);
//            setFormTTGPU(gpu);
        }else if (rdLop.isSelected()) {
            LopAo lop = serviceLop.getAll().get(row);
//            setFormTTGPU(gpu);
        }
        else if (rdMu.isSelected()) {
            KieuMu mu = serviceMu.getAll().get(row);
//            setFormTTGPU(gpu);
        }
        else if (rdMauSac.isSelected()) {
            MauSac ms = serviceMauSac.getAll().get(row);
//            setFormTTGPU(gpu);
        }
        showDetailThongTinSp();
    }//GEN-LAST:event_tbThuocTinhMouseClicked

    private void btnSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeActionPerformed
        // TODO add your handling code here:
        new ViewSize().setVisible(true);
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().dispose();
        new ViewKieuDang().dispose();
        new ViewLop().dispose();
        new ViewMauSac().dispose();
        new ViewMu().dispose();
        loaiSize();
//        new ViewSanPhamChiTiet().dispose();
    }//GEN-LAST:event_btnSizeActionPerformed

    private void btnMsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMsActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().dispose();
        new ViewKieuDang().dispose();
        new ViewLop().dispose();
        new ViewMauSac().setVisible(true);
        new ViewMu().dispose();
        loaiMauSac();
    }//GEN-LAST:event_btnMsActionPerformed

    private void btnClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().setVisible(true);
        new ViewKieuDang().dispose();
        new ViewLop().dispose();
        new ViewMauSac().dispose();
        new ViewMu().dispose();
//        new ViewSanPhamChiTiet();
    }//GEN-LAST:event_btnClActionPerformed

    private void btnKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKieuDangActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().dispose();
        new ViewKieuDang().setVisible(true);
        new ViewLop().dispose();
        new ViewMauSac().dispose();
        new ViewMu().dispose();
//        new ViewSanPhamChiTiet();
    }//GEN-LAST:event_btnKieuDangActionPerformed

    private void btnKhoaCaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaCaiActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().setVisible(true);
        new ViewChatLieu().dispose();
        new ViewKieuDang().dispose();
        new ViewLop().dispose();
        new ViewMauSac().dispose();
        new ViewMu().dispose();
    }//GEN-LAST:event_btnKhoaCaiActionPerformed

    private void btnLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLopActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().dispose();
        new ViewKieuDang().dispose();
        new ViewLop().setVisible(true);
        new ViewMauSac().dispose();
        new ViewMu().dispose();
    }//GEN-LAST:event_btnLopActionPerformed

    private void btnMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuActionPerformed
        // TODO add your handling code here:
        new ViewSize().dispose();
        new ViewCachThucDongCua().dispose();
        new ViewChatLieu().dispose();
        new ViewKieuDang().dispose();
        new ViewLop().dispose();
        new ViewMauSac().dispose();
        new ViewMu().setVisible(true);
    }//GEN-LAST:event_btnMuActionPerformed

    private void btnNextSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextSpActionPerformed
        // TODO add your handling code here:
        this.pageSp++;
        btnPrevSp.setEnabled(true);
        if (pageSp >= maxSp) {
            btnNextSp.setEnabled(false);
        }
        listSp = serviceSp.phanTrang(pageSp, 5);
//        showDetailDongDau();
        showDataSanPham(listSp);
        lbSoTrangSp.setText(String.valueOf(pageSp) + "/" + maxSp);
    }//GEN-LAST:event_btnNextSpActionPerformed

    private void btnPrevSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevSpActionPerformed
        // TODO add your handling code here:
        this.pageSp--;
        btnNextSp.setEnabled(true);
        if (pageSp < 2) {
            btnPrevSp.setEnabled(false);
        }
        listSp = serviceSp.phanTrang(pageSp, 5);
        showDataSanPham(listSp);
        lbSoTrangSp.setText(String.valueOf(pageSp) + "/" + maxSp);
    }//GEN-LAST:event_btnPrevSpActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        this.pageSpct++;
        btnPrev.setEnabled(true);
        if (pageSpct >= maxSpct) {
            btnNext.setEnabled(false);
        }
        listSpct = serviceSpct.phanTrang(pageSpct, 5);
        showDataFullSpct(listSpct);
        lbSoTrang.setText(String.valueOf(pageSpct) + "/" + maxSpct);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        this.pageSpct--;
        btnNext.setEnabled(true);
        if (pageSpct < 2) {
            btnPrev.setEnabled(false);
        }
        listSpct = serviceSpct.phanTrang(pageSpct, 5);
        showDataFullSpct(listSpct);
        lbSoTrang.setText(String.valueOf(pageSpct) + "/" + maxSpct);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?") == 0) {

            JOptionPane.showMessageDialog(this, "Đã Thêm");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?") == 0) {

            JOptionPane.showMessageDialog(this, "Đã sửa");

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?") == 0) {

            JOptionPane.showMessageDialog(this, "Đã sửa");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tfGia.setText("");
        tfSoLuong.setText("");
        tfThemThuocTinh.setText("");
        taMoTa.setText("");
        tfTenSpct.setText("");
        cbbSize.setSelectedItem(0);
        loaiSize();
        loaiMauSac();
        loaiChatLieu();
        loaiKhoaCai();
        soLop();
        listSpct = serviceSpct.phanTrang(pageSpct, 5);
        showDataFullSpct(listSpct);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSanPhamMouseEntered

    private void tfTimKiemSpctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemSpctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemSpctActionPerformed

    private void tfTimKiemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemSpActionPerformed

    private void tfTimKiemSpctKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSpctKeyTyped
        // TODO add your handling code here:
        try {

            showDataFullSpct(serviceSpct.search(tfTimKiemSpct.getText()));
//            System.out.println(serviceSpct.search(tfTimKiemSpct.getText()));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "khong tim thay");
        }
    }//GEN-LAST:event_tfTimKiemSpctKeyTyped

    private void tfTimKiemSpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSpKeyTyped
        // TODO add your handling code here:
        try {
            showDataSanPham(serviceSp.search(tfTimKiemSp.getText()));
//            System.out.println(serviceSp.search(tfTimKiemSp.getText()));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "khong tim thay");
        }
    }//GEN-LAST:event_tfTimKiemSpKeyTyped
    public void excelSanPhamChiTiet() throws IOException {
        excel.outExcel((DefaultTableModel) tbSpct.getModel());
        MsgBox.alert(this, "Xuất file thành công");
    }
    private void btnXuatExcelSpctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelSpctActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file không ?") == 0) {
                excelSanPhamChiTiet();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXuatExcelSpctActionPerformed
    public void excelSanPham() throws IOException {
        excel.outExcel((DefaultTableModel) tbSanPham.getModel());
        MsgBox.alert(this, "Xuất file thành công");
    }
    private void btnXuatExcelSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelSpActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file không ?") == 0) {
                excelSanPham();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnXuatExcelSpActionPerformed

    private void tbSpctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSpctMouseClicked
        // TODO add your handling code here:
        int size = tbSpct.getSelectedRow();
        showDetailSpct();
//        cbbSizeSpct.setSelectedItem(size);
        //        showDataFullSpct(serviceSpct.getAllByName(size+""));
    }//GEN-LAST:event_tbSpctMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCl;
    private javax.swing.JButton btnKhoaCai;
    private javax.swing.JButton btnKieuDang;
    private javax.swing.JButton btnLop;
    private javax.swing.JButton btnMs;
    private javax.swing.JButton btnMu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNextSp;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrevSp;
    private javax.swing.JButton btnSize;
    private javax.swing.JButton btnXuatExcelSp;
    private javax.swing.JButton btnXuatExcelSpct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKhoaCai;
    private javax.swing.JComboBox<String> cbbKieuDang;
    private javax.swing.JComboBox<String> cbbLop;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbMu;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel jpSP;
    private javax.swing.JPanel jpSpct;
    private javax.swing.JLabel lbSoTrang;
    private javax.swing.JLabel lbSoTrangSp;
    private javax.swing.JRadioButton rdChatLieu;
    private javax.swing.JRadioButton rdKhoaCai;
    private javax.swing.JRadioButton rdKieuDang;
    private javax.swing.JRadioButton rdLop;
    private javax.swing.JRadioButton rdMauSac;
    private javax.swing.JRadioButton rdMu;
    private javax.swing.JRadioButton rdSize;
    private javax.swing.JTextArea taMoTa;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tbSpct;
    private javax.swing.JTable tbThuocTinh;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfMaSanPham;
    private javax.swing.JTextField tfMaThuocTinh;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfTenSpct;
    private javax.swing.JTextField tfTenThuocTinh;
    private javax.swing.JTextField tfThemThuocTinh;
    private com.fpt.utils.TextField tfTimKiemSp;
    private com.fpt.utils.TextField tfTimKiemSpct;
    // End of variables declaration//GEN-END:variables
}
