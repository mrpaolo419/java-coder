package empleadosservice;

import empleadosDto.EmpleadoDto;
import empleadosmapper.EmpleadoMapper;
import empleadosmodel.EmpleadoModel;
import empleadosrepository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements Empleadoservices {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    // Obtener un empleado por ID
    public EmpleadoDto getUserByID(Long id) {
        Optional<EmpleadoModel> empleado = empleadoRepository.findById(id);
        return empleado.map(empleadoMapper::toDto).orElse(null);
    }

    // Crear un nuevo empleado
    public EmpleadoDto createEmpleado(EmpleadoDto empleadoDto) {
        EmpleadoModel empleadoModel = empleadoMapper.toModel(empleadoDto);
        EmpleadoModel savedEmpleado = empleadoRepository.save(empleadoModel);
        return empleadoMapper.toDto(savedEmpleado);
    }

    // Obtener todos los empleados
    public List<EmpleadoDto> getAllEmpleados() {
        return empleadoRepository.findAll().stream()
                .map(empleadoMapper::toDto)
                .collect(Collectors.toList());
    }

    // Actualizar un empleado existente
    public void updateEmpleado(Long id, EmpleadoDto empleadoDto) {
        Optional<EmpleadoModel> optionalEmpleado = empleadoRepository.findById(id);
        if (optionalEmpleado.isPresent()) {
            EmpleadoModel empleadoToUpdate = optionalEmpleado.get();
            empleadoToUpdate.setNombre(empleadoDto.getNombre());
            empleadoToUpdate.setEdad(empleadoDto.getEdad());
            empleadoToUpdate.setEmail(empleadoDto.getEmail());
            empleadoToUpdate.setTelefono(empleadoDto.getTelefono());
            empleadoToUpdate.setCategoria(empleadoDto.getCategoria());
            empleadoRepository.save(empleadoToUpdate);
        }
    }

    // Eliminar un empleado por ID
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
