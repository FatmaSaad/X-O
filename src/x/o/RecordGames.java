package x.o;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RecordGames extends Pane {

    protected final ImageView imageView;
    protected final Reflection reflection;
    protected final ListView recordsList;
    private ObservableList<String> items = FXCollections.observableArrayList();
    protected final Button back;
    FileInputStream recordFile;

    public RecordGames(Stage stage) {

        imageView = new ImageView();
        reflection = new Reflection();
        recordsList = new ListView();
        back = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        imageView.setFitHeight(168.0);
        imageView.setFitWidth(240.0);
        imageView.setLayoutX(76.0);
        imageView.setLayoutY(79.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("media/record.JPG").toExternalForm()));

        imageView.setEffect(reflection);

        recordsList.setLayoutX(374.0);
        recordsList.setLayoutY(16.0);
        recordsList.setPrefHeight(364.0);
        recordsList.setPrefWidth(298.0);
        
        recordsList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String result = recordsList.getSelectionModel().getSelectedItem().toString();
                stage.getScene().setRoot(new ReplayRecord("","",0,0,result));
                System.out.println(result);
            }
        });
        
        recordsList.setItems(items);
        
        try {
            
            /*FileOutputStream newFile = new FileOutputStream("records.txt");
            byte[] chars = "1,2,3,4,5".getBytes();
                    
            newFile.write(chars);
            newFile.close();*/
            
            //Open Record File
            recordFile = new FileInputStream("record.txt");
            int size = recordFile.available();
            byte[] data = new byte[size];
            recordFile.read(data); 
            
            String[] allRecords = (new String(data)).split(",");
            
            for(int i=0; i< allRecords.length; i++)
            {
                items.add(allRecords[i]);
            }
            
            recordFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecordGames.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RecordGames.class.getName()).log(Level.SEVERE, null, ex);
        }
;

        back.setLayoutX(30.0);
        back.setLayoutY(361.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(31.0);
        back.setPrefWidth(75.0);
        back.setText("Back");
        
        back.setOnAction((ActionEvent event) -> {

            stage.getScene().setRoot(new StartGamePage(stage));

        });

        getChildren().add(imageView);
        getChildren().add(recordsList);
        getChildren().add(back);

    }
}
