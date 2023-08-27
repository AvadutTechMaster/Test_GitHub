package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.dao.BookDao;
import in.ashokit.service.BookService;

@SpringBootApplication
public class Assignment001Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Assignment001Application.class, args);
		
		BookService bean = context.getBean(BookService.class);
		
		bean.readData();
		
		
		
		
	}

}
