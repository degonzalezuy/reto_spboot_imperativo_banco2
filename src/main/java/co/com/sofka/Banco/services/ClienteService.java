package co.com.sofka.Banco.services;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.repository.ClienteRepository;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
        clienteRepository.deleteById(id);
        return null;
    }

    @Override
    public Cliente modificarCliente(Cliente cliente, Long id) {
        return null;
    }
}
