package com.example.stayenka.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bookingplace.CheckAdapter
import com.example.stayenka.DatabaseHelper
import com.example.stayenka.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var qrCodeImageView: ImageView
    private lateinit var db:DatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        db= DatabaseHelper(requireActivity())

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Content to encode into QR code

        println(db.getAllItems())

        val adapter=CheckAdapter(db.getAllItems())
        binding.rvFd.adapter=adapter
        // Generate QR code bitmap

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}