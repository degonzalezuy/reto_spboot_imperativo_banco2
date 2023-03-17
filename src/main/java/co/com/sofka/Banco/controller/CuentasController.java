package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.services.ClienteService;
import co.com.sofka.Banco.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentasController {

    @Autowired
    private CuentaService service;

    @GetMapping
    public ResponseEntity<List<Cuenta>> getCuentas(){
        return ResponseEntity.ok().body(service.buscarCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cuenta>>getClientePorId(@PathVariable(value="id") Long cuentaId) {
        Optional<Cuenta> cuenta = service.buscarCuentaPorId(cuentaId);
        return ResponseEntity.ok().body(cuenta);
    }

    @PostMapping
    public ResponseEntity<Cuenta> guardarCuenta(@RequestBody Cuenta cuenta){
        System.out.println(cuenta);
        return ResponseEntity.ok().body(service.guardarCuenta(cuenta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@RequestBody Cuenta cuenta, @PathVariable Long id){
        Cuenta cuenta1 = service.modificarCuenta(cuenta, id);

        return ResponseEntity.ok().body(cuenta1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable Long id){
        Cuenta cuenta1 = service.eliminarCuenta(id);

        return ResponseEntity.ok().body("Cuenta eliminada");
    }

}