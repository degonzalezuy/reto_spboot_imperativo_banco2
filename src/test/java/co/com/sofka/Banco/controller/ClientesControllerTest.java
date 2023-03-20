package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.repository.ClienteRepository;
import co.com.sofka.Banco.services.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
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
    ClienteService service;

    Cliente cliente1=new Cliente(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");
    Cliente cliente2=new Cliente(2L, "Diego2", 34, 12345678, "Bulevar1234", "+54 234245","hola", true, "M");
    Cliente cliente3=new Cliente(3L, "Diego3", 34, 12345678, "Av salto 345345", "+598 6456456" ,"hola", true, "M");
    @Test
    void getClientes() throws Exception {
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));
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
        Cliente cliente=new Cliente(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");

        Mockito.when(service.guardarCliente(cliente)).thenReturn(cliente);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cliente));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

    }

    @Test
    void actualizarCliente() throws Exception {
        Cliente clienteUpdated=new Cliente( 1L,"Pepe", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");

        Mockito.when(service.buscarClientePorId(cliente1.getIdCliente())).thenReturn(Optional.of(cliente1));
        Mockito.when(service.modificarCliente(cliente1, cliente1.getIdCliente())).thenReturn(Optional.of(clienteUpdated));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/clientes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(this.mapper.writeValueAsString(clienteUpdated));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());

    }

    @Test
    void eliminarCliente() throws Exception{
        Mockito.when(service.eliminarCliente(cliente2.getIdCliente())).thenReturn(cliente2);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/clientes/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}