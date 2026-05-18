package p6_entorno_operativo;

public class EO2_Trabajador {
    private int idTrabajador;
    private String nombreTrabajador;
    private String rol;

    // Roles permitidos
    public static final String COCINERO_WOK = "cocinero en wok";
    public static final String COCINERO_SUSHI = "cocinero en sushi";
    public static final String CAMARERO = "camarero";
    public static final String REPARTIDOR = "repartidor";

    public EO2_Trabajador(int idTrabajador, String nombre, String rol) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.rol = rol;
    }

    public void gestionarPedido() {
        switch (this.rol) {
            case CAMARERO -> System.out.println(nombre + " (Camarero) está tomandote nota.");
            case REPARTIDOR -> System.out.println(nombre + " (Repartidor) organizará la ruta de entrega.");
            default -> System.out.println(nombre + " está coordinando el pedido en cocina.");
        }
    }

    public void prepararPedido() {
        if (this.rol.equals(COCINERO_WOK)) {
            System.out.println(nombre + " está preparando tu comida china.");
        } else if (this.rol.equals(COCINERO_SUSHI)) {
            System.out.println(nombre + " está preparando tu sushi.");
        } else {
            System.out.println(nombre + " (Rol: " + rol + ") no prepara comida directamente.");
        }
    }

    public void entregarPedido() {
        if (this.rol.equals(REPARTIDOR)) {
            System.out.println(nombre + " ha salido en la moto a entregar.");
        } else if (this.rol.equals(CAMARERO)) {
            System.out.println(nombre + " lleva los platos a la mesa.");
        } else {
            System.out.println(nombre + " está coordinando el pedido en barra.");
        }
    }

    @Override
    public String toString() {
        return idTrabajador + "," + nombre + "," + rol;
    }
}