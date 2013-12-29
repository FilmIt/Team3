package com.example.fffmpegtest;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Functions s= new Functions();
			//s.speed("/storage/extSdCard/Media/test.mp4",(float)0.5,"/storage/extSdCard/Media/out.mp4");
		//s.merge_vid("/storage/extSdCard/Media/test.mp4", "/storage/extSdCard/Media/test.mp4",/storage/extSdCard/Media/out.mp4");
		//s.trim_vid("/storage/extSdCard/Media/test.mp4", 1, 2,"/storage/extSdCard/Media/out.mp4");
		Log.d("main activity", "Trimming complete");
		Toast.makeText(getApplicationContext(), "Trimming Complete " + s.trim_vid("/storage/extSdCard/Media/test.mp4", 1, 2),Toast.LENGTH_LONG).show();
		return true;
	}

}
