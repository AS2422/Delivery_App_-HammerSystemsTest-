package com.asafin24.hammersystems_test_safin.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.hammersystems_test_safin.R
import com.asafin24.hammersystems_test_safin.domain.models.BannerModel
import kotlinx.android.synthetic.main.banner_item.view.*


class BannerAdapter : RecyclerView.Adapter<BannerVH>() {

    private var bannerList = mutableListOf<BannerModel>(
        BannerModel(30, "С понедельника по четверг с 10 до 16", R.drawable.pizza1),
        BannerModel(40, "Студентам в будние дни", R.drawable.pizza2)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerVH =
        BannerVH(LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false))

    override fun getItemCount(): Int = bannerList.size

    override fun onBindViewHolder(holder: BannerVH, position: Int): Unit = holder.itemView.run {
        holder.itemView.tv_amount_of_discount.text = bannerList[position].discount.toString() + " %"
        holder.itemView.tv_discount_time.text = bannerList[position].discount_time
        holder.itemView.iv_banner.setImageResource(bannerList[position].image)
    }
}

class BannerVH(itemView: View) : RecyclerView.ViewHolder(itemView)