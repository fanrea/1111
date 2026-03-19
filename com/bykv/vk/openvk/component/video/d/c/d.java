package com.bykv.vk.openvk.component.video.d.c;

import com.bykv.vk.openvk.component.video.d.c.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d implements b {
    private b.h an;
    private b.hc b;
    private b.d c;
    protected boolean d = false;
    private b.c gb;
    private b.InterfaceC0160b h;
    private b.u hc;
    private b.an u;

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.u uVar) {
        this.hc = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.hc hcVar) {
        this.b = hcVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.d dVar) {
        this.c = dVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.an anVar) {
        this.u = anVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.InterfaceC0160b interfaceC0160b) {
        this.h = interfaceC0160b;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.c cVar) {
        this.gb = cVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public final void d(b.h hVar) {
        this.an = hVar;
    }

    public void d() {
        this.hc = null;
        this.c = null;
        this.b = null;
        this.u = null;
        this.an = null;
        this.h = null;
        this.gb = null;
    }

    protected final void hc() {
        try {
            b.u uVar = this.hc;
            if (uVar != null) {
                uVar.hc(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void b() {
        try {
            b.hc hcVar = this.b;
            if (hcVar != null) {
                hcVar.d(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void d(int i) {
        try {
            b.d dVar = this.c;
            if (dVar != null) {
                dVar.d(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void c() {
        try {
            b.an anVar = this.u;
            if (anVar != null) {
                anVar.b(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    protected final void d(int i, int i2, int i3, int i4) {
        try {
            b.h hVar = this.an;
            if (hVar != null) {
                hVar.d(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean d(int i, int i2) {
        try {
            b.InterfaceC0160b interfaceC0160b = this.h;
            if (interfaceC0160b != null) {
                if (interfaceC0160b.d(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    protected final boolean hc(int i, int i2) {
        try {
            b.c cVar = this.gb;
            if (cVar != null) {
                if (cVar.hc(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.an.b.b("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.d.c.b
    public void d(boolean z) {
        this.d = z;
    }
}
