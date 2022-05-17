package com.example.words.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.words.R
import com.example.words.fragments.WordListFragment

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
    val item = dataset[position]
    holder.button.text = item
    holder.button.setOnClickListener {
      val queryUrl: Uri = Uri.parse("${WordListFragment.SEARCH_PREFIX}${item}")
      val intent = Intent(Intent.ACTION_VIEW, queryUrl)
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int = dataset.size
}


