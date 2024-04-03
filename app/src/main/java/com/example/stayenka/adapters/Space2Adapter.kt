package com.example.bookingplace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.stayenka.R
import com.example.stayenka.databinding.ParkingItemLayout2Binding
import com.example.stayenka.model.sp2_model


class Space2Adapter(
    var items: MutableList<sp2_model>,
    var listener: ItemSetOnClickListener,
) :
    RecyclerView.Adapter<Space2Adapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: sp2_model)
    }

    inner class Holder(var view: ParkingItemLayout2Binding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: sp2_model) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

                this.tvNumber.text = data.number
//                this.tvLocate.text = data.locate
//                this.tvPrice.text = data.price
                this.ivPil2.setImageResource(data.image)

                if (data.check) {
                    this.ivPil2.visibility = View.VISIBLE
                } else {

                    this.ivPil2.visibility = View.INVISIBLE

                }
//                this.tvName.text = data.name
//                this.tvLocate.text=data.locate
//                this.tvStar.text=data.star
//                this.ivIhv.setImageResource(data.image)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            ParkingItemLayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(
            binding
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)
        val iv = holder.itemView.findViewById<ImageView>(R.id.iv_pil2)
        var check = true
        holder.itemView.setOnClickListener {
            listener.onClick(item)
            if (!item.check) {

                if (check) {

                    iv.visibility = View.VISIBLE

                    check = false

                } else {

                    iv.visibility = View.INVISIBLE
                    check = true
                }
            }
        }

    }

    override fun getItemCount(): Int = items.count()

}