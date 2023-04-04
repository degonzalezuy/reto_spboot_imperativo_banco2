 package co.com.sofka.Banco.mapper;

import co.com.sofka.Banco.dto.MovimientoDto;
import co.com.sofka.Banco.model.Movimiento;

import java.util.List;
import java.util.stream.Collectors;

 public class MovimientosMapper {

    public static Movimiento movimientoDtoToMovimiento(MovimientoDto movimientoDto){
        return Movimiento.builder()
                .idMovimiento(movimientoDto.getIdMovimiento())
                .fecha(movimientoDto.getFecha())
                .tipoMovimiento(movimientoDto.getTipoMovimiento())
                .saldo(movimientoDto.getSaldo())
                .valor(movimientoDto.getValor())
                .build();
    }

    public static MovimientoDto movimientoToMovimientoDto(Movimiento movimiento){
        return MovimientoDto.builder()
                .idMovimiento(movimiento.getIdMovimiento())
                .fecha(movimiento.getFecha())
                .tipoMovimiento(movimiento.getTipoMovimiento())
                .saldo(movimiento.getSaldo())
                .valor(movimiento.getValor())
                .build();
    }

    public static List<Movimiento> movimientosDtoToMovimientos(List<MovimientoDto> movimientosDtos ){
        return movimientosDtos.stream()
                .map(MovimientosMapper::movimientoDtoToMovimiento)
                .collect(Collectors.toList());
    }
     public static List<MovimientoDto> movimientosToMovimientosDto(List<Movimiento> movimientos ){
         return movimientos.stream()
                 .map(MovimientosMapper::movimientoToMovimientoDto)
                 .collect(Collectors.toList());
     }
}
