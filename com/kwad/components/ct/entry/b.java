package com.kwad.components.ct.entry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.kwad.components.ct.detail.listener.DetailPageListener;
import com.kwad.components.ct.entry.view.EntryLinearView;
import com.kwad.components.ct.entry.view.EntryTypeTabView;
import com.kwad.components.ct.entry.view.d;
import com.kwad.components.ct.request.f;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.request.l;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.core.AbstractKsEntryElement;
import com.kwad.sdk.utils.ad;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends AbstractKsEntryElement {
    private static com.kwad.components.ct.response.model.cached.a aCQ;
    private com.kwad.components.ct.response.model.a.a aCR;
    private d aCS;
    private BroadcastReceiver aCT;
    private boolean aCU;
    private k.a aCW;
    private KsContentPage.PageListener alM;
    private KsContentPage.VideoListener alN;
    private KsContentPage.KsShareListener alT;
    private boolean aCV = false;
    private AtomicBoolean aCX = new AtomicBoolean(false);
    private final DetailPageListener alX = new DetailPageListener() { // from class: com.kwad.components.ct.entry.b.5
        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageEnter(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alM != null) {
                b.this.alM.onPageEnter(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageResume(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alM != null) {
                b.this.alM.onPageResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPagePause(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alM != null) {
                b.this.alM.onPagePause(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageLeave(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alM != null) {
                b.this.alM.onPageLeave(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }
    };
    private final com.kwad.components.ct.detail.listener.a alY = new com.kwad.components.ct.detail.listener.a() { // from class: com.kwad.components.ct.entry.b.6
        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alN != null) {
                b.this.alN.onVideoPlayStart(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alN != null) {
                b.this.alN.onVideoPlayPaused(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alN != null) {
                b.this.alN.onVideoPlayResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void d(int i, CtAdTemplate ctAdTemplate) {
            if (b.this.alN != null) {
                b.this.alN.onVideoPlayCompleted(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            if (b.this.alN != null) {
                b.this.alN.onVideoPlayError(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate), i2, i3);
            }
        }
    };

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void setTouchIntercept(boolean z) {
    }

    public final void a(com.kwad.components.ct.response.model.a.a aVar) {
        this.aCR = aVar;
        if (aVar.aVj != null) {
            Iterator<CtAdTemplate> it = this.aCR.aVj.iterator();
            while (it.hasNext()) {
                it.next().mRequestCount = 1;
            }
        }
    }

    public final void a(k.a aVar) {
        this.aCW = aVar;
    }

    private void a(final Context context, final KsEntryElement.OnFeedClickListener onFeedClickListener) {
        com.kwad.components.ct.response.model.a.a aVar;
        if (this.aCS == null && (aVar = this.aCR) != null) {
            this.aCU = false;
            int i = aVar.aVa;
            if (i == 1) {
                this.aCU = true;
                this.aCS = (EntryLinearView) View.inflate(context, R.layout.ksad_view_entry_twophoto, null);
            } else if (i == 2) {
                this.aCU = true;
                this.aCS = (d) View.inflate(context, R.layout.ksad_view_entry_viewpager, null);
            } else if (i == 3) {
                this.aCU = true;
                this.aCS = (d) View.inflate(context, R.layout.ksad_view_entry_gifviewpager, null);
            } else if (i == 4) {
                this.aCS = (d) View.inflate(context, R.layout.ksad_view_entryphoto4, null);
            } else if (i == 5) {
                d dVar = (d) View.inflate(context, R.layout.ksad_view_entry_tab, null);
                this.aCS = dVar;
                ((EntryTypeTabView) dVar).setEnableSlideAutoOpen(this.aCV);
            } else {
                this.aCS = new com.kwad.components.ct.entry.view.b(context);
            }
            d dVar2 = this.aCS;
            if (dVar2 != null) {
                if (!dVar2.b(this.aCR)) {
                    this.aCS = new com.kwad.components.ct.entry.view.b(context);
                }
                this.aCS.setOnFeedClickListener(new KsEntryElement.OnFeedClickListener() { // from class: com.kwad.components.ct.entry.b.1
                    @Override // com.kwad.sdk.api.KsEntryElement.OnFeedClickListener
                    public final void handleFeedClick(int i2, int i3, View view) {
                        onFeedClickListener.handleFeedClick(i2, i3, view);
                        if (b.this.aCU && com.kwad.components.ct.a.a.amo.getValue().booleanValue()) {
                            b.this.aG(context);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(Context context) {
        if (this.aCT != null) {
            return;
        }
        this.aCT = new BroadcastReceiver() { // from class: com.kwad.components.ct.entry.b.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                intent.getIntExtra("param_selected_pos", 0);
                if (b.this.aCS != null) {
                    ((View) b.this.aCS).post(new Runnable() { // from class: com.kwad.components.ct.entry.b.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.refresh();
                        }
                    });
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_refresh_entry");
        ad.dq(context.getApplicationContext()).a(this.aCT, intentFilter);
        this.aCS.setOnDetachListener(new d.b() { // from class: com.kwad.components.ct.entry.b.3
            @Override // com.kwad.components.ct.entry.view.d.b
            public final void onDetachedFromWindow() {
                if (b.this.aCS != null) {
                    b bVar = b.this;
                    bVar.aH(((View) bVar.aCS).getContext());
                }
            }
        });
    }

    public final void aH(Context context) {
        ad.dq(context.getApplicationContext()).unregisterReceiver(this.aCT);
        this.aCT = null;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsEntryElement
    public final View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        a(context, onFeedClickListener);
        return (View) this.aCS;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void refresh() {
        if (this.aCW == null || this.aCX.get()) {
            return;
        }
        this.aCX.set(true);
        l.a(this.aCW, new f() { // from class: com.kwad.components.ct.entry.b.4
            @Override // com.kwad.components.core.request.l
            public final void onError(int i, String str) {
                b.this.aCX.set(false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.components.core.request.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(CtAdResultData ctAdResultData) {
                b.this.aCX.set(false);
                if (ctAdResultData.entryInfo != null) {
                    b.this.a(ctAdResultData.entryInfo);
                    if (b.this.aCS instanceof View) {
                        ((View) b.this.aCS).post(new Runnable() { // from class: com.kwad.components.ct.entry.b.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.aCS.b(b.this.aCR);
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final int getEntryViewType() {
        com.kwad.components.ct.response.model.a.a aVar = this.aCR;
        if (aVar != null) {
            return aVar.aVa;
        }
        return 0;
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void setEnableSlideAutoOpen(boolean z) {
        this.aCV = z;
        d dVar = this.aCS;
        if (dVar instanceof EntryTypeTabView) {
            ((EntryTypeTabView) dVar).setEnableSlideAutoOpen(z);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
        if (videoListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alY);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        if (pageListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alX);
        }
    }

    @Override // com.kwad.sdk.api.KsEntryElement
    public final void setShareListener(KsContentPage.KsShareListener ksShareListener) {
        this.alT = ksShareListener;
        com.kwad.components.ct.api.a.a aVarXa = xa();
        if (aVarXa != null) {
            aVarXa.a(this.alT);
        }
    }

    private static com.kwad.components.ct.api.a.a xa() {
        com.kwad.components.ct.api.d dVar = (com.kwad.components.ct.api.d) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.d.class);
        if (dVar != null) {
            return dVar.xa();
        }
        return null;
    }

    public static void a(com.kwad.components.ct.response.model.cached.a aVar) {
        aCQ = aVar;
    }

    public static com.kwad.components.ct.response.model.cached.a wY() {
        return aCQ;
    }

    public static void DV() {
        aCQ = null;
    }
}
