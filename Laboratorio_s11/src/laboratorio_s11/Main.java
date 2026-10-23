package laboratorio_s11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   DEMOSTRACION: PILA ESTATICA          ");
        System.out.println("========================================");
        try {
            PilaEstatica pilaEst = new PilaEstatica(3);
            System.out.println("La pila estatica esta vacia: " + pilaEst.isEmpty());
            
            pilaEst.push(10);
            pilaEst.push(20);
            pilaEst.push(30);
            System.out.println("Elementos insertados: 10, 20, 30");
            System.out.println("Tope actual (peek): " + pilaEst.peek());
            System.out.println("Tamano actual: " + pilaEst.size());

            System.out.println("Extrayendo elemento (pop): " + pilaEst.pop());
            System.out.println("Nuevo tope despues del pop: " + pilaEst.peek());
            
            pilaEst.push(40);
            System.out.println("Se inserto 40. Nuevo tope: " + pilaEst.peek());
        } catch (Exception e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        }
        
        PilaDinamica pilaDin = new PilaDinamica();
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("   MENU INTERACTIVO: PILA DINAMICA      ");
            System.out.println("========================================");
            System.out.println("1. Insertar elemento (Push)");
            System.out.println("2. Eliminar elemento (pop)");
            System.out.println("3. Ver elemento en el tope (Peek)");
            System.out.println("4. Ver tamano actual de la pila");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el valor entero a insertar: ");
                        int valor = scanner.nextInt();
                        pilaDin.push(valor);
                        System.out.println("Elemento " + valor + " insertado con exito.");
                        break;
                    case 2:
                        try {
                            int eliminado = pilaDin.pop();
                            System.out.println("Elemento eliminado (pop): " + eliminado);
                        } catch (Exception e) {
                            System.out.println("Error: La pila esta vacia (Underflow).");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("El elemento en el tope es: " + pilaDin.peek());
                        } catch (Exception e) {
                            System.out.println("Error: La pila esta vacia.");
                        }
                        break;
                    case 4:
                        System.out.println("El tamano actual de la pila es: " + pilaDin.size());
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.next(); // Limpiar entrada incorrecta
            }
        } while (opcion != 5);

        scanner.close();
    }
}