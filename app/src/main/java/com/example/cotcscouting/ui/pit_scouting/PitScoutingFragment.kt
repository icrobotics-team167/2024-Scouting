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

PIT SCOUT FORM PLANS
- Misc questions (Team name stuff like that)
- Auto questions
- Teleop questions
- Drop down menu?
- Question search?
- Question information?
- Cool animations?
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
        var teamnameText = teamnameAnswerBox?.text
        var teamnameAnswer = ""

        teamnameAnswerBox?.setOnFocusChangeListener {
            v: View,
            hasFocus : Boolean ->

            fun onFocusChange(v : View, hasFocus : Boolean) {
                // if teamAnswerBox is equal to the text which was originally in the text box
                if(teamnameAnswerBox.text.toString().equals(teamnameText.toString())) {
                    // If teamnameAnswerBox is not focused, then reset teamnameAnswerBox to it's original text
                    if(!v.hasFocus()) {
                        teamnameAnswerBox.text = teamnameText
                    } else { // Since teamnameAnswerBox is now focused clear it so the text doesn't need to be cleared
                        teamnameAnswerBox.text.clear()
                    }
                } else { // Since teamnameAnswerBox isn't equal to the text which was originally in the box TODO: I think cases where what's in the text box is "" can be dealt with prior to this else
                    // If teamnameAnswerBox is blank, then reest teamnameAnswerBox to it's original text
                    if(teamnameAnswerBox.text.toString().equals("")) {
                        teamnameAnswerBox.text = teamnameText
                    } else { // Since teamnameAnswerBox isn't blank, save the current value in teamnameAnswerBox
                        teamnameAnswer = teamnameAnswerBox.text.toString()
                    }
                }
            }

            onFocusChange(v, hasFocus) // Run on change function
        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}