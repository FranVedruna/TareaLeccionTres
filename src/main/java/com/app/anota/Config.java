package com.app.anota;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.app.anota")
@PropertySource("datos.propiedades")
public class Config {

}
