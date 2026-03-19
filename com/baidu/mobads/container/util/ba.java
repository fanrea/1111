package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ba {
    public static int a(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null) {
            return a(new com.baidu.mobads.container.components.i.a(context, jVar.getOriginJsonObject()));
        }
        return 0;
    }

    public static int a(com.baidu.mobads.container.components.i.a aVar) {
        JSONObject jSONObjectA;
        if (aVar == null || (jSONObjectA = aVar.a("ad_logo_style")) == null) {
            return 0;
        }
        return jSONObjectA.optInt("type", 0);
    }

    public static View a(Context context, int i) {
        ImageView imageViewC;
        int iA;
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                ImageView imageViewC2 = c(applicationContext, com.baidu.mobads.container.h.k);
                int iA2 = bv.a(applicationContext, 13.0f);
                linearLayout.addView(imageViewC2, new RelativeLayout.LayoutParams(iA2, iA2));
                if (i == 1) {
                    imageViewC = c(applicationContext, com.baidu.mobads.container.h.m);
                    iA = bv.a(applicationContext, 52.0f);
                } else {
                    imageViewC = c(applicationContext, com.baidu.mobads.container.h.l);
                    iA = bv.a(applicationContext, 25.0f);
                }
                linearLayout.addView(imageViewC, new RelativeLayout.LayoutParams(iA, iA2));
                linearLayout.setOnClickListener(new bb(applicationContext));
                return linearLayout;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static View a(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                ImageView imageView = new ImageView(applicationContext);
                com.component.b.a.a().a(imageView, "ic_white_ad_logo");
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(bv.a(applicationContext, 38.0f), bv.a(applicationContext, 13.0f)));
                relativeLayout.setOnClickListener(new bc(applicationContext));
                return relativeLayout;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static ImageView c(Context context, String str) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (com.baidu.mobads.container.util.d.d.a(context).g(str)) {
            com.baidu.mobads.container.util.d.d.a(context).b(imageView, str);
        } else if (com.baidu.mobads.container.h.k.equals(str)) {
            imageView.setImageBitmap(n.a());
        } else if (com.baidu.mobads.container.h.l.equals(str)) {
            imageView.setImageBitmap(n.b());
        } else if (com.baidu.mobads.container.h.m.equals(str)) {
            imageView.setImageBitmap(n.c());
        }
        b(context, str);
        return imageView;
    }

    public static void a(Context context, String str) {
        SPUtils sPUtils = new SPUtils(context, com.baidu.mobads.container.h.n);
        if (str.equals(com.baidu.mobads.container.h.k)) {
            sPUtils.a(com.baidu.mobads.container.h.o, System.currentTimeMillis());
        } else if (str.equals(com.baidu.mobads.container.h.l)) {
            sPUtils.a(com.baidu.mobads.container.h.p, System.currentTimeMillis());
        }
    }

    public static boolean a(long j, Context context, String str) {
        long jB;
        SPUtils sPUtils = new SPUtils(context, com.baidu.mobads.container.h.n);
        if (str.equals(com.baidu.mobads.container.h.k)) {
            jB = sPUtils.b(com.baidu.mobads.container.h.o, 0L);
        } else if (!str.equals(com.baidu.mobads.container.h.l)) {
            jB = 0;
        } else {
            jB = sPUtils.b(com.baidu.mobads.container.h.p, 0L);
        }
        if (jB != 0 && System.currentTimeMillis() - jB < j) {
            return false;
        }
        return true;
    }

    public static boolean a(String str, long j, Context context) {
        if (context != null && str != null && com.baidu.mobads.container.util.d.d.a(context).g(str) && !a(j, context, str)) {
            return false;
        }
        return true;
    }

    public static void b(Context context, String str) {
        if (a(str, 259200000L, context)) {
            com.baidu.mobads.container.util.d.d.a(context).i(str);
            com.baidu.mobads.container.util.d.d.a(context).e(str);
            a(context, str);
        }
    }

    public static void b(Context context) {
        if (context != null) {
            SPUtils sPUtils = new SPUtils(context, com.baidu.mobads.container.h.n);
            String string = sPUtils.getString(com.baidu.mobads.container.h.q, "");
            if (!TextUtils.isEmpty(string)) {
                n.a = string;
            }
            String string2 = sPUtils.getString(com.baidu.mobads.container.h.r, "");
            if (!TextUtils.isEmpty(string2)) {
                n.b = string2;
            }
        }
    }
}
