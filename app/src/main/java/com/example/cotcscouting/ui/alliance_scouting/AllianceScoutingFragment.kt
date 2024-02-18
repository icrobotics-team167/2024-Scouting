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
        
    ): View {
        _binding = FragmentAllianceScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var blueAmpsCount = 0
        binding.blueAmpsDec.setOnClickListener {
            if(blueAmpsCount > 0) {
                blueAmpsCount--
            }
            binding.blueAmps.text = blueAmpsCount.toString()
        }

        binding.blueAmpsInc.setOnClickListener {
            blueAmpsCount++
            binding.blueAmps.text = blueAmpsCount.toString()
        }
        var blueCoOp = 0
        binding.blueCoOp.setOnClickListener {
            blueCoOp = if(binding.blueCoOp.isChecked){
                1
            } else {
                0
            }
        }

        var blueMelody = 0
        binding.blueMelody.setOnClickListener {
            blueMelody = if(binding.blueMelody.isChecked){
                1
            } else {
                0
            }
        }

        var blueEnsamble = 0
        binding.blueEnsamble.setOnClickListener {
            blueEnsamble = if(binding.blueEnsamble.isChecked){
                1
            } else {
                0
            }
        }

        var blueHarmony = 0
        binding.blueHarmony.setOnClickListener {
            blueHarmony = if(binding.blueHarmony.isChecked){
                1
            } else {
                0
            }
        }

        var redAmpsCount = 0
        binding.redAmpsDec.setOnClickListener {
            if(redAmpsCount > 0) {
                redAmpsCount--
            }
            binding.redAmps.text = redAmpsCount.toString()
        }

        binding.redAmpsInc.setOnClickListener {
            redAmpsCount++
            binding.redAmps.text = redAmpsCount.toString()
        }

        var redCoOp = 0
        binding.redCoOp.setOnClickListener {
            redCoOp = if(binding.redCoOp.isChecked){
                1
            } else {
                0
            }
        }

        var redMelody = 0
        binding.redMelody.setOnClickListener {
            redMelody = if(binding.redMelody.isChecked){
                1
            } else {
                0
            }
        }

        var redEnsamble = 0
        binding.redEnsamble.setOnClickListener {
            redEnsamble = if(binding.redEnsamble.isChecked){
                1
            } else {
                0
            }
        }

        var redHarmony = 0
        binding.redHarmony.setOnClickListener {
            redHarmony = if(binding.redHarmony.isChecked){
                1
            } else {
                0
            }
        }

        binding.allianceSubmit.setOnClickListener {
            val submitValues = intArrayOf(blueAmpsCount, blueCoOp, blueMelody, blueEnsamble, blueHarmony, redAmpsCount, redCoOp, redMelody, redEnsamble, redHarmony)
            println(binding.blueAlliance.text.toString() + " " + binding.redAlliance.text.toString() + " " + binding.blueNotes.text.toString() + " " + binding.redNotes.text.toString() + " " + submitValues[0] + " " + submitValues[1] + " " + submitValues[2] + " " + submitValues[3] + " " + submitValues[4] + " " + submitValues[5] + " " + submitValues[6] + " " + submitValues[7] + " " + submitValues[8] + " " + submitValues[9])
        }
        return root
    }
}