package org.gl52.proj.ui.controller;

import java.io.IOException;

import org.gl52.proj.ui.App;

public abstract class AbstractController {

	protected  String mainSceneScene = "mainScene";
	
	public void switchToMainSceneScene() throws IOException{
			App.setRoot(mainSceneScene);
	}
}
