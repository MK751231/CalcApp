package jp.techacademy.masato.koshikawa.calcapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

const val PLUS = 1
const val MINUS = 2
const val MULTIPLY = 3
const val DIVIDE = 4

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_first.setOnClickListener(this)
        button_second.setOnClickListener(this)
        button_third.setOnClickListener(this)
        button_fourth.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_first -> caluclation(PLUS)
            R.id.button_second -> caluclation(MINUS)
            R.id.button_third -> caluclation(MULTIPLY)
            R.id.button_fourth -> caluclation(DIVIDE)
        }
    }

    private fun caluclation(operator: Int) {
        if (edittext_first.length() == 0 || edittext_second.length() == 0) {
            Log.d("UI_PARTS", "数字が入力されていません")
        } else {
            val num1 = edittext_first.text.toString().toDouble()
            val num2 = edittext_second.text.toString().toDouble()
            var total: Double = 0.0
            when (operator) {
                PLUS -> {
                    total = num1 + num2
                }
                MINUS -> {
                    total = num1 - num2
                }
                MULTIPLY -> {
                    total = num1 * num2
                }
                DIVIDE -> {
                    if (num2 == 0.0) {
                        Log.d("UI_PARTS", "割り算では2つ目の数字には0以外を入力してください")
                    } else {
                        total = num1 / num2
                    }
                }
            }
            Log.d("UI_PARTS", total.toString())

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", total.toString())
            startActivity(intent)
        }
    }
}

