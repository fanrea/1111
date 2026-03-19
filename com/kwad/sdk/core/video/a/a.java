package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a implements c {
    private c.e abX;
    private c.i abY;
    private c.b abZ;
    private c.InterfaceC0592c aca;
    private c.d acb;
    private c.a acc;
    private c.f bIn;
    private c.g bIo;
    private c.h bIp;

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.bIn = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.abX = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.abZ = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.acc = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.bIo = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.abY = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0592c interfaceC0592c) {
        this.aca = interfaceC0592c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.acb = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.bIp = hVar;
    }

    public final void resetListeners() {
        this.bIn = null;
        this.abX = null;
        this.acc = null;
        this.abZ = null;
        this.bIo = null;
        this.abY = null;
        this.aca = null;
        this.acb = null;
        this.bIp = null;
    }

    protected final void acC() {
        c.f fVar = this.bIn;
        if (fVar != null) {
            fVar.ua();
        }
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.abX;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.abZ;
        if (bVar != null) {
            bVar.qY();
        }
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.acc;
        if (aVar != null) {
            aVar.aQ(i);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.bIo;
        if (gVar != null) {
            gVar.qZ();
        }
    }

    public final void H(int i, int i2) {
        c.i iVar = this.abY;
        if (iVar != null) {
            iVar.m(i, i2);
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        com.kwad.sdk.core.video.a.b.a.fV("videoPlayError");
        c.InterfaceC0592c interfaceC0592c = this.aca;
        return interfaceC0592c != null && interfaceC0592c.n(i, i2);
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.acb;
        return dVar != null && dVar.o(i, i2);
    }

    protected final void b(TimedText timedText) {
        c.h hVar = this.bIp;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    protected static void L(float f) {
        if (f == 0.0f) {
            com.kwad.sdk.core.video.a.b.a.fV("autoMute");
        } else {
            com.kwad.sdk.core.video.a.b.a.fV("autoVoice");
        }
    }
}
