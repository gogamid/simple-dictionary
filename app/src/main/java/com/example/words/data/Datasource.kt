package com.example.words.data

class Datasource {
  fun loadLetters(): List<Char> {
    val alphabet = mutableListOf<Char>()
    var c = 'A' //set the 1st character
    for(i in 0..25)
      alphabet.add(c++)
    return alphabet
  }
}