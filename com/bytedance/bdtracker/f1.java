package com.bytedance.bdtracker;

import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.IPresetEventObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f1 implements IEventObserver, IPresetEventObserver {
    public final CopyOnWriteArraySet<l0> a = new CopyOnWriteArraySet<>();

    public void a(l0 l0Var) {
        if (l0Var != null) {
            this.a.add(l0Var);
        }
    }

    public void b(l0 l0Var) {
        if (l0Var != null) {
            this.a.remove(l0Var);
        }
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(str, str2, str3, j, j2, str4);
        }
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEventV3(String str, JSONObject jSONObject) {
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onEventV3(str, jSONObject);
        }
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onLaunch(JSONObject jSONObject) {
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onLaunch(jSONObject);
        }
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onPageEnter(JSONObject jSONObject) {
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPageEnter(jSONObject);
        }
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onPageLeave(JSONObject jSONObject) {
        Iterator<l0> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onPageLeave(jSONObject);
        }
    }
}
