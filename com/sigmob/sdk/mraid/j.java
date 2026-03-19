package com.sigmob.sdk.mraid;

import android.content.Context;
import android.view.View;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class j {
    protected String a;
    String b;

    public interface a {
        void a(Context context, JSONObject args);

        void a(JSONObject args);

        void b(JSONObject args);

        void c(JSONObject args);

        void d(JSONObject args);

        void e(JSONObject args);

        void f(JSONObject args);

        void g(JSONObject args);

        void h(JSONObject args);
    }

    protected j(String uniqueId) {
        this.a = uniqueId;
    }

    public void a(String parentId) {
        this.b = parentId;
    }

    public abstract View b();

    public abstract void c();

    public String d() {
        return this.b;
    }
}
