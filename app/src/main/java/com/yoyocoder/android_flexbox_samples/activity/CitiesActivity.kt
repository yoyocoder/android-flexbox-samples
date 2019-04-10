package com.yoyocoder.android_flexbox_samples.activity

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxItemDecoration
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.yoyocoder.android_flexbox_samples.R
import com.yoyocoder.android_flexbox_samples.adapter.CityAdapter
import dummy.CityFactory
import kotlinx.android.synthetic.main.activity_cities.rcv_cities

class CitiesActivity : AppCompatActivity() {

  private lateinit var cityAdapter: CityAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_cities)

    cityAdapter = CityAdapter(Glide.with(this))
    val layoutManager = FlexboxLayoutManager(this).apply {
      flexWrap = FlexWrap.WRAP
      flexDirection = FlexDirection.ROW
      justifyContent = JustifyContent.FLEX_START
      alignItems = AlignItems.STRETCH
    }
    rcv_cities.layoutManager = layoutManager
    rcv_cities.adapter = cityAdapter
    rcv_cities.addItemDecoration((getFlexboxItemDecoration()))
    cityAdapter.reloadData(CityFactory.INSTANCE.cities)
  }

  private fun getFlexboxItemDecoration(): RecyclerView.ItemDecoration {
    return FlexboxItemDecoration(this).apply {
      setDrawable(GradientDrawable().apply { setSize(10, 10) })
      setOrientation(FlexboxItemDecoration.BOTH)
    }
  }
}
