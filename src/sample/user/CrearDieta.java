package sample.user;

import javafx.collections.ObservableList;
import sample.seleccionado.AlimentoItem;

public class CrearDieta {
    private DataUser usuario;
    private ObservableList<AlimentoItem> alimentoObservableList;


    public CrearDieta(DataUser usuario, ObservableList<AlimentoItem> alimentoObservableList) {
        this.usuario = usuario;
        this.alimentoObservableList = alimentoObservableList;
    }



    private void calcularMasa() {
        double masa_basal;
        if (usuario.isComplete()) {
            if (usuario.getGenero().equals("Hombre")) {
                masa_basal = (10 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5 * usuario.getEdad()) + 5;
            } else {
                masa_basal = (10 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5 * usuario.getEdad()) - 161;

            }
            System.out.println(masa_basal);

        }
    }
    public void calcularDieta(Boolean pdf){
        //tomar usuario y lista

    }
}
