package co.com.sofka.Banco.services;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.repository.ClienteRepository;
import co.com.sofka.Banco.repository.CuentaRepository;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import co.com.sofka.Banco.services.interfaces.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CuentaService implements ICuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;


    public List<Cuenta> buscarCuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> buscarCuentaPorId(Long id) {
        return cuentaRepository.findById(id);

    }
    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        //Cliente cliente = ClienteMapper.clienteDtoToCliente(clienteDto);
        //ClienteDto clienteDto1 = ClienteMapper.clienteToClientDto(clienteRepository.save(cliente));
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
        return null;
    }

    @Override
    public Cuenta modificarCuenta(Cuenta cuenta, Long id) {
        return null;
    }

}