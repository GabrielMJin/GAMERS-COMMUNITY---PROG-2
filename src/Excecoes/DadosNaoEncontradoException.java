package Excecoes;

public class DadosNaoEncontradoException extends Exception{
    public DadosNaoEncontradoException(){
        super("Conta abstrata não encontrada!");
    }
}