package com.kitsu.android.anime.ui.adapters

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kitsu.android.anime.R
import com.kitsu.android.anime.data.response.DataItem
import com.kitsu.android.anime.ui.modules.detail.DetailActivity
import com.kitsu.android.anime.utils.inflate
import kotlinx.android.synthetic.main.item_anime.view.*

class HomeAdapter(var list: MutableList<DataItem?>) :
        RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: DataItem?) {
            data?.let {
                with(it) {
                    Glide.with(itemView.context)
                            .load(it.attributes?.posterImage?.small)
                            .centerCrop()
                            .error(R.drawable.all_notfound)
                            .placeholder(R.drawable.all_placeholder)
                            .into(itemView.ivFaceBook)

                    itemView.tvName.text = it.attributes?.canonicalTitle

                    itemView.setOnClickListener {
                        val intent = Intent(itemView.context, DetailActivity::class.java)
                        Log.d("Dars","this@with.attributes?.slug "+this@with.attributes?.slug)
                        intent.putExtra("slug",this@with.attributes?.slug)

                        val p1: Pair<View, String> = Pair.create(itemView.ivFaceBook,"transitionFaceBook")
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
            MyViewHolder(parent.inflate(R.layout.item_anime))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        list.let {
            holder.bindView(it[position])
        }
    }

}
