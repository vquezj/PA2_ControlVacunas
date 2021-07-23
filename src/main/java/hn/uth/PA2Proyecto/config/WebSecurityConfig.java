/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.config;

import hn.uth.PA2Proyecto.servicios.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author 50497
 */
@Configuration //le decios que es un archivo de configuracion de spring
@EnableWebSecurity //habilita el web security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //este array es para evitar que la seguridad se aplique a los resources
   String[] resources = new String[]{
        "/include/**", "/css/**", "/icons/**", "/images/**", "/js/**", "/layer/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*aqui le decimos a http que configure los requets le decimos quienes estan autorizados
        quienes no y de que manera
        todos los que tengan el permitAll despues significa que cualquiera puede acceder
        a esas url o lo que este anteriormente de igual forma le decimos que a la raiz o al index cualquiera
        pueda acceder, pero todo lo que sea admin o empiece por admin debe tener el rol admin obligatoriamente
        y todo lo que tenga user debe tener el rol de usuario
        y cualquier otro request o cualquier otra url que no sea ninguna de las que especificamos 
        anteriormente debe estar autenticada en este caso la de principal debe estar autenticada
        con el and le decimos que queremos configurar el formulario login
        le decimos que cuando la app necesite mostrar el login siempre me lleve a la url login
        tambien le decimos que cualquiera puede acceder a esa url
        si el usuario se logue exitosamente lo debe llevar a la url de principal
        pero si comete error y no se loguea exitosamente le va a devolver a la url del login con el parametro error
        le decimos que los nombres para username y password en los parametros seran username y password que son los que
        estan en el formulario
        posteriormente le decimos que queremos configurar otra parte de la seguridad que es el logout
        y le decimos que se puede desloguear cualquiera
        y una vez que se desloguee exitosamente lo va a llevar al login con el parametro logout 
        mostrando una alerta con el mensaje usted a cerrado session exitosamente */

        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/login").permitAll()
                .antMatchers("/vacuna*", "/establecimiento*", "/index*").access("hasRole('ADMIN')")
                .antMatchers("/citas*", "/estadisticas*", "/calendarizacion*").access("hasRole('USER')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/principal")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;
    /* aqui configuramos el encriptador de las contraseñas
    el constructor del encriptador recibe un parametro de enteros o lo podemos dejar vacio pero lo hara 
    aleatoriamente si le ponemos el parametro lo podemos controlar y le decimos que tan fuerte queremos
    que sea la encriptacion */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    
    /* posteriormente le decimos en la configuracion global y la manera en que va autenticar los usuarios 
    va a ser utilizando el encode que declaramos anteriorente y el servicio userDetailService*/
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
