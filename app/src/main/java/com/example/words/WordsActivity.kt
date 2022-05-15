package com.example.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.words.adapter.LetterAdapter
import com.example.words.adapter.WordAdapter
import com.example.words.data.Datasource

class WordsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_words)

    val letterId = intent?.extras?.getChar("letter")
    val myDataset = Datasource().loadWords(letterId ?: 'a')
    val recyclerView = findViewById<RecyclerView>(R.id.words_recycler_view)
    recyclerView.adapter = WordAdapter(this, myDataset)
    recyclerView.setHasFixedSize(true)
  }
}