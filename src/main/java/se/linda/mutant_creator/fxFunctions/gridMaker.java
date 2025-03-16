package se.linda.mutant_creator.fxFunctions;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class gridMaker {
    private GridPane grid;
    private int vGap;
    private int hGap;
    private Insets padd;

    public gridMaker(int vGap, int hGap) {
        this.grid = new GridPane();
        this.vGap = vGap;
        this.hGap = hGap;
        this.padd = new Insets(25,25,25,25);
    }

    public GridPane getGrid() {
        this.grid.setVgap(this.vGap);
        this.grid.setHgap(this.hGap);
        this.grid.setPadding(this.padd);
        return this.grid;
    }
}
