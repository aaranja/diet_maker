package sample.user;

import com.pdfjet.*;
import com.pdfjet.Font;
import javafx.collections.ObservableList;
import sample.buscador.Alimento;
import sample.seleccionado.AlimentoItem;

import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import sample.buscador.Alimento;

public class CrearDieta {
    private DataUser usuario;
    /* KCalorias totales */
    private float calorias_totales = 0;
    /* Macronutrientes */
    private float proteinas_totales = 0;
    private float lipidos_totales = 0;
    private float carbohidratos_totales = 0;
    private List<ObservableList<AlimentoItem>> lista_alimentos;
    private List<Float> desayuno;
    private List<Float> comida;
    private List<Float> cena;

    DecimalFormat df = new DecimalFormat("#.00");

    public CrearDieta(DataUser usuario, List<ObservableList<AlimentoItem>> lista_alimentos) {
        this.usuario = usuario;
        this.lista_alimentos = lista_alimentos;
    }

    /* Calcula masa basal de acuerdo a los datos del usuario */
    private Double getMasaBasal() {
        double masa_basal;
        if (usuario.getGenero().equals("Hombre")) {
            masa_basal = (10 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5 * usuario.getEdad()) + 5;
        } else {
            masa_basal = (10 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5 * usuario.getEdad()) - 161;
        }
        return masa_basal;
    }

    /* Retorna el índice masa coporal */
    private Double getIMC(){
        return  usuario.getPeso() / ( Math.pow((usuario.getAltura()/100), 2));
    }

    /* Devuelve una lista con los totales de calorías y macro nutrientes */
    private List<Float> getData(ObservableList<AlimentoItem> lista){
        float calorias_totales = 0;
        float proteinas_totales = 0;
        float lipidos_totales = 0;
        float carbohidratos_totales = 0;
        List<Float> datos = new ArrayList<>();
        for(AlimentoItem alimentoItem : lista){
            Alimento alimento = getAlimento(alimentoItem);
            calorias_totales += alimento.getCalorias();
            proteinas_totales += alimento.getProteinas();
            lipidos_totales += alimento.getLipidos();
            carbohidratos_totales += alimento.getCarbohidratos();
        }

        datos.add(calorias_totales);
        datos.add(proteinas_totales);
        datos.add(lipidos_totales);
        datos.add(carbohidratos_totales);

        return datos;
    }

    /* Retorna el cálculo del alimento de acuerdo a los gramos*/
    private Alimento getAlimento(AlimentoItem alimento){
        float calorias = (alimento.getCalorias()/alimento.getPesoNeto()) * alimento.getGramos();
        float proteinas = (alimento.getProteinas()/alimento.getPesoNeto()) * alimento.getGramos();
        float lipidos = (alimento.getLipidos()/alimento.getPesoNeto()) * alimento.getGramos();
        float carbohidratos = (alimento.getCarbohidratos()/alimento.getPesoNeto()) * alimento.getGramos();

        return new Alimento(alimento.getNombre(),alimento.getGramos(), calorias, proteinas, lipidos, carbohidratos);
    }

    public void calcularDieta(Boolean pdf) throws Exception {
        if( usuario.isComplete()){
           double masa_basal = getMasaBasal();
            double imc = getIMC();
            /* KCalorias totales */

            this.desayuno = getData(lista_alimentos.get(0));
            this.comida = getData(lista_alimentos.get(1));
            this.cena = getData(lista_alimentos.get(2));

            this.calorias_totales = this.desayuno.get(0) + this.comida.get(0) + this.cena.get(0);
            /* Macronutrientes */
            this.proteinas_totales = this.desayuno.get(1) + this.comida.get(1) + this.cena.get(1);
            this.lipidos_totales = this.desayuno.get(2) + this.comida.get(2) + this.cena.get(2);
            this.carbohidratos_totales = this.desayuno.get(3) + this.comida.get(3) + this.cena.get(3);


            System.out.println("Tu masa basal es: "+masa_basal);
            System.out.println("Tu indice de masa corporal es: "+imc);
            System.out.println("Las calorias totales son: "+this.calorias_totales);
            System.out.println("Los macronutrientes (proteinas, lipidos, carbohidratos) totales son: "+this.proteinas_totales+", "+this.lipidos_totales+", "+this.carbohidratos_totales);
            this.crearPDF();
        }
    }

