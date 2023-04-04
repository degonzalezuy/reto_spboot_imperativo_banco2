package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.dto.ClienteDto;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private IClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getClientes(){
        return ResponseEntity.ok().body(service.buscarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteDto>>getClientePorId(@PathVariable(value="id") Long clienteId) {
        Optional<ClienteDto> clienteDto = service.buscarClientePorId(clienteId);
        return ResponseEntity.ok().body(clienteDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> guardarCliente(@RequestBody ClienteDto clienteDto){

        return ResponseEntity.ok().body(service.guardarCliente(clienteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<ClienteDto>> actualizarCliente(@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        Optional<ClienteDto> cliente1 = service.modificarCliente(clienteDto, id);

        return ResponseEntity.ok().body(cliente1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id){
       service.eliminarCliente(id);
       return ResponseEntity.ok().build();
    }
}