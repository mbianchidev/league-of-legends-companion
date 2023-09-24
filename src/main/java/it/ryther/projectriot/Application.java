package it.ryther.projectriot;

import it.ryther.projectriot.API.Queues.Queue;
import it.ryther.projectriot.API.Queues.QueuesCall;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan({"it.ryther.projectriot*"})
@EntityScan("it.ryther.projectriot*")
//@EnableJpaRepositories("it.ryther.projectriot*")
public class Application {

	public static List<Queue> queues = QueuesCall.run();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
		return args -> {};
	}

}