import clases.personaje;
import clases.rio;

public class main {
  /*
   * @params args the comand lines arguments
   */
  public static void main(String[] args) {
  
    // Creación de los personajes y el rio
    rio rio = new rio();
    personaje lobo = new personaje("lobo");
    personaje caperucita = new personaje("caperucita");
    personaje uvas = new personaje("uvas");
    personaje observador = new personaje("observador");
    
    rio.addPersonajeInicial(lobo);
    rio.addPersonajeInicial(caperucita);
    rio.addPersonajeInicial(uvas);
    rio.addPersonajeInicial(observador);
    // Bienvenida al juego
    System.out.println("------------------------------------------------------------------------------------------------");
    System.out.println("Bienvenido al juego de la caperucita roja");
    System.out.println("Para ganar el juego el observador debe llevar a caperucita, el lobo y a las uvas al otro lado del rio");
    System.out.println("Pero ten cuidado, si caperucita se queda sola con el lobo o con las uvas, pierdes");
    System.out.println("Para mover a los personajes, escribe el nombre del personaje que quieres mover");
    System.out.println("Si quieres mover a caperucita, escribe caperucita");
    System.out.println("Si quieres mover al lobo, escribe lobo");
    System.out.println("Si quieres mover a las uvas, escribe uvas");
    System.out.println("------------------------------------------------------------------------------------------------");

    while (true) {
      System.out.println("-----LADO INICIAL-----");
      System.out.println("Ingresa el nombre del personaje que quieres llevar al otro lado del rio (caperucita, lobo, uvas):");
      String personaje = System.console().readLine();
      if (personaje.equals("caperucita")) {
        if (rio.ladoInicial.contains(caperucita)) {
          rio.moverPersonajeAFinal(caperucita);
          rio.moverPersonajeAFinal(observador);
        } else {
          System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
        }
      } else if (personaje.equals("lobo")) {
        if (rio.ladoInicial.contains(lobo)) {
          rio.moverPersonajeAFinal(lobo);
          rio.moverPersonajeAFinal(observador);
        } else {
          System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
        }
      } else if (personaje.equals("uvas")) {
        if (rio.ladoInicial.contains(uvas)) {
          rio.moverPersonajeAFinal(uvas);
          rio.moverPersonajeAFinal(observador);
        } else {
          System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
        }
      } else {
        System.out.println("El personaje ingresado no existe");
      }

      if (rio.terminarPartida(caperucita, lobo, uvas, observador)) {
        System.out.println(rio.toString());
        System.out.println("****PERDISTE****");
        break;
      }
      
      if (rio.ganarJuego()) {
        System.out.println(rio.toString());
        System.out.println("****GANASTE****");
        break;
      }
      
      if (rio.ladoFinal.contains(observador)) {
        System.out.println(rio.toString());
        System.out.println("-----LADO FINAL-----");
      System.out.println("Quieres llevar a alguien de regreso ? [si/no]");
      String respuesta = System.console().readLine();
      if (respuesta.equals("si")) {
        System.out.println("Ingresa el nombre del personaje que quieres llevar de regreso (caperucita, lobo, uvas):");
        personaje = System.console().readLine();
        if (personaje.equals("caperucita")) {
          if (rio.ladoFinal.contains(caperucita)) {
            rio.moverPersonajeAInicio(caperucita);
            rio.moverPersonajeAInicio(observador);
          } else {
            System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
          }
        } else if (personaje.equals("lobo")) {
          if (rio.ladoFinal.contains(lobo)) {
            rio.moverPersonajeAInicio(lobo);
            rio.moverPersonajeAInicio(observador);
          } else {
            System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
          }
        } else if (personaje.equals("uvas")) {
          if (rio.ladoFinal.contains(uvas)) {
            rio.moverPersonajeAInicio(uvas);
            rio.moverPersonajeAInicio(observador);
            
          } else {
            System.out.println("###EL PERSONAJE NO SE ENCUENTRA DE ESTE LADO###");
          }
        } else {
          System.out.println("###El personaje ingresado no existe###");
        }
      } else {
         rio.moverPersonajeAInicio(observador);
      }
      }

      System.out.println(rio.toString());
      if (rio.terminarPartida(caperucita, lobo, uvas, observador)) {
        System.out.println(rio.toString());
        System.out.println("****PERDISTE****");
        break;
      }


    }
    
  }
}
