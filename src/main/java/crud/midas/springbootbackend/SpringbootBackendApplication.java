package crud.midas.springbootbackend;

import crud.midas.springbootbackend.model.Empleados;
import crud.midas.springbootbackend.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}


	@Autowired
	private EmpleadosRepository empleadosRepository;

	@Override
	public void run(String... args) throws Exception {



	}
}
