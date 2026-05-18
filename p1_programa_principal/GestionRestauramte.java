package p1_programa_principal;

import java.io.*;
import java.util.Scanner;

//implementamos todos los paquetes en caso de ser necesarios

import p3_modelo_de_la_aplicacion.*; 
import p4_excepciones.*; 
import p5_interfaces.*; 


public class GestionRestauramte {

	public static void main(String[] args) {
		
	GestionRestauramte gestion = new GestionRestauramte();
    
	Scanner sc = new Scanner(System.in);
        
	int opcion = 0;

        do {
            System.out.println("\n================================");
            System.out.println("      GESTIÓN DEl RESTAURANTE        ");
            System.out.println("================================");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Añadir trabajador");
            System.out.println("3. Eliminar trabajador");
            System.out.println("4. Pedir bebida o postre");
            System.out.println("5. Pedir para comer aqui");
            System.out.println("6. Pedir para llevar");
            System.out.println("7. Pedir wok");
            System.out.println("8. Pedir sushi");
            System.out.println("9. Forma de pago");
            System.out.println("10. Salir");
            System.out.print("Elige una opción (1-10): ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Introduce tu nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce tu teléfono (9 dígitos): ");
                    String telefono = sc.nextLine();
                    System.out.print("Introduce tu direccion: ");
                    String direccion = sc.nextLine();

                    if (gestion.guardarCliente(nombre, telefono, direccion)) {
                        System.out.println("Cliente añadido correctamente.");
                    } else {
                        System.out.println("No se pudo añadir el cliente (Dato introducido es incorrecto).");
                    }
                    gestion.guardarCliente();
                    break;

                case 2:
                	System.out.print("Introduce tu nombre: ");
                    int idTrabajador = sc.nextInt();
                    System.out.print("Introduce tu teléfono (9 dígitos): ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce tu direccion: ");
                    String direccion = sc.nextLine();

                    if (gestion.guardarCliente(nombre, telefono, direccion)) {
                        System.out.println("Cliente añadido correctamente.");
                    } else {
                        System.out.println("No se pudo añadir el cliente (Dato introducido es incorrecto).");
                    }
                    gestion.guardarCliente();
                    break;

                case 3:
                    gestion.listarPacientes();
                    break;

                case 4:
                    System.out.print("Nombre del paciente a modificar: ");
                    String nombreMod = sc.nextLine();
                    System.out.print("Teléfono del paciente: ");
                    String telMod = sc.nextLine();

                    Paciente pMod = gestion.buscarPaciente(nombreMod, telMod);
                    if (pMod != null) {
                        System.out.print("¿Qué dato quieres modificar? (direccion / baja): ");
                        String campo = sc.nextLine();

                        if (campo.equalsIgnoreCase("direccion")) {
                            System.out.print("Nueva dirección: ");
                            pMod.setDirección(sc.nextLine());
                            System.out.println("Dirección modificada correctamente.");
                        } else if (campo.equalsIgnoreCase("baja")) {
                            System.out.print("¿Está de baja? (s/n): ");
                            pMod.setBaja(sc.nextLine().equalsIgnoreCase("s"));
                            System.out.println("Estado de baja modificado correctamente.");
                        } else {
                            System.out.println("Opción no válida.");
                        }
                    } else {
                        System.out.println("El paciente indicado no existe.");
                    }
                    break;

                case 5:
                    System.out.print("Nombre del paciente a eliminar: ");
                    String nombreEli = sc.nextLine();
                    System.out.print("Teléfono del paciente: ");
                    String telEli = sc.nextLine();

                    if (gestion.eliminarPaciente(nombreEli, telEli)) {
                        System.out.println("Paciente eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró al paciente para eliminar.");
                    }
                    break;

                case 6:
                    

                case 7:
                    System.out.println("Saliendo del sistema…");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}