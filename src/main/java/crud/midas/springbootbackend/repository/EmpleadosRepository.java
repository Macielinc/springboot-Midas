package crud.midas.springbootbackend.repository;

import crud.midas.springbootbackend.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    //crud
}
