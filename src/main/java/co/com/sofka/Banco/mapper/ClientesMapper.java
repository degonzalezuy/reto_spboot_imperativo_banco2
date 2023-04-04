package co.com.sofka.Banco.mapper;

import co.com.sofka.Banco.dto.ClienteDto;
import co.com.sofka.Banco.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClientesMapper {

    public static ClienteDto clienteToClienteDto(Cliente cliente){
        return ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .edad(cliente.getEdad())
                .estado(cliente.isEstado())
                .contrasena(cliente.getContrasena())
                .direccion(cliente.getDireccion())
                .genero(cliente.getGenero())
                .nombre(cliente.getNombre())
                .documento(cliente.getDocumento())
                .telefono(cliente.getTelefono())
                .build();
    }

    public static Cliente clienteDtoToCliente(ClienteDto clienteDto){
        return Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .edad(clienteDto.getEdad())
                .estado(clienteDto.isEstado())
                .contrasena(clienteDto.getContrasena())
                .direccion(clienteDto.getDireccion())
                .genero(clienteDto.getGenero())
                .nombre(clienteDto.getNombre())
                .documento(clienteDto.getDocumento())
                .telefono(clienteDto.getTelefono())
                .build();
    }

    public static List<Cliente> clientesDtoToClientes(List<ClienteDto> clienteDtos){
        return clienteDtos.stream()
                .map(ClientesMapper::clienteDtoToCliente)
                .collect(Collectors.toList());
    }

    public static List<ClienteDto> clientesToClientesDto(List<Cliente> clientes){
        return clientes.stream()
                .map(ClientesMapper::clienteToClienteDto)
                .collect(Collectors.toList());
    }
}
