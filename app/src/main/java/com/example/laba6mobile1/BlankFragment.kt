package com.example.laba6mobile1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class BlankFragment : Fragment() {
    internal interface OnFragmentSendDataListener {
        fun onSendData(data : String)
    }

    private var sendDataListener: OnFragmentSendDataListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            sendDataListener = context as OnFragmentSendDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() + " не " +
                        "реализует интерфейс OnFragmentSendDataListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val button1 = view.findViewById<Button>(R.id.statButton)
        val button2 = view.findViewById<Button>(R.id.countButton)
        val button3 = view.findViewById<Button>(R.id.deleteButton)


        val listener = View.OnClickListener { view -> // получаем выбранный текст
            val text = (view as Button).getText().toString()
            // Посылаем данные Activity
            sendDataListener!!.onSendData(text)
        }
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        return view
    }
}