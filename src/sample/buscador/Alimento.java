package sample.buscador;

public class Alimento {
    private String nombre;
    private String tipo_alimento;
    private Integer calorias;

    public Alimento(String nombre, int calorias, String tipo_alimento ) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.tipo_alimento = tipo_alimento;
    }

    public String getNombre(){
        return nombre;
    }

    public int getCalorias(){
        return calorias;
    }

    public void setCalorias(int nuevaCalorias){
        this.calorias = nuevaCalorias;
    }

    public String toString(){ return nombre; }
}
