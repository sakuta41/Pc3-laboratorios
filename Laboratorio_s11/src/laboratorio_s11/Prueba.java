/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_s11;

/**
 *
 * @author cesar
 */
public class Prueba {
    public static void main(String[] args) {
        int operaciones = 1000000;
        
        System.out.println("Iniciando pruebas de rendimiento con " + operaciones + " operaciones...\n");

        // --- PRUEBA PILA ESTATICA ---
        long inicioEstatica = System.nanoTime();
        
        PilaEstatica pilaEst = new PilaEstatica(operaciones);
        for (int i = 0; i < operaciones; i++) {
            pilaEst.push(i);
        }
        while (!pilaEst.isEmpty()) {
            pilaEst.pop();
        }
        
        long finEstatica = System.nanoTime();
        long tiempoEstaticaMs = (finEstatica - inicioEstatica) / 1_000_000;
        System.out.println("Tiempo Pila Estatica: " + tiempoEstaticaMs + " ms");

        // --- PRUEBA PILA DINAMICA ---
        long inicioDinamica = System.nanoTime();
        
        PilaDinamica pilaDin = new PilaDinamica();
        for (int i = 0; i < operaciones; i++) {
            pilaDin.push(i);
        }
        while (!pilaDin.isEmpty()) {
            pilaDin.pop();
        }
        
        long finDinamica = System.nanoTime();
        long tiempoDinamicaMs = (finDinamica - inicioDinamica) / 1_000_000;
        System.out.println("Tiempo Pila Dinamica: " + tiempoDinamicaMs + " ms");
    }
}