package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import Trabalho.Empresa;
import Trabalho.HibernateUtil;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class CadEmp extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtfNomeF;
	private JTextField txtfNomeR;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtIE;
	private JTextField txtEmail;
	private JFormattedTextField ftxtCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadEmp frame = new CadEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadEmp() {
		setTitle("Cadastro de Empresas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeFantasia.setBounds(10, 10, 119, 14);
		panel.add(lblNomeFantasia);
		
		txtfNomeF = new JTextField();
		txtfNomeF.setBounds(139, 8, 275, 20);
		panel.add(txtfNomeF);
		txtfNomeF.setColumns(10);
		
		JLabel lblNomeReal = new JLabel("Nome Real:");
		lblNomeReal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeReal.setBounds(10, 34, 119, 14);
		panel.add(lblNomeReal);
		
		txtfNomeR = new JTextField();
		txtfNomeR.setColumns(10);
		txtfNomeR.setBounds(139, 32, 275, 20);
		panel.add(txtfNomeR);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCnpj.setBounds(10, 58, 119, 14);
		panel.add(lblCnpj);
		
		ftxtCNPJ = new JFormattedTextField();
		ftxtCNPJ.setText("Apenas numeros!");
		ftxtCNPJ.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				String n = ftxtCNPJ.getText();
				if (n.equals("Apenas numeros!")) {
					ftxtCNPJ.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String n = ftxtCNPJ.getText();
				if (n.equals("")) {
					ftxtCNPJ.setText("Apenas numeros!");
				}
			}
		});
		
		ftxtCNPJ.setBounds(139, 56, 275, 20);
		panel.add(ftxtCNPJ);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndereco.setBounds(10, 81, 119, 14);
		panel.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(139, 79, 275, 20);
		panel.add(txtEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 105, 119, 14);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("Apenas numeros!");
		txtTelefone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String n = txtTelefone.getText();
				if (n.equals("Apenas numeros!")) {
					txtTelefone.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String n = txtTelefone.getText();
				if (n.equals("")) {
					txtTelefone.setText("Apenas numeros!");
				}
			}
		});
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(139, 103, 275, 20);
		panel.add(txtTelefone);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(10, 130, 119, 14);
		panel.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(139, 128, 275, 20);
		panel.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(10, 153, 119, 14);
		panel.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String n = txtEstado.getText();
				if (n.equals("Apenas sigla do estado!")) {
					txtEstado.setText(null);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				String n = txtEstado.getText();
				if (n.equals("")) {
					txtEstado.setText("Apenas sigla do estado!");
				}
			}
		});
		txtEstado.setText("Apenas sigla do estado!");
		txtEstado.setColumns(10);
		txtEstado.setBounds(139, 151, 275, 20);
		panel.add(txtEstado);
		
		JLabel lblInscEstadual = new JLabel("Insc. Estadual:");
		lblInscEstadual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInscEstadual.setBounds(10, 178, 119, 14);
		panel.add(lblInscEstadual);
		
		txtIE = new JTextField();
		txtIE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				String n = txtIE.getText();
				if (n.equals("Apenas numeros!")) {
					txtIE.setText(null);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				String n = txtIE.getText();
				if (n.equals("")) {
					txtIE.setText("Apenas numeros!");
				}
			}
		});
		txtIE.setText("Apenas numeros!");
		txtIE.setColumns(10);
		txtIE.setBounds(139, 176, 275, 20);
		panel.add(txtIE);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 201, 119, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(139, 199, 275, 20);
		panel.add(txtEmail);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HibernateUtil.begin();
					Session s = HibernateUtil.getSession();
					
					Empresa empr = new Empresa();
					empr.setNome(txtfNomeR.getText());
					empr.setNomeF(txtfNomeF.getText());
					empr.setCnpj(Integer.parseInt(ftxtCNPJ.getText()));
					empr.setEnd(txtEndereco.getText());
					empr.setTel(Integer.parseInt(txtTelefone.getText()));
					empr.setCidade(txtCidade.getText());
					empr.setEstado(txtEstado.getText());
					empr.setIe(Integer.parseInt(txtIE.getText()));
					empr.setEmail(txtEmail.getText());
					
					s.save(empr);
					HibernateUtil.commit();
					lP();
					JOptionPane.showMessageDialog(null, "Empresa cadastrada!");
					
				} catch (Exception e2) {
					HibernateUtil.rollback();
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empresa n�o cadastrada!");
				}
			}
		});
		btnGravar.setBounds(139, 226, 79, 23);
		panel.add(btnGravar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lP();
				dispose();
			}
		});
		btnSair.setBounds(335, 226, 79, 23);
		panel.add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lP();
			}
		});
		btnLimpar.setBounds(237, 226, 79, 23);
		panel.add(btnLimpar);
	}
	
	public void lP(){
		txtfNomeR.setText(null);
		txtfNomeF.setText(null);
		ftxtCNPJ.setText("Apenas numeros!");
		txtEndereco.setText(null);
		txtTelefone.setText("Apenas numeros!");
		txtCidade.setText(null);
		txtEstado.setText("Apenas sigla do estado!");
		txtIE.setText("Apenas numeros!");
		txtEmail.setText(null);
	}
}
