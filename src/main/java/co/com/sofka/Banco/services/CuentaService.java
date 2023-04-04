package co.com.sofka.Banco.services;


import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.mapper.CuentasMapper;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.repository.CuentaRepository;
import co.com.sofka.Banco.services.interfaces.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CuentaService implements ICuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;


    @Override
    public List<CuentaDto> buscarCuentas() {
        return CuentasMapper.cuentasToCuentasDto(cuentaRepository.findAll());
    }

    public Optional<CuentaDto> buscarCuentaPorId(Long id) {
        return  cuentaRepository.findById(id).map(CuentasMapper::cuentaToCuentaDto);

    }
    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        //Cliente cliente = ClienteMapper.clienteDtoToCliente(clienteDto);
        //ClienteDto clienteDto1 = ClienteMapper.clienteToClientDto(clienteRepository.save(cliente));
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public Optional<Cuenta> modificarCuenta(Cuenta cuenta, Long id) {
        return cuentaRepository.findById(id).map(cuenta1 -> {
            cuenta1.setNumero(cuenta.getNumero());
            cuenta1.setSaldo(cuenta.getSaldo());
            cuenta1.setTipoCuenta(cuenta.getTipoCuenta());
            cuenta1.setEstado(cuenta.getEstado());
            cuenta1.setCliente(cuenta.getCliente());

            return cuentaRepository.save(cuenta1);
        });

    }

}