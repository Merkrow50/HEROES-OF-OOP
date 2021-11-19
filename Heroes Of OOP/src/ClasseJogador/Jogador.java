package ClasseJogador;

import ClassePersonagem.Personagem;

public class Jogador {

  private Personagem personagem;
  private String nome;

  public Jogador(Personagem personagem, String nome){

    this.personagem = personagem;
    this.nome = nome;

  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPersonagem(Personagem personagem) {
    this.personagem = personagem;
  }

  public Personagem getPersonagem() {
    return personagem;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "Jogador{" +
        "personagem=" + personagem +
        ", nome='" + nome + '\'' +
        '}';
  }
}
