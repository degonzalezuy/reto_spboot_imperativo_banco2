package co.com.sofka.Banco.dto;

import co.com.sofka.Banco.model.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoDto {

    private Long idMovimiento;
    private Date fecha;
    private String tipoMovimiento;
    private float valor;
    private float saldo;
    @ManyToOne
    private Cuenta cuenta;
}