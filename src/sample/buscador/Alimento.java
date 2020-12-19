package sample.buscador;

public class Alimento {
    private String nombre;
    private String tipo_alimento;
    private Float calorias;
    private Float carbohidratos;
    private Float proteinas;
    private Float lipidos;
    private Float peso_neto;

    public Alimento(String nombre, String tipo_alimento, Float calorias, Float carbohidratos, Float proteinas, Float lipidos, Float peso_neto) {
        this.nombre = nombre;
        this.tipo_alimento = tipo_alimento;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.lipidos = lipidos;
        this.peso_neto = peso_neto;
    }

    public Alimento(String nombre, Float gramos, Float calorias, Float proteinas, Float lipidos, Float carbohidratos){
        this.nombre = nombre;
        this.peso_neto = gramos;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.lipidos = lipidos;
        this.carbohidratos = carbohidratos;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
    }

    public Float getCalorias() {
        return calorias;
    }

    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    public Float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Float getProteinas() {
        return proteinas;
    }

    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    public Float getLipidos() {
        return lipidos;
    }

    public void setLipidos(Float lipidos) {
        this.lipidos = lipidos;
    }

    public Float getPesoNeto() { return peso_neto; }

}
