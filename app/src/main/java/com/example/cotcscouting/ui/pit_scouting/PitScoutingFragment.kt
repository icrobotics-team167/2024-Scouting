/*
PIT SCOUTING QUESTIONS
- Auto function + what area (Score)
- Teleop function
- Strategy
- Endgame function (Hanging)
- Hanging mechanisms
- Drive train type
- How they pick up notes
- If can shoot where do you want to shoot (Against subwoofer, against podium, or anywhere)

AUTO:
where do you start (is this flexible [how many autos?])
Where do you score?
How many do you score?


PIT SCOUT FORM PLANS
- Misc questions (Team name stuff like that)
- Auto questions
- Teleop questions
- Drop down menu?
- Question search?
- Question information?
- Cool animations?
- Skill trees?
- Vehicles?
- Leveling system?
- GIMP
- Switch between different types of questions?
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
        val teamnameAnswerBox : EditText? = binding.teamNameAnswer
        focusListener(teamnameAnswerBox)



        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun focusListener(textBoxID : EditText?): String {
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

        return answer;
    }
}