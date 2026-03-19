package com.kwad.components.ct.feed;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile b aFl;
    private List<CtAdTemplate> aFi;
    private List<CtAdTemplate> aFj;
    private List<a> aFk;

    public interface a {
        void ck(int i);
    }

    private b() {
    }

    public static b EL() {
        if (aFl == null) {
            synchronized (b.class) {
                if (aFl == null) {
                    aFl = new b();
                }
            }
        }
        return aFl;
    }

    public final List<CtAdTemplate> Bh() {
        return this.aFi;
    }

    public final void w(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.aFi == null) {
            this.aFi = new ArrayList();
        }
        this.aFi.clear();
        this.aFi.addAll(list);
    }

    public final void Bi() {
        List<CtAdTemplate> list = this.aFi;
        if (list != null) {
            list.clear();
        }
        this.aFi = null;
    }

    public final List<CtAdTemplate> EM() {
        return this.aFj;
    }

    public final void C(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.aFj == null) {
            this.aFj = new ArrayList();
        }
        this.aFj.clear();
        this.aFj.addAll(list);
    }

    public final void EN() {
        List<CtAdTemplate> list = this.aFj;
        if (list != null) {
            list.clear();
        }
        this.aFj = null;
    }

    public final void EO() {
        List<a> list = this.aFk;
        if (list != null) {
            list.clear();
        }
    }

    public final void a(a aVar) {
        if (this.aFk == null) {
            this.aFk = new LinkedList();
        }
        this.aFk.add(aVar);
    }

    public final void b(a aVar) {
        if (this.aFk == null) {
            this.aFk = new LinkedList();
        }
        this.aFk.remove(aVar);
    }

    public final void cj(int i) {
        List<a> list = this.aFk;
        if (list == null) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            it.next().ck(i);
        }
    }
}
