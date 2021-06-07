package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.ui.App;

public abstract class AbstractController {

	protected  String mainSceneScene = "mainScene";
	
	public void switchToMainScene() throws IOException{
			App.setRoot(mainSceneScene);
	}

	
}
