package sample.lista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class AlimentoListViewCell extends ListCell<AlimentoItem> {
    @FXML private Label labelNombre;
    @FXML private Label labelGramos;
    @FXML private Label labelIndex;
    @FXML private GridPane gridPane;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(AlimentoItem alimentoItem, boolean vacio) {
        super.updateItem(alimentoItem, vacio);
        if (vacio || alimentoItem == null){
            setText(null);
            setGraphic(null);
        } else {
            if(mLLoader == null){
                mLLoader = new FXMLLoader(getClass().getResource("../../fxml/ListCell.fxml"));
                mLLoader.setController(this);
                try{
                    mLLoader.load();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            /* Asignar valores del alimento al los labels*/
            labelIndex.setText("--");
            labelNombre.setText(alimentoItem.toString());
            labelGramos.setText(alimentoItem.getGramos());

            setText(null);
            setGraphic(gridPane);
        }

    }
}
