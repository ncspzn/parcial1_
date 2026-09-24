package co.edu.uniquindio.poo.model;


public class habitacion {

    private int numeroHabitacion;
    private int piso;
    private TipoHabitacion tipoHabitacion;
    private int capacidadMaxima;
    private double precioPorNoche;
    private EstadoHabitacion estadoHabitacion;

    public Habitacion(int numeroHabitacion, int piso,
                      TipoHabitacion tipoHabitacion,
                      int capacidadMaxima,
                      double precioPorNoche,
                      EstadoHabitacion estadoHabitacion) {

        this.numeroHabitacion = numeroHabitacion;
        this.piso = piso;
        this.tipoHabitacion = tipoHabitacion;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.estadoHabitacion = estadoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public boolean estaDisponible() {
        return estadoHabitacion == EstadoHabitacion.DISPONIBLE;
    }

    public void ocupar() {
        estadoHabitacion = EstadoHabitacion.OCUPADA;
    }

    public void liberar() {
        estadoHabitacion = EstadoHabitacion.DISPONIBLE;
    }
}
