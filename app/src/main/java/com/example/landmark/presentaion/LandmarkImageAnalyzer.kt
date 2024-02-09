package com.example.landmark.presentaion

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.landmark.domain.Classification
import com.example.landmark.domain.LandmarkClassifier

class LandmarkImageAnalyzer(
    private val classifer: LandmarkClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321)

            val results = classifer.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++
        image.close()
    }
}