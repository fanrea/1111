package com.kwad.tachikoma.live.message;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.al;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements View.OnClickListener {
    private TextView Dc;
    private al Dd;
    private c De;
    private boolean Dj;
    private int Dk;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final LinkedList<LiveMessage> Df = new LinkedList<>();
    private final LinkedList<LiveMessage> Dg = new LinkedList<>();
    private long Dh = 0;
    private boolean Di = true;
    private al.n pN = new al.n() { // from class: com.kwad.tachikoma.live.message.d.1
        @Override // android.support.v7.widget.al.n
        public final void c(al alVar, int i) {
            if (i == 0 && com.kwad.tachikoma.t.e.b(d.this.Dd, true)) {
                try {
                    d.this.J(false);
                } catch (Throwable unused) {
                }
            }
        }
    };
    private View.OnTouchListener Dl = new View.OnTouchListener() { // from class: com.kwad.tachikoma.live.message.d.2
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                d.this.Dj = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                d.this.Dj = false;
            } else if (motionEvent.getAction() == 2) {
                d.this.ip();
            }
            return false;
        }
    };
    private final Runnable Dm = new Runnable() { // from class: com.kwad.tachikoma.live.message.d.3
        @Override // java.lang.Runnable
        public final void run() {
            d.this.refresh();
        }
    };

    public d(al alVar, c cVar, TextView textView) {
        this.Dd = alVar;
        this.De = cVar;
        this.Dc = textView;
        al alVar2 = this.Dd;
        if (alVar2 != null) {
            alVar2.a(this.pN);
            this.Dd.setOnTouchListener(this.Dl);
        }
        try {
            if (this.Dc != null) {
                this.Dc.setVisibility(8);
                this.Dc.setOnClickListener(this);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(LiveMessage liveMessage) {
        if (liveMessage.isInValid()) {
            return;
        }
        Log.d("LiveMessageController", "addLiveMessage:" + liveMessage.userName);
        this.Df.add(liveMessage);
        Log.d("live message tag", "live message size:" + this.Df.size());
    }

    public final void io() {
        this.mHandler.removeCallbacks(this.Dm);
        this.mHandler.postDelayed(this.Dm, 0L);
    }

    public final void J(boolean z) {
        this.Di = true;
        this.Dk = 0;
        ir();
        K(z);
    }

    public final void ip() {
        this.Di = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mHandler.removeCallbacks(this.Dm);
        iq();
        this.Dh = System.currentTimeMillis();
        this.mHandler.postDelayed(this.Dm, 1200L);
    }

    private void iq() {
        if (this.Df.isEmpty() && this.Dg.isEmpty()) {
            return;
        }
        Log.d("live message tag", "start poll message");
        int iMin = Math.min(this.Df.size(), 8);
        ArrayList arrayList = new ArrayList(iMin);
        while (iMin > 0) {
            arrayList.add(this.Df.poll());
            iMin--;
        }
        for (int size = this.Dg.size(); size > 0; size--) {
            arrayList.add(this.Dg.poll());
        }
        c cVar = this.De;
        if (cVar != null) {
            cVar.a(arrayList);
        }
        if (this.Di) {
            K(false);
            return;
        }
        this.Dk += arrayList.size();
        try {
            is();
        } catch (Throwable unused) {
        }
    }

    private void K(boolean z) {
        if (this.Dj) {
            return;
        }
        c cVar = this.De;
        int itemCount = cVar != null ? cVar.getItemCount() : 0;
        if (itemCount > 0) {
            if (z) {
                al alVar = this.Dd;
                if (alVar != null) {
                    alVar.ar(itemCount - 1);
                    return;
                }
                return;
            }
            al alVar2 = this.Dd;
            if (alVar2 != null) {
                alVar2.smoothScrollToPosition(itemCount - 1);
            }
        }
    }

    private void ir() {
        TextView textView = this.Dc;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void is() {
        if (this.Dk > 99) {
            TextView textView = this.Dc;
            if (textView != null) {
                textView.setText("99+条新消息");
            }
        } else {
            TextView textView2 = this.Dc;
            if (textView2 != null) {
                textView2.setText(this.Dk + "条新消息");
            }
        }
        TextView textView3 = this.Dc;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Dc) {
            J(true);
        }
    }
}
