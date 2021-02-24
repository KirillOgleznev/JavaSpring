package ru.myapp.garden;

import org.springframework.context.annotation.*;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration("springConfig")
@ComponentScan("manager")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("manager")
@EnableTransactionManagement
public class ConfigurationFile {

    @Bean(value = "frontGarden")
    public FrontGarden frontGarden() {
        return new FrontGarden(11, 11, true);
    }

    @Bean(value = "backGarden")
    public BackGarden backGarden() {
        return new BackGarden(10, 10);
    }

    @Bean(value = "house1")
    public House house1() {
        return new House("house1", frontGarden());
    }

    @Bean(value = "house2", initMethod = "turnOn", destroyMethod = "turnOff")
    public House house2() {
        return new House("house2", backGarden());
    }

    @Bean(value = "houseFactory", initMethod = "turnOn", destroyMethod = "turnOff")
    public House houseFactory() {
        return House.houseFactory();
    }
}
