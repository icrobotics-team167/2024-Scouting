package com.example.cotcscouting.ui.match_scouting

import android.content.Context
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
import java.net.URL

class MatchScoutingFragment : Fragment()  {

    private var _binding: FragmentMatchScoutingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var autoAmpCount = 0
    private var autoSpeakerCount = 0
    private var teleopAmpCount = 0
    private var teleOpSpeakerCount = 0
    private var ampSpeakerCount = 0
    private var leave = false
    private var onStage = false
    private var onStageSpotlit = false
    private var trapNote = 0
    private var park = false
    private var rings = BooleanArray(5)
    private var defense = false
    private var shootingDistanceBar = 0
    private var teamNumber = 0
    private var matchNumber = 0
    private var scoutName = "Scout"
    private var regionalCode = "missouri"
    private var scoutingAssignment = "red 1"

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

        binding.leave?.setOnClickListener {
            leave = binding.leave?.isChecked == true
        }
        binding.onStage?.setOnClickListener {
            onStage = binding.onStage?.isChecked == true
        }

        binding.onStageSpotlit?.setOnClickListener {
            onStageSpotlit = binding.onStageSpotlit?.isChecked == true
        }

        binding.trapNote?.setOnClickListener {
            trapNote = if (binding.trapNote?.isChecked == true) {
                1
            } else {
                0
            }
        }

        binding.park?.setOnClickListener {
            park = binding.park?.isChecked == true
        }

        binding.defense?.setOnClickListener {
            defense = binding.defense?.isChecked == true
        }

        binding.shootingDistanceBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // here, you react to the value being set in seekBar
                shootingDistanceBar = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // you can probably leave this empty
            }
        })

        val blueAllianceURL = URL("https://www.thebluealliance.com/api/v3/event/2023iacf/matches?X-TBA-Auth-Key=9wSxnqP56MMgj6T8SsoQVOprfnX4uGp1YHGq7GLUYv8fmLXk0PYOqEeSR6QRtv3w")
        blueAllianceURL.openStream()

        binding.matchNumber?.setOnClickListener {
            val matchEditable = binding.matchNumber
            if (matchEditable != null) {
                matchNumber = Integer.parseInt(matchEditable.text.toString())
            }
        }

        binding.teamNumber?.setOnClickListener {
            val teamEditable = binding.teamNumber
            if (teamEditable != null) {
                teamNumber = Integer.parseInt(teamEditable.text.toString())
            }
        }
        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        scoutName = sharedPref.getString("scout_name", "Scout").toString()
        scoutingAssignment = sharedPref.getString("scout_assignment", "Red 1").toString()
        binding.scoutName?.text = scoutName
        binding.matchNumber?.setText(matchNumber.toString(), TextView.BufferType.EDITABLE)
        binding.teamNumber?.setText(teamNumber.toString(), TextView.BufferType.EDITABLE)
        binding.scoutAssignment?.text = scoutingAssignment
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
                ring1 = rings[0],
                ring2 = rings[1],
                ring3 = rings[2],
                ring4 = rings[3],
                ring5 = rings[4],
                defense = defense,
                shootingDistanceBar = shootingDistanceBar,
                teamNumber = teamNumber,
                matchNumber = matchNumber,
                scoutName = scoutName,
                regionalCode = regionalCode
            )
            val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }
            database?.matchDAO()?.insert(match)


            binding.matchNumber?.setText(matchNumber.toString(), TextView.BufferType.EDITABLE)
            clearFields()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clearFields() {
        autoAmpCount = 0
        binding.ampNoteAuto?.text = autoAmpCount.toString()
        autoSpeakerCount = 0
        binding.speakerNoteAuto?.text = autoSpeakerCount.toString()
        teleopAmpCount = 0
        binding.ampNoteTeleOp?.text = teleopAmpCount.toString()
        teleOpSpeakerCount = 0
        binding.teleOpSpeaker?.text = teleOpSpeakerCount.toString()
        ampSpeakerCount = 0
        leave = false
        binding.leave?.isChecked = false
        onStage = false
        binding.onStage?.isChecked = false
        onStageSpotlit = false
        binding.onStageSpotlit?.isChecked = false
        trapNote = 0
        binding.trapNote?.isChecked = false
        park = false
        binding.park?.isChecked = false
        rings = BooleanArray(5)
        defense = false
        shootingDistanceBar = 1
        binding.shootingDistanceBar?.progress = 0
    }
}