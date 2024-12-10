package com.example.taskapp.ui.screens.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MedicationEntityUi(val dose: String,
                              val name: String,
                              val strength: String):Parcelable