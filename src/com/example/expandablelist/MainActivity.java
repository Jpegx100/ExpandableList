package com.example.expandablelist;

import android.support.v7.app.ActionBarActivity;
import android.app.ExpandableListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private String[] listaPai;
	private String[][] listafilho;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView t = (TextView)findViewById(R.id.t);
		Typeface font = Typeface.createFromAsset(getAssets(), "COMIC.TTF");
		t.setTypeface(font);
		LinearLayout l = (LinearLayout)findViewById(R.id.l);
		//l.setBackgroundResource(R.drawable.lago);
		
		ExpandableListView expListView = (ExpandableListView)findViewById(R.id.expListView);
		ImageView img1 = (ImageView) findViewById(R.id.button1);
		ImageView img2 = (ImageView) findViewById(R.id.button2);
		img1.setImageResource(R.drawable.ic_action_new);
		img2.setImageResource(R.drawable.ic_action_new);
		
		String[][] listaFilho = { { "Subcategoria 1", "Subcategoria 2" },
				{ "Subcategoria 3" }, { "Subcategoria 4" } };
		String[] listaPai = { "Categoria 1", "Categoria 2", "Categoria 3" };
		expListView.setAdapter(new MeuAdaptador(this, listaPai, listaFilho, getAssets()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
