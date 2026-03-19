package com.style.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.text.util.LocalePreferences;
import com.baidu.mobads.annotation.remote.template.DlDialogJson;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.component.a.a.b;
import com.component.a.g.a;
import com.component.a.i.n;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends RelativeLayout {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final String e = e.class.getSimpleName();
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l = 10;
    private final a m;
    private final com.component.a.g.d n;
    private View o;
    private int p;

    public e(Context context, a aVar) {
        super(context);
        this.p = 0;
        this.m = aVar;
        this.n = new com.component.a.g.d(context, aVar.a, aVar.j, aVar.i);
        this.n.a(new a.C0317a().d(false));
    }

    public void a() {
        a(this.m.f);
    }

    public void a(int i2) {
        JSONObject jSONObjectB = b(i2);
        if (jSONObjectB != null) {
            a(jSONObjectB);
            this.n.a(this, jSONObjectB, new f(this));
        }
    }

    public com.baidu.mobads.container.util.animation.a b() {
        if (this.o != null) {
            try {
                String strE = e();
                if (!TextUtils.isEmpty(strE)) {
                    JSONObject jSONObject = new JSONObject(strE);
                    String strOptString = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(strOptString)) {
                        return com.baidu.mobads.container.util.animation.a.a(this.o).a(jSONObject.optInt("duration", -1)).b(jSONObject.optInt(b.e.c, 0)).c(jSONObject.optInt("repeat", -2)).a(jSONObject.optJSONArray("params")).a(jSONObject.optString("interpolator", "linear")).b(jSONObject.optString("start", "")).c(jSONObject.optString(PointCategory.END, "")).d(strOptString);
                    }
                    return null;
                }
                return null;
            } catch (Throwable th) {
                bq.a().a(th);
                return null;
            }
        }
        return null;
    }

    public boolean c() {
        return this.m.k;
    }

    private JSONObject b(int i2) {
        if (i2 != 1 && this.m.g != 1 && this.m.g != 10) {
            this.p = 1;
            return this.m.a(1);
        }
        this.p = this.m.g;
        return this.m.e;
    }

    private String e() {
        switch (this.p) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 10:
                return "{\"type\":\"exit\",\"duration\":200,\"interpolator\":\"acc\",\"delay\":0,\"repeat\":0,\"params\":[\"translate\",\"bottom\"]}";
            case 1:
            case 2:
                return "{\"type\":\"exit\",\"duration\":200,\"interpolator\":\"acc\",\"delay\":0,\"repeat\":0,\"params\":[\"alpha\"]}";
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                return "";
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            n.a(jSONObject, new g(this, getContext()));
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.f.e eVar, JSONObject jSONObject, String str) {
        if (eVar != null && jSONObject != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObjectF = eVar.f();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject != null && jSONObjectF != null) {
                a(jSONObjectF, jSONObjectOptJSONObject);
                b(jSONObjectF, jSONObjectOptJSONObject);
                c(jSONObjectF, jSONObjectOptJSONObject);
                d(jSONObjectF, jSONObjectOptJSONObject);
            }
        }
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        int iOptInt;
        int iOptInt2;
        try {
            if (jSONObject2.has("w_rate")) {
                jSONObject.put("w_rate", jSONObject2.optDouble("w_rate", 0.0d));
                jSONObject.remove("w");
            }
            if (jSONObject2.has("h_rate")) {
                jSONObject.put("h_rate", jSONObject2.optDouble("h_rate", 0.0d));
                jSONObject.remove("h");
            }
            if (jSONObject2.has("w") && (iOptInt2 = jSONObject2.optInt("w", -1)) != -2) {
                jSONObject.put("w", iOptInt2);
                jSONObject.remove("w_rate");
            }
            if (jSONObject2.has("h") && (iOptInt = jSONObject2.optInt("h", -2)) != -2) {
                jSONObject.put("h", iOptInt);
                jSONObject.remove("h_rate");
            }
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        String strA;
        try {
            switch (jSONObject2.optInt("anim_style", this.m.h)) {
                case 1:
                    strA = a("breathe", 0, -1, 2000, (float) jSONObject2.optDouble("cornerradius", 0.5d));
                    break;
                case 2:
                    strA = a("swipe", 0, -1, 3000, -2.0f);
                    break;
                case 3:
                    strA = a("guide", 0, -1, 2000, -2.0f);
                    break;
                default:
                    strA = "";
                    break;
            }
            jSONObject.put("anim", strA);
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    private String a(String str, int i2, int i3, int i4, float f2) {
        try {
            return String.format(Locale.US, "[{\"type\":\"%s\",\"delay\":%d,\"repeat\":%d,\"duration\":%d,\"radius_rate\":%f}]", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2));
        } catch (Throwable th) {
            bq.a().a(e, th);
            return "";
        }
    }

    private void c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has("bgcolor")) {
                jSONObject3.put(TypedValues.Custom.S_COLOR, jSONObject2.optString("bgcolor"));
            }
            if (jSONObject2.has("alpha")) {
                jSONObject3.put("alpha", (float) jSONObject2.optDouble("alpha", 1.0d));
            }
            if (jSONObject2.has("cornerradius")) {
                jSONObject3.put("radius_rate", (float) jSONObject2.optDouble("cornerradius", 0.5d));
            }
            if (jSONObject3.length() > 0) {
                a(jSONObject, "background", jSONObject3);
            }
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    private void d(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has("textcolor")) {
                jSONObject3.put(TypedValues.Custom.S_COLOR, jSONObject2.optString("textcolor"));
            }
            if (jSONObject2.has("textsize")) {
                jSONObject3.put("size", jSONObject2.optInt("textsize", 8));
            }
            if (jSONObject2.has("textstyle")) {
                jSONObject3.put("style", jSONObject2.optInt("textstyle"));
            }
            if (jSONObject3.length() > 0) {
                a(jSONObject, "text", jSONObject3);
            }
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.f.e eVar, JSONObject jSONObject) {
        if (eVar != null && jSONObject != null) {
            try {
                JSONObject jSONObjectF = eVar.f();
                int iOptInt = jSONObject.optInt("dialog_region", 2);
                if (iOptInt == 1) {
                    jSONObjectF.put("click", "ad_click");
                } else if (iOptInt == 2) {
                    jSONObjectF.put("click", com.component.a.g.b.t);
                }
            } catch (Throwable th) {
                bq.a().d(e, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.f.e eVar) {
        if (eVar != null) {
            try {
                eVar.f().put("visibility", this.m.c);
            } catch (Throwable th) {
                bq.a().d(e, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, com.component.a.f.e eVar) {
        JSONObject jSONObjectF;
        if (eVar != null && (jSONObjectF = eVar.f()) != null) {
            Rect rectD = bv.d(context);
            float fB = eVar.b(-1.0f);
            float fC = eVar.c(-1.0f);
            try {
                int iMin = Math.min(rectD.width(), rectD.height());
                if (fB > 0.0f) {
                    jSONObjectF.remove("w_rate");
                    jSONObjectF.put("w", bv.b(context, fB * iMin));
                } else if (eVar.a(-1.0f) > 0.0f && fC > 0.0f) {
                    jSONObjectF.remove("h_rate");
                    jSONObjectF.put("h", bv.b(context, fC * iMin));
                }
            } catch (Throwable th) {
                bq.a().a(e, th);
            }
        }
    }

    private void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            if (jSONObject.has(str)) {
                JSONObject jSONObjectA = n.a(jSONObject, str);
                if (jSONObjectA != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectA.put(next, jSONObject2.opt(next));
                    }
                    jSONObject2 = jSONObjectA;
                }
                jSONObject.put(str, jSONObject2);
                return;
            }
            jSONObject.put(str, jSONObject2);
        } catch (Throwable th) {
            bq.a().a(e, th);
        }
    }

    public static class a {
        private final com.baidu.mobads.container.adrequest.j a;
        private JSONObject b;
        private JSONObject e;
        private com.component.a.g.b j;
        private int c = 1;
        private int f = 1;
        private int g = 0;
        private int h = 0;
        private final by.b i = new by.b("", "", "");
        private boolean k = false;
        private final DlDialogJson d = new DlDialogJson();

        public a(com.baidu.mobads.container.adrequest.j jVar) {
            this.a = a(jVar);
        }

        public a a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.g = jSONObject.optInt("type", this.g);
                this.h = jSONObject.optInt("anim_style", this.h);
            }
            return this;
        }

        public a a(com.component.a.g.b bVar) {
            this.j = bVar;
            return this;
        }

        public a a(String str, String str2, String str3) {
            this.i.a = str;
            this.i.c = str2;
            this.i.b = str3;
            return this;
        }

        public e a(Activity activity, int i) {
            Context applicationContext = activity.getApplicationContext();
            if (i == 1) {
                this.g = 10;
                this.k = true;
            } else {
                this.b = a(applicationContext);
                if (this.b != null) {
                    this.g = this.b.optInt("type", 0);
                    this.k = this.b.optInt("cancel", 0) == 1;
                }
            }
            this.f = a(activity);
            this.e = a(this.g);
            return new e(applicationContext, this);
        }

        private com.baidu.mobads.container.adrequest.j a(com.baidu.mobads.container.adrequest.j jVar) {
            JSONObject jSONObject;
            if (jVar == null) {
                jSONObject = null;
            } else {
                jSONObject = n.b(jVar.getOriginJsonObject());
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.remove("monitors");
                jSONObject.remove(LocalePreferences.FirstDayOfWeek.MONDAY);
            } catch (Throwable th) {
                bq.a().a(th);
            }
            return new XAdInstanceInfoExt(jSONObject);
        }

        private JSONObject a(Context context) {
            if (this.a != null) {
                try {
                    JSONObject originJsonObject = this.a.getOriginJsonObject();
                    if (originJsonObject != null) {
                        com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(context, originJsonObject);
                        this.c = aVar.a("dl_wb_cancel", 1);
                        return aVar.a("dialog_config");
                    }
                    return null;
                } catch (Throwable th) {
                    bq.a().a(e.e, th);
                    return null;
                }
            }
            return null;
        }

        private int a(Activity activity) {
            try {
                return activity.getResources().getConfiguration().orientation;
            } catch (Throwable th) {
                bq.a().a(e.e, th);
                return 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject a(int i) {
            String centerNormalDialog;
            try {
                switch (i) {
                    case 1:
                        centerNormalDialog = this.d.getCenterNormalDialog();
                        break;
                    case 2:
                        centerNormalDialog = this.d.getCenterDecorateDialog();
                        break;
                    case 3:
                        centerNormalDialog = this.d.getFullscreenDialog();
                        break;
                    case 4:
                        centerNormalDialog = this.d.getBottomSmallDialog();
                        break;
                    case 5:
                        centerNormalDialog = this.d.getBottomLargeDialog();
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        centerNormalDialog = this.d.getBottomPopupDialog();
                        break;
                    case 10:
                        centerNormalDialog = this.d.getDownloadPauseNormalDialog();
                        break;
                }
                return new JSONObject(centerNormalDialog);
            } catch (Throwable th) {
                bq.a().a(e.e, th);
                return null;
            }
        }
    }
}
