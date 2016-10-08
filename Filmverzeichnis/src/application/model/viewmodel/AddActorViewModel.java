package application.model.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddActorViewModel {

	 private StringProperty labelText =  new SimpleStringProperty("default");

	public StringProperty getLabelText() {
		return labelText;
	}

	public void setLabelText(StringProperty labelText) {
		this.labelText = labelText;
	}
	
}
