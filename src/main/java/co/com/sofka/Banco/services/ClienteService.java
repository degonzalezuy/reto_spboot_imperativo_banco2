package co.com.sofka.Banco.services;

import co.com.sofka.Banco.dto.ClienteDto;
import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.repository.ClienteRepository;
import co.com.sofka.Banco.services.interfaces.IClienteService;
import co.com.sofka.Banco.mapper.ClientesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<ClienteDto> buscarClientes(){
        return ClientesMapper.clientesToClientesDto(clienteRepository.findAll());
    }

    public Optional<ClienteDto> buscarClientePorId(Long id){
        return clienteRepository.findById(id).map(ClientesMapper::clienteToClienteDto);

    }

    @Override
    public ClienteDto guardarCliente(ClienteDto clienteDto) {
        //Cliente cliente = ClienteMapper.clienteDtoToCliente(clienteDto);
        //ClienteDto clienteDto1 = ClienteMapper.clienteToClientDto(clienteRepository.save(cliente));
        Cliente cliente = ClientesMapper.clienteDtoToCliente(clienteDto);
        return ClientesMapper.clienteToClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public void eliminarCliente(Long id){
             clienteRepository.deleteById(id);
    }


    @Override
    public Optional<ClienteDto> modificarCliente(ClienteDto clienteDto, Long id) {
        return clienteRepository.findById(id).map(cliente1 -> {
            cliente1.setEstado(clienteDto.isEstado());
            cliente1.setContrasena(clienteDto.getContrasena());
            cliente1.setEdad(clienteDto.getEdad());
            cliente1.setDireccion(clienteDto.getDireccion());
            cliente1.setDocumento(clienteDto.getDocumento());
            cliente1.setGenero(clienteDto.getGenero());
            cliente1.setTelefono(clienteDto.getTelefono());
            cliente1.setNombre(clienteDto.getNombre());

            return ClientesMapper.clienteToClienteDto(clienteRepository.save(cliente1));
        });
    }
}
