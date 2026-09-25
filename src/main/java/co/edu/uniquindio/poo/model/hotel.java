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

    private int[] ocupacionSemanal;

    public Hotel(String nombreComercial,
                 String nit,
                 String direccion,
                 String telefono) {

        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        listaHuespedes = new ArrayList<>();
        listaHabitaciones = new ArrayList<>();
        listaReservas = new ArrayList<>();

        ocupacionSemanal = new int[7];
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

    public void registrarOcupacion(DiaSemana dia, int cantidad) {

        ocupacionSemanal[dia.ordinal()] = cantidad;
    }

    public int diaConMayorOcupacion() {

        int mayor = ocupacionSemanal[0];
        int dia = 0;

        for (int i = 1; i < ocupacionSemanal.length; i++) {

            if (ocupacionSemanal[i] > mayor) {
                mayor = ocupacionSemanal[i];
                dia = i;
            }
        }

        return dia;
    }

    public int diaConMenorOcupacion() {

        int menor = ocupacionSemanal[0];
        int dia = 0;

        for (int i = 1; i < ocupacionSemanal.length; i++) {

            if (ocupacionSemanal[i] < menor) {
                menor = ocupacionSemanal[i];
                dia = i;
            }
        }

        return dia;
    }

    public int cantidadTotalHabitacionesOcupadasDuranteLaSemana() {

        int total = 0;

        for (int cantidad : ocupacionSemanal) {
            total += cantidad;
        }

        return total;
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

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
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
}