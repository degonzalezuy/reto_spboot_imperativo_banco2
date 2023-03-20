package co.com.sofka.Banco.model;

import jakarta.persistence.*;

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private int edad;
    private int documento;
    private String direccion;
    private String telefono;
    private String contrasena;
    private boolean estado;
    private String genero;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, int edad, int documento, String direccion, String telefono, String contrasena, boolean estado, String genero) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.estado = estado;
        this.genero = genero;
    }
    public Cliente( String nombre, int edad, int documento, String direccion, String telefono, String contrasena, boolean estado, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.estado = estado;
        this.genero = genero;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    public boolean isEstado() {
        return estado;
    }
}
