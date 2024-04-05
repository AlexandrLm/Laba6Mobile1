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


    private var action = ""
    private var actionCode: Int = 0
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

        btn.isActivated = textForEdit.text.toString() == ""

        actionName.text = action

        btn.setOnClickListener{
            val inputText = textForEdit.text.toString()
            when(actionCode){

                1 ->{
                    val vowelsCount = inputText.count { it in "aeiouyAEIOUY" }
                    val consonantsCount = inputText.count { it in "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ" }
                    val otherSymbolsCount = inputText.length - vowelsCount - consonantsCount
                    resultText.text = "Гласных: $vowelsCount\nСогласных: $consonantsCount\nДругих символов: $otherSymbolsCount"
                }
                2 ->{
                    val wordsCount = inputText.trim().split("\\s+".toRegex()).size
                    resultText.text = "Количество слов: $wordsCount"
                }
                3 ->{
                    val words = inputText.trim().split("\\s+".toRegex())
                    if (words.isNotEmpty()) {
                        val newText = words.drop(1).joinToString(" ")
                        textForEdit.setText(newText)
                    }
                }
            }
        }

        return view
    }
    fun setAction(action: String, actionCode: Int) {
        this.action = action
        this.actionCode = actionCode
    }
}