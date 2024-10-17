package com.hfad.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hfad.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var expression: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.result.text = "0"

        // Clear all
        binding.ac.setOnClickListener {
            expression = ""
            binding.data.text = ""
            binding.result.text = "0"
        }


        binding.seven.setOnClickListener { appendToExpression("7") }
        binding.eight.setOnClickListener { appendToExpression("8") }
        binding.nine.setOnClickListener { appendToExpression("9") }
        binding.four.setOnClickListener { appendToExpression("4") }
        binding.five.setOnClickListener { appendToExpression("5") }
        binding.six.setOnClickListener { appendToExpression("6") }
        binding.one.setOnClickListener { appendToExpression("1") }
        binding.two.setOnClickListener { appendToExpression("2") }
        binding.three.setOnClickListener { appendToExpression("3") }
        binding.zero.setOnClickListener { appendToExpression("0") }

        binding.plus.setOnClickListener { appendToExpression("+") }
        binding.minus.setOnClickListener { appendToExpression("-") }
        binding.multiply.setOnClickListener { appendToExpression("*") }
        binding.divide.setOnClickListener { appendToExpression("/") }
        binding.dot.setOnClickListener { appendToExpression(".") }


        binding.openBracket.setOnClickListener {
            appendToExpression("(")
        }
        binding.closeBracket.setOnClickListener {
            appendToExpression(")")
        }

        binding.equal.setOnClickListener {
            calculateResult()
        }
    }

    //to append text to the expression and update the UI
    private fun appendToExpression(value: String) {
        expression += value
        binding.data.text = expression
    }

    //evaluate the expression using Exp4j
    private fun calculateResult() {
        try {
            // Using Exp4j to evaluate the expression
            val result = ExpressionBuilder(expression).build().evaluate()

            // Display the result
            binding.result.text = result.toString()
        } catch (e: Exception) {
            // In case of error in the expression, display an error message
            binding.result.text = "Error"
        }
    }
}
