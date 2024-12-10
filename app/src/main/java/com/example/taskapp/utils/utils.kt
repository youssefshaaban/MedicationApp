package com.example.taskapp.utils

import androidx.compose.ui.graphics.Color

fun Color.Companion.fromHex(colorString: String) = Color(android.graphics.Color.parseColor("#$colorString"))