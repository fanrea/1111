package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements b.a, e.b<b> {
    private a a;

    public interface a {
        void a(f task, int blockIndex, long currentBlockOffset, k blockSpeed);

        void a(f task, int blockIndex, com.sigmob.sdk.downloader.core.breakpoint.a info, k blockSpeed);

        void a(f task, long currentOffset, k taskSpeed);

        void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint, b model);

        void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, k taskSpeed);
    }

    public static class b extends b.c {
        k d;
        SparseArray<k> e;

        public b(int id) {
            super(id);
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.b.c, com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c info) {
            super.a(info);
            this.d = new k();
            this.e = new SparseArray<>();
            int iG = info.g();
            for (int i = 0; i < iG; i++) {
                this.e.put(i, new k());
            }
        }

        public k b(int blockIndex) {
            return this.e.get(blockIndex);
        }

        public k f() {
            return this.d;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(int id) {
        return new b(id);
    }

    public void a(a callback) {
        this.a = callback;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f task, int blockIndex, long increaseBytes, b.c model) {
        b bVar = (b) model;
        bVar.e.get(blockIndex).a(increaseBytes);
        bVar.d.a(increaseBytes);
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(task, blockIndex, model.c.get(blockIndex).longValue(), bVar.b(blockIndex));
        this.a.a(task, model.b, bVar.d);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f task, int blockIndex, b.c model) {
        b bVar = (b) model;
        bVar.e.get(blockIndex).g();
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(task, blockIndex, model.a.b(blockIndex), bVar.b(blockIndex));
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint, b.c model) {
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(task, info, fromBreakpoint, (b) model);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.a
    public boolean a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, b.c model) {
        k kVar;
        b bVar = (b) model;
        if (bVar.d != null) {
            kVar = bVar.d;
            kVar.g();
        } else {
            kVar = new k();
        }
        a aVar = this.a;
        if (aVar == null) {
            return true;
        }
        aVar.a(task, cause, realCause, kVar);
        return true;
    }
}
