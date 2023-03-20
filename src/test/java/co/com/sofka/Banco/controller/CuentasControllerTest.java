package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.services.ClienteService;
import co.com.sofka.Banco.services.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

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
    Cuenta cuenta1= new Cuenta(1L, 111L, "Ahorro", 10000, true, cliente1);
    Cuenta cuenta2= new Cuenta(1L, 222L, "Ahorro", 10000, true, cliente1);
    Cuenta cuenta3 = new Cuenta(1L, 333L, "Ahorro", 10000, true, cliente1);

    @Test
    void getCuentas() {
    }

    @Test
    void getClientePorId() {
    }

    @Test
    void guardarCuenta() {
    }

    @Test
    void actualizarCuenta() {
    }

    @Test
    void eliminarCuenta() {
    }
}