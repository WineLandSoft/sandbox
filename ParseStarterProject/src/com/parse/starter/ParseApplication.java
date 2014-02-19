package com.parse.starter;

import java.util.HashMap;

import com.parse.FunctionCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCloud;
import com.parse.ParseException;

import com.parse.ParseUser;

import android.app.Application;
import android.widget.Toast;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "oCCuj30u6ioRVSblikwOaCNYGYGxU94vtkYKpyg7", "OxyQlcfgMNxDPyBkbHNxjG7BNtghE6ZDJNRhm5On");

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
