package com.example.cotcscouting.ui.graphing_testing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.databinding.FragmentGraphingTestingBinding

class GraphingTestingFragment : Fragment() {
    private var _binding: FragmentGraphingTestingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val graphingTestingBinding =
            ViewModelProvider(this)[GraphingTestingViewModel::class.java]

        _binding = FragmentGraphingTestingBinding.inflate(inflater, container, false)

        val textView : TextView? = binding.textHome
        graphingTestingBinding.text.observe(viewLifecycleOwner) {
            if(textView != null) {
                textView.text = it
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}