package co.com.sofka.Banco.controller;


import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import co.com.sofka.Banco.services.interfaces.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

    @Autowired
    private ICuentaService service;

    @GetMapping
    public ResponseEntity<List<CuentaDto>> getCuentas(){
        return ResponseEntity.ok().body(service.buscarCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CuentaDto>>getClientePorId(@PathVariable(value="id") Long cuentaId) {
        Optional<CuentaDto> cuenta = service.buscarCuentaPorId(cuentaId);
        return ResponseEntity.ok().body(cuenta);
    }

    @PostMapping
    public ResponseEntity<Cuenta> guardarCuenta(@RequestBody Cuenta cuenta){
        System.out.println(cuenta);
        return ResponseEntity.ok().body(service.guardarCuenta(cuenta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Cuenta>> actualizarCuenta(@RequestBody Cuenta cuenta, @PathVariable Long id){
        Optional<Cuenta> cuenta1 = service.modificarCuenta(cuenta, id);

        return ResponseEntity.ok().body(cuenta1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id){
        service.eliminarCuenta(id);
        return ResponseEntity.ok().build();
    }

}