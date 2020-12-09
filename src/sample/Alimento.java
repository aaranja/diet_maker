package sample;

public class Alimento {
    private String nombre;
    private float calorias;
    private String tipo;

    public Alimento(String nombre, float calorias, String tipo) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
