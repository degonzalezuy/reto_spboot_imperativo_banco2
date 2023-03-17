package co.com.sofka.Banco.model;

import jakarta.persistence.*;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    private Long numero;
    private String tipoCuenta;
    private float saldo;
    private Boolean estado;
    @OneToOne
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(Long idCuenta, Long numero, String tipoCuenta, float saldo, Boolean estado, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.numero = numero;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;

        this.cliente = cliente;
    }

    public Long getId() {
        return idCuenta;
    }

    public void setId(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}