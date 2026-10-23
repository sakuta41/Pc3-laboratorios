/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_s11;

/**
 *
 * @author cesar
 */
public class PilaDinamica {
    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo tope;
    private int tamano;

    public PilaDinamica() {
        tope = null;
        tamano = 0;
    }

    public void push(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamano++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        int dato = tope.dato;
        tope = tope.siguiente;
        tamano--;
        return dato;
    }

    public int peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return tope.dato;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size() {
        return tamano;
    }
}