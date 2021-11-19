package ClassePersonagem;

import ClasseArma.Arma;
import ClasseArma.Espada;
import ClasseArma.Machado;

public class Guerreiro extends Personagem {

  private static int ataque = 30;
  private static float defesa = 20;
  private static float pontosDeVida = 180;
  private static Arma arma1 = new Espada();
  private static Arma arma2 = new Machado();

  public Guerreiro() {
    super(ataque,defesa,pontosDeVida,arma1,arma2);
  }

  @Override
  public void chooseWeapon(int weapon) {
    super.chooseWeapon(weapon);
    if(weapon == 1) {
      System.out.println("Seu Guerreiro foi equipado com uma Espada seu poder de ataque aumentou para 40 e sua defesa para 35");
    }

    if(weapon == 2) {
      System.out.println("Seu Guerreiro foi equipado com uma Machado seu poder de ataque aumentou para 47 e sua defesa para 28");
    }
  }

}
