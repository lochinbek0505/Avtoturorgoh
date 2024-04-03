package com.example.stayenka.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bookingplace.CatecoriesAdapter
import com.example.stayenka.MainActivity2
import com.example.stayenka.R
import com.example.stayenka.databinding.FragmentHomeBinding
import com.example.stayenka.model.category_model
import com.example.stayenka.model.sp2_model
import com.example.stayenka.model.space_model

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var adapter: CatecoriesAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val ma1 = arrayListOf<Int>(10000, 50000, 250000)
        val ms1 = arrayListOf<sp2_model>(
            sp2_model("01", R.drawable.ic_car, false),
            sp2_model("02", R.drawable.ic_car, false),
            sp2_model("03", R.drawable.ic_car, false),
            sp2_model("04", R.drawable.ic_car, true),
            sp2_model("05", R.drawable.ic_car, false),
            sp2_model("06", R.drawable.ic_car, false),
            sp2_model("07", R.drawable.ic_car, true),
            sp2_model("08", R.drawable.ic_car, false),
            sp2_model("09", R.drawable.ic_car, true),
            sp2_model("10", R.drawable.ic_car, false),
            sp2_model("11", R.drawable.ic_car, true),
            sp2_model("12", R.drawable.ic_car, true),
            sp2_model("13", R.drawable.ic_car, false),
            sp2_model("14", R.drawable.ic_car, false),
        )

        val m1 = space_model(
            ma1,
            ms1
        )


        val ma2 = arrayListOf<Int>(12000, 55000, 270000)
        val ms2 = arrayListOf<sp2_model>(
            sp2_model("01", R.drawable.ic_car, false),
            sp2_model("02", R.drawable.ic_car, false),
            sp2_model("03", R.drawable.ic_car, false),
            sp2_model("04", R.drawable.ic_car, true),
            sp2_model("05", R.drawable.ic_car, false),
            sp2_model("06", R.drawable.ic_car, false),
            sp2_model("07", R.drawable.ic_car, true),
            sp2_model("08", R.drawable.ic_car, false),
            sp2_model("09", R.drawable.ic_car, true),
            sp2_model("10", R.drawable.ic_car, false),
            sp2_model("11", R.drawable.ic_car, true),
            sp2_model("12", R.drawable.ic_car, true),
            sp2_model("13", R.drawable.ic_car, false),
            sp2_model("14", R.drawable.ic_car, false),
            sp2_model("15", R.drawable.ic_car, false),
            sp2_model("16", R.drawable.ic_car, true),
            sp2_model("17", R.drawable.ic_car, true),
            sp2_model("18", R.drawable.ic_car, false),
        )

        val m2 = space_model(
            ma2,
            ms2
        )


        val ma3 = arrayListOf<Int>(15000, 60000, 290000)
        val ms3 = arrayListOf<sp2_model>(

            sp2_model("01", R.drawable.ic_car, false),
            sp2_model("02", R.drawable.ic_car, false),
            sp2_model("03", R.drawable.ic_car, false),
            sp2_model("04", R.drawable.ic_car, true),
            sp2_model("05", R.drawable.ic_car, false),
            sp2_model("06", R.drawable.ic_car, false),
            sp2_model("07", R.drawable.ic_car, true),
            sp2_model("08", R.drawable.ic_car, false),
            sp2_model("09", R.drawable.ic_car, true),
            sp2_model("10", R.drawable.ic_car, false),
            sp2_model("11", R.drawable.ic_car, true),
            sp2_model("12", R.drawable.ic_car, true),
            sp2_model("13", R.drawable.ic_car, false),
            sp2_model("14", R.drawable.ic_car, false),
            sp2_model("15", R.drawable.ic_car, false),
            sp2_model("16", R.drawable.ic_car, true),
            sp2_model("17", R.drawable.ic_car, false),
            sp2_model("18", R.drawable.ic_car, false),
            sp2_model("19", R.drawable.ic_car, false),
            sp2_model("20", R.drawable.ic_car, true),
        )

        val m3 = space_model(
            ma3,
            ms3
        )


        val ma4 = arrayListOf<Int>(20000, 70000, 300000)
        val ms4 = arrayListOf<sp2_model>(
            sp2_model("01", R.drawable.ic_car, false),
            sp2_model("02", R.drawable.ic_car, false),
            sp2_model("03", R.drawable.ic_car, false),
            sp2_model("04", R.drawable.ic_car, true),
            sp2_model("05", R.drawable.ic_car, false),
            sp2_model("06", R.drawable.ic_car, false),
            sp2_model("07", R.drawable.ic_car, true),
            sp2_model("08", R.drawable.ic_car, false),
            sp2_model("09", R.drawable.ic_car, true),
            sp2_model("10", R.drawable.ic_car, false),
            sp2_model("11", R.drawable.ic_car, true),
            sp2_model("12", R.drawable.ic_car, true),
            sp2_model("13", R.drawable.ic_car, false),
            sp2_model("14", R.drawable.ic_car, false),
            sp2_model("15", R.drawable.ic_car, false),
            sp2_model("16", R.drawable.ic_car, true),
            sp2_model("17", R.drawable.ic_car, false),
            sp2_model("18", R.drawable.ic_car, false),
            sp2_model("19", R.drawable.ic_car, false),
            sp2_model("20", R.drawable.ic_car, true),
        )

        val m4 = space_model(
            ma4,
            ms4
        )


        val array = arrayListOf<category_model>(

            category_model(
                R.drawable.ic_1,
                "Makon Mall avtoturargohi",
                "Shokhrukh, Mirzo Bedil St 17",
                "250 ming so'm/oyiga",
                m1
            ),

            category_model(
                R.drawable.ic_4,
                "Family Park  avtoturargohi",
                "Narpay ko'chasi ",
                "270 ming so'm/oyiga",
                m2
            ),

            category_model(
                R.drawable.ic_2,
                "Registon  avtoturargohi",
                "Registon ko'chasi  , Registon maydoni",
                "290 ming so'm/oyiga",
                m3
            ),

            category_model(
                R.drawable.ic_2,
                "Samarqand turizm markazi avtoturargohi",
                "Buyuk ipak yo'li ko'chasi ko'chasi ",
                "300 ming so'm/oyiga",
                m4
            )

        )


        adapter = CatecoriesAdapter(array, object : CatecoriesAdapter.ItemSetOnClickListener {
            override fun onClick(data: category_model) {

                val intent=Intent(requireActivity(), MainActivity2::class.java)

                intent.putExtra("space_model",data)

                startActivity(intent)
            }


        })

        binding.rvFh.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}