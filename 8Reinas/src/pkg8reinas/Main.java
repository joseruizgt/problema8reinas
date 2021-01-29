/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import javax.swing.JOptionPane;

/**
 *
 * @author joser
 */
public class Main {

    public static int contador = 1;

    public static void main(String[] args) {
        String[][] tablero;
        boolean s = true;
        int x = 0;
        do {
            s = true;
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del tablero"));
            } catch (NumberFormatException e) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "Error, el dato ingresado es inválido", "Error",
                        JOptionPane.WARNING_MESSAGE);
                s = false;
            }
        } while (s == false);
        tablero = generarTablero(x);
        ubicarReina(tablero, 0);
    }

    public static void ubicarReina(String[][] tablero, int columna) {

        for (int i = 0; i < tablero.length; i++) {
            if (PosValida(tablero, i, columna)) {
                tablero[i][columna] = "♕";

                if (columna < tablero.length - 1) {
                    ubicarReina(tablero, columna + 1);
                } else {

                    imprimirMatriz(tablero);
                    

                    System.out.println("");
                    System.out.println("- - - - - - - - - - - - - -");
                    System.out.println("");
                }

                tablero[i][columna] = " ";
            }

        }
    }

    public static boolean PosValida(String[][] tablero, int fila, int columna) {

        for (int x = 0; x < columna; x++) {                                                               //evaluamos la columna entera
            if (tablero[fila][x].equals("♕")) {
                return false;
            }
        }

        for (int j = 0; j < tablero.length && (fila - j) >= 0 && (columna - j) >= 0; j++) {                  //evaluamos la diagonal superior izquierda, no evaluamos la diagonal superior derecha
                                                                                                        //ya que con la primera evaluación por columnas  nos ahorramos esa evaluación
            if (tablero[fila - j][columna - j].equals("♕")) {
                return false;
            }

        }

        for (int j = 0; j < tablero.length && (fila + j) < tablero.length && columna - j >= 0; j++) {       //evaluamos la diagonal inferior izquierda, no evaluamos la diagonal inferior derecha
                                                                                                       //ya que con la primera evaluación por columnas  nos ahorramos esa evaluación
            if (tablero[fila + j][columna - j].equals("♕")) {
                return false;
            }
        }

        return true;

    }

    public static String[][] generarTablero(int tamanio) {
        String[][] res = new String[tamanio][tamanio];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = " ";
            }
        }
        return res;
    }

    public static void imprimirMatriz(String[][] tablero) {
        System.out.println("FORMA NO. " + contador + ")");
        for (int i = 0; i < tablero.length; i++) {       
            for (int j = 0; j < tablero.length; j++) {
                
                if (tablero[i][j].equals("♕")) {
                    System.out.print("♕");
                }else{                    
                    if (i%2 == 0) {
                        if (j%2 == 0) {
                            System.out.print("▢");
                        }else{
                            System.out.print("■");
                        }
                    }else{
                         if (j%2 == 0) {
                             System.out.print("■");
                            
                        }else{
                            System.out.print("▢");
                        }
                    }
                
                }
                
               System.out.print(" ");
            }
            System.out.println();
        }
        contador++;
    }

}
