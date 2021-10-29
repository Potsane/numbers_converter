package com.app.rapidnumberconverter.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.rapidnumberconverter.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private lateinit var calculatorViewModel: CalculatorViewModel
    private var _binding: FragmentCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        calculatorViewModel =
            ViewModelProvider(this).get(CalculatorViewModel::class.java)

        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        calculatorViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}