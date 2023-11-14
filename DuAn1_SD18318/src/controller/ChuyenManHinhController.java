package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.BanHangJPanel;
import view.HoaDonJPanel;
import view.KhachHangJPanel;
import view.PhieuGiamGiaJPanel;
import view.SanPhamJPanel;
import view.NhanVienJPanel;

/**
 *
 * @author PC
 */
public class ChuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "BanHang";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new BanHangJPanel());
        root.validate();
        root.repaint();

    }

    public void setEventList(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;

        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {

            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "BanHang":
                    node = new BanHangJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                case "SanPham":
                    node = new SanPhamJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                case "PhieuGiamGia":
                    node = new PhieuGiamGiaJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                case "NhanVien":
                    node = new NhanVienJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                case "KhachHang":
                    node = new KhachHangJPanel();
                    jpnItem.setBackground(new Color(180, 220, 241));
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(242, 242, 242));
            jlbItem.setBackground(new Color(242, 242, 242));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(242, 242, 242));
            jlbItem.setBackground(new Color(242, 242, 242));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(180, 220, 241));
//                jlbItem.setBackground(new Color(242,242,242));
            }
        }

    }

    public void setChangeBackgroud(String kind) {
        for (DanhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
//                item.getJlb().setBackground(new Color(242,242,242));

//                item.getJpn().setBackground(new Color(242,242,242));
            } else {
                item.getJlb().setBackground(new Color(242, 242, 242));
//                item.getJpn().setBackground(new Color(242,242,242));
            }

        }
    }

}
