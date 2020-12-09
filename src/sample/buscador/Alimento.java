package sample.buscador;

public class Alimento {
    private String nombre;
    private String tipo_alimento;
    private Float calorias;

    public Alimento(String nombre, Float calorias, String tipo_alimento ) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.tipo_alimento = tipo_alimento;
    }

    public String getNombre(){
        return nombre;
    }

    public Float getCalorias(){
        return calorias;
    }

    public void setCalorias(Float nuevaCalorias){
        this.calorias = nuevaCalorias;
    }

    public String getTipoAlimento(){
        return tipo_alimento;
    }

    public String toString(){ return nombre; }
}
