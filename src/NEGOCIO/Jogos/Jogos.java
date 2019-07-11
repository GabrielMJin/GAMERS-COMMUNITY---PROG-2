package NEGOCIO.Jogos;

import java.util.ArrayList;

import NEGOCIO.Usuario.Usuario;

abstract public class Jogos {
	private int idJogo;
	private int tipo;
	private String nome;
	private String descricao;

	ArrayList<String> comentarios = new ArrayList<String>();

	public Jogos(int idJogo,String nome, String descricao, int tipo) {
		this.idJogo = idJogo;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;

	}
	public void adicionarComentario(Usuario comentador, String comentario) {
		this.comentarios.add(comentador.getLogin() + " : " + comentario);
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
	public String toString(){
        return getNome();
    }

	
}
