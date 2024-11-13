package empleadosmapper;

import empleadosmodel.EmpleadoModel;
import empleadosDto.EmpleadoDto;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    // Convierte de EmpleadoModel a EmpleadoDto
    public EmpleadoDto toDto(EmpleadoModel empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }

        return new EmpleadoDto(
            empleado.getId(),
            empleado.getNombre(),
            empleado.getEdad(),
            empleado.getEmail(),
            empleado.getTelefono(),
            empleado.getCategoria()
        );
    }

    // Convierte de EmpleadoDto a EmpleadoModel
    public EmpleadoModel toModel(EmpleadoDto empleadoDto) {
        if (empleadoDto == null) {
            throw new IllegalArgumentException("El EmpleadoDto no puede ser nulo");
        }

        EmpleadoModel empleado = new EmpleadoModel();
        empleado.setId(empleadoDto.getId());
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setEdad(empleadoDto.getEdad());
        empleado.setEmail(empleadoDto.getEmail());
        empleado.setTelefono(empleadoDto.getTelefono());
        empleado.setCategoria(empleadoDto.getCategoria());

        return empleado;
    }
}
