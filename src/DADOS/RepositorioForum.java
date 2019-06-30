package DADOS;

import NEGOCIO.Forum.TopicosEnum;
import NEGOCIO.Forum.Pergunta;
import NEGOCIO.Forum.Respostas;
import NEGOCIO.Usuario.Usuario;
import java.util.ArrayList;

public class RepositorioForum {
    
    ArrayList<Respostas> ArrResposta;
    ArrayList<Pergunta> ArrPerguntas;
    
    public RepositorioForum(){
    this.ArrResposta = new ArrayList(); 
    this.ArrPerguntas = new ArrayList();
   }
    
   public void RepPergunta(Pergunta pergunta){
       this.ArrPerguntas.add(pergunta);
   }
   
   //procura e exibi pergunta
   public Pergunta ExibirPergunta(double posicao){   
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
   
    public void Responder(int posicao, Pergunta pergunta, String resposta, Usuario usuario, TopicosEnum topico){
        for(Pergunta aux : ArrPerguntas){
            if(aux.getPosicao() == posicao){
       Respostas responder = new Respostas(resposta, usuario, pergunta, topico);
       ArrResposta.add(responder); 
        }
        
   } 
    }

    private int getPergunta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
