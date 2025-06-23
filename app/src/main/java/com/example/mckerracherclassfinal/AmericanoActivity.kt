package com.example.mckerracherclassfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AmericanoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_americano)
        setContentView(R.layout.activity_americano)

        val confirmButton = findViewById<Button>(R.id.confirmAmericanoButton)
        val quantityEditText = findViewById<EditText>(R.id.americanoQuantity)

        confirmButton.setOnClickListener {
            val quantity = quantityEditText.text.toString().toIntOrNull() ?: 0
            if (quantity > 0) {
                val orderItem = OrderItem(
                    name = "Americano",
                    description = "The strong, classic pick-me-up!.",
                    price = 4.50,
                    quantity = quantity,
                    imageRes = R.drawable.americano
                )
                val resultIntent = Intent()
                resultIntent.putExtra("orderItem", orderItem)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}