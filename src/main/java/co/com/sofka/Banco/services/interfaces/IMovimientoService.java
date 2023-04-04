package co.com.sofka.Banco.services.interfaces;


import co.com.sofka.Banco.dto.MovimientoDto;
import co.com.sofka.Banco.model.Movimiento;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IMovimientoService {
    public List<MovimientoDto> buscarMovimientos();
    public Optional<MovimientoDto> buscarMovimientoPorId(Long id);
    public MovimientoDto guardarMovimiento(MovimientoDto movimientoDto);
    public Movimiento eliminarMovimiento(Long id);
    public Optional<MovimientoDto> modificarMovimiento(MovimientoDto movimientoDto, Long id);

}