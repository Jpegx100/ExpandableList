package com.example.expandablelist;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MeuAdaptador extends BaseExpandableListAdapter{
	private Context context;
	
	private String[] listaPai;
	private String[][] listafilho;
	private AssetManager asst;
	public MeuAdaptador(Context context, String[] listaPai, String[][] listafilho, AssetManager ass) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listafilho = listafilho;
		this.listaPai = listaPai;
		this.asst = ass;
	}
	
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return listaPai.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return listafilho[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return listaPai[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return listafilho[groupPosition][childPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		LinearLayout ln = new LinearLayout(context);
		
		ImageView img = new ImageView(context);
		img.setImageResource(R.drawable.ic_action_person);
		TextView textViewCategorias = new TextView(context);
		textViewCategorias.setText(listaPai[groupPosition]);
		textViewCategorias.setPadding(50, 5, 0, 5);
		Typeface font = Typeface.createFromAsset(asst, "COMIC.TTF");  
		textViewCategorias.setTypeface(font);
		// Definimos o tamanho do texto
		textViewCategorias.setTextSize(20);
		// Definimos que o texto estará em negrito
		textViewCategorias.setTypeface(null, Typeface.BOLD);
		
		ln.setOrientation(LinearLayout.HORIZONTAL);
		ln.addView(textViewCategorias);
		ln.addView(img);
		return ln;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		TextView textViewSubLista = new TextView(context);
		textViewSubLista.setText(listafilho[groupPosition][childPosition]);
		textViewSubLista.setPadding(10, 5, 0, 5);
		
		LinearLayout ln = new LinearLayout(context);
		ln.addView(textViewSubLista);
		if(listafilho[groupPosition][childPosition].contains("1")) ln.setBackgroundColor(Color.RED);
		else if(listafilho[groupPosition][childPosition].contains("2")) ln.setBackgroundColor(Color.BLUE);
		else ln.setBackgroundColor(Color.GREEN);
		return ln;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
