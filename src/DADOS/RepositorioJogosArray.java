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

public class RepositorioJogosArray {
	
	private Jogos[] jogosAcao;
	private Jogos[] jogosCorrida;
	private Jogos[] jogosEsportes;
	private Jogos[] jogosLuta;
	private Jogos[] jogosOnline;
	private Jogos[] jogosRpg;
	private Jogos[] jogosSimulador;
	private Jogos[] jogosTiro;
	private int proximaAcao;
	private int proximaCorrida;
	private int proximaEsportes;
	private int proximaLuta;
	private int proximaOnline;
	private int proximaRpg;
	private int proximaSimulador;
	private int proximaTiro;
	
	public RepositorioJogosArray(int tamanho) {
		this.jogosAcao = new Aventura[tamanho];
		this.jogosCorrida = new Corrida[tamanho];
		this.jogosEsportes = new Esportes[tamanho];
		this.jogosLuta = new Luta[tamanho];
		this.jogosOnline = new Online[tamanho];
		this.jogosRpg = new Rpg[tamanho];
		this.jogosSimulador = new Simulador[tamanho];
		this.jogosTiro = new Tiro[tamanho];
		
		this.proximaAcao = 0;
		this.proximaCorrida = 0;
		this.proximaEsportes = 0;
		this.proximaLuta = 0;
		this.proximaOnline = 0;
		this.proximaRpg = 0;
		this.proximaSimulador = 0;
		this.proximaTiro = 0;
	}
	
	public void cadastrarJogo(Jogos a) {
		
	}

}
