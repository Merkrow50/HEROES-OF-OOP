package ClasseArma;

import ClasseArma.Arma;

public class Balestra extends Arma {
  private static int ataque = 15;
  private static int defesa = 10;

  public Balestra() {
    super(ataque, defesa);
  }
}
