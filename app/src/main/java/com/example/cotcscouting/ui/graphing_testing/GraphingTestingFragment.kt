package com.example.cotcscouting.ui.graphing_testing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.databinding.FragmentGraphingTestingBinding
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt

class GraphingTestingFragment : Fragment() {
    private var _binding: FragmentGraphingTestingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val graphingTestingBinding =
            ViewModelProvider(this)[GraphingTestingViewModel::class.java]

        _binding = FragmentGraphingTestingBinding.inflate(inflater, container, false)

        val textView : TextView? = binding.textHome
        graphingTestingBinding.text.observe(viewLifecycleOwner) {
            if(textView != null) {
                textView.text = it
            }
        }
        val list = arrayOf("B1", "B2", "B3")
        createOptions(list, binding.tableLayout!!) // Might want to get rid of the assertion idk
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // May or may not work android studio emulator isn't scaling correctly so I can't really tell but it didn't crash the second time.
    fun createOptions(names : Array<String>, layout : TableLayout) {
        val max = floor(names.size / 2.0).toInt()

        for(i in 0..max) {
            val tableRow = TableRow(this.context)

            val button = Button(this.context)
            button.text = names[i + i]
            tableRow.addView(button)

            if(i + i + 1 < names.size - 1) {
                val button2 = Button(this.context)
                button2.text = names[i + i + 1]
                tableRow.addView(button2)
            }

            layout.addView(tableRow)
        }
    }
}