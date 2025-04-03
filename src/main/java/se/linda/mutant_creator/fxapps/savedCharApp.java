package se.linda.mutant_creator.fxapps;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import se.linda.mutant_creator.fxFunctions.Grid;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class savedCharApp extends Application {
    private Grid grid = new Grid();
    private GridPane mainGrid = grid.getGrid(17,17,true);
    private PDDocument outputDoc = new PDDocument();
    private String path ="C:/Users/loric/Java projects/Mutant_Creator/src/main/resources/se/linda/mutant_creator/fxapps/Character_Sheet3.pdf";

    public static void main(String[] args) {
        launch(args);
    }

    private void setStage(Stage stage, GridPane grid, int V, int V1, String title) {
    }

    private void lockStage(Stage stage, int with, int hight) {
        stage.setMaxHeight(hight);
        stage.setMinHeight(hight);
        stage.setMaxWidth(with);
        stage.setMinWidth(with);
    }

    private List<PDField> findFields() {
        List<PDField> fields = List.of();
        File test = new File(path);
        System.out.println(test.isFile());
        try {
            PDDocument document = PDDocument.load(new File(path));
            System.out.println(document.getDocumentCatalog().getMarkInfo() );
            PDAcroForm form = document.getDocumentCatalog().getAcroForm();
            System.out.println(form);
            if(form != null) {
                fields.addAll(form.getFields());
            } else {
                System.out.println("Empty");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fields;
    }

    @Override
    public void start(Stage stage) {
        List<PDField> allFields = findFields();
        for (PDField field : allFields) {
            System.out.println(field.getPartialName());
        }
    }
}