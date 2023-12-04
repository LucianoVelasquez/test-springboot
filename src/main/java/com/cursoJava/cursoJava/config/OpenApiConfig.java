package com.cursoJava.cursoJava.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
    contact = @Contact(name = "Luciano",email = "luciano.vel166@gmail.com",url = "https://veldev.vercel.app/"),
    description = "Proyecto individual el cual consiste trabajar con datos de paises y donde cada pais puede estar relacionado con una o mas actividades en Relacion (n-n)",
    title = "Countries API",
    version = "1.0"
))
public class OpenApiConfig {
    
}
