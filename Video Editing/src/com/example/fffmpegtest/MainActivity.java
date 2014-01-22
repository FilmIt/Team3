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
		
		
		//s.speed("/storage/extSdCard/Media/testH264.mp4",(float)2,"/storage/extSdCard/Media/fast.mp4");
		//s.merge_vid("/storage/extSdCard/Media/testH264.mp4", "/storage/extSdCard/Media/testH264.mp4","/storage/extSdCard/Media/merged.mp4");
		float ha=s.trim_vid("/storage/extSdCard/Media/testH264.mp4", 3, 10, "/storage/extSdCard/Media/trimmed.mp4");
		
		Log.d("main activity", "Trimming complete");
		//Toast.makeText(getApplicationContext(), "Trimming Complete " + s.trim_vid("/storage/extSdCard/Media/test.mp4", 2, 10),Toast.LENGTH_LONG).show();
		Toast.makeText(getApplicationContext(), "Trimming Complete "+ha,Toast.LENGTH_LONG).show();
		return true;
	}

}

