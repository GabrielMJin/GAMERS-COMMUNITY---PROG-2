package NEGOCIO.Forum;


import NEGOCIO.Usuario.Usuario;

public class Pergunta {
    private String pergunta;
    private Usuario usuario;
    private TopicosEnum topico;
    private int posicao;

    
    public Pergunta(String pergunta, Usuario usuario, TopicosEnum topico) {
        this.pergunta = pergunta;
        this.usuario = usuario;
        this.topico = topico;
    }

    public Pergunta() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPergunta() {
        return pergunta;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }
    
    @Override
    public String toString(){
        return "Pergunta" + ":"+ getPergunta();
    }
   
    
}
