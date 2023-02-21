package com.guru.springDI.config;


import com.guru.springDI.exampleBean.FakeDataSource;
import com.guru.springDI.exampleBean.JmsDataSource;
import com.guru.springDI.exampleBean.YmlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
    }
)
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru_username}")
    private String user;

    @Value("${guru_password}")
    private String password;

    @Value("${guru_dburl}")
    private String dburl;

    @Value("${jms.name}")
    private String JmsName;

    @Value("${user.name}")
    private String ymlUsername;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setDburl(dburl);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUserName(user);
//        fakeDataSource.setUserName(env.getProperty("username"));
//        use this one to load an env var called username from the env var under the edit config of this file.
//        Also, if what is declared in the env var is the same as the one in the properties file the one in the config one will override the one decalred in the properties file.

        return fakeDataSource;
    }

//    This one loads all the data inside the path that has been defined using the @PropertySource("classpath:datasource.properties")

    @Bean
    public JmsDataSource jmsDataSource(){
        JmsDataSource jmsDataSource = new JmsDataSource();
        jmsDataSource.setName(JmsName);
        return jmsDataSource;
    }

    @Bean
    public YmlDataSource ymlDataSource(){
        YmlDataSource ymlDataSource = new YmlDataSource();
        ymlDataSource.setName("ymlUsername");
        return ymlDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
