package com.example.evaluacion_prod.controlador;


import com.example.evaluacion_prod.entidad.Productos;
import org.springframework.web.bind.annotation.*;
import com.example.evaluacion_prod.servicios.serviciosProd;

import java.util.ArrayList;


@CrossOrigin(origins =  "*",maxAge = 3600)
@RestController
public class controladorProd {

    serviciosProd servicio =new serviciosProd();

    @GetMapping("/cantidad")
    public String cantidad(){
        return "la cantidad de productos es: "+servicio.cantidad();
    }


    @GetMapping("/mostrarProd")
    public ArrayList<Productos> serviciosProductos(){
        return servicio.mostrarProd();
    }


    @PutMapping("/actualizar/{codigo}/{nombre}/{precio}/{categoria}/{cantidad}")
    public void actualizar(@PathVariable("codigo")int codigo,
                           @PathVariable("nombre")String nombre,
                           @PathVariable("precio")int precio,
                           @PathVariable("categoria")String categoria,
                           @PathVariable("cantidad")int cantidad)
    {servicio.actualizar(codigo,nombre,precio,categoria,cantidad);}



    @GetMapping("/calcularTotal/{codigo}/{cantidad}")
    public double calcularTotal(@PathVariable("codigo") int codigo, @PathVariable("cantidad") int cantidad) {
        return servicio.calcularTotal(codigo, cantidad);
    }

    @GetMapping("/calcularTotalConIva/{codigo}/{cantidad}")
    public double calcularTotalConIva(@PathVariable("codigo") int codigo, @PathVariable("cantidad") int cantidad) {
        return servicio.calcularTotalConIva(codigo, cantidad);
    }


    @PutMapping("/actualizarC")
    public void actualizar(@RequestBody Productos producto, Productos[] lista) {
        for (Productos p : lista) {
            if (p.getCodigo() == producto.getCodigo()) {
                p.setNombre(producto.getNombre());
                p.setPrecio(producto.getPrecio());
                p.setCategoria(producto.getCategoria());
                p.setCantidad(producto.getCantidad());
                break;
            }
        }
    }



}
