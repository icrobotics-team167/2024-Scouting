package com.example.cotcscouting.ui.alliance_scouting

import android.content.Context
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
    private val newAlliance = Alliance(
        uid = 0,
        blueNotes= "",
        blueAmpCount= 0,
        blueCoOp= false,
        blueMelody= false,
        blueEnsamble= false,
        blueHarmony= false,
        redNotes= "",
        redAmpCount= 0,
        redCoOp= false,
        redMelody= false,
        redEnsamble= false,
        redHarmony= false,
        matchNumber= 0,
        scoutName= "",
        regionalCode= "",
        michaelRed1= "",
        michaelRed2= "",
        michaelRed3= "",
        michaelBlue1= "",
        michaelBlue2= "",
        michaelBlue3= ""
    )
    private var activeAlliance = newAlliance

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        
    ): View {
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        _binding = FragmentAllianceScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }

        binding.michaelRed1.setOnClickListener {
            activeAlliance.michaelRed1 = binding.michaelRed1.text.toString()
        }

        binding.michaelRed2.setOnClickListener {
            activeAlliance.michaelRed2 = binding.michaelRed2.text.toString()
        }

        binding.michaelRed3.setOnClickListener {
            activeAlliance.michaelRed3 = binding.michaelRed3.text.toString()
        }

        binding.blueAmpsDec.setOnClickListener {
            if(activeAlliance.blueAmpCount > 0) this.activeAlliance.blueAmpCount--
            binding.blueAmps.text = activeAlliance.blueAmpCount.toString()
        }

        binding.blueAmpsInc.setOnClickListener {
            activeAlliance.blueAmpCount++
            binding.blueAmps.text = activeAlliance.blueAmpCount.toString()
        }
        binding.blueCoOp.setOnClickListener {
            activeAlliance.blueCoOp = binding.blueCoOp.isChecked
        }

        binding.blueMelody.setOnClickListener {
            activeAlliance.blueMelody = binding.blueMelody.isChecked
        }

        binding.blueEnsamble.setOnClickListener {
            activeAlliance.blueEnsamble = binding.blueEnsamble.isChecked
        }

        binding.blueHarmony.setOnClickListener {
            activeAlliance.blueHarmony = binding.blueHarmony.isChecked
        }

        binding.michaelRed1.setOnClickListener {
            activeAlliance.michaelRed1 = binding.michaelRed1.text.toString()
        }

        binding.michaelRed2.setOnClickListener {
            activeAlliance.michaelRed2 = binding.michaelRed2.text.toString()
        }

        binding.michaelRed3.setOnClickListener {
            activeAlliance.michaelRed3 = binding.michaelRed3.text.toString()
        }

        binding.redAmpsDec.setOnClickListener {
            if(activeAlliance.redAmpCount > 0) {
                activeAlliance.redAmpCount--
            }
            binding.redAmps.text = activeAlliance.redAmpCount.toString()
        }

        binding.redAmpsInc.setOnClickListener {
            activeAlliance.redAmpCount++
            binding.redAmps.text = activeAlliance.redAmpCount.toString()
        }

        binding.redCoOp.setOnClickListener {
            activeAlliance.redCoOp = binding.redCoOp.isChecked
        }

        binding.redMelody.setOnClickListener {
            activeAlliance.redMelody = binding.redMelody.isChecked
        }

        binding.redEnsamble.setOnClickListener {
            activeAlliance.redEnsamble = binding.redEnsamble.isChecked
        }

        binding.redHarmony.setOnClickListener {
            activeAlliance.redHarmony = binding.redHarmony.isChecked
        }

        activeAlliance.scoutName = sharedPref.getString("scout_name", "Scout").toString()
        activeAlliance.regionalCode = sharedPref.getString("regional_code","Regional").toString()
        activeAlliance.matchNumber = sharedPref.getInt("match_number", -1)
        binding.allianceSubmit.setOnClickListener {
            database?.allianceDAO()?.insert(activeAlliance)
            activeAlliance = newAlliance
        }
        return root
    }
}