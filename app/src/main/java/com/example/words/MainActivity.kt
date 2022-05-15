package com.example.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.words.adapter.LetterAdapter
import com.example.words.data.Datasource

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val myDataset = Datasource().loadLetters()
    val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
    recyclerView.adapter = LetterAdapter(this, myDataset)
    recyclerView.setHasFixedSize(true)
  }
}