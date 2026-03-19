package com.kuaishou.tk.api;

import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.tk.api.exception.ContainerInfoMap;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.api.page.INewBaseBridge;
import com.kuaishou.tk.api.page.IRouter;
import com.tk.core.a.d;
import com.tk.core.a.j;
import com.tk.core.a.k;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.bridge.b;
import com.tk.core.component.e;
import com.tk.core.i.a;
import com.tk.core.manager.c;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKContext {
    private final b mContext;
    private String mRootDir = "";

    public TKContext(b bVar) {
        this.mContext = bVar;
    }

    public void setBundleInfo(TkBundleInfo tkBundleInfo, String str) {
        b bVar;
        if (tkBundleInfo == null || (bVar = this.mContext) == null) {
            return;
        }
        bVar.setBundleId(tkBundleInfo.mBundleId);
        this.mContext.a(tkBundleInfo);
        ContainerInfoMap.setBundleInfo(this.mContext.hashCode(), tkBundleInfo);
    }

    public void setSessionId(String str) {
        b bVar = this.mContext;
        if (bVar != null) {
            ContainerInfoMap.setContainerSessionId(bVar.hashCode(), str);
        }
    }

    public void setBizExtraInfo(String str) {
        b bVar = this.mContext;
        if (bVar != null) {
            ContainerInfoMap.setBizExtraInfo(bVar.hashCode(), str);
        }
    }

    public void setBusinessName(String str) {
        b bVar = this.mContext;
        if (bVar != null) {
            ContainerInfoMap.setBusinessName(bVar.hashCode(), str);
        }
    }

    public void registerRouter(final IRouter iRouter) {
        c.rY().a(this.mContext.pj(), new k() { // from class: com.kuaishou.tk.api.TKContext.1
            @Override // com.tk.core.a.k
            public void navigateTo(Uri uri) {
                iRouter.navigateTo(uri);
            }
        });
    }

    public void setNewBaseBridge(final INewBaseBridge iNewBaseBridge) {
        if (iNewBaseBridge == null) {
            return;
        }
        this.mContext.a(new d() { // from class: com.kuaishou.tk.api.TKContext.2
            @Override // com.tk.core.a.d
            public Object invoke(String str, String str2, V8Function v8Function) {
                return iNewBaseBridge.invoke(str, str2, new FunctionCallImpl(v8Function, TKContext.this.mContext));
            }

            @Override // com.tk.core.a.d
            public Object invokeM(String str, String str2, String str3, V8Function v8Function) {
                return iNewBaseBridge.invoke(str, str2, str3, new FunctionCallImpl(v8Function, TKContext.this.mContext));
            }
        });
    }

    public void onDestroy() throws Throwable {
        com.tk.core.bridge.d dVar = !this.mContext.pj().isReleased() ? (com.tk.core.bridge.d) getGlobalNativeObject("Tachikoma") : null;
        if (dVar != null) {
            dVar.be("onContainerDestroy");
        }
        c.rY().b(this.mContext.pj());
        ContainerInfoMap.remove(this.mContext.hashCode());
        this.mContext.onDestroy();
    }

    public void onCreate() {
        this.mContext.onCreate();
    }

    public TKViewContainer createView(String str, Object... objArr) {
        e eVarA = this.mContext.a(str, objArr);
        if (eVarA == null) {
            a.a("TKContext", "Can not createView by script", null);
            return null;
        }
        return new TKViewContainer(str, eVarA);
    }

    public void evaluateScript(String str, String str2, String str3, j jVar) {
        evaluateScript("", "", -1, str, str2, str3, jVar);
    }

    public Object evaluateScript(String str, String str2, int i, String str3, String str4, String str5, final j jVar) {
        if (!TextUtils.isEmpty(str5)) {
            this.mRootDir = str5;
            this.mContext.bb(str5);
        }
        if (this.mContext.pj() != null) {
            return this.mContext.pj().a(str, str2, i, str3, str4, new j() { // from class: com.kuaishou.tk.api.TKContext.3
                @Override // com.tk.core.a.j
                public void success() {
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.success();
                    }
                }

                @Override // com.tk.core.a.j
                public void failed(Throwable th) {
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.failed(th);
                    }
                }
            });
        }
        if (jVar == null) {
            return null;
        }
        jVar.failed(new Throwable("mContext.context() is null"));
        return null;
    }

    public Object getGlobalNativeObject(String str) {
        return this.mContext.getGlobalNativeObject(str);
    }

    public String getmRootDir() {
        return this.mRootDir;
    }

    public b getContext() {
        return this.mContext;
    }

    public String getTag() {
        b bVar = this.mContext;
        return bVar != null ? bVar.getTag() : "";
    }

    public V8 getV8Context() {
        return this.mContext.pj().pi();
    }

    public IsolatePool.b getBindingIsolateRef() {
        return this.mContext.pj().getBindingIsolateRef();
    }

    public void setRenderWithoutUI(boolean z) {
        this.mContext.setRenderWithoutUI(z);
    }

    public long getFirstToNativeTime() {
        return this.mContext.getFirstToNativeTime();
    }

    public boolean getUseCleanContext() {
        return this.mContext.getUseCleanContext();
    }

    public boolean isCompile() {
        return this.mContext.pj().isCompile();
    }

    public int getCliValue() {
        return this.mContext.getCliValue();
    }

    public void setCustomEnv(Map<String, CustomEnv> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        if (!map.isEmpty()) {
            for (Map.Entry<String, CustomEnv> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    CustomEnv value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        map2.put(key, new com.tk.core.bridge.CustomEnv(value.value, value.isMutable));
                    }
                }
            }
        }
        this.mContext.setCustomEnv(map2);
    }

    public int getRepetitionCompileCount() {
        return this.mContext.pj().getRepetitionCompileCount();
    }

    public int getTotalCompileCount() {
        return this.mContext.pj().getTotalCompileCount();
    }

    public long getTotalCompileSize() {
        return this.mContext.pj().getTotalCompileSize();
    }

    public void setBundleId(String str) {
        this.mContext.setBundleId(str);
    }
}
