package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.animation.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile b d;

    private b() {
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public c d(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(dVar.tt())) {
            return new mk(view, dVar);
        }
        if (j.a.equals(dVar.tt())) {
            return new e(view, dVar);
        }
        if ("ripple".equals(dVar.tt())) {
            return new gb(view, dVar);
        }
        if ("marquee".equals(dVar.tt())) {
            return new h(view, dVar);
        }
        if ("waggle".equals(dVar.tt())) {
            return new cb(view, dVar);
        }
        if ("shine".equals(dVar.tt())) {
            return new mq(view, dVar);
        }
        if ("swing".equals(dVar.tt())) {
            return new k(view, dVar);
        }
        if ("fade".equals(dVar.tt())) {
            return new d(view, dVar);
        }
        if ("rubIn".equals(dVar.tt())) {
            return new tc(view, dVar);
        }
        if ("rotate".equals(dVar.tt())) {
            return new tt(view, dVar);
        }
        if ("cutIn".equals(dVar.tt())) {
            return new an(view, dVar);
        }
        if ("stretch".equals(dVar.tt())) {
            return new uo(view, dVar);
        }
        if ("bounce".equals(dVar.tt())) {
            return new u(view, dVar);
        }
        return null;
    }
}
