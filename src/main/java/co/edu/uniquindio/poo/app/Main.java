package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog("Nombre del hotel:");
        String nit = JOptionPane.showInputDialog("NIT:");
        String direccion = JOptionPane.showInputDialog("Direccion:");
        String telefono = JOptionPane.showInputDialog("Telefono:");

        Hotel hotel = new Hotel(nombre, nit, direccion, telefono);

        String cantidadHuespedes = JOptionPane.showInputDialog(
                "Cantidad de huespedes:"
        );

        for (int i = 0; i < Integer.parseInt(cantidadHuespedes); i++) {

            String id = JOptionPane.showInputDialog("ID del huesped:");
            String nombreHuesped = JOptionPane.showInputDialog("Nombre:");
            String edad = JOptionPane.showInputDialog("Edad:");
            String telefonoHuesped = JOptionPane.showInputDialog("Telefono:");
            String ciudad = JOptionPane.showInputDialog("Ciudad:");

            Huesped huesped = new Huesped(
                    id,
                    nombreHuesped,
                    Integer.parseInt(edad),
                    telefonoHuesped,
                    ciudad
            );

            hotel.agregarHuesped(huesped);
        }

        String cantidadHabitaciones = JOptionPane.showInputDialog(
                "Cantidad de habitaciones:"
        );

        for (int i = 0; i < Integer.parseInt(cantidadHabitaciones); i++) {

            String numero = JOptionPane.showInputDialog(
                    "Numero de habitacion:"
            );

            String piso = JOptionPane.showInputDialog("Piso:");

            TipoHabitacion tipo = (TipoHabitacion) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de habitacion:",
                    "Tipo de habitacion",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    TipoHabitacion.values(),
                    TipoHabitacion.SENCILLA
            );

            String capacidad = JOptionPane.showInputDialog(
                    "Capacidad maxima:"
            );

            String precio = JOptionPane.showInputDialog(
                    "Precio por noche:"
            );

            EstadoHabitacion estado =
                    (EstadoHabitacion) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el estado:",
                            "Estado",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            EstadoHabitacion.values(),
                            EstadoHabitacion.DISPONIBLE
                    );

            Habitacion habitacion = new Habitacion(
                    Integer.parseInt(numero),
                    Integer.parseInt(piso),
                    tipo,
                    Integer.parseInt(capacidad),
                    Double.parseDouble(precio),
                    estado
            );

            hotel.agregarHabitacion(habitacion);
        }

        String cantidadReservas = JOptionPane.showInputDialog(
                "Cantidad de reservas:"
        );

        for (int i = 0; i < Integer.parseInt(cantidadReservas); i++) {

            String idReserva = JOptionPane.showInputDialog(
                    "ID de la reserva:"
            );

            String año = JOptionPane.showInputDialog("Año:");
            String mes = JOptionPane.showInputDialog("Mes:");
            String dia = JOptionPane.showInputDialog("Dia:");

            LocalDate fecha = LocalDate.of(
                    Integer.parseInt(año),
                    Integer.parseInt(mes),
                    Integer.parseInt(dia)
            );

            String noches = JOptionPane.showInputDialog(
                    "Numero de noches:"
            );

            String cantidadHuespedesReserva =
                    JOptionPane.showInputDialog(
                            "Cantidad de huespedes:"
                    );

            EstadoReserva estadoReserva =
                    (EstadoReserva) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el estado de la reserva:",
                            "Estado",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            EstadoReserva.values(),
                            EstadoReserva.PENDIENTE
                    );

            MetodoPago metodoPago =
                    (MetodoPago) JOptionPane.showInputDialog(
                            null,
                            "Seleccione el metodo de pago:",
                            "Metodo de pago",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            MetodoPago.values(),
                            MetodoPago.EFECTIVO
                    );

            Reserva reserva = new Reserva(
                    idReserva,
                    fecha,
                    Integer.parseInt(noches),
                    Integer.parseInt(cantidadHuespedesReserva),
                    estadoReserva,
                    metodoPago
            );

            String cantidadHabitacionesReserva =
                    JOptionPane.showInputDialog(
                            "Cantidad de habitaciones para la reserva:"
                    );

            for (int j = 0;
                 j < Integer.parseInt(cantidadHabitacionesReserva);
                 j++) {

                String numeroHabitacion =
                        JOptionPane.showInputDialog(
                                "Numero de habitacion:"
                        );

                Habitacion habitacion =
                        hotel.buscarHabitacion(
                                Integer.parseInt(numeroHabitacion)
                        );

                if (habitacion != null &&
                        habitacion.estaDisponible()) {

                    reserva.agregarHabitacion(habitacion);

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Habitacion no disponible"
                    );

                    j--;
                }
            }

            hotel.agregarReserva(reserva);
        }

        for (DiaSemana dia : DiaSemana.values()) {

            String ocupadas = JOptionPane.showInputDialog(
                    "Habitaciones ocupadas el " + dia + ":"
            );

            hotel.registrarOcupacion(
                    dia,
                    Integer.parseInt(ocupadas)
            );
        }

        String idBuscar = JOptionPane.showInputDialog(
                "ID del huesped que desea buscar:"
        );

        Huesped huesped = hotel.buscarHuesped(idBuscar);

        if (huesped != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Huesped encontrado\n" +
                            "Nombre: " + huesped.getNombreCompleto() +
                            "\nEdad: " + huesped.getEdad() +
                            "\nCiudad: " + huesped.getCiudadProcedencia()
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Huesped no encontrado"
            );
        }

        String numeroBuscar = JOptionPane.showInputDialog(
                "Numero de habitacion que desea buscar:"
        );

        Habitacion habitacion =
                hotel.buscarHabitacion(
                        Integer.parseInt(numeroBuscar)
                );

        if (habitacion != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Habitacion encontrada\n" +
                            "Numero: " + habitacion.getNumeroHabitacion() +
                            "\nTipo: " + habitacion.getTipoHabitacion() +
                            "\nEstado: " + habitacion.getEstadoHabitacion() +
                            "\nPrecio: $" + habitacion.getPrecioPorNoche()
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Habitacion no encontrada"
            );
        }

        int mayor = hotel.diaConMayorOcupacion();
        int menor = hotel.diaConMenorOcupacion();

        JOptionPane.showMessageDialog(
                null,
                "RESULTADOS\n\n" +
                        "Dia con mayor ocupacion: " +
                        DiaSemana.values()[mayor] +
                        "\nDia con menor ocupacion: " +
                        DiaSemana.values()[menor] +
                        "\nTotal de habitaciones ocupadas: " +
                        hotel.cantidadTotalHabitacionesOcupadasDuranteLaSemana() +
                        "\nIngresos totales: $" +
                        hotel.calcularIngresos()
        );
    }
}
```
