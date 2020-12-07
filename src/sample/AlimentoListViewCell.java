package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class AlimentoListViewCell extends ListCell<Alimento> {
    @FXML private Label labelNombre;
    @FXML private Label labelGramos;
    @FXML private Label labelIndex;
    @FXML private GridPane gridPane;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Alimento alimento, boolean vacio) {
        super.updateItem(alimento, vacio);
        if (vacio || alimento == null){
            setText(null);
            setGraphic(null);
        } else {
            if(mLLoader == null){
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/ListCell.fxml"));
                mLLoader.setController(this);
                try{
                    mLLoader.load();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            labelIndex.setText("--");
            labelNombre.setText(alimento.getNombre());
            labelGramos.setText(alimento.getGramos());

            setText(null);
            setGraphic(gridPane);
        }
    }
}
