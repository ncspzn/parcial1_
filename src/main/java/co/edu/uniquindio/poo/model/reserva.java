package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class reserva {

    private String idReserva;
    private LocalDate fechaReserva;
    private int numeroNoches;
    private int cantidadHuespedes;
    private EstadoReserva estadoReserva;
    private MetodoPago metodoPago;
    private double valorTotal;
    private List<Habitacion> listaHabitaciones;

    public Reserva(String idReserva,
                   LocalDate fechaReserva,
                   int numeroNoches,
                   int cantidadHuespedes,
                   EstadoReserva estadoReserva,
                   MetodoPago metodoPago) {

        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.numeroNoches = numeroNoches;
        this.cantidadHuespedes = cantidadHuespedes;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.valorTotal = 0;
        this.listaHabitaciones = new ArrayList<>();
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public int getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(int cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (habitacion != null && habitacion.estaDisponible()) {
            listaHabitaciones.add(habitacion);
            habitacion.ocupar();
            calcularValorTotal();
        }
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        if (listaHabitaciones.remove(habitacion)) {
            habitacion.liberar();
            calcularValorTotal();
        }
    }

    public void calcularValorTotal() {
        valorTotal = 0;

        for (Habitacion habitacion : listaHabitaciones) {
            valorTotal += habitacion.getPrecioPorNoche() * numeroNoches;
        }
    }
}