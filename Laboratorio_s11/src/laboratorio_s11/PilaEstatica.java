/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_s11;

/**
 *
 * @author cesar
 */
public class PilaEstatica {
        private int[] arreglo;
        private int tope;

        public PilaEstatica(int capacidad) {
            arreglo = new int[capacidad];
            tope = -1; // Pila vacía
        }

        public void push(int elemento) {
            if (tope == arreglo.length - 1) {
                throw new IllegalStateException("Error: Pila estática llena (Overflow)");
            }
            arreglo[++tope] = elemento;
        }

        public int pop() {
            if (isEmpty()) {
                throw new java.util.EmptyStackException();
            }
            return arreglo[tope--];
        }

        public int peek() {
            if (isEmpty()) {
                throw new java.util.EmptyStackException();
            }
            return arreglo[tope];
        }

        public boolean isEmpty() {
            return tope == -1;
        }

        public int size() {
            return tope + 1;
        }
    }