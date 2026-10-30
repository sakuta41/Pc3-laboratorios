package laboratorio_s12;


public class Main {

    // ==========================================
    // 1. COLA UTILIZANDO ARREGLO CIRCULAR
    // ==========================================

    static class ColaCircular {

        private int[] arreglo;
        private int frente;
        private int fin;
        private int cantidad;

        public ColaCircular(int capacidad) {

            if (capacidad <= 0) {
                throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero."
                );
            }

            arreglo = new int[capacidad];
            frente = 0;
            fin = -1;
            cantidad = 0;
        }

        public void encolar(int dato) {

            if (cantidad == arreglo.length) {
                System.out.println("Error: Cola circular llena.");
                return;
            }

            fin = (fin + 1) % arreglo.length;
            arreglo[fin] = dato;
            cantidad++;
        }

        public int desencolar() {

            if (estaVacia()) {
                throw new IllegalStateException(
                    "Error: No se puede desencolar una cola vacia."
                );
            }

            int dato = arreglo[frente];

            frente = (frente + 1) % arreglo.length;
            cantidad--;

            if (cantidad == 0) {
                frente = 0;
                fin = -1;
            }

            return dato;
        }

        public int frente() {

            if (estaVacia()) {
                throw new IllegalStateException(
                    "La cola esta vacia."
                );
            }

            return arreglo[frente];
        }

        public boolean estaVacia() {
            return cantidad == 0;
        }

        public boolean estaLlena() {
            return cantidad == arreglo.length;
        }

        public int tamanio() {
            return cantidad;
        }

