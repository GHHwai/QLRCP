import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public final class NhanVienUI extends JFrame {
	public NhanVienUI() {
		super("Nhân Viên Quản Lí");
		initUI();
	}
	public void initUI() {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel p1= new JPanel();
		p1.setLayout(new GridLayout(1,2));
		JButton b1= new JButton("Khách hàng");
		JButton b2= new JButton("Phim");
		JButton b3= new JButton("Thoát");
		p1.add(b1); p1.add(b2);
		this.add(p1, BorderLayout.NORTH);
		ArrayList<khachhang> khdata= new ArrayList<>();
		khdata.add(new khachhang(1, "2", "3", "4"));
		khdata.add(new khachhang(2, "3", "4", "5"));
		ArrayList<phim> phimdata= new ArrayList<>();
		phimdata.add(new phim(1, "2", "3", 4, "5-5-2020", "6", "7"));
		phimdata.add(new phim(2, "3", "4", 5, "5-5-2020", "7", "8"));
		Object[][] khdatatab= new Object[khdata.size()][4];
		Object[][] phimdatatab= new Object[phimdata.size()][6];
		for (int i=0; i<khdata.size(); i++) {
			khdatatab[i][0]=khdata.get(i).ID;
			khdatatab[i][1]=khdata.get(i).name;
			khdatatab[i][2]=khdata.get(i).phoneNumber;
			khdatatab[i][3]=khdata.get(i).type;
		}
		for (int i=0; i<phimdata.size(); i++) {
			phimdatatab[i][0]=phimdata.get(i).ID;
			phimdatatab[i][1]=phimdata.get(i).title;
			phimdatatab[i][2]=phimdata.get(i).genre;
			phimdatatab[i][3]=phimdata.get(i).duration;
			phimdatatab[i][4]=phimdata.get(i).director;
			phimdatatab[i][5]=phimdata.get(i).releaseDate;
		}
		String[] cotkh= {"ID", "Tên", "Số điện thoại", "Loại khách"};
		String[] cotph= {"ID", "Tiêu đề", "Thể loại phim", "Thời hạn phim", "Đạo diễn", "Ngày phát hành"};
		JTable t1= new JTable(khdatatab, cotkh);
		JTable t2= new JTable(phimdatatab, cotph);
		JScrollPane sp1= new JScrollPane(t1);
		JScrollPane sp2= new JScrollPane(t2);
		JPanel p2= new JPanel();
		p2.setLayout(new CardLayout());
		p2.add(sp1); p2.add(sp2);
		this.add(p2, BorderLayout.CENTER);
		b1.addActionListener((ActionEvent e)-> {
			sp1.setVisible(true);
			sp2.setVisible(false);
		});
		b2.addActionListener((ActionEvent e)-> {
			sp1.setVisible(false);
			sp2.setVisible(true);
		});
	}
	public static void main(String[] args) {
		try{
			(new NhanVienUI()).setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
