package com.example.hw8.recycler_view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw8.R

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleAuthorTextView: TextView = itemView.findViewById(R.id.titleAuthorTextView)
    val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    val containerLinearLayout: LinearLayout = itemView.findViewById(R.id.container)

}
