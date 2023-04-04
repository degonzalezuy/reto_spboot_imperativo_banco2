package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.dto.ClienteDto;
import co.com.sofka.Banco.model.Cliente;

import co.com.sofka.Banco.services.ClienteService;

import co.com.sofka.Banco.services.interfaces.IClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;


import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@SpringBootTest

class ClientesControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    IClienteService service;

    ClienteDto cliente1=new ClienteDto(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");
    ClienteDto cliente2=new ClienteDto(2L, "Diego2", 34, 12345678, "Bulevar1234", "+54 234245","hola", true, "M");
    ClienteDto cliente3=new ClienteDto(3L, "Diego3", 34, 12345678, "Av salto 345345", "+598 6456456" ,"hola", true, "M");
    @Test
    void getClientes() throws Exception {
        List<ClienteDto> clientes = new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));
        Mockito.when(service.buscarClientes()).thenReturn(clientes);

        mockMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    void getClientePorId() throws Exception{
        Mockito.when(service.buscarClientePorId(cliente1.getIdCliente())).thenReturn(Optional.of(cliente1));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void guardarCliente() throws Exception{
        ClienteDto clienteDto=new ClienteDto(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");

        Mockito.when(service.guardarCliente(clienteDto)).thenReturn(clienteDto);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(clienteDto));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

    }

    @Test
    void actualizarCliente() throws Exception {
        ClienteDto clienteUpdated=new ClienteDto( 1L,"Pepe", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");

        Mockito.when(service.buscarClientePorId(cliente1.getIdCliente())).thenReturn(Optional.of(cliente1));
        Mockito.when(service.modificarCliente(cliente1, cliente1.getIdCliente())).thenReturn(Optional.of(clienteUpdated));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(this.mapper.writeValueAsString(clienteUpdated));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

    }

   /* @Test
    void eliminarCliente() throws Exception{
        Mockito.when(service.eliminarCliente(cliente2.getIdCliente())).thenReturn(nullValue());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/clientes/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/
}