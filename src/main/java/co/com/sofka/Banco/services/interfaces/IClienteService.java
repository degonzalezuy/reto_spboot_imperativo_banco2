package co.com.sofka.Banco.services.interfaces;

import co.com.sofka.Banco.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

        public List<ClienteDto> buscarClientes();
        public Optional<ClienteDto> buscarClientePorId(Long id);
        public ClienteDto guardarCliente(ClienteDto clienteDto);
        public void eliminarCliente(Long id);
        public Optional<ClienteDto> modificarCliente(ClienteDto clienteDto, Long id);

}
