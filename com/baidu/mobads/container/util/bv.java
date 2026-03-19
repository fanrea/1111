package com.baidu.mobads.container.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bv {
    private static DisplayMetrics a = null;
    private static float b = 0.0f;
    private static float c = 0.0f;

    public static Rect a(Context context) {
        DisplayMetrics displayMetricsG = g(context);
        try {
            if (displayMetricsG.widthPixels > displayMetricsG.heightPixels) {
                return new Rect(0, 0, displayMetricsG.heightPixels, displayMetricsG.widthPixels);
            }
            return new Rect(0, 0, displayMetricsG.widthPixels, displayMetricsG.heightPixels);
        } catch (Exception e) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics displayMetricsG = g(context);
        return new Rect(0, 0, displayMetricsG.widthPixels, displayMetricsG.heightPixels);
    }

    public static float e(Context context) {
        if (b < 0.01d) {
            b = g(context).density;
        }
        return b;
    }

    public static float f(Context context) {
        if (c < 0.01d) {
            c = g(context).scaledDensity;
        }
        return c;
    }

    public static DisplayMetrics g(Context context) {
        try {
            if (a != null && a.widthPixels > 0) {
                return a;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (x.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            }
            a = displayMetrics;
        } catch (Throwable th) {
            a = new DisplayMetrics();
            bq.a().a(th);
        }
        return a;
    }

    public static int a(Context context, int i) {
        try {
            return (int) (i / e(context));
        } catch (Exception e) {
            return i;
        }
    }

    public static int b(Context context, int i) {
        try {
            return (int) (i * e(context));
        } catch (Exception e) {
            return i;
        }
    }

    public static int h(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int i(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier <= 0 || !k(context)) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        } catch (Exception e) {
            return 0;
        }
    }

    private static boolean k(Context context) throws Resources.NotFoundException, ClassNotFoundException {
        boolean z;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier <= 0) {
                z = false;
            } else {
                z = resources.getBoolean(identifier);
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
                if ("1".equals(str)) {
                    return false;
                }
                if (!"0".equals(str)) {
                    return z;
                }
                return true;
            } catch (Exception e) {
                return z;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static View a(Activity activity, View view, boolean z) {
        try {
            if (x.a(activity).a() == 35 && activity.getApplicationContext().getApplicationInfo().targetSdkVersion == 35) {
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = h(activity);
                if (z) {
                    layoutParams.bottomMargin = i(activity);
                }
                relativeLayout.addView(view, layoutParams);
                return relativeLayout;
            }
            return view;
        } catch (Exception e) {
            return view;
        }
    }

    public static View a(Activity activity, View view) {
        try {
            if (x.a(activity).a() == 35 && activity.getApplicationContext().getApplicationInfo().targetSdkVersion == 35) {
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = h(activity);
                int i = i(activity);
                if (i > a((Context) activity, 20.0f)) {
                    layoutParams.rightMargin = i;
                } else if (i > 0) {
                    layoutParams.bottomMargin = i;
                }
                relativeLayout.addView(view, layoutParams);
                return relativeLayout;
            }
            return view;
        } catch (Exception e) {
            return view;
        }
    }

    public static boolean j(Context context) {
        try {
            if (x.a(context).a() == 35 && context != null && context.getApplicationContext() != null && context.getApplicationContext().getApplicationInfo() != null) {
                if (context.getApplicationContext().getApplicationInfo().targetSdkVersion == 35) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
