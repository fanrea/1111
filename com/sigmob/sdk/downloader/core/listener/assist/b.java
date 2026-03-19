package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b<T extends c> implements d {
    InterfaceC0737b a;
    private a b;
    private final e<T> c;

    public interface a {
        boolean a(f task, int blockIndex, long increaseBytes, c model);

        boolean a(f task, int blockIndex, c model);

        boolean a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint, c model);

        boolean a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, c model);
    }

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.b$b, reason: collision with other inner class name */
    public interface InterfaceC0737b {
        void a(f task, int blockIndex, com.sigmob.sdk.downloader.core.breakpoint.a info);

        void a(f task, long currentOffset);

        void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint, c model);

        void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, c model);

        void d(f task, int blockIndex, long currentBlockOffset);
    }

    public static class c implements e.a {
        com.sigmob.sdk.downloader.core.breakpoint.c a;
        long b;
        SparseArray<Long> c;
        private final int d;

        public c(int id) {
            this.d = id;
        }

        public long a(int blockIndex) {
            return this.c.get(blockIndex).longValue();
        }

        SparseArray<Long> a() {
            return this.c;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c info) {
            this.a = info;
            this.b = info.i();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int iG = info.g();
            for (int i = 0; i < iG; i++) {
                sparseArray.put(i, Long.valueOf(info.b(i).a()));
            }
            this.c = sparseArray;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.d;
        }

        public long c() {
            return this.b;
        }

        public SparseArray<Long> d() {
            return this.c.clone();
        }

        public com.sigmob.sdk.downloader.core.breakpoint.c e() {
            return this.a;
        }
    }

    public b(e.b<T> creator) {
        this.c = new e<>(creator);
    }

    b(e<T> handler) {
        this.c = handler;
    }

    public void a(a assistExtend) {
        this.b = assistExtend;
    }

    public void a(InterfaceC0737b callback) {
        this.a = callback;
    }

    public void a(f task, int blockIndex) {
        InterfaceC0737b interfaceC0737b;
        c cVar = (c) this.c.b(task, task.y());
        if (cVar == null) {
            return;
        }
        a aVar = this.b;
        if ((aVar == null || !aVar.a(task, blockIndex, cVar)) && (interfaceC0737b = this.a) != null) {
            interfaceC0737b.a(task, blockIndex, cVar.a.b(blockIndex));
        }
    }

    public void a(f task, int blockIndex, long increaseBytes) {
        InterfaceC0737b interfaceC0737b;
        c cVar = (c) this.c.b(task, task.y());
        if (cVar == null) {
            return;
        }
        long jLongValue = cVar.c.get(blockIndex).longValue() + increaseBytes;
        cVar.c.put(blockIndex, Long.valueOf(jLongValue));
        cVar.b += increaseBytes;
        a aVar = this.b;
        if ((aVar == null || !aVar.a(task, blockIndex, increaseBytes, cVar)) && (interfaceC0737b = this.a) != null) {
            interfaceC0737b.d(task, blockIndex, jLongValue);
            this.a.a(task, cVar.b);
        }
    }

    public void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint) {
        InterfaceC0737b interfaceC0737b;
        c cVar = (c) this.c.a(task, info);
        a aVar = this.b;
        if ((aVar == null || !aVar.a(task, info, fromBreakpoint, cVar)) && (interfaceC0737b = this.a) != null) {
            interfaceC0737b.a(task, info, fromBreakpoint, cVar);
        }
    }

    public synchronized void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
        c cVar = (c) this.c.c(task, task.y());
        a aVar = this.b;
        if (aVar == null || !aVar.a(task, cause, realCause, cVar)) {
            InterfaceC0737b interfaceC0737b = this.a;
            if (interfaceC0737b != null) {
                interfaceC0737b.a(task, cause, realCause, cVar);
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean isAlwaysRecoverAssistModel) {
        this.c.a(isAlwaysRecoverAssistModel);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.c.a();
    }

    public a b() {
        return this.b;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean isAlwaysRecoverAssistModel) {
        this.c.b(isAlwaysRecoverAssistModel);
    }
}
