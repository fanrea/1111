package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends View implements cb.a {
    private boolean ajY;
    private boolean ajZ;
    private a aks;
    private boolean akt;
    private final int aku;
    private View dB;
    private final cb dC;
    private final AtomicBoolean dD;

    public interface a {
        void fx();
    }

    public d(Context context, View view) {
        super(context);
        this.dC = new cb(this);
        this.dD = new AtomicBoolean(true);
        this.aku = (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f);
        this.dB = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public final void setViewCallback(a aVar) {
        this.aks = aVar;
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onAttachedToWindow:" + this);
        wv();
        this.ajY = false;
        wz();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.d("EmptyView", "onDetachedFromWindow" + this);
        wu();
        this.ajY = true;
        wA();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onFinishTemporaryDetach:" + this.dB.getParent());
        wz();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.d("EmptyView", "onStartTemporaryDetach:" + this.dB.getParent());
        wA();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.d.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    private void wz() {
        this.dD.getAndSet(false);
    }

    private void wA() {
        this.dD.getAndSet(true);
    }

    private void wu() {
        if (this.ajZ) {
            this.dC.removeCallbacksAndMessages(null);
            this.ajZ = false;
        }
    }

    private void wv() {
        if (!this.akt || this.ajZ) {
            return;
        }
        this.ajZ = true;
        this.dC.sendEmptyMessage(1);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.akt = z;
        if (!z && this.ajZ) {
            wu();
        } else {
            if (!z || this.ajZ) {
                return;
            }
            wv();
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!ca.a(this.dB, this.aku, false)) {
                if (this.ajY) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            } else {
                if (message.arg1 == 1000 && (aVar = this.aks) != null) {
                    aVar.fx();
                }
                this.dC.sendEmptyMessageDelayed(2, 500L);
                return;
            }
        }
        com.kwad.sdk.core.d.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.ajZ) {
            if (ca.a(this.dB, this.aku, false)) {
                wu();
                Message messageObtainMessage = this.dC.obtainMessage();
                messageObtainMessage.what = 2;
                messageObtainMessage.arg1 = 1000;
                this.dC.sendMessageDelayed(messageObtainMessage, 1000L);
                return;
            }
            this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
