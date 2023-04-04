package co.com.sofka.Banco.mapper;

import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.model.Cuenta;

import java.util.List;
import java.util.stream.Collectors;

public class CuentasMapper {

    public static Cuenta cuentaDtoToCuenta(CuentaDto cuentaDto){
        return Cuenta.builder()
                .idCuenta(cuentaDto.getIdCuenta())
                .tipoCuenta(cuentaDto.getTipoCuenta())
                .saldo(cuentaDto.getSaldo())
                .numero(cuentaDto.getNumero())
                .estado(cuentaDto.getEstado())
                .build();
    }

    public static CuentaDto cuentaToCuentaDto(Cuenta cuenta){
        return CuentaDto.builder()
                .idCuenta(cuenta.getIdCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldo(cuenta.getSaldo())
                .numero(cuenta.getNumero())
                .estado(cuenta.getEstado())
                .build();
    }

    public static List<CuentaDto> cuentasToCuentasDto(List<Cuenta> cuentas){
        return cuentas.stream()
                .map(CuentasMapper::cuentaToCuentaDto)
                .collect(Collectors.toList());
    }

    public static List<Cuenta> cuentaDtoToCuentas(List<CuentaDto> cuentasDto){
        return cuentasDto.stream()
                .map(CuentasMapper::cuentaDtoToCuenta)
                .collect(Collectors.toList());
    }
}
