/*
AUTO:
where do you start (is this flexible [how many autos?]) added
Where do you score? added
How many do you score? added

TELEOP:
Game strategy
Intake(Ground or source)
Which speaker you go for
Furthest shot
Closest shot
How many points can you earn in a match

Endgame Questions:
Do you climb?
How long to climb?
Where do you climb? (Middle, edges)
Do you score on the trap?

PIT SCOUT FORM PLANS
- Cool animations?
- Skill trees?
- Vehicles?
- Leveling system?
- Subway surfers on the side?
- Tiktok compilation next to subway surfers?
- Random loud noises?
- Micro-transactions?
- Lake chargoggagoggmanchauggagoggchaubunagungamaugg?
*/

package com.example.cotcscouting.ui.pit_scouting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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

        var startingArea = ArrayList<String>()

        binding.doesMatter?.setOnClickListener {
            startingArea.clear()
            startingArea.add("All")
            binding.left?.isChecked = false
            binding.right?.isChecked = false
            binding.center?.isChecked = false
        }

        // I don't like that I repeat the same if loop 3 times.
        binding.left?.setOnClickListener {
            if(startingArea.contains("Both")) {
                startingArea.removeAt(startingArea.indexOf("Both"))
            }
            binding.doesMatter?.isChecked = false
            startingArea.add("Left")
        }
        binding.right?.setOnClickListener {
            if(startingArea.contains("Both")) {
                startingArea.removeAt(startingArea.indexOf("Both"))
            }
            binding.doesMatter?.isChecked = false
            startingArea.add("Right")
        }
        binding.center?.setOnClickListener {
            if(startingArea.contains("Both")) {
                startingArea.removeAt(startingArea.indexOf("Both"))
            }
            binding.doesMatter?.isChecked = false
            startingArea.add("Center")
        }


        var scoreArea = "NO ANSWER"

        binding.ampAndSpeaker?.setOnClickListener {
            scoreArea = "Both"
            binding.amp?.isChecked = false
            binding.speaker?.isChecked = false
        }
        binding.amp?.setOnClickListener {
            scoreArea = "Amp"
            binding.speaker?.isChecked = false
            binding.ampAndSpeaker?.isChecked = false
        }
        binding.speaker?.setOnClickListener {
            scoreArea = "Speaker"
            binding.amp?.isChecked = false
            binding.ampAndSpeaker?.isChecked = false
        }


        var intake = "NO ANSWER"

        binding.groundAndSource?.setOnClickListener {
            intake = "Both"
            binding.ground?.isChecked = false
            binding.source?.isChecked = false
        }
        binding.ground?.setOnClickListener {
            intake = "Ground"
            binding.source?.isChecked = false
            binding.groundAndSource?.isChecked = false
        }
        binding.source?.setOnClickListener {
            intake = "Source"
            binding.ground?.isChecked = false
            binding.groundAndSource?.isChecked = false
        }

        binding.submit?.setOnClickListener {
            val pit = Pit(
                0,
                teamNumber = Integer.decode(binding.teamNameAnswer?.text.toString()),
                scoutName = binding.scoutAnswer?.text.toString(),
                driveCoachName = binding.coachAnswer?.text.toString(),
                driveBase = binding.driveBaseAnswer?.text.toString(),
                rookieTeam = binding.rookieTeam?.isChecked,
                howManyAutos = Integer.decode(binding.autoCount?.text.toString()),
                hasAuto = binding.hasAuto?.isChecked,
                doesPreload = binding.doesPreload?.isChecked,
                doesShoot = binding.doesShoot?.isChecked,
                doesIntake = binding.doesIntake?.isChecked,
                whereDoYouStart = startingArea.toString(),
                whereDoYouScore = scoreArea,
                notesScoreCount = Integer.decode(binding.scoreAuto?.text.toString()),
                gameStrategy = binding.gameStrategy?.text.toString(),
                intake = intake
            )
            val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }
            database?.pitDAO()?.insert(pit)
        }


        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun focusListenerString(textBoxID : EditText?): String {
        var answer = ""
        val originalText = textBoxID?.text

        textBoxID?.setOnFocusChangeListener {
                v: View,
                hasFocus : Boolean ->

            fun onFocusChange(v : View, hasFocus : Boolean) {
                // if teamAnswerBox is equal to the text which was originally in the text box
                if(textBoxID.text.toString().equals(originalText.toString()) || textBoxID.text.isBlank()) {
                    // If textBoxID is not focused, then reset textBoxID to it's original text
                    if(!v.hasFocus()) {
                        textBoxID.text = originalText
                    } else { // Since textBoxID is now focused clear it so the text doesn't need to be cleared
                        textBoxID.text.clear()
                    }
                } else { // Since textBoxID isn't equal to the text which was originally in the box
                    answer = textBoxID.text.toString()
                }
            }
            onFocusChange(v, hasFocus) // Run on change function
        }

        return answer
    }
}