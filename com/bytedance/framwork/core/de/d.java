package com.bytedance.framwork.core.de;

import android.content.Context;
import com.bytedance.framwork.core.de.ha.f;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: MonitorManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.framwork.core.de.gh.b {
    private c a;
    private String f;
    private final LinkedList<com.bytedance.framwork.core.de.ef.a> b = new LinkedList<>();
    private final int c = 5;
    private long d = 0;
    private final int e = 120000;
    private boolean g = false;

    public d(Context context, String str) {
        this.a = c.a(context);
        this.f = str;
    }

    public void a() {
        com.bytedance.framwork.core.de.gh.a.a().a(this);
    }

    public void a(String str, String str2, JSONObject jSONObject) {
        if (this.g || jSONObject == null) {
            return;
        }
        a(new com.bytedance.framwork.core.de.ef.a(this.f, str, str2, jSONObject.toString(), System.currentTimeMillis()));
    }

    @Override // com.bytedance.framwork.core.de.gh.b
    public void onTimeEvent(long j) {
        if (this.g) {
            return;
        }
        a(j, false);
    }

    protected void a(com.bytedance.framwork.core.de.ef.a aVar) {
        if (this.b.size() >= 200) {
            a(System.currentTimeMillis(), true);
        }
        this.b.add(aVar);
    }

    public boolean a(long j, boolean z) {
        LinkedList linkedList;
        int size = this.b.size();
        if (size <= 0) {
            return false;
        }
        if (!z && size < 5 && j - this.d <= 120000) {
            return false;
        }
        this.d = j;
        synchronized (this.b) {
            linkedList = new LinkedList(this.b);
            this.b.clear();
        }
        if (f.a(linkedList)) {
            return true;
        }
        try {
            this.a.a(this.f, linkedList);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public void b() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    public void a(boolean z) {
        this.g = z;
    }
}
