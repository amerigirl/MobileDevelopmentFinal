package com.example.mckerracherclassfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mckerracherclassfinal.R.id

class MochaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mocha)

        val confirmButton = findViewById<Button>(R.id.confirmMochaButton)
        val quantityEditText = findViewById<EditText>(R.id.mochaQuantity)

        confirmButton.setOnClickListener {
            val quantity = quantityEditText.text.toString().toIntOrNull() ?: 0
            if (quantity > 0) {
                val orderItem = OrderItem(
                    name = "Mocha",
                    description = "Creamy chocolate flavor. Available with whip.",
                    price = 4.50,
                    quantity = quantity,
                    imageRes = R.drawable.mocha
                )
                val resultIntent = Intent()
                resultIntent.putExtra("orderItem", orderItem)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}