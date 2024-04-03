package com.example.bookingplace

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stayenka.databinding.CheckLayoutBinding
import com.example.stayenka.model.Item
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix


class CheckAdapter(
    var items: ArrayList<Item>,
) :
    RecyclerView.Adapter<CheckAdapter.Holder>() {


    inner class Holder(var view: CheckLayoutBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(data: Item) {

            view.apply {

//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(this.mhlIv1)

                this.tvName.text = data.name
                this.tvFrom.text = data.fromDate
                this.tvTo.text = data.endDate
                this.tvLimit.text = "${data.limit} kun"
                this.tvPrice.text = "${data.price} so'm"
                val bitmap = generateQRCode(data.qrText)

                // Set QR code bitmap to ImageView
                this.ivQr.setImageBitmap(bitmap)
//                this.tvName.text = data.name
//                this.tvLocate.text=data.locate
//                this.tvStar.text=data.star
//                this.ivIhv.setImageResource(data.image)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding =
            CheckLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(
            binding
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.bind(item)


    }

    override fun getItemCount(): Int = items.count()
    private fun generateQRCode(content: String): Bitmap? {
        val width = 500
        val height = 500
        val bitMatrix: BitMatrix
        try {
            val multiFormatWriter = MultiFormatWriter()
            bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height)
        } catch (e: WriterException) {
            e.printStackTrace()
            return null
        }

        val bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        for (x in 0 until width) {
            for (y in 0 until height) {
                bm.setPixel(x, y, if (bitMatrix[x, y]) -0x1000000 else -0x1)
            }
        }

        return bm
    }

}