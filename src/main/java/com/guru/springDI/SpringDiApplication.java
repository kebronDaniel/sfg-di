package com.guru.springDI;

import com.guru.springDI.config.PropertyConfig;
import com.guru.springDI.controllers.InjectedController;
import com.guru.springDI.controllers.ProfileControllerOne;
import com.guru.springDI.controllers.SampleController;
import com.guru.springDI.controllers.SampleControllerTwo;
import com.guru.springDI.exampleBean.FakeDataSource;
import com.guru.springDI.exampleBean.JmsDataSource;
import com.guru.springDI.exampleBean.YmlDataSource;
import com.guru.springDI.services.GreetingsInterfaceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext scx = SpringApplication.run(SpringDiApplication.class, args);

		System.out.println("----using primary------");
		SampleController sampleController = (SampleController) scx.getBean("sampleController");
		System.out.println(sampleController.showGreetings());

		System.out.println("----using qualifiers-----");
		SampleControllerTwo sampleControllerTwo = (SampleControllerTwo) scx.getBean("sampleControllerTwo");
		System.out.println(sampleControllerTwo.greetings());

		System.out.println("-------Profile--------");
		ProfileControllerOne profileControllerOne = (ProfileControllerOne) scx.getBean("profileControllerOne");
		System.out.println(profileControllerOne.greetings());

		System.out.println("--------property source---------");
		FakeDataSource fakeDataSource  = (FakeDataSource) scx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());
		JmsDataSource jmsDataSource = (JmsDataSource) scx.getBean(JmsDataSource.class);
		System.out.println("---using another properties file---");
		System.out.println(jmsDataSource.getName());

		System.out.println("-------Yml source --------");
		YmlDataSource ymlDataSource = (YmlDataSource) scx.getBean(YmlDataSource.class);
		System.out.println(ymlDataSource.getName());
	}

}
