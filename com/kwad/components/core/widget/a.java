package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends KSFrameLayout implements cb.a {
    private InterfaceC0500a ajX;
    private boolean ajY;
    private boolean ajZ;
    private int aka;
    private boolean akb;
    private long akc;
    private boolean akd;
    private final float ake;
    private final int akf;
    private final View dB;
    private final cb dC;

    /* renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0500a {
        void aD();

        void ae();

        void af();

        void c(View view);

        void onWindowFocusChanged(boolean z);
    }

    public a(Context context, View view) {
        super(context, view);
        this.dC = new cb(this);
        this.aka = 5;
        this.dB = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float fYu = com.kwad.sdk.core.config.e.Yu();
        this.ake = fYu;
        setVisiblePercent(fYu);
        float fYw = com.kwad.sdk.core.config.e.Yw();
        this.akf = (int) ((fYw < 0.0f ? 1.0f : fYw) * 1000.0f);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        InterfaceC0500a interfaceC0500a;
        InterfaceC0500a interfaceC0500a2;
        super.E(view);
        if (this.akf == 0 && (interfaceC0500a2 = this.ajX) != null) {
            interfaceC0500a2.c(view);
            return;
        }
        if (!this.akb) {
            this.akb = true;
            this.akc = System.currentTimeMillis();
            wu();
            wt();
            return;
        }
        if (System.currentTimeMillis() - this.akc <= this.akf || (interfaceC0500a = this.ajX) == null) {
            return;
        }
        interfaceC0500a.c(view);
        wu();
    }

    private void wt() {
        InterfaceC0500a interfaceC0500a;
        if (this.akf == 0 && (interfaceC0500a = this.ajX) != null) {
            interfaceC0500a.c(this.dB);
            return;
        }
        Message messageObtainMessage = this.dC.obtainMessage();
        messageObtainMessage.what = 2;
        this.dC.sendMessageDelayed(messageObtainMessage, this.akf);
    }

    public final void setViewCallback(InterfaceC0500a interfaceC0500a) {
        this.ajX = interfaceC0500a;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0500a interfaceC0500a = this.ajX;
        if (interfaceC0500a != null) {
            interfaceC0500a.onWindowFocusChanged(z);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.aka = 5;
        this.ajY = false;
        this.akb = false;
        wv();
        InterfaceC0500a interfaceC0500a = this.ajX;
        if (interfaceC0500a != null) {
            interfaceC0500a.ae();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        wu();
        this.aka = 0;
        this.akc = 0L;
        this.ajY = true;
        InterfaceC0500a interfaceC0500a = this.ajX;
        if (interfaceC0500a != null) {
            interfaceC0500a.af();
        }
    }

    private void wu() {
        this.dC.removeCallbacksAndMessages(null);
        this.ajZ = false;
    }

    private void wv() {
        if (this.ajZ) {
            return;
        }
        this.ajZ = true;
        this.dC.sendEmptyMessage(1);
    }

    public final void ww() {
        wv();
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (this.ajY) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (ca.a(this.dB, (int) (this.ake * 100.0f), false)) {
                InterfaceC0500a interfaceC0500a = this.ajX;
                if (interfaceC0500a != null) {
                    interfaceC0500a.c(this.dB);
                    return;
                }
                return;
            }
            this.aka = 5;
            this.dC.sendEmptyMessage(1);
            return;
        }
        if (ca.a(this.dB, (int) (this.ake * 100.0f), false)) {
            wu();
            if (this.akb) {
                InterfaceC0500a interfaceC0500a2 = this.ajX;
                if (interfaceC0500a2 != null) {
                    interfaceC0500a2.c(this.dB);
                }
            } else {
                this.akb = true;
                this.akc = System.currentTimeMillis();
                wt();
            }
            this.akd = false;
            cb cbVar = this.dC;
            int i2 = this.aka;
            this.aka = i2 - 1;
            cbVar.sendEmptyMessageDelayed(1, i2 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC0500a interfaceC0500a3 = this.ajX;
        if (interfaceC0500a3 != null && !this.akd) {
            interfaceC0500a3.aD();
        }
        this.akd = true;
        cb cbVar2 = this.dC;
        int i3 = this.aka;
        this.aka = i3 - 1;
        cbVar2.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
    }
}
