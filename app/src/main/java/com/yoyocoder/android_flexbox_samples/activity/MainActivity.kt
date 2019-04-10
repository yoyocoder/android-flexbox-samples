package com.yoyocoder.android_flexbox_samples.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yoyocoder.android_flexbox_samples.R.id
import com.yoyocoder.android_flexbox_samples.R.layout

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
  }

  fun onClick(view: View) {
    when (view.id) {
      id.tv_flexbox_layout -> {
      }
      id.tv_flexbox_layout_manager -> {
        startActivity(Intent(this, CitiesActivity::class.java))
      }
    }
  }
}
