package com.example.hw8.fragments

import com.example.hw8.db.BookRepository
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hw8.R
import com.google.android.material.internal.ViewUtils.hideKeyboard

class AddBookFragment() : Fragment() {

    private lateinit var bookRepository: BookRepository
    private lateinit var addButton: Button
    private lateinit var titleEditText:EditText
    private lateinit var authorEditText:EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookRepository = BookRepository(requireContext())
        addButton = view.findViewById(R.id.addButton)
        titleEditText = view.findViewById(R.id.titleEditText)
        authorEditText = view.findViewById(R.id.authorEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val author = authorEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val bookId = bookRepository.addBook(title, author, description)
            if(bookId>-1){
                clearEdits()
                hideKeyboard(it)
                Toast.makeText(context, "Book Successfully Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEdits(){
        titleEditText.setText("")
        authorEditText.setText("")
        descriptionEditText.setText("")
    }
}
