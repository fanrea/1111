package com.bytedance.sdk.component.tt.hc;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.an;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.d;
import com.bytedance.sdk.component.hc.d.h;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.hc.d.w;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends c {
    public static final com.bytedance.sdk.component.hc.d.d d = new d.C0278d().d().hc();
    public static final com.bytedance.sdk.component.hc.d.d hc = new d.C0278d().hc();
    private com.bytedance.sdk.component.hc.d.d gb;
    private Map<String, String> tc;
    private boolean tt;

    public b(mq mqVar) {
        super(mqVar);
        this.gb = d;
        this.tt = false;
        this.tc = new HashMap();
    }

    public void d(String str, String str2) {
        if (str == null) {
            com.bytedance.sdk.component.tt.c.u.d("GetExecutor", "name cannot be null !!!");
        } else {
            this.tc.put(str, str2);
        }
    }

    public void d(final com.bytedance.sdk.component.tt.d.d dVar) {
        try {
            k.d dVar2 = new k.d();
            if (this.tt) {
                dVar2.d(this.an);
            } else {
                h.d dVar3 = new h.d();
                Uri uri = Uri.parse(this.an);
                dVar3.d(uri.getScheme());
                dVar3.hc(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    dVar3.b(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tc.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tc.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        dVar3.d(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                dVar2.d(dVar3.hc());
            }
            d(dVar2);
            dVar2.d(this.gb);
            dVar2.d((Object) hc());
            this.b.d(dVar2.d().hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bytedance.sdk.component.tt.hc.b.1
                @Override // com.bytedance.sdk.component.hc.d.b
                public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar, IOException iOException) {
                    com.bytedance.sdk.component.tt.d.d dVar4 = dVar;
                    if (dVar4 != null) {
                        dVar4.d(b.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.hc.d.b
                public void onResponse(com.bytedance.sdk.component.hc.d.hc hcVar, cb cbVar) throws IOException {
                    if (dVar != null) {
                        HashMap map = new HashMap();
                        if (cbVar != null) {
                            an anVarH = cbVar.h();
                            if (anVarH != null) {
                                for (int i = 0; i < anVarH.d(); i++) {
                                    map.put(anVarH.d(i), anVarH.hc(i));
                                }
                            }
                            w wVarAn = cbVar.an();
                            dVar.d(b.this, new com.bytedance.sdk.component.tt.hc(cbVar.c(), cbVar.b(), cbVar.u(), map, wVarAn == null ? "" : wVarAn.hc(), cbVar.hc(), cbVar.d()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.tt.c.u.d()) {
                com.bytedance.sdk.component.utils.mq.d(th);
            }
            if (dVar != null) {
                dVar.d(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.tt.hc.c
    public com.bytedance.sdk.component.tt.hc d() {
        try {
            k.d dVar = new k.d();
            String strHc = "";
            if (this.tt) {
                dVar.d(this.an);
            } else {
                h.d dVar2 = new h.d();
                Uri uri = Uri.parse(this.an);
                dVar2.d(uri.getScheme());
                dVar2.hc(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    dVar2.b(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.tc.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.tc.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        dVar2.d(strEncode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                dVar.d(dVar2.hc());
            }
            d(dVar);
            dVar.d(this.gb);
            dVar.d((Object) hc());
            cb cbVarD = this.b.d(dVar.d().hc()).d();
            if (cbVarD == null) {
                return null;
            }
            HashMap map = new HashMap();
            an anVarH = cbVarD.h();
            if (anVarH != null) {
                for (int i = 0; i < anVarH.d(); i++) {
                    map.put(anVarH.d(i), anVarH.hc(i));
                }
            }
            w wVarAn = cbVarD.an();
            if (wVarAn != null) {
                strHc = wVarAn.hc();
            }
            return new com.bytedance.sdk.component.tt.hc(cbVarD.c(), cbVarD.b(), cbVarD.u(), map, strHc, cbVarD.hc(), cbVarD.d());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }
}
