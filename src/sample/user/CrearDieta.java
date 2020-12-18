package sample.user;

import com.pdfjet.*;
import javafx.collections.ObservableList;
import sample.buscador.Alimento;
import sample.seleccionado.AlimentoItem;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CrearDieta {
    private DataUser usuario;
    private ObservableList<AlimentoItem> alimentoObservableList;

    public CrearDieta(DataUser usuario, ObservableList<AlimentoItem> alimentoObservableList) {
        this.usuario = usuario;
        this.alimentoObservableList = alimentoObservableList;
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

    public void calcularDieta(Boolean pdf) throws Exception {
        if( usuario.isComplete()){
            double masa_basal = getMasaBasal();
            double imc = getIMC();
            /* KCalorias totales */
            float calorias_totales = 0;
            /* Macronutrientes */
            float proteinas_totales = 0;
            float lipidos_totales = 0;
            float carbohidratos_totales = 0;

            for(AlimentoItem alimentoSeleccionado : alimentoObservableList){
                Alimento alimento = alimentoSeleccionado.getAlimento();
                float calorias_gramo = alimento.getCalorias()/alimento.getPesoNeto();
                float calorias_subTotal = alimentoSeleccionado.getGramos() * calorias_gramo;
                System.out.println(alimento.getNombre()+ " "+alimentoSeleccionado.getGramos()+": - Calorias subtotal: "+calorias_subTotal);
                calorias_totales += calorias_subTotal;

                proteinas_totales += alimento.getProteinas();
                lipidos_totales += alimento.getLipidos();
                carbohidratos_totales += alimento.getCarbohidratos();
            }

            System.out.println("Tu masa basal es: "+masa_basal);
            System.out.println("Tu indice de masa corporal es: "+imc);
            System.out.println("Las calorias totales son: "+calorias_totales);
            System.out.println("Los macronutrientes (proteinas, lipidos, carbohidratos) totales son: "+proteinas_totales+", "+lipidos_totales+", "+carbohidratos_totales);
            this.crearPDF();
        }

    }

    private Cell getCellCabecera(String texto, Font font, int tamaño){
        Cell cell = new Cell(font);
        cell.setText(texto);
        cell.setColSpan(1);
        cell.setWidth(tamaño);
        cell.setTopPadding(10f);
        cell.setBottomPadding(10f);
        cell.setLeftPadding(10f);
        cell.setRightPadding(10f);
        return cell;
    }

    private Cell getCellCampo(String texto, Font font, int tamaño){
        Cell cell = new Cell(font);

        //cell.setNoBorders();
        cell.setText(texto);
        cell.setWidth(tamaño);

        // WITH:
        cell.setTopPadding(10f);
        cell.setBottomPadding(10f);
        cell.setLeftPadding(10f);
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
        f2.setSize(7f);

        Page page = new Page(pdf, Letter.PORTRAIT);
        TextLine text = new TextLine(f1,
                "Nombre: "+usuario.getNombre());
        text.setLocation(50f, 70f);
        text.setStrikeout(false);
        text.setUnderline(false);
        float[] point = text.drawOn(page);

        TextLine text2 = new TextLine(f1,
                "Altura: "+usuario.getAltura()+" cm");
        text2.setLocation(50f, 85f);
        text2.setStrikeout(false);
        text2.setUnderline(false);
        float[] point2 = text2.drawOn(page);

        TextLine text3 = new TextLine(f1,
                "Edad: "+usuario.getEdad()+" años");
        text3.setLocation(50f, 100f);
        text3.setStrikeout(false);
        text3.setUnderline(false);
        float[] point3 = text3.drawOn(page);

        TextLine text4 = new TextLine(f1,
                "Peso: "+usuario.getPeso()+" kg");
        text4.setLocation(50f, 115f);
        text4.setStrikeout(false);
        text4.setUnderline(false);
        float[] point4 = text4.drawOn(page);

        TextLine text5 = new TextLine(f1,
                "Genero: "+usuario.getGenero());
        text5.setLocation(50f, 130f);
        text5.setStrikeout(false);
        text5.setUnderline(false);
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
        cabecera.add(getCellCabecera("Alimento", f1, 75));
        cabecera.add(getCellCabecera("Tipo", f1, 75));

        tableData.add(cabecera);

        for(AlimentoItem alimento: alimentoObservableList){
            List<Cell> fila = new ArrayList<Cell>();
            Alimento a = alimento.getAlimento();
            fila.add(getCellCampo(a.getNombre(), f2, 75 ));
            fila.add(getCellCampo(a.getTipo(), f2, 75));

            tableData.add(fila);

        }

        table.setData(tableData);
        table.setCellBordersWidth(0.2f);
        //ubicación de la tabla
        table.setLocation(70f, 190f);
        table.drawOn(page);

        //
        table.resetRenderedPagesCount();
        table.setLocation(70f, 370f);
        table.drawOn(page);


        pdf.complete();

    }


}
