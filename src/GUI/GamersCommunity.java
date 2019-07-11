package GUI;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DADOS.RepositorioForum;
import Excecoes.VetorVazioException;
import NEGOCIO.Forum.Pergunta;
import NEGOCIO.Forum.Respostas;
import NEGOCIO.Jogos.Aventura;
import NEGOCIO.Jogos.CadastroJogos;
import NEGOCIO.Jogos.Corrida;
import NEGOCIO.Jogos.Esportes;
import NEGOCIO.Jogos.Jogos;
import NEGOCIO.Jogos.Luta;
import NEGOCIO.Jogos.Online;
import NEGOCIO.Jogos.Rpg;
import NEGOCIO.Jogos.Simulador;
import NEGOCIO.Jogos.Tiro;
import NEGOCIO.Usuario.CadastroUsuario;
import NEGOCIO.Usuario.Usuario;
import NEGOCIO.Usuario.tipoJogador;
import java.io.*;

public class GamersCommunity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idusu = 0;
		int idJogo = 1;
		int fim = 0;
		

		
		Scanner lerString = new Scanner(System.in);
		Scanner lerInt = new Scanner(System.in);
		CadastroUsuario cadastroUsu = new CadastroUsuario();
		CadastroJogos cadastroJogos = new CadastroJogos();
        Pergunta pergunta = new Pergunta();
        Respostas resposta = new Respostas();
        RepositorioForum acesso = new RepositorioForum();
        
        cadastroUsu.getRepositorioUsuario().Ler(cadastroUsu.getRepositorioUsuario());
        

        
        
        
		int programa = 0;
		do {
		
			System.out.println("Bem Vindo ao GamersCommunity");
			do {
				System.out.println("Menu Principal\n1 - Login\n2 - Cadastro\n3 - Login ADM\n4 - Fechar o programa");
				fim = lerInt.nextInt();
				
			}while(fim==0);
			//login
			while(fim==1) {
				System.out.println("Tela de Login");
				System.out.println("Digite seu Login:");
				String login = lerString.nextLine();
				System.out.println("Digite Sua Senha:");
				String senha = lerString.nextLine();
				Usuario logado = cadastroUsu.procurar(login);
				System.out.println(logado.getLogin());
				if(cadastroUsu.existe(login)&& logado.getSenha().equals(senha)) {
					System.out.println("logado com sucesso!");
					int log = 0;
					
					while(log==0) {
						System.out.println("Bem Vindo " + logado.getLogin() + "!" );
						System.out.println("Sua Descrição: " + logado.getDescricao());
						System.out.println("Tipo de Jogador" + logado.getGamer());
						System.out.println();
						System.out.println("Menu");
						System.out.println("1 - Ver meus jogos");
						System.out.println("2 - Adicionar jogo");
						System.out.println("3 - Acessar o fórum");
						System.out.println("4 - Sair");
						log = lerInt.nextInt();
					}
					while(log==1) {
						if(logado.getMeusJogos()==null) {
							System.out.println("Você não tem jogos na biblioteca!");
							System.out.println("");
							System.out.println("0 - Voltar");
							log = lerInt.nextInt();
							
						}
						else {
							System.out.println(logado.getMeusJogos());
							System.out.println("");
							System.out.println("0 - Voltar");
							log = lerInt.nextInt();
						}
					}
					//adicionar jogo na biblioteca
					while(log==2) {
						System.out.println("Nome do Jogo:");
						String gameadd = lerString.nextLine();
						System.out.println("Tipo: 1- Aventura 2- Corrida 3- Esportes 4- Luta 5- Online 6- Rpg 7 - Simulador 8 - Tiro");
						int tipojuego = lerInt.nextInt();
						Jogos adicionar = cadastroJogos.procurar(gameadd, tipojuego);
						logado.adicionarJogo(adicionar);
						if(logado.getMeusJogos().contains(adicionar)) {
							System.out.println("Adicionado com sucesso!");
							log = 0;
						}
						else {
							System.out.println("Não foi possível adicionar tal jogo, provavelmente não existe na nossa biblioteca!");
							log = 0;
						}
						
					}
					//acessar Forum
					while(log==3) {
                        int controle = 0;
                        System.out.println("Bem-Vindo ao ForumCommunity");
                        System.out.println("1 - Perguntar");
                        System.out.println("2 - Responder");
                        System.out.println("3 - Listar Forum");
                        System.out.println("4 - Voltar");
                        controle = lerInt.nextInt();
                        if(controle == 1){
                            System.out.print("Digite sua pergunta: ");
                            String texto = lerString.nextLine();
                            pergunta = new Pergunta(texto, logado);   
                            acesso.RepPergunta(pergunta);
                            System.out.println("Pergunta efetuada com sucesso...");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GamersCommunity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        
                        else if(controle == 2){
                             System.out.println("Perguntas recentes");
                             acesso.ListarForum();
                             System.out.print("Selecione uma pergunta: ");
                             int selecionar = lerInt.nextInt();
                             acesso.ExibirPergunta(selecionar);
                             for(Respostas aux : acesso.ExibirRespostas(pergunta)){
                                 System.out.println(aux);
                             }
                             System.out.print("Digite sua resposta: ");                               
                             String texto = lerString.nextLine();
                             acesso.Responder(selecionar, pergunta, texto, logado);
                             System.out.println("Resposta efetuada com sucesso...");
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GamersCommunity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                       }
                        
                        else if(controle == 3){
                            acesso.ListarForum();
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GamersCommunity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                        else if(controle == 4){
                            log = 0;
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GamersCommunity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
					
						
					}
				}
				
			}
			//cadastro
			while(fim==2){
	
				System.out.println("Bem Vindo a área de cadastro!");
				System.out.println("Digite seu Login:");
				String login = lerString.nextLine();
				System.out.println("Digite a Senha");
				String senha = "123";
				senha = lerString.nextLine();
				System.out.println("Fale sobre você!");
				String descricao = lerString.nextLine();
				System.out.println("Tipo de jogador: 1 - Casual 2 - Hardcore 3 - Entusiasta");
				int tipoplay = lerInt.nextInt();
				
				if(tipoplay == 1) {
					Usuario cadastrarUSU = new Usuario(login, senha, descricao, idusu,tipoJogador.CASUAL);
					idusu++;
					if(cadastroUsu.existe(login)==false) {
						cadastroUsu.cadastrar(cadastrarUSU);
						System.out.println("Usuario cadastrado com sucesso!");
						cadastroUsu.getRepositorioUsuario().Gravar(cadastroUsu.getRepositorioUsuario());
						fim=0;
					}
					else {
						System.out.println("Usuario Já existe");
					}
				}
				else if(tipoplay == 2) {
					Usuario cadastrarUSU = new Usuario(login, senha, descricao, idusu,tipoJogador.HARDCORE);
					idusu++;
					if(cadastroUsu.existe(login)==false) {
						cadastroUsu.cadastrar(cadastrarUSU);
						System.out.println("Usuario cadastrado com sucesso!");
						cadastroUsu.getRepositorioUsuario().Gravar(cadastroUsu.getRepositorioUsuario());
						fim=0;
					}
					else {
						System.out.println("Usuario Já existe");
					}
				}
				else if(tipoplay == 3) {
					Usuario cadastrarUSU = new Usuario(login, senha, descricao, idusu,tipoJogador.ENTUSIASTA);
					idusu++;
					if(cadastroUsu.existe(login)==false) {
						cadastroUsu.cadastrar(cadastrarUSU);
						System.out.println("Usuario cadastrado com sucesso!");
						cadastroUsu.getRepositorioUsuario().Gravar(cadastroUsu.getRepositorioUsuario());
						fim=0;
					}
					else {
						System.out.println("Usuario Já existe");
					}
				}
				else {
					System.out.println("opção de tipo de jogador inválida!");
					fim = 0;
				}
				
			}	
			while(fim==3) {
				System.out.println("Bem vindo a área de ADM");
				System.out.println("Continuar? 3 - Sim  1 - Não");
				fim = lerInt.nextInt();
				System.out.println("Digite seu login:");
				String login = lerString.nextLine();
				System.out.println("Digite sua senha");
				String senha = lerString.nextLine();
				int adm=0;
				if(login.equals("ADM123") && senha.equals("12345678")) {
					System.out.println("LOGADO COM SUCESSO!");
					while(adm==0){
					System.out.println("Bem vindo MESTRE");
					
					System.out.println("");
					System.out.println("1-Remover Jogo\n2-Adicionar Jogo\n3-Remover Usuario\n4-Fechar programa");
					adm = lerInt.nextInt();
					}
					while(adm==4) {
						fim = 1;
					}
					while(adm==1) {
						System.out.println("digite nome do jogo que quer deletar:");
						String nome = lerString.nextLine();
						System.out.println("digite o tipo de jogo: 1-aventura, 2-corrida, 3-Esportes,4-Luta, 5-online, 6-rpg, 7-simulador,8-tiro");
						int tipo = lerInt.nextInt();
						boolean a = cadastroJogos.descadastrar(nome, tipo);
						if(a==true) {
							System.out.println("Jogo removido com sucesso!");
							idJogo--;
							adm=1;
							
						}
						else {
							System.out.println("Jogo inexistente no repositório!");
							adm=1;
						}
					}
					while(adm==2) {
						System.out.println("digite o nome do jogo");
						String jogo = lerString.nextLine();
						System.out.println("digite o tipo de jogo: 1-aventura, 2-corrida, 3-Esportes,4-Luta, 5-online, 6-rpg, 7-simulador,8-tiro");
						int tipo= lerInt.nextInt();
						if(tipo==1) {
							Aventura jogoCadas = new Aventura(idJogo, jogo, tipo);
							boolean a = cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 2) {
							Corrida jogoCadas = new Corrida(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 3) {
							Esportes jogoCadas = new Esportes(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 4) {
							Luta jogoCadas = new Luta(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 5) {
							Online jogoCadas = new Online(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 6) {
							Rpg jogoCadas = new Rpg(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 7) {
							Simulador jogoCadas = new Simulador(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else if(tipo == 8) {
							Tiro jogoCadas = new Tiro(idJogo, jogo, tipo);
							boolean a=cadastroJogos.cadastrar(jogoCadas);
							if(a==true) {
								System.out.println("jogo cadastrado com sucesso!");
								idJogo++;
							}
							adm=0;
						}
						else {
							System.out.println("tipo inválido");
							adm = 0;
						}
						
					}
					while(adm==3) {
						System.out.println("Remover usuário");
						System.out.println("");
						System.out.println("Digite o login");
						String nomelogin = lerString.nextLine();
						boolean a = cadastroUsu.descadastrar(nomelogin);
						if(a==true) {
							System.out.println("Deletado com sucesso!");
							idusu--;
							adm=0;
						}
						else {
							System.out.println("Usuario nao existe");
							adm=0;
						}
					}
				}	
			}
			while(fim==4) {
				fim=5;
				programa = 1;
			}
		}while(programa==0);
		cadastroUsu.getRepositorioUsuario().Gravar(cadastroUsu.getRepositorioUsuario());
	}
	
}
