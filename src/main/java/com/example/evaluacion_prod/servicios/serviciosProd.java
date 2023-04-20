package com.example.evaluacion_prod.servicios;

import com.example.evaluacion_prod.entidad.Productos;

import java.util.ArrayList;

public class serviciosProd {


    private ArrayList<Productos> lista = new ArrayList<>();


    public serviciosProd() {
        lista.add(new Productos(1, "manzana", 5000.0, "frutas", 3));
        lista.add(new Productos(2, "mango", 5200.0, "frutas", 5));
        lista.add(new Productos(3, "pera", 3500.0, "frutas", 5));
        lista.add(new Productos(4, "jabon", 2500.0, "aseo", 8));
        lista.add(new Productos(5, "cloro", 4500.0, "aseo", 1));
        lista.add(new Productos(6, "limpia pisos", 8500.0, "aseo", 4));
        lista.add(new Productos(7, "leche", 35000.0, "lacteos", 5));
        lista.add(new Productos(8, "queso", 16000.0, "lacteos", 2));
        lista.add(new Productos(9, "yougurt", 10000.0, "lacteos", 3));
    }

    public int cantidad() {
        return lista.size();
    }

    public ArrayList<Productos> mostrarProd() {
        return lista;
    }


    public void actualizar(int codigo, String nombre, double precio, String categoria, int cantidad) {
        for (Productos p : lista) {
            if (p.getCodigo() == codigo) {
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setCategoria(categoria);
                p.setCantidad(cantidad());
                break;

            }

        }
    }

    public double calcularTotal(int codigo, int cantidad) {
        for (Productos p : lista) {
            if (p.getCodigo() == codigo) {
                return p.getCantidad() * p.getPrecio();
            }
        }
        return 0;
    }

    public double calcularTotalConIva(int codigo, int cantidad) {
        for (Productos p : lista) {
            if (p.getCodigo() == codigo) {
                double precioSinIva = p.getPrecio() * cantidad;
                return precioSinIva * 1.19;
            }
        }
        return 0;
    }

    public void actualizarCategoria(String categoria, String nombre, double precio, int cantidad) {
        for (Productos p : lista) {
            if (p.getCategoria().equals(categoria)) {
                p.setNombre(nombre);
                p.setPrecio(precio);
                p.setCantidad(cantidad);
            }
        }
    }

}