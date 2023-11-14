package com.example.slider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    private val imageList = listOf(R.drawable.dog, R.drawable.horse, R.drawable.kitten)
    private val quoteList = listOf(
        "I will prepare and some day my chance will come. \n Abraham Lincoln",
        "We don't laugh because we're happy, we're happy because we laugh. \n William James",
        "Happiness is nothing more than good health and a bad memory. \n Albert Schweitzer"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movePosition(0)

        binding.btnToLeft.setOnClickListener{
            movePosition(-1)
        }
        binding.btnToRight.setOnClickListener {
            movePosition(1)
        }
    }
    private fun movePosition(num: Int) {
        position += num

        if (position >= imageList.size) {
            position = 0
        } else if (position < 0) {
            position = imageList.size - 1
        }

        binding.textView.text = quoteList[position]
        binding.imageView3.setImageResource(imageList[position])
    }
}