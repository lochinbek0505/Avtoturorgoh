package com.example.bookingplace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stayenka.databinding.HomeItemBinding
import com.example.stayenka.model.category_model


class CatecoriesAdapter(
    var items: ArrayList<category_model>,
    var listener: ItemSetOnClickListener,
) :
    RecyclerView.Adapter<CatecoriesAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: category_model)
    }

    inner class Holder(var view: HomeItemBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: category_model) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

                this.tvName.text = data.name
                this.tvLocate.text = data.locate
                this.tvPrice.text = data.price
                this.ivHi.setImageResource(data.image)
//                this.tvName.text = data.name
//                this.tvLocate.text=data.locate
//                this.tvStar.text=data.star
//                this.ivIhv.setImageResource(data.image)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(
            binding
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }

    }

    override fun getItemCount(): Int = items.count()

}