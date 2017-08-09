package com.mycheering.launcher.auto.theme;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

public class BitmapUtilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }

    public Bitmap createThemeStyleBitmap(Bitmap bitmap, Bitmap bgBitmap, Bitmap catBitmap) {
        return IconTypeUtil.getIconFronStyleType(bitmap, bgBitmap, catBitmap);
    }

}
