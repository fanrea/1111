package com.kwad.components.core.webview.tachikoma.d;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.c.g;
import com.kwad.sdk.utils.bs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends a {
    private String Cz;
    private FrameLayout aac;
    private e ahi;
    private p ajv;
    private ba ajw;
    private com.kwad.components.core.webview.tachikoma.f.e ajx = new com.kwad.components.core.webview.tachikoma.f.e() { // from class: com.kwad.components.core.webview.tachikoma.d.c.2
        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void he() {
            if (c.this.ajw != null) {
                c.this.ajw.vd();
                c.this.ajw.ve();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.e
        public final void hm() {
            if (c.this.ajw != null) {
                c.this.ajw.vf();
                c.this.ajw.vg();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0490a c0490a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_dialog";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aac = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        e eVar = this.ahi;
        if (eVar != null) {
            eVar.a(this.ajx);
        }
        if (this.ajp.ajr != null) {
            this.hF.a(new g() { // from class: com.kwad.components.core.webview.tachikoma.d.c.1
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    c.this.ajp.ajr.callTKBridge(str);
                }
            });
            this.ajp.ajr.a(this.hF);
            this.hF.a("hasTKBridge", Boolean.TRUE);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a
    protected final void a(b bVar) {
        super.a(bVar);
        this.Cz = this.ajp.Cz;
        this.ahi = this.ajp.ahi;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        FrameLayout frameLayout = this.aac;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.aac.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            aVar.width = (int) ((bs.getScreenWidth(getContext()) / fBv) + 0.5f);
            aVar.height = (int) ((bs.getScreenHeight(getContext()) / fBv) + 0.5f);
        } else {
            aVar.width = (int) ((width / fBv) + 0.5f);
            aVar.height = (int) ((height / fBv) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
        this.ajv = pVar;
        long j = this.ajp.CF;
        if (this.ajv == null || j <= 0) {
            return;
        }
        z zVar = new z();
        zVar.sp = (int) ((j / 1000.0f) + 0.5f);
        this.ajv.a(zVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
        super.aF();
        if (this.ajp.ajt) {
            if (this.ajp.ZP != null) {
                this.ajp.ZP.G(true);
            }
        } else {
            e eVar = this.ahi;
            if (eVar != null) {
                eVar.dismiss();
            }
            if (this.ajp.ZP != null) {
                this.ajp.ZP.hn();
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ba baVar) {
        this.ajw = baVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        e eVar = this.ahi;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (this.ajp.ZP != null) {
            this.ajp.ZP.G(true);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.a, com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        if (this.ajp.ajr != null) {
            this.ajp.ajr.callbackDialogDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        if (this.ajp.ZR != null) {
            return this.ajp.ZR.templateId;
        }
        return this.Cz;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.aac;
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.ahi;
        if (eVar != null) {
            if (eVar.isShowing()) {
                this.ahi.d(new DialogInterface.OnDismissListener() { // from class: com.kwad.components.core.webview.tachikoma.d.c.3
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        c.this.ahi.e(this);
                        c.this.wh();
                    }
                });
            } else {
                wh();
            }
            this.ahi.dismiss();
            return;
        }
        wh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        if (this.ajp.aju != null) {
            this.ajp.aju.hg();
        }
        com.kwad.components.core.webview.tachikoma.e.c.wq().t(getTkTemplateId(), getTKReaderScene());
        if (this.ajp.ajr != null) {
            this.ajp.ajr.callbackPageStatus(false, "render failed");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        if (this.ajp.ajr != null) {
            this.ajp.ajr.callbackPageStatus(true, null);
        }
    }
}
