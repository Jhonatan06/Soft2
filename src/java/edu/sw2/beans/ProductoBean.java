
package edu.sw2.beans;

public class ProductoBean {
    //Atributos
    public String producto;
    public String zona;
    public int ingreso;
    
    //Constructor
    public ProductoBean(String producto, String zona, int ingreso) {
        this.producto = producto;
        this.zona = zona;
        this.ingreso = ingreso;
    }
    
    //Getter and Setter
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public float getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }  
}
