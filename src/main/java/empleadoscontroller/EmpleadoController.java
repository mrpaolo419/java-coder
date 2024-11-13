package empleadoscontroller;

import empleadosservice.EmpleadoService;
import empleadosDto.EmpleadoDto;
import utils.ApiMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public ResponseEntity<ApiMsg> getAllEmpleados() {
        try {
            List<EmpleadoDto> empleados = empleadoService.getAllEmpleados();
            return ResponseEntity.ok(new ApiMsg("Lista de empleados obtenida correctamente", empleados));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new ApiMsg("Error al obtener empleados", null));
        }
        
    }

    @PostMapping("/create")
public ResponseEntity<ApiMsg> createEmpleado(@RequestBody EmpleadoDto empleadoDto) {
    try {
        EmpleadoDto savedEmpleado = empleadoService.createEmpleado(empleadoDto);
        return ResponseEntity.ok(new ApiMsg("Empleado creado exitosamente", savedEmpleado));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new ApiMsg("Error al crear el empleado", null));
    }
}

}
