package com.sigmob.sdk.videoAd;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.ViewUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.ImageLoader;
import com.czhj.volley.toolbox.StringUtil;
import com.google.android.material.timepicker.TimeModel;
import com.sigmob.sdk.base.common.aa;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ak;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.s;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.views.an;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.aq;
import com.sigmob.sdk.base.views.au;
import com.sigmob.sdk.base.views.d;
import com.sigmob.sdk.base.views.m;
import com.sigmob.sdk.base.views.o;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.base.views.v;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.base.views.z;
import com.sigmob.sdk.videoAd.f;
import com.sigmob.sdk.videoAd.i;
import com.sigmob.windad.natives.WindNativeAdData;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i extends b implements aa, g.a, com.sigmob.sdk.videocache.d {
    public static final String f = "i";
    static final String g = "video_config";
    private static final String i = "current_position";
    private static final String j = "video_finished";
    private static final String k = "companionAd_visable";
    private static final long l = 50;
    private static final int m = -1;
    private static final int n = 0;
    private static int o;
    private String A;
    private boolean B;
    private final Handler C;
    private boolean D;
    private com.sigmob.sdk.base.views.d E;
    private String F;
    private int G;
    private boolean H;
    private com.sigmob.sdk.videoAd.a I;
    private int J;

    /* renamed from: K, reason: collision with root package name */
    private com.sigmob.sdk.videoplayer.a f795K;
    private BaseAdUnit L;
    private View M;
    private s N;
    private final MediaMetadataRetriever O;
    private aq P;
    private ap Q;
    private w R;
    private f S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private RelativeLayout Z;
    private boolean aa;
    private ap ab;
    private boolean ac;
    private boolean ad;
    private ImageLoader.ImageContainer ae;
    private m af;
    private boolean ag;
    private boolean ah;
    private z ai;
    private boolean aj;
    private q ak;
    private boolean al;
    private w am;
    private w an;
    private ak.a ao;
    private v ap;
    private boolean aq;
    private com.sigmob.sdk.nativead.a ar;
    private w as;
    private boolean at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private String ax;
    private final View.OnClickListener ay;
    private boolean az;
    String h;
    private final int p;
    private com.sigmob.sdk.base.views.b q;
    private ImageView r;
    private RelativeLayout s;
    private int t;
    private boolean u;
    private int v;
    private String w;
    private final List<String> x;
    private final List<String> y;
    private long z;

    /* renamed from: com.sigmob.sdk.videoAd.i$10, reason: invalid class name */
    class AnonymousClass10 implements ak.b {
        AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            i.this.J();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || i.this.L == null || i.this.aq) {
                return;
            }
            i.this.aq = true;
            i.this.L.getClickCommon().sld = "2";
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            if (number != null) {
                i.this.L.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.L.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.L.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            i.this.ap.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$10$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.i$11, reason: invalid class name */
    class AnonymousClass11 implements ak.b {
        AnonymousClass11() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            i.this.J();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || i.this.L == null || i.this.aq) {
                return;
            }
            i.this.aq = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                i.this.L.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.L.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.L.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            i.this.L.getClickCommon().turn_time = String.valueOf(number4);
            i.this.L.getClickCommon().sld = "5";
            i.this.ap.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.i$12, reason: invalid class name */
    class AnonymousClass12 implements ak.b {
        AnonymousClass12() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            i.this.J();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (i.this.ap instanceof an) {
                ((an) i.this.ap).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || i.this.L == null || i.this.aq) {
                return;
            }
            i.this.aq = true;
            Number number = info.get("x_max_acc");
            Number number2 = info.get("y_max_acc");
            Number number3 = info.get("z_max_acc");
            if (number != null) {
                i.this.L.getClickCommon().x_max_acc = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.L.getClickCommon().y_max_acc = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.L.getClickCommon().z_max_acc = String.valueOf(number3.intValue());
            }
            i.this.L.getClickCommon().sld = "2";
            i.this.ap.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.i$13, reason: invalid class name */
    class AnonymousClass13 implements ak.b {
        AnonymousClass13() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            i.this.J();
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a() {
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(float progress) {
            if (i.this.ap instanceof com.sigmob.sdk.base.views.ak) {
                ((com.sigmob.sdk.base.views.ak) i.this.ap).a(progress);
            }
        }

        @Override // com.sigmob.sdk.base.common.ak.b
        public void a(Map<String, Number> info) {
            if (info == null || i.this.L == null || i.this.aq) {
                return;
            }
            i.this.aq = true;
            Number number = info.get("turn_x");
            Number number2 = info.get("turn_y");
            Number number3 = info.get("turn_z");
            Number number4 = info.get("turn_time");
            if (number != null) {
                i.this.L.getClickCommon().turn_x = String.valueOf(number.intValue());
            }
            if (number2 != null) {
                i.this.L.getClickCommon().turn_y = String.valueOf(number2.intValue());
            }
            if (number3 != null) {
                i.this.L.getClickCommon().turn_z = String.valueOf(number3.intValue());
            }
            i.this.L.getClickCommon().turn_time = String.valueOf(number4);
            i.this.L.getClickCommon().sld = "5";
            i.this.ap.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$13$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            }, 400L);
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.i$6, reason: invalid class name */
    class AnonymousClass6 extends com.sigmob.sdk.base.l {
        AnonymousClass6() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setUrl(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            SigmobLog.d("onPageFinished: ");
            i.this.w = "done";
        }

        @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            SigmobLog.d("onPageStarted: ");
        }

        @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            if (failingUrl.startsWith("http://")) {
                return;
            }
            i.this.w = "error";
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            if (Build.VERSION.SDK_INT >= 21) {
                String host = request.getUrl().getHost();
                if (TextUtils.isEmpty(host) || !host.equals("localhost")) {
                    return;
                }
                i.this.w = "error";
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Uri uri;
            String host;
            String scheme;
            try {
                SigmobLog.d("load url " + url);
                uri = Uri.parse(url);
                host = uri.getHost();
                scheme = uri.getScheme();
                if (!TextUtils.isEmpty(host)) {
                    if (!"track".equals(host) && !"active".equals(host)) {
                        if ("openFourElements".equals(host)) {
                            i.this.b(2);
                            return true;
                        }
                    }
                    String queryParameter = uri.getQueryParameter("data");
                    String queryParameter2 = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                    if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                        final String str = new String(Base64.decode(queryParameter, 0), "utf-8");
                        ac.a(host, queryParameter2, i.this.L, new ac.a() { // from class: com.sigmob.sdk.videoAd.i$6$$ExternalSyntheticLambda0
                            @Override // com.sigmob.sdk.base.common.ac.a
                            public final void onAddExtra(Object obj) {
                                i.AnonymousClass6.a(str, obj);
                            }
                        });
                    }
                    return true;
                }
            } catch (Throwable unused) {
                SigmobLog.e("webview");
            }
            if (i.this.aa) {
                return true;
            }
            if (i.this.L.getMaterial().disable_auto_deeplink.booleanValue() && !i.this.B) {
                return TextUtils.isEmpty(scheme) || !scheme.startsWith(com.alipay.sdk.m.l.a.r);
            }
            if (i.this.L.getMaterial().click_type.intValue() == com.sigmob.sdk.base.common.k.Button.a() || TextUtils.isEmpty(i.this.L.getLanding_page()) || i.this.L.getMaterial().creative_type.intValue() == com.sigmob.sdk.base.common.l.CreativeTypeVideo_EndCardURL.a()) {
                i.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                i.this.L.getClickCommon().click_scene = "endcard";
                if (i.this.Q.getVisibility() != 0 || TextUtils.isEmpty(scheme)) {
                    if (!TextUtils.isEmpty(scheme) && (scheme.equals(com.alipay.sdk.m.l.a.r) || scheme.equals("https"))) {
                        if (i.this.ah) {
                            i.this.W();
                            i.this.ah = false;
                        }
                        view.loadUrl(url);
                    }
                } else if (!StringUtil.scheme().equalsIgnoreCase(scheme) || TextUtils.isEmpty(host) || !host.equalsIgnoreCase("download") || TextUtils.isEmpty(i.this.L.getMaterial().landing_page)) {
                    try {
                        LinkAction linkActionA = com.sigmob.sdk.videoplayer.c.a(i.this.L.getAdLinkActions(), uri);
                        if (linkActionA == null) {
                            linkActionA = com.sigmob.sdk.videoplayer.c.a(i.this.L.getSlotAdLinkActions(), uri);
                        }
                        if (linkActionA != null && linkActionA.redirect_count.intValue() <= i.this.L.getRedirectCount(uri)) {
                            return true;
                        }
                        if (!scheme.equalsIgnoreCase(com.alipay.sdk.m.l.a.r) && !scheme.equalsIgnoreCase("https")) {
                            i.this.L.addRedirectCount(uri);
                            i.this.L.setCustomDeeplink(url);
                            i.this.I.a(com.sigmob.sdk.base.a.ENDCARD, i.this.h, true);
                            return true;
                        }
                        view.loadUrl(url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    i.this.I.a(com.sigmob.sdk.base.a.ENDCARD, i.this.h, true);
                }
            } else if (i.this.L.getMaterial().click_type.intValue() == com.sigmob.sdk.base.common.k.FullScreen.a()) {
                TextUtils.isEmpty(i.this.L.getLanding_page());
                return true;
            }
            return true;
        }
    }

    /* renamed from: com.sigmob.sdk.videoAd.i$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[com.sigmob.sdk.base.a.values().length];
            b = iArr;
            try {
                iArr[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[com.sigmob.sdk.base.a.MOTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.videoplayer.d.values().length];
            a = iArr2;
            try {
                iArr2[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static class a {
        a() {
        }

        @JavascriptInterface
        public int getInteractionType() {
            return i.o;
        }

        @JavascriptInterface
        public String getSdkVersion() {
            return n.k;
        }
    }

    public i(Activity activity, BaseAdUnit adUnit, Bundle intentExtras, Bundle savedInstanceState, String broadcastIdentifier, com.sigmob.sdk.base.common.j controllerListener) throws IllegalStateException {
        super(activity, broadcastIdentifier, controllerListener);
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.w = "undone";
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.A = "none";
        this.C = new Handler(Looper.getMainLooper());
        this.D = true;
        this.L = null;
        this.O = new MediaMetadataRetriever();
        this.T = 0;
        this.Y = false;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        this.ag = false;
        this.aj = false;
        this.al = false;
        this.ay = new View.OnClickListener() { // from class: com.sigmob.sdk.videoAd.i.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activityN = i.this.n();
                if (activityN == null || i.this.L == null) {
                    return;
                }
                i iVar = i.this;
                if (iVar.a((Dialog) iVar.ar)) {
                    return;
                }
                i.this.ar = new com.sigmob.sdk.nativead.a(activityN, i.this.L);
                i.this.ar.a();
                i.this.ar.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.videoAd.i.9.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        i.this.N();
                        i.this.G();
                        if (i.this.ao == null) {
                            return;
                        }
                        i.this.ao.a();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int position, String value, boolean enforce) {
                        i.this.N();
                        i.this.G();
                        if (i.this.ao == null) {
                            return;
                        }
                        i.this.ao.a();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                        i.this.O();
                        if (i.this.ao == null) {
                            return;
                        }
                        i.this.ao.b();
                    }
                });
            }
        };
        this.L = adUnit;
        this.I = (com.sigmob.sdk.videoAd.a) adUnit.getAdConfig();
        this.p = Dips.dipsToIntPixels(10.0f, this.a);
        this.I.a(n(), this.L, new q.b() { // from class: com.sigmob.sdk.videoAd.i.1
            @Override // com.sigmob.sdk.base.views.q.b
            public void a() {
                i.this.al = false;
                i.this.aq = false;
                i.this.N();
                if (i.this.ao != null) {
                    i.this.ao.a();
                }
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(Error error) {
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void a(String url, String clickCoordinate) {
                i.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                i.this.L.getClickCommon().click_scene = "appinfo";
                i.this.L.getClickCommon().is_final_click = true;
            }

            @Override // com.sigmob.sdk.base.views.q.b
            public void b() {
                i.this.al = true;
                i.this.aq = true;
                i.this.O();
                if (i.this.ao != null) {
                    i.this.ao.b();
                }
            }
        });
        this.I.a((aa) this);
        this.F = this.L.getAdslot_id();
        o = this.L.getInteractionType();
        b(activity, this.J, intentExtras);
        this.L.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        this.D = this.L.getMaterial().creative_type.intValue() != com.sigmob.sdk.base.common.l.CreativeTypeVideo_transparent_html.a();
        if (savedInstanceState != null) {
            this.U = savedInstanceState.getInt(i, -1);
            this.V = savedInstanceState.getBoolean(j, false);
            this.Y = savedInstanceState.getBoolean(k, false);
        }
        if (this.e == null) {
            int iB = com.sigmob.sdk.base.k.b();
            if (iB != 0) {
                n().setTheme(iB);
            }
            m().setBackgroundColor(-16777216);
        } else {
            m().setBackgroundColor(0);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        this.s = relativeLayout;
        relativeLayout.setBackgroundColor(-16777216);
        this.f795K = d(this.a, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.s.addView(this.f795K, layoutParams);
        m().addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
        if (this.u) {
            a(this.a);
            E();
        }
        q();
        this.s.setClickable(true);
        this.s.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.i.8
            MotionEvent a = null;

            /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) throws java.io.UnsupportedEncodingException {
                /*
                    r3 = this;
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.i.c(r4)
                    boolean r4 = r4.getFullClickOnVideo()
                    r0 = 1
                    if (r4 == 0) goto L3c
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.i.e(r4)
                    if (r4 == 0) goto L21
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.d r4 = com.sigmob.sdk.videoAd.i.e(r4)
                    int r4 = r4.getVisibility()
                    if (r4 == 0) goto La1
                L21:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L35
                    android.view.MotionEvent r4 = r3.a
                    if (r4 != 0) goto L2d
                    r3.a = r5
                L2d:
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    android.view.MotionEvent r1 = r3.a
                    com.sigmob.sdk.videoAd.i.a(r4, r1, r5)
                    goto La1
                L35:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La1
                    goto L9b
                L3c:
                    int r4 = r5.getAction()
                    if (r4 != r0) goto L95
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.i.c(r4)
                    com.sigmob.sdk.base.models.rtb.MaterialMeta r4 = r4.getMaterial()
                    java.lang.Boolean r4 = r4.enable_collapse_tool_bar
                    boolean r4 = r4.booleanValue()
                    r1 = 0
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.i.f(r4)
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.i.f(r4)
                    boolean r4 = r4.a()
                    if (r4 == 0) goto L89
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.i.f(r4)
                    boolean r4 = r4.b()
                    if (r4 == 0) goto L7f
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.i.f(r4)
                    r4.setVisibility(r1)
                    goto L89
                L7f:
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.views.m r4 = com.sigmob.sdk.videoAd.i.f(r4)
                    r2 = 4
                    r4.setVisibility(r2)
                L89:
                    com.sigmob.sdk.videoAd.i r4 = com.sigmob.sdk.videoAd.i.this
                    com.sigmob.sdk.base.models.BaseAdUnit r4 = com.sigmob.sdk.videoAd.i.c(r4)
                    java.lang.String r2 = "useless_video_click"
                    com.sigmob.sdk.base.common.ac.a(r4, r5, r2, r1)
                L95:
                    int r4 = r5.getAction()
                    if (r4 != 0) goto La1
                L9b:
                    android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r5)
                    r3.a = r4
                La1:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.i.AnonymousClass8.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        this.z = System.currentTimeMillis();
        this.Z.setVisibility(0);
        this.A = "loading";
        int i2 = this.v + 1;
        this.v = i2;
        if (i2 > 2) {
            a((int) this.f795K.getCurrentPositionWhenPlaying(), true);
        } else {
            this.C.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.ab();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        RelativeLayout relativeLayout = this.Z;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.x.add(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis() - this.z)));
            this.y.add(String.format(Locale.getDefault(), "%.2f", Float.valueOf(((int) this.f795K.getCurrentPositionWhenPlaying()) / 1000.0f)));
            this.A = "play";
            this.C.removeCallbacksAndMessages(null);
            this.Z.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.sigmob.sdk.nativead.a aVar = this.ar;
        if (aVar == null) {
            return;
        }
        aVar.dismiss();
        this.ar.b();
        this.ar = null;
    }

    private void H() {
        switch ((int) this.L.getWidgetId(0)) {
            case 138731:
                L();
                break;
            case 138733:
                M();
                break;
            case 138757:
                I();
                break;
            case 138758:
                K();
                break;
        }
        v vVar = this.ap;
        if (vVar == null) {
            return;
        }
        vVar.a();
    }

    private void I() {
        this.ap = new com.sigmob.sdk.base.views.ac(l());
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        ak.a aVar = new ak.a(l(), new AnonymousClass10(), ak.c.SHAKE);
        this.ao = aVar;
        aVar.c(this.L.getSensitivity());
        this.ao.a();
        m().addView(this.ap, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.aq = true;
        this.L.getClickCommon().click_area = "component";
        this.L.getClickCommon().click_scene = "ad";
        this.L.getClickCommon().is_final_click = true;
        this.I.a(com.sigmob.sdk.base.a.MOTION, (String) null, true);
    }

    private void K() {
        this.ap = new au(l());
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        ak.a aVar = new ak.a(l(), new AnonymousClass11(), ak.c.WRING);
        this.ao = aVar;
        aVar.c(this.L.getSensitivity());
        this.ao.a();
        m().addView(this.ap, layoutParams);
    }

    private void L() {
        this.ap = new an(l());
        int iDipsToIntPixels = Dips.dipsToIntPixels(100.0f, l());
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        ak.a aVar = new ak.a(l(), new AnonymousClass12(), ak.c.SWING);
        this.ao = aVar;
        aVar.c(this.L.getSensitivity());
        this.ao.a();
        m().addView(this.ap, layoutParams);
    }

    private void M() {
        this.ap = new com.sigmob.sdk.base.views.ak(l());
        int iDipsToIntPixels = Dips.dipsToIntPixels(92.0f, l());
        int iDipsToIntPixels2 = Dips.dipsToIntPixels(145.0f, l());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, iDipsToIntPixels2);
        ak.a aVar = new ak.a(l(), new AnonymousClass13(), ak.c.SLOPE);
        this.ao = aVar;
        aVar.c(this.L.getSensitivity());
        this.ao.a();
        m().addView(this.ap, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            if (this.V) {
                return;
            }
            int currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
            if (this.U > 0 && currentPositionWhenPlaying == 0) {
                SigmobLog.d("video seek to " + this.U);
                this.f795K.a(this.U);
            }
            com.sigmob.sdk.base.views.d dVar = this.E;
            if ((dVar == null || dVar.getVisibility() != 0) && !this.al) {
                this.f795K.d();
            }
            if (this.U != -1) {
                this.I.a(l(), this.U);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        try {
            if (this.V) {
                return;
            }
            this.f795K.j();
            SigmobLog.i("videoView.pause()");
            this.U = (int) this.f795K.getCurrentPositionWhenPlaying();
            r().a("pause", (int) this.f795K.getCurrentPositionWhenPlaying());
            this.I.b(l(), this.U);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float P() {
        if (y() > 0) {
            return ((int) this.f795K.getCurrentPositionWhenPlaying()) / y();
        }
        return 0.0f;
    }

    private void Q() {
        try {
            this.T = this.I.e(y());
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (this.L.getAd_type() == 4 || this.as == null) {
            return;
        }
        int iB = B();
        if (iB > 0) {
            this.as.setText(iB + "s 后获取奖励");
        } else {
            this.as.setText("已获得奖励");
        }
    }

    private void S() {
        ac.a(PointCategory.PLAY_LOADING, (String) null, this.L, new ac.a() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda11
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                this.f$0.a(obj);
            }
        });
    }

    private void T() {
        int iO = this.I.o();
        int iY = y() - 2;
        if (iO == 99999999) {
            iO = 0;
        } else if (iO == -99999999) {
            a(iY);
            return;
        } else if (iO <= 0) {
            iO += iY;
        }
        a(iO);
    }

    private void U() {
        z zVar = this.ai;
        if (zVar == null) {
            return;
        }
        zVar.dismiss();
        this.ai.c();
        this.ai = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ImageView imageView;
        w wVar = this.as;
        if (wVar != null) {
            ViewUtil.removeFromParent(wVar);
        }
        w wVar2 = this.an;
        if (wVar2 != null) {
            ViewUtil.removeFromParent(wVar2);
        }
        v vVar = this.ap;
        if (vVar != null) {
            ViewUtil.removeFromParent(vVar);
        }
        z();
        ak.a aVar = this.ao;
        if (aVar != null) {
            aVar.c();
            this.ao = null;
        }
        if (!this.D && (imageView = this.r) != null) {
            ViewParent parent = imageView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.r);
            }
            m().addView(this.r, 0);
        }
        com.sigmob.sdk.base.common.g.g().b(this);
        h(l(), 0);
        com.sigmob.sdk.base.views.b bVar = this.q;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
        S();
        F();
        if (this.M == null) {
            SigmobLog.e("endcard can't show " + this.L.getEndCardIndexPath());
            HashMap map = new HashMap();
            map.put("error", "endcard can't show");
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, map);
            this.d.a();
        }
        View view = this.M;
        if (view != null) {
            view.setVisibility(0);
            this.M.bringToFront();
        }
        RelativeLayout relativeLayout = this.s;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
            a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
        }
        w wVar3 = this.R;
        if (wVar3 != null) {
            ViewUtil.removeFromParent(wVar3);
        }
        ap apVar = this.ab;
        if (apVar != null) {
            ViewUtil.removeFromParent(apVar);
        }
        if (this.ag) {
            ViewUtil.removeFromParent(this.P);
        }
        m mVar = this.af;
        if (mVar != null) {
            ViewUtil.removeFromParent(mVar);
        }
        this.Y = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        com.sigmob.sdk.base.utils.c.a(f, this.L);
        this.C.post(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.X();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        a(IntentActions.ACTION_INTERSTITIAL_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        U();
        this.aa = true;
        this.I.b(l(), y(), this.L);
        k().a();
    }

    private View a(Context context, f videoCompanionAdConfig, int initialVisibility) {
        Preconditions.NoThrow.checkNotNull(context);
        if (videoCompanionAdConfig == null) {
            View view = new View(context);
            view.setVisibility(4);
            return view;
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setGravity(17);
        m().addView(relativeLayout, 0, new RelativeLayout.LayoutParams(-1, -1));
        o oVarA = a(context, videoCompanionAdConfig);
        oVarA.setVisibility(initialVisibility);
        relativeLayout.addView(oVarA, new LinearLayout.LayoutParams(-1, -1));
        return oVarA;
    }

    private o a(Context context, f videoCompanionAdConfig) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(videoCompanionAdConfig);
        Preconditions.NoThrow.checkNotNull(videoCompanionAdConfig.a());
        o oVarA = o.a(context, this.L.getAd_source_logo(), false, this.L.getInvisibleAdLabel());
        oVarA.addJavascriptInterface(new a(), "sigVersion");
        oVarA.setWebViewClickListener(new o.a() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.views.o.a
            public final void onWebViewClick(MotionEvent motionEvent, MotionEvent motionEvent2) throws UnsupportedEncodingException {
                this.f$0.b(motionEvent, motionEvent2);
            }
        });
        oVarA.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda5
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                this.f$0.a(str, str2, str3, str4, j2);
            }
        });
        oVarA.setAdUnit(this.L);
        oVarA.setWebViewClient(new AnonymousClass6());
        videoCompanionAdConfig.a().a(oVarA);
        oVarA.a((n.a) null);
        return oVarA;
    }

    private String a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        sb.append('[');
        do {
            if (i2 != 0) {
                sb.append(io.netty.util.internal.StringUtil.COMMA);
            }
            sb.append(list.get(i2));
            i2++;
        } while (i2 < list.size());
        sb.append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int seek) {
        try {
            ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(seek);
                }
            });
        } catch (RuntimeException e) {
            SigmobLog.e(e.getMessage());
        }
    }

    private void a(int currentPosition, boolean isShowForce) {
        w wVar = this.R;
        if (wVar == null || this.au) {
            return;
        }
        this.au = true;
        wVar.setText("跳过");
        this.R.setEnabled(true);
        ValueAnimator duration = ValueAnimator.ofInt(Dips.dipsToIntPixels(22.0f, l()), Dips.dipsToIntPixels(45.0f, l())).setDuration(300L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.a(valueAnimator);
            }
        });
        duration.start();
        this.R.setVisibility(0);
        r().a(isShowForce, currentPosition);
        r().a("show_skip", currentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
        layoutParams.width = iIntValue;
        this.R.setLayoutParams(layoutParams);
        this.R.invalidate();
    }

    private void a(Context context, int visibility) {
        if (this.an == null) {
            w wVar = new w(context);
            this.an = wVar;
            wVar.setText("反馈");
            this.an.setId(ClientMetadata.generateViewId());
            this.an.setOnClickListener(this.ay);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            int i2 = this.p;
            layoutParams.setMargins(i2, i2 * 2, 0, 0);
            m().addView(this.an, layoutParams);
        }
        w wVar2 = this.an;
        if (wVar2 != null) {
            wVar2.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Bitmap bitmap) {
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        this.r.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent downEvent, MotionEvent upEvent) throws UnsupportedEncodingException {
        this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.L.getClickCommon().click_scene = "ad";
        ClickAreaSetting clickAreaSetting = this.L.getClickAreaSetting();
        float fFloatValue = clickAreaSetting.left.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float fFloatValue2 = (1.0f - clickAreaSetting.right.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        float fFloatValue3 = clickAreaSetting.top.floatValue() * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        float fFloatValue4 = (1.0f - clickAreaSetting.bottom.floatValue()) * ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        boolean z = true;
        if (fFloatValue >= upEvent.getRawX() || upEvent.getRawX() >= fFloatValue2 || fFloatValue3 >= upEvent.getRawY() || upEvent.getRawY() >= fFloatValue4) {
            z = false;
        } else {
            SigMacroCommon macroCommon = this.L.getMacroCommon();
            macroCommon.addMarcoKey(SigMacroCommon._PROGRESS_, String.valueOf(((int) P()) * 100));
            macroCommon.updateClickMarco(downEvent, upEvent, true);
            this.h = macroCommon.getCoordinate();
            if (this.S == null) {
                z();
            }
            this.I.a(com.sigmob.sdk.base.a.VIDEO_CLICK, this.h, true);
        }
        ac.a(this.L, upEvent, "useless_video_click", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        r().a(com.sigmob.sdk.base.common.a.v, (int) this.f795K.getCurrentPositionWhenPlaying());
        if (C()) {
            b(false);
        }
        if (this.ad || this.L.getConfirmDialog() == 2 || this.L.getAd_type() == 4) {
            r().a("skip", (int) this.f795K.getCurrentPositionWhenPlaying());
            this.I.b(this.a, (int) this.f795K.getCurrentPositionWhenPlaying(), y(), this.L);
            a(false, false);
            return;
        }
        this.f795K.j();
        SigmobLog.i("videoView.pause()");
        this.E.setduration(B());
        this.E.setVisibility(0);
        m mVar = this.af;
        if (mVar == null || mVar.getFourElementsLayout() == null) {
            return;
        }
        this.af.getFourElementsLayout().setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map options = pointEntitySigmob.getOptions();
            options.put("duration_seq", a(this.x));
            options.put("video_time_seq", a(this.y));
            options.put("skip_state", this.A);
            options.put("video_duration", String.format(Locale.getDefault(), "%.2f", Float.valueOf(y() / 1000.0f)));
            options.put("endcard_loading_state", this.w);
            pointEntitySigmob.setOptions(options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j2) {
        if (this.B) {
            if (TextUtils.isEmpty(this.L.getLanding_page()) || this.L.getInteractionType() == 2) {
                this.L.setCustomLandPageUrl(str);
            }
            this.L.getClickCommon().click_area = "companion";
            this.L.getClickCommon().click_scene = "endcard";
            this.I.a(com.sigmob.sdk.base.a.ENDCARD, this.h, true);
            SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j2 + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa() throws IllegalArgumentException {
        if (new File(this.L.getVideoPath()).exists()) {
            this.O.setDataSource(this.L.getVideoPath());
        } else {
            this.O.setDataSource(this.L.getVideo_url(), new HashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ab() {
        this.C.removeCallbacksAndMessages(null);
        a((int) this.f795K.getCurrentPositionWhenPlaying(), true);
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int type) {
        if (this.ak == null) {
            q qVar = new q(n(), this.L);
            this.ak = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.videoAd.i.5
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    if (i.this.ak != null) {
                        i.this.ak.dismiss();
                        i.this.ak.c();
                        i.this.ak = null;
                        i.this.al = false;
                    }
                    if (i.this.f795K != null && type == 1) {
                        i.this.f795K.d();
                    }
                    if (i.this.ao != null) {
                        i.this.ao.a();
                    }
                    i.this.r().a(com.sigmob.sdk.base.common.a.g, (int) i.this.f795K.getCurrentPositionWhenPlaying());
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(Error error) {
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String url, String clickCoordinate) {
                    if (i.this.S == null) {
                        i.this.z();
                    }
                    i.this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    i.this.L.getClickCommon().click_scene = "appinfo";
                    i.this.I.a(com.sigmob.sdk.base.a.ENDCARD, url, clickCoordinate, true);
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    if (i.this.f795K != null && type == 1) {
                        i.this.f795K.j();
                    }
                    if (i.this.ao != null) {
                        i.this.ao.b();
                    }
                    i.this.r().a(com.sigmob.sdk.base.common.a.f, (int) i.this.f795K.getCurrentPositionWhenPlaying());
                }
            });
        }
        q qVar2 = this.ak;
        if (qVar2 == null || !qVar2.a() || this.al) {
            return;
        }
        this.ak.show();
        this.al = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, int visibility) {
        if (this.L.getRewardStyle() == 1) {
            this.as = new w(context);
            int iB = B();
            if (iB > 0) {
                this.as.setText(iB + "s 后获取奖励");
            } else {
                this.as.setText("已获得奖励");
                b(false);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(97.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(1, this.an.getId());
            int i2 = this.p;
            layoutParams.setMargins(i2, i2 * 2, 0, 0);
            m().addView(this.as, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent, MotionEvent motionEvent2) throws UnsupportedEncodingException {
        if (this.Q.getVisibility() != 0 || this.aa) {
            SigmobLog.w("ignore invalid click");
            return;
        }
        this.L.getClickCommon().sld = "0";
        ac.a(this.L, motionEvent2, PointCategory.ENDCARDCLICK, true);
        SigMacroCommon macroCommon = this.L.getMacroCommon();
        macroCommon.updateClickMarco(motionEvent, motionEvent2, true);
        this.h = macroCommon.getCoordinate();
        this.B = true;
        if (this.L.getMaterial().click_type.intValue() != com.sigmob.sdk.base.common.k.FullScreen.a() || TextUtils.isEmpty(this.L.getLanding_page()) || this.L.getMaterial().creative_type.intValue() == com.sigmob.sdk.base.common.l.CreativeTypeVideo_EndCardURL.a()) {
            this.ah = true;
            return;
        }
        this.L.getClickCommon().click_area = ClickCommon.CLICK_AREA_MATERIAL;
        this.L.getClickCommon().click_scene = "endcard";
        this.I.a(com.sigmob.sdk.base.a.ENDCARD, this.h, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i2) {
        final Bitmap frameAtTime = this.O.getFrameAtTime(i2 * 1000, 2);
        if (frameAtTime == null) {
            return;
        }
        this.C.post(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(frameAtTime);
            }
        });
    }

    private void c(Context context, int visibility) {
        if (this.am == null) {
            w wVar = new w(context);
            this.am = wVar;
            wVar.setText("反馈");
            this.am.setOnClickListener(this.ay);
            this.am.setId(ClientMetadata.generateViewId());
            int iDipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.Q.getId());
            layoutParams.addRule(6, this.Q.getId());
            layoutParams.setMargins(0, -iDipsToIntPixels, 0, 0);
            m().addView(this.am, layoutParams);
        }
        w wVar2 = this.am;
        if (wVar2 != null) {
            wVar2.setVisibility(visibility);
        }
    }

    private void c(String url) {
        Uri uri;
        if (TextUtils.isEmpty(url) || (uri = Uri.parse(url)) == null) {
            return;
        }
        String host = uri.getHost();
        if (!TextUtils.isEmpty(host) && host.equalsIgnoreCase("127.0.0.1")) {
            Pattern patternCompile = Pattern.compile("/(.*)");
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            Matcher matcher = patternCompile.matcher(path);
            if (matcher.find()) {
                this.ax = matcher.group(1);
                com.sigmob.sdk.base.common.g.d().a(this, this.ax);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean isComplete) {
        if (this.at || this.L.getAd_type() == 4) {
            return;
        }
        this.at = true;
        int iY = isComplete ? y() : (int) this.f795K.getCurrentPositionWhenPlaying();
        r().a("finish", iY);
        this.I.c(l().getApplicationContext(), iY, y(), a());
    }

    private com.sigmob.sdk.videoplayer.a d(final Context context, int initialVisibility) {
        if (this.L.getProxyVideoUrl() == null) {
            throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
        }
        final com.sigmob.sdk.videoplayer.a aVar = new com.sigmob.sdk.videoplayer.a(context);
        aVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.k() { // from class: com.sigmob.sdk.videoAd.i.14
            @Override // com.sigmob.sdk.videoplayer.k
            public void a(long position, long duration) {
                int iY = i.this.y();
                i.this.R();
                if (i.this.C()) {
                    i.this.b(false);
                }
                if (i.this.u()) {
                    i.this.c(false);
                }
                int iB = i.this.B();
                if (i.this.E != null) {
                    i.this.E.setduration(iB);
                }
                if (i.this.ag) {
                    i.this.P.a((int) i.this.f795K.getCurrentPositionWhenPlaying());
                }
                long j2 = iY;
                if (1000 + position < j2) {
                    if (i.this.t()) {
                        i.this.A();
                    } else if (!i.this.au) {
                        i.this.R.setText(String.valueOf((int) ((j2 - i.this.f795K.getCurrentPositionWhenPlaying()) / 1000.0f)));
                    }
                }
                if (i.this.v()) {
                    i.this.w();
                }
                for (d dVar : i.this.I.a(position, j2)) {
                    i.this.b(dVar.getEvent());
                    dVar.setTracked();
                }
                if (position > j2) {
                    i.this.a(true, false);
                }
            }

            @Override // com.sigmob.sdk.videoplayer.k
            public void a(com.sigmob.sdk.videoplayer.d state) throws UnsupportedEncodingException {
                SigmobLog.i("video player state change " + state);
                int i2 = AnonymousClass7.a[state.ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        i.this.A = "none";
                        i.this.a(true, false);
                        return;
                    }
                    if (i2 == 8) {
                        ac.a("video", aVar.getErrorCode(), aVar.getErrorMessage(), i.this.L);
                        i.this.a(false, true);
                        return;
                    } else if (i2 == 5) {
                        i.this.E();
                        aVar.j();
                        return;
                    } else {
                        if (i2 != 6) {
                            return;
                        }
                        i.this.F();
                        aVar.d();
                        return;
                    }
                }
                i.this.X = (int) aVar.getDuration();
                if (i.this.X == 0) {
                    i iVar = i.this;
                    iVar.X = iVar.L.getDuration();
                }
                if (!i.this.au) {
                    i.this.R.setText(String.valueOf((int) (i.this.y() / 1000.0f)));
                    i.this.R.setVisibility(0);
                }
                i iVar2 = i.this;
                iVar2.b(iVar2.l(), 0);
                aVar.getVideoWidth();
                aVar.getVideoHeight();
                if (i.this.S != null) {
                    i.this.S.a(i.this.y());
                }
                if (i.this.ac) {
                    i.this.ab.a(ResourceUtil.getDrawableId(i.this.l(), "sig_image_video_mute"));
                    i.this.f795K.setMute(true);
                }
                i.this.r().a(i.this.X, i.this.I.l());
                if (!i.this.V && (i.this.U == 0 || i.this.U == -1)) {
                    SigMacroCommon macroCommon = i.this.L.getMacroCommon();
                    macroCommon.addMarcoKey(SigMacroCommon._COMPLETED_, "0");
                    macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i.this.y() / 1000));
                }
                if (i.this.ag) {
                    i.this.P.a(i.this.y(), 0);
                }
            }
        });
        String proxyVideoUrl = this.L.getProxyVideoUrl();
        try {
            if (!this.D) {
                ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalArgumentException {
                        this.f$0.aa();
                    }
                });
                this.r = b(context);
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        aVar.setUp(proxyVideoUrl);
        c(proxyVideoUrl);
        aVar.setVisibility(initialVisibility);
        return aVar;
    }

    private void e(final Context context, int initialVisibility) {
        aq aqVar = new aq(context);
        this.P = aqVar;
        aqVar.setAnchorId(this.f795K.getId());
        this.P.setVisibility(initialVisibility);
        m().addView(this.P);
    }

    private void f(final Context context, int initialVisibility) {
        if (this.E != null) {
            return;
        }
        com.sigmob.sdk.base.views.d dVar = new com.sigmob.sdk.base.views.d(context, this.I.q());
        this.E = dVar;
        dVar.setVisibility(initialVisibility);
        m().addView(this.E);
        this.E.setDialogListener(new d.a() { // from class: com.sigmob.sdk.videoAd.i.15
            @Override // com.sigmob.sdk.base.views.d.a
            public void a() {
                if (!i.this.V) {
                    i.this.r().a("skip", (int) i.this.f795K.getCurrentPositionWhenPlaying());
                    i.this.I.b(i.this.a, (int) i.this.f795K.getCurrentPositionWhenPlaying(), i.this.y(), i.this.L);
                }
                i.this.E.setVisibility(8);
                if (i.this.af != null && i.this.af.getFourElementsLayout() != null) {
                    i.this.af.getFourElementsLayout().setClickable(true);
                }
                if (i.this.I.m()) {
                    i.this.k().a();
                    return;
                }
                if (!i.this.D) {
                    i iVar = i.this;
                    iVar.a((int) iVar.f795K.getCurrentPositionWhenPlaying());
                }
                i.this.f795K.i();
                i.this.V();
                i.this.V = true;
                if (i.this.r() != null) {
                    i.this.N.a("show", 0);
                }
            }

            @Override // com.sigmob.sdk.base.views.d.a
            public void b() {
                i.this.f795K.d();
                i.this.E.setVisibility(8);
                if (i.this.af == null || i.this.af.getFourElementsLayout() == null) {
                    return;
                }
                i.this.af.getFourElementsLayout().setClickable(true);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(final android.content.Context r24, int r25) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.i.g(android.content.Context, int):void");
    }

    private void h(final Context context, int initialVisibility) {
        if (this.Q == null) {
            ap apVar = new ap(context);
            this.Q = apVar;
            apVar.setId(ClientMetadata.generateViewId());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i2 = this.p;
            layoutParams.setMargins(i2, i2 * 2, i2, i2);
            m().addView(this.Q, layoutParams);
            BaseAdUnit baseAdUnit = this.L;
            if (baseAdUnit != null && !TextUtils.isEmpty(baseAdUnit.getCloseCardHtmlData()) && !this.az) {
                z zVar = new z(n(), this.L, this.I);
                this.ai = zVar;
                zVar.a(new z.a() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda8
                    @Override // com.sigmob.sdk.base.views.z.a
                    public final void onCloseClick() {
                        this.f$0.Z();
                    }
                });
            }
            this.Q.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.i.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        if (i.this.az || i.this.ai == null || i.this.ai.a() || i.this.aj) {
                            i.this.aa = true;
                            i.this.I.b(i.this.l(), i.this.y(), i.this.L);
                            i.this.k().a();
                        } else {
                            i.this.ai.show();
                            i.this.aj = true;
                        }
                    }
                    return true;
                }
            });
            this.Q.a(this.L);
            String strF = this.I.f();
            if (strF != null) {
                this.Q.a(strF);
            }
        }
        ap apVar2 = this.Q;
        if (apVar2 != null) {
            apVar2.setVisibility(initialVisibility);
        }
        c(l(), initialVisibility);
    }

    private void i(final Context context, int initialVisibility) {
        w wVar = new w(context);
        this.R = wVar;
        wVar.setId(ClientMetadata.generateViewId());
        this.R.setVisibility(initialVisibility);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(10);
        ap apVar = this.ab;
        if (apVar != null) {
            layoutParams.addRule(0, apVar.getId());
            layoutParams.setMargins(0, this.p * 2, 0, 0);
        }
        m().addView(this.R, layoutParams);
        this.R.setEnabled(false);
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        if ((this.L.getSkipPercent() != 0 || this.L.getSkipSeconds() >= 0) && this.L.getSkipSeconds() != 0) {
            return;
        }
        a(0, false);
    }

    private void j(final Context context, int initialVisibility) {
        ap apVar = new ap(context);
        this.ab = apVar;
        apVar.setId(ClientMetadata.generateViewId());
        this.ab.setVisibility(initialVisibility);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(22.0f, context), Dips.dipsToIntPixels(22.0f, context));
        layoutParams.addRule(4, this.an.getId());
        layoutParams.addRule(11);
        int i2 = this.p;
        layoutParams.setMargins(i2, i2 * 2, i2, 0);
        m().addView(this.ab, layoutParams);
        this.ab.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.videoAd.i.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    if (i.this.ac) {
                        i.this.r().a(com.sigmob.sdk.base.common.a.E, (int) i.this.f795K.getCurrentPositionWhenPlaying());
                        i.this.ab.a(ResourceUtil.getDrawableId(i.this.l(), "sig_image_video_unmute"));
                        i.this.f795K.setMute(false);
                    } else {
                        i.this.r().a(com.sigmob.sdk.base.common.a.D, (int) i.this.f795K.getCurrentPositionWhenPlaying());
                        i.this.ab.a(ResourceUtil.getDrawableId(i.this.l(), "sig_image_video_mute"));
                        i.this.f795K.setMute(true);
                    }
                    i.this.ac = !r3.ac;
                }
                return true;
            }
        });
        if (this.L.getIsMute() == 0) {
            this.ab.a(ResourceUtil.getDrawableId(l(), "sig_image_video_unmute"));
        } else {
            this.ab.a(ResourceUtil.getDrawableId(l(), "sig_image_video_mute"));
            this.f795K.setMute(true);
            this.ac = true;
        }
    }

    public static int p() {
        return 0;
    }

    void A() {
        if (this.L.getMaterial().disable_auto_deeplink.booleanValue()) {
            z();
        }
        a((int) this.f795K.getCurrentPositionWhenPlaying(), false);
        int iB = B();
        com.sigmob.sdk.base.views.d dVar = this.E;
        if (dVar != null) {
            dVar.setduration(iB);
        }
    }

    int B() {
        try {
            int rewardSeconds = this.L.getRewardSeconds();
            if (rewardSeconds > -1) {
                if (y() > 0 && rewardSeconds * 1000 > y()) {
                    rewardSeconds = (int) (y() / 1000.0f);
                }
                return (int) (rewardSeconds - (this.f795K.getCurrentPositionWhenPlaying() / 1000.0f));
            }
            if (y() <= 0) {
                return -1;
            }
            return (int) (((y() / 1000.0f) * (this.L.getRewardPercent() * 0.01d)) - (this.f795K.getCurrentPositionWhenPlaying() / 1000.0f));
        } catch (Throwable unused) {
            return -1;
        }
    }

    boolean C() {
        return B() <= 0;
    }

    @Override // com.sigmob.sdk.base.common.g.a
    public BaseAdUnit a() {
        return this.L;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(final int requestCode, final int resultCode, final Intent data) {
        if (resultCode == -1) {
            k().a();
        }
    }

    public void a(Context context) {
        this.Z = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.LOADING.a());
        imageView.setId(ClientMetadata.generateViewId());
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 3600000, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setAnimation(rotateAnimation);
        this.Z.addView(imageView, layoutParams);
        this.Z.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        m().addView(this.Z, layoutParams2);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(final Configuration newConfig) {
        if (this.I != null && this.S == null) {
            f fVarG = com.sigmob.sdk.videoAd.a.g(this.L);
            this.S = fVarG;
            fVarG.a(this.I);
        }
        if (r() != null) {
            r().a("rotation", (int) this.f795K.getCurrentPositionWhenPlaying());
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
        try {
            outState.putBoolean(j, this.V);
            outState.putInt(i, this.U);
            outState.putBoolean(k, this.Y);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.g.a
    public void a(BaseAdUnit adUnit) {
        if (adUnit.getUuid().equals(this.L.getUuid()) && adUnit.isEndCardIndexExist()) {
            this.C.post(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.z();
                }
            });
        }
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File cacheFile, String url, int percentsAvailable) {
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String url, Throwable throwable) {
        SigmobLog.e("url", throwable);
        ac.a("video", 0, throwable.getMessage(), this.L);
        a(false, true);
    }

    public void a(boolean isComplete, boolean isError) {
        if (this.aw) {
            return;
        }
        this.aw = true;
        F();
        boolean videoErrorReward = this.L.getVideoErrorReward();
        c(isComplete);
        if (isComplete || (isError && videoErrorReward)) {
            b(isComplete);
            if (isComplete) {
                x();
            }
        } else if (this.I.m()) {
            k().a();
            return;
        }
        if (!this.D) {
            if (isComplete) {
                T();
            } else {
                a((int) this.f795K.getCurrentPositionWhenPlaying());
            }
        }
        this.f795K.i();
        V();
        this.V = true;
        if (r() != null) {
            this.N.a("show", 0);
        }
    }

    @Override // com.sigmob.sdk.base.common.g.a
    public void b(BaseAdUnit adUnit) {
    }

    void b(final String adEvent) {
        if ("start".equals(adEvent)) {
            a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            a(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
        }
        if (r() != null) {
            r().a(adEvent, (int) this.f795K.getCurrentPositionWhenPlaying());
        }
    }

    void b(boolean isComplete) {
        if (this.L.getAd_type() == 4 || this.ad) {
            return;
        }
        this.ad = true;
        int iY = isComplete ? y() : (int) this.f795K.getCurrentPositionWhenPlaying();
        this.C.postDelayed(new Runnable() { // from class: com.sigmob.sdk.videoAd.i$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Y();
            }
        }, 100L);
        r().a("reward", iY);
        this.I.c(l().getApplicationContext(), iY, y(), a());
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.i
    public void e() {
        super.e();
        n().getWindow().addFlags(1024);
        MaterialMeta material = this.L.getMaterial();
        this.t = ClientMetadata.getInstance().getInsetBottom();
        if (this.Y) {
            V();
        } else {
            if (this.I == null) {
                throw new IllegalStateException("BaseVideoConfig does not have a video disk path");
            }
            if (this.ag) {
                e(l(), 4);
            }
            if (material.has_companion_endcard != null && material.has_companion_endcard.booleanValue() && material.companion != null) {
                g(l(), 4);
                this.G = material.companion.show_delay_secs.intValue();
            }
            a(l(), 0);
            j(l(), 0);
            i(l(), 4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d("start", 0.0f));
            arrayList.add(new d("play_quarter", 0.25f));
            arrayList.add(new d("play_two_quarters", 0.5f));
            arrayList.add(new d("play_three_quarters", 0.75f));
            this.I.a((List<d>) arrayList);
            a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        f(l(), 4);
        H();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
        if (this.aa) {
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            return;
        }
        ak.a aVar = this.ao;
        if (aVar != null) {
            aVar.b();
            v vVar = this.ap;
            if (vVar != null) {
                vVar.b();
            }
        }
        if (this.Y) {
            return;
        }
        O();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
        ak.a aVar;
        if (!this.Y && this.ar == null) {
            N();
        }
        View view = this.M;
        if (view != null && (view instanceof o)) {
            ((o) view).resumeTimers();
        }
        this.aq = false;
        if (this.ar != null || (aVar = this.ao) == null) {
            return;
        }
        aVar.a();
        v vVar = this.ap;
        if (vVar != null) {
            vVar.a();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        try {
            SigmobLog.d("VideoViewController onDestroy() called");
            com.sigmob.sdk.base.common.g.g().b(this);
            if (!this.aa) {
                a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            }
            if (this.ax != null) {
                com.sigmob.sdk.base.common.g.d().b(this, this.ax);
            }
            w wVar = this.an;
            if (wVar != null) {
                wVar.setOnClickListener(null);
                ViewUtil.removeFromParent(this.an);
            }
            w wVar2 = this.am;
            if (wVar2 != null) {
                wVar2.setOnClickListener(null);
                ViewUtil.removeFromParent(this.am);
            }
            com.sigmob.sdk.nativead.a aVar = this.ar;
            if (aVar != null) {
                aVar.a((WindNativeAdData.DislikeInteractionCallback) null);
                this.ar.dismiss();
                this.ar.b();
            }
            this.I.k();
            ImageLoader.ImageContainer imageContainer = this.ae;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.ae = null;
            }
            s sVar = this.N;
            if (sVar != null) {
                sVar.a();
                this.N = null;
            }
            f fVar = this.S;
            if (fVar != null) {
                fVar.a((f.a) null);
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.O;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            ap apVar = this.Q;
            if (apVar != null) {
                apVar.setOnTouchListener(null);
            }
            w wVar3 = this.R;
            if (wVar3 != null) {
                wVar3.setOnTouchListener(null);
            }
            ap apVar2 = this.ab;
            if (apVar2 != null) {
                apVar2.setOnTouchListener(null);
            }
            com.sigmob.sdk.videoplayer.a aVar2 = this.f795K;
            if (aVar2 != null) {
                aVar2.r();
            }
            View view = this.M;
            if (view != null && (view instanceof o)) {
                ((o) view).setWebViewClickListener(null);
                ((o) this.M).setLogoClickListener(null);
                ((o) this.M).destroy();
            }
            U();
            ak.a aVar3 = this.ao;
            if (aVar3 != null) {
                aVar3.c();
                this.ao = null;
            }
            BaseAdUnit baseAdUnit = this.L;
            if (baseAdUnit != null) {
                baseAdUnit.destroy();
            }
            this.M = null;
            this.P = null;
            super.h();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }

    @Override // com.sigmob.sdk.base.common.aa
    public void onAdClick(boolean isRecord, com.sigmob.sdk.base.a type) {
        s sVarR;
        int currentPositionWhenPlaying;
        String str;
        this.az = true;
        W();
        if (isRecord) {
            ClickCommon clickCommon = this.L.getClickCommon();
            int i2 = AnonymousClass7.b[type.ordinal()];
            if (i2 == 1) {
                ac.a(com.sigmob.sdk.base.a.COMPANION, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                sVarR = r();
                currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.w;
            } else if (i2 == 2) {
                ac.a(com.sigmob.sdk.base.a.VIDEO_CLICK, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                sVarR = r();
                currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
                str = "full_video_click";
            } else if (i2 != 3) {
                ac.a(com.sigmob.sdk.base.a.ENDCARD, "click", this.L, clickCommon.isDeeplink, clickCommon.clickUrl, clickCommon.clickCoordinate, y());
                sVarR = r();
                currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
                str = "click";
            } else {
                sVarR = r();
                currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
                str = com.sigmob.sdk.base.common.a.k;
            }
            sVarR.a(str, currentPositionWhenPlaying);
        }
    }

    public void q() {
        com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(l().getApplicationContext(), 0);
        this.q = bVar;
        bVar.setId(ClientMetadata.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Dips.dipsToIntPixels(16.0f, l()));
        m mVar = this.af;
        if (mVar != null) {
            layoutParams.addRule(8, mVar.getId());
        } else {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, this.p);
        }
        try {
            this.q.a(this.L.getAd_source_logo());
            if (!this.L.getInvisibleAdLabel()) {
                this.q.b(com.sigmob.sdk.base.k.h());
            }
        } catch (Throwable unused) {
        }
        m().addView(this.q, layoutParams);
    }

    public s r() {
        if (this.N == null) {
            s sVar = new s();
            this.N = sVar;
            sVar.a(a());
        }
        return this.N;
    }

    public String s() {
        return this.F;
    }

    public boolean t() {
        long currentPositionWhenPlaying;
        try {
            currentPositionWhenPlaying = (int) this.f795K.getCurrentPositionWhenPlaying();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        if (this.L.getSkipSeconds() > -1) {
            return (((float) currentPositionWhenPlaying) / 1000.0f) + 0.3f >= ((float) this.L.getSkipSeconds());
        }
        if (y() > 0) {
            return ((((float) y()) / 1000.0f) * ((float) this.L.getSkipPercent())) * 0.01f < ((float) currentPositionWhenPlaying) / 1000.0f;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean u() {
        /*
            r7 = this;
            r0 = 1
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.L     // Catch: java.lang.Throwable -> L4e
            int r1 = r1.getAd_type()     // Catch: java.lang.Throwable -> L4e
            r2 = 0
            if (r1 != r0) goto L4d
            com.sigmob.sdk.videoplayer.a r1 = r7.f795K     // Catch: java.lang.Throwable -> L4e
            long r3 = r1.getCurrentPositionWhenPlaying()     // Catch: java.lang.Throwable -> L4e
            int r1 = (int) r3     // Catch: java.lang.Throwable -> L4e
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L4e
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.L     // Catch: java.lang.Throwable -> L4e
            int r1 = r1.getChargeSeconds()     // Catch: java.lang.Throwable -> L4e
            r5 = -1
            if (r1 <= r5) goto L32
            float r1 = (float) r3     // Catch: java.lang.Throwable -> L4e
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r3
            r3 = 1050253722(0x3e99999a, float:0.3)
            float r1 = r1 + r3
            com.sigmob.sdk.base.models.BaseAdUnit r3 = r7.L     // Catch: java.lang.Throwable -> L4e
            int r3 = r3.getChargeSeconds()     // Catch: java.lang.Throwable -> L4e
            float r3 = (float) r3     // Catch: java.lang.Throwable -> L4e
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            r2 = r0
            goto L4d
        L32:
            int r1 = r7.y()     // Catch: java.lang.Throwable -> L4e
            if (r1 <= 0) goto L4d
            r5 = 100
            long r3 = r3 * r5
            int r1 = r7.y()     // Catch: java.lang.Throwable -> L4e
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L4e
            long r3 = r3 / r5
            com.sigmob.sdk.base.models.BaseAdUnit r1 = r7.L     // Catch: java.lang.Throwable -> L4e
            int r1 = r1.getChargePercent()     // Catch: java.lang.Throwable -> L4e
            long r5 = (long) r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L2f
            goto L30
        L4d:
            return r2
        L4e:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.i.u():boolean");
    }

    public boolean v() {
        m mVar = this.af;
        if (mVar != null && mVar.a()) {
            return true;
        }
        try {
            boolean z = ((long) ((int) this.f795K.getCurrentPositionWhenPlaying())) / 1000 >= ((long) this.G);
            if (z) {
                SigmobLog.d("showAble CompanionAds");
            }
            return z;
        } catch (Throwable th) {
            SigmobLog.e("shouldBeShowCompanionAds", th);
            return true;
        }
    }

    public void w() {
        m mVar;
        if (this.H || (mVar = this.af) == null) {
            return;
        }
        mVar.setVisibility(0);
        this.H = true;
    }

    public void x() {
        if (this.av) {
            return;
        }
        this.av = true;
        this.L.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, "1");
        if (this.W) {
            return;
        }
        r().a("complete", (int) this.f795K.getCurrentPositionWhenPlaying());
    }

    int y() {
        com.sigmob.sdk.videoplayer.a aVar = this.f795K;
        if (aVar == null) {
            return 0;
        }
        int i2 = this.X;
        return i2 > 0 ? this.I.b(i2) : this.I.b((int) aVar.getDuration());
    }

    void z() {
        if (this.M == null && this.L.isEndCardIndexExist()) {
            try {
                f fVarG = com.sigmob.sdk.videoAd.a.g(this.L);
                this.S = fVarG;
                fVarG.a(this.I);
                this.M = a(n(), this.S, 4);
                this.S.a(y());
                h(l(), 4);
            } catch (Throwable th) {
                this.S = null;
                SigmobLog.e(th.getMessage());
                HashMap map = new HashMap();
                map.put("error", th.getMessage());
                a(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL, map);
                this.d.a();
            }
        }
    }
}
