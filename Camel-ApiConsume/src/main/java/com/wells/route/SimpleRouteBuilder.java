package com.wells.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import com.wells.model.Employee;
import com.wells.processor.CreateEmployeeProcessor;
import com.wells.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {

	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

	@Override
	public void configure() throws Exception {

		// route for REST GET Call
		from("file:C:/inputFolderREST?noop=true").setHeader(Exchange.HTTP_METHOD, simple("GET"))
				.to("http://localhost:8081/employee?id=100").process(new MyProcessor());

		// route for REST POST Call
		from("file:C:/inboxPOST?noop=true").process(new CreateEmployeeProcessor()).marshal(jsonDataFormat)
				.setHeader(Exchange.HTTP_METHOD, simple("POST"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json")).to("http://localhost:8081/employee")
				.process(new MyProcessor());
	}

}