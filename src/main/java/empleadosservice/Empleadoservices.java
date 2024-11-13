package empleadosservice;

import empleadosDto.EmpleadoDto;
import java.util.List;

public interface Empleadoservices {

    // Obtener un empleado por su ID
    EmpleadoDto getUserByID(Long id);

    // Crear un nuevo empleado
    EmpleadoDto createEmpleado(EmpleadoDto empleadoDto);

    // Obtener todos los empleados
    List<EmpleadoDto> getAllEmpleados();

    // Actualizar un empleado existente por su ID
    void updateEmpleado(Long id, EmpleadoDto empleadoDto);

    // Eliminar un empleado por su ID
    void deleteEmpleado(Long id);
}
