package ClassePersonagem;

import ClasseArma.Arma;
import ClasseArma.Cajado;
import ClasseArma.Varinha;

public class Mago extends Personagem {

  private static int ataque = 20;
  private static float defesa = 10;
  private static float pontosDeVida = 200;
  private static Arma arma1 = new Varinha();
  private static Arma arma2 = new Cajado();

  public Mago() {
    super(ataque,defesa,pontosDeVida,arma1,arma2);
  }

  @Override
  public void chooseWeapon(int weapon) {
    super.chooseWeapon(weapon);
    if(weapon == 1) {
      System.out.println("Seu Mago foi equipado com uma Varinha seu poder de ataque aumentou para 36 e sua defesa para 19");
    }

    if(weapon == 2) {
      System.out.println("Seu Mago foi equipado com uma Cajado seu poder de ataque aumentou para 33 e sua defesa para 22");
    }
  }
}
