package co.edu.uniquindio.poo.model;

public class Huesped {

    private String id;
    private String nombreCompleto;
    private int edad;
    private String telefono;
    private String ciudadProcedencia;

    public Huesped(String id, String nombreCompleto,
                   int edad, String telefono,
                   String ciudadProcedencia) {

        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudadProcedencia = ciudadProcedencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudadProcedencia() {
        return ciudadProcedencia;
    }

    public void setCiudadProcedencia(String ciudadProcedencia) {
        this.ciudadProcedencia = ciudadProcedencia;
    }
}
