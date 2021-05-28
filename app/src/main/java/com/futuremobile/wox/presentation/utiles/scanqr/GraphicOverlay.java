package com.futuremobile.wox.presentation.utiles.scanqr;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class GraphicOverlay<T extends GraphicOverlay.Graphic> extends View {
    private final Object mLock = new Object();
    private int mPreviewWidth;
    private float mWidthScaleFactor = 1.0F;
    private int mPreviewHeight;
    private float mHeightScaleFactor = 1.0F;
    private int mFacing = 0;
    private Set<T> mGraphics = new HashSet();

    public GraphicOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void clear() {
        synchronized(this.mLock) {
            this.mGraphics.clear();
        }

        this.postInvalidate();
    }

    public void add(T graphic) {
        synchronized(this.mLock) {
            this.mGraphics.add(graphic);
        }

        this.postInvalidate();
    }

    public void remove(T graphic) {
        synchronized(this.mLock) {
            this.mGraphics.remove(graphic);
        }

        this.postInvalidate();
    }

    public List<T> getGraphics() {
        synchronized(this.mLock) {
            return new Vector(this.mGraphics);
        }
    }

    public float getWidthScaleFactor() {
        return this.mWidthScaleFactor;
    }

    public float getHeightScaleFactor() {
        return this.mHeightScaleFactor;
    }

    public void setCameraInfo(int previewWidth, int previewHeight, int facing) {
        synchronized(this.mLock) {
            this.mPreviewWidth = previewWidth;
            this.mPreviewHeight = previewHeight;
            this.mFacing = facing;
        }

        this.postInvalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized(this.mLock) {
            if (this.mPreviewWidth != 0 && this.mPreviewHeight != 0) {
                this.mWidthScaleFactor = (float)canvas.getWidth() / (float)this.mPreviewWidth;
                this.mHeightScaleFactor = (float)canvas.getHeight() / (float)this.mPreviewHeight;
            }

            Iterator var3 = this.mGraphics.iterator();

            while(var3.hasNext()) {
                GraphicOverlay.Graphic graphic = (GraphicOverlay.Graphic)var3.next();
                graphic.draw(canvas);
            }

        }
    }

    public abstract static class Graphic {
        private GraphicOverlay mOverlay;

        public Graphic(GraphicOverlay overlay) {
            this.mOverlay = overlay;
        }

        public abstract void draw(Canvas var1);

        public float scaleX(float horizontal) {
            return horizontal * this.mOverlay.mWidthScaleFactor;
        }

        public float scaleY(float vertical) {
            return vertical * this.mOverlay.mHeightScaleFactor;
        }

        public float translateX(float x) {
            return this.mOverlay.mFacing == 1 ? (float)this.mOverlay.getWidth() - this.scaleX(x) : this.scaleX(x);
        }

        public float translateY(float y) {
            return this.scaleY(y);
        }

        public void postInvalidate() {
            this.mOverlay.postInvalidate();
        }
    }
}

