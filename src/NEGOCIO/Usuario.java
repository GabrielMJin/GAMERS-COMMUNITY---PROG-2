package NEGOCIO;
import java.util.ArrayList;


public class Usuario {
	int id;
	private String login;
	private String senha;
	private ArrayList<Jogos> meusJogos = new ArrayList<Jogos>();
	private String descricao;
	
	public Usuario(String login, String senha, String descricao, int id) {
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
		this.id = id;
	}
	public void adicionarJogo(Jogos jogoAdicionar) {
		this.meusJogos.add(jogoAdicionar);
	}
	public boolean removerJogo(Jogos jogoRemover) {
		if(this.meusJogos.contains(jogoRemover)) {
			meusJogos.remove(jogoRemover);
			return true;
		}
		else
			return false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Jogos> getMeusJogos() {
		return meusJogos;
	}

	public void setMeusJogos(ArrayList<Jogos> meusJogos) {
		this.meusJogos = meusJogos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