        public void mostrar() {

            if (estaVacia()) {
                System.out.println("Cola vacia.");
                return;
            }

            System.out.print("Cola circular: ");

            for (int i = 0; i < cantidad; i++) {

                int indice = (frente + i) % arreglo.length;

                System.out.print(arreglo[indice] + " ");
            }

            System.out.println();
        }
    }


    // ==========================================
    // 2. COLA UTILIZANDO LISTAS ENLAZADAS
    // ==========================================

    static class ColaEnlazada {

        private class Nodo {

            int dato;
            Nodo siguiente;

            public Nodo(int dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        private Nodo frente;
        private Nodo fin;
        private int cantidad;

        public ColaEnlazada() {
            frente = null;
            fin = null;
            cantidad = 0;
        }

        public void encolar(int dato) {

            Nodo nuevo = new Nodo(dato);

            if (estaVacia()) {

                frente = nuevo;
                fin = nuevo;

            } else {

                fin.siguiente = nuevo;
                fin = nuevo;
            }

            cantidad++;
        }

        public int desencolar() {

            if (estaVacia()) {
                throw new IllegalStateException(
                    "Error: No se puede desencolar una cola vacia."
                );
            }

            int dato = frente.dato;

            frente = frente.siguiente;
            cantidad--;

            if (frente == null) {
                fin = null;
            }

            return dato;
        }

        public int frente() {

            if (estaVacia()) {
                throw new IllegalStateException(
                    "La cola esta vacia."
                );
            }

            return frente.dato;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public int tamanio() {
            return cantidad;
        }

        public void mostrar() {

            if (estaVacia()) {
                System.out.println("Cola vacia.");
                return;
            }

            Nodo actual = frente;

            System.out.print("Cola enlazada: ");

            while (actual != null) {

                System.out.print(actual.dato + " ");

                actual = actual.siguiente;
            }

            System.out.println();
        }
    }


    // ==========================================
    // 3. COLA CON PRIORIDAD BASICA
    // ==========================================

    static class ColaPrioridad {

        private class Nodo {

            int dato;
            int prioridad;
            Nodo siguiente;

            public Nodo(int dato, int prioridad) {

                this.dato = dato;
                this.prioridad = prioridad;
                this.siguiente = null;
            }
        }

        private Nodo frente;
        private int cantidad;

        public ColaPrioridad() {
            frente = null;
            cantidad = 0;
        }

        // Menor numero = mayor prioridad
        public void encolar(int dato, int prioridad) {

            Nodo nuevo = new Nodo(dato, prioridad);

            if (frente == null ||
                prioridad < frente.prioridad) {

                nuevo.siguiente = frente;
                frente = nuevo;

            } else {

                Nodo actual = frente;

                while (actual.siguiente != null &&
                       actual.siguiente.prioridad <= prioridad) {

                    actual = actual.siguiente;
                }

                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
            }

            cantidad++;
        }

        public int desencolar() {

            if (estaVacia()) {
                throw new IllegalStateException(
                    "Error: La cola de prioridad esta vacia."
                );
            }

            int dato = frente.dato;

            frente = frente.siguiente;
            cantidad--;

            return dato;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public int tamanio() {
            return cantidad;
        }

        public void mostrar() {

            if (estaVacia()) {
                System.out.println("Cola de prioridad vacia.");
                return;
            }

            Nodo actual = frente;

            System.out.println("Cola de prioridad:");

            while (actual != null) {

                System.out.println(
                    "Dato: " + actual.dato +
                    " | Prioridad: " + actual.prioridad
                );

                actual = actual.siguiente;
            }
        }
    }


    // ==========================================
    // 4. COMPARACION DE RENDIMIENTO
    // ==========================================

    public static void compararRendimiento() {

        final int N = 1000;

        long inicio;
        long fin;

        // Cola circular

        ColaCircular circular = new ColaCircular(N);

        inicio = System.nanoTime();

        for (int i = 0; i < N; i++) {
            circular.encolar(i);
        }

        for (int i = 0; i < N; i++) {
            circular.desencolar();
        }

        fin = System.nanoTime();

        long tiempoCircular = fin - inicio;


        // Cola enlazada

        ColaEnlazada enlazada = new ColaEnlazada();

        inicio = System.nanoTime();

        for (int i = 0; i < N; i++) {
            enlazada.encolar(i);
        }

        for (int i = 0; i < N; i++) {
            enlazada.desencolar();
        }

        fin = System.nanoTime();

        long tiempoEnlazada = fin - inicio;


        // Cola de prioridad

        ColaPrioridad prioridad = new ColaPrioridad();

        inicio = System.nanoTime();

        for (int i = 0; i < N; i++) {

            int nivel = i % 10;

            prioridad.encolar(i, nivel);
        }

        for (int i = 0; i < N; i++) {
            prioridad.desencolar();
        }

        fin = System.nanoTime();

        long tiempoPrioridad = fin - inicio;


        // Mostrar resultados

        System.out.println("\n================================");
        System.out.println(" COMPARACION DE RENDIMIENTO");
        System.out.println("================================");

        System.out.println("Cantidad de elementos: " + N);

        System.out.println(
            "Cola circular: " + tiempoCircular + " ns"
        );

        System.out.println(
            "Cola enlazada: " + tiempoEnlazada + " ns"
        );

        System.out.println(
            "Cola prioridad: " + tiempoPrioridad + " ns"
        );

        System.out.println("================================");
    }


    // ==========================================
    // METODO PRINCIPAL
    // ==========================================

    public static void main(String[] args) {

        // PRUEBA 1: COLA CIRCULAR

        System.out.println("\n===== COLA CIRCULAR =====");

        ColaCircular circular = new ColaCircular(5);

        circular.encolar(10);
        circular.encolar(20);
        circular.encolar(30);
        circular.encolar(40);

        circular.mostrar();

        System.out.println(
            "Primer elemento: " + circular.frente()
        );

        System.out.println(
            "Elemento eliminado: " + circular.desencolar()
        );

        circular.encolar(50);
        circular.encolar(60);

        circular.mostrar();

        System.out.println(
            "Esta llena?: " + circular.estaLlena()
        );


        // PRUEBA 2: COLA ENLAZADA

        System.out.println("\n===== COLA ENLAZADA =====");

        ColaEnlazada enlazada = new ColaEnlazada();

        enlazada.encolar(100);
        enlazada.encolar(200);
        enlazada.encolar(300);

        enlazada.mostrar();

        System.out.println(
            "Primer elemento: " + enlazada.frente()
        );

        System.out.println(
            "Elemento eliminado: " + enlazada.desencolar()
        );

        enlazada.mostrar();


        // PRUEBA 3: COLA DE PRIORIDAD

        System.out.println("\n===== COLA DE PRIORIDAD =====");

        ColaPrioridad prioridad = new ColaPrioridad();

        prioridad.encolar(100, 3);
        prioridad.encolar(200, 1);
        prioridad.encolar(300, 2);
        prioridad.encolar(400, 1);
        prioridad.encolar(500, 4);

        prioridad.mostrar();

        System.out.println(
            "\nElemento atendido: " + prioridad.desencolar()
        );

        prioridad.mostrar();


        // PRUEBA 4: SEGURIDAD

        System.out.println("\n===== PRUEBAS DE SEGURIDAD =====");

        ColaEnlazada prueba = new ColaEnlazada();

        try {

            prueba.desencolar();

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());
        }


        // Verificar limite del arreglo circular

        ColaCircular pruebaCircular = new ColaCircular(2);

        pruebaCircular.encolar(10);
        pruebaCircular.encolar(20);
        pruebaCircular.encolar(30);

        pruebaCircular.mostrar();


        // PRUEBA 5: RENDIMIENTO

        compararRendimiento();
    }
}
