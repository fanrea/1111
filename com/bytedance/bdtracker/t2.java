package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.q2;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class t2 implements r2 {
    public final Throwable a;

    public t2(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        this.a = th;
    }

    @Override // com.bytedance.bdtracker.p2
    public List<String> a() {
        return TextUtils.isEmpty(this.a.getMessage()) ? l0.b.a() : CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.bdtracker.q2
    public void a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        StringWriter stringWriter = new StringWriter();
        this.a.printStackTrace(new PrintWriter(stringWriter));
        String message = this.a.getMessage();
        if (message == null) {
            message = "unknown";
        }
        jSONObject.put("err_underlying_code", message);
        jSONObject.put("err_message", stringWriter.toString());
    }

    @Override // com.bytedance.bdtracker.q2
    public String b() {
        return "db_exception";
    }

    @Override // com.bytedance.bdtracker.p2
    public int c() {
        return 7;
    }

    @Override // com.bytedance.bdtracker.q2
    public JSONObject d() {
        return q2.a.a(this);
    }

    @Override // com.bytedance.bdtracker.q2
    public String e() {
        return "data_statistics";
    }

    @Override // com.bytedance.bdtracker.p2
    public List<Number> f() {
        return l0.b.d();
    }

    @Override // com.bytedance.bdtracker.q2
    public Object g() {
        return 1;
    }
}
