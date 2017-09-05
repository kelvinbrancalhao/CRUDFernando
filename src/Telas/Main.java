/* Projeto: trabalho QC para matéria de topicos avançados em Programação
 * Desenvolvedores: Kelvin Ferri Brancalhão e Yancei Liev Stessuk
 * RA: 1411420631
 * Data:26/06/17
 * 
 * */


package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane deskPanePrincipal;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mncadastro = new JMenu("Cadastro");
		menuBar.add(mncadastro);
		
		JMenuItem mntmEmpresa = new JMenuItem("Empresa");
		mntmEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadEmp emp = new CadEmp();
				emp.setVisible(true);
				deskPanePrincipal.add(emp);
			}
		});
		mncadastro.add(mntmEmpresa);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadFunc func = new CadFunc();
				func.setVisible(true);
				deskPanePrincipal.add(func);
			}
		});
		mncadastro.add(mntmFuncionario);
		
		JMenuItem mntmCascade = new JMenuItem("Cascade");
		mntmCascade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mncadastro.add(mntmCascade);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmEmpresa_1 = new JMenuItem("Empresa");
		mntmEmpresa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConEmp emp = new ConEmp();
				emp.setVisible(true);
				deskPanePrincipal.add(emp);
			}
		});
		mnConsulta.add(mntmEmpresa_1);
		
		JMenuItem mntmFuncionario_1 = new JMenuItem("Funcionario");
		mntmFuncionario_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConFunc func = new ConFunc();
				func.setVisible(true);
				deskPanePrincipal.add(func);
			}
		});
		mnConsulta.add(mntmFuncionario_1);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSistema.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		deskPanePrincipal = new JDesktopPane();
		contentPane.add(deskPanePrincipal, BorderLayout.CENTER);
	}
}

