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
    opens se.linda.mutant_creator.fxpages to javafx.fxml;
    exports se.linda.mutant_creator.fxpages;
    opens se.linda.mutant_creator.fxfunctions to javafx.fxml;
    exports se.linda.mutant_creator.fxfunctions;
    opens se.linda.mutant_creator.functions to javafx.fxml;
    exports se.linda.mutant_creator.functions;
    opens se.linda.mutant_creator.fxcontrollers to javafx.fxml;
    exports se.linda.mutant_creator.fxcontrollers;
    opens se.linda.mutant_creator.contructors to javafx.fxml;
    exports se.linda.mutant_creator.contructors;
}