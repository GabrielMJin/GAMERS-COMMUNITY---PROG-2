package DADOS;

import Excecoes.VetorVazioException;
import NEGOCIO.Forum.Pergunta;
import NEGOCIO.Forum.Respostas;
import NEGOCIO.Jogos.Jogos;
import NEGOCIO.Usuario.Usuario;
import java.util.ArrayList;

public interface RepositorioForumAbstrata {

    public void RepPergunta(Pergunta pergunta);
    public ArrayList<Respostas> ExibirRespostas(Pergunta aux) throws VetorVazioException;
    public Pergunta ExibirPergunta(int posicao)throws VetorVazioException;
    public void ListarForum() throws VetorVazioException;
    public void Responder(int posicao, Pergunta pergunta, String resposta, Usuario usuario);


}