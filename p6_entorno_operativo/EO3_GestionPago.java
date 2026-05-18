package p6_entorno_operativo;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EO3_GestionPago {

    private Scanner sc = new Scanner(System.in);
    private final String RUTA_ARCHIVO = "pagoGuardado.txt";

    public void registrarPago() {
        System.out.println("\n--- REGISTRO DE NUEVO PAGO ---");
        
        System.out.print("Ingrese ID de Pago: ");
        int id = sc.nextInt();
        
        System.out.print("Ingrese la Cuenta: ");
        double monto = sc.nextDouble();

        System.out.println("\nSeleccione el Método de Pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.print("Opción: ");
        
        int op = sc.nextInt();
        String metodoElegido = (op == 1) ? EO3_Pago.EFECTIVO : (op == 2) ? EO3_Pago.TARJETA : "desconocido";

        // Creamos el objeto Pago
        EO3_Pago nuevoPago = new EO3_Pago(id, monto, metodoElegido);

        // Procesamos y guardamos
        if (nuevoPago.procesarPago()) {
            System.out.println(nuevoPago.generarRecibo());
            guardarEnArchivo(nuevoPago);
        } else {
            System.out.println("Error: No se pudo procesar el pago (Datos inválidos).");
        }
    }

    private void guardarEnArchivo(EO3_Pago p) {
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println(p.toString());
            System.out.println("Pago guardado exitosamente en: " + RUTA_ARCHIVO);
            
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de pagos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        EO3_GestionPago app = new EO3_GestionPago();
        app.registrarPago();
    }
}