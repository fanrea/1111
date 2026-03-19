package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.c;
import com.bytedance.adsdk.lottie.jh;
import com.bytedance.adsdk.lottie.tt;
import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.gb;
import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicLottieView extends LottieAnimationView {
    private int an;
    private boolean b;
    private boolean c;
    private Map<String, Bitmap> d;
    private Map<String, String> gb;
    private int h;
    private String hc;
    private int u;

    public void setLottieAppNameMaxLength(int i) {
        this.u = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.an = i;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.h = i;
    }

    public DynamicLottieView(Context context) {
        super(context);
        this.d = new HashMap();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tt();
    }

    public void setImageLottieTosPath(String str) {
        this.hc = str;
    }

    public void setAnimationsLoop(boolean z) {
        this.b = z;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.c = z;
    }

    public void setData(Map<String, String> map) {
        this.gb = map;
    }

    public void tt() {
        if (TextUtils.isEmpty(this.hc)) {
            return;
        }
        setProgress(0.0f);
        d(this.b);
        if (this.c) {
            mk();
        } else {
            tc();
        }
    }

    private void tc() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.hc + ".json");
        setImageAssetDelegate(new c() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.c
            public Bitmap d(final tt ttVar) {
                final String strMq;
                strMq = ttVar.mq();
                strMq.hashCode();
                switch (strMq) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.gb != null) {
                            strMq = (String) DynamicLottieView.this.gb.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.gb != null) {
                            strMq = (String) DynamicLottieView.this.gb.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.d.get(strMq);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.d.d.d.d().u().d(strMq).b(2).d(new gb() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.an.gb
                    @ATSMethod(1)
                    public Bitmap d(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ttVar.d(), ttVar.hc(), false);
                        DynamicLottieView.this.d.put(strMq, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).d(new cb<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(2)
                    public void d(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(1)
                    public void d(mk<Bitmap> mkVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(mkVar.b(), ttVar.d(), ttVar.hc(), false);
                        DynamicLottieView.this.d.put(strMq, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.d(ttVar.mk(), bitmapCreateScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.d.get(strMq);
            }
        });
        if (this.gb != null) {
            jh jhVar = new jh(this);
            String str = this.gb.get("app_name");
            String str2 = this.gb.get("description");
            String str3 = this.gb.get("title");
            if (this.u > 0 && str.length() > this.u) {
                str = str.substring(0, this.u - 1) + "...";
            } else if (this.u <= 0) {
                str = "";
            }
            if (this.an > 0 && str3.length() > this.an) {
                str3 = str3.substring(0, this.an - 1) + "...";
            } else if (this.u <= 0) {
                str3 = "";
            }
            if (this.h > 0 && str2.length() > this.h) {
                str2 = str2.substring(0, this.h - 1) + "...";
            } else if (this.u <= 0) {
                str2 = "";
            }
            jhVar.hc("{appName}", str);
            jhVar.hc("{adTitle}", str3);
            jhVar.hc("{adDesc}", str2);
            setTextDelegate(jhVar);
            setFontAssetDelegate(new b() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.b
                public String hc(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.b
                public Typeface d(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        d();
    }

    private void mk() {
        setAnimationFromUrl(this.hc);
        setImageAssetDelegate(new c() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.c
            public Bitmap d(final tt ttVar) {
                if (ttVar == null) {
                    return null;
                }
                final String strUo = ttVar.uo();
                String strMq = ttVar.mq();
                if (TextUtils.isEmpty(strUo) || !TextUtils.isEmpty(strMq)) {
                    if (TextUtils.isEmpty(strMq) || !TextUtils.isEmpty(strUo)) {
                        strUo = (TextUtils.isEmpty(strMq) || TextUtils.isEmpty(strUo)) ? "" : strUo + strMq;
                    } else {
                        strUo = strMq;
                    }
                }
                if (TextUtils.isEmpty(strUo)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.d == null ? null : (Bitmap) DynamicLottieView.this.d.get(strUo);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.d.d.d.d().u().d(strUo).d(new gb() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.an.gb
                    @ATSMethod(1)
                    public Bitmap d(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, ttVar.d(), ttVar.hc(), false);
                        if (DynamicLottieView.this.d != null) {
                            DynamicLottieView.this.d.put(strUo, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).d(new cb<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(2)
                    public void d(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.an.cb
                    @ATSMethod(1)
                    public void d(mk<Bitmap> mkVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(mkVar.b(), ttVar.d(), ttVar.hc(), false);
                        if (DynamicLottieView.this.d != null) {
                            DynamicLottieView.this.d.put(strUo, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.d(ttVar.mk(), bitmapCreateScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.d == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.d.get(strUo);
            }
        });
        d();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        an();
    }
}
