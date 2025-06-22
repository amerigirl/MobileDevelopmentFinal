package com.example.mckerracherclassfinal

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mckerracherclassfinal.R.id.main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the reference for the button
        val placeOrderButton = findViewById<Button>(R.id.placeOrderButton)
        // Register the button for context menu
        registerForContextMenu(placeOrderButton)
    }

    // Inflate context menu
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.setHeaderTitle("Select Coffee Type")
        menu.add(0, v.id, 0, "Latte")
        menu.add(0, v.id, 1, "Mocha")
        menu.add(0, v.id, 2, "Americano")
    }

    // Handle context menu item selection
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.order) {
            0 -> {
                // Start LatteActivity
                val intent = Intent(this, LatteActivity::class.java)
                startActivity(intent)
                true
            }
            1 -> {
                // Start MochaActivity
                val intent = Intent(this, MochaActivity::class.java)
                startActivity(intent)
                true
            }
            2 -> {
                // Start AmericanoActivity
                val intent = Intent(this, AmericanoActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
