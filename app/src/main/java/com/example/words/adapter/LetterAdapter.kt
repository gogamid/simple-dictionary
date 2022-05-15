package com.example.words.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.words.R
import com.example.words.WordsActivity

class LetterAdapter(
  private val context: Context,
  private val dataset: List<Char>
) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

  class LetterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val button: Button = view.findViewById(R.id.letter_button)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.letter_item, parent, false)
    return LetterViewHolder(adapterLayout)
  }

  override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
    val item = dataset[position]
    holder.button.text = item.toString()
    holder.button.setOnClickListener {
      val intent = Intent(context, WordsActivity::class.java)
      intent.putExtra("letter", holder.button.text[0])
      context.startActivity(intent)
    }
  }

  override fun getItemCount(): Int = dataset.size
}