package com.example.pruebalibreria;

import java.util.List;

import com.google.gdata.data.spreadsheet.SpreadsheetEntry;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView mostrar;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	  mostrar = (TextView)findViewById(R.id.textView1);
		
		try {
				MySpreadSheetIntegration objeGSS = new MySpreadSheetIntegration();
				List<SpreadsheetEntry> spreadsheets = objeGSS.conexionGSS();
				
				 for (SpreadsheetEntry sheet : spreadsheets) {
				      // Print the title of this spreadsheet to the screen
				      System.out.println(sheet.getTitle().getPlainText());
				      mostrar.append(sheet.getTitle().toString());
				    }

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
