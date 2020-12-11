package sample.user;

public class DataUser {
    private String nombre;
    private float altura = 0;
    private int edad = 0;
    private float peso = 0;
    private String genero;

    public DataUser() {
    }

    public DataUser(String nombre, float talla, float altura, int edad, float peso, String genero) {
        this.nombre = nombre;
        this.altura = altura;
        this.edad = edad;
        this.peso = peso;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isComplete(){
        if(this.nombre == null) return false;
        if(this.edad == 0) return false;
        if(this.genero == null) return false;
        if(this.peso == 0) return false;
        if(this.altura == 0) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", edad=" + edad +
                ", peso=" + peso +
                ", genero='" + genero + '\'' +
                '}';
    }
}
