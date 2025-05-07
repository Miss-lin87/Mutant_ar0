package se.linda.mutant_creator.fxfunctions;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Grid {
    private final GridPane mainGrid;

    public Grid(){
        this.mainGrid = new GridPane();
    }

    public GridPane getGrid(int vGap, int hGap, boolean visibility) {
        this.mainGrid.setVgap(vGap);
        this.mainGrid.setHgap(hGap);
        this.mainGrid.setPadding(new Insets(10, 10, 10, 10));
        this.mainGrid.setGridLinesVisible(visibility);
        return this.mainGrid;
    }

    public void setPadding(int v, int v1, int v2, int v3) {
        this.mainGrid.setPadding(new Insets(v,v1,v2,v3));
    }

    public void addNode(GridPane grid, int row, int colum, Node node) {
        grid.add(node, colum, row);
    }

    public void addNodes(GridPane grid, int row, int colum, Node ...nodes) {
        int startRow = 0;
        for (Node node : nodes) {
            grid.add(node, colum, row + startRow);
            startRow ++;
        }
    }

    public Button closeButton(Stage stage) {
        Button temp = new Button("Close");
        temp.setFont(Font.font("",FontWeight.BOLD, 12));
        temp.setBackground(new Background(new BackgroundFill(Color.RED, null, new Insets(2))));
        temp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(3))));
        temp.setOnAction(_ -> stage.close());
        return temp;
    }
}