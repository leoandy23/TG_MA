package clases;

import java.util.ArrayList;

public class rio {
  public ArrayList<personaje> ladoInicial;
  public ArrayList<personaje> ladoFinal;

  public rio() {
    this.ladoInicial = new ArrayList<personaje>();
    this.ladoFinal = new ArrayList<personaje>();
  }

  public void addPersonajeInicial(personaje p) {
    this.ladoInicial.add(p);
  }

  public void moverPersonajeAFinal(personaje p) {
    this.ladoInicial.remove(p);
    this.ladoFinal.add(p);
  }

  public void moverPersonajeAInicio(personaje p) {
    this.ladoFinal.remove(p);
    this.ladoInicial.add(p);
  }

  public boolean terminarPartida(personaje caperucita,personaje lobo,personaje uvas,personaje observador) {
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
    for (personaje p : this.ladoInicial) {
      rio += p.getNombre() + " ";
    }
    rio += "\n";
    rio += "Lado final: ";
    for (personaje p : this.ladoFinal) {
      rio += p.getNombre() + " ";
    }
    rio += "\n------------------------------------";
    return rio;
  }
}
