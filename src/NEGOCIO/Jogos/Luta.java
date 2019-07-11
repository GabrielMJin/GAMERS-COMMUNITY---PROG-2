package NEGOCIO.Jogos;
import java.io.*;
public class Luta extends Jogos implements Serializable{
	
	public Luta(int id, String nome,int tipo) {
		super(id, nome , "Jogo eletrônico de luta é o nome dado ao estilo de jogos de video game em que os personagens se enfrentam em combates que podem ser do tipo \"briga de rua\" ou \"versus\"",4);
	}
}
