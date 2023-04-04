package co.com.sofka.Banco.services;

import co.com.sofka.Banco.model.Cuenta;
import co.com.sofka.Banco.repository.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock private CuentaRepository repository;

    private CuentaService cuentaService;

    @BeforeEach void setUp()
    {
        Cuenta c1= Cuenta.builder()
                .idCuenta(1L)
                .numero(1234L)
                .tipoCuenta("Ahorro")
                .saldo(10000)
                .estado(true)
                .build();

        Cuenta c2= Cuenta.builder()
                .idCuenta(2L)
                .numero(4567L)
                .tipoCuenta("Corriente")
                .saldo(20000)
                .estado(true)
                .build();
        Cuenta c3= Cuenta.builder()
                .idCuenta(3L)
                .numero(8912L)
                .tipoCuenta("Ahorro")
                .saldo(5000)
                .estado(true)
                .build();
    }
    @Test
    void buscarCuentas() {

        assertEquals(3, cuentaService.buscarCuentas().size());
    }

    @Test
    void buscarCuentaPorId() {
    }

    @Test
    void guardarCuenta() {
        //Arrange

        //Act
        //Assert
    }

    @Test
    void eliminarCuenta() {
    }

    @Test
    void modificarCuenta() {
    }
}