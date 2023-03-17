package co.com.sofka.Banco.services.interfaces;

import co.com.sofka.Banco.model.Cliente;

import java.util.Optional;

public interface IClienteService {
    public interface ICliente {
        public Optional<Cliente> buscarClientePorId(Long id);
        public Cliente guardarCliente(Cliente cliente);
        public void eliminarCliente(Long id);
        public Optional<Cliente> modificarCliente(Cliente cliente, Long id);

    }
}
