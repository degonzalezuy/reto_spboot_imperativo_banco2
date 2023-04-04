package co.com.sofka.Banco.services;

import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.dto.MovimientoDto;
import co.com.sofka.Banco.mapper.MovimientosMapper;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.model.Movimiento;
import co.com.sofka.Banco.repository.MovimientoRepository;
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

    public List<MovimientoDto> buscarMovimientos() {
        return MovimientosMapper.movimientosToMovimientosDto( movimientoRepository.findAll());
    }

    public Optional<MovimientoDto> buscarMovimientoPorId(Long id) {
        return movimientoRepository.findById(id).map(MovimientosMapper::movimientoToMovimientoDto);

    }
    @Override
    public MovimientoDto guardarMovimiento(MovimientoDto movimientoDto) {
        //float saldo = getSaldoCuenta(movimiento.getCuenta().getId());
        Optional<CuentaDto> cuenta = cuentaService.buscarCuentaPorId(movimientoDto.getCuenta().getIdCuenta());
        float saldo = cuenta.get().getSaldo();

        if(movimientoDto.getValor()>0){
          saldo = sumarMovimiento(saldo, movimientoDto.getValor());
        }else{
            saldo = restarMovimiento(saldo, movimientoDto.getValor());
        }
        movimientoDto.setSaldo(saldo);
        Cuenta cuentaActualizada = new Cuenta();
        cuentaActualizada.setIdCuenta(cuenta.get().getIdCuenta());
        cuentaActualizada.setNumero(cuenta.get().getNumero());
        cuentaActualizada.setSaldo(saldo);
        cuentaActualizada.setTipoCuenta(cuenta.get().getTipoCuenta());
        cuentaActualizada.setEstado(cuenta.get().getEstado());
        cuentaActualizada.setCliente(cuenta.get().getCliente());

        cuentaService.modificarCuenta(cuentaActualizada, cuentaActualizada.getIdCuenta());
        return MovimientosMapper.movimientoToMovimientoDto(movimientoRepository.save(MovimientosMapper.movimientoDtoToMovimiento(movimientoDto)));
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
    public Optional<MovimientoDto> modificarMovimiento(MovimientoDto movimientoDto, Long id)
    {
        return movimientoRepository.findById(id).map(movimiento1 -> {
            movimiento1.setTipoMovimiento(movimientoDto.getTipoMovimiento());
            movimiento1.setSaldo(movimientoDto.getSaldo());
            movimiento1.setCuenta(movimientoDto.getCuenta());
            movimiento1.setFecha(movimientoDto.getFecha());
            movimiento1.setValor(movimientoDto.getValor());


            return MovimientosMapper.movimientoToMovimientoDto(movimientoRepository.save(movimiento1));
        });

    }

}