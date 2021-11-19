package ClasseArma;

public class Arma {

  private int ataque;
  private int defesa;

  public Arma(int ataque , int defesa){
    this.ataque = ataque;
    this.defesa = defesa;
  }

  public int getDefesa() {
    return defesa;
  }

  public int getAtaque() {
    return ataque;
  }

  @Override
  public String toString() {
    return "Arma{" +
        "ataque=" + ataque +
        ", defesa=" + defesa +
        '}';
  }
}
