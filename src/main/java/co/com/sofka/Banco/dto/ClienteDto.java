package co.com.sofka.Banco.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto{
        private Long idCliente;
        private String nombre;
        private int edad;
        private int documento;
        private String direccion;
        private String telefono;
        private String contrasena;
        private boolean estado;
        private String genero;
}
