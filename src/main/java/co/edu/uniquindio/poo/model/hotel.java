package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;

    private List<Huesped> listaHuespedes;
    private List<Habitacion> listaHabitaciones;
    private List<Reserva> listaReservas;

    public Hotel(String nombreComercial,
                 String nit,
                 String direccion,
                 String telefono) {

        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        this.listaHuespedes = new ArrayList<>();
        this.listaHabitaciones = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void agregarHuesped(Huesped huesped) {
        if (huesped != null) {
            listaHuespedes.add(huesped);
        }
    }

    public void agregarHabitacion(Habitacion habitacion) {
        if (habitacion != null) {
            listaHabitaciones.add(habitacion);
        }
    }

    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            listaReservas.add(reserva);
        }
    }

    public Huesped buscarHuesped(String id) {

        for (Huesped huesped : listaHuespedes) {
            if (huesped.getId().equals(id)) {
                return huesped;
            }
        }

        return null;
    }

    public Habitacion buscarHabitacion(int numero) {

        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.getNumeroHabitacion() == numero) {
                return habitacion;
            }
        }

        return null;
    }

    public List<Habitacion> consultarHabitacionesDisponibles() {

        List<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.estaDisponible()) {
                disponibles.add(habitacion);
            }
        }

        return disponibles;
    }

    public double calcularIngresos() {

        double ingresos = 0;

        for (Reserva reserva : listaReservas) {

            if (reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA ||
                    reserva.getEstadoReserva() == EstadoReserva.FINALIZADA) {

                ingresos += reserva.getValorTotal();
            }
        }

        return ingresos;
    }
}