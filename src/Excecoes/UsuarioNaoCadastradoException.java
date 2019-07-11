package Excecoes;

public class UsuarioNaoCadastradoException extends Exception{
    public UsuarioNaoCadastradoException(){
        super("Usuario não cadastrado...");
    }
}