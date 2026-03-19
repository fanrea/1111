package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.b.e;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import com.component.a.a.b;
import io.netty.util.internal.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends com.bytedance.adsdk.ugeno.hc.d<Swiper> {
    private com.bytedance.adsdk.ugeno.hc.b cj;
    private float ec;
    private float ed;
    private boolean gu;
    private String hg;
    private int ho;
    private float hr;
    private int ic;
    private JSONArray jm;
    private float lv;
    private boolean ox;
    private float p;
    private String rs;
    private boolean tj;
    private float zk;

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(JSONObject jSONObject) {
    }

    public hc(Context context) {
        super(context);
        this.tj = true;
        this.ox = true;
        this.p = 0.0f;
        this.hr = 2000.0f;
        this.hg = "normal";
        this.gu = true;
        this.ho = Color.parseColor("#666666");
        this.ic = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public View d() {
        this.u = new Swiper(this.hc);
        ((Swiper) this.u).d((b) this);
        return this.u;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        JSONArray jSONArray = this.jm;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.u).c((int) this.lv).u((int) this.ed).an((int) this.zk).b(this.gu).hc(this.ic).b(this.ho).hc(this.hg).c(this.tj).d(this.ec).d(this.ox).d((int) this.hr).b(this.gu);
        for (int i = 0; i < this.jm.length(); i++) {
            e eVar = new e(this.hc);
            eVar.d(this.kb);
            com.bytedance.adsdk.ugeno.hc.b<View> bVarHc = eVar.hc(this.cj.zw(), null);
            eVar.hc(this.jm.optJSONObject(i));
            ((Swiper) this.u).d((Swiper) bVarHc);
        }
        if (this.ox) {
            ((Swiper) this.u).hc();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.cj = bVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    c = 0;
                    break;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    c = 1;
                    break;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    c = 2;
                    break;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    c = 3;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c = 4;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c = 5;
                    break;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    c = 6;
                    break;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    c = 7;
                    break;
                }
                break;
            case 109641799:
                if (str.equals(b.e.a)) {
                    c = '\b';
                    break;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    c = '\t';
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c = '\n';
                    break;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    c = 11;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c = '\f';
                    break;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.p = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 1:
                this.ho = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case 2:
                this.zk = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 3:
                this.hg = str2;
                break;
            case 4:
                this.rs = str2;
                break;
            case 5:
                this.gu = com.bytedance.adsdk.ugeno.an.b.d(str2, true);
                break;
            case 6:
                this.ed = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 7:
                this.tj = com.bytedance.adsdk.ugeno.an.b.d(str2, true);
                break;
            case '\b':
                this.hr = com.bytedance.adsdk.ugeno.an.b.d(str2, 500.0f);
                break;
            case '\t':
                this.ec = com.bytedance.adsdk.ugeno.an.b.d(str2, 1.0f);
                break;
            case '\n':
                this.lv = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 11:
                this.ic = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case '\f':
                this.ox = com.bytedance.adsdk.ugeno.an.b.d(str2, true);
                break;
            case '\r':
                this.jm = com.bytedance.adsdk.ugeno.an.hc.d(str2, (JSONArray) null);
                break;
        }
    }
}
