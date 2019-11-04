package dev.touyou.randomcolor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var r: Int = 255
    var g: Int = 255
    var b: Int = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorButton.setOnClickListener {
            setColorAndText()
        }
    }

    fun setColorAndText() {
        r = Random.nextInt(0, 255)
        g = Random.nextInt(0, 255)
        b = Random.nextInt(0, 255)

        val color = Color.argb(255, r, g, b)
        var hsv: FloatArray = FloatArray(3)
        Color.RGBToHSV(r, g, b, hsv)

        rootLayout.rootView.setBackgroundColor(color)
        val rgbTemplate = "R: %d, G: %d, B: %d"
        val hsvTemplate = "H: %.2f, S: %.2f, V: %.2f"
        rgbTextView.text = rgbTemplate.format(color.red, color.green, color.blue)
        hexTextView.text = "#" + r.toString(16).takeLast(2) + g.toString(16).takeLast(2) + b.toString(16).takeLast(2)
        hsvTextView.text = hsvTemplate.format(hsv[0], hsv[1], hsv[2])
    }
}
