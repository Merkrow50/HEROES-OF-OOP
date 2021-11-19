package ClassePersonagem;

import ClassePersonagem.Personagem;

public class Dragao extends Personagem {

  private static int ataque = 100;
  private static int defesa = 30;
  private static float pontosDeVida = 300;



  public Dragao() {
    super(ataque,defesa,pontosDeVida,null,null);
  }

}
