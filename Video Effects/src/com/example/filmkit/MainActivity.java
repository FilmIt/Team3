package com.example.filmkit;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String srcPath = "";
		String desPath = "";
		int intensity = 0;
		float intensityF = 0;
		Video.flea(srcPath,desPath);
		Video.tint(srcPath,desPath,intensity);
		Video.grayScale(srcPath,desPath);
		Video.pixelate(srcPath,desPath,intensity);//range from 0 to 100
		Video.invert(srcPath,desPath);
		Video.changeContrast(srcPath,desPath,intensityF);
		Video.changeBrightness(srcPath,desPath,intensity);
		Video.changeOpacity(srcPath,desPath,intensity); //range from 0 to 255
		Toast.makeText(getApplicationContext(), "DONE",Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
