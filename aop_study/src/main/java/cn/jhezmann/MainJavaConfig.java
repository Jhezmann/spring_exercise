package cn.jhezmann;

import cn.jhezmann.beans.Person;
import cn.jhezmann.config.ComponentsConfig;
import cn.jhezmann.config.DBConfig;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("cn.jhezmann")
@PropertySource("classpath:/db.properties")
@Import({DBConfig.class, ComponentsConfig.class})
public class MainJavaConfig {
}
