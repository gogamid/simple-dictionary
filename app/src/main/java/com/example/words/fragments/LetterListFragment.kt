package com.example.words.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.words.R
import com.example.words.adapter.LetterAdapter
import com.example.words.data.Datasource
import com.example.words.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
  private var _binding: FragmentLetterListBinding? = null
  private val binding get() = _binding!!
  private lateinit var recyclerView: RecyclerView
  private var isLinearLayoutManager = true
  private lateinit var myDataset: List<Char>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentLetterListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    recyclerView = binding.recyclerView
    myDataset = Datasource().loadLetters()
    chooseLayout()
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.layout_menu, menu)

    val layoutButton = menu.findItem(R.id.action_switch_layout)
    setIcon(layoutButton)
  }

  private fun setIcon(menuItem: MenuItem?) {
    if (menuItem == null)
      return

    menuItem.icon =
      if (isLinearLayoutManager)
        ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
      else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
  }

  private fun chooseLayout() {
    if (isLinearLayoutManager) {
      recyclerView.layoutManager = LinearLayoutManager(context)
    } else {
      recyclerView.layoutManager = GridLayoutManager(context, 4)
    }
    recyclerView.adapter = LetterAdapter(this.requireContext(), myDataset)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
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