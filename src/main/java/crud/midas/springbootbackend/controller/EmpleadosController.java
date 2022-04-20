package crud.midas.springbootbackend.controller;

import crud.midas.springbootbackend.exception.ResourceNotFoundException;
import crud.midas.springbootbackend.model.Empleados;
import crud.midas.springbootbackend.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @GetMapping
    private List<Empleados> getAllEmployes(){
        return empleadosRepository.findAll();
    }
    //build rest api
    @PostMapping()
    public Empleados createEmpleados(@RequestBody Empleados empleados){
        return empleadosRepository.save(empleados);
    }
    @GetMapping("{id}")
    public ResponseEntity<Empleados> getEmpleadoById(@PathVariable long id){
        Empleados empleados = empleadosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));
        return ResponseEntity.ok(empleados);
    }
    @PutMapping("{id}")
    public ResponseEntity<Empleados> updateEmpleado(@PathVariable long id,@RequestBody Empleados empleadosDatails){
        Empleados updateEmpleado = empleadosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));

        updateEmpleado.setCumpleanosFecha(empleadosDatails.getCumpleanosFecha());
        updateEmpleado.setPrimerNombre(empleadosDatails.getPrimerNombre());
        updateEmpleado.setSegundoNombre(empleadosDatails.getSegundoNombre());
        updateEmpleado.setApellidoPaterno(empleadosDatails.getApellidoPaterno());
        updateEmpleado.setApellidoMaterno(empleadosDatails.getApellidoMaterno());
        updateEmpleado.setGenero(empleadosDatails.getGenero());
        updateEmpleado.setFechaContratada(empleadosDatails.getFechaContratada());

        empleadosRepository.save(updateEmpleado);

        return ResponseEntity.ok(updateEmpleado);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmpleado(@PathVariable long id){

        Empleados empleados = empleadosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con id: " + id));

       empleadosRepository.delete(empleados);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
