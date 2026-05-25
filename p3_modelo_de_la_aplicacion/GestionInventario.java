package p3_modelo_de_la_aplicacion;

/**
 * Clase abstracta que gestiona el stock de ingredientes disponibles.
 * Base para todos los elementos del modelo que requieran materias primas.
 * * @author TuNombre
 * @version 1.0
 */
public abstract class GestionInventario {
    /** Cantidad disponible de ingredientes en stock de forma protegida. */
    protected int stockIngredientes;

    /**
     * Constructor para inicializar el stock del inventario.
     * @param stockIngredientes Cantidad inicial de ingredientes.
     */
    public GestionInventario(int stockIngredientes) {
        this.stockIngredientes = stockIngredientes;
    }

    /**
     * Consulta el nivel de stock actual.
     * @return Cantidad de ingredientes.
     */
    public int consultarStock() {
        return this.stockIngredientes;
    }

    /**
     * Método abstracto para actualizar el stock según las necesidades de la receta o producto.
     */
    public abstract void actualizarStock();

    /**
     * Comprueba si el stock es apto para usarse.
     * @return true si es mayor que cero, false en caso contrario.
     */
    public boolean hayIngredientes() {
        return this.stockIngredientes > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GestionInventario other = (GestionInventario) obj;
        return this.stockIngredientes == other.stockIngredientes;
    }

    @Override
    public String toString() {
        return "Inventario: [Stock = " + stockIngredientes + "]";
    }