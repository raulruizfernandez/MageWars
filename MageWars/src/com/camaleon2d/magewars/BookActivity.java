package com.camaleon2d.magewars;

import java.util.ArrayList;

import com.camaleon2d.objects.Book;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class BookActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_book);
		
		TextView titulo_libro = (TextView) findViewById(R.id.BOOK_titulo);
				
		Book libro_seleccionado = getIntent().getExtras().getParcelable("libro_seleccionado");
			
		libro_seleccionado.setTitulo("Titulo");
		
		titulo_libro.setText(libro_seleccionado.getTitulo());
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.book, menu);
		return true;
	}

}
