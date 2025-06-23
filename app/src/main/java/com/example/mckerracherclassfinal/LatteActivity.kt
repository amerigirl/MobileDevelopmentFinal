package com.example.mckerracherclassfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LatteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latte)

        val confirmButton = findViewById<Button>(R.id.confirmLatteButton)
        val quantityEditText = findViewById<EditText>(R.id.latteQuantity)

        confirmButton.setOnClickListener {
            val quantity = quantityEditText.text.toString().toIntOrNull() ?: 0
            if (quantity > 0) {
                val orderItem = OrderItem(
                    name = "Vanilla Latte",
                    description = "Smooth espresso with vanilla flavor.",
                    price = 4.50,
                    quantity = quantity,
                    imageRes = R.drawable.latte
                )
                val resultIntent = Intent()
                resultIntent.putExtra("orderItem", orderItem)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
