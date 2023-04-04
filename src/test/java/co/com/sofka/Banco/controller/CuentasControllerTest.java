package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.dto.CuentaDto;
import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.services.ClienteService;
import co.com.sofka.Banco.services.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CuentasControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    CuentaService service;

    Cliente cliente1=new Cliente(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");
    CuentaDto cuenta1= new CuentaDto(1L, 111L, "Ahorro", 10000, true, cliente1);
    CuentaDto cuenta2= new CuentaDto(1L, 222L, "Ahorro", 10000, true, cliente1);
    CuentaDto cuenta3 = new CuentaDto(1L, 333L, "Ahorro", 10000, true, cliente1);

    @Test
    void getCuentas() throws Exception{
            List<CuentaDto> cuentas = new ArrayList<>(Arrays.asList(cuenta1, cuenta2, cuenta3));
            Mockito.when(service.buscarCuentas()).thenReturn(cuentas);

            mockMvc.perform(get("/cuentas")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void getClientePorId() throws Exception{
        Mockito.when(service.buscarCuentaPorId(cuenta1.getIdCuenta())).thenReturn(Optional.of(cuenta1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/cuentas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void guardarCuenta() throws Exception{
        Cuenta cuenta = new Cuenta(1L, 333L, "Ahorro", 10000, true, cliente1);

        Mockito.when(service.guardarCuenta(cuenta)).thenReturn(cuenta);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(cuenta));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    void actualizarCuenta() {
    }

    /*@Test
    void eliminarCuenta() throws Exception{
        Mockito.when(service.eliminarCuenta(cuenta2.getIdCuenta())).thenReturn(void);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/cuentas/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/
}