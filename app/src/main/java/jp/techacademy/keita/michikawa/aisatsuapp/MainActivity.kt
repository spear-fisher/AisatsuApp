package jp.techacademy.keita.michikawa.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.TimePickerDialog
import android.util.Log
import android.view.View
import android.widget.TimePicker
import jp.techacademy.keita.michikawa.aisatsuapp.databinding.ActivityMainBinding
import java.time.LocalTime


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.text = "ボタン"
        binding.button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener {view, hour, minute ->
                    val time = LocalTime.of(hour, minute, 0)
                    if (time.isAfter(LocalTime.of(1, 59, 0)) && time.isBefore(LocalTime.of(10, 0,0, ))) {
                        binding.textView.text = "おはよう"
                    } else if (time.isAfter(LocalTime.of(9, 59, 0)) && time.isBefore(LocalTime.of(18, 0, 0))) {
                        binding.textView.text = "こんにちは"
                    } else {
                        binding.textView.text = "こんばんは"
                    }
            },
            13, 0, true)
        timePickerDialog.show()
    }
}