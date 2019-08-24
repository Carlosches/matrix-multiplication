//______________________________________________________PACKAGE___________________________________________________________

/**
 *This package contains all the classes required to show the user interface and matrices in it. 
 */

package userInterface;

//______________________________________________________IMPORTS___________________________________________________________

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;

//______________________________________________________THE CLASS__________________________________________________________

/**
* This class defines the necessary attributes and methods to change the size of the elements in the window. 
* @author 
*/

public class SceneSizeChangeListener implements ChangeListener<Number>{

//______________________________________________________CONSTANTS___________________________________________________________	

//______________________________________________________ATTRIBUTES___________________________________________________________

	private final Scene scene;
	private final double ratio;
	private final double initHeight;
	private final double initWidth;
	private final Parent contentPane;

//______________________________________________________METHODS___________________________________________________________

	public SceneSizeChangeListener(Scene scene, double ratio, double initHeight, double initWidth, Parent contentPane) {
		this.scene = scene;
		this.ratio = ratio;
		this.initHeight = initHeight;
		this.initWidth = initWidth;
		this.contentPane = contentPane;
	}

//________________________________________________________________________________________________________________
	 
	@Override
	public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
		
		final double newWidth  = scene.getWidth();
		final double newHeight = scene.getHeight();

		double scaleFactor = newWidth / newHeight > ratio ? newHeight / initHeight : newWidth / initWidth;

		if (scaleFactor >= 1) {
			Scale scale = new Scale(scaleFactor, scaleFactor);
			scale.setPivotX(0);
			scale.setPivotY(0);
			scene.getRoot().getTransforms().setAll(scale);

			contentPane.prefWidth (newWidth  / scaleFactor);
			contentPane.prefHeight(newHeight / scaleFactor);
		} else {
			contentPane.prefWidth (Math.max(initWidth,  newWidth));
			contentPane.prefHeight(Math.max(initHeight, newHeight));
		}
	}
	
//________________________________________________________________________________________________________________
	 
}


