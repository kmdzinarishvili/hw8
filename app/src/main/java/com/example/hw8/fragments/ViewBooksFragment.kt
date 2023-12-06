package com.example.hw8.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw8.recycler_view.BookAdapter
import com.example.hw8.recycler_view.BookModel
import com.example.hw8.R
import com.example.hw8.db.BookRepository

class ViewBooksFragment() : Fragment() {

    private lateinit var bookRepository: BookRepository
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookRepository = BookRepository(requireContext())

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val books = bookRepository.getAllBooks();
        bookAdapter = BookAdapter(books)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookAdapter
        }

    }

}
