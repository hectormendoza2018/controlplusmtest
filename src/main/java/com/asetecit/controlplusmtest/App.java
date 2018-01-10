package com.asetecit.controlplusmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class App extends Application {

	private ConfigurableApplicationContext ctx;
	private Parent root;

	@Override
	public void init() throws Exception {
		ctx = SpringApplication.run(App.class);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/root.fxml"));
		fxmlLoader.setControllerFactory(ctx::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("ControlPlus M Test");
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		if (ctx != null) {
			ctx.close();
		}
	}

	public static void main(String[] args) {
		launch(App.class, args);
	}
}
