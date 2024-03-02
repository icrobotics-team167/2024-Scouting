package com.example.cotcscouting

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.DialogFragment

class LoginFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            builder.setTitle("Login to Start Scouting")
            builder.setView(inflater.inflate(R.layout.fragment_login, null))
                .setPositiveButton("Login") { dialog, id ->
                    //Save information to datastore
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}