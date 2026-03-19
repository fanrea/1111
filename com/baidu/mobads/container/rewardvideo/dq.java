package com.baidu.mobads.container.rewardvideo;

import android.view.View;
import com.baidu.mobads.container.activity.b;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class dq extends b.a {
    com.component.a.d.c e;
    protected final com.baidu.mobads.container.activity.b f;
    protected NativeRewardActivity.e g;

    public dq(com.component.a.d.c cVar, com.baidu.mobads.container.activity.b bVar) {
        this.e = cVar;
        this.f = bVar;
        this.f.a(this);
    }

    void a(JSONObject jSONObject) {
    }

    void a(View view, String str) {
        com.component.a.f.e eVarB;
        com.component.a.i.f fVarA = com.component.a.i.f.a(view);
        if (fVarA != null && (eVarB = fVarA.b()) != null) {
            if ("super_view".equals(eVarB.s(""))) {
                a(view);
            }
            if ("share".equals(eVarB.n(""))) {
                b(view);
            }
        }
    }

    void a(NativeRewardActivity nativeRewardActivity, int i) {
    }

    void a(NativeRewardActivity nativeRewardActivity) {
    }

    boolean a(int i, int i2) {
        return false;
    }

    void a() {
    }

    void b() {
    }

    protected void a(View view) {
    }

    protected void b(View view) {
    }

    protected void c(View view) {
    }

    boolean a(View view, boolean z, com.component.a.f.d dVar) {
        return false;
    }

    boolean a(View view, int i) {
        return false;
    }

    boolean d(View view) {
        return false;
    }

    boolean e(View view) {
        return false;
    }
}