    private Cell getCellCabecera(String texto, Font font, int tamaño){
        Cell cell = new Cell(font);
        cell.setText(texto);
        cell.setColSpan(1);
        cell.setWidth(tamaño);
        cell.setTopPadding(5f);
        cell.setBottomPadding(5f);
        cell.setLeftPadding(3f);
        cell.setRightPadding(10f);
        return cell;
    }

    private Cell getCellCampo(String texto, Font font, int tamaño){
        Cell cell = new Cell(font);
        //cell.setNoBorders();
        cell.setText(texto);
        cell.setWidth(tamaño);
        // WITH:
        cell.setTopPadding(5f);
        cell.setBottomPadding(5f);
        cell.setLeftPadding(3f);
        cell.setRightPadding(10f);
        return cell;
    }

    private Cell getTitle(String texto, Font font, int tamaño, boolean borde){
        Cell cell = new Cell(font);
        //cell.setNoBorders();
        cell.setText(texto);
        cell.setWidth(tamaño);
        cell.setNoBorders();
        if(borde) cell.setNoBorders();
        // WITH:
        cell.setTopPadding(5f);
        cell.setBottomPadding(5f);
        cell.setLeftPadding(3f);
        cell.setRightPadding(10f);
        return cell;
    }

    private void crearPDF() throws Exception{
        PDF pdf = new PDF(
                new BufferedOutputStream(
                        new FileOutputStream("Ejemplo2.pdf")));
        //Empieza texto

        Font f1 = new Font(pdf, CoreFont.HELVETICA);
        Font f2 = new Font(pdf, CoreFont.HELVETICA);
        Font f3 = new Font(pdf, CoreFont.HELVETICA);
        f1.setSize(5.0f);
        f2.setSize(6.0f);
        f3.setSize(7.0f);
        f3.setItalic(true);



        Page page = new Page(pdf, Letter.PORTRAIT);
        TextLine text = new TextLine(f1,
                "Nombre: "+usuario.getNombre());
        text.setLocation(50f, 70f);
        text.setStrikeout(false);
        text.setUnderline(false);
        text.setFontSize(15);
        float[] point = text.drawOn(page);

        TextLine text2 = new TextLine(f1,
                "Altura: "+usuario.getAltura()+" cm");
        text2.setLocation(50f, 85f);
        text2.setStrikeout(false);
        text2.setUnderline(false);
        text2.setFontSize(15);
        float[] point2 = text2.drawOn(page);

        TextLine text3 = new TextLine(f1,
                "Edad: "+usuario.getEdad()+" años");
        text3.setLocation(50f, 100f);
        text3.setStrikeout(false);
        text3.setUnderline(false);
        text3.setFontSize(15);
        float[] point3 = text3.drawOn(page);

        TextLine text4 = new TextLine(f1,
                "Peso: "+usuario.getPeso()+" kg");
        text4.setLocation(50f, 115f);
        text4.setStrikeout(false);
        text4.setUnderline(false);
        text4.setFontSize(15);
        float[] point4 = text4.drawOn(page);

        TextLine text5 = new TextLine(f1,
                "Genero: "+usuario.getGenero());
        text5.setLocation(50f, 130f);
        text5.setStrikeout(false);
        text5.setUnderline(false);
        text5.setFontSize(15);
        float[] point5 = text5.drawOn(page);

        TextLine text6 = new TextLine(f1,
                "Datos de registro. ");
        text6.setLocation(250f, 45f);
        text6.setStrikeout(false);
        text6.setUnderline(false);
        text6.setFontSize(20);
        float[] point6 = text6.drawOn(page);

        TextLine text7 = new TextLine(f1,
                "Alimentos.");
        text7.setLocation(50f, 175f);
        text7.setStrikeout(false);
        text7.setUnderline(false);
        text7.setFontSize(15);
        float[] point7 = text7.drawOn(page);

        /*  ==================  TABLA  ===================== */
        Table table = new Table();
        // table.setCellMargin(10f);

        List<List<Cell>> tableData = new ArrayList<List<Cell>>();

        List<Cell> row = null;
        Cell cell = null;


        List<Cell> cabecera = new ArrayList<Cell>();
        cabecera.add(getCellCabecera("Alimento", f3, 130));
        cabecera.add(getCellCabecera("Tipo", f3, 100));
        cabecera.add(getCellCabecera("Gramos", f3, 45));
        cabecera.add(getCellCabecera("Calorias", f3, 45));
        cabecera.add(getCellCabecera("Proteinas", f3, 45));
        cabecera.add(getCellCabecera("Lipidos", f3, 45));
        cabecera.add(getCellCabecera("Carbohidratos", f3, 50));

        /* Añadir título desayuno */
        List<Cell> titulo_desayuno = new ArrayList<Cell>();
        titulo_desayuno.add(getTitle("Desayuno", f3, 100,true));
        tableData.add(titulo_desayuno);

        tableData.add(cabecera);

        for(AlimentoItem alimento: lista_alimentos.get(0)){
            List<Cell> fila = new ArrayList<Cell>();
            /*  Nombre > Gramos > Calorias > Proteinas > Lipidos > Carbohidratos */

            /* Alimento con los datos calculados*/
            Alimento a = getAlimento(alimento);

            fila.add(getCellCampo(a.getNombre(), f2, 130 ));
            fila.add(getCellCampo(alimento.getTipo(), f2, 100));
            fila.add(getCellCampo(String.valueOf(a.getPesoNeto()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCalorias()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getProteinas()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getLipidos()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCarbohidratos()), f2, 50));

            tableData.add(fila);

        }

        /* Añadir totales del desayuno*/
        List<Cell> total = new ArrayList<Cell>();
        total.add(getTitle("", f3, 230, true));
        total.add(getTitle("Totales", f3, 45, false));
        total.add(getTitle(this.desayuno.get(0).toString(), f3, 45, false));
        total.add(getTitle(this.desayuno.get(1).toString(), f3, 45, false));
        total.add(getTitle(this.desayuno.get(2).toString(), f3, 45, false));
        total.add(getTitle(this.desayuno.get(3).toString(), f3, 50, false));
        tableData.add(total);


        /* ########### SECCIÓN TABLA COMIDA ###############################*/
        /* Añadir título comida */
        List<Cell> titulo_comida = new ArrayList<Cell>();
        titulo_comida.add(getTitle("Comida", f3, 100,true));
        tableData.add(titulo_comida);

        List<Cell> cabecera_comida = new ArrayList<Cell>();
        cabecera_comida.add(getCellCabecera("Alimento", f3, 130));
        cabecera_comida.add(getCellCabecera("Tipo", f3, 100));
        cabecera_comida.add(getCellCabecera("Gramos", f3, 45));
        cabecera_comida.add(getCellCabecera("Calorias", f3, 45));
        cabecera_comida.add(getCellCabecera("Proteinas", f3, 45));
        cabecera_comida.add(getCellCabecera("Lipidos", f3, 45));
        cabecera_comida.add(getCellCabecera("Carbohidratos", f3, 50));
        tableData.add(cabecera_comida);

        for(AlimentoItem alimento: lista_alimentos.get(1)){
            List<Cell> fila = new ArrayList<Cell>();
            /*  Nombre > Gramos > Calorias > Proteinas > Lipidos > Carbohidratos */

            /* Alimento con los datos calculados*/
            Alimento a = getAlimento(alimento);

            fila.add(getCellCampo(a.getNombre(), f2, 130 ));
            fila.add(getCellCampo(alimento.getTipo(), f2, 100));
            fila.add(getCellCampo(String.valueOf(a.getPesoNeto()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCalorias()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getProteinas()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getLipidos()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCarbohidratos()), f2, 50));

            tableData.add(fila);

        }

        /* Añadir totales */
        List<Cell> total_comida = new ArrayList<Cell>();
        total_comida.add(getTitle("", f3, 230, true));
        total_comida.add(getTitle("Totales", f3, 45, false));
        total_comida.add(getTitle(this.comida.get(0).toString(), f3, 45, false));
        total_comida.add(getTitle(this.comida.get(1).toString(), f3, 45, false));
        total_comida.add(getTitle(this.comida.get(2).toString(), f3, 45, false));
        total_comida.add(getTitle(this.comida.get(3).toString(), f3, 50, false));
        tableData.add(total_comida);

        /* ############### FIN TABLA COMIDA #############################*/

        /* ############### SECCIÓN TABLA CENA #############################*/
        /* Añadir título comida */
        List<Cell> titulo_cena = new ArrayList<Cell>();
        titulo_cena.add(getTitle("Cena", f3, 100,true));
        tableData.add(titulo_cena);

        List<Cell> cabecera_cena = new ArrayList<Cell>();
        cabecera_cena.add(getCellCabecera("Alimento", f3, 130));
        cabecera_cena.add(getCellCabecera("Tipo", f3, 100));
        cabecera_cena.add(getCellCabecera("Gramos", f3, 45));
        cabecera_cena.add(getCellCabecera("Calorias", f3, 45));
        cabecera_cena.add(getCellCabecera("Proteinas", f3, 45));
        cabecera_cena.add(getCellCabecera("Lipidos", f3, 45));
        cabecera_cena.add(getCellCabecera("Carbohidratos", f3, 50));
        tableData.add(cabecera_cena);

        for(AlimentoItem alimento: lista_alimentos.get(2)){
            List<Cell> fila = new ArrayList<Cell>();
            /*  Nombre > Gramos > Calorias > Proteinas > Lipidos > Carbohidratos */

            /* Alimento con los datos calculados*/
            Alimento a = getAlimento(alimento);

            fila.add(getCellCampo(a.getNombre(), f2, 130 ));
            fila.add(getCellCampo(alimento.getTipo(), f2, 100));
            fila.add(getCellCampo(String.valueOf(a.getPesoNeto()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCalorias()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getProteinas()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getLipidos()), f2, 45));
            fila.add(getCellCampo(String.valueOf(a.getCarbohidratos()), f2, 50));

            tableData.add(fila);

        }

        /* Añadir totales */
        List<Cell> total_cena = new ArrayList<Cell>();
        total_cena.add(getTitle("", f3, 230, true));
        total_cena.add(getTitle("Totales", f3, 45, false));
        total_cena.add(getTitle(df.format(this.cena.get(0)), f3, 45, false)); // calorias
        total_cena.add(getTitle(df.format(this.cena.get(1)), f3, 45, false)); // proteinas
        total_cena.add(getTitle(df.format(this.cena.get(2)), f3, 45, false)); // lipidos
        total_cena.add(getTitle(df.format(this.cena.get(3)), f3, 50, false)); // carbohidratos
        tableData.add(total_cena);
        /* ############### FIN TABLA CENA #############################*/


        table.setData(tableData);
        table.setCellBordersWidth(0.2f);
        //ubicación de la tabla
        table.setLocation(50f, 210f);
        table.resetRenderedPagesCount();
        table.drawOn(page);

        TextLine text8 = new TextLine(f1,
                "Tu masa basal es: "+getMasaBasal());
        text8.setLocation(30f, 700f);
        text8.setStrikeout(false);
        text8.setUnderline(false);
        text8.setFontSize(10);
        float[] point8 = text8.drawOn(page);

        TextLine text9 = new TextLine(f1,
                "Tu indice de masa corporal es: "+df.format(getIMC()));
        text9.setLocation(30f, 715f);
        text9.setStrikeout(false);
        text9.setUnderline(false);
        text9.setFontSize(10);
        float[] point9 = text9.drawOn(page);

        TextLine text10 = new TextLine(f1,
                "Tus calorias totales son: "+this.calorias_totales);
        text10.setLocation(30f, 730f);
        text10.setStrikeout(false);
        text10.setUnderline(false);
        text10.setFontSize(10);
        float[] point10 = text10.drawOn(page);

        TextLine text11 = new TextLine(f1,
                "Los macronutrientes (proteinas, lipidos, carbohidratos) totales son: "+df.format(this.proteinas_totales)+", "+df.format(this.lipidos_totales)+", "+df.format(this.carbohidratos_totales));
        text11.setLocation(30f, 745f);
        text11.setStrikeout(false);
        text11.setUnderline(false);
        text11.setFontSize(10);
        float[] point11 = text11.drawOn(page);

        pdf.complete();

    }


}
