package x.o;

import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class ListViewBackGround extends Pane {

    protected final ImageView listview_image;
    protected final Reflection reflection;

    public ListViewBackGround() {

        listview_image = new ImageView();
        reflection = new Reflection();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(414.0);
        setPrefWidth(717.0);

        listview_image.setFitHeight(227.0);
        listview_image.setFitWidth(195.0);
        listview_image.setLayoutX(379.0);
        listview_image.setLayoutY(10.0);
        listview_image.setPickOnBounds(true);
        listview_image.setPreserveRatio(true);
        listview_image.setRotate(20.0);
        listview_image.setImage(new Image(getClass().getResource("media/paneback.jpeg").toExternalForm()));

        reflection.setBottomOpacity(0.1);
        reflection.setFraction(0.73);
        reflection.setTopOpacity(0.38);
        listview_image.setEffect(reflection);

        getChildren().add(listview_image);

    }
}
