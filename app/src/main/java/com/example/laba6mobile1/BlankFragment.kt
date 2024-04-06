package com.example.laba6mobile1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup

class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val button1 = view.findViewById<Button>(R.id.statButton)
        val button2 = view.findViewById<Button>(R.id.countButton)
        val button3 = view.findViewById<Button>(R.id.deleteButton)

        return view
    }
}