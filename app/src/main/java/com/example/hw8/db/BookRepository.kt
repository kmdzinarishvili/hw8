package com.example.hw8.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.hw8.recycler_view.BookModel

class BookRepository(context: Context) {

    private val database: SQLiteDatabase

    init {
        Log.d("DEB", "init")
        val dbHelper = MyDatabaseHelper(context)
        database = dbHelper.writableDatabase
    }

    fun addBook(title: String, author: String, description: String): Long {
        val values = ContentValues().apply {
            put("title", title)
            put("author", author)
            put("description", description)
        }

        return database.insert("books", null, values)
    }

    fun getAllBooks(): List<BookModel> {
        val bookList = mutableListOf<BookModel>()
        val cursor: Cursor = database.query("books", null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val book = BookModel(
                    id = cursor.getInt(cursor.getColumnIndex("id")),
                    title = cursor.getString(cursor.getColumnIndex("title")),
                    author = cursor.getString(cursor.getColumnIndex("author")),
                    description = cursor.getString(cursor.getColumnIndex("description"))
                )

                bookList.add(book)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return bookList
    }

    fun updateBook(book: BookModel): Int {
        val values = ContentValues().apply {
            put("title", book.title)
            put("author", book.author)
            put("description", book.description)
        }

        return database.update(
            "books",
            values,
            "id = ?",
            arrayOf(book.id.toString())
        )
    }

    fun deleteBook(bookId: Int): Int {
        return database.delete(
            "books",
            "id = ?",
            arrayOf(bookId.toString())
        )
    }
}
