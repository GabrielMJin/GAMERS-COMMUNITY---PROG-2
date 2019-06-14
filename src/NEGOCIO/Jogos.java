package NEGOCIO;

import java.util.ArrayList;

abstract public class Jogos {
	int idJogo;
	int tipo;
	String nome;
	String descricao;
	tipoJogador gamer;
	ArrayList<String> comentarios = new ArrayList<String>();

	public Jogos(int idJogo,String nome, String descricao,tipoJogador gamer) {
		this.idJogo = idJogo;
		this.nome = nome;
		this.descricao = descricao;
		this.gamer = gamer;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public ArrayList<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios = comentarios;
	}

	public int getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(int idJogo) {
		this.idJogo = idJogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public tipoJogador getGamer() {
		return gamer;
	}

	public void setGamer(tipoJogador gamer) {
		this.gamer = gamer;
	}
	
	
}
