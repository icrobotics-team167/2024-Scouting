package com.example.cotcscouting.ui.alliance_scouting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cotcscouting.data.model.Alliance
import com.example.cotcscouting.data.model.AppDatabase
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
        val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }

        var blueNotes = ""
        binding.blueNotes.setOnClickListener {
            blueNotes = binding.blueNotes.text.toString()
        }

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
        var blueCoOp = false
        binding.blueCoOp.setOnClickListener {
            blueCoOp = binding.blueCoOp.isChecked
        }

        var blueMelody = false
        binding.blueMelody.setOnClickListener {
            blueMelody = binding.blueMelody.isChecked
        }

        var blueEnsamble = false
        binding.blueEnsamble.setOnClickListener {
            blueEnsamble = binding.blueEnsamble.isChecked
        }

        var blueHarmony = false
        binding.blueHarmony.setOnClickListener {
            blueHarmony = binding.blueHarmony.isChecked
        }

        var redNotes = ""
        binding.redNotes.setOnClickListener {
            redNotes = binding.redNotes.text.toString()
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

        var redCoOp = false
        binding.redCoOp.setOnClickListener {
            redCoOp = binding.redCoOp.isChecked
        }

        var redMelody = false
        binding.redMelody.setOnClickListener {
            redMelody = binding.redMelody.isChecked
        }

        var redEnsamble = false
        binding.redEnsamble.setOnClickListener {
            redEnsamble = binding.redEnsamble.isChecked
        }

        var redHarmony = false
        binding.redHarmony.setOnClickListener {
            redHarmony = binding.redHarmony.isChecked
        }

        binding.allianceSubmit.setOnClickListener {
            val alliance = Alliance(
                0,
                blueNotes = blueNotes,
                blueAmpsCount = blueAmpsCount,
                blueCoOp = blueCoOp,
                blueMelody = blueMelody,
                blueEnsamble = blueEnsamble,
                blueHarmony = blueHarmony,
                redNotes = redNotes,
                redAmpsCount = redAmpsCount,
                redCoOp = redCoOp,
                redMelody = redMelody,
                redEnsamble = redEnsamble,
                redHarmony = redHarmony,
                matchNumber = 0,
                scoutName = "Calder",
                regionalCode = "missouri"
            )
            println(blueNotes)
            database?.allianceDAO()?.insert(alliance)
        }
        return root
    }
}