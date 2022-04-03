package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var op: String
    
    private var numOne: Double = 0.0
    private var numTwo: Double = 0.0
    private var resultNum: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clearer() {
        result.text = ""
        op = ""

        numOne = 0.0
        numTwo = 0.0
        resultNum = 0.0
    }

    fun numsFinder(button: Button) {
        if (result.text == "0") {
            result.text = ""
        }
        val oldNum = result.text.toString()

        val newNum = button.text.toString()

        result.text = oldNum + newNum
    }

    fun operatorFinder(button: Button) {
        val numOne = result.text.toString().toDouble()
        
        val op = button.text.toString()
    }

    fun doneCalc(button: Button) {
        val numTwo = result.text.toString().toDouble()

        when (op) {
            "-" -> resultNum = numOne - numTwo
            "+" -> resultNum = numOne + numTwo
            "*" -> resultNum = numOne * numTwo
            "/" -> resultNum = numOne / numTwo
        }
        result.text = resultNum.toString()
    }
}
