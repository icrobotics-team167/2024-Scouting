package com.example.cotcscouting.ui.match_scouting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.data.model.AppDatabase
import com.example.cotcscouting.data.model.Match
import com.example.cotcscouting.databinding.FragmentMatchScoutingBinding

class MatchScoutingFragment : Fragment()  {

    private var _binding: FragmentMatchScoutingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val matchScoutingViewModal =
            ViewModelProvider(this)[MatchScoutingViewModel::class.java]

        _binding = FragmentMatchScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView? = binding.textDashboard
        matchScoutingViewModal.text.observe(viewLifecycleOwner) {
            if (textView != null) {
                textView.text = it
            }
        }

        var autoAmpCount = 0
        binding.autoAmpDec?.setOnClickListener {
            if(autoAmpCount > 0) {
                autoAmpCount--
            }
            binding.ampNoteAuto?.text = autoAmpCount.toString()
        }

        binding.autoAmpInc?.setOnClickListener {
            autoAmpCount++
            binding.ampNoteAuto?.text = autoAmpCount.toString()
        }

        var autoSpeakerCount = 0
        binding.autoSpeakerDec?.setOnClickListener {
            if(autoSpeakerCount > 0) {
                autoSpeakerCount--
            }
            binding.speakerNoteAuto?.text = autoSpeakerCount.toString()
        }

        binding.autoSpeakerInc?.setOnClickListener {
            autoSpeakerCount++
            binding.speakerNoteAuto?.text = autoSpeakerCount.toString()
        }

        var teleopAmpCount = 0
        binding.teleOpAmpDec?.setOnClickListener {
            if(teleopAmpCount > 0) {
                teleopAmpCount--
            }
            binding.ampNoteTeleOp?.text = teleopAmpCount.toString()
        }

        binding.teleOpAmpInc?.setOnClickListener {
            teleopAmpCount++
            binding.ampNoteTeleOp?.text = teleopAmpCount.toString()
        }
        var teleOpSpeakerCount = 0
        binding.teleOpSpeakerDec?.setOnClickListener {
            if(teleOpSpeakerCount > 0) {
                teleOpSpeakerCount--
            }
            binding.teleOpSpeaker?.text = teleOpSpeakerCount.toString()
        }

        binding.teleOpSpeakerInc?.setOnClickListener {
            teleOpSpeakerCount++
            binding.teleOpSpeaker?.text = teleOpSpeakerCount.toString()
        }

        var ampSpeakerCount = 0
        binding.ampSpeakerNoteDec?.setOnClickListener {
            if(ampSpeakerCount > 0) {
                ampSpeakerCount--
            }
            binding.ampSpeakerNote?.text = ampSpeakerCount.toString()
        }

        binding.ampSpeakerNoteInc?.setOnClickListener {
            ampSpeakerCount++
            binding.ampSpeakerNote?.text = ampSpeakerCount.toString()
        }


        var leave = false
        binding.leave?.setOnClickListener {
            leave = binding.leave?.isChecked == true
        }

        var onStage = false
        binding.onStage?.setOnClickListener {
            onStage = binding.onStage?.isChecked == true
        }

        var onStageSpotlit = false
        binding.onStageSpotlit?.setOnClickListener {
            onStageSpotlit = binding.onStageSpotlit?.isChecked == true
        }

        var trapNote = 0
        binding.trapNote?.setOnClickListener {
            trapNote = if(binding.trapNote?.isChecked == true){
                1
            } else {
                0
            }
        }

        var park = false
        binding.park?.setOnClickListener {
            park = binding.park?.isChecked == true
        }

        var ring1 = false
        binding.ring1?.setOnClickListener {
            ring1 = binding.ring1?.isChecked == true
        }

        var ring2 = false
        binding.ring2?.setOnClickListener {
            ring2 = binding.ring2?.isChecked == true
        }

        var ring3 = false
        binding.ring3?.setOnClickListener {
            ring3 = binding.ring3?.isChecked == true
        }

        var ring4 = false
        binding.ring4?.setOnClickListener {
            ring4 = binding.ring4?.isChecked == true
        }

        var ring5 = false
        binding.ring5?.setOnClickListener {
            ring5 = binding.ring5?.isChecked == true
        }

        var shootingDistanceBar = 1
        binding.shootingDistanceBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // here, you react to the value being set in seekBar
                shootingDistanceBar = progress
                println(shootingDistanceBar)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }
        })

        binding.submit?.setOnClickListener {
            val match = Match(
                0,
                autoAmpCount = autoAmpCount,
                autoSpeakerCount = autoSpeakerCount,
                teleopAmpCount = teleopAmpCount,
                teleOpSpeakerCount = teleOpSpeakerCount,
                ampSpeakerCount = ampSpeakerCount,
                leave = leave,
                onStage = onStage,
                onStageSpotlit = onStageSpotlit,
                trapNote = trapNote,
                park = park,
                ring1 = ring1,
                ring2 = ring2,
                ring3 = ring3,
                ring4 = ring4,
                ring5 = ring5,
                shootingDistanceBar = shootingDistanceBar,
                teamNumber = 167,
                matchNumber = 0,
                scoutName = "Calder",
                regionalCode = "missouri"
            )
            val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }
            database?.matchDAO()?.insert(match)
}
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}