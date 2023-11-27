package com.example.calculator

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private lateinit var input1:TextInputEditText
    private lateinit var input2:TextInputEditText
    private lateinit var result:TextView

    private lateinit var plusButton:MaterialButton
    private lateinit var minusButton:MaterialButton
    private lateinit var multiplyButton:MaterialButton
    private lateinit var divideButton:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(Color.parseColor("#FF018786"))
        )
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)

        result = findViewById(R.id.result)

        plusButton = findViewById(R.id.plus)
        minusButton = findViewById(R.id.minus)
        multiplyButton = findViewById(R.id.multiply)
        divideButton = findViewById(R.id.divide)

        plusButton.setOnClickListener{
            add()
        }
        minusButton.setOnClickListener {
            subtract()
        }
        multiplyButton.setOnClickListener {
            multiply()
        }
        divideButton.setOnClickListener {
            divide()
        }

    }
    private fun  inputIsNotEmpty():Boolean{
        var b=true;
        if(input1.text.toString().trim().isEmpty()){
            input1.error="Required"
            input1.requestFocus()
            b=false;
        }
        if(input2.text.toString().trim().isEmpty()){
            input2.error="Required"
            input2.requestFocus()
            b=false;
        }
        return  b;
    }
   private fun add(){
        if(inputIsNotEmpty()){
            val inputdata1 = input1.text.toString().trim().toBigDecimal()
            val inputdata2 = input2.text.toString().trim().toBigDecimal()
            result.text = inputdata1.add(inputdata2).toString()
        }
    }
   private fun subtract(){
        if(inputIsNotEmpty()){
            val inputdata1=input1.text.toString().trim().toBigDecimal()
            val inputdata2=input2.text.toString().trim().toBigDecimal()
            result.text=inputdata1.subtract(inputdata2).toString();
        }
    }

  private  fun multiply(){
        if(inputIsNotEmpty()){
            val inputdata1=input1.text.toString().trim().toBigDecimal()
            val inputdata2=input2.text.toString().trim().toBigDecimal()
            result.text=inputdata1.multiply(inputdata2).toString()
        }
    }
    fun divide(){
        if(inputIsNotEmpty()){
            val inputdata1=input1.text.toString().trim().toBigDecimal()
            val inputdata2=input2.text.toString().trim().toBigDecimal()

            if(inputdata2.compareTo(BigDecimal.ZERO)==0){
                input2.error="invalid input"
            }else {
                result.text = inputdata1.divide(inputdata2, 2, RoundingMode.HALF_UP).toString();
            }
        }
    }
}