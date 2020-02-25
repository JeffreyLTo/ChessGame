import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

// Gui for which the board game is made/
public class Game extends Application {
    private Board chess;

    // Starts the board game.
    public void start(Stage stage) {
        stage.setTitle("Chess");

        //Instantiate a chess board and set its dimensions.
        chess = new Board();
        chess.setPrefSize(590,590);
        Scene scene = new Scene(chess);
        stage.setScene(scene);

        stage.show();
    }
    // Run the application to start a chess game.
    public static void main(String[] args) {
        launch(args);
    }


}

