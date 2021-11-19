package ClasseArma;

import ClasseArma.Arma;

public class Machado extends Arma {

  private static int ataque = 10;
  private static int defesa = 15;

  public Machado() {
    super(ataque, defesa);
  }
}
