package com.example.words.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.words.adapter.WordAdapter
import com.example.words.data.Datasource
import com.example.words.databinding.FragmentLetterListBinding
import com.example.words.databinding.FragmentWordListBinding
import com.example.words.fragments.WordListFragment.Companion.LETTER

class WordListFragment : Fragment() {
  companion object {
    const val LETTER = "letter"
    const val SEARCH_PREFIX = "https://www.google.com/search?q="
  }

  private var _binding: FragmentWordListBinding? = null
  private val binding get() = _binding!!
  private lateinit var recyclerView: RecyclerView


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentWordListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    recyclerView = binding.wordsRecyclerView
    val letterId = activity?.intent?.extras?.getChar(LETTER)
    val myDataset = Datasource().loadWords(letterId ?: 'a')
    recyclerView.adapter = WordAdapter(this.requireContext(), myDataset)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}