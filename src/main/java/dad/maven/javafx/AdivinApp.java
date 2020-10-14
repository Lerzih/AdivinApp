package dad.maven.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("AdivinApp");
		int intento = 0;
		
		// Containers de la stage principal
		
		Text inicio = new Text("Introduce un número del 1 al 100");
		HBox textoInicio = new HBox(inicio);
		
		TextField numero = new TextField();
		HBox fNumeros = new HBox(numero);
		
		Button intro = new Button("Comprobar");
		HBox boton = new HBox(intro);
		
		VBox caja = new VBox();
		caja.getChildren().addAll(textoInicio, fNumeros, boton);
		caja.setSpacing(5);
		caja.setFillWidth(false);
		caja.setAlignment(Pos.CENTER);
		
		// Operaciones para generar un numero aleatorio
		
		int random = (int)(Math.random()*100);
		System.out.println(random);
		
		// Alerts
		
		intro.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				String respuesta = numero.getText();
				System.out.println(respuesta);
				int res;
				

				try {
					res = Integer.parseInt(respuesta);
					System.out.println(res);
					
					if (res == random) {
						
						Alert acertado = new Alert(AlertType.INFORMATION);
						acertado.setTitle("AdivinApp");
						acertado.setHeaderText("Has acertado!");
						acertado.setContentText("Sólo has necesitado " + intento + " intentos. \n"
								+ "Vuelve a jugar y hazlo mejor.");

						acertado.showAndWait();
						
					}
						
					if (res != random) {
							
						String mayor = "El número a adivinar es mayor a " + res;
						String menor = "El número a adivinar es menor a " + res;
						
						if (res > random) {
							
							Alert fallo = new Alert(AlertType.WARNING);
							fallo.setTitle("AdivinApp");
							fallo.setHeaderText("¡Has fallado!");
							fallo.setContentText(menor);

							fallo.showAndWait();
						}
						
						else {
							Alert fallo = new Alert(AlertType.WARNING);
							fallo.setTitle("AdivinApp");
							fallo.setHeaderText("¡Has fallado!");
							fallo.setContentText(mayor);

							fallo.showAndWait();
						}
						
						
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					
					Alert error = new Alert(AlertType.ERROR);
					error.setTitle("AdivinApp");
					error.setHeaderText("Error");
					error.setContentText("El número introducido no es válido");

					error.showAndWait();
				}
				
			} 
			
		});
		
		// Comando para mostrar la stage
		
		Scene scene = new Scene(caja, 300, 250);
	    primaryStage.setScene(scene);
		primaryStage.show();
		

	}

	
	public static void main(String[] args) {
		
		launch(args);
	}

}
