package co.com.sofka.Banco.services.interfaces;

import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ICuentaService {
    public List<CuentaDto> buscarCuentas();
    public Optional<CuentaDto> buscarCuentaPorId(Long id);
    public Cuenta guardarCuenta(Cuenta cuenta);
    public void eliminarCuenta(Long id);
    public Optional<Cuenta> modificarCuenta(Cuenta cuenta, Long id);
}
