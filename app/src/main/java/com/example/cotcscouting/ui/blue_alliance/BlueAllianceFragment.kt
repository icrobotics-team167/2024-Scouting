package com.example.cotcscouting.ui.blue_alliance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.databinding.FragmentBlueAllianceBinding
import java.net.URL

class BlueAllianceFragment : Fragment() {

    private var _binding: FragmentBlueAllianceBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val blueAllianceViewModel =
            ViewModelProvider(this)[BlueAllianceViewModel::class.java]

        _binding = FragmentBlueAllianceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        blueAllianceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val URL = URL("https://www.thebluealliance.com/api/v3/event/2024")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}