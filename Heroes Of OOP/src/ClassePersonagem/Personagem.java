package ClassePersonagem;
import ClasseArma.Arma;

public class Personagem {

  private int ataque;
  private float defesa;
  private float pontosDeVida;
  private float defesaInicial;
  Arma arma1;
  Arma arma2;

  public Personagem(int ataque, float defesa, float pontosDeVida, Arma arma1, Arma arma2){
    this.arma1 = arma1;
    this.arma2 = arma2;
    this.ataque = ataque;
    this.defesa = defesa;
    this.pontosDeVida = pontosDeVida;

  }

  public void setPontosDeVida(float pontosDeVida) {
    this.pontosDeVida = pontosDeVida;
  }

  public int getAtaque() {
    return ataque;
  }

  public void setDefesaInicial(float defesaInicial) {
    this.defesaInicial = defesaInicial;
  }

  public float getDefesaInicial() {
    return defesaInicial;
  }

  public float getDefesa() {
    return defesa;
  }

  public void chooseWeapon(int weapon){
    if(weapon == 1){
      setAtaque(getAtaque() + arma1.getAtaque());
      setDefesa(getDefesa() + arma1.getDefesa());
      setDefesaInicial(getDefesa());
    }
    if(weapon == 2){
      setAtaque(getAtaque() + arma2.getAtaque());
      setDefesa(getDefesa() + arma2.getDefesa());
      setDefesaInicial(getDefesa());
    }
    if(weapon != 1 && weapon != 2){
      System.out.println("Valor Inválido! Escolha uma arma com o valor entre 1 e 2!");
    }
  }

  public void setAtaque(int ataque) {
    this.ataque = ataque;
  }

  public void setDefesa(float defesa) {
    this.defesa = defesa;
  }

  public float getPontosDeVida() {
    return pontosDeVida;
  }

  @Override
  public String toString() {
    return "Personagem{" +
        "ataque=" + ataque +
        ", defesa=" + defesa +
        ", pontosDeVida=" + pontosDeVida +
        ", arma1=" + arma1 +
        ", arma2=" + arma2 +
        '}';
  }
}
