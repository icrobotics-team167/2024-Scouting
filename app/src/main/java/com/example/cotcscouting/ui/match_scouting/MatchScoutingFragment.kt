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


        var leave = 0
        binding.leave?.setOnClickListener {
            if(binding.leave?.isChecked == true){
                leave = 1;
            }
            else {
                leave = 0
            }
        }

        var onStage = 0
        binding.onStage?.setOnClickListener {
            if(binding.onStage?.isChecked == true){
                onStage = 1;
            }
            else {
                onStage = 0
            }
        }

        var onStageSpotlit = 0
        binding.onStageSpotlit?.setOnClickListener {
            if(binding.onStageSpotlit?.isChecked == true){
                onStageSpotlit = 1;
            }
            else {
                onStageSpotlit = 0
            }
        }

        var trapNote = 0
        binding.trapNote?.setOnClickListener {
            if(binding.trapNote?.isChecked == true){
                trapNote = 1;
            }
            else {
                trapNote = 0
            }
        }

        var park = 0
        binding.park?.setOnClickListener {
            if(binding.park?.isChecked == true){
                park = 1;
            }
            else {
                park = 0
            }
        }

        binding.submit?.setOnClickListener {
            val submit_values = intArrayOf(autoAmpCount, autoSpeakerCount, teleopAmpCount, teleOpSpeakerCount, ampSpeakerCount, leave, onStage, onStageSpotlit, trapNote, park,)
            System.out.println(" " + submit_values[0] + " " + submit_values[1] + " " + submit_values[2] + " " + submit_values[3] + " " + submit_values[4] + " " + submit_values[5] + " " + submit_values[6] + " " + submit_values[7] + " " + submit_values[8] + " " + submit_values[9])
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}