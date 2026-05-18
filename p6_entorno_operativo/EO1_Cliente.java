package p6_entorno_operativo;

	public class EO1_Cliente {
	   
		// Atributos privados 
	    private int idCliente;
	    private String nombreCliente;
	    private String telefono;
	    private String direccion;

	    // Constructor
	    public EO1_Cliente(int idCliente, String nombre, String telefono, String direccion) {
	        this.idCliente = idCliente;
	        this.nombreCliente = nombreCliente;
	        this.telefono = telefono;
	        this.direccion = direccion;
	    }

	    // Métodos del UML
	    public void realizarPedido() {
	        System.out.println("El cliente " + nombreCliente + " está realizando un pedido.");
	    }

	    public void consultarPedidos() {
	        System.out.println("Consultando pedidos para el cliente ID: " + idCliente);
	    }

	    @Override
	    public String toString() {
	        return "ID: " + idCliente + " | Nombre: " + nombreCliente + " | Tel: " + telefono + " | Dir: " + direccion;
	    }

	    // Getters necesarios para guardar los datos
	    public int getIdCliente() { 
	    	return idCliente; 
	    	}
	    public String getNombreCliente() { 
	    	return nombreCliente; 
	    	}
	    public String getTelefono() { 
	    	return telefono; 
	    	}
	    public String getDireccion() { 
	    	return direccion; 
	    	}
	}
