package com.bytedance.adsdk.ugeno.hc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.an.gb;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d<E extends ViewGroup> extends b {
    protected List<b<View>> d;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, d dVar) {
        super(context, dVar);
        this.d = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
    }

    public void d(b bVar) {
        if (bVar == null) {
            return;
        }
        this.d.add(bVar);
        View viewTt = bVar.tt();
        if (viewTt != null) {
            ((ViewGroup) this.u).addView(viewTt);
        }
    }

    public void d(b bVar, ViewGroup.LayoutParams layoutParams) {
        if (bVar == null) {
            return;
        }
        this.d.add(bVar);
        View viewTt = bVar.tt();
        if (viewTt != null) {
            ((ViewGroup) this.u).addView(viewTt, layoutParams);
        }
    }

    public List<b<View>> h() {
        return this.d;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public b d(String str) {
        b<T> bVarC;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.mk)) {
            return this;
        }
        for (b<View> bVar : this.d) {
            if (bVar != null && (bVarC = bVar.c(str)) != 0) {
                return bVarC;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public b hc(String str) {
        b<T> bVarU;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.mq)) {
            return this;
        }
        for (b<View> bVar : this.d) {
            if (bVar != null && (bVarU = bVar.u(str)) != 0) {
                return bVarU;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected b b(String str) {
        b<T> bVarAn;
        if (!TextUtils.isEmpty(str) && tc(str) != null) {
            return this;
        }
        for (b<View> bVar : this.d) {
            if (bVar != null && (bVarAn = bVar.an(str)) != 0) {
                return bVarAn;
            }
        }
        return null;
    }

    public C0176d gb() {
        return new C0176d(this);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.hc.d$d, reason: collision with other inner class name */
    public static class C0176d {
        protected float an;
        protected boolean cb;
        protected boolean de;
        protected boolean e;
        protected float gb;
        protected float h;
        protected boolean jh;
        protected float k;
        protected float mk;
        protected float mq;
        protected ViewGroup.LayoutParams np;
        protected boolean rf;
        protected boolean sy;
        protected float tc;
        protected float tt;
        protected float u;
        protected float uo;
        protected boolean v;
        protected boolean w;
        protected d yi;
        protected boolean yo;
        protected float d = -2.0f;
        protected float hc = -2.0f;
        protected float b = 0.0f;
        protected float c = 0.0f;

        public C0176d(d dVar) {
            this.yi = dVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void d(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1221029593:
                    if (str.equals("height")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        c = 4;
                        break;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        c = 5;
                        break;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        c = 6;
                        break;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        c = 7;
                        break;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        c = 11;
                        break;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.mk = gb.d(context, str2);
                    this.cb = true;
                    break;
                case 1:
                    this.b = gb.d(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.hc = -1.0f;
                        break;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.hc = -2.0f;
                        break;
                    } else {
                        this.hc = gb.d(context, str2);
                        break;
                    }
                case 3:
                    this.u = gb.d(context, str2);
                    break;
                case 4:
                    this.gb = gb.d(context, str2);
                    this.de = true;
                    break;
                case 5:
                    this.tc = gb.d(context, str2);
                    this.e = true;
                    break;
                case 6:
                    this.tt = gb.d(context, str2);
                    this.v = true;
                    break;
                case 7:
                    this.c = gb.d(context, str2);
                    break;
                case '\b':
                    this.mq = gb.d(context, str2);
                    this.yo = true;
                    break;
                case '\t':
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.d = -1.0f;
                        break;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.d = -2.0f;
                        break;
                    } else {
                        this.d = gb.d(context, str2);
                        break;
                    }
                case '\n':
                    this.k = gb.d(context, str2);
                    this.rf = true;
                    break;
                case 11:
                    this.uo = gb.d(context, str2);
                    this.w = true;
                    break;
                case '\f':
                    this.h = gb.d(context, str2);
                    this.sy = true;
                    break;
                case '\r':
                    this.an = gb.d(context, str2);
                    this.jh = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.d + ", mHeight=" + this.hc + ", mMargin=" + this.u + ", mMarginLeft=" + this.an + ", mMarginRight=" + this.h + ", mMarginTop=" + this.gb + ", mMarginBottom=" + this.tt + ", mParams=" + this.np + '}';
        }

        public ViewGroup.LayoutParams d() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.d, (int) this.hc);
            marginLayoutParams.leftMargin = (int) (this.jh ? this.an : this.u);
            marginLayoutParams.rightMargin = (int) (this.sy ? this.h : this.u);
            marginLayoutParams.topMargin = (int) (this.de ? this.gb : this.u);
            marginLayoutParams.bottomMargin = (int) (this.v ? this.tt : this.u);
            return marginLayoutParams;
        }
    }
}
