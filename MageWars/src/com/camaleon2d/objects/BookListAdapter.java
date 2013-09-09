package com.camaleon2d.objects;

import java.util.Collections;
import java.util.List;

import com.camaleon2d.magewars.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BookListAdapter extends BaseAdapter {

    private List<Book> list_book = Collections.emptyList();

    private final Context context;
    
    // the context is needed to inflate views in getView()
    public BookListAdapter(Context context) {
        this.context = context;
    }

    public void updateBook(List<Book> new_list_book) {
    	ThreadPreconditions.checkOnMainThread();
        this.list_book = new_list_book;
        notifyDataSetChanged();
    }

    public int getCount() {
        return list_book.size();
    }

    // getItem(int) in Adapter returns Object but we can override
    // it to BananaPhone thanks to Java return type covariance
    @Override
    public Book getItem(int position) {
        return list_book.get(position);
    }

    // getItemId() is often useless, I think this should be the default
    // implementation in BaseAdapter
    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
    	    	
    	if (convertView == null) {
    		
    		convertView = LayoutInflater.from(context).inflate(R.layout.listview_book, parent, false);

    	}

    	TextView listview_titulo = (TextView) convertView.findViewById(R.id.opcionLibro_titulo);

        Book libro_seleccionado = getItem(position);
       
        listview_titulo.setText(libro_seleccionado.getTitulo());

        return convertView;

    }
    
}
