package it.gps;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
public class Main implements CommandLineRunner {

	@Autowired
	GPSSolver gps;

	@Override
	public void run(String... args) throws Exception {
		Problem p = new ObjectMapper().readValue(new File("banana.json"), Problem.class);
		log.info("problema di esempio ={}", p);
		List<String> solution = gps.solve(p); 
		if (solution==null)
			log.info("impossibile");
		else
			solution.forEach(s -> {
				if (s.startsWith(GPSSolver.PREFIX))
					log.info("{}", s);
			});

	}

}
