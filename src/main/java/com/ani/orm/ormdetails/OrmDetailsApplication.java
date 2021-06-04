package com.ani.orm.ormdetails;

import com.ani.orm.ormdetails.mapping.MappingService;
import com.ani.orm.ormdetails.query.QueryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmDetailsApplication {
	//https://javabydeveloper.com/hibernate-5-example-with-different-configurations/
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrmDetailsApplication.class, args);
		query(ctx);

//		mapping(ctx);
	}

	private static void query(ApplicationContext ctx) {
		QueryService service = ctx.getBean(QueryService.class);
//		service.findByIsbn();
//		service.contain();

//		service.startsWith();

//		service.between();

//		service.conditional();

//		service.top();

//		service.query();

//		service.sorted();

//		service.aggregateFn();

		service.criteria();
	}

	private static void mapping(ApplicationContext ctx) {
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

		service.chipOnBoardFetch();
	}
}
