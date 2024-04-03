package com.example.stayenka

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stayenka.databinding.ActivityPaymentBinding
import com.example.stayenka.model.Item

class PaymentActivity : AppCompatActivity() {

    lateinit var binding: ActivityPaymentBinding
    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivityPaymentBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val data = intent.getSerializableExtra("PAYMENT") as Item
        dbHelper=DatabaseHelper(this)

        binding.cardDateEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (s.length == 2 && s.get(1) != '/') {
                        binding.cardDateEditText.setText(StringBuilder(s).insert(2, "/"))
                        binding.cardDateEditText.setSelection(binding.cardDateEditText.text!!.length)
                    }
                }
            }
        })


        binding.payButton.setOnClickListener {

            if (!binding.cardDateEditText.text.isNullOrEmpty() || !binding.cardNumberEditText.text.isNullOrEmpty() || !binding.cardNameEditText.text.isNullOrEmpty()){

                dbHelper.addItem(data)
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
                Toast.makeText(this, "Subscription successfully activated !!!", Toast.LENGTH_LONG).show()
                println(data.toString())
            }
            else{

                Toast.makeText(this, "Please fill in all fields !!!", Toast.LENGTH_LONG).show()


            }

        }

    }
}