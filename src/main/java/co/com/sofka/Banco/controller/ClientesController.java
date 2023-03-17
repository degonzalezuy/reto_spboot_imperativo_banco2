package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        return ResponseEntity.ok().body(service.buscarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>>getClientePorId(@PathVariable(value="id") Long clienteId) {
        Optional<Cliente> cliente = service.buscarClientePorId(clienteId);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){

        return ResponseEntity.ok().body(service.guardarCliente(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente cliente1 = service.modificarCliente(cliente, id);

        return ResponseEntity.ok().body(cliente1);
    }
}