package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class e extends d implements c.a {

    private static class a implements e.b<c.b> {
        private a() {
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.b b(int id) {
            return new c.b(id);
        }
    }

    public e() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.c());
    }

    private e(com.sigmob.sdk.downloader.core.listener.assist.c assistExtend) {
        super(new com.sigmob.sdk.downloader.core.listener.assist.b(new a()));
        assistExtend.a(this);
        a(assistExtend);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0737b
    public final void a(com.sigmob.sdk.downloader.f task, int blockIndex, com.sigmob.sdk.downloader.core.breakpoint.a info) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0737b
    public final void a(com.sigmob.sdk.downloader.f task, long currentOffset) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0737b
    public final void a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info, boolean fromBreakpoint, b.c model) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0737b
    public final void a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause, b.c model) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0737b
    public final void d(com.sigmob.sdk.downloader.f task, int blockIndex, long currentBlockOffset) {
    }
}
