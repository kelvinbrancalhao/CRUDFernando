package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import Trabalho.Empresa;
import Trabalho.HibernateUtil;

@SuppressWarnings("serial")
public class ConEmp extends JInternalFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCon;
	private JRadioButton rdbtnEq;
	private JRadioButton rdbtnNe;
	private JComboBox cbbCampo;
	private JRadioButton rdbtnGt;
	private JRadioButton rdbtnLt;
	private JRadioButton rdbtnIlike;
	private JRadioButton rdbtnNotNull;
	private JRadioButton rdbtnGe;
	private JRadioButton rdbtnLe;
	private JTable table;
	private JRadioButton rdbtnLike;
	private JRadioButton rdbtnAll;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConEmp frame = new ConEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConEmp() {
		setTitle("Consulta Empresas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		rdbtnEq = new JRadioButton("Eq");
		buttonGroup.add(rdbtnEq);
		rdbtnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("nomeF");
				cbbCampo.addItem("cnpj");
				cbbCampo.addItem("end");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("ie");
				cbbCampo.addItem("email");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnEq.setBounds(6, 7, 63, 23);
		panel.add(rdbtnEq);
		
		rdbtnNe = new JRadioButton("Ne");
		buttonGroup.add(rdbtnNe);
		rdbtnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("nomeF");
				cbbCampo.addItem("cnpj");
				cbbCampo.addItem("end");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("ie");
				cbbCampo.addItem("email");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnNe.setBounds(71, 7, 63, 23);
		panel.add(rdbtnNe);
		
		rdbtnGt = new JRadioButton("Gt");
		buttonGroup.add(rdbtnGt);
		rdbtnGt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnGt.setBounds(136, 7, 63, 23);
		panel.add(rdbtnGt);
		
		rdbtnLt = new JRadioButton("Lt");
		buttonGroup.add(rdbtnLt);
		rdbtnLt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnLt.setBounds(201, 7, 63, 23);
		panel.add(rdbtnLt);
		
		rdbtnIlike = new JRadioButton("iLike");
		buttonGroup.add(rdbtnIlike);
		rdbtnIlike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("nomeF");
				cbbCampo.addItem("cnpj");
				cbbCampo.addItem("end");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("ie");
				cbbCampo.addItem("email");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnIlike.setBounds(266, 7, 63, 23);
		panel.add(rdbtnIlike);
		
		rdbtnNotNull = new JRadioButton("Not Null");
		buttonGroup.add(rdbtnNotNull);
		rdbtnNotNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("nome");
				cbbCampo.addItem("nomeF");
				cbbCampo.addItem("cnpj");
				cbbCampo.addItem("end");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("ie");
				cbbCampo.addItem("email");
				txtCon.setEnabled(false);
				txtCon.setText(null);
			}
		});
		rdbtnNotNull.setBounds(396, 7, 74, 23);
		panel.add(rdbtnNotNull);
		
		rdbtnGe = new JRadioButton("Ge");
		buttonGroup.add(rdbtnGe);
		rdbtnGe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnGe.setBounds(477, 7, 52, 23);
		panel.add(rdbtnGe);
		
		rdbtnLe = new JRadioButton("Le");
		buttonGroup.add(rdbtnLe);
		rdbtnLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		rdbtnLe.setBounds(531, 7, 63, 23);
		panel.add(rdbtnLe);
		
		cbbCampo = new JComboBox();
		cbbCampo.setEnabled(false);
		cbbCampo.setBounds(6, 37, 98, 20);
		panel.add(cbbCampo);
		
		txtCon = new JTextField();
		txtCon.setEnabled(false);
		txtCon.setBounds(114, 37, 345, 20);
		panel.add(txtCon);
		txtCon.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lp();
			}
		});
		btnLimpar.setBounds(565, 36, 94, 23);
		panel.add(btnLimpar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session s = HibernateUtil.getSession();
				HibernateUtil.begin();
				
				DefaultTableModel d = new DefaultTableModel();
				d.addColumn("ID");
				d.addColumn("Nome");
				d.addColumn("Nome Fantasia");
				d.addColumn("CNPJ");
				d.addColumn("Endere�o");
				d.addColumn("Telefone");
				d.addColumn("Cidade");
				d.addColumn("Estado");
				d.addColumn("Inscri��o Estadual");
				d.addColumn("Email");
				
				if (rdbtnEq.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("cnpj")||cbbCampo.getSelectedItem().toString().equals("tel")||cbbCampo.getSelectedItem().toString().equals("ie")) {
							consultaEmp.add(Restrictions.eq(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaEmp.add(Restrictions.eq(cbbCampo.getSelectedItem().toString(), txtCon.getText()));
						}
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							d.fireTableDataChanged();
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);	
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				if (rdbtnNe.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("cnpj")||cbbCampo.getSelectedItem().toString().equals("tel")||cbbCampo.getSelectedItem().toString().equals("ie")) {
							consultaEmp.add(Restrictions.ne(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaEmp.add(Restrictions.ne(cbbCampo.getSelectedItem().toString(), txtCon.getText()));
						}
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnGt.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						consultaEmp.add(Restrictions.gt(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnLt.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						consultaEmp.add(Restrictions.lt(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnIlike.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("cnpj")||cbbCampo.getSelectedItem().toString().equals("tel")||cbbCampo.getSelectedItem().toString().equals("ie")) {
							consultaEmp.add(Restrictions.ilike(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaEmp.add(Restrictions.ilike(cbbCampo.getSelectedItem().toString(), txtCon.getText(),MatchMode.ANYWHERE));
						}
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnLike.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("cnpj")||cbbCampo.getSelectedItem().toString().equals("tel")||cbbCampo.getSelectedItem().toString().equals("ie")) {
							consultaEmp.add(Restrictions.like(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaEmp.add(Restrictions.like(cbbCampo.getSelectedItem().toString(), txtCon.getText(),MatchMode.ANYWHERE));
						}
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnNotNull.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						consultaEmp.add(Restrictions.isNotNull(cbbCampo.getSelectedItem().toString()));
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnGe.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						consultaEmp.add(Restrictions.ge(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnLe.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						consultaEmp.add(Restrictions.le(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rdbtnAll.isSelected() == true) {
					try {
						Criteria consultaEmp = s.createCriteria(Empresa.class);
						List<Empresa> result = consultaEmp.list();
						
						for (Empresa e : result) {
							String[] tupla = new String[10];
							tupla[0] = String.valueOf(e.getId());
							tupla[1] = e.getNome();
							tupla[2] = e.getNomeF();
							tupla[3] = String.valueOf(e.getCnpj());
							tupla[4] = e.getEnd();
							tupla[5] = String.valueOf(e.getTel());
							tupla[6] = e.getCidade();
							tupla[7] = e.getEstado();
							tupla[8] = String.valueOf(e.getIe());
							tupla[9] = e.getEmail();
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			HibernateUtil.close();
			}
		});
		btnConsultar.setBounds(471, 36, 94, 23);
		panel.add(btnConsultar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lp();
				dispose();
				Main p = new Main();
				
			}
		});
		btnSair.setBounds(6, 180, 653, 23);
		panel.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 60, 653, 115);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		rdbtnLike = new JRadioButton("Like");
		rdbtnLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("nomeF");
				cbbCampo.addItem("cnpj");
				cbbCampo.addItem("end");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("ie");
				cbbCampo.addItem("email");
				txtCon.setEnabled(true);
				txtCon.setText(null);
				
			}
		});
		buttonGroup.add(rdbtnLike);
		rdbtnLike.setBounds(331, 7, 63, 23);
		panel.add(rdbtnLike);
		
		rdbtnAll = new JRadioButton("All");
		rdbtnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(false);
				txtCon.setEnabled(false);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnAll);
		rdbtnAll.setBounds(596, 7, 63, 23);
		panel.add(rdbtnAll);
	}
	public void lp(){
		cbbCampo.removeAllItems();
		cbbCampo.setEnabled(false);
		buttonGroup.clearSelection();
		txtCon.setEnabled(false);
		txtCon.setText("");
	} 
}
