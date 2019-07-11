package NEGOCIO.Jogos;
import java.io.*;
public class Simulador extends Jogos implements Serializable {
	
	public Simulador(int id, String nome, int tipo) {
		super(id, nome, "Um jogo eletrônico de simulação tende a simular situações reais, exigindo bastante raciocínio lógico para driblar os obstáculos.",7);
	}

}
