package com.example.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.words.adapter.LetterAdapter
import com.example.words.data.Datasource

class LettersActivity : AppCompatActivity() {
  private var isLinearLayoutManager = true
  private lateinit var recyclerView: RecyclerView
  private lateinit var myDataset: List<Char>
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_letters)

    myDataset = Datasource().loadLetters()
    recyclerView = findViewById(R.id.recycler_view)
    chooseLayout()
    recyclerView.setHasFixedSize(true)

  }

  private fun chooseLayout() {
    if (isLinearLayoutManager) {
      recyclerView.layoutManager = LinearLayoutManager(this)
    } else {
      recyclerView.layoutManager = GridLayoutManager(this, 4)
    }
    recyclerView.adapter = LetterAdapter(this, myDataset)
  }

  private fun setIcon(menuItem: MenuItem?) {
    if (menuItem == null)
      return

    menuItem.icon =
      if (isLinearLayoutManager)
        ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
      else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.layout_menu, menu)

    val layoutButton = menu?.findItem(R.id.action_switch_layout)
    setIcon(layoutButton)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_switch_layout -> {
        isLinearLayoutManager = !isLinearLayoutManager
        chooseLayout()
        setIcon(item)
        return true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}