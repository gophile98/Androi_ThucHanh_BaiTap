package com.example.student.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    //Contruster
    public DBHelper(@Nullable Context context) {
        super(context, "dbdemo.sqlite", null   ,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Author(id primary key ,name text, address text, email text)");
        db.execSQL("create table Book(id_book primary key, title text, id_author integer constraint id references Author(id)on delete cascade on update cascade) ");

    }
    //Ktra trung bang.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Author");
        db.execSQL("drop table if exists Book");
        onCreate(db);

    }
    //Them du lieu bang Author
    public int insertAuthor(Author author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", author.getId());
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());

        int result = (int) db.insert("Author", null, contentValues);
        db.close();
        return result;
    }

    //Them du lieu bang Book
    public int insertBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id_book", book.getId_book());
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_author());

        int result = (int) db.insert("Book", null, contentValues);
        db.close();
        return result;
    }
    //Lay toan bo du lieu bang Author
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Author", null);
        if(cursor != null){
            cursor.moveToFirst();
        }while (cursor.isAfterLast() == false){
            list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;

    }
    //Lay toan bo du lieu o bang Book
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Book", null);
        if (cursor != null){
            cursor.moveToFirst();
        }while (cursor.isAfterLast() == false){
            list.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    //Tim kiem Author theo id
    public ArrayList<Author> getIdAuthor(int id){
        ArrayList<Author> list = new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors where id ="+id, null);
        if (cursor != null){
            cursor.moveToFirst();
        }while (cursor.isAfterLast() == false){
            list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();

        }
        cursor.close();
        db.close();
        return list;
    }
    //Tim kiem Book theo id
    public ArrayList<Book> getIdBook(int id_book){
        ArrayList<Book> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors where id ="+id_book, null);
        if (cursor != null){
            cursor.moveToFirst();
        }while (cursor.isAfterLast() == false){
            list.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    //Xoa Author theo id
    public boolean deleteAuthor(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        if(db.delete("Author", "id"+"=?", new String[]{String.valueOf(id)})>0){
            db.close();
            return  true;
        }
        return false;
    }
    //Xoa Book theo id
    public boolean deleteBook(int id_book){
        SQLiteDatabase db = this.getWritableDatabase();
        if (db.delete("Book", "id_book"+"=?", new String[]{String.valueOf(id_book)})>0){
            db.close();
            return true;
        }
        return false;
    }

    //Update Author theo id
    public boolean updateAuthor(int id, String name, String address, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("email", email);

        db.update("Author", contentValues, "id="+id, null);
        return true;
    }

    //Update Book theo id
    public boolean updateBook(int id_book, String title, int id_author){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_book", id_book);
        contentValues.put("title", title);
        contentValues.put("id_author", id_author);

        db.update("Book", contentValues, "id="+id_book, null);
        return true;
    }


}
