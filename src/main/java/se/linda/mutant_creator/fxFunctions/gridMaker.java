package se.linda.mutant_creator.fxFunctions;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class gridMaker {
    private GridPane grid;
    private int vGap;
    private int hGap;
    private Insets padd;
    private boolean visibility;

    public gridMaker(int vGap, int hGap, boolean visbility) {
        this.grid = new GridPane();
        this.vGap = vGap;
        this.hGap = hGap;
        this.padd = new Insets(25,25,25,25);
        this.visibility = visbility;
    }

    public GridPane getGrid() {
        this.grid.setVgap(this.vGap);
        this.grid.setHgap(this.hGap);
        this.grid.setPadding(this.padd);
        this.grid.setGridLinesVisible(visibility);
        return this.grid;
    }
}
