package com.example.hw8.recycler_view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw8.R

class BookAdapter(private val dataList: List<BookModel>) : RecyclerView.Adapter<BookViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.book_view, parent, false)
            return BookViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            val book = dataList[position]

            holder.titleAuthorTextView.text = "${book.title} by ${book.author}"
            holder.descriptionTextView.text = book.description

            val randomBackgroundColor = getRandomColor()
            holder.containerLinearLayout.setBackgroundColor(randomBackgroundColor)

            val textColor = generateTextColor(randomBackgroundColor)

            holder.titleAuthorTextView.setTextColor(textColor)
            holder.descriptionTextView.setTextColor(textColor)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        private fun getRandomColor(): Int {
            val random = java.util.Random()
            return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        }

        private fun generateTextColor(backgroundColor: Int): Int {
            val redComponent = Color.red(backgroundColor)
            val greenComponent = Color.green(backgroundColor)
            val blueComponent = Color.blue(backgroundColor)
            val luminance: Double = (0.299 * redComponent + 0.587 * greenComponent+ 0.114 * blueComponent) / 255

            return if (luminance > 0.5) Color.WHITE else Color.BLACK
        }


}