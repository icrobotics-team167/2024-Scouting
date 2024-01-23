package com.example.cotcscouting.ui.match_scouting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.databinding.FragmentMatchScoutingBinding
import com.example.cotcscouting.ui.pit_scouting.PitScoutingViewModel

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

        var ampsCount = 0
        binding.ampsDec?.setOnClickListener {
            if(ampsCount > 0) {
                ampsCount--
            }
            binding.amps?.text = ampsCount.toString()
        }

        binding.ampsInc?.setOnClickListener {
            ampsCount++
            binding.amps?.text = ampsCount.toString()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}