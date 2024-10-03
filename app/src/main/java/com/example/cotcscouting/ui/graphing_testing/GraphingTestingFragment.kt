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

    // Won't work with odds but rn I just want to test that I know how to create buttons.
    fun createOptions(names : Array<String>, layout : TableLayout) {
        val max = ceil(names.size/2.0).roundToInt()
        println(names.size)
        println(max)

        for(element in names) {
            val tableRow = TableRow(this.context)
            createOption(element, tableRow)
            layout.addView(tableRow)
        }
    }

    fun createOption(name : String, row : TableRow) {
        val button = Button(this.context)
        button.text = name
        row.addView(button)
    }
}