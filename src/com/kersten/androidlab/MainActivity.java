package com.kersten.androidlab;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ArrayList<HashMap<String, String>> samplesList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		samplesList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> app = new HashMap<String, String>();
		app.put("name", "JSON");
		app.put("description", "Remote JSON call");
		app.put("class", "JsonActivity");
		samplesList.add(app);
		
		app = new HashMap<String, String>();
		app.put("name", "Maps");
		app.put("description", "Sample usage of maps API");
		samplesList.add(app);
		
		
		String[] from = {"name", "description"};
		int[] to = {R.id.mainListItemTitle, R.id.mainListItemDescription};
		
		SimpleAdapter adapter = new SimpleAdapter(this, samplesList, R.layout.main_list_item, from, to);
		
		ListView lv = (ListView) findViewById(R.id.mainList);
		
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				HashMap<String, String> item = samplesList.get(position);
				
				try {
					// Get the class dynamically
					Class<?> cls = Class.forName("com.kersten.androidlab." + item.get("class"));
					Intent intent = new Intent(MainActivity.this, cls);
					
					startActivity(intent);
					
				} catch (ClassNotFoundException e) {
					Toast.makeText(parent.getContext(), "Class: " + item.get("class") + " not found", Toast.LENGTH_LONG).show();
				}

			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
