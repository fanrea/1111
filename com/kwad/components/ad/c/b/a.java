package com.kwad.components.ad.c.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.c.c;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.n.d;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d<c> implements View.OnClickListener, e {
    private KsAdVideoPlayConfig dG;
    private f dQ;
    private List<Integer> dX;
    private FrameLayout dY;
    private ImageView dZ;
    private LinearLayout ea;
    private ImageView eb;
    private boolean ec;
    private com.kwad.sdk.core.video.videoview.a ed;
    private com.kwad.components.ad.c.e ee;
    private LinearLayout ef;
    private TextView eg;
    private TextView eh;
    private TextView ei;
    private ImageView ej;
    private KsLogoView ek;
    public InterfaceC0404a el;
    private a.InterfaceC0593a em;
    private a.b en;
    private OfflineOnAudioConflictListener eo;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* renamed from: com.kwad.components.ad.c.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0404a {
        void a(int i, int i2, AdTemplate adTemplate);

        void ax();

        void e(AdTemplate adTemplate);

        void f(AdTemplate adTemplate);
    }

    @Override // com.kwad.components.core.n.d
    public final boolean am() {
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.ec = false;
        return false;
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC0404a interfaceC0404a) {
        super(context);
        this.mIsAudioEnable = true;
        this.en = new a.b() { // from class: com.kwad.components.ad.c.b.a.1
            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                a.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.cm(a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.ed;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(((c) a.this.Tj).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                if (a.this.el != null) {
                    a.this.el.ax();
                }
            }
        };
        this.eo = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.ed != null) {
                    a.this.ed.setVideoSoundEnable(false);
                }
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.el = interfaceC0404a;
        this.mContext = getContext();
        qG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* renamed from: aq, reason: merged with bridge method [inline-methods] */
    public c ap() {
        f fVar = new f(this.pQ, com.kwad.sdk.core.response.b.a.cU(this.mAdInfo));
        this.dQ = fVar;
        fVar.wK();
        c cVar = new c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    @Override // com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        getContext();
        return ar();
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d
    public final void ao() {
        FrameLayout frameLayout = (FrameLayout) this.pQ.findViewById(R.id.ksad_banner_item_content);
        this.dY = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.pQ.findViewById(R.id.ksad_banner_item_info);
        this.ef = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.pQ.findViewById(R.id.ksad_banner_item_des);
        this.eg = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.eg.setOnClickListener(this);
        TextView textView2 = (TextView) this.pQ.findViewById(R.id.ksad_banner_item_title);
        this.eh = textView2;
        textView2.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        this.eh.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.pQ.findViewById(R.id.ksad_banner_button_base);
        this.ea = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.pQ.findViewById(R.id.ksad_banner_item_button);
        this.ei = textView3;
        textView3.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        this.ei.setOnClickListener(this);
        ImageView imageView = (ImageView) this.pQ.findViewById(R.id.ksad_banner_item_close);
        this.ej = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.pQ.findViewById(R.id.ksad_banner_item_image);
        this.dZ = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.pQ.findViewById(R.id.ksad_banner_item_image_bg);
        this.eb = imageView3;
        imageView3.setOnClickListener(this);
        this.ek = (KsLogoView) this.pQ.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.L(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aY(this.mAdInfo).materialUrl)) {
            int i = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 17;
            this.dZ.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.dZ, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (!com.kwad.sdk.core.response.b.a.bj(this.mAdInfo)) {
            this.dZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.dZ, com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.dZ.setOnClickListener(this);
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAY = com.kwad.sdk.core.response.b.a.aY(this.mAdInfo);
            if (!TextUtils.isEmpty(materialFeatureAY.materialUrl)) {
                int i2 = materialFeatureAY.width;
                int i3 = materialFeatureAY.height;
                if (i2 > 0 && i2 < i3) {
                    this.eb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.eb, com.kwad.sdk.core.response.b.a.P(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i4 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i4 / 16) * 9, i4);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.dZ.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.dZ, com.kwad.sdk.core.response.b.a.aY(this.mAdInfo).materialUrl, this.mAdTemplate);
        }
        this.ek.aQ(this.mAdTemplate);
        this.dY.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strGa;
        if (ksAdVideoPlayConfig == null) {
            ksAdVideoPlayConfig = new KSAdVideoPlayConfigImpl();
        }
        this.dG = ksAdVideoPlayConfig;
        this.mIsAudioEnable = !at();
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        this.ed = new com.kwad.sdk.core.video.videoview.a(getContext());
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.P(this.mAdInfo))) {
            int i = materialFeatureAZ.width;
            int i2 = materialFeatureAZ.height;
            if (i > 0 && i < i2) {
                int i3 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i3 / 16) * 9, i3);
                layoutParams.gravity = 5;
                layoutParams.rightMargin = 14;
                this.ed.setLayoutParams(layoutParams);
            }
        }
        this.ed.setOnClickListener(this);
        int iUw = com.kwad.sdk.core.config.e.Uw();
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        if (iUw < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (fileDw == null || !fileDw.exists()) {
                strL = null;
            } else {
                strGa = fileDw.getAbsolutePath();
                strL = strGa;
            }
        } else if (iUw != 0) {
            com.kwad.sdk.core.videocache.f fVarCh = com.kwad.sdk.core.videocache.c.a.ch(this.mContext);
            if (com.kwad.sdk.core.config.e.XC()) {
                int iUw2 = com.kwad.sdk.core.config.e.Uw();
                if (!fVarCh.gc(strL)) {
                    if (fVarCh.a(strL, iUw2 * 1024, new a.C0589a(), null)) {
                        strGa = fVarCh.ga(strL);
                    }
                } else {
                    strGa = fVarCh.ga(strL);
                }
                strL = strGa;
            } else {
                strL = fVarCh.ga(strL);
            }
        }
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), null);
        a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.ad.c.b.a.6
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
            public final com.kwad.sdk.core.video.a.c aw() {
                int i4 = Build.VERSION.SDK_INT;
                return null;
            }
        };
        this.em = interfaceC0593a;
        this.ed.setExternalPlayerListener(interfaceC0593a);
        this.ed.setVideoSoundEnable(this.mIsAudioEnable);
        this.dG.setVideoAutoPlayType(com.kwad.sdk.core.response.b.a.dG(this.mAdInfo));
        com.kwad.components.ad.c.e eVar = new com.kwad.components.ad.c.e(this.mContext, this.mAdTemplate, this.ed, this.dG);
        this.ee = eVar;
        eVar.setHideEnd(true);
        this.ee.setVideoPlayCallback(this.en);
        this.ed.setController(this.ee);
        this.dY.addView(this.ed);
        this.pQ.findViewById(R.id.ksad_banner_logo).bringToFront();
        this.dY.setClickable(true);
        this.ee.ag();
        new j(getContext(), this.dY, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return R.layout.ksad_banner_item_land;
        }
        return R.layout.ksad_banner_item;
    }

    private static Presenter ar() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ad.c.c.b());
        return presenter;
    }

    public final void as() {
        this.dY.setVisibility(0);
        this.el.e(this.mAdTemplate);
    }

    private boolean at() {
        boolean z;
        boolean z2 = true;
        if (com.kwad.sdk.core.config.e.Yy() || !com.kwad.components.core.u.a.aC(this.mContext).to()) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dG;
            if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
                z = !this.dG.isVideoSoundEnable();
            } else {
                if (com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)) {
                    z2 = false;
                }
                z = z2;
            }
        } else {
            z = z2;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mIsAudioEnable = !z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.Yy()) {
            if (com.kwad.components.core.u.a.aC(this.mContext).tp()) {
                return !com.kwad.components.core.u.a.aC(this.mContext).to();
            }
            return com.kwad.components.core.u.a.aC(this.mContext).aS(false);
        }
        if (!this.ec) {
            this.ec = com.kwad.components.core.u.a.aC(this.mContext).aS(true);
        }
        return this.ec;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.dY || view == this.dZ || view == this.ed || view == this.eb) {
            this.el.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.ef || view == this.ea) {
            this.el.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.eg) {
            this.el.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.eh) {
            this.el.a(31, 2, this.mAdTemplate);
        } else if (view == this.ei) {
            this.el.a(29, 1, this.mAdTemplate);
        } else if (view == this.ej) {
            this.el.f(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            onClick(view);
        }
    }
}
