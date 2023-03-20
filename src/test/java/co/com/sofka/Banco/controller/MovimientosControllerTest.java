package co.com.sofka.Banco.controller;

import co.com.sofka.Banco.model.Cliente;
import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.model.Movimiento;
import co.com.sofka.Banco.services.ClienteService;
import co.com.sofka.Banco.services.MovimientoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class MovimientosControllerTest {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    MovimientoService service;


    LocalDate start = LocalDate.of(2023, Month.OCTOBER, 14);
    LocalDate end = LocalDate.now();
    LocalDate random = RandomDates.between(start, end);


    Cliente cliente1=new Cliente(1L, "Diego", 34, 12345678, "Caballero 1969","+598 1234", "hola", true, "M");
    Cuenta cuenta1= new Cuenta(1L, 111L, "Ahorro", 10000, true, cliente1);
    //Movimiento movimiento1 = new Movimiento(1L,  , "Deposito", 15000, 0, cuenta1);
    Movimiento movimiento2 = new Movimiento();
    Movimiento movimiento3 = new Movimiento();



    @Test
    void getMovimientos() {
    }

    @Test
    void getMovimientoPorId() {
    }

    @Test
    void guardarMovimiento() {
    }

    @Test
    void actualizarMovimiento() {
    }

    @Test
    void eliminarMovimiento() {
    }
}