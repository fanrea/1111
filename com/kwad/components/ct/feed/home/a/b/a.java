package com.kwad.components.ct.feed.home.a.b;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.api.model.feed.FeedSlideParam;
import com.kwad.components.ct.feed.b;
import com.kwad.components.ct.home.adx.AdxAdTemplate;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.n;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.feed.home.a.a.a implements View.OnClickListener {
    private RecyclerView Wj;
    private ImageView aFw;
    private TextView aFx;
    private b.a aFy;
    private boolean aFz = true;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private CtAdTemplate mAdTemplate;
    private Handler mHandler;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFw = (ImageView) findViewById(R.id.ksad_feed_item_cover);
        this.aFx = (TextView) findViewById(R.id.ksad_feed_item_photo_desc);
        this.aFw.setOnClickListener(this);
        TextView textView = this.aFx;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        getRootView().setOnClickListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        this.Wj = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).Wj;
        this.avY = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).avY;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aFy != null) {
            com.kwad.components.ct.feed.b.EL().b(this.aFy);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.aFy != null) {
            com.kwad.components.ct.feed.b.EL().b(this.aFy);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        if (view == this.aFw) {
            if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
                com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 83);
            }
        } else if (view == this.aFx) {
            if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
                com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 24);
            }
        } else if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 79);
        }
        Fa();
        By();
    }

    public final a bM(boolean z) {
        this.aFz = false;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Fa() {
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        SceneImpl sceneImpl = ctAdTemplate.mAdScene;
        if (sceneImpl == null) {
            return;
        }
        List<CtAdTemplate> originalAdTemplate = AdxAdTemplate.getOriginalAdTemplate((List<CtAdTemplate>) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).avY.getItems());
        n.d(com.kwad.components.ct.response.a.a.O(originalAdTemplate), ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).mCurrentPosition);
        com.kwad.components.ct.feed.b.EL().w(originalAdTemplate);
        com.kwad.components.ct.feed.b.EL().EO();
        if (this.aFz) {
            com.kwad.components.ct.feed.b.EL().a(Fb());
        }
        FeedSlideParam feedSlideParam = new FeedSlideParam();
        feedSlideParam.mEntryScene = sceneImpl.entryScene;
        feedSlideParam.mSelectedPosition = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).mCurrentPosition;
        feedSlideParam.mIsWallpaperPage = com.kwad.components.ct.response.a.c.G(com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        com.kwad.components.ct.feed.a.a.a(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG, feedSlideParam);
    }

    private b.a Fb() {
        if (this.aFy == null) {
            this.aFy = new C0515a(this);
        }
        return this.aFy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void By() {
        com.kwad.components.ct.e.b.JK().d((CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM, 1);
    }

    /* renamed from: com.kwad.components.ct.feed.home.a.b.a$a, reason: collision with other inner class name */
    static class C0515a implements b.a, cb.a {
        private WeakReference<a> XQ;
        private final int aFA = 100;

        public C0515a(a aVar) {
            this.XQ = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.ct.feed.b.a
        public final void ck(int i) {
            com.kwad.sdk.core.d.c.d("FeedHomeItemClickPresenter", "position=" + i);
            a aVar = this.XQ.get();
            if (aVar == null || aVar.avY == null) {
                return;
            }
            aVar.avY.refresh();
            if (aVar.mHandler == null) {
                aVar.mHandler = new cb(this);
            }
            Message messageObtain = Message.obtain(aVar.mHandler);
            messageObtain.what = 100;
            messageObtain.arg1 = i;
            aVar.mHandler.sendMessageDelayed(messageObtain, 100L);
        }

        @Override // com.kwad.sdk.utils.cb.a
        public final void a(Message message) {
            a aVar = this.XQ.get();
            if (aVar != null && message.what == 100) {
                aVar.Wj.scrollToPosition(message.arg1);
            }
        }
    }
}
