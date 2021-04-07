package com.falanper.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var number1: Float = 0.0f
    private var isPlus: Boolean = false
    private var isMinus: Boolean = false
    private var isDivision: Boolean = false
    private var isMultiplication: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.number_edit_text)
    }

    fun operationFunction(view: View) {
        when (view.id) {
            R.id.button_one -> numberClicked(1)
            R.id.button_two -> numberClicked(2)
            R.id.button_three -> numberClicked(3)
            R.id.button_four -> numberClicked(4)
            R.id.button_five -> numberClicked(5)
            R.id.button_six -> numberClicked(6)
            R.id.button_seven -> numberClicked(7)
            R.id.button_eight -> numberClicked(8)
            R.id.button_nine -> numberClicked(9)
            R.id.button_zero -> numberClicked(0)
            R.id.button_dot -> {
                val number = editText.text.toString() + "."
                editText.setText(number)
            }
            R.id.button_clear -> {
                editText.setText("")
            }
            R.id.button_plus -> {
                plus()
            }
            R.id.button_minus -> {
                minus()
            }
            R.id.button_multiplication -> {
                multiplication()
            }
            R.id.button_division -> {
                division()
            }
            R.id.button_equals -> {
                var result = 0.0f
                val number2 = editText.text.toString().toFloat()
                when {
                    isPlus -> {
                        result = number1 + number2
                        isPlus = false
                    }
                    isMinus -> {
                        result = number1 - number2
                        isMinus = false
                    }
                    isMultiplication -> {
                        result = number1 * number2
                        isMultiplication = false
                    }
                    isDivision -> {
                        result = number1 / number2
                        isDivision = false
                    }
                }
                editText.setText(result.toString())
            }
        }
    }

    private fun numberClicked(numberClicked: Int) {
        val number = editText.text.toString() + numberClicked.toString()
        editText.setText(number)
    }

    private fun setNumber1() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
    }

    private fun plus() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
        isPlus = true
    }

    private fun minus() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
        isMinus = true
    }

    private fun multiplication() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
        isMultiplication = true
    }

    private fun division() {
        number1 = editText.text.toString().toFloat()
        editText.setText("")
        isDivision = true
    }
}