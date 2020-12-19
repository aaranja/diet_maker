package sample.analizador.nutricion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.buscador.Alimento;
import sample.seleccionado.AlimentoItem;
import sample.user.DataUser;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nutricion {
    private ParseTree arbol;
    private Map<String, Object> total_datos = new HashMap<>();

    public Map<String, Object> analizar(String path){
        List<List<List<String>>> lista_visita;
        try{
            CharStream input = CharStreams.fromFileName(path, StandardCharsets.UTF_8);
            AlimentosLexer lexico = new AlimentosLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexico);
            AlimentosParser sintactico = new AlimentosParser(tokens);
            this.arbol = sintactico.archivo();

            /* Conseguir todos los datos */
            sample.analizador.nutricion.Visitante visitas = new Visitante();
            lista_visita = (List<List<List<String>>>) visitas.visit(arbol);

            /* Conseguir datos de usuario */
            DataUser usuario = getDataUser(lista_visita.get(0).get(0));

            /* Conseguir platos (Desayuno) */
            ObservableList<AlimentoItem> desayuno = geDataAlimento(lista_visita.get(1));
            /* Conseguir platos (Desayuno) */
            ObservableList<AlimentoItem> comida = geDataAlimento(lista_visita.get(2));
            /* Conseguir platos (Desayuno) */
            ObservableList<AlimentoItem> cena = geDataAlimento(lista_visita.get(3));

            System.out.println(usuario.toString());
            System.out.println(desayuno.toString());
            System.out.println(comida.toString());
            System.out.println(cena.toString());

            this.total_datos.put("Usuario", usuario);
            this.total_datos.put("Desayuno", desayuno);
            this.total_datos.put("Comida", comida);
            this.total_datos.put("Cena", cena);

        }catch(Exception e){
            //salida = e.toString();
            System.out.println(e.toString());
        }
        return this.total_datos;
    }

    private DataUser getDataUser(List<String> lista_user){
        String nombre = lista_user.remove(0);
        int edad = Integer.parseInt(lista_user.remove(0));
        float peso = Float.parseFloat(lista_user.remove(0));
        float altura = Float.parseFloat(lista_user.remove(0));;
        String genero = lista_user.remove(0);

        return new DataUser(nombre,altura,edad,peso,genero);
    }

    private ObservableList<AlimentoItem> geDataAlimento(List<List<String>> tipo_comida){
        ObservableList<AlimentoItem> lista_alimentos = FXCollections.observableArrayList();
        for(List<String> alimento : tipo_comida){
            Float gramos = Float.parseFloat(alimento.get(0)); // gramos
            String nombre = alimento.get(1);
            String tipo = alimento.get(2);
            Float peso = Float.parseFloat(alimento.get(3));
            Float calorias = Float.parseFloat(alimento.get(4));
            Float proteinas = Float.parseFloat(alimento.get(5));
            Float lipidos = Float.parseFloat(alimento.get(6));
            Float carbohidratos=Float.parseFloat(alimento.get(7));
            Alimento temp = new Alimento(nombre, tipo, calorias, carbohidratos, proteinas, lipidos, peso);
            lista_alimentos.add(new AlimentoItem(temp, gramos));
        }
        return lista_alimentos;
    }


}
