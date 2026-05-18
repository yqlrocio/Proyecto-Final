package p6_entorno_operativo;

	import java.util.Scanner;
	import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	
	public class EO2_GestionTrabajador {

	    private Scanner sc = new Scanner(System.in);
	    
	    private final String RUTA_ARCHIVO = "trabajadorGuardado.txt";

	    public void registrar() {
	        System.out.println("\n--- REGISTRO DEL PERSONAL ---");
	        System.out.print("ID del Trabajador: ");
	        int id = sc.nextInt();
	        sc.nextLine(); 

	        System.out.print("Nombre completo: ");
	        String nombre = sc.nextLine();

	        System.out.println("\n================================");
	        System.out.println("         Seleccione el Rol:       ");
	        System.out.println("================================");
	        System.out.println("1. Cocinero en Wok");
	        System.out.println("2. Cocinero en Sushi");
	        System.out.println("3. Camarero");
	        System.out.println("4. Repartidor");
	        System.out.print("Opción: ");
	        
	        int opcion = sc.nextInt();
	        String rolSeleccionado = switch(opcion) {
	            case 1 -> EO2_Trabajador.COCINERO_WOK;
	            case 2 -> EO2_Trabajador.COCINERO_SUSHI;
	            case 3 -> EO2_Trabajador.CAMARERO;
	            case 4 -> EO2_Trabajador.REPARTIDOR;
	            default -> "No definido";
	        };

	        // Creamos el objeto trabajador
	        EO2_Trabajador t = new EO2_Trabajador(id, nombre, rolSeleccionado);
	        
	        // Llamamos al método interno de guardar 
	        guardarEnArchivo(t);
	    }

	    private void guardarEnArchivo(EO2_Trabajador trabajador) {
	        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
	             BufferedWriter bw = new BufferedWriter(fw);
	             PrintWriter out = new PrintWriter(bw)) {
	            
	            out.println(trabajador.toString());
	            System.out.println("\n Guardado con éxito: " + trabajador.toString() + " guardado en " + RUTA_ARCHIVO);
	            
	        } catch (IOException e) {
	            System.err.println("Error al escribir en el archivo: " + e.getMessage());
	        }
	    }

	   
	    
	    public static void main(String[] args) {
	        EO2_GestionTrabajador app = new EO2_GestionTrabajador();
	        app.registrar();
	    }
	}