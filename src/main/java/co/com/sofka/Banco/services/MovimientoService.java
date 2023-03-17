package co.com.sofka.Banco.services;

import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.model.Movimiento;
import co.com.sofka.Banco.repository.CuentaRepository;
import co.com.sofka.Banco.repository.MovimientoRepository;
import co.com.sofka.Banco.services.interfaces.ICuentaService;
import co.com.sofka.Banco.services.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MovimientoService implements IMovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaService cuentaService;

    public List<Movimiento> buscarMovimientos() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> buscarMovimientoPorId(Long id) {
        return movimientoRepository.findById(id);

    }
    @Override
    public Movimiento guardarMovimiento(Movimiento movimiento) {
        //float saldo = getSaldoCuenta(movimiento.getCuenta().getId());
        Optional<Cuenta> cuenta = cuentaService.buscarCuentaPorId(movimiento.getCuenta().getId());
        float saldo = cuenta.get().getSaldo();

        if(movimiento.getValor()>0){
          saldo = sumarMovimiento(saldo, movimiento.getValor());
        }else{
            saldo = restarMovimiento(saldo, movimiento.getValor());
        }
        movimiento.setSaldo(saldo);
        Cuenta cuentaActualizada = new Cuenta();
        cuentaActualizada.setId(cuenta.get().getId());
        cuentaActualizada.setNumero(cuenta.get().getNumero());
        cuentaActualizada.setSaldo(saldo);
        cuentaActualizada.setTipoCuenta(cuenta.get().getTipoCuenta());
        cuentaActualizada.setEstado(cuenta.get().getEstado());
        cuentaActualizada.setCliente(cuenta.get().getCliente());

        cuentaService.modificarCuenta(cuentaActualizada, cuentaActualizada.getId());
        return movimientoRepository.save(movimiento);
    }

    private float sumarMovimiento(float saldo, float valor){
        return saldo + valor;
    }

    private float restarMovimiento(float saldo, float valor){
        return saldo - valor;
    }

    @Override
    public Movimiento eliminarMovimiento(Long id) {
        movimientoRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Movimiento> modificarMovimiento(Movimiento movimiento, Long id)
    {
        return movimientoRepository.findById(id).map(movimiento1 -> {
            movimiento1.setTipoMovimiento(movimiento.getTipoMovimiento());
            movimiento1.setSaldo(movimiento.getSaldo());
            movimiento1.setCuenta(movimiento.getCuenta());
            movimiento1.setFecha(movimiento.getFecha());
            movimiento1.setValor(movimiento.getValor());


            return movimientoRepository.save(movimiento1);
        });

    }

}