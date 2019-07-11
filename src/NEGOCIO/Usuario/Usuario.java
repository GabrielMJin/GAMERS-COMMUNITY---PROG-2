package NEGOCIO.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

import DADOS.RepositorioJogosArray;
import NEGOCIO.Jogos.Jogos;


public class Usuario implements Serializable{
	int id;
	private String login;
	private String senha;
	private ArrayList<Jogos> meusJogos = new ArrayList<Jogos>();
	private String descricao;
	private tipoJogador gamer;
	
	public Usuario(String login, String senha, String descricao, int id, tipoJogador gamer) {
		this.login = login;
		this.senha = senha;
		this.descricao = descricao;
		this.id = id;
		this.gamer = gamer;
	}
	public tipoJogador getGamer() {
		return gamer;
	}
	
	
	public void setGamer(tipoJogador gamer) {
		this.gamer = gamer;
	}
	public void setLogin(String login) {
		this.login = login;
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
	
	public String toString(){
        return getLogin();
    }
	
}
