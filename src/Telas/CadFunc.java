package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Trabalho.Empresa;
import Trabalho.HibernateUtil;

@SuppressWarnings("serial")
public class CadFunc extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox cbbEmp;
	private JTextField txtCodEmp;
	private List<Empresa> empresasCadastradas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFunc frame = new CadFunc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadFunc() {
		setTitle("Cadastrto de Funcionarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Nome Fantasia:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 10, 119, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 8, 275, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Nome Real:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 34, 119, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 32, 275, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("CNPJ:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 58, 119, 14);
		panel.add(label_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("Apenas numeros!");
		formattedTextField.setBounds(139, 56, 275, 20);
		panel.add(formattedTextField);
		
		JLabel label_3 = new JLabel("Endere\u00E7o:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 81, 119, 14);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 79, 275, 20);
		panel.add(textField_2);
		
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 105, 119, 14);
		panel.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setText("Apenas numeros!");
		textField_3.setColumns(10);
		textField_3.setBounds(139, 103, 275, 20);
		panel.add(textField_3);
		
		JLabel label_5 = new JLabel("Cidade:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(10, 130, 119, 14);
		panel.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(139, 128, 275, 20);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("Estado:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(10, 153, 119, 14);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setText("Apenas sigla do estado!");
		textField_5.setColumns(10);
		textField_5.setBounds(139, 151, 275, 20);
		panel.add(textField_5);
		
		JLabel label_7 = new JLabel("Insc. Estadual:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(10, 178, 119, 14);
		panel.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setText("Apenas numeros!");
		textField_6.setColumns(10);
		textField_6.setBounds(139, 176, 275, 20);
		panel.add(textField_6);
		
		JLabel label_8 = new JLabel("Email:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(10, 201, 119, 14);
		panel.add(label_8);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(139, 199, 275, 20);
		panel.add(textField_7);
		
		JButton button = new JButton("Gravar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a = cbbEmp.getSelectedIndex();
				Empresa e = empresasCadastradas.get(a);
				
				
			}
		});
		button.setBounds(139, 255, 79, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Sair");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(335, 255, 79, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Limpar");
		button_2.setBounds(237, 255, 79, 23);
		panel.add(button_2);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresa.setBounds(10, 226, 119, 14);
		panel.add(lblEmpresa);
		
		cbbEmp = new JComboBox();
		cbbEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Session s = HibernateUtil.getSession();
					HibernateUtil.begin();
					
				
					HibernateUtil.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		cbbEmp.setBounds(139, 224, 119, 20);
		panel.add(cbbEmp);
		
		txtCodEmp = new JTextField();
		txtCodEmp.setEditable(false);
		txtCodEmp.setBounds(335, 224, 79, 20);
		panel.add(txtCodEmp);
		txtCodEmp.setColumns(10);
		
		JLabel lblCodEmp = new JLabel("Cod. Emp:");
		lblCodEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodEmp.setBounds(262, 226, 68, 14);
		panel.add(lblCodEmp);
		try {
			Session s = HibernateUtil.getSession();
			HibernateUtil.begin();
			
			Criteria consultaEmp = s.createCriteria(Empresa.class);
			empresasCadastradas = consultaEmp.list();
			
			for (Empresa emp : empresasCadastradas) {
				cbbEmp.addItem(emp.getNome());
			}
			HibernateUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
