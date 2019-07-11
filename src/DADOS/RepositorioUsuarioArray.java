package DADOS;


import NEGOCIO.Forum.Pergunta;
import NEGOCIO.Usuario.Usuario;
import java.io.*;
import java.util.ArrayList;
/*import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;*/
public class RepositorioUsuarioArray implements Serializable{
	
	private Usuario[] usuarios;
	private int proxima;
	
	public RepositorioUsuarioArray (int tamanho) {
		//lerArquivo();
		this.usuarios = new Usuario[tamanho];
		this.proxima = 0;
	}
    public void Gravar() {
        try {
			FileOutputStream arq = new FileOutputStream("Usuarios.dat") ;
			ObjectOutputStream obj = new ObjectOutputStream(arq);
			obj.writeObject(usuarios);
			arq.flush();
			arq.close();
			obj.flush();
			obj.close();
			System.out.println("Gravado com sucesso!");
        }
        catch(Exception e) {
//        	System.out.println("Error 404");
        	e.printStackTrace();
        }
        
	}
    
    public void Ler() {
        try {
			FileInputStream arq = new FileInputStream("Usuarios.dat") ;
			ObjectInputStream obj = new ObjectInputStream(arq);
		    usuarios = (Usuario[])obj.readObject();			
			arq.close();			
			obj.close();
			System.out.println("Usuários lido!");
        }
        catch(Exception e) {
//        	System.out.println("Error 404");
        	e.printStackTrace();
        }
        
	}
	
	/*public void Gravar(RepositorioUsuarioArray b) {
        try {
		FileOutputStream arq = new FileOutputStream("pessoas.arq") ;
		ObjectOutputStream obj = new ObjectOutputStream(arq);
		obj.writeObject(b);
		obj.flush();
		System.out.println("Gravado com sucesso!");
        }
        catch(Exception Error) {
        	System.out.println("Error 404");
        }
        
	}
	
	public void Ler(RepositorioUsuarioArray b) {
		try {
			FileInputStream arq = new FileInputStream("pessoas.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			RepositorioUsuarioArray test = (RepositorioUsuarioArray)obj.readObject();
			System.out.println("Lido com sucesso!");
		}
		catch(Exception Error)
		{
			System.out.println("Arquivo não encontrado");
		}
		
	}*/
	
	
	public void cadastrar(Usuario c) {
		this.usuarios[this.proxima] = c;
		this.proxima +=1;
		
	}
	
	private int procurarIndice(String num) {
		//lerArquivo();
		int i = 0;
		boolean achou = false;
		while((!achou)&& (i < this.proxima)) {
			if(num.equals(this.usuarios[i].getLogin())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	
	public Usuario procurar(String num) {
		//lerArquivo();
		int i = this.procurarIndice(num);
		Usuario resultado = null;
		if(i != this.proxima) {
			resultado = this.usuarios[i];
		}
		return resultado;
	}
	
	public boolean existe(String numUsuario) {
		//lerArquivo();
		boolean existe = false;
		int indice = this.procurarIndice(numUsuario);
		if(indice != proxima) {
			existe = true;
		}
		return existe;
	}

	public void remover(String num) {
		//lerArquivo();
		int i = this.procurarIndice(num);
		if(i != this.proxima) {
			this.usuarios[i] = this.usuarios[this.proxima-1];
			this.usuarios[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}
		else {
			
		}
		//salvarArquivo();
	}
	
	private void duplicaArrayUsuarios() {
		//lerArquivo();
		if(this.usuarios != null && this.usuarios.length > 0) {
			Usuario[] arrayDuplicado = new Usuario[this.usuarios.length * 2];
			for (int i = 0;i < this.usuarios.length; i++){
				arrayDuplicado[i] = this.usuarios[i];
			}
			this.usuarios = arrayDuplicado;
		}
		//salvarArquivo();
		
	}

	
}
