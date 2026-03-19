package com.bytedance.msdk.c;

import android.content.Context;
import android.location.Address;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.zw;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.tt.b.hc {
    private Context hc;
    String d = "sp_multi_ttmadnet_config";
    private final zw b = zw.d("sp_multi_ttmadnet_config", getContext());

    @Override // com.bytedance.sdk.component.tt.b.hc
    public String b() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public int d() {
        return 4741;
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public Address d(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public String hc() {
        return "msdk";
    }

    public d(Context context) {
        this.hc = context;
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public Context getContext() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public int c() {
        return com.bytedance.msdk.hc.hc.d();
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public String u() {
        return np.d();
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public String d(Context context, String str, String str2) {
        return this.b.hc(str, str2);
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public void d(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.b.d(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.b.d(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.b.d(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.b.d(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.b.d(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.tt.b.hc
    public String[] an() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }
}
