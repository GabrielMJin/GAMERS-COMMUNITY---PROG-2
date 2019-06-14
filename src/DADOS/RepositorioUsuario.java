package DADOS;

import java.util.Arrays;

import NEGOCIO.Usuario;
public class RepositorioUsuario {
	
	private Usuario[] usuarios;
	private int proxima;
	
	public RepositorioUsuario(int tamanho) {
		this.usuarios = new Usuario[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Usuario c) {
		this.usuarios[this.proxima] = c;
		this.proxima +=1;
		
	}
	
	private int procurarIndice(String num) {
		int i = 0;
		boolean achou = false;
		while((!achou)&& (i < this.proxima)) {
			if(num.equals(this.usuarios[i].getId())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	
	public Usuario procurar(String num) {
		int i = this.procurarIndice(num);
		Usuario resultado = null;
		if(i != this.proxima) {
			resultado = this.usuarios[i];
		}
		return resultado;
	}
	
	public boolean existe(String numUsuario) {
		boolean existe = false;
		int indice = this.procurarIndice(numUsuario);
		if(indice != proxima) {
			existe = true;
		}
		return existe;
	}

	public void remover(String num) {
		int i = this.procurarIndice(num);
		if(i != this.proxima) {
			this.usuarios[i] = this.usuarios[this.proxima-1];
			this.usuarios[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}
		else {
			
		}
	}
	
	
	private void duplicaArrayUsuarios() {
		if(this.usuarios != null && this.usuarios.length > 0) {
			Usuario[] arrayDuplicado = new Usuario[this.usuarios.length * 2];
			for (int i = 0;i < this.usuarios.length; i++){
				arrayDuplicado[i] = this.usuarios[i];
			}
			this.usuarios = arrayDuplicado;
		}
		
	}
	
}
