package p6_entorno_operativo;

public class EO3_Pago {
	
    private int idPago;
    private double cuenta;
    private String metodo;

    // Constantes para los métodos permitidos
    public static final String EFECTIVO = "efectivo";
    public static final String TARJETA = "tarjeta";

    public EO3_Pago(int idPago, double cuenta, String metodo) {
        this.idPago = idPago;
        this.cuenta = cuenta;
        this.metodo = metodo;
    }

    // Lógica para validar que el pago sea correcto
    public boolean validarPago() {
        return (metodo.equals(EFECTIVO) || metodo.equals(TARJETA)) && cuenta > 0;
    }

    public boolean procesarPago() {
        if (validarPago()) {
            System.out.println("Procesando pago de " + cuenta + "€" + " || vía " + metodo + "...");
            return true;
        }
        return false;
    }

    public String generarRecibo() {
        return "---------- RECIBO ----------\n" +
               "ID Transacción: " + idPago + "\n" +
               "Total Pagado: " + cuenta + "€" + "\n" +
               "Método: " + metodo.toUpperCase() + "\n" + // mostrar en mayúscula el método de pago
               "----------------------------";
    }

    @Override
    public String toString() {
        return idPago + "," + cuenta + "," + metodo;
    }
}