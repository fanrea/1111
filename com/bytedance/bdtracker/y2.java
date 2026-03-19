package com.bytedance.bdtracker;

import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class y2 implements q2 {
    public int a;
    public Integer b;
    public String c;
    public String d;
    public long e;

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return this.b == null ? l0.b.a() : CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        if (this.c != null) {
            jSONObject.put("err_code", 2003);
            jSONObject.put("err_message", this.c);
            jSONObject.put("err_underlying_code", this.b);
        }
        jSONObject.put("dim_success", this.a);
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        String strSubstring = this.d;
        if (strSubstring != null) {
            if (StringsKt.contains$default((CharSequence) strSubstring, (CharSequence) "?", false, 2, (Object) null)) {
                strSubstring = strSubstring.substring(0, StringsKt.indexOf$default((CharSequence) strSubstring, "?", 0, false, 6, (Object) null));
                Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (strSubstring != null) {
                return strSubstring;
            }
        }
        return "";
    }

    @Override // com.bytedance.bdtracker.p2
    public int c() {
        return 23;
    }

    @Override // com.bytedance.bdtracker.q2
    public JSONObject d() {
        return q2.a.a(this);
    }

    @Override // com.bytedance.bdtracker.q2
    public String e() {
        return "network_service";
    }

    @Override // com.bytedance.bdtracker.p2
    public List<Integer> f() {
        return CollectionsKt.listOf(new Integer[]{0, 500, 1000, 1500, 2000, 2500, 5000});
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return Long.valueOf(this.e);
    }
}
