package it.gps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
public class Main implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("hello from Spring logger");
		Set<String> prec = new HashSet<String>();
		prec.add("A");
		Set<String> add = new HashSet<String>();
		add.add("B");		
		Set<String> del = new HashSet<String>();	
		Problem p = new Problem(Arrays.asList("A"),Arrays.asList("B"),Arrays.asList(new Operator("azione1", prec,add,del)));
		log.info("problema di esempio ={}", p);
//		System.out.println("hello from Spring boot");		
	}

}
