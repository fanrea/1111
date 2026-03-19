package com.kwad.tachikoma;

import android.text.TextUtils;
import com.kuaishou.tk.api.TKContext;
import com.kuaishou.tk.export.INativeModule;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.ss.texturerender.TextureRenderKeys;
import com.tk.core.a.j;
import com.tkruntime.v8.V8Object;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements INativeModule {
    private final Map<String, IOfflineCompoBridgeHandler> AN = new ConcurrentHashMap();
    private IOfflineCompoBridgeHandler AO = new com.kwad.tachikoma.l.b();
    private IOfflineCompoTKBridgeHandler AP;
    private boolean AQ;
    private TKContext AR;
    private String AS;
    private int AT;
    private int AU;

    public final void a(TKContext tKContext) {
        this.AR = tKContext;
    }

    public final void l(String str) {
        this.AS = str;
    }

    public final void bN(int i) {
        this.AT = i;
    }

    public final void bO(int i) {
        this.AU = i;
    }

    public final void b(V8Object v8Object) {
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction;
        String string = v8Object.getString("action");
        String string2 = v8Object.getString("data");
        final String string3 = v8Object.getString(TextureRenderKeys.KEY_IS_CALLBACK);
        e.log().i("TKJSBridge", "callAdBridge == action " + string + " callback" + string3);
        IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler = this.AN.get(string);
        if (iOfflineCompoBridgeHandler == null) {
            if (OfflineHostProvider.getApi().env().isDevelopEnable()) {
                throw new RuntimeException("Js Action not found:" + string);
            }
            m("Js Action not found:" + string);
            iOfflineCompoBridgeHandler = this.AO;
        }
        if (iOfflineCompoBridgeHandler != null) {
            if (string3 != null) {
                iOfflineCompoCallBackFunction = new IOfflineCompoCallBackFunction() { // from class: com.kwad.tachikoma.c.1
                    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction
                    public final void onSuccess(String str) {
                        c.this.a(string3, str);
                    }

                    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction
                    public final void onError(String str) {
                        c.this.a(string3, str);
                    }
                };
            } else {
                iOfflineCompoCallBackFunction = new IOfflineCompoCallBackFunction() { // from class: com.kwad.tachikoma.c.2
                    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction
                    public final void onError(String str) {
                    }

                    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction
                    public final void onSuccess(String str) {
                    }
                };
            }
            try {
                iOfflineCompoBridgeHandler.handleJsCall(string2, iOfflineCompoCallBackFunction);
                return;
            } catch (Throwable th) {
                m(th.getMessage());
                OfflineHostProvider.getApi().crash().gatherException(th);
                return;
            }
        }
        e.log().e("TKJSBridge", "bridgeHandler is null");
    }

    public final void c(V8Object v8Object) throws JSONException {
        String string = v8Object.getString("action");
        String string2 = v8Object.getString("data");
        String string3 = v8Object.getString(TextureRenderKeys.KEY_IS_CALLBACK);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", string);
            jSONObject.put("data", string2);
            jSONObject.put(TextureRenderKeys.KEY_IS_CALLBACK, string3);
            String string4 = jSONObject.toString();
            if (this.AP != null) {
                this.AP.callTKBridge(string4);
            }
        } catch (JSONException e) {
            e.log().printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2) {
        if (this.AQ) {
            e.log().d("TKJSBridge", "callJS after destroy jsInterface");
            return;
        }
        if (str == null) {
            e.log().d("TKJSBridge", "callJS callback is empty");
            return;
        }
        e.log().d("TKJSBridge", "callJS callback:+ " + str);
        try {
            String str3 = str + "(" + JSONObject.quote(str2) + ")";
            if (this.AR != null && this.AR.getContext() != null && this.AR.getContext().pj() != null && !this.AR.getContext().pj().isReleased()) {
                this.AR.evaluateScript(str3, this.AS + ":" + str, null, new j() { // from class: com.kwad.tachikoma.c.3
                    @Override // com.tk.core.a.j
                    public final void success() {
                        e.log().d("TKJSBridge", "callJs success script");
                    }

                    @Override // com.tk.core.a.j
                    public final void failed(Throwable th) {
                        e.log().e("TKJSBridge", "callJS failed callback:+ " + str, th);
                        c.this.m(th.getMessage());
                        OfflineHostProvider.getApi().crash().gatherException(th);
                        e.log().printStackTrace(th);
                    }
                });
            }
        } catch (Throwable th) {
            m(th.getMessage());
            OfflineHostProvider.getApi().crash().gatherException(th);
            e.log().printStackTrace(th);
        }
    }

    public final void a(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler) {
        if (iOfflineCompoBridgeHandler != null && !TextUtils.isEmpty(iOfflineCompoBridgeHandler.getKey())) {
            if (this.AN.containsKey(iOfflineCompoBridgeHandler.getKey())) {
                String str = "cannot register handler again, handler: " + iOfflineCompoBridgeHandler.getKey();
                e.log().e("TKJSBridge", str);
                if (e.isDebug()) {
                    throw new IllegalStateException(str);
                }
            }
            this.AN.put(iOfflineCompoBridgeHandler.getKey(), iOfflineCompoBridgeHandler);
            return;
        }
        e.log().e("TKJSBridge", "handler and handler'key cannot be null");
    }

    public final void hO() {
        Iterator<Map.Entry<String, IOfflineCompoBridgeHandler>> it = this.AN.entrySet().iterator();
        while (it.hasNext()) {
            IOfflineCompoBridgeHandler value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.AN.clear();
    }

    public final void a(IOfflineCompoTKBridgeHandler iOfflineCompoTKBridgeHandler) {
        this.AP = iOfflineCompoTKBridgeHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.AU).setRenderState(3).setErrorReason(str).setTemplateId(this.AS).setVersionCode(String.valueOf(this.AT)).toJson());
    }

    @Override // com.kuaishou.tk.export.INativeModule
    public final void destroy(boolean z) {
        e.log().i("TKJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, IOfflineCompoBridgeHandler>> it = this.AN.entrySet().iterator();
        while (it.hasNext()) {
            IOfflineCompoBridgeHandler value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.AQ = true;
    }
}
