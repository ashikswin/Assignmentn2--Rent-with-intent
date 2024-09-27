package com.ashikurrahman.rentwithintentapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail1)

        // Retrieve the Instrument object passed via intent
        val instrument = intent.getParcelableExtra<Instrument>("instrument")

        // Update views with the instrument details
        val imageView = findViewById<ImageView>(R.id.detailImage)
        val nameTextView = findViewById<TextView>(R.id.detailName)
        val priceTextView = findViewById<TextView>(R.id.detailPrice)

        instrument?.let {
            imageView.setImageResource(it.imageResId)
            nameTextView.text = it.name
            priceTextView.text = it.price
        }

        // "Save" button action
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener {
            // Display a success toast
            Toast.makeText(this, "Instrument saved successfully!", Toast.LENGTH_SHORT).show()

            // Set the result to indicate that the booking was successful
            setResult(Activity.RESULT_OK)

            // Close the activity and return to MainActivity
            finish()
        }

        // "Cancel" button action
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            // Display a cancellation toast
            Toast.makeText(this, "Booking cancelled!", Toast.LENGTH_SHORT).show()

            // Set the result to indicate that the booking was cancelled
            setResult(Activity.RESULT_CANCELED)

            // Close the activity and return to MainActivity
            finish()
        }
    }
}
