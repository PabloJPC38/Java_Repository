
package com.egg.biblioteca.controladores;

// @author Pablo

import com.egg.biblioteca.Excepciones.Mi_Exception;
import com.egg.biblioteca.servicios.Autor_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor") //localhost:8080/autor
public class Autor_Controlador {
    
    @Autowired
    private Autor_Servicio autorServicio;
       
    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar(){
        return "autor_form.html";
    }
    
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){
        
        try {
            autorServicio.Crear_Autor(nombre);
            
            modelo.put("exito", "El Autor fue registrado correctamente!");
        } 
        catch (Mi_Exception ex) {
                      
            modelo.put("error", ex.getMessage());
            return "autor_form.html";
        }
        
        return "index.html";        
    }
}