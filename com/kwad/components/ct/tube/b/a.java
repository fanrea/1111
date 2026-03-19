package com.kwad.components.ct.tube.b;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final Set<b> aXf;
    private final List<c> aXg;

    public interface b {
        void a(TubeInfo tubeInfo);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    /* renamed from: com.kwad.components.ct.tube.b.a$a, reason: collision with other inner class name */
    public static class C0537a {
        private static final a aXh = new a(0);
    }

    private a() {
        this.aXf = new CopyOnWriteArraySet();
        this.aXg = new CopyOnWriteArrayList();
    }

    public static a Kv() {
        return C0537a.aXh;
    }

    public final c Kw() {
        if (this.aXg.size() > 0) {
            return this.aXg.get(0);
        }
        return null;
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.aXg.add(0, cVar);
        }
    }

    public final void b(c cVar) {
        if (cVar != null) {
            this.aXg.remove(cVar);
        }
    }

    public final void b(TubeInfo tubeInfo) {
        Iterator<b> it = this.aXf.iterator();
        while (it.hasNext()) {
            it.next().a(tubeInfo);
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.aXf.add(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.aXf.remove(bVar);
        }
    }
}
