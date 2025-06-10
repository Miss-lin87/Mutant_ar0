package se.linda.mutant_creator.fxpages;


import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class MainPageTest {
    private Text test = new Text("test");

    @Start
    private void start(Stage stage) {
        test.setId("testText");
        stage.setScene(new Scene(new StackPane(test), 300, 275));
        stage.show();
    }

    @Test
    public void testMainPage(FxRobot robot) {
        Assertions.assertNotNull(robot.lookup("#testTest").queryAs(Text.class));
    }
}