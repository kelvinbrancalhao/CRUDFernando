package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private int id;
	private String nome;
	private String nomeF;
	private int cnpj;
	private String end;
	private int tel;
	private String cidade;
	private String estado;
	private int ie;
	private String email;
	private List<Funcionario> func = new ArrayList<Funcionario>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeF() {
		return nomeF;
	}
	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIe() {
		return ie;
	}
	public void setIe(int ie) {
		this.ie = ie;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Funcionario> getFunc() {
		return func;
	}
	public void setFunc(List<Funcionario> func) {
		this.func = func;
	}
	
}
