package com.parse.starter;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FunctionCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseCloud;
import com.parse.ParseException;

public class ParseStarterProjectActivity extends Activity {
	EditText textFuncion;
	TextView textResultado;
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpened(getIntent());
		
		textFuncion = (EditText)findViewById(android.R.id.edit);
		textResultado = (TextView)findViewById(android.R.id.text1);
	}
	
	
	public void llamarFuncion(View v){
		textResultado.setText("");
		String funcion = textFuncion.getText().toString();
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("movie", "El padrino");
		
		
		ParseCloud.callFunctionInBackground(funcion, parametros, new FunctionCallback<Object>() {			  
			@Override
			public void done(Object object, ParseException e) {
				if (e == null) {
					textResultado.setText(object.toString());
			    }else {
			    	textResultado.setText(e.getMessage());
			    }
			}
		});
	}
}
