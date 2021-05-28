package com.futuremobile.wox.presentation.utiles.scanqr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.google.android.gms.vision.barcode.Barcode;

public class BarcodeGraphic extends GraphicOverlay.Graphic {
    private int mId;
    private static final int[] COLOR_CHOICES = new int[]{-16776961, -16711681, -16711936};
    private static int mCurrentColorIndex = 0;
    private Paint mRectPaint;
    private Paint mTextPaint;
    private volatile Barcode mBarcode;

    BarcodeGraphic(GraphicOverlay overlay) {
        super(overlay);
        mCurrentColorIndex = (mCurrentColorIndex + 1) % COLOR_CHOICES.length;
        int selectedColor = COLOR_CHOICES[mCurrentColorIndex];
        this.mRectPaint = new Paint();
        this.mRectPaint.setColor(selectedColor);
        this.mRectPaint.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setStrokeWidth(4.0F);
        this.mTextPaint = new Paint();
        this.mTextPaint.setColor(selectedColor);
        this.mTextPaint.setTextSize(36.0F);
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Barcode getBarcode() {
        return this.mBarcode;
    }

    void updateItem(Barcode barcode) {
        this.mBarcode = barcode;
        this.postInvalidate();
    }

    public void draw(Canvas canvas) {
        Barcode barcode = this.mBarcode;
        if (barcode != null) {
            RectF rect = new RectF(barcode.getBoundingBox());
            rect.left = this.translateX(rect.left);
            rect.top = this.translateY(rect.top);
            rect.right = this.translateX(rect.right);
            rect.bottom = this.translateY(rect.bottom);
            canvas.drawRect(rect, this.mRectPaint);
            canvas.drawText(barcode.rawValue, rect.left, rect.bottom, this.mTextPaint);
        }
    }
}
