package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class jh {
    private static boolean an = false;
    private static Resources b = null;
    private static String c = null;
    private static Context d = null;
    private static String hc = null;
    private static boolean u = false;

    private static String b(Context context) {
        if (c == null) {
            c = context.getPackageName();
        }
        return c;
    }

    private static int d(Context context, String str, String str2) {
        int identifier = d(context).getIdentifier(str, str2, b(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!u) {
            hc(context);
            return d(context).getIdentifier(str, str2, b(context));
        }
        return context.getResources().getIdentifier(str, str2, b(context));
    }

    public static String d(Context context, String str) {
        return d(context).getString(hc(context, str));
    }

    public static int hc(Context context, String str) {
        return d(context, str, TypedValues.Custom.S_STRING);
    }

    public static void d(Context context, String str, ImageView imageView) throws Resources.NotFoundException {
        Drawable drawable = d(context).getDrawable(u(context, str));
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void d(Context context, String str, View view) throws Resources.NotFoundException {
        Drawable drawable = d(context).getDrawable(u(context, str));
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public static Drawable b(Context context, String str) {
        try {
            return d(context).getDrawable(u(context, str));
        } catch (Exception e) {
            mq.d(e);
            return null;
        }
    }

    public static Bitmap c(Context context, String str) {
        return BitmapFactory.decodeResource(d(context), u(context, str));
    }

    public static int u(Context context, String str) {
        try {
            return d(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int an(Context context, String str) {
        return d(context, str, "id");
    }

    public static int h(Context context, String str) {
        return d(context, str, "layout");
    }

    public static int gb(Context context, String str) {
        return d(context, str, "style");
    }

    public static int tt(Context context, String str) {
        return d(context, str, "dimen");
    }

    public static int tc(Context context, String str) {
        return d(context).getColor(mk(context, str));
    }

    public static int mk(Context context, String str) {
        return d(context, str, TypedValues.Custom.S_COLOR);
    }

    public static int mq(Context context, String str) {
        return d(context, str, "anim");
    }

    public static Resources d(Context context) {
        Resources resources = b;
        if (resources == null) {
            resources = null;
        }
        Context context2 = d;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void hc(Context context) {
        try {
            if (TextUtils.isEmpty(hc)) {
                return;
            }
            Resources resources = context.getResources();
            b = new Resources(hc(resources.getAssets(), hc + "/apk/base-1.apk"), resources.getDisplayMetrics(), resources.getConfiguration());
            c = context.getPackageName();
            u = true;
        } catch (Throwable th) {
            mq.b("ResourceHelp", "makePluginResources failed", th);
        }
    }

    private static AssetManager hc(AssetManager assetManager, String str) throws NoSuchMethodException, SecurityException {
        AssetManager assetManager2;
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            d(assetManager2, str);
            assetManager = assetManager2;
        } catch (Exception unused) {
            d(assetManager, str);
        }
        try {
            j.d(assetManager, "ensureStringBlocks", new Object[0]);
        } catch (Exception unused2) {
        }
        return assetManager;
    }

    public static boolean d(AssetManager assetManager, String str) throws NoSuchMethodException, SecurityException {
        Method methodD = j.d((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        if (methodD == null) {
            methodD = j.d((Class<?>) AssetManager.class, "addAssetPath", (Class<?>[]) new Class[]{String.class});
        }
        if (methodD != null) {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i < 0) {
                    break;
                }
                if (((Integer) methodD.invoke(assetManager, str)).intValue() != 0) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }
}
