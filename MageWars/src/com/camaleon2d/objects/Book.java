package com.camaleon2d.objects;

import android.os.Parcel;
import android.os.Parcelable;


public class Book implements Parcelable {
    
	private String titulo;

	public String toString () { return this.titulo; }
	public void setTitulo (String titulo_nuevo) { this.titulo = titulo_nuevo; }
	public String getTitulo () { return this.titulo; }
    
	
	
	public Book() {	
		this.titulo = "Nuevo Libro";
	}
	
    private Book(Parcel in) {
    	this.titulo = "Nuevo Libro";
    	readFromParcel(in);
    } 
	
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.titulo);
    }
    
    public void readFromParcel(Parcel in) {
    	this.titulo = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR
            = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    
}


	

	
	
	

	

