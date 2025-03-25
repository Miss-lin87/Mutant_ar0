module se.linda.mutant_creator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.desktop;
    requires android.json;
    requires json.smart;
    requires org.mongodb.bson;
    requires org.apache.pdfbox;

    opens se.linda.mutant_creator to javafx.fxml;
    exports se.linda.mutant_creator;
    exports se.linda.mutant_creator.fxapps;
    opens se.linda.mutant_creator.fxapps to javafx.fxml;
}