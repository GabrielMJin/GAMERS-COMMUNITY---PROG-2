package DADOS;


import NEGOCIO.Forum.Pergunta;
import NEGOCIO.Forum.Respostas;
import NEGOCIO.Usuario.Usuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Excecoes.VetorVazioException;

public class RepositorioForum implements Serializable, RepositorioForumAbstrata {
    
    static ArrayList<Respostas> ArrResposta = new ArrayList();
    static ArrayList<Pergunta> ArrPerguntas = new ArrayList();;
    
    public RepositorioForum(){
   }
    public void Gravar() {
        try {
			FileOutputStream arq = new FileOutputStream("perguntas.dat") ;
			ObjectOutputStream obj = new ObjectOutputStream(arq);
			obj.writeObject(ArrPerguntas);
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
			FileInputStream arq = new FileInputStream("perguntas.dat") ;
			ObjectInputStream obj = new ObjectInputStream(arq);
		    ArrPerguntas = (ArrayList<Pergunta>)obj.readObject();			
			arq.close();			
			obj.close();
			System.out.println("Arquivos Lidos!");
        }
        catch(Exception e) {
//        	System.out.println("Error 404");
        	e.printStackTrace();
        }
        
	}
    
   public void RepPergunta(Pergunta pergunta){
	   Ler();
       ArrPerguntas.add(pergunta);
       Gravar();
   }
   
   //procura e exibi pergunta
   public Pergunta ExibirPergunta(int posicao){   
       for(Pergunta aux : ArrPerguntas){
           if(posicao == aux.getPosicao()){
              return aux;
           }   
       }
     return null;
   }
   public ArrayList<Respostas> ExibirRespostas(Pergunta pergunta1){
       ArrayList<Respostas> ArryAux = new ArrayList();
        for(Respostas aux2 : ArrResposta){
            if(aux2.getPergunta().getPergunta().equals(pergunta1.getPergunta()))
                   ArryAux.add(aux2);
               }
        return ArryAux;
   }
   public void ListarForum(){
       for(int i = 0; i < ArrPerguntas.size(); i++){
           this.ArrPerguntas.get(i).setPosicao(i);
           System.out.println(i + "-" + this.ArrPerguntas.get(i).getPergunta());
           //System.out.println(ArrPerguntas.get(i).getPosicao());
       }
   }
   
    public void Responder(int posicao, Pergunta pergunta, String resposta, Usuario usuario){
        for(Pergunta aux : ArrPerguntas){
            if(aux.getPosicao() == posicao){
       Respostas responder = new Respostas(resposta, usuario, pergunta);
       ArrResposta.add(responder); 
        }
        
   } 
    }

    private int getPergunta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
