package sample.analizador.nutricion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Visitante extends AlimentosBaseVisitor{

    /* Recibe una lista de alimentos context y los retorna en formato List String*/
    private List<List<String>> getAlimentos(List<AlimentosParser.AlimentoContext> platos){
        List<List<String>> lista_alimentos = new ArrayList<>();
        for(AlimentosParser.AlimentoContext alimento : platos ){
            List<String> fila_alimento = new ArrayList<>();
            fila_alimento.add(alimento.cantidad().getText());
            fila_alimento.add(alimento.nombre().getText());
            fila_alimento.add(alimento.tipo().getText());
            fila_alimento.add(alimento.peso_alimento().getText());
            fila_alimento.add(alimento.calorias().getText());
            fila_alimento.add(alimento.proteinas().getText());
            fila_alimento.add(alimento.lipidos().getText());
            fila_alimento.add(alimento.carbohidratos().getText());

            lista_alimentos.add(fila_alimento);
        }
        return lista_alimentos;
    }

    @Override
    public List<List<List<String>>> visitArchivo(AlimentosParser.ArchivoContext ctx) {
        /* Conseguir del contexto los datos */
        List<String> datos = new ArrayList<String>();
        datos.add(ctx.persona().nombre().getText());
        datos.add(ctx.persona().edad().getText());
        datos.add(ctx.persona().peso().getText());
        datos.add(ctx.persona().altura().getText());
        datos.add(ctx.persona().genero().getText());
        /* Datos de la persona */
        List<List<String>> datos_persona = new ArrayList<>();
        datos_persona.add(datos);

        /* Desayuno */
        List<List<String>> desayuno = getAlimentos(ctx.platos().desayuno().alimento());

        /* Comida */
        List<List<String>> comida = getAlimentos(ctx.platos().comida().alimento());

        /*Cena*/
        List<List<String>> cena = getAlimentos(ctx.platos().cena().alimento());

        /* Listas de listas */

        List<List<List<String>>> lista_final = new ArrayList<>();
        lista_final.add(datos_persona);
        lista_final.add(desayuno);
        lista_final.add(comida);
        lista_final.add(cena);

        return lista_final;
        //return super.visitArchivo(ctx);
    }
}
