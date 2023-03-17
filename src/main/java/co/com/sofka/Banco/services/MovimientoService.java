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


    public List<Movimiento> buscarMovimientos() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> buscarMovimientoPorId(Long id) {
        return movimientoRepository.findById(id);

    }
    @Override
    public Movimiento guardarMovimiento(Movimiento movimiento) {
        float saldo = getSaldoCuenta(movimiento.getCuenta().getId());
        if(movimiento.getValor()>0){
          saldo = sumarMovimiento(saldo, movimiento.getValor());
        }else{
            saldo = restarMovimiento(saldo, movimiento.getValor());
        }
        movimiento.setSaldo(saldo);
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
    public Movimiento modificarMovimiento(Movimiento movimiento, Long id) {
        return null;
    }

    @Autowired
    private CuentaService cuentaService;
    public float getSaldoCuenta(Long idCuenta){
        Optional<Cuenta> cuenta = cuentaService.buscarCuentaPorId(idCuenta);
        return cuenta.get().getSaldo();
    }
}