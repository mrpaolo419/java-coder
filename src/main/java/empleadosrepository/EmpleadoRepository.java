package empleadosrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empleadosmodel.EmpleadoModel;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {
}
