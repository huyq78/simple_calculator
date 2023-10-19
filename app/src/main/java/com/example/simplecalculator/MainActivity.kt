package com.example.simplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number1 = "0"
    private var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//    Action Buttons
        binding.CEBtn.setOnClickListener { binding.TextResult.text = "0" }
        binding.CBtn.setOnClickListener { handleClickClearBtn() }
        binding.BSBtn.setOnClickListener { handleClickBackspaceBtn() }
        binding.MinusBtn.setOnClickListener { handleClickOperatorBtn("-") }
        binding.MulBtn.setOnClickListener { handleClickOperatorBtn("*") }
        binding.DivBtn.setOnClickListener { handleClickOperatorBtn("/") }
        binding.AddBtn.setOnClickListener { handleClickOperatorBtn("+") }
        binding.ChangeBtn.setOnClickListener { handleClickChaneBtn() }
        binding.ResultBtn.setOnClickListener { handleClickResultBtn() }

//    Number Buttons
        binding.Number0.setOnClickListener { handleClickNumberBtn("0") }
        binding.Number1.setOnClickListener { handleClickNumberBtn("1") }
        binding.Number2.setOnClickListener { handleClickNumberBtn("2") }
        binding.Number3.setOnClickListener { handleClickNumberBtn("3") }
        binding.Number4.setOnClickListener { handleClickNumberBtn("4") }
        binding.Number5.setOnClickListener { handleClickNumberBtn("5") }
        binding.Number6.setOnClickListener { handleClickNumberBtn("6") }
        binding.Number7.setOnClickListener { handleClickNumberBtn("7") }
        binding.Number8.setOnClickListener { handleClickNumberBtn("8") }
        binding.Number9.setOnClickListener { handleClickNumberBtn("9") }

    }

    private fun handleClickNumberBtn(number: String) {
        val textResult = binding.TextResult
        if (textResult.text.toString().compareTo("0") == 0) {
            if (number.compareTo("0") != 0) {
                textResult.text = number
            }
        } else {
            val newResult = textResult.text.toString().plus(number)
            textResult.text = newResult
        }

    }

    private fun handleClickOperatorBtn(clickedBtn: String) {
        number1 = binding.TextResult.text.toString()
        binding.TextResult.text = "0"
        operator = clickedBtn
    }

    private fun handleClickResultBtn() {
        if (operator.compareTo("/") == 0 && binding.TextResult.text.toString().toInt() == 0) {
            return
        }

        val result = when (operator) {
            "+" -> number1.toInt() + binding.TextResult.text.toString().toInt()
            "-" -> number1.toInt() - binding.TextResult.text.toString().toInt()
            "*" -> number1.toInt() * binding.TextResult.text.toString().toInt()
            "/" -> number1.toInt() / binding.TextResult.text.toString().toInt()
            else -> binding.TextResult.text.toString().toInt()
        }
        binding.TextResult.text = result.toString()
        number1 = "0"

    }

    private fun handleClickClearBtn() {
        number1 = ""
        operator = ""
        binding.TextResult.text = "0"
    }

    private fun handleClickBackspaceBtn() {
        if (binding.TextResult.text.toString().length == 1) {
            binding.TextResult.text = "0"
        } else {
            binding.TextResult.text = binding.TextResult.text.toString().dropLast(1)
        }
    }

    private fun handleClickChaneBtn() {
        val result = 0 - binding.TextResult.text.toString().toInt()
        binding.TextResult.text = result.toString()
    }
}



