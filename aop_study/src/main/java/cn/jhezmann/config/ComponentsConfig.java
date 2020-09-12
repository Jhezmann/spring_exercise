package cn.jhezmann.config;

import cn.jhezmann.beans.Person;
import cn.jhezmann.beans.User;
import org.springframework.context.annotation.Bean;

public class ComponentsConfig {
    @Bean
    public Person person(User user){
        Person person = new Person();
        person.setUser(user);
        return person;
    }
}
