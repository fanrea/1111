package com.kwad.components.ct;

import android.os.Bundle;
import android.text.TextUtils;
import com.kwad.components.ct.detail.listener.DetailPageListener;
import com.kwad.components.ct.home.i;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.AbstractKsContentPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d extends AbstractKsContentPage {
    protected WeakReference<i> alL;
    private KsContentPage.PageListener alM;
    private KsContentPage.VideoListener alN;
    private C0504d alP;
    private boolean alQ;
    private String alR;
    private String alS;
    private KsContentPage.KsShareListener alT;
    private KsContentPage.ExternalViewControlListener alU;
    private KsContentPage.KsEcBtnClickListener alV;
    private KsContentPage.KsVideoBtnClickListener alW;
    private SceneImpl mAdScene;
    private List<KsContentPage.SubShowItem> alO = new ArrayList();
    private final DetailPageListener alX = new DetailPageListener() { // from class: com.kwad.components.ct.d.1
        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageEnter(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alM != null) {
                d.this.alM.onPageEnter(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageResume(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alM != null) {
                d.this.alM.onPageResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPagePause(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alM != null) {
                d.this.alM.onPagePause(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.DetailPageListener
        public final void onPageLeave(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alM != null) {
                d.this.alM.onPageLeave(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }
    };
    private final com.kwad.components.ct.detail.listener.a alY = new com.kwad.components.ct.detail.listener.a() { // from class: com.kwad.components.ct.d.2
        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alN != null) {
                d.this.alN.onVideoPlayStart(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alN != null) {
                d.this.alN.onVideoPlayPaused(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alN != null) {
                d.this.alN.onVideoPlayResume(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void d(int i, CtAdTemplate ctAdTemplate) {
            if (d.this.alN != null) {
                d.this.alN.onVideoPlayCompleted(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate));
            }
        }

        @Override // com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            if (d.this.alN != null) {
                d.this.alN.onVideoPlayError(com.kwad.components.ct.detail.d.a.m(i, ctAdTemplate), i2, i3);
            }
        }
    };

    public d(SceneImpl sceneImpl) {
        this.mAdScene = sceneImpl;
    }

    public final void bs(String str) {
        this.alR = str;
    }

    public final void bt(String str) {
        this.alS = str;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentPage
    public final KsFragment getFragment2() {
        i iVarWX = wX();
        this.alL = new WeakReference<>(iVarWX);
        a(iVarWX);
        if (!this.alO.isEmpty()) {
            iVarWX.D(this.alO);
            this.alO.clear();
        }
        C0504d c0504d = this.alP;
        if (c0504d != null) {
            iVarWX.c(c0504d);
        }
        Bundle arguments = iVarWX.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBoolean("KEY_INSERTAD_ENABLE", this.alQ);
        arguments.putString("KEY_PushLINK", this.alR);
        arguments.putString("KEY_SHARE_VIDEO_INFO", this.alS);
        return iVarWX;
    }

    protected i wX() {
        return i.c(this.mAdScene);
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public boolean onBackPressed() {
        i iVar;
        WeakReference<i> weakReference = this.alL;
        return (weakReference == null || (iVar = weakReference.get()) == null || !iVar.onBackPressed()) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public boolean onPageLeaveIntercept(KsContentPage.KsPageLeaveClickListener ksPageLeaveClickListener) {
        i iVar;
        WeakReference<i> weakReference = this.alL;
        return (weakReference == null || (iVar = weakReference.get()) == null || !iVar.onPageLeaveIntercept(ksPageLeaveClickListener)) ? false : true;
    }

    private void a(i iVar) {
        try {
            byte b2 = 0;
            if (this.alT != null) {
                iVar.setShareListener(new b(this.alT, b2));
            } else {
                com.kwad.sdk.core.d.c.w("KsContentPage", "mShareListener is null");
            }
            if (this.alV != null) {
                iVar.setEcBtnClickListener(new a(this.alV, b2));
            } else {
                com.kwad.sdk.core.d.c.w("KsContentPage", "mShareListener is null");
            }
            if (this.alW != null) {
                iVar.setVideoBtnClickListener(new c(this.alW, b2));
            } else {
                com.kwad.sdk.core.d.c.w("KsContentPage", "mShareListener is null");
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void tryToRefresh() {
        i iVar;
        WeakReference<i> weakReference = this.alL;
        if (weakReference == null || (iVar = weakReference.get()) == null) {
            return;
        }
        iVar.tryToRefresh();
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void refreshBySchema(String str) {
        WeakReference<i> weakReference = this.alL;
        if (weakReference != null) {
            i iVar = weakReference.get();
            if (TextUtils.isEmpty(str) || iVar == null) {
                return;
            }
            iVar.refreshBySchema(str);
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setPageListener(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
        if (pageListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alX);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alX);
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setShareListener(KsContentPage.KsShareListener ksShareListener) {
        this.alT = ksShareListener;
        i.a(ksShareListener);
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setExternalViewControlListener(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
        i.a(externalViewControlListener);
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setEcBtnClickListener(KsContentPage.KsEcBtnClickListener ksEcBtnClickListener) {
        this.alV = ksEcBtnClickListener;
        i.a(ksEcBtnClickListener);
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoBtnClickListener(KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener) {
        this.alW = ksVideoBtnClickListener;
        i.a(ksVideoBtnClickListener);
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setVideoListener(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
        if (videoListener == null) {
            com.kwad.components.ct.detail.listener.c.zh().b(this.alY);
        } else {
            com.kwad.components.ct.detail.listener.c.zh().a(this.alY);
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void setAddSubEnable(boolean z) {
        this.alQ = z;
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addSubItem(List<KsContentPage.SubShowItem> list) {
        WeakReference<i> weakReference = this.alL;
        i iVar = weakReference != null ? weakReference.get() : null;
        if (iVar != null) {
            iVar.D(list);
        } else {
            this.alO.addAll(list);
        }
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public int getSubCountInPage() {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return com.kwad.components.ct.home.config.b.ab(this.mAdScene.getPosId());
    }

    @Override // com.kwad.sdk.api.KsContentPage
    public void addPageLoadListener(KsContentPage.OnPageLoadListener onPageLoadListener) {
        C0504d c0504d = new C0504d(onPageLoadListener, this);
        WeakReference<i> weakReference = this.alL;
        i iVar = weakReference != null ? weakReference.get() : null;
        if (iVar != null) {
            iVar.c(c0504d);
        } else {
            this.alP = c0504d;
        }
    }

    /* renamed from: com.kwad.components.ct.d$d, reason: collision with other inner class name */
    static class C0504d implements com.kwad.components.ct.api.a.a.b {
        private final KsContentPage.OnPageLoadListener amd;
        private final KsContentPage ame;

        C0504d(KsContentPage.OnPageLoadListener onPageLoadListener, KsContentPage ksContentPage) {
            this.amd = onPageLoadListener;
            this.ame = ksContentPage;
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void a(boolean z, boolean z2, int i, int i2) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.amd;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadStart(this.ame, i2);
            }
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            KsContentPage.OnPageLoadListener onPageLoadListener = this.amd;
            if (onPageLoadListener != null) {
                onPageLoadListener.onLoadFinish(this.ame, i);
            }
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void onError(int i, String str) {
            try {
                KsContentPage.OnPageLoadListener onPageLoadListener = this.amd;
                if (onPageLoadListener != null) {
                    onPageLoadListener.onLoadError(this.ame, str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static class b implements KsContentPage.KsShareListener {
        private final KsContentPage.KsShareListener amb;

        /* synthetic */ b(KsContentPage.KsShareListener ksShareListener, byte b) {
            this(ksShareListener);
        }

        private b(KsContentPage.KsShareListener ksShareListener) {
            this.amb = ksShareListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsShareListener
        public final void onClickShareButton(String str) {
            KsContentPage.KsShareListener ksShareListener = this.amb;
            if (ksShareListener == null) {
                return;
            }
            ksShareListener.onClickShareButton(str);
        }
    }

    static class a implements KsContentPage.KsEcBtnClickListener {
        private final KsContentPage.KsEcBtnClickListener ama;

        /* synthetic */ a(KsContentPage.KsEcBtnClickListener ksEcBtnClickListener, byte b) {
            this(ksEcBtnClickListener);
        }

        private a(KsContentPage.KsEcBtnClickListener ksEcBtnClickListener) {
            this.ama = ksEcBtnClickListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsEcBtnClickListener
        public final void onOpenKwaiBtnClick() {
            KsContentPage.KsEcBtnClickListener ksEcBtnClickListener = this.ama;
            if (ksEcBtnClickListener == null) {
                return;
            }
            ksEcBtnClickListener.onOpenKwaiBtnClick();
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsEcBtnClickListener
        public final void onGoShoppingBtnClick(String str) {
            KsContentPage.KsEcBtnClickListener ksEcBtnClickListener = this.ama;
            if (ksEcBtnClickListener == null) {
                return;
            }
            ksEcBtnClickListener.onGoShoppingBtnClick(str);
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsEcBtnClickListener
        public final void onCurrentGoodCardClick(String str) {
            KsContentPage.KsEcBtnClickListener ksEcBtnClickListener = this.ama;
            if (ksEcBtnClickListener == null) {
                return;
            }
            ksEcBtnClickListener.onCurrentGoodCardClick(str);
        }
    }

    static class c implements KsContentPage.KsVideoBtnClickListener {
        private final KsContentPage.KsVideoBtnClickListener amc;

        /* synthetic */ c(KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener, byte b) {
            this(ksVideoBtnClickListener);
        }

        private c(KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener) {
            this.amc = ksVideoBtnClickListener;
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsVideoBtnClickListener
        public final void onCommentsClick(int i) {
            KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener = this.amc;
            if (ksVideoBtnClickListener == null) {
                return;
            }
            ksVideoBtnClickListener.onCommentsClick(i);
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsVideoBtnClickListener
        public final void onClickLikeBtn(int i, boolean z) {
            KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener = this.amc;
            if (ksVideoBtnClickListener == null) {
                return;
            }
            ksVideoBtnClickListener.onClickLikeBtn(i, z);
        }

        @Override // com.kwad.sdk.api.KsContentPage.KsVideoBtnClickListener
        public final void onAvatarClick(int i) {
            KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener = this.amc;
            if (ksVideoBtnClickListener == null) {
                return;
            }
            ksVideoBtnClickListener.onAvatarClick(i);
        }
    }
}
