package se.linda.mutant_creator.fxFunctions;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Grid {
    private GridPane grid;
    private boolean visbility;

    public Grid(){
        this.grid = new GridPane();
    }

    public GridPane getGrid(int vGap, int hGap, boolean visibility) {
        this.grid.setVgap(vGap);
        this.grid.setHgap(hGap);
        this.grid.setPadding(new Insets(10, 10, 10, 10));
        this.grid.setGridLinesVisible(visibility);
        return this.grid;
    }

    public GridPane addNode(GridPane grid, int row, int colum, Node node) {
        grid.add(node, colum, row);
        return grid;
    }

    public GridPane addNodes(GridPane grid, int row, int colum, Node... nodes) {
        int rowcount = 0;
        for (Node N : nodes) {
            grid.add(N, colum, row + rowcount);
            rowcount ++;
        }
        return grid;
    }
}
