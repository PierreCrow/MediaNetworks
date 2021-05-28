package com.futuremobile.wox.presentation.utiles.scanqr;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class BarcodeCaptureActivity extends AppCompatActivity implements BarcodeGraphicTracker.BarcodeUpdateListener {
    private static final String TAG = "Barcode-reader";
    private static final int RC_HANDLE_GMS = 9001;
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    public static final String AutoFocus = "AutoFocus";
    public static final String BarcodeObject = "Barcode";
    private CameraSource mCameraSource;
    private CameraSourcePreview mPreview;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;
    private AppCompatButton btn_cancel;

    public BarcodeCaptureActivity() {
    }

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);



    }



    @SuppressLint({"InlinedApi"})
    private void createCameraSource(boolean autoFocus) {
        Context context = this.getApplicationContext();
        BarcodeDetector barcodeDetector = (new BarcodeDetector.Builder(context)).build();
        BarcodeTrackerFactory barcodeFactory = new BarcodeTrackerFactory(this.mGraphicOverlay, this);
        barcodeDetector.setProcessor((new com.google.android.gms.vision.MultiProcessor.Builder(barcodeFactory)).build());
        if (!barcodeDetector.isOperational()) {
            IntentFilter lowstorageFilter = new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW");
            boolean hasLowStorage = this.registerReceiver((BroadcastReceiver)null, lowstorageFilter) != null;
            if (hasLowStorage) {
                Toast.makeText(this, "errorrcamera", 1).show();
            }
        }

        CameraSource.Builder builder = (new CameraSource.Builder(this.getApplicationContext(), barcodeDetector)).setFacing(0).setRequestedPreviewSize(2000, 1500).setRequestedFps(15.0F);
        if (Build.VERSION.SDK_INT >= 14) {
            builder = builder.setFocusMode(autoFocus ? "continuous-picture" : null);
        }

        this.mCameraSource = builder.build();
    }

    protected void onResume() {
        super.onResume();
        this.startCameraSource();
    }

    protected void onPause() {
        super.onPause();
        if (this.mPreview != null) {
            this.mPreview.stop();
        }

    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mPreview != null) {
            this.mPreview.release();
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != 2) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        } else if (grantResults.length != 0 && grantResults[0] == 0) {
            boolean autoFocus = this.getIntent().getBooleanExtra("AutoFocus", false);
            this.createCameraSource(autoFocus);
        } else {
            android.content.DialogInterface.OnClickListener listener = new android.content.DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    BarcodeCaptureActivity.this.finish();
                }
            };
            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
            builder.setTitle("Multitracker sample").setMessage("no tiene el permiso de la cámara").setPositiveButton("ok", listener).show();
        }
    }

    private void startCameraSource() throws SecurityException {
        int code = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.getApplicationContext());
        if (code != 0) {
            Dialog dlg = GoogleApiAvailability.getInstance().getErrorDialog(this, code, 9001);
            dlg.show();
        }

        if (this.mCameraSource != null) {
            try {
                this.mPreview.start(this.mCameraSource, this.mGraphicOverlay);
            } catch (IOException var3) {
                Log.e("Barcode-reader", "Unable to start camera source.", var3);
                this.mCameraSource.release();
                this.mCameraSource = null;
            }
        }

    }

    public void onBarcodeDetected(Barcode barcode) {
        Intent data = new Intent();
        data.putExtra("Barcode", barcode);
        Log.e("Get barcode: ", String.valueOf(barcode));
        this.setResult(0, data);
        this.finish();
    }
}
