package com.example.cotcscouting.ui.alliance_scouting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cotcscouting.databinding.FragmentAllianceScoutingBinding

class AllianceScoutingFragment : Fragment() {

    private var _binding: FragmentAllianceScoutingBinding? = null
    
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        
    ): View? {
        _binding = FragmentAllianceScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var blueAmpsCount = 0
        binding.blueAmpsDec.setOnClickListener {
            if(blueAmpsCount > 0) {
                blueAmpsCount--
            }
            binding.blueAmps.text = blueAmpsCount.toString()
        }

        binding.blueAmpsInc?.setOnClickListener {
            println("Yay!")
            blueAmpsCount++
            binding.blueAmps?.text = blueAmpsCount.toString()
        }
        var blueCoOp = 0
        binding.blueCoOp?.setOnClickListener {
            if(binding.blueCoOp?.isChecked == true){
                blueCoOp = 1;
            }
            else {
                blueCoOp = 0
            }
        }

        var blueMelody = 0
        binding.blueMelody?.setOnClickListener {
            if(binding.blueMelody?.isChecked == true){
                blueMelody = 1;
            }
            else {
                blueMelody = 0
            }
        }

        var blueEnsamble = 0
        binding.blueEnsamble?.setOnClickListener {
            if(binding.blueEnsamble?.isChecked == true){
                blueEnsamble = 1;
            }
            else {
                blueEnsamble = 0
            }
        }

        var blueHarmony = 0
        binding.blueHarmony?.setOnClickListener {
            if(binding.blueHarmony?.isChecked == true){
                blueHarmony = 1;
            }
            else {
                blueHarmony = 0
            }
        }

        var redAmpsCount = 0
        binding.redAmpsDec?.setOnClickListener {
            if(redAmpsCount > 0) {
                redAmpsCount--
            }
            binding.redAmps?.text = redAmpsCount.toString()
        }

        binding.redAmpsInc?.setOnClickListener {
            redAmpsCount++
            binding.redAmps?.text = redAmpsCount.toString()
        }

        var redCoOp = 0
        binding.redCoOp?.setOnClickListener {
            if(binding.redCoOp?.isChecked == true){
                redCoOp = 1;
            }
            else {
                redCoOp = 0
            }
        }

        var redMelody = 0
        binding.redMelody?.setOnClickListener {
            if(binding.redMelody?.isChecked == true){
                redMelody = 1;
            }
            else {
                redMelody = 0
            }
        }

        var redEnsamble = 0
        binding.redEnsamble?.setOnClickListener {
            if(binding.redEnsamble?.isChecked == true){
                redEnsamble = 1;
            }
            else {
                redEnsamble = 0
            }
        }

        var redHarmony = 0
        binding.redHarmony?.setOnClickListener {
            if(binding.redHarmony?.isChecked == true){
                redHarmony = 1
            }
            else {
                redHarmony = 0
            }
        }

        binding.allianceSubmit?.setOnClickListener {
            val submit_values = intArrayOf(blueAmpsCount, blueCoOp, blueMelody, blueEnsamble, blueHarmony, redAmpsCount, redCoOp, redMelody, redEnsamble, redHarmony)
            System.out.println(binding.blueAlliance.getText().toString() + " " + binding.redAlliance.getText().toString() + " " + binding.blueNotes.getText().toString() + " " + binding.redNotes.getText().toString() + " " + submit_values[0] + " " + submit_values[1] + " " + submit_values[2] + " " + submit_values[3] + " " + submit_values[4] + " " + submit_values[5] + " " + submit_values[6] + " " + submit_values[7] + " " + submit_values[8] + " " + submit_values[9])
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AllianceScoutingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}