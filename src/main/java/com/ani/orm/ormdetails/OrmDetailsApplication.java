package com.ani.orm.ormdetails;

import com.ani.orm.ormdetails.mapping.MappingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmDetailsApplication {
	//https://javabydeveloper.com/hibernate-5-example-with-different-configurations/
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrmDetailsApplication.class, args);
		MappingService service = ctx.getBean(MappingService.class);
		System.out.println("---Saving Board---");
		service.createSingleBoard();
		System.out.println("---Saving Chip---");
		service.createSingleChip();
		System.out.println("---Crafting Board With Chip---");
		service.createBoardWithChips();
		System.out.println("---All Chips On The Board---");
		service.findAllChipsByBoardId();
		System.out.println("---All Chips---");
		service.findAllChips();
		System.out.println("---Saving Processor---");
		service.saveProcessor();
		System.out.println("---All Processors---");
		service.findAllProcessors();
		System.out.println("---All Processors On Board---");
		service.findAllProcessorsByBoardId();
	}
}
