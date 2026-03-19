package com.component.a.g.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.component.a.g.c.e;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bx extends e {
    private static final double a = 4.8d;
    private static final String b = "star_view";
    private static final String c = "rating_view";
    private static final String d = "star_rating_view";
    private double e;
    private String[] f;
    private final a g;

    public bx(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar, a aVar2) {
        super(context, jVar, aVar);
        this.g = aVar2;
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        double dDoubleValue;
        if (eVar == null || this.mAdInfo == null) {
            return null;
        }
        try {
            if (b.equals(eVar.s(""))) {
                if (this.g == null) {
                    JSONObject originJsonObject = this.mAdInfo.getOriginJsonObject();
                    dDoubleValue = 4.8d;
                    if (originJsonObject != null) {
                        dDoubleValue = new BigDecimal(originJsonObject.optDouble(RemoteRewardActivity.JSON_BANNER_RATING_ID, 4.8d)).setScale(1, 4).doubleValue();
                    }
                } else {
                    dDoubleValue = this.g.a;
                }
                return new com.style.widget.ae(this.mAppContext, dDoubleValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        try {
            com.component.a.f.e eVarF = dVar.f();
            View viewE = dVar.e();
            if (eVarF != null && viewE != null && d.equals(eVarF.m("")) && (viewE instanceof com.component.a.d.c)) {
                a(eVarF);
                Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(viewE);
                for (View view : mapA.keySet()) {
                    a(view, mapA.get(view));
                }
            }
        } catch (Throwable th) {
        }
    }

    private void a(com.component.a.f.e eVar) {
        JSONObject originJsonObject;
        JSONArray jSONArrayB;
        try {
            JSONObject jSONObjectC = eVar.c();
            if (jSONObjectC != null && (jSONArrayB = com.component.a.i.n.b(jSONObjectC, "src_array")) != null && jSONArrayB.length() >= 3) {
                String[] strArr = new String[jSONArrayB.length()];
                for (int i = 0; i < jSONArrayB.length(); i++) {
                    strArr[i] = jSONArrayB.optString(i);
                }
                this.f = strArr;
            }
        } catch (Exception e) {
        }
        if (this.mAdInfo != null && (originJsonObject = this.mAdInfo.getOriginJsonObject()) != null) {
            double dOptDouble = originJsonObject.optDouble(RemoteRewardActivity.JSON_BANNER_RATING_ID, 0.0d);
            if (dOptDouble > 0.0d) {
                this.e = new BigDecimal(String.valueOf(dOptDouble)).setScale(1, 4).doubleValue();
            } else {
                this.e = 4.8d;
            }
        }
    }

    private void a(View view, com.component.a.f.e eVar) {
        if (eVar == null) {
            return;
        }
        String strM = eVar.m("");
        if (b.equals(strM) && (view instanceof com.component.a.d.a)) {
            ArrayList arrayList = new ArrayList();
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(view);
            for (View view2 : mapA.keySet()) {
                if (mapA.get(view2) != null && (view2 instanceof ImageView)) {
                    arrayList.add(view2);
                }
            }
            com.component.a.i.n.a((List<View>) arrayList, true);
            if (this.f != null && this.f.length >= 3) {
                a(this.e, arrayList, this.f);
                return;
            } else {
                a(this.e, arrayList);
                return;
            }
        }
        if (c.equals(strM) && (view instanceof TextView)) {
            ((TextView) view).setText(String.valueOf(this.e));
        }
    }

    private void a(double d2, List<View> list) {
        Bitmap bitmapB = null;
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < list.size(); i++) {
            d2 -= 1.0d;
            if (d2 >= 0.0d) {
                if (!z) {
                    bitmapB = com.component.b.a.a().b("ic_gold_star");
                }
                z = true;
            } else if (d2 > -1.0d) {
                bitmapB = com.component.b.a.a().b("ic_half_gold_star");
            } else {
                if (!z2) {
                    bitmapB = com.component.b.a.a().b("ic_gray_star");
                }
                z2 = true;
            }
            ((ImageView) list.get(i)).setImageBitmap(bitmapB);
        }
    }

    private void a(double d2, List<View> list, String[] strArr) {
        String str;
        Bitmap bitmapB = null;
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = (ImageView) list.get(i);
            d2 -= 1.0d;
            if (d2 >= 0.0d) {
                str = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    bitmapB = com.component.b.a.a().b("ic_gold_star");
                }
            } else if (d2 > -1.0d) {
                str = strArr[1];
                if (TextUtils.isEmpty(str)) {
                    bitmapB = com.component.b.a.a().b("ic_half_gold_star");
                }
            } else {
                str = strArr[2];
                if (TextUtils.isEmpty(str)) {
                    bitmapB = com.component.b.a.a().b("ic_gray_star");
                }
            }
            if (TextUtils.isEmpty(str)) {
                imageView.setImageBitmap(bitmapB);
            } else {
                com.baidu.mobads.container.util.d.d.a(this.mAppContext).a(imageView, str);
            }
        }
    }

    public static class a {
        private double a = 4.8d;

        public a a(double d) {
            this.a = d;
            return this;
        }
    }
}
