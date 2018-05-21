package com.kitsu.android.anime.ui.adapters

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.kitsu.android.anime.R
import com.kitsu.android.anime.data.response.DataItem
import com.kitsu.android.anime.ui.modules.detail.DetailActivity
import com.kitsu.android.anime.utils.inflate
import kotlinx.android.synthetic.main.item_trending.view.*
import org.jetbrains.anko.dip

class TrendingAdapter (var list: List<DataItem?>) :
        RecyclerView.Adapter<TrendingAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: DataItem?, position:Int) {
            data?.let {
                with(it) {
                    Glide.with(itemView.context)
                            .load(it.attributes?.coverImage?.large)
                            .into(itemView.ivBackground)

                    var parms = itemView.tvName.layoutParams as FrameLayout.LayoutParams
                    if((position % 2)==0){
                        parms.gravity = Gravity.START or Gravity.BOTTOM
                        parms.marginStart = itemView.context.dip(8)
                    }else{
                        parms.gravity = Gravity.END or Gravity.BOTTOM
                        parms.marginEnd = itemView.context.dip(8)
                    }
                    itemView.tvName.layoutParams = parms
                    itemView.tvName.text = it.attributes?.canonicalTitle

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        intent.putExtra("slug",this@with.attributes?.slug)

                        val p1: Pair<View, String> = Pair.create(itemView.ivBackground,"transitionCover")
                        val p2: Pair<View, String> = Pair.create(itemView.tvName,"transitionName")

                        val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity,
                                p1, p2)

                        itemView.context.startActivity(intent, options.toBundle())
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(parent.inflate(R.layout.item_trending))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        list.let {
            holder.bindView(it[position], position)
        }
    }

}
