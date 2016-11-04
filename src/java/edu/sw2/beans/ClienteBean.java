package edu.sw2.beans;

public class ClienteBean {
    private int codigo;
    private String nombre;
    private String estado;
    private int utilidad;    
    private int utilidadP;    
    private String rating;
    private int growE;
    private int growP;

    public ClienteBean(String nombre, String estado, String rating) {
        this.nombre = nombre;
        this.estado = estado;
        this.rating = rating;
    }    

    public ClienteBean(int utilidad, int utilidadP) {       
        this.utilidad = utilidad;
        this.utilidadP = utilidadP;
    }

    public ClienteBean() {
    }
               
        
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getUtilidadP() {
        return utilidadP;
    }

    public void setUtilidadP(int utilidadP) {
        this.utilidadP = utilidadP;
    }

    public int getGrowE() {
        return growE;
    }

    public void setGrowE(int growE) {
        this.growE = growE;
    }

    public int getGrowP() {
        return growP;
    }

    public void setGorwP(int growP) {
        this.growP = growP;
    }
    
    
    
    
}
