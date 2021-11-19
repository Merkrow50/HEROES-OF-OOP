package Main;

import ClasseArma.ArcoLongo;
import ClasseArma.Arma;
import ClasseArma.Balestra;
import ClasseArma.Cajado;
import ClasseArma.Espada;
import ClasseArma.Machado;
import ClasseArma.Varinha;
import ClasseJogador.Jogador;
import ClassePersonagem.Arqueiro;
import ClassePersonagem.Dragao;
import ClassePersonagem.Guerreiro;
import ClassePersonagem.Mago;
import ClassePersonagem.Personagem;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class StartGame {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String iniciar;
    String personagem = null;
    int arma;

    Personagem mago = new Mago();
    Personagem arqueiro = new Arqueiro();
    Personagem guerreiro = new Guerreiro();
    Personagem dragao = new Dragao();

    Arma espada = new Espada();
    Arma varinha = new Varinha();
    Arma arcoLongo = new ArcoLongo();
    Arma balestra = new Balestra();
    Arma machado = new Machado();
    Arma cajado = new Cajado();

    Jogador jogador1 = new Jogador(null, null);
    Jogador jogador2 = new Jogador(null, null);
    Jogador jogador3 = new Jogador(null, null);

    Random random = new Random();

    Menu menu = new Menu();

    String nome;

    System.out.println("Seja Bem Vindo ao HEROES OF OOP.");
    System.out.println("Deseja Iniciar uma Nova Partida: ");
    System.out.println("Sim para iniciar não para fechar o jogo: ");
    iniciar = scanner.next();

    if (Objects.equals(iniciar, "sim")) { // TRUE

      System.out.println("o jogo irá iniciar");

    }

    if (Objects.equals(iniciar, "não")) { // FALSE

      System.out.println("Encerrando jogo.");
      System.exit(0);
    }

    System.out.println("Para criar um Personagem digite criar:");
    System.out.println("Para inicar a partida digite iniciar:");
    System.out.println("Para sair do jogo digite sair:");
    iniciar = scanner.next();
    menu.createPerson(jogador1, iniciar);

    if (jogador2.getPersonagem() == null) {
      System.out.println("Deseja criar outro personagem?");
      System.out.println("Digite criar para criar outro personagem.");
      System.out.println("Digite iniciar para iniciar o jogo.");
      System.out.println("Digite sair para fechar o jogo.");
      iniciar = scanner.next();
      menu.createPerson(jogador2, iniciar);
    }

    if (jogador2.getPersonagem() != null) {
      System.out.println("Deseja criar outro personagem?");
      System.out.println("Digite criar para criar outro personagem.");
      System.out.println("Digite iniciar para iniciar o jogo.");
      System.out.println("Digite sair para fechar o jogo.");
      iniciar = scanner.next();
      menu.createPerson(jogador3, iniciar);
    }

    if(jogador3.getPersonagem() != null){
      System.out.println("Deseja iniciar o jogo ou sair?");
      System.out.println("Digite iniciar para iniciar o jogo.");
      System.out.println("Digite sair para fechar o jogo.");
      iniciar = scanner.next();
    }

    if (Objects.equals(iniciar, "iniciar")) {
      for (var i = 1; 0 <= dragao.getPontosDeVida(); i++) {

        int ataqueDragaoAleatorio = random.nextInt(3);

        System.out.println("Começando a rodada");

        for (var j = 1; j <= 3; j++) {

          System.out.println("Para sair do jogo digite sair:");
          System.out.println("Se deseja se posicionar para atacar digite atacar:");
          System.out.println("Se deseja se posicionar para defender digite defender:");
          iniciar = scanner.next();

          if (Objects.equals(iniciar, "sair")) {
            System.out.println("Encerrando jogo!");
            System.exit(0);
          }

          menu.chooseatk(iniciar, jogador1, jogador2, jogador3, dragao, j);

          if (jogador2.getPersonagem() == null) {
            break;
          }

          if (j == 2 && jogador3.getPersonagem() == null) {
            break;
          }

        }

        if (ataqueDragaoAleatorio == 0) {
          menu.ataqueDragao(jogador1, dragao);
          System.out.println("O dragão atacou o jogador " + jogador1.getNome() + " causando " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " de dano!");
          if (Objects.equals(iniciar, "defender")) {
            menu.resetRound(jogador1);
          }
        }

        if (ataqueDragaoAleatorio == 1) {
          if (jogador2.getPersonagem() != null && jogador2.getPersonagem().getPontosDeVida() > 0) {
            menu.ataqueDragao(jogador2, dragao);
            System.out.println("O dragão atacou o " + jogador2.getNome() + " causando " + (dragao.getAtaque() - jogador2.getPersonagem().getDefesa()) + " de dano!");
            if (Objects.equals(iniciar, "defender")) {
              menu.resetRound(jogador2);
            }
          } else {
            if (jogador1.getPersonagem().getPontosDeVida() > 0) {
              menu.atacar(jogador1, dragao);
              System.out.println("O dragão atacou o jogador " + jogador1.getNome() + " causando " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " de dano!");
              if (Objects.equals(iniciar, "defender")) {
                menu.resetRound(jogador1);
              }
            }
          }
        }

        if (ataqueDragaoAleatorio == 2) {
          if (jogador3.getPersonagem() != null && jogador3.getPersonagem().getPontosDeVida() > 0) {
            menu.ataqueDragao(jogador3, dragao);
            System.out.println("O dragão atacou o " + jogador3.getNome() + " causando " + (dragao.getAtaque() - jogador3.getPersonagem().getDefesa()) + " de dano!");
            if (Objects.equals(iniciar, "defender")) {
              menu.resetRound(jogador3);
            }
          } else {
            if (jogador2.getPersonagem() != null && jogador2.getPersonagem().getPontosDeVida() > 0) {
              menu.atacar(jogador2, dragao);
              System.out.println("O dragão atacou o " + jogador2.getNome() + " causando " + (dragao.getAtaque() - jogador2.getPersonagem().getDefesa()) + " de dano!");
              if (Objects.equals(iniciar, "defender")) {
                menu.resetRound(jogador2);
              }
            } else {
              if(jogador3.getPersonagem().getPontosDeVida() > 0) {
                menu.ataqueDragao(jogador1, dragao);
                System.out.println("O dragão atacou o jogador " + jogador1.getNome() + " causando " + (dragao.getAtaque() - jogador1.getPersonagem().getDefesa()) + " de dano!");
                if (Objects.equals(iniciar, "defender")) {
                  menu.resetRound(jogador1);
                }
              }
            }
          }
        }

        float vidaTotal = 0;
        
        if(jogador1.getPersonagem().getPontosDeVida() < 0){
          vidaTotal += 0;
        }else {
          vidaTotal += jogador1.getPersonagem().getPontosDeVida();
        }

        System.out.println("Após está rodada o Dragão ficou com " + dragao.getPontosDeVida() + " pontos de vida");
        System.out.println(jogador1.getNome() + " ficou com " + jogador1.getPersonagem().getPontosDeVida() + " pontos de vida!");

        if (jogador2.getPersonagem() != null) {
          if(jogador2.getPersonagem().getPontosDeVida() < 0){
            vidaTotal += 0;
          }else {
            vidaTotal += jogador2.getPersonagem().getPontosDeVida();
          }
          System.out.println(jogador2.getNome() + " ficou com " + jogador2.getPersonagem().getPontosDeVida() + " pontos de vida!");
        }

        if (jogador3.getPersonagem() != null) {
          if(jogador3.getPersonagem().getPontosDeVida() < 0){
            vidaTotal += 0;
          }else {
            vidaTotal += jogador3.getPersonagem().getPontosDeVida();
          }
          System.out.println(jogador3.getNome() + " ficou com " + jogador3.getPersonagem().getPontosDeVida() + " pontos de vida!");
        }

        if (vidaTotal <= 0) {
          break;
        }
      }
      if (dragao.getPontosDeVida() <= 0) {

        System.out.println("PARABENS VOCÊ DERROTOU O PODEROSO DRAGÃO DA COLINA!");

      } else {

        System.out.println("DESCULPE VOCÊ FOI DERROTADO PELO PODEROSO DRAGÃO DA COLINA! TENTE NOVAMENTE!");
      }
    }

    if (Objects.equals(iniciar, "sair")) {
      System.out.println("Encerrando Jogo!");
      System.exit(0);
    }
  }
}
