package NEGOCIO.Jogos;
import java.io.*;
public class Corrida extends Jogos implements Serializable {
	
	public Corrida(int id, String nome, int tipo) {
		super(id, nome, "Jogos de corrida utilizam a perspectiva de jogo em primeira ou terceira pessoa. Podem ser baseados tanto em competições ou lugares reais quanto em ambientes fictícios, variando entre jogabilidade de simuladores, ou jogos mais arcades.", 2);
	}
}
