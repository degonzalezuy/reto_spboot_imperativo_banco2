package co.com.sofka.Banco.services.interfaces;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;

import java.util.Optional;

public interface ICuentaService {
    public Optional<Cuenta> buscarCuentaPorId(Long id);
    public Cuenta guardarCuenta(Cuenta cuenta);
    public Cuenta eliminarCuenta(Long id);
    public Cuenta modificarCuenta(Cuenta cuenta, Long id);
}
