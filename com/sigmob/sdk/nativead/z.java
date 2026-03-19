package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.kuaishou.socket.nano.SocketMessages;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.nativead.e;
import com.sigmob.sdk.nativead.n;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class z implements View.OnClickListener, View.OnTouchListener, aa, e.a, n.a, WindNativeAdData.DislikeInteractionCallback {
    private static final Stack<v> M = new Stack<>();
    public static final String a = "z";
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private boolean A;
    private boolean D;
    private boolean E;
    private List<View> F;
    private long G;
    private WindNativeAdData.DislikeInteractionCallback J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f794K;
    private v L;
    protected WindNativeAdData b;
    protected BaseAdUnit c;
    protected i d;
    private WindAdMetaData i;
    private p j;
    private n k;
    private e n;
    private l o;
    private MotionEvent p;
    private d q;
    private NativeADEventListener r;
    private boolean s;
    private ViewGroup t;
    private ViewGroup.LayoutParams u;
    private Bitmap v;
    private com.sigmob.sdk.base.views.q w;
    private boolean x;
    private t y;
    private boolean z;
    private List<View> l = new ArrayList();
    private final HashSet<View> m = new HashSet<>();
    private boolean B = true;
    private boolean C = false;
    private List<View> H = new ArrayList();
    private final List<View> I = new ArrayList();
    private q.b N = new q.b() { // from class: com.sigmob.sdk.nativead.z.5
        @Override // com.sigmob.sdk.base.views.q.b
        public void a() {
            if (z.this.w != null) {
                z.this.w.dismiss();
                z.this.w.c();
                z.this.w = null;
            }
            z.this.x = false;
            z.this.c.getClickCommon().click_scene = "preview";
            z.this.j().a(com.sigmob.sdk.base.common.a.g, 0);
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void a(Error error) {
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void a(String url, String clickCoordinate) {
            if (z.this.c == null) {
                return;
            }
            z.this.c.getClickCommon().sld = "0";
            z.this.c.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            z.this.c.getClickCommon().click_scene = "appinfo";
            z.this.c.getClickCommon().is_final_click = true;
            if (z.this.x) {
                z.this.x().a(com.sigmob.sdk.base.a.PREVIEW, url, clickCoordinate, true);
            }
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void b() {
            if (z.this.j != null) {
                z.this.r().a();
            }
            z.this.j().a(com.sigmob.sdk.base.common.a.f, 0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Context K() {
        return com.sigmob.sdk.b.e();
    }

    private void L() {
        try {
            Activity activityD = com.sigmob.sdk.base.utils.o.d(M());
            if (this.w == null && activityD != null) {
                com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(activityD, this.c);
                this.w = qVar;
                qVar.a(this.N);
            }
            com.sigmob.sdk.base.views.q qVar2 = this.w;
            if (qVar2 == null || !qVar2.a() || this.x) {
                return;
            }
            this.c.getClickCommon().click_area = "appinfo";
            this.w.show();
            this.x = true;
        } catch (Exception e2) {
            SigmobLog.e("openFourElements fail:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View M() {
        n nVar = this.k;
        if (nVar == null) {
            return null;
        }
        return (View) nVar.getParent();
    }

    private boolean N() {
        return this.c.isExpiredAd();
    }

    private boolean O() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() throws UnsupportedEncodingException {
        a(4, (MotionEvent) null);
    }

    private View a(HashSet<View> viewList, MotionEvent event) {
        if (viewList == null) {
            return null;
        }
        Iterator<View> it = viewList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (com.sigmob.sdk.base.utils.o.a(next, event)) {
                return next;
            }
        }
        return null;
    }

    private View a(List<View> viewList, MotionEvent event) {
        if (viewList == null) {
            return null;
        }
        for (View view : viewList) {
            if (com.sigmob.sdk.base.utils.o.a(view, event)) {
                return view;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r9, android.view.MotionEvent r10) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.z.a(int, android.view.MotionEvent):void");
    }

    private void a(ViewParent parent, int measuredWidth, int measuredHeight) {
        BaseAdUnit baseAdUnit;
        int i;
        Context contextK = K();
        if (contextK == null || parent == null || (baseAdUnit = this.c) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (baseAdUnit.enableWidgetInteraction()) {
            boolean zEnableDevToRender = this.c.enableDevToRender(0);
            if (zEnableDevToRender) {
                i = 30;
            } else {
                int iMin = Math.min(measuredHeight, measuredWidth);
                int iPixelsToIntDips = Dips.pixelsToIntDips(iMin, contextK);
                int iMin2 = Math.min(iPixelsToIntDips, 100);
                SigmobLogger.d(a, "createWidget2Show: minViewSize = " + iMin + ", minViewSizeDp = " + iPixelsToIntDips + ", widgetSizeDp = " + iMin2, new Object[0]);
                i = iMin2;
            }
            float f2 = zEnableDevToRender ? 0.0f : 1.0f;
            String str = a;
            SigmobLogger.d(str, "createWidget2Show: widgetSizeDp = " + i, new Object[0]);
            View viewA = a(i, i);
            if (viewA == null) {
                return;
            }
            viewA.setAlpha(f2);
            com.sigmob.sdk.base.utils.o.a(viewA);
            int measuredWidth2 = viewGroup.getMeasuredWidth();
            int measuredHeight2 = viewGroup.getMeasuredHeight();
            SigmobLogger.d(str, "createWidget2Show: containerW = " + measuredWidth2 + ", containerH = " + measuredHeight2, new Object[0]);
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth2, measuredHeight2));
            frameLayout.addView(viewA);
            viewGroup.addView(frameLayout);
            this.m.add(viewA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, com.sigmob.sdk.base.a aVar) {
        af afVarJ;
        NativeADEventListener nativeADEventListener;
        if (com.sigmob.sdk.base.utils.c.a(com.sigmob.sdk.base.utils.c.a(a, this.c)) && (nativeADEventListener = this.r) != null) {
            nativeADEventListener.onAdClicked();
        }
        if (z && (afVarJ = j()) != null) {
            afVarJ.a("click", 0);
        }
    }

    private boolean a(MotionEvent event) {
        p pVar = this.j;
        if (pVar == null) {
            return false;
        }
        return pVar.a(event);
    }

    private p b(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View childAt = view.getChildAt(i);
            if (childAt instanceof p) {
                return (p) childAt;
            }
        }
        return null;
    }

    private n c(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View childAt = view.getChildAt(i);
            if (childAt instanceof n) {
                return (n) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(ViewGroup viewGroup) {
        a(a(viewGroup), viewGroup);
    }

    public String A() {
        return k().getCTAText();
    }

    public Bitmap B() {
        return this.v;
    }

    public void C() {
        p pVar;
        r rVarR;
        if (this.s || !this.D || (pVar = this.j) == null || pVar.getParent() == null || (rVarR = r()) == null) {
            return;
        }
        rVarR.c();
    }

    public void D() {
        r rVarR;
        if (this.s || (rVarR = r()) == null) {
            return;
        }
        this.A = true;
        rVarR.a();
    }

    public void E() {
        p pVar;
        if (this.t != null && (pVar = this.j) != null) {
            ViewParent parent = pVar.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.j);
            }
            this.t.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.u;
            if (layoutParams != null) {
                this.t.addView(this.j, layoutParams);
            } else {
                this.t.addView(this.j);
            }
            if (!this.m.contains(this.j)) {
                this.m.add(this.j);
            }
        }
        this.t = null;
        this.u = null;
    }

    public void F() {
        p pVar;
        r rVarR;
        if (this.s || !this.D || (pVar = this.j) == null || pVar.getParent() == null || (rVarR = r()) == null) {
            return;
        }
        rVarR.b();
    }

    public void G() {
        r rVarR;
        if (this.s || (rVarR = r()) == null) {
            return;
        }
        rVarR.d();
    }

    public String H() {
        BaseAdUnit baseAdUnit = this.c;
        return (baseAdUnit == null || baseAdUnit.bidding_response == null || this.c.bidding_response.ecpm == null) ? "" : String.valueOf(this.c.bidding_response.ecpm);
    }

    public String I() {
        SigVideo nativeVideo = this.c.getNativeVideo();
        if (nativeVideo == null) {
            return null;
        }
        return nativeVideo.getThumbUrl();
    }

    public WindAdMetaData J() {
        if (this.i == null) {
            this.i = WindAdMetaData.create(this.c);
        }
        return this.i;
    }

    public View a(int width, int height) {
        if (this.L == null && this.c != null) {
            Context contextK = K();
            v vVar = new v(contextK, Dips.dipsToIntPixels(width, contextK), Dips.dipsToIntPixels(height, contextK));
            if (!vVar.a((int) this.c.getWidgetId(0), this.c.getSensitivity(), this.c.getClickCommon())) {
                return null;
            }
            vVar.setMotionActionListener(new c() { // from class: com.sigmob.sdk.nativead.z$$ExternalSyntheticLambda2
                @Override // com.sigmob.sdk.nativead.c
                public final void onAction() throws UnsupportedEncodingException {
                    this.f$0.P();
                }
            });
            int iDipsToIntPixels = Dips.dipsToIntPixels((width < 100 || height < 100) ? 30 : 70, contextK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
            layoutParams.gravity = 17;
            vVar.setLayoutParams(layoutParams);
            this.L = vVar;
        }
        return this.L;
    }

    public View a(ViewGroup parent) {
        View viewA;
        int measuredHeight;
        int measuredHeight2;
        View view = null;
        if (parent == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < parent.getChildCount(); i2++) {
            View childAt = parent.getChildAt(i2);
            if (childAt != null) {
                if (childAt instanceof p) {
                    return childAt;
                }
                if ((childAt instanceof ImageView) && this.I.contains(childAt) && (measuredHeight2 = childAt.getMeasuredHeight() * childAt.getMeasuredWidth()) > i) {
                    view = childAt;
                    i = measuredHeight2;
                }
                if ((childAt instanceof ViewGroup) && (viewA = a((ViewGroup) childAt)) != null) {
                    if (viewA instanceof p) {
                        return viewA;
                    }
                    if ((viewA instanceof ImageView) && this.I.contains(viewA) && (measuredHeight = viewA.getMeasuredHeight() * viewA.getMeasuredWidth()) > i) {
                        view = viewA;
                        i = measuredHeight;
                    }
                }
            }
        }
        return view;
    }

    @Override // com.sigmob.sdk.base.common.n.c
    public void a() {
        d dVarX = x();
        if (dVarX == null) {
            return;
        }
        dVarX.a(K(), this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view, int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        ViewParent parent = view.getParent();
        if (parent == null) {
            return;
        }
        if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            layoutParams2.gravity = 17;
            layoutParams = layoutParams2;
        } else if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams3.addRule(13);
            layoutParams = layoutParams3;
        } else {
            if (!(parent instanceof LinearLayout)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            layoutParams4.gravity = 17;
            layoutParams = layoutParams4;
        }
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    public void a(View view, ViewGroup viewGroup) {
        ViewParent parent;
        if (viewGroup == null) {
            return;
        }
        if (view == null) {
            SigmobLogger.d(a, "prepareWidget2Show: container", new Object[0]);
            view = viewGroup;
            parent = viewGroup;
        } else if (!(view instanceof p) && !(view instanceof ImageView)) {
            SigmobLogger.d(a, "prepareWidget2Show: no material", new Object[0]);
            return;
        } else {
            SigmobLogger.d(a, "prepareWidget2Show: material", new Object[0]);
            parent = view.getParent();
        }
        String simpleName = view.getClass().getSimpleName();
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        SigmobLogger.d(a, "prepareWidget2Show: simpleName = " + simpleName + ", measuredHeight = " + measuredHeight + ", measuredWidth = " + measuredWidth, new Object[0]);
        a(parent, measuredWidth, measuredHeight);
    }

    public void a(View view, List<View> clickViewList, List<View> creativeViewList, View disLikeView, NativeADEventListener nativeADEventListener) {
        n nVar;
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP);
                return;
            }
            return;
        }
        if (com.sigmob.sdk.b.i() == null) {
            com.sigmob.sdk.b.a(com.sigmob.sdk.base.utils.o.d(view));
        }
        if (disLikeView != null) {
            if (this.y == null) {
                a aVar = new a(disLikeView.getContext(), this.c);
                this.y = aVar;
                aVar.a(this);
            }
            disLikeView.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.nativead.z.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() != 1 || z.this.y == null) {
                        return true;
                    }
                    z.this.y.a();
                    return true;
                }
            });
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.nativead.z.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (z.this.c == null) {
                    return;
                }
                Context contextK = z.this.K();
                viewGroup.getLocationOnScreen(new int[2]);
                ClickCommon clickCommon = z.this.c.getClickCommon();
                clickCommon.adarea_x = String.valueOf(Dips.pixelsToIntDips(r1[0], contextK));
                clickCommon.adarea_y = String.valueOf(Dips.pixelsToIntDips(r1[1], contextK));
                clickCommon.adarea_w = String.valueOf(Dips.pixelsToIntDips(viewGroup.getWidth(), contextK));
                clickCommon.adarea_h = String.valueOf(Dips.pixelsToIntDips(viewGroup.getHeight(), contextK));
            }
        });
        v vVar = (v) com.sigmob.sdk.base.utils.o.a(viewGroup, v.class);
        if (vVar != null && vVar != this.L) {
            com.sigmob.sdk.base.utils.o.a(vVar);
        }
        viewGroup.post(new Runnable() { // from class: com.sigmob.sdk.nativead.z$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(viewGroup);
            }
        });
        x().a(new com.sigmob.sdk.base.common.aa() { // from class: com.sigmob.sdk.nativead.z$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.aa
            public final void onAdClick(boolean z, com.sigmob.sdk.base.a aVar2) {
                this.f$0.a(z, aVar2);
            }
        });
        if (creativeViewList != null) {
            this.l = creativeViewList;
        }
        List<View> list = this.H;
        if (list != null) {
            this.m.removeAll(list);
        }
        if (clickViewList != null) {
            this.H = clickViewList;
        }
        this.r = nativeADEventListener;
        o().a((Map<String, Object>) null, this.c);
        com.sigmob.sdk.base.common.g.g().a(this.c, (g.b) null);
        n nVar2 = this.k;
        if (nVar2 == null) {
            n nVarC = c(viewGroup);
            this.k = nVarC;
            if (nVarC == null) {
                nVar = new n(K());
                this.k = nVar;
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            this.m.addAll(this.H);
            this.k.setAdVisibilityStatusChangeListener(this);
            this.k.a(x().s(), x().t());
        }
        com.sigmob.sdk.base.utils.o.a(nVar2);
        nVar = this.k;
        layoutParams = new ViewGroup.LayoutParams(0, 0);
        viewGroup.addView(nVar, layoutParams);
        this.m.addAll(this.H);
        this.k.setAdVisibilityStatusChangeListener(this);
        this.k.a(x().s(), x().t());
    }

    public void a(ViewGroup mediaLayout, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        this.f794K = true;
        b(mediaLayout, nativeADMediaListener);
    }

    public void a(final BaseAdUnit adUnit, WindNativeAdData nativeAdUnit) {
        this.c = adUnit;
        this.b = nativeAdUnit;
        if (this.j == null && adUnit.getNativeAd().type.intValue() == 1) {
            this.j = new p(com.sigmob.sdk.b.e());
        }
        com.sigmob.sdk.base.common.g.a().getBitmap(k().getAd_source_logo(), new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.nativead.z.1
            public void onBitmapLoadFailed() {
            }

            public void onBitmapLoaded(Bitmap bitmap) {
                z.this.v = bitmap;
            }
        });
    }

    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.J = dislikeInteractionCallback;
    }

    public void a(HashSet<View> viewList, View.OnTouchListener onTouchListener) {
        if (viewList == null) {
            return;
        }
        Iterator<View> it = viewList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next != null) {
                next.setOnClickListener(null);
                next.setOnTouchListener(null);
                next.setOnTouchListener(onTouchListener);
            }
        }
    }

    public void a(List<ImageView> viewList, int resId) {
        List<SigImage> imageUrlList = k().getImageUrlList();
        if (viewList == null || imageUrlList == null) {
            return;
        }
        this.I.clear();
        this.I.addAll(viewList);
        int iMin = Math.min(viewList.size(), imageUrlList.size());
        for (int i = 0; i < iMin; i++) {
            SigImage sigImage = imageUrlList.get(i);
            ImageView imageView = viewList.get(i);
            if (!this.m.contains(imageView)) {
                this.m.add(imageView);
            }
            List<View> list = this.F;
            if (list == null) {
                this.F = new ArrayList();
            } else {
                list.clear();
            }
            this.F.add(imageView);
            com.sigmob.sdk.base.common.g.a().load(sigImage.getImageUrl()).placeholder(resId).error(resId).into(imageView);
        }
    }

    public void a(List<View> viewList, View.OnTouchListener onTouchListener) {
        if (viewList == null) {
            return;
        }
        for (View view : viewList) {
            if (view != null) {
                view.setOnClickListener(null);
                view.setOnTouchListener(null);
                view.setOnTouchListener(onTouchListener);
            }
        }
    }

    @Override // com.sigmob.sdk.nativead.n.a
    public void a(boolean isValidImpression) {
        if (this.z) {
            return;
        }
        if (!this.s) {
            com.sigmob.sdk.base.common.g.g().e(this.c);
            if (isValidImpression) {
                NativeADEventListener nativeADEventListener = this.r;
                if (nativeADEventListener != null) {
                    nativeADEventListener.onAdExposed();
                }
                j().a("ad_show", 0);
            }
        }
        this.z = isValidImpression;
    }

    @Override // com.sigmob.sdk.base.common.n.c
    public void b() {
        d dVarX = x();
        if (dVarX != null) {
            dVarX.b(K(), this.c);
        }
    }

    public void b(ViewGroup mediaContainer, final WindNativeAdData.NativeADMediaListener sigAdVideoEventListener) {
        if (mediaContainer == null) {
            return;
        }
        p pVar = (p) com.sigmob.sdk.base.utils.o.a(mediaContainer, p.class);
        if (pVar != null) {
            com.sigmob.sdk.base.utils.o.a(pVar);
        }
        p pVar2 = this.j;
        if (pVar2 != null) {
            com.sigmob.sdk.base.utils.o.a(pVar2);
            mediaContainer.addView(this.j, new ViewGroup.LayoutParams(-1, -2));
        }
        if (!this.m.contains(this.j)) {
            this.m.add(this.j);
        }
        p pVar3 = this.j;
        if (pVar3 != null && !this.c.equals(pVar3.getAdUnit())) {
            this.j.a(this);
        }
        p pVar4 = this.j;
        final r sigVideoAdController = pVar4 == null ? null : pVar4.getSigVideoAdController();
        if (sigVideoAdController == null) {
            return;
        }
        sigVideoAdController.a(new j() { // from class: com.sigmob.sdk.nativead.z.2
            @Override // com.sigmob.sdk.nativead.j
            public void a() {
                z.this.j().a("video_restart", 0);
            }

            @Override // com.sigmob.sdk.nativead.j
            public void a(long current, long duration) {
                List<com.sigmob.sdk.videoAd.d> listA;
                z.this.c.getVideoCommon().end_time = sigVideoAdController.j();
                d dVarX = z.this.x();
                if (dVarX == null || (listA = dVarX.a(current, duration)) == null || listA.isEmpty()) {
                    return;
                }
                for (com.sigmob.sdk.videoAd.d dVar : listA) {
                    z.this.j().a(dVar.getEvent(), sigVideoAdController.j());
                    dVar.setTracked();
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoCompleted() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoCompleted();
                }
                z.this.c.getVideoCommon().end_time = sigVideoAdController.e();
                z.this.c.getVideoCommon().is_last = 1;
                z.this.j().a("complete", sigVideoAdController.j());
                z.this.j().a("video_link", 0);
                z.this.C = false;
                z.this.A = false;
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoError(WindAdError error) {
                z.this.A = false;
                z.this.C = false;
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoError(error);
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoLoad() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoLoad();
                }
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoPause() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoPause();
                }
                z.this.C = true;
                z.this.j().a("video_pause", 0);
                z.this.j().a("video_link", 0);
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoResume() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoResume();
                }
                z.this.C = false;
                z.this.c.getVideoCommon().type = 2;
                z.this.c.getVideoCommon().is_first = 0;
                z.this.c.getVideoCommon().begin_time = sigVideoAdController.j();
                z.this.A = false;
                z.this.j().a("video_start", sigVideoAdController.j());
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoStart() {
                View viewM = z.this.M();
                if (viewM != null) {
                    z.this.c.setAdSize(viewM.getWidth(), viewM.getHeight());
                }
                z.this.c.getVideoCommon().video_time = sigVideoAdController.e();
                z.this.c.getVideoCommon().is_first = 1;
                z.this.c.getVideoCommon().is_last = 0;
                z.this.c.getVideoCommon().end_time = 0;
                z.this.c.getVideoCommon().is_auto_play = z.this.x().u() ? 1 : 2;
                if (z.this.s) {
                    z.this.c.getVideoCommon().scene = 3;
                } else {
                    z.this.c.getVideoCommon().scene = 1;
                }
                if (z.this.B) {
                    z.this.c.getVideoCommon().type = 1;
                    z.this.B = false;
                } else {
                    z.this.c.getVideoCommon().type = 3;
                }
                WindNativeAdData.NativeADMediaListener nativeADMediaListener = sigAdVideoEventListener;
                if (nativeADMediaListener != null) {
                    nativeADMediaListener.onVideoStart();
                }
                z.this.A = false;
                z.this.C = false;
                z.this.j().a("video_start", 0);
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit) {
        p pVar = this.j;
        if (pVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = ((View) pVar.getParent()).getLayoutParams();
        SigmobLog.d("visibilityStatusChange() called with: isVisible = [" + layoutParams.width + ":" + layoutParams.height + "]");
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void b(BaseAdUnit adUnit, String error) {
    }

    public void b(boolean mute) {
        r rVarR;
        if (this.s || (rVarR = r()) == null) {
            return;
        }
        rVarR.a(mute);
    }

    @Override // com.sigmob.sdk.nativead.e.a
    public void c() {
        SigmobLog.d("----------onAdDetailShow----------");
        if (x() != null) {
            x().c(K(), this.c);
        }
        this.s = true;
        NativeADEventListener nativeADEventListener = this.r;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailShow();
        }
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void c(BaseAdUnit adUnit) {
    }

    @Override // com.sigmob.sdk.nativead.e.a
    public void d() {
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void d(BaseAdUnit adUnit) {
    }

    @Override // com.sigmob.sdk.nativead.e.a
    public void e() {
        this.s = false;
        NativeADEventListener nativeADEventListener = this.r;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailDismiss();
        }
        d dVarX = x();
        if (dVarX != null) {
            dVarX.d(K(), this.c);
        }
        E();
        l lVar = this.o;
        if (lVar != null) {
            lVar.setVisibility(0);
        }
        e eVar = this.n;
        if (eVar != null) {
            eVar.b(this.c);
        }
        View viewM = M();
        if (viewM == null || dVarX == null) {
            return;
        }
        dVarX.a(com.sigmob.sdk.base.utils.o.c(viewM), this.c, this.N);
    }

    @Override // com.sigmob.sdk.base.common.n.b
    public void e(BaseAdUnit mAdUnit) {
    }

    @Override // com.sigmob.sdk.nativead.n.a
    public void f() {
        if (this.D) {
            v vVar = this.L;
            if (vVar != null) {
                vVar.b();
                M.remove(this.L);
            }
            r rVarR = r();
            if (rVarR != null) {
                rVarR.a();
            }
            SigmobLog.d("-----------onAdViewPauseImpression---------");
            this.D = false;
        }
    }

    @Override // com.sigmob.sdk.nativead.n.a
    public void g() {
        v vVarLastElement;
        v vVar;
        if (this.L != null) {
            Stack<v> stack = M;
            if (!stack.isEmpty() && (vVarLastElement = stack.lastElement()) != null && vVarLastElement == (vVar = this.L)) {
                vVar.a();
            }
        }
        if (this.s || this.D) {
            return;
        }
        this.D = true;
        v vVar2 = this.L;
        if (vVar2 != null) {
            Stack<v> stack2 = M;
            if (!stack2.contains(vVar2)) {
                stack2.push(this.L);
                this.L.a();
            }
        }
        p pVar = this.j;
        if (pVar == null || pVar.getParent() == null) {
            return;
        }
        d dVarX = x();
        if (!this.A && dVarX != null && dVarX.u()) {
            r().c();
        }
        SigmobLog.d("------------onAdViewStartImpression------------");
    }

    @Override // com.sigmob.sdk.nativead.n.a
    public void h() {
        if (this.s || K() == null || !this.E) {
            return;
        }
        HashSet<View> hashSet = this.m;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.E = false;
        v vVar = this.L;
        if (vVar != null) {
            vVar.b();
            M.remove(this.L);
        }
        SigmobLog.d("------------onAdViewRemoved----------" + hashCode());
        r rVarR = r();
        if (rVarR != null) {
            rVarR.a();
        }
        this.D = false;
        n nVar = this.k;
        if (nVar != null && nVar.hasWindowFocus()) {
            this.z = false;
        }
        af afVarJ = j();
        if (afVarJ != null) {
            afVarJ.a("ad_hide", 0);
        }
        if (this.B || this.C || afVarJ == null) {
            return;
        }
        afVarJ.a("video_link", 0);
    }

    @Override // com.sigmob.sdk.nativead.n.a
    public void i() {
        if (this.E || this.s) {
            return;
        }
        this.E = true;
        SigmobLog.d("----------onAdViewShow------------" + hashCode());
        this.A = false;
        this.D = false;
        View viewM = M();
        if (viewM != null) {
            x().a(com.sigmob.sdk.base.utils.o.c(viewM), this.c, this.N);
            viewM.setOnTouchListener(this);
        }
        p pVar = this.j;
        if (pVar != null && !this.m.contains(pVar)) {
            this.m.add(this.j);
        } else if (this.F != null) {
            if (this.m.isEmpty()) {
                this.m.addAll(this.F);
            } else {
                for (View view : this.F) {
                    if (!this.m.contains(view)) {
                        this.m.add(view);
                    }
                }
            }
        }
        v vVar = this.L;
        if (vVar != null && !this.m.contains(vVar)) {
            this.m.add(this.L);
        }
        this.m.addAll(this.H);
        a(this.l, this);
        a(this.m, this);
        af afVarJ = j();
        if (afVarJ != null) {
            afVarJ.a("start", 0);
        }
    }

    public af j() {
        BaseAdUnit baseAdUnit = this.c;
        if (baseAdUnit == null) {
            return null;
        }
        af sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        g gVar = new g();
        gVar.a(this.c);
        return gVar;
    }

    @Override // com.sigmob.sdk.nativead.aa
    public BaseAdUnit k() {
        return this.c;
    }

    @Override // com.sigmob.sdk.nativead.aa
    public WindNativeAdData l() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.aa
    public l m() {
        if (!this.f794K && this.o == null && this.c.getadPrivacy() != null) {
            l lVar = new l(K());
            this.o = lVar;
            lVar.setOnTouchListener(this);
            this.o.a(this.c.getAppVersion(), this.c.getCompanyName());
        }
        return this.o;
    }

    public boolean n() {
        e eVar = this.n;
        if (eVar == null) {
            return false;
        }
        return eVar.a(this.c);
    }

    public e o() {
        if (this.n == null) {
            this.n = new e(this);
        }
        return this.n;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onCancel() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onSelected(int position, String value, boolean enforce) {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onSelected(position, value, enforce);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onShow() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (v == null || event == null || ((event.getAction() == 0 && this.G > 0 && System.currentTimeMillis() - this.G < 500) || this.c == null)) {
            return false;
        }
        try {
        } catch (Throwable th) {
            SigmobLog.e("onTouch error", th);
        }
        if (event.getAction() != 1) {
            this.G = System.currentTimeMillis();
            this.p = event;
            return true;
        }
        this.c.getClickCommon().click_scene = "preview";
        this.c.getClickCommon().sld = "0";
        if (v == this.o) {
            SigmobLog.d("click mSigAppInfoView");
            a(1, event);
            return true;
        }
        SigmobLog.d("click " + v);
        List<View> list = this.l;
        int i = 3;
        if (list != null) {
            if ((list.contains(v) ? v : a(this.l, event)) != null) {
                SigmobLog.d("click ctaClickView");
                this.c.getClickCommon().click_scene = "preview";
                this.c.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                a(3, event);
                return true;
            }
        }
        HashSet<View> hashSet = this.m;
        if (hashSet != null) {
            if (!hashSet.contains(v)) {
                v = a(this.m, event);
            }
            if (v != null) {
                SigmobLog.d("click mCreativeViews");
                p pVar = this.j;
                if (!(pVar != null && pVar.a(event))) {
                    i = 2;
                }
                a(i, event);
                return true;
            }
        }
        return false;
    }

    public int p() {
        int width;
        View viewM = M();
        return (this.j == null || viewM == null || (width = viewM.getWidth()) <= 0) ? SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE : width;
    }

    public View q() {
        return this.j;
    }

    public r r() {
        p pVar = this.j;
        if (pVar == null) {
            return null;
        }
        return pVar.getSigVideoAdController();
    }

    public double s() {
        if (r() == null) {
            return 0.0d;
        }
        return r0.e();
    }

    public double t() {
        if (r() == null) {
            return 0.0d;
        }
        return r0.f();
    }

    public int u() {
        View viewM = M();
        if (q() == null || viewM == null || viewM.getWidth() <= 0) {
            return 720;
        }
        return (int) (viewM.getWidth() / this.c.getAdPercent());
    }

    public void v() {
        a(this.m, (View.OnTouchListener) null);
        a(this.l, (View.OnTouchListener) null);
        HashSet<View> hashSet = this.m;
        if (hashSet != null) {
            hashSet.clear();
        }
        List<View> list = this.l;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.H;
        if (list2 != null) {
            list2.clear();
        }
        this.r = null;
        this.d = null;
    }

    public void w() {
        Object[] objArr = new Object[1];
        BaseAdUnit baseAdUnit = this.c;
        objArr[0] = baseAdUnit != null ? baseAdUnit.getVid() : ILogConst.CACHE_PLAY_REASON_NULL;
        SigmobLog.i(String.format("native ad data %s is Destroy", objArr));
        v();
        List<View> list = this.F;
        if (list != null) {
            list.clear();
        }
        p pVar = this.j;
        if (pVar != null) {
            com.sigmob.sdk.base.utils.o.a(pVar);
            this.j.c();
            this.j = null;
        }
        BaseAdUnit baseAdUnit2 = this.c;
        if (baseAdUnit2 != null && baseAdUnit2.getSessionManager() != null) {
            j().a("ad_hide", 0);
            j().a();
        }
        v vVar = this.L;
        if (vVar != null) {
            vVar.c();
            M.remove(this.L);
            com.sigmob.sdk.base.utils.o.a(this.L);
            this.L = null;
        }
        com.sigmob.sdk.base.common.g.g().e(this.c);
        com.sigmob.sdk.base.common.g.b(this.c);
        com.sigmob.sdk.base.views.q qVar = this.w;
        if (qVar != null) {
            qVar.dismiss();
            this.w.c();
            this.w = null;
        }
        t tVar = this.y;
        if (tVar != null && (tVar instanceof a)) {
            tVar.a(null);
            a aVar = (a) this.y;
            aVar.dismiss();
            aVar.b();
            this.y = null;
        }
        this.J = null;
        this.N = null;
        n nVar = this.k;
        if (nVar != null) {
            nVar.setAdVisibilityStatusChangeListener(null);
            com.sigmob.sdk.base.utils.o.a(this.k);
            this.k = null;
        }
        e eVar = this.n;
        if (eVar != null) {
            eVar.b(this.c);
            this.n = null;
        }
        BaseAdUnit baseAdUnit3 = this.c;
        if (baseAdUnit3 != null) {
            baseAdUnit3.destroy();
        }
    }

    @Override // com.sigmob.sdk.nativead.aa
    public d x() {
        BaseAdUnit baseAdUnit;
        if (this.q == null && (baseAdUnit = this.c) != null) {
            this.q = (d) baseAdUnit.getAdConfig();
        }
        return this.q;
    }

    public void y() throws UnsupportedEncodingException {
        Bundle bundle = new Bundle();
        if (this.j != null && x().l()) {
            ac acVar = new ac();
            int[] iArr = new int[2];
            this.j.getLocationOnScreen(iArr);
            acVar.a(iArr[0]);
            acVar.b(iArr[1]);
            acVar.c(this.j.getMeasuredWidth());
            acVar.d(this.j.getMeasuredHeight());
            bundle.putParcelable("attr", acVar);
            this.t = (ViewGroup) this.j.getParent();
            this.u = this.j.getLayoutParams();
            x.a((k) this.j);
            SigMacroCommon macroCommon = this.c.getMacroCommon();
            if (macroCommon != null) {
                macroCommon.addMarcoKey(SigMacroCommon._SCENE_, "3");
            }
            this.s = true;
        }
        l lVar = this.o;
        if (lVar != null) {
            lVar.setVisibility(4);
        }
        o().a(this.c, bundle);
    }

    int z() {
        int interactionType = this.c.getInteractionType();
        if (interactionType == 2) {
            return 1;
        }
        return interactionType == 0 ? 0 : 2;
    }
}
