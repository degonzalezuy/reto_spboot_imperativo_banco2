package co.com.sofka.Banco.services;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.repository.ClienteRepository;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService.ICliente {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> buscarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Long id){
        return clienteRepository.findById(id);

    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        //Cliente cliente = ClienteMapper.clienteDtoToCliente(clienteDto);
        //ClienteDto clienteDto1 = ClienteMapper.clienteToClientDto(clienteRepository.save(cliente));
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente eliminarCliente(Long id) {
        Optional<Cliente> cliente = this.buscarClientePorId(id);
        clienteRepository.delete(cliente.get());
        return cliente.get();
    }

    @Override
    public Optional<Cliente> modificarCliente(Cliente cliente, Long id) {
        return clienteRepository.findById(id).map(cliente1 -> {
            cliente1.setEstado(cliente.getEstado());
            cliente1.setContrasena(cliente.getContrasena());
            cliente1.setEdad(cliente.getEdad());
            cliente1.setDireccion(cliente.getDireccion());
            cliente1.setDocumento(cliente.getDocumento());
            cliente1.setGenero(cliente.getGenero());
            cliente1.setTelefono(cliente.getTelefono());
            cliente1.setNombre(cliente.getNombre());

            return clienteRepository.save(cliente1);
        });
    }
}
