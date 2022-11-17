
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private VBox SIGNUP;
    @FXML
    private VBox SIGNIN;
    @FXML
    private Pane ColorPane;
    private DropShadow shadow ;
    @FXML
    private VBox SignUpInformation;
    @FXML
    private VBox SignInInformation;
    @FXML
    private Pane InformationPane;

    private int duration = 250;
    //private double x, y;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.shadow = new DropShadow(BlurType.THREE_PASS_BOX, Color.web("#363636"), 0.0, 0.0, 8.0, 0.0);
        shadow.setHeight(0.0);
        shadow.setWidth(55.98);
        ColorPane.requestFocus();
    }

    @FXML
    public void SignUP(ActionEvent actionEvent) {
        SIGNIN.setVisible(true);
        SIGNIN.setOpacity(0.0);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.translateXProperty(), 250)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(InformationPane.translateXProperty(), -250)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.styleProperty(), "-fx-background-color:  linear-gradient(to right, #81e7c0 , #c3a3ea); -fx-background-radius : 20 ")));

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(SIGNUP.opacityProperty(), 0)));
        timeline.setOnFinished(e -> {
            SignUpInformation.setVisible(true);
            SignInInformation.setVisible(false);
            Timeline timeline2 =  new Timeline();
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.translateXProperty(), 0)));
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(InformationPane.translateXProperty(), 0)));
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.styleProperty(), "-fx-background-color:  linear-gradient(to right, #81e7c0 , #c3a3ea); -fx-background-radius : 20 0 0 20")));
            this.shadow.setOffsetX(8.0);
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.effectProperty(),  this.shadow )));
            timeline2.setOnFinished(e2 -> {
                SIGNUP.setVisible(false);
                Timeline timeline3 =  new Timeline();
                timeline3.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(SIGNIN.opacityProperty(), 1)));
                timeline3.play();
            });
            timeline2.play();
        });

        timeline.play();
    }

    @FXML
    public void SignIn(ActionEvent actionEvent) {
        SIGNUP.setVisible(true);
        SIGNUP.setOpacity(0.0);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.translateXProperty(), 250)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(InformationPane.translateXProperty(), -250)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.styleProperty(), "-fx-background-color:  linear-gradient(to right, #81e7c0 , #c3a3ea); -fx-background-radius : 20 ")));

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(100), new KeyValue(SIGNIN.opacityProperty(), 0)));
        timeline.setOnFinished(e -> {
            SignUpInformation.setVisible(false);
            SignInInformation.setVisible(true);
            Timeline timeline2 =  new Timeline();
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.translateXProperty(), 500)));
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(InformationPane.translateXProperty(), -500)));
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.styleProperty(), "-fx-background-color:  linear-gradient(to right, #81e7c0 , #c3a3ea); -fx-background-radius :  0 20 20 0 ")));
            this.shadow.setOffsetX(-8.0);
            timeline2.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(ColorPane.effectProperty(),  this.shadow )));
            timeline2.setOnFinished(e2 -> {

                SIGNIN.setVisible(false);
                Timeline timeline3 =  new Timeline();
                timeline3.getKeyFrames().add(new KeyFrame(Duration.millis(this.duration), new KeyValue(SIGNUP.opacityProperty(), 1)));
                timeline3.play();
            });
            timeline2.play();
        });
        timeline.play();
    }




   /* @FXML
    public void screenPressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }


    @FXML
    public void screenDragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }*/


}
