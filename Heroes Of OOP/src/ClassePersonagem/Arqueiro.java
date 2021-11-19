package ClassePersonagem;

import ClasseArma.ArcoLongo;
import ClasseArma.Arma;
import ClasseArma.Balestra;

public class Arqueiro extends Personagem {

  private static int ataque = 100;
  private static int defesa = 30;
  private static float pontosDeVida = 160;
  private static Arma arma1 = new ArcoLongo();
  private static Arma arma2 = new Balestra();

  public Arqueiro() {
    super(ataque,defesa,pontosDeVida,arma1,arma2);
  }

  @Override
  public void chooseWeapon(int weapon) {
    super.chooseWeapon(weapon);
    if(weapon == 1) {
      System.out.println("Seu Arqueiro foi equipado com uma Arco Longo seu poder de ataque aumentou para " + this.getAtaque() + "  e sua defesa para " + this.getDefesa() );
    }

    if(weapon == 2) {
      System.out.println("Seu Arqueiro foi equipado com uma Balestra seu poder de ataque aumentou para " + this.getAtaque() + "  e sua defesa para " + this.getDefesa());
    }
  }

}
