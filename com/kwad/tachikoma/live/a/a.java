package com.kwad.tachikoma.live.a;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener;
import com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.model.KSAdLiveEndResultData;
import com.kwad.components.offline.api.core.adlive.model.KSAdLiveShopInfo;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.components.offline.api.core.adlive.request.KSAdLiveEndRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.components.offline.api.core.widget.RcFrameLayout;
import com.kwad.tachikoma.t.i;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<RcFrameLayout> implements AdLivePlayStateListener, AdLiveShopInfoListener, KsAdLiveMessageListener {
    private float CB;
    private float CC;
    private float CD;
    private float CE;
    private int CG;
    private IAdLiveOfflineView DA;
    private IAdLivePlayModule DB;
    private IAdLiveEndRequest DC;
    protected JsValueRef<V8Function> DD;
    protected JsValueRef<V8Function> DE;
    protected JsValueRef<V8Function> DF;
    protected JsValueRef<V8Function> DG;
    protected JsValueRef<V8Function> DH;
    protected JsValueRef<V8Function> DI;
    protected JsValueRef<V8Function> DJ;
    protected JsValueRef<V8Function> DK;
    protected JsValueRef<V8Function> DL;
    private String DM;
    private RcFrameLayout DN;
    private Context mContext;

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayResume() {
    }

    static /* synthetic */ boolean a(a aVar, JsValueRef jsValueRef) {
        return a((JsValueRef<V8Function>) jsValueRef);
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.CG = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public RcFrameLayout n(Context context) {
        this.mContext = context;
        this.DA = OfflineHostProvider.getApi().live().getIAdLiveOfflineView(context, 2);
        IAdLiveOfflineView iAdLiveOfflineView = this.DA;
        if (iAdLiveOfflineView != null && (iAdLiveOfflineView.getView() instanceof RcFrameLayout)) {
            this.DN = (RcFrameLayout) this.DA.getView();
        } else {
            this.DN = new RcFrameLayout(context);
        }
        return this.DN;
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        this.CB = o.eb(i);
        float f = this.CB;
        this.CC = f;
        this.CD = f;
        this.CE = this.CC;
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        this.CB = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        this.CC = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        this.CD = o.eb(i);
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        this.CE = o.eb(i);
    }

    public final void a(String str, String str2, String str3, String str4, long j) {
        this.DM = str3;
        if (this.DA == null) {
            return;
        }
        this.DB = OfflineHostProvider.getApi().live().getAdLivePlayModule(this.DA, str, str2, str4, j);
        this.DN.setRadius(this.CB, this.CC, this.CE, this.CD);
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.registerAdLivePlayStateListener(this);
            this.DA.registerAdLiveShopInfoListener(this);
            this.DA.registerKsAdLiveMessageListener(this);
        }
    }

    @Deprecated
    public final void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, str4, 0L);
    }

    public final void setMuted(boolean z) {
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(!z, false);
            if (a(this.DH)) {
                this.DH.get().call(null, Boolean.valueOf(z));
            }
        }
    }

    public final void setForceGetAudioFocus(boolean z) {
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setForceGetAudioFocus(z);
        }
    }

    public final void p(V8Function v8Function) {
        if (v8Function != null) {
            JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
            ad.unRetainJsValue(this.DH);
            this.DH = jsValueRefRetainJsValue;
        }
    }

    public final void j(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DG);
        this.DG = jsValueRefRetainJsValue;
    }

    public final void l(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DF);
        this.DF = jsValueRefRetainJsValue;
    }

    public final void m(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DE);
        this.DE = jsValueRefRetainJsValue;
    }

    public final void q(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DJ);
        this.DJ = jsValueRefRetainJsValue;
    }

    public final void r(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DK);
        this.DK = jsValueRefRetainJsValue;
    }

    public final void s(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DL);
        this.DL = jsValueRefRetainJsValue;
    }

    public final void k(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DD);
        this.DD = jsValueRefRetainJsValue;
    }

    public final void n(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.DI);
        this.DI = jsValueRefRetainJsValue;
    }

    public final void pause() {
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
    }

    public final void stop() {
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
    }

    public final void resume() {
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.DD);
        ad.unRetainJsValue(this.DE);
        ad.unRetainJsValue(this.DF);
        ad.unRetainJsValue(this.DG);
        ad.unRetainJsValue(this.DJ);
        ad.unRetainJsValue(this.DK);
        ad.unRetainJsValue(this.DL);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        IAdLivePlayModule iAdLivePlayModule = this.DB;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.DA;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.unRegisterAdLiveShopInfoListener(this);
            this.DA.unRegisterKsAdLiveMessageListener(this);
        }
    }

    private static boolean a(JsValueRef<V8Function> jsValueRef) {
        return (jsValueRef == null || jsValueRef.get() == null || jsValueRef.get().isReleased()) ? false : true;
    }

    private void cd(int i) throws Throwable {
        if (this.CG == i) {
            return;
        }
        this.CG = i;
        if (a(this.DI)) {
            this.DI.get().call(null, Integer.valueOf(i));
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePrepared() throws Throwable {
        com.kwad.tachikoma.e.log().d("TKLivePlayer", "====++++ video prepared");
        cd(1);
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayProgress(long j) throws Throwable {
        com.kwad.tachikoma.e.log().d("TKLivePlayer", "====++++ video progress:");
        if (a(this.DD)) {
            V8Function v8Function = this.DD.get();
            double d = j;
            Double.isNaN(d);
            v8Function.call(null, Double.valueOf(d / 1000.0d), 0, 0);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayStart() throws Throwable {
        com.kwad.tachikoma.e.log().d("TKLivePlayer", "====++++ video play start");
        if (a(this.DG)) {
            this.DG.get().call(null, new Object[0]);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayPause() throws Throwable {
        com.kwad.tachikoma.e.log().d("TKLivePlayer", "====++++ video paused");
        cd(4);
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayCompleted() throws Throwable {
        cd(5);
        if (a(this.DF)) {
            this.DF.get().call(null, new Object[0]);
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLivePlayEnd() {
        if (TextUtils.isEmpty(this.DM)) {
            return;
        }
        this.DC = OfflineHostProvider.getApi().live().mIAdLiveEndRequest(this.DM);
        if (this.DC == null) {
            return;
        }
        new OfflineCompoNetworking<KSAdLiveEndRequest, KSAdLiveEndResultData>() { // from class: com.kwad.tachikoma.live.a.a.1
            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking, com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.components.offline.api.core.network.OfflineCompoNetworking
            protected final /* synthetic */ CommonOfflineCompoResultData createResponseData() {
                return iw();
            }

            private static KSAdLiveEndResultData iw() {
                return new KSAdLiveEndResultData();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
            /* renamed from: ix, reason: merged with bridge method [inline-methods] */
            public KSAdLiveEndRequest createRequest() {
                return new KSAdLiveEndRequest(a.this.DC);
            }
        }.request(new IOfflineCompoRequestListener<KSAdLiveEndRequest, KSAdLiveEndResultData>() { // from class: com.kwad.tachikoma.live.a.a.2
            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final /* bridge */ /* synthetic */ void onError(IOfflineCompoRequest iOfflineCompoRequest, int i, String str) {
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final /* bridge */ /* synthetic */ void onStartRequest(IOfflineCompoRequest iOfflineCompoRequest) {
            }

            @Override // com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener
            public final /* synthetic */ void onSuccess(IOfflineCompoRequest iOfflineCompoRequest, BaseOfflineCompoResultData baseOfflineCompoResultData) {
                a((KSAdLiveEndResultData) baseOfflineCompoResultData);
            }

            private void a(final KSAdLiveEndResultData kSAdLiveEndResultData) {
                if (kSAdLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                i.runOnUiThread(new Runnable() { // from class: com.kwad.tachikoma.live.a.a.2.1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        if (a.a(a.this, a.this.DJ)) {
                            a.this.DJ.get().call(null, kSAdLiveEndResultData.mQLivePushEndInfo.toJson(new JSONObject()).toString());
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
    public final void onLiveAudioEnableChange(boolean z) throws Throwable {
        if (a(this.DH)) {
            this.DH.get().call(null, Boolean.valueOf(!z));
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.KsAdLiveMessageListener
    public final void addLiveMessageData(LiveMessage liveMessage) throws Throwable {
        if (a(this.DK)) {
            this.DK.get().call(null, liveMessage.toJson().toString());
        }
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopInfoListener
    public final void addKSAdLiveShopInfo(KSAdLiveShopInfo kSAdLiveShopInfo) throws Throwable {
        if (a(this.DL)) {
            this.DL.get().call(null, kSAdLiveShopInfo.toJson().toString());
        }
    }
}
