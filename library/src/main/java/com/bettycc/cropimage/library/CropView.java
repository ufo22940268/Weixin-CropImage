package com.bettycc.cropimage.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ccheng on 10/24/14.
 */
public class CropView extends PhotoView {

    private PhotoViewAttacher mAttacher;

    public CropView(Context context) {
        super(context);
        init();
    }

    public CropView(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    public CropView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        init();
    }

    private void init() {
        mAttacher = new PhotoViewAttacher(this);
    }

    public Bitmap getCropedBitmap() {
        Bitmap visibleRectangleBitmap = getVisibleRectangleBitmap();
        float scale = mAttacher.getScale();
        RectF displayRect = mAttacher.getDisplayRect();
        System.out.println("scale = " + scale);
        System.out.println("displayRect = " + displayRect);
        System.out.println("visibleRectangleBitmap = " + visibleRectangleBitmap.getWidth());

        float x = Math.abs(displayRect.left)/scale;
        float y = Math.abs(displayRect.top)/scale;
        float width = 500/scale;
        float height = 500/scale;

        return Bitmap.createBitmap(visibleRectangleBitmap, (int)x, (int)y, (int)width, (int)height);
    }
}
