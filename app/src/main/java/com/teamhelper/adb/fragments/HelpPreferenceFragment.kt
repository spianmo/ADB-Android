package com.teamhelper.adb.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.teamhelper.adb.R
import com.teamhelper.adb.utils.ADB
import com.teamhelper.adb.views.MainActivity
import kotlin.system.exitProcess

class HelpPreferenceFragment : PreferenceFragmentCompat() {
    private lateinit var adb: ADB

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adb = ADB.getInstance(context)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.help, rootKey)
    }

    private fun restartApp() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finishAffinity()
        exitProcess(0)
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {

            getString(R.string.restart_key) -> restartApp()

            else -> {
                if (preference !is SwitchPreference && preference !is EditTextPreference) {
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle(preference.title)
                        .setMessage(preference.summary)
                        .show()
                }
            }
        }

        return super.onPreferenceTreeClick(preference)
    }
}