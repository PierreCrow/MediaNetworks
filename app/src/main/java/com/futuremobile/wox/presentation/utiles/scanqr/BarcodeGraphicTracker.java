package com.futuremobile.wox.presentation.utiles.scanqr;

import android.content.Context;
import androidx.annotation.UiThread;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;

public class BarcodeGraphicTracker extends Tracker<Barcode> {
    private GraphicOverlay<BarcodeGraphic> mOverlay;
    private BarcodeGraphic mGraphic;
    private BarcodeGraphicTracker.BarcodeUpdateListener mBarcodeUpdateListener;

    BarcodeGraphicTracker(GraphicOverlay<BarcodeGraphic> mOverlay, BarcodeGraphic mGraphic, Context context) {
        this.mOverlay = mOverlay;
        this.mGraphic = mGraphic;
        if (context instanceof BarcodeGraphicTracker.BarcodeUpdateListener) {
            this.mBarcodeUpdateListener = (BarcodeGraphicTracker.BarcodeUpdateListener)context;
        } else {
            throw new RuntimeException("Hosting activity must implement BarcodeUpdateListener");
        }
    }

    public void onNewItem(int id, Barcode item) {
        this.mGraphic.setId(id);
        this.mBarcodeUpdateListener.onBarcodeDetected(item);
    }

    public void onUpdate(Detector.Detections<Barcode> detectionResults, Barcode item) {
        this.mOverlay.add(this.mGraphic);
        this.mGraphic.updateItem(item);
    }

    public void onMissing(Detector.Detections<Barcode> detectionResults) {
        this.mOverlay.remove(this.mGraphic);
    }

    public void onDone() {
        this.mOverlay.remove(this.mGraphic);
    }

    public interface BarcodeUpdateListener {
        @UiThread
        void onBarcodeDetected(Barcode var1);
    }
}
