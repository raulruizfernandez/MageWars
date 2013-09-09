package com.camaleon2d.magewars;

import java.util.ArrayList;

import com.camaleon2d.magewars.R;
import com.camaleon2d.objects.Book;
import com.camaleon2d.objects.BookListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	Book libro;
	ArrayList<Book> list_book;
	BookListAdapter adaptador;
	ListView listview_book;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println("MainActivity: ESTAMOS EN onCreate");
        
        setContentView(R.layout.activity_main);
        
        list_book = new ArrayList<Book>(); //Crear el ArrayList
        
        list_book.add(new Book()); // Llenar la lista
        
        listview_book = (ListView) findViewById(R.id.listviewBook); //Relacion
               
        adaptador = new BookListAdapter(this);
        
        adaptador.updateBook(list_book);
        
        listview_book.setAdapter(adaptador);
        
        
    }
    
    protected void onResume() {
        super.onResume();
       
        adaptador.updateBook(list_book);
        
        System.out.println("MainActivity: ESTAMOS EN onResume");
        
       
        listview_book.setOnItemClickListener(new OnItemClickListener() {
        	
			public void onItemClick(AdapterView<?> padre, View vista,
					int posicion_seleccionada,
					long id) {
				
				Book libro_seleccionado = (Book) padre.getAdapter().getItem(posicion_seleccionada);
								
				Intent nuevo_libro = new Intent(MainActivity.this,BookActivity.class);
				
				nuevo_libro.putExtra("libro_seleccionado", libro_seleccionado);
								
				startActivity(nuevo_libro);
								
			}
        	
		});    
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity: ESTAMOS EN onStart");
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity: ESTAMOS EN onPause");
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity: ESTAMOS EN onStop");
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity: ESTAMOS EN onDestroy");
        // The activity is about to be destroyed.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
        
}
