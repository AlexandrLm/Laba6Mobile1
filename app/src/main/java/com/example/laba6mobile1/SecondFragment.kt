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

        btn.isActivated = textForEdit.text.toString() == ""

        return view
    }
    fun setText(text: String){
        val view = view?.findViewById<TextView>(R.id.actionNameText)
        view?.text = text
    }
}