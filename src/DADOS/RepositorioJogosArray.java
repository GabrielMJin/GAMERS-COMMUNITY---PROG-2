package DADOS;

import NEGOCIO.Jogos.Aventura;
import NEGOCIO.Jogos.Corrida;
import NEGOCIO.Jogos.Esportes;
import NEGOCIO.Jogos.Jogos;
import NEGOCIO.Jogos.Luta;
import NEGOCIO.Jogos.Online;
import NEGOCIO.Jogos.Rpg;
import NEGOCIO.Jogos.Simulador;
import NEGOCIO.Jogos.Tiro;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class RepositorioJogosArray {
	//private RepositorioJogosArray jogo;
	private Jogos[] jogosAventura;
	private Jogos[] jogosCorrida;
	private Jogos[] jogosEsportes;
	private Jogos[] jogosLuta;
	private Jogos[] jogosOnline;
	private Jogos[] jogosRpg;
	private Jogos[] jogosSimulador;
	private Jogos[] jogosTiro;
	private int proximaAventura;
	private int proximaCorrida;
	private int proximaEsportes;
	private int proximaLuta;
	private int proximaOnline;
	private int proximaRpg;
	private int proximaSimulador;
	private int proximaTiro;
	
	public RepositorioJogosArray(int tamanho) {
		//lerArquivoJogos();
		
		this.jogosAventura = new Aventura[tamanho];
		this.jogosCorrida = new Corrida[tamanho];
		this.jogosEsportes = new Esportes[tamanho];
		this.jogosLuta = new Luta[tamanho];
		this.jogosOnline = new Online[tamanho];
		this.jogosRpg = new Rpg[tamanho];
		this.jogosSimulador = new Simulador[tamanho];
		this.jogosTiro = new Tiro[tamanho];
		
		this.proximaAventura = 0;
		this.proximaCorrida = 0;
		this.proximaEsportes = 0;
		this.proximaLuta = 0;
		this.proximaOnline = 0;
		this.proximaRpg = 0;
		this.proximaSimulador = 0;
		this.proximaTiro = 0;
	}
	
	public void cadastrarJogo(Jogos a) {
		//lerArquivoJogos();
		if(a.getTipo()==1) {
			this.jogosAventura[this.proximaAventura] = a;
			this.proximaAventura += 1;
			//salvarArquivoAventura();
		}
		else if(a.getTipo()==2) {
			this.jogosCorrida[this.proximaCorrida] = a;
			this.proximaCorrida += 1;
			//salvarArquivoCorrida();
		}
		else if(a.getTipo()==3) {
			this.jogosEsportes[this.proximaEsportes] = a;
			this.proximaEsportes += 1;
			//salvarArquivoEsportes();
		}
		else if(a.getTipo()==4) {
			this.jogosLuta[this.proximaLuta] = a;
			this.proximaLuta += 1;
			//salvarArquivoLuta();
		}
		else if(a.getTipo()==5) {
			this.jogosOnline[this.proximaOnline] = a;
			this.proximaOnline += 1;
			//salvarArquivoOnline();
		}
		else if(a.getTipo()==6) {
			this.jogosRpg[this.proximaRpg] = a;
			this.proximaRpg += 1;
			//salvarArquivoRPG();
		}
		else if(a.getTipo()==7) {
			this.jogosSimulador[this.proximaSimulador] = a;
			this.proximaSimulador += 1;
			//salvarArquivoSimulador();
		}
		else if(a.getTipo()==8) {
			this.jogosTiro[this.proximaTiro] = a;
			this.proximaTiro += 1;
			//salvarArquivoTiro();
		}
	}
	
	private int procurarIndice(String num,int tipo) {
		//lerArquivoJogos();
		int i=0;
		if(tipo==1&&this.proximaAventura>=1) {
			for(i = 0 ; i<this.proximaAventura ; i++) {
				if(this.jogosAventura[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
			
		}
		else if(tipo == 2 && this.proximaCorrida>=1) {
			for(i = 0 ; i<this.proximaCorrida;i++) {
				if(this.jogosCorrida[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
		}
		else if(tipo == 3 && this.proximaEsportes>=1){
			for(i = 0; i <this.proximaEsportes; i++) {
				if(this.jogosEsportes[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
		}
		else if(tipo == 4 && this.proximaLuta>=1){
			for(i = 0; i <this.proximaLuta ; i++) {
				if(this.jogosLuta[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
		}
		else if(tipo == 5 && this.proximaOnline >= 1){
			for(i=0;i<this.proximaOnline ; i++) {
				if(this.jogosOnline[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
		}
		else if(tipo == 6 && this.proximaRpg>=1){
			for(i=0;i<this.proximaRpg;i++) {
				if(this.jogosRpg[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
			
		}
		else if(tipo == 7 && this.proximaSimulador>=1){
			for(i=0;i<this.proximaSimulador;i++) {
				if(this.jogosSimulador[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
			
		}
		else if(tipo == 8 && this.proximaTiro>=1) {
			for(i=0;i<this.proximaTiro;i++) {
				if(this.jogosTiro[i].getNome().equals(num)) {
					return i;
				}
			}
			return i;
			
		}
		return i;
	}
	
	public Jogos procurar(String nomeJogo,int tipo) {
		//lerArquivoJogos();
		int i = this.procurarIndice(nomeJogo,tipo);
		Jogos resultado = null;
		if(tipo == 1) {
			if(i != this.proximaAventura && i != this.proximaAventura) {
				resultado = this.jogosAventura[i];
			}
		}
		if(tipo == 2) {
			if(i != this.proximaCorrida && i != this.proximaCorrida) {
				resultado = this.jogosCorrida[i];
			}
		}
		if(tipo == 3) {
			if(i != this.proximaEsportes && i != this.proximaEsportes) {
				resultado = this.jogosEsportes[i];
			}
		}
		if(tipo == 4) {
			if(i != this.proximaLuta && i != this.proximaLuta) {
				resultado = this.jogosLuta[i];
			}
		}
		if(tipo == 5) {
			if(i != this.proximaOnline && i != this.proximaOnline) {
				resultado = this.jogosOnline[i];
			}
		}
		if(tipo == 6) {
			if(i != this.proximaRpg && i != this.proximaRpg) {
				resultado = this.jogosRpg[i];
			}
		}
		if(tipo == 7) {
			if(i != this.proximaSimulador && i != this.proximaSimulador) {
				resultado = this.jogosSimulador[i];
			}
		}
		if(tipo == 8) {
			if(i != this.proximaTiro && i != this.proximaTiro) {
				resultado = this.jogosTiro[i];
			}
		}
		
	return resultado;	
	}
	public boolean existe(String nomeJogo,int tipo) {
		//lerArquivoJogos();
		boolean existe = false;
		int i = this.procurarIndice(nomeJogo, tipo);
		if(i != -1) {
			if(tipo==1 && i != this.proximaAventura) {
				existe = true;
			}
			if(tipo==2 && i != this.proximaCorrida) {
				existe = true;
			}
			if(tipo==3 && i != this.proximaEsportes) {
				existe = true;
			}
			if(tipo==4 && i != this.proximaLuta) {
				existe = true;
			}
			if(tipo==5 && i != this.proximaOnline) {
				existe = true;
			}
			if(tipo==6 && i != this.proximaRpg) {
				existe = true;
			}
			if(tipo==7 && i != this.proximaSimulador) {
				existe = true;
			}
			if(tipo==8 && i != this.proximaTiro) {
				existe = true;
			}
		}
		return existe;
	}
	
	
	public void remover(String num, int tipo) {
		//lerArquivoJogos();
		int i = this.procurarIndice(num,tipo);
		if(tipo==1) {
			if(i != this.proximaAventura) {
				this.jogosAventura[i] = this.jogosAventura[this.proximaAventura-1];
				this.jogosAventura[this.proximaAventura - 1] = null;
				this.proximaAventura = this.proximaAventura - 1;
				//salvarArquivoAventura();
			}
		}
		else if(tipo==2) {
			if(i != this.proximaCorrida) {
				this.jogosCorrida[i] = this.jogosCorrida[this.proximaCorrida-1];
				this.jogosCorrida[this.proximaCorrida - 1] = null;
				this.proximaCorrida = this.proximaCorrida - 1;
				//salvarArquivoCorrida();
			}
		}
		else if(tipo==3) {
			if(i != this.proximaEsportes) {
				this.jogosEsportes[i] = this.jogosEsportes[this.proximaEsportes-1];
				this.jogosEsportes[this.proximaEsportes - 1] = null;
				this.proximaEsportes = this.proximaEsportes- 1;
				//salvarArquivoEsportes();
			}
		}
		else if(tipo==4) {
			if(i != this.proximaLuta) {
				this.jogosLuta[i] = this.jogosLuta[this.proximaLuta-1];
				this.jogosLuta[this.proximaLuta - 1] = null;
				this.proximaLuta = this.proximaLuta- 1;
				//salvarArquivoLuta();
			}
		}
		else if(tipo==5) {
			if(i != this.proximaOnline) {
				this.jogosOnline[i] = this.jogosOnline[this.proximaOnline - 1];
				this.jogosOnline[this.proximaOnline - 1] = null;
				this.proximaOnline = this.proximaOnline- 1;
				//salvarArquivoOnline();
			}
		}
		else if(tipo==6) {
			if(i != this.proximaRpg) {
				this.jogosRpg[i] = this.jogosRpg[this.proximaRpg-1];
				this.jogosRpg[this.proximaRpg - 1] = null;
				this.proximaRpg = this.proximaRpg- 1;
				//salvarArquivoRPG();
			}
		}
		else if(tipo==7) {
			if(i != this.proximaSimulador) {
				this.jogosSimulador[i] = this.jogosSimulador[this.proximaSimulador-1];
				this.jogosSimulador[this.proximaSimulador - 1] = null;
				this.proximaSimulador = this.proximaSimulador- 1;
				//salvarArquivoSimulador();
			}
		}
		else if(tipo==8) {
			if(i != this.proximaTiro) {
				this.jogosTiro[i] = this.jogosTiro[this.proximaTiro-1];
				this.jogosTiro[this.proximaTiro - 1] = null;
				this.proximaTiro = this.proximaTiro - 1;
				//salvarArquivoTiro();
			}
		}
		
	}
	
//metodos salvar e abrir
	
	/*public void lerArquivoJogos() {
			try {
				FileInputStream arqL = new FileInputStream("RepositorioJogos.dat");
				ObjectInputStream objL = new ObjectInputStream(arqL);
				jogo = (RepositorioJogosArray) objL.readObject();
				objL.close();
				arqL.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();;
			}
		}
	
	public void salvarArquivoAventura() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosAventura);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}*/
	
/*	public void salvarArquivoCorrida() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosCorrida);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void salvarArquivoEsportes() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosEsportes);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void salvarArquivoLuta() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosLuta);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void salvarArquivoOnline() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosOnline);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void salvarArquivoRPG() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosRpg);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void salvarArquivoSimulador() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosSimulador);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void salvarArquivoTiro() {
		try {
				FileOutputStream arqG = new FileOutputStream("RepositorioJogos.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(jogosTiro);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	*/
}
