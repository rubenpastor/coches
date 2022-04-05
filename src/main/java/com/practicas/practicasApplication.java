package com.practicas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import com.practicas.service.PacienteService;


@SpringBootApplication
public class practicasApplication {
	private static final Logger log = LoggerFactory.getLogger(practicasApplication.class);
	/*@Autowired
	private PacienteService pacienteService;
	*/
	public static void main(String[] args) {
		SpringApplication.run(practicasApplication.class, args);
	}
	
	

	@RestController
	public class IndexController implements ErrorController{

	    private static final String PATH = "/error";

	    @RequestMapping(value = PATH)
	    public String error() {
	        return "Error handling";
	    }

	    @Override
	    public String getErrorPath() {
	        return PATH;
	    }
	}
}
