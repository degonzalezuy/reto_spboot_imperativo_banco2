package co.com.sofka.Banco.dto;

import co.com.sofka.Banco.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaDto {
    private Long idCuenta;
    private Long numero;
    private String tipoCuenta;
    private float saldo;
    private Boolean estado;
    private Cliente cliente;
}