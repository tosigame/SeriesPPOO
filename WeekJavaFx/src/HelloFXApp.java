import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage){
        VBox root =new VBox();
        Text msg=new Text("Hello");
        TextField nameFld=new TextField();

        Label label=new Label();
        label.setStyle("-fx-text-fill: red;");

        Button sayHelloBtn=new Button("Say Hello");
        sayHelloBtn.setOnAction(e->{
            String name =nameFld.getText();
            if(name.trim().length()>0){
                label.setText("Hello "+ name);
            }else{
                label.setText("Hello There");
            }

        });

        Button exit=new Button("Exit");
        exit.setOnAction(e-> Platform.exit());
        root.getChildren().addAll(label,nameFld,msg,sayHelloBtn,exit);
        Scene scene =new Scene(root,300,150);
        stage.setScene(scene);
        stage.setTitle("TestTitle");
        stage.show();
    }
}
