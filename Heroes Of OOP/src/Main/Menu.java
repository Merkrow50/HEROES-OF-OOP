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
import java.util.Scanner;

public class Menu {


  public void atacar(Jogador jogador, Personagem dragao){
    float dano = jogador.getPersonagem().getAtaque() - dragao.getDefesa();
    dragao.setPontosDeVida((int) (dragao.getPontosDeVida() - dano));
  }

  public void resetRound(Jogador jogador){
    int defesa = (int) (jogador.getPersonagem().getDefesa() - jogador.getPersonagem().getDefesaInicial() * 0.1);
    jogador.getPersonagem().setDefesa(defesa);
  }

  public void defender(Jogador jogador){
    jogador.getPersonagem().setDefesa((float) (jogador.getPersonagem().getDefesa() + jogador.getPersonagem().getDefesa() * 0.1)); ;
  }

  public void ataqueDragao(Jogador jogador, Personagem dragao){
    float dano = dragao.getAtaque() - jogador.getPersonagem().getDefesa();
    jogador.getPersonagem().setPontosDeVida(jogador.getPersonagem().getPontosDeVida() - dano);
  }

  public void deadPlayer(String iniciar, Jogador jogador1, Jogador jogador2, Jogador jogador3, Personagem dragao, int i){

      if (Objects.equals(iniciar, "atacar")) {

        if (i == 1) {
          System.out.println("Jogador 1 atacando!");
          assert jogador1 != null;
          atacar(jogador1, dragao);
          if (jogador2 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 2 && jogador2 != null) {
          System.out.println("Jogador 2 atacando!");
          atacar(jogador2, dragao);
          if (jogador3 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0 && jogador2.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 3 && jogador3 != null) {
          System.out.println("Jogador 3 atacando!");
          atacar(jogador3, dragao);
          i -= 2;
        }
      }

      if (Objects.equals(iniciar, "defender")) {

        if (i == 1) {
          System.out.println("Jogador 1 defendendo!");
          defender(jogador1);
          if (jogador2 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 2 && jogador2.getPersonagem() != null) {
          System.out.println("Jogador 2 defendendo!");
          defender(jogador2);
          if (jogador3 == null) {
            i = 0;
            if (jogador1.getPersonagem().getPontosDeVida() == 0 && jogador2.getPersonagem().getPontosDeVida() == 0) {
              return;
            }
          }
        }

        if (i == 3 && jogador3.getPersonagem() != null) {
          System.out.println("Jogador 3 defendendo!");
          defender(jogador3);
          i -= 2;
        }
      }
    }


  public void chooseatk(String iniciar, Jogador jogador1, Jogador jogador2, Jogador jogador3, Personagem dragao, int i){

    if(i == 1) {
      if (jogador1.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O jogador " + jogador1.getNome() + " está morto!");
        return;
      }
      deadPlayer(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

    if(i == 2) {
      if (jogador2.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O jogador " + jogador2.getNome() + " está morto!");
        return;
      }
      deadPlayer(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

    if(i == 3) {
      if (jogador3.getPersonagem().getPontosDeVida() <= 0){
        System.out.println("O jogador " + jogador3.getNome() + " está morto!");
        return;
      }
      deadPlayer(iniciar, jogador1, jogador2, jogador3, dragao, i);
    }

  }


  public void createPerson(Jogador jogador1, String iniciar){
    Scanner scanner = new Scanner(System.in);

    Personagem mago = new Mago();
    Personagem arqueiro = new Arqueiro();
    Personagem guerreiro = new Guerreiro();
    Personagem dragao = new Dragao();

    String nome;
    String personagem;

    int arma;

    Arma espada = new Espada();
    Arma varinha = new Varinha();
    Arma arcoLongo = new ArcoLongo();
    Arma balestra = new Balestra();
    Arma machado = new Machado();
    Arma cajado = new Cajado();

    if (Objects.equals(iniciar, "criar")) { // TRUE
      System.out.println("Digite qual o Nome do seu personagem:");
      nome = scanner.next();
      System.out.println("Digite qual a Classe do seu personagem:");
      System.out.println("Digite 1 : | --- Mago ---| | ATQ --- 20 --- | | DEF --- 10 --- | | PDV --- 200 --- |\n");
      System.out.println("Digite 2 : | --- Guerreiro  ---| | ATQ --- 30 --- | | DEF --- 20 --- | | PDV --- 180 --- |\n");
      System.out.println("Digite 3 : | --- Arqueiro  ---| | ATQ --- 20 --- | | DEF --- 30 --- | | PDV --- 160 --- |\n");
      personagem = scanner.next();

      if (Objects.equals(personagem, "1")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(mago);
        System.out.println("Escolha a arma para o seu Mago!");
        System.out.println("Digite 1 : | --- Varinha ---| | ATQ --- +16 --- | | DEF --- +9 --- |\n");
        System.out.println("Digite 2 : | --- Cajado  ---| | ATQ --- +13 --- | | DEF --- +12 --- |\n");
        arma = scanner.nextInt();

        if (Objects.equals(arma, 1)) {
          mago.chooseWeapon(arma);

        }

        if (Objects.equals(arma, 2)) {
          mago.chooseWeapon(arma);

        }
      }

      if (Objects.equals(personagem, "2")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(guerreiro);
        System.out.println("Escolha a arma para o seu Guerreiro!");
        System.out.println("Digite 1 : | --- Espada ---| | ATQ --- +10 --- | | DEF --- +15 --- |\n");
        System.out.println("Digite 2 : | --- Machado  ---| | ATQ --- +17 --- | | DEF --- +8 --- |\n");
        arma = scanner.nextInt();
        if (Objects.equals(arma, 1)) {
          guerreiro.chooseWeapon(arma);

        }

        if (Objects.equals(arma, 2)) {
          guerreiro.chooseWeapon(arma);

        }
      }

      if (Objects.equals(personagem, "3")) {
        jogador1.setNome(nome);
        jogador1.setPersonagem(arqueiro);
        System.out.println("Escolha a arma para o seu Arqueiro!");
        System.out.println("Digite 1 : | --- Arco Longo ---| | ATQ --- +12 --- | | DEF --- +13 --- |\n");
        System.out.println("Digite 2 : | --- Balestra  ---| | ATQ --- +15 --- | | DEF --- +10 --- |\n");
        arma = scanner.nextInt();
        if (Objects.equals(arma, 1)) {

          arqueiro.chooseWeapon(arma);

        }

        if (Objects.equals(arma, 2)) {

          arqueiro.chooseWeapon(arma);

        }


      }
      System.out.println("Personagem Criado com sucesso!");

    }
  }
}