package co.com.sofka.Banco.repository;


import co.com.sofka.Banco.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
