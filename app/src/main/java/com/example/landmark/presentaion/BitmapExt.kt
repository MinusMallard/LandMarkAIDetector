package com.example.landmark.presentaion

import android.graphics.Bitmap


fun Bitmap.centerCrop(desiredlength: Int ): Bitmap {
    val xStart = (width - desiredlength)/2
    val yStart = (height - desiredlength) /2

    if(xStart < 0 || yStart < 0 || desiredlength > width || desiredlength > height) {
        throw IllegalArgumentException("Invalid arguments for cropping")
    }

    return Bitmap.createBitmap( this, xStart, yStart, desiredlength, desiredlength)
}