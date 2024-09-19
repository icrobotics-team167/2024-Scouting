package com.example.cotcscouting.ui.pit_scouting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.data.model.AppDatabase
import com.example.cotcscouting.data.model.Pit
import com.example.cotcscouting.databinding.FragmentPitScoutingBinding

class PitScoutingFragment : Fragment() {

    private var _binding: FragmentPitScoutingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pitScoutingViewModel =
            ViewModelProvider(this)[PitScoutingViewModel::class.java]

        _binding = FragmentPitScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView? = binding.textDashboard
        pitScoutingViewModel.text.observe(viewLifecycleOwner) {
            if(textView != null) {
                textView.text = it
            }
        }

        var amountNumber = 0
        val add  = binding.add
        val remove = binding.remove
        val amount = binding.amount

        add?.setOnClickListener {
            amountNumber++
            amount?.text = amountNumber.toString()
        }

        remove?.setOnClickListener {
            amountNumber--
            amount?.text = amountNumber.toString()
        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun makeIncrement(textView: TextView, increment : Button, decrement : Button) {

    }
}