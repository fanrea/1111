package com.component.a;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    private final View a;
    private final Map<String, View> b = new ConcurrentHashMap();
    private final Map<String, View> c = new ConcurrentHashMap();

    public f(View view) {
        this.a = view;
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        LinkedList linkedList = new LinkedList();
        if (this.a instanceof com.component.a.c.c) {
            linkedList.add(this.a);
            while (!linkedList.isEmpty()) {
                KeyEvent.Callback callback = (View) linkedList.poll();
                if (callback instanceof com.component.a.c.c) {
                    com.component.a.i.f lifeCycle = ((com.component.a.c.c) callback).getLifeCycle();
                    if (lifeCycle != null) {
                        com.component.a.f.e eVarB = lifeCycle.b();
                        if (eVarB != null) {
                            String strL = eVarB.l("");
                            String strM = eVarB.m("");
                            if (!this.b.containsKey(strL)) {
                                this.b.put(strL, callback);
                            }
                            if (!this.c.containsKey(strM)) {
                                this.c.put(strM, callback);
                            }
                        }
                    }
                    if (callback instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) callback;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = viewGroup.getChildAt(i);
                            if (childAt instanceof com.component.a.c.c) {
                                linkedList.add(childAt);
                            }
                        }
                    }
                }
            }
        }
    }

    public View a(String str) {
        return this.b.get(str);
    }

    public View b(String str) {
        return this.c.get(str);
    }

    public com.component.a.i.f c(String str) {
        return com.component.a.i.f.a(a(str));
    }

    public com.component.a.i.f d(String str) {
        return com.component.a.i.f.a(b(str));
    }

    public com.component.a.f.e e(String str) {
        return com.component.a.i.f.c(a(str));
    }

    public com.component.a.f.e f(String str) {
        return com.component.a.i.f.c(b(str));
    }

    public JSONObject g(String str) {
        return com.component.a.i.f.b(a(str));
    }

    public JSONObject h(String str) {
        return com.component.a.i.f.b(b(str));
    }
}
