package co.com.sofka.Banco.services.interfaces;


import co.com.sofka.Banco.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface IMovimientoService {
    public Optional<Movimiento> buscarMovimientoPorId(Long id);
    public Movimiento guardarMovimiento(Movimiento movimiento);
    public Movimiento eliminarMovimiento(Long id);
    public Movimiento modificarMovimiento(Movimiento movimiento, Long id);
    public List<Movimiento> buscarMovimientos();
}