package com.example.words.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.words.R

class WordAdapter(
  private val context: Context,
  private val dataset: List<String>
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

  class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val button: Button = view.findViewById(R.id.word_button)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
    val adapterLayout =
      LayoutInflater.from(parent.context).inflate(R.layout.word_item, parent, false)
    return WordViewHolder(adapterLayout)
  }

  override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
    holder.button.text = dataset[position]
  }

  override fun getItemCount(): Int = dataset.size
}


