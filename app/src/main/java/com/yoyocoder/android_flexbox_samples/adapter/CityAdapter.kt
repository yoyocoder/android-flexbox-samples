package com.yoyocoder.android_flexbox_samples.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.flexbox.FlexboxLayoutManager
import com.yoyocoder.android_flexbox_samples.R
import dummy.CityFactory.City

class CityAdapter(
    private val requestManager: RequestManager
) : RecyclerView.Adapter<ViewHolder>() {

  private val cities = mutableListOf<City>()
  private var requestOptions = lazy {
    RequestOptions()
        .override(300, 300)
        .fitCenter()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return if (viewType == R.layout.city_item) {
      val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.city_item, parent, false)
      CityViewHolder(view)
    } else {
      val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.blank_item, parent, false)
      BlankViewHolder(view)
    }
  }

  override fun getItemCount() = cities.size

  override fun getItemViewType(position: Int): Int {
    return if (cities[position].url == null) {
      R.layout.blank_item
    } else R.layout.city_item
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    (holder as? CityViewHolder)?.bind(cities[position])
    (holder as? BlankViewHolder)?.bind()
  }

  fun reloadData(newCities: List<City>) {
    // This is just a trick to make the list look like grid layout
    // TODO: find another solution
    val newData = if (newCities.size % 2 == 1) {
      mutableListOf<City>().apply {
        addAll(newCities)
        add(City(null))
      }
    } else {
      newCities
    }

    val diffUtil = DiffUtil.calculateDiff(CityDiffUtilCallback(newData, cities))
    cities.clear()
    cities.addAll(newData)
    diffUtil.dispatchUpdatesTo(this)
  }

  inner class CityViewHolder(private val view: View) : ViewHolder(view) {

    fun bind(city: City) {
      if (view is AppCompatImageView) {
        requestManager.load(city.url)
            .apply(requestOptions.value)
            .into(view)

        (view.layoutParams as? FlexboxLayoutManager.LayoutParams)?.apply {
          flexBasisPercent = 0.4f
          flexGrow = 1f
        }
      }
    }

  }

  inner class BlankViewHolder(private val view: View) : ViewHolder(view) {

    fun bind() {
      (view.layoutParams as? FlexboxLayoutManager.LayoutParams)?.apply {
        flexBasisPercent = 0.4f
        flexGrow = 1f
      }
    }

  }

  class CityDiffUtilCallback(
      private val oldCities: List<City>,
      private val newCities: List<City>
  ) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return oldCities[oldItemPosition].url == newCities[newItemPosition].url
    }

    override fun getOldListSize() = oldCities.size

    override fun getNewListSize() = newCities.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return oldCities[oldItemPosition].url == newCities[newItemPosition].url
    }

  }
}
