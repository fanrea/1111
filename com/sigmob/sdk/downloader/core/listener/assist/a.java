package com.sigmob.sdk.downloader.core.listener.assist;

import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a implements d, e.b<b> {
    private final e<b> a;
    private InterfaceC0736a b;

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.a$a, reason: collision with other inner class name */
    public interface InterfaceC0736a {
        void a(f task, int blockCount, long currentOffset, long totalLength);

        void a(f task, long currentOffset, long totalLength);

        void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, b model);

        void a(f task, com.sigmob.sdk.downloader.core.cause.b cause);

        void a(f task, b model);
    }

    public static class b implements e.a {
        final int a;
        Boolean b;
        Boolean c;
        volatile Boolean d;
        int e;
        long f;
        final AtomicLong g = new AtomicLong();

        b(int id) {
            this.a = id;
        }

        public long a() {
            return this.f;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c info) {
            this.e = info.g();
            this.f = info.j();
            this.g.set(info.i());
            if (this.b == null) {
                this.b = false;
            }
            if (this.c == null) {
                this.c = Boolean.valueOf(this.g.get() > 0);
            }
            if (this.d == null) {
                this.d = true;
            }
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.a;
        }
    }

    public a() {
        this.a = new e<>(this);
    }

    a(e<b> handler) {
        this.a = handler;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(int id) {
        return new b(id);
    }

    public void a(InterfaceC0736a callback) {
        this.b = callback;
    }

    public void a(f task) {
        b bVar = (b) this.a.a(task, null);
        InterfaceC0736a interfaceC0736a = this.b;
        if (interfaceC0736a != null) {
            interfaceC0736a.a(task, bVar);
        }
    }

    public void a(f task, long increaseBytes) {
        b bVar = (b) this.a.b(task, task.y());
        if (bVar == null) {
            return;
        }
        bVar.g.addAndGet(increaseBytes);
        InterfaceC0736a interfaceC0736a = this.b;
        if (interfaceC0736a != null) {
            interfaceC0736a.a(task, bVar.g.get(), bVar.f);
        }
    }

    public void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
        b bVar = (b) this.a.b(task, info);
        if (bVar == null) {
            return;
        }
        bVar.a(info);
        bVar.b = true;
        bVar.c = true;
        bVar.d = true;
    }

    public void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, com.sigmob.sdk.downloader.core.cause.b cause) {
        InterfaceC0736a interfaceC0736a;
        b bVar = (b) this.a.b(task, info);
        if (bVar == null) {
            return;
        }
        bVar.a(info);
        if (bVar.b.booleanValue() && (interfaceC0736a = this.b) != null) {
            interfaceC0736a.a(task, cause);
        }
        bVar.b = true;
        bVar.c = false;
        bVar.d = true;
    }

    public void a(f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
        b bVar = (b) this.a.c(task, task.y());
        InterfaceC0736a interfaceC0736a = this.b;
        if (interfaceC0736a != null) {
            interfaceC0736a.a(task, cause, realCause, bVar);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean isAlwaysRecoverAssistModel) {
        this.a.a(isAlwaysRecoverAssistModel);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.a.a();
    }

    public void b(f task) {
        b bVar = (b) this.a.b(task, task.y());
        if (bVar == null) {
            return;
        }
        if (Boolean.TRUE.equals(bVar.c) && Boolean.TRUE.equals(bVar.d)) {
            bVar.d = false;
        }
        InterfaceC0736a interfaceC0736a = this.b;
        if (interfaceC0736a != null) {
            interfaceC0736a.a(task, bVar.e, bVar.g.get(), bVar.f);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean isAlwaysRecoverAssistModel) {
        this.a.b(isAlwaysRecoverAssistModel);
    }
}
