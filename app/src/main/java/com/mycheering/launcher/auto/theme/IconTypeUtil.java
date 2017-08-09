package com.mycheering.launcher.auto.theme;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by root on 17-8-8.
 */

public class IconTypeUtil implements IType {

    public static Bitmap getIconFronStyleType(Bitmap bitmap, Bitmap bgBitmap, Bitmap catBitmap) {
        int type = BuildConfig.ICON_STYLE_TYPE;
        switch (type) {
            case STYLE_SMALL_RADIUS_TYPE:
                return createStyleSmallRadiusBitmap(bitmap, bgBitmap);
            case STYLE_BIG_RADIUS_TYPE:
                return createStyleBigRadiusBitmap(bitmap, bgBitmap);
            case STYLE_SHRINK_TYPE:
                return createStyleShrinkBitmap(bitmap, bgBitmap);
            case STYLE_ENLARGE_TYPE:
                return createStyleEnlargeBitmap(bitmap, bgBitmap);
            case STYLE_LITTLE_TYPE:
                return createStyleLittleBitmap(bitmap, bgBitmap);
            case STYLE_CIRCLE_BG_TYPE:
                return createStyleCircleBgBitmap(bitmap, bgBitmap, catBitmap);
            case STYLE_LARGE_RADIUS_TYPE:
                return createStyleLargeRadiusBitmap(bitmap, bgBitmap, catBitmap);
            default:
                return createStyleSmallRadiusBitmap(bitmap, bgBitmap);
        }
    }

    //ic_theme_style zuowei icon de bejing
    private static Bitmap createStyleSmallRadiusBitmap(Bitmap bitmap, Bitmap bgBitmap) {
        if (bgBitmap == null) {
            return bitmap;
        }
        try {
            int width, height;
            width = bgBitmap.getWidth();
            height = bgBitmap.getHeight();
            Bitmap themeIcon = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas();
            canvas.setBitmap(themeIcon);
            BitmapDrawable bgDrawable = new BitmapDrawable(bgBitmap);
            bgDrawable.setBounds(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
            bgDrawable.draw(canvas);
            BitmapDrawable iconDrawable = new BitmapDrawable(bitmap);
            int x = width / 8;
            int y = height / 8;
            iconDrawable.setBounds(x, y, bitmap.getWidth() - x, bitmap.getHeight() - y);
            iconDrawable.draw(canvas);
            return themeIcon;
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static Bitmap createStyleBigRadiusBitmap(Bitmap bitmap, Bitmap bgBitmap) {
        try {
            if (bgBitmap != null) {
                Bitmap concerBitmap = combineImages(bitmap, bgBitmap);
                return concerBitmap;
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static Bitmap combineImages(Bitmap fg, Bitmap bgd) {
        Bitmap bmp;
        int width = bgd.getWidth() > fg.getWidth() ?
                bgd.getWidth() : fg.getWidth();
        int height = bgd.getHeight() > fg.getHeight() ?
                bgd.getHeight() : fg.getHeight();
        bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Canvas canvas = new Canvas(bmp);
        canvas.drawBitmap(bgd, 0, 0, null);
        canvas.drawBitmap(fg, 0, 0, paint);
        return bmp;
    }

    private static Bitmap createStyleShrinkBitmap(Bitmap bitmap, Bitmap bgBitmap) {
        if (bgBitmap == null) {
            return bitmap;
        }
        try {
            int width, height;
            width = bgBitmap.getWidth();
            height = bgBitmap.getHeight();
            Bitmap themeIcon = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas();
            canvas.setBitmap(themeIcon);
            int x = bitmap.getWidth() / 4;
            int y = bitmap.getHeight() / 4;
            BitmapDrawable bgDrawable = new BitmapDrawable(bgBitmap);
            bgDrawable.setBounds(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
            bgDrawable.draw(canvas);
            BitmapDrawable iconDrawable = new BitmapDrawable(bitmap);
            iconDrawable.setBounds(x, y, bitmap.getWidth() - x, bitmap.getHeight() - y);
            iconDrawable.draw(canvas);
            return themeIcon;
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static Bitmap createStyleEnlargeBitmap(Bitmap bitmap, Bitmap bgBitmap) {
        return bgBitmap;
    }

    private static Bitmap createStyleLittleBitmap(Bitmap bitmap, Bitmap bgBitmap) {
        if (bgBitmap == null) {
            return bitmap;
        }
        try {
            int width, height;
            width = bgBitmap.getWidth();
            height = bgBitmap.getHeight();
            Bitmap themeIcon = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas();
            canvas.setBitmap(themeIcon);
            int x = (bitmap.getWidth() / 6);
            int y = (bitmap.getHeight() / 6);
            BitmapDrawable bgDrawable = new BitmapDrawable(bgBitmap);
            bgDrawable.setBounds(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
            bgDrawable.draw(canvas);
            BitmapDrawable iconDrawable = new BitmapDrawable(bitmap);
            iconDrawable.setBounds(x - 1, y, bitmap.getWidth() - x - 1, bitmap.getHeight() - y);
            iconDrawable.draw(canvas);
            return themeIcon;
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static Bitmap createStyleCircleBgBitmap(Bitmap bitmap, Bitmap bgBitmap, Bitmap catBitmap) {
        try {
            if (bgBitmap != null) {
                Bitmap concerBitmap = combineImages(bitmap, catBitmap);
                if (bgBitmap == null) {
                    return concerBitmap;
                }
                try {
                    int width, height;
                    width = bgBitmap.getWidth();
                    height = bgBitmap.getHeight();
                    Bitmap themeIcon = Bitmap.createBitmap(width, height,
                            Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas();
                    canvas.setBitmap(themeIcon);
                    BitmapDrawable bgDrawable = new BitmapDrawable(bgBitmap);
                    bgDrawable.setBounds(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
                    bgDrawable.draw(canvas);
                    BitmapDrawable iconDrawable = new BitmapDrawable(concerBitmap);
                    iconDrawable.setBounds(0, 0, concerBitmap.getWidth(), concerBitmap.getHeight());
                    iconDrawable.draw(canvas);
                    return themeIcon;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return concerBitmap;
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static Bitmap createStyleLargeRadiusBitmap(Bitmap bitmap, Bitmap bgBitmap, Bitmap catBitmap) {
        try {
            if (bgBitmap != null) {
                Bitmap concerBitmap = combineImages(bitmap, catBitmap);
                if (bgBitmap == null) {
                    return concerBitmap;
                }
                try {
                    Bitmap temp = concerBitmap;
                    concerBitmap = bgBitmap;
                    bgBitmap = temp;
                    int width, height;
                    width = bgBitmap.getWidth();
                    height = bgBitmap.getHeight();
                    Bitmap themeIcon = Bitmap.createBitmap(width, height,
                            Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas();
                    canvas.setBitmap(themeIcon);
                    BitmapDrawable bgDrawable = new BitmapDrawable(bgBitmap);
                    bgDrawable.setBounds(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
                    bgDrawable.draw(canvas);
                    BitmapDrawable iconDrawable = new BitmapDrawable(concerBitmap);
                    iconDrawable.setBounds(0, 0, concerBitmap.getWidth(), concerBitmap.getHeight());
                    iconDrawable.draw(canvas);
                    return themeIcon;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return concerBitmap;
            }
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            outOfMemoryError.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
