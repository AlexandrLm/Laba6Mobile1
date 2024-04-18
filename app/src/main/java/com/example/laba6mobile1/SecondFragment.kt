package com.example.laba6mobile1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondFragment : Fragment() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val btn = view.findViewById<Button>(R.id.button)
        val textForEdit = view.findViewById<EditText>(R.id.textForEdiText)
        val actionName = view.findViewById<TextView>(R.id.actionNameText)
        val resultText = view.findViewById<TextView>(R.id.resultText)

        btn.setOnClickListener{
            when (actionName.text) {
                "Вывести статистику" -> {
                    val (vowelsCount, consonantsCount, otherCount) = getStatistics(textForEdit.text.toString())
                    resultText.text = "Гласные: $vowelsCount\nСогласные: $consonantsCount\nДругие: $otherCount"
                }
                "Посчитать слова" -> {
                    resultText.text = "Количество слов: ${getWordsCount(textForEdit.text.toString())}"
                }
                "Удалить первое слово" -> {
                    val input = textForEdit.text.toString()
                    val newInput = deleteFirstWord(input)
                    //textForEdit.setText(newInput)
                    //textForEdit.setSelection(newInput.length)
                    resultText.text = newInput
                }
            }
        }
        return view
    }
    fun setText(text: String){
        val view = view?.findViewById<TextView>(R.id.actionNameText)
        view?.text = text
    }
    private fun getStatistics(input: String): Triple<Int, Int, Int> {
        var vowelsCount = 0
        var consonantsCount = 0
        var otherCount = 0

        for (c in input) {
            when (c) {
                in "aeiouyAEIOUY" -> vowelsCount++
                in "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ" -> consonantsCount++
                else -> otherCount++
            }
        }
        return Triple(vowelsCount, consonantsCount, otherCount)
    }
    private fun getWordsCount(input: String): Int {
        if (input.isEmpty()) return 0
        val trimmedInput = input.trim()
        val words = trimmedInput.split("\\s+".toRegex())
        return words.size
    }
    private fun deleteFirstWord(input: String): String {
        if (input.isEmpty()) return ""
        val trimmedInput = input.trim()
        val words = trimmedInput.split("\\s+".toRegex())
        if (words.size == 1) return ""
        val newWords = words.drop(1)
        return newWords.joinToString(" ")
    }
}