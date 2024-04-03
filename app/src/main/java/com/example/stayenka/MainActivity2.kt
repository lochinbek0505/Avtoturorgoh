package com.example.stayenka

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bookingplace.Space1Adapter
import com.example.bookingplace.Space2Adapter
import com.example.stayenka.databinding.ActivityMain2Binding
import com.example.stayenka.model.Item
import com.example.stayenka.model.category_model
import com.example.stayenka.model.sp2_model
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity2 : AppCompatActivity() {
    lateinit var dbHelper: DatabaseHelper

    lateinit var binding: ActivityMain2Binding
    var number = 0
    var price = 0
    var addDate = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)


        val currentDate = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

        val newdate = dateFormat.format(currentDate.time)
// Add a certain number of days
        currentDate.add(Calendar.DAY_OF_YEAR, addDate)
// Format the date to "00-MM-YYYY" string format
        val formattedDate = dateFormat.format(currentDate.time)

        val items = dbHelper.getAllItems()
        items.forEach {
            println(it.toString())
        }


        var positon_list = ArrayList<String>()
        val data2 = intent.getSerializableExtra("space_model") as category_model
        var data = data2.list
        binding.tvName.text = data2.name

        for (sp2Model in data.space) {
            if (!sp2Model.check) {
                println(sp2Model.toString())
                number++

            }
        }

        binding.tvId.text = number.toString()

        binding.btnSubmit.setOnClickListener {

            if (price != 0 || positon_list.isNotEmpty()) {


                currentDate.add(Calendar.DAY_OF_YEAR, addDate)
                val formattedDate = dateFormat.format(currentDate.time)
                val newItem = Item(
                    name = data2.name,
                    location = data2.locate,
                    price = price.toString(),
                    fromDate = newdate,
                    endDate = formattedDate,
                    limit = addDate.toString(),
                    number = positon_list.toString(),
                    qrText = "This profile has successfully activated a $addDate-day subscription until $formattedDate. The subscription start date is $newdate and the subscription price is $price so'm"
                )

                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("PAYMENT", newItem)
                startActivity(intent)

            } else {

                Toast.makeText(this, "Please fill in all fields !!!", Toast.LENGTH_LONG).show()

            }
//

        }



        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)

            when (checkedId) {

                R.id.radioButton1 -> {

                    binding.btnSubmit.text = "OBUNA BO'LISH ${data.spiceprice.get(2)} SO'M/OYLIK"
                    price = data.spiceprice.get(2)
                    addDate = 30
                }

                R.id.radioButton2 -> {

                    binding.btnSubmit.text = "OBUNA BO'LISH ${data.spiceprice.get(1)} SO'M/HAFTALIK"
                    price = data.spiceprice.get(1)
                    addDate = 7
                }

                R.id.radioButton3 -> {

                    binding.btnSubmit.text = "OBUNA BO'LISH ${data.spiceprice.get(0)} SO'M/KUNLIK"
                    price = data.spiceprice.get(0)
                    addDate = 1
                }


            }

        }
        val array = data.space.subList(0, data.space.size / 2)

        val array2 = data.space.subList(data.space.size / 2, data.space.size)

        var check1 = true
        var check2 = true

        val adapter = Space1Adapter(array, object : Space1Adapter.ItemSetOnClickListener {
            override fun onClick(data: sp2_model) {
                Log.e("AA", "")
                if (!data.check) {
                    Log.e("ASWERT", "run")

                    if (check1) {

                        number--
                        binding.tvId.text = number.toString()
                        positon_list.add(data.number)
                        check1 = false
                    } else {

                        number++
                        positon_list.remove(data.number)
                        binding.tvId.text = number.toString()
                        check1 = true

                    }
                }
            }
        })


        val adapter2 = Space2Adapter(array2, object : Space2Adapter.ItemSetOnClickListener {
            override fun onClick(data: sp2_model) {
                Log.e("AA", "")
                if (!data.check) {

                    if (check2) {

                        number--
                        positon_list.add(data.number)
                        binding.tvId.text = number.toString()
                        check2 = false
                    } else {

                        number++
                        positon_list.remove(data.number)
                        binding.tvId.text = number.toString()
                        check2 = true

                    }
                }
            }
        })

        binding.rvAm1.adapter = adapter
        binding.rvAm2.adapter = adapter2

    }


}