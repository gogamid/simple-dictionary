package com.example.words.data

class Datasource {
  val words = "abandon\n" +
      "abbey\n" +
      "able\n" +
      "abnormal\n" +
      "abolish\n" +
      "abortion\n" +
      "baby\n" +
      "back\n" +
      "background\n" +
      "bacon\n" +
      "bad\n" +
      "bag\n" +
      "cabin\n" +
      "cabinet\n" +
      "cable\n" +
      "cafe\n" +
      "cage\n" +
      "cake\n" +
      "dairy\n" +
      "damage\n" +
      "damn\n" +
      "dance\n" +
      "danger\n" +
      "dangerous\n" +
      "eagle\n" +
      "ear\n" +
      "earthquake\n" +
      "east\n" +
      "easy\n" +
      "eat\n" +
      "fabricate\n" +
      "facade\n" +
      "face\n" +
      "facility\n" +
      "factor\n" +
      "gaffe\n" +
      "gain\n" +
      "galaxy\n" +
      "gallery\n" +
      "gallon\n" +
      "game\n" +
      "habit\n" +
      "habitat\n" +
      "hair\n" +
      "haircut\n" +
      "half\n" +
      "hall\n" +
      "ice\n" +
      "ice cream\n" +
      "idea\n" +
      "ideal\n" +
      "identification\n" +
      "jacket\n" +
      "jail\n" +
      "jam\n" +
      "keep\n" +
      "kettle\n" +
      "key\n" +
      "kick\n" +
      "laboratory\n" +
      "laborer\n" +
      "labour\n" +
      "lace\n" +
      "lack\n" +
      "machinery\n" +
      "magazine\n" +
      "magnetic\n" +
      "magnitude\n" +
      "maid\n" +
      "nail\n" +
      "name\n" +
      "nap\n" +
      "narrow\n" +
      "oak\n" +
      "obese\n" +
      "object\n" +
      "objective\n" +
      "obligation\n" +
      "pace\n" +
      "pack\n" +
      "package\n" +
      "packet\n" +
      "page\n" +
      "qualification\n" +
      "qualified\n" +
      "qualify\n" +
      "quality\n" +
      "rabbit\n" +
      "race\n" +
      "racism\n" +
      "rack\n" +
      "radiation\n" +
      "sacred\n" +
      "sacrifice\n" +
      "safari\n" +
      "safe\n" +
      "safety\n" +
      "table\n" +
      "tablet\n" +
      "tactic\n" +
      "tail\n" +
      "take\n" +
      "talented\n" +
      "unanimous\n" +
      "unaware\n" +
      "uncertainty\n" +
      "uncle\n" +
      "vacuum\n" +
      "vague\n" +
      "vain\n" +
      "valid\n" +
      "valley\n" +
      "value\n" +
      "wage\n" +
      "wagon\n" +
      "waist\n" +
      "wait\n" +
      "waiter\n" +
      "x-ray\n" +
      "yard\n" +
      "year\n" +
      "zero\n" +
      "zone\n" +
      "zebra"

  fun loadLetters(): List<Char> {
    val alphabet = mutableListOf<Char>()
    var c = 'a' //set the 1st character
    for (i in 0..25)
      alphabet.add(c++)
    return alphabet
  }

  fun loadWords(letter: Char): List<String> {
    return words
      .trim()
      .splitToSequence('\n')
      .filter { it[0] == letter }
      .toList()
  }
}
