/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author 50497
 */
public class Passgenerator {
    //generamos esta clase para poder tener el password encriptado
    
    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        //el String que mandamos al metodo encode es el password que queremos encriptar
        
        System.out.println(bCryptPasswordEncoder.encode("1234"));
    }
}
