package clases;

import java.util.ArrayList;

public class Rio {
  public ArrayList<Personaje> ladoInicial;
  public ArrayList<Personaje> ladoFinal;

  public Rio() {
    this.ladoInicial = new ArrayList<Personaje>();
    this.ladoFinal = new ArrayList<Personaje>();
  }

  public void addPersonajeInicial(Personaje p) {
    this.ladoInicial.add(p);
  }

  public void moverPersonajeAFinal(Personaje p) {
    this.ladoInicial.remove(p);
    this.ladoFinal.add(p);
  }

  public void moverPersonajeAInicio(Personaje p) {
    this.ladoFinal.remove(p);
    this.ladoInicial.add(p);
  }

  public boolean terminarPartida(Personaje caperucita,Personaje lobo,Personaje uvas,Personaje observador) {
    boolean gameover = false;

    if ((this.ladoInicial.contains(lobo) & this.ladoInicial.contains(caperucita) & !this.ladoInicial.contains(observador))
        || (this.ladoInicial.contains(uvas) & this.ladoInicial.contains(caperucita) & !this.ladoInicial.contains(observador))) {
      gameover = true;
    }

    if ((this.ladoFinal.contains(lobo) & this.ladoFinal.contains(caperucita) & !this.ladoFinal.contains(observador))
        || (this.ladoFinal.contains(uvas) & this.ladoFinal.contains(caperucita) & !this.ladoFinal.contains(observador))) {
      gameover = true;
    }

    return gameover;
  }
  
  public boolean ganarJuego() {
    boolean win = false;

    if (this.ladoFinal.size() == 4 && this.ladoInicial.size() == 0) {
      win = true;
    }

    return win;
  }
  
  @Override
  public String toString() {
    String rio = "------------------------------------";
    rio += "\nLado inicial: ";
    for (Personaje p : this.ladoInicial) {
      rio += p.getNombre() + " ";
    }
    rio += "\n";
    rio += "Lado final: ";
    for (Personaje p : this.ladoFinal) {
      rio += p.getNombre() + " ";
    }
    rio += "\n------------------------------------";
    return rio;
  }
}
