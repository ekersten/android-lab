package com.kersten.androidlab;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JsonActivity extends Activity {

	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);

		Button clickBtn = (Button) findViewById(R.id.clickBtn);
		clickBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				progressDialog = ProgressDialog.show(JsonActivity.this, "", "Loading...");
				
				new Thread(){
					public void run(){
						try{
							sleep(3000);
						} catch (Exception e) {
							Log.e("tag", e.getMessage());
						}
						
						progressDialog.dismiss();
					}
				}.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_json, menu);
		return true;
	}

}
