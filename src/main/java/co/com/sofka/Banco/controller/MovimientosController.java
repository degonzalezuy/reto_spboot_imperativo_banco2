package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cuenta;

import co.com.sofka.Banco.model.Movimiento;
import co.com.sofka.Banco.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

    @Autowired
    private MovimientoService service;

    @GetMapping
    public ResponseEntity<List<Movimiento>> getMovimientos(){
        return ResponseEntity.ok().body(service.buscarMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>>getMovimientoPorId(@PathVariable(value="id") Long movimientoId) {
        Optional<Movimiento> movimiento = service.buscarMovimientoPorId(movimientoId);
        return ResponseEntity.ok().body(movimiento);
    }

    @PostMapping
    public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody Movimiento movimiento)throws Exception{
        if(movimiento.getValor()==0){
               new Exception("No se puede registrar un movimiento con importe cero");
        }
        return ResponseEntity.ok().body(service.guardarMovimiento(movimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Movimiento>> actualizarMovimiento(@RequestBody Movimiento movimiento, @PathVariable Long id){
        Optional<Movimiento> movimiento1 = service.modificarMovimiento(movimiento, id);

        return ResponseEntity.ok().body(movimiento1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMovimiento(@PathVariable Long id){
        Movimiento movimiento1 = service.eliminarMovimiento(id);

        return ResponseEntity.ok().body("Movimiento eliminada");
    }

}