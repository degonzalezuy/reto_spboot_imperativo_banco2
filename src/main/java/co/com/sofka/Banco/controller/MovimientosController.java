package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.dto.MovimientoDto;
import co.com.sofka.Banco.model.Cuenta;

import co.com.sofka.Banco.model.Movimiento;
import co.com.sofka.Banco.services.MovimientoService;
import co.com.sofka.Banco.services.interfaces.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private IMovimientoService service;

    @GetMapping
    public ResponseEntity<List<MovimientoDto>> getMovimientos(){
        return ResponseEntity.ok().body(service.buscarMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovimientoDto>>getMovimientoPorId(@PathVariable(value="id") Long movimientoId) {
        Optional<MovimientoDto> movimiento = service.buscarMovimientoPorId(movimientoId);
        return ResponseEntity.ok().body(movimiento);
    }

    @PostMapping
    public ResponseEntity<MovimientoDto> guardarMovimiento(@RequestBody MovimientoDto movimientoDto)throws Exception{
        if(movimientoDto.getValor()==0){
               new Exception("No se puede registrar un movimiento con importe cero");
        }
        return ResponseEntity.ok().body(service.guardarMovimiento(movimientoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<MovimientoDto>> actualizarMovimiento(@RequestBody Movimiento movimientoD
            , @PathVariable Long id){
        Optional<MovimientoDto> movimiento1 = service.modificarMovimiento(MovimientoDto.builder().build(), id);

        return ResponseEntity.ok().body(movimiento1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimiento(@PathVariable Long id){
        Movimiento movimiento1 = service.eliminarMovimiento(id);

        return ResponseEntity.ok().body("Movimiento eliminada");
    }

}