package com.ashikurrahman.rentwithintentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import android.widget.RatingBar

class MainActivity : AppCompatActivity() {

    // Ensure that price is a String, imageResId is an Int (drawable resource), and the rest are correct types.
    private val instruments = listOf(
        Instrument(R.drawable.sample_instrument, "Drum Set", "300 credits", 4.0f, true),
        Instrument(R.drawable.sample_instrument_2, "Guitar", "150 credits", 4.5f, false),
        Instrument(R.drawable.sample_instrument_3, "Piano", "500 credits", 5.0f, true)
    )
    private var currentInstrumentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showInstrumentDetails(instruments[currentInstrumentIndex])

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            currentInstrumentIndex = (currentInstrumentIndex + 1) % instruments.size
            showInstrumentDetails(instruments[currentInstrumentIndex])
        }

        val borrowButton = findViewById<Button>(R.id.borrowButton)
        borrowButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("instrument", instruments[currentInstrumentIndex])
            }
            startActivity(intent)
        }
    }

    // Function to update the UI with instrument details
    private fun showInstrumentDetails(instrument: Instrument) {
        val imageView = findViewById<ImageView>(R.id.itemImage)
        val nameTextView = findViewById<TextView>(R.id.itemName)
        val priceTextView = findViewById<TextView>(R.id.itemPrice)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val isNewSwitch = findViewById<SwitchCompat>(R.id.itemConditionSwitch)

        // Update the UI with the instrument's data
        imageView.setImageResource(instrument.imageResId)
        nameTextView.text = instrument.name
        priceTextView.text = instrument.price
        ratingBar.rating = instrument.rating
        isNewSwitch.isChecked = instrument.isNew
    }
}
