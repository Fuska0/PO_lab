package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import static agh.ics.oop.OptionsParser.parse;

public class App extends Application {
    private AbstractWorldMap map;

    public void init(){

        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{MoveDirection[] directions = parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(5,6), new Vector2d(1,1) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
            System.exit(0);
        }
    }
    public void start(Stage stage){
        int xMin = map.getLeftLowerCorner().getX();
        int yMin = map.getLeftLowerCorner().getY();
        int xMax = map.getRightHigherCorner().getX();
        int yMax = map.getRightHigherCorner().getY();

        int width = 50;
        int height = 50;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        gridPane.getColumnConstraints().add(new ColumnConstraints(width));
        gridPane.getRowConstraints().add(new RowConstraints(height));

        Label start = new Label("y/x");
        gridPane.add(start,0,0);
        GridPane.setHalignment(start, HPos.CENTER);

        for(int i = 1; i<=xMax - xMin + 1; i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(width));
            Label label = new Label(Integer.toString(xMin + i -1));
            gridPane.add(label,i,0);
            GridPane.setHalignment(label,HPos.CENTER);
        }

        for(int i = 1; i <= yMax - yMin + 1; i++){
            gridPane.getRowConstraints().add(new RowConstraints(height));
            Label label = new Label(Integer.toString(yMax-i+1));
            gridPane.add(label,0, i);
            GridPane.setHalignment(label,HPos.CENTER);
        }

        for(int j=yMin;j<=yMax;j++){
            for(int i=xMin;i<=xMax;i++){
                Vector2d pos = new Vector2d(i,j);
                if(map.isOccupied(pos)){
                    Label label = new Label(map.objectAt(pos).toString());
                    gridPane.add(label,i+1,yMax-j+1);
                    GridPane.setHalignment(label,HPos.CENTER);
                }
                else {
                    gridPane.add(new Label(" "),i+1,yMax-j+1);
                }
            }
        }

        Scene scene = new Scene(gridPane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}