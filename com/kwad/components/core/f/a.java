package com.kwad.components.core.f;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.e;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.g;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bs;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements h {
    private String RO;
    private long RP;
    private String RQ;
    private Context mContext;

    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return -200;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        try {
            this.mContext = context;
            ao(context);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "initGId error : " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql() {
        String strDL = ag.dL(this.mContext);
        String strApY = bs.apY();
        if (TextUtils.isEmpty(strDL)) {
            ag.ap(this.mContext, strApY);
            return;
        }
        if (TextUtils.equals(strDL, strApY)) {
            return;
        }
        this.RO = "";
        this.RP = 0L;
        this.RQ = "";
        ag.am(this.mContext, "");
        ag.e(this.mContext, this.RP);
        ag.ax(this.mContext, this.RQ);
        ag.ap(this.mContext, strApY);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    private void ao(Context context) {
        c.i("EncryptComponentsImpl", "initGId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("64", 0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.bzF)) {
                jSONObject.put("64_level", 1);
            }
            com.kwad.sdk.core.f.c.handlePolicy(jSONObject);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        com.kwad.sdk.core.f.c.a(context, new com.kwad.sdk.core.f.a() { // from class: com.kwad.components.core.f.a.1
            @Override // com.kwad.sdk.core.f.a
            public final void aw(String str) {
                c.d("initGId onSuccess", "deviceInfo：" + str);
                a.this.ql();
                a.this.au(str);
            }

            @Override // com.kwad.sdk.core.f.a
            public final void onFailed(int i, String str) {
                c.e("EncryptComponentsImpl", "initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }
        });
    }

    @Override // com.kwad.sdk.components.h
    public final String qm() {
        return (com.kwad.sdk.core.config.e.Ye() || System.currentTimeMillis() >= qp() || TextUtils.isEmpty(qo())) ? qq() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(String str) {
        if (this.mContext == null || bq.isNullString(str) || bq.isEquals(qq(), str)) {
            return;
        }
        this.RQ = str;
        ag.ax(this.mContext, str);
    }

    @Override // com.kwad.sdk.components.h
    public final void av(String str) {
        if (this.mContext == null || bq.isNullString(str) || bq.isEquals(qo(), str)) {
            return;
        }
        try {
            this.RO = str;
            ag.am(this.mContext, str);
            com.kwad.sdk.core.f.c.setEgid(this.mContext, str);
        } catch (Throwable th) {
            c.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.h
    public final void C(long j) {
        if (this.mContext == null || j <= 0 || j == qp()) {
            return;
        }
        this.RP = j;
        ag.e(this.mContext, j);
    }

    @Override // com.kwad.sdk.components.h
    public final g qn() {
        return new com.kwad.sdk.core.a.a();
    }

    private String qo() {
        if (TextUtils.isEmpty(this.RO)) {
            this.RO = ag.dG(this.mContext);
        }
        return this.RO;
    }

    private long qp() {
        if (this.RP == 0) {
            this.RP = ag.dJ(this.mContext);
        }
        return this.RP;
    }

    private String qq() {
        if (TextUtils.isEmpty(this.RQ)) {
            this.RQ = ag.dP(this.mContext);
        }
        return this.RQ;
    }
}
