package Telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Trabalho.Funcionario;
import Trabalho.HibernateUtil;

@SuppressWarnings("serial")
public class ConFunc extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtCon;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnEq;
	private JRadioButton rdbtnNe;
	private JRadioButton rdbtnGt;
	private JRadioButton rdbtnLt;
	private JRadioButton rdbtnIlike;
	private JRadioButton rdbtnLike;
	private JRadioButton rdbtnNotNull;
	private JRadioButton rdbtnGe;
	private JRadioButton rdbtnLe;
	private JRadioButton rdbtnAll;
	private JComboBox cbbCampo;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConFunc frame = new ConFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConFunc() {
		setTitle("Consulta Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(5, 4, 669, 212);
		contentPane.add(panel);
		
		rdbtnEq = new JRadioButton("Eq");
		rdbtnEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("cargo");
				cbbCampo.addItem("rg");
				cbbCampo.addItem("cpf");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("end");
				cbbCampo.addItem("cep");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("emp");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnEq);
		rdbtnEq.setBounds(6, 7, 63, 23);
		panel.add(rdbtnEq);
		
		rdbtnNe = new JRadioButton("Ne");
		rdbtnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("cargo");
				cbbCampo.addItem("rg");
				cbbCampo.addItem("cpf");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("end");
				cbbCampo.addItem("cep");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("emp");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnNe);
		rdbtnNe.setBounds(71, 7, 63, 23);
		panel.add(rdbtnNe);
		
		rdbtnGt = new JRadioButton("Gt");
		rdbtnGt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnGt);
		rdbtnGt.setBounds(136, 7, 63, 23);
		panel.add(rdbtnGt);
		
		rdbtnLt = new JRadioButton("Lt");
		rdbtnLt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnLt);
		rdbtnLt.setBounds(201, 7, 63, 23);
		panel.add(rdbtnLt);
		
		rdbtnIlike = new JRadioButton("iLike");
		rdbtnIlike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("cargo");
				cbbCampo.addItem("rg");
				cbbCampo.addItem("cpf");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("end");
				cbbCampo.addItem("cep");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("emp");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnIlike);
		rdbtnIlike.setBounds(266, 7, 63, 23);
		panel.add(rdbtnIlike);
		
		rdbtnNotNull = new JRadioButton("Not Null");
		rdbtnNotNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				cbbCampo.addItem("nome");
				cbbCampo.addItem("cargo");
				cbbCampo.addItem("rg");
				cbbCampo.addItem("cpf");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("end");
				cbbCampo.addItem("cep");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("emp");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnNotNull);
		rdbtnNotNull.setBounds(396, 7, 74, 23);
		panel.add(rdbtnNotNull);
		
		rdbtnGe = new JRadioButton("Ge");
		rdbtnGe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnGe);
		rdbtnGe.setBounds(477, 7, 52, 23);
		panel.add(rdbtnGe);
		
		rdbtnLe = new JRadioButton("Le");
		rdbtnLe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbCampo.removeAllItems();
				cbbCampo.setEnabled(true);
				cbbCampo.addItem("id");
				txtCon.setEnabled(true);
				txtCon.setText(null);
			}
		});
		buttonGroup.add(rdbtnLe);
		rdbtnLe.setBounds(531, 7, 63, 23);
		panel.add(rdbtnLe);
		
		cbbCampo = new JComboBox();
		cbbCampo.setEnabled(false);
		cbbCampo.setBounds(6, 37, 98, 20);
		panel.add(cbbCampo);
		
		txtCon = new JTextField();
		txtCon.setEnabled(false);
		txtCon.setColumns(10);
		txtCon.setBounds(114, 37, 345, 20);
		panel.add(txtCon);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnLimpar.setBounds(565, 36, 94, 23);
		panel.add(btnLimpar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session s = HibernateUtil.getSession();
				HibernateUtil.begin();
				
				DefaultTableModel d = new DefaultTableModel();
				d.addColumn("ID");
				d.addColumn("Nome");
				d.addColumn("Cargo");
				d.addColumn("RG");
				d.addColumn("CPF");
				d.addColumn("Cidade");
				d.addColumn("Estado");
				d.addColumn("Endere�o");
				d.addColumn("CEP");
				d.addColumn("Telefone");
				d.addColumn("Cod. Empresa");
				
				if (rdbtnEq.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("rg")||cbbCampo.getSelectedItem().toString().equals("cpf")||cbbCampo.getSelectedItem().toString().equals("cep")||cbbCampo.getSelectedItem().toString().equals("emp")) {
							consultaFunc.add(Restrictions.eq(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaFunc.add(Restrictions.eq(cbbCampo.getSelectedItem().toString(), txtCon.getText()));
						}
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);	
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				if (rdbtnNe.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("rg")||cbbCampo.getSelectedItem().toString().equals("cpf")||cbbCampo.getSelectedItem().toString().equals("cep")||cbbCampo.getSelectedItem().toString().equals("emp")) {
							consultaFunc.add(Restrictions.ne(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaFunc.add(Restrictions.ne(cbbCampo.getSelectedItem().toString(), txtCon.getText()));
						}
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnGt.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						consultaFunc.add(Restrictions.gt(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnLt.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						consultaFunc.add(Restrictions.lt(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnIlike.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("rg")||cbbCampo.getSelectedItem().toString().equals("cpf")||cbbCampo.getSelectedItem().toString().equals("cep")||cbbCampo.getSelectedItem().toString().equals("emp")) {
							consultaFunc.add(Restrictions.ilike(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaFunc.add(Restrictions.ilike(cbbCampo.getSelectedItem().toString(), txtCon.getText(),MatchMode.ANYWHERE));
						}
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnLike.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						if (cbbCampo.getSelectedItem().toString().equals("id")||cbbCampo.getSelectedItem().toString().equals("rg")||cbbCampo.getSelectedItem().toString().equals("cpf")||cbbCampo.getSelectedItem().toString().equals("cep")||cbbCampo.getSelectedItem().toString().equals("emp")) {
							consultaFunc.add(Restrictions.like(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						} else {
							consultaFunc.add(Restrictions.like(cbbCampo.getSelectedItem().toString(), txtCon.getText(),MatchMode.ANYWHERE));
						}
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnNotNull.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						consultaFunc.add(Restrictions.isNotNull(cbbCampo.getSelectedItem().toString()));
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnGe.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						consultaFunc.add(Restrictions.ge(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnLe.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						consultaFunc.add(Restrictions.le(cbbCampo.getSelectedItem().toString(), Integer.parseInt(txtCon.getText())));
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (rdbtnAll.isSelected() == true) {
					try {
						Criteria consultaFunc = s.createCriteria(Funcionario.class);
						List<Funcionario> result = consultaFunc.list();
						
						for (Funcionario f : result) {
							String[] tupla = new String[11];
							tupla[0] = String.valueOf(f.getId());
							tupla[1] = f.getNome();
							tupla[2] = f.getCargo();
							tupla[3] = String.valueOf(f.getRg());
							tupla[4] = String.valueOf(f.getCpf());
							tupla[5] = f.getCidade();
							tupla[6] = f.getEstado();
							tupla[7] = f.getEnd();
							tupla[8] = String.valueOf(f.getCep());
							tupla[9] = String.valueOf(f.getTel());
							tupla[10] = String.valueOf(f.getEmp());
							d.addRow(tupla);
						} 
						table.setModel(d);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			HibernateUtil.close();
			}
		});
		btnConsultar.setBounds(471, 36, 94, 23);
		panel.add(btnConsultar);
		
		JButton button_2 = new JButton("Sair");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setBounds(6, 180, 653, 23);
		panel.add(button_2);
		
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
				cbbCampo.addItem("cargo");
				cbbCampo.addItem("rg");
				cbbCampo.addItem("cpf");
				cbbCampo.addItem("cidade");
				cbbCampo.addItem("estado");
				cbbCampo.addItem("end");
				cbbCampo.addItem("cep");
				cbbCampo.addItem("tel");
				cbbCampo.addItem("emp");
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
	public void clearFields(){
		cbbCampo.removeAllItems();
		cbbCampo.setEnabled(false);
		buttonGroup.clearSelection();
		txtCon.setEnabled(false);
		txtCon.setText("");
	}
}
