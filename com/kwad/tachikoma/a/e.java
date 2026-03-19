package com.kwad.tachikoma.a;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private Map<Integer, g> BA;
    private JsValueRef<V8Object> BB;
    private AtomicInteger Bt;
    private WeakReference<Activity> By;
    private ILifeCycleListener Bz;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Bt = new AtomicInteger(0);
        this.BA = new HashMap();
    }

    private void bindActivity(Activity activity) {
        this.By = new WeakReference<>(activity);
    }

    private void ia() {
        if (this.Bz != null) {
            return;
        }
        this.Bz = new ILifeCycleListener() { // from class: com.kwad.tachikoma.a.e.1
            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToBackground() {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToForeground() {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                e.this.a(activity, 1);
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityResumed(Activity activity) {
                e.this.a(activity, 2);
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityPaused(Activity activity) {
                e.this.a(activity, 3);
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityDestroyed(Activity activity) {
                e.this.a(activity, 4);
            }
        };
        ((a) pO().getGlobalNativeObject("KSAdTKApplication")).a(this.Bz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = this.By) == null || weakReference.get() == null || !activity.equals(this.By.get())) {
            return;
        }
        Iterator<Map.Entry<Integer, g>> it = this.BA.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().call(null, Integer.valueOf(i));
        }
    }

    public final boolean isActive() {
        WeakReference<Activity> weakReference = this.By;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.By.get().equals(OfflineHostProvider.getApi().lifeCycle().getCurrentActivity());
    }

    public final int f(V8Function v8Function) {
        ia();
        g gVar = new g(v8Function, pO());
        int iIncrementAndGet = this.Bt.incrementAndGet();
        this.BA.put(Integer.valueOf(iIncrementAndGet), gVar);
        return iIncrementAndGet;
    }

    public final void bQ(int i) {
        this.BA.remove(Integer.valueOf(i));
    }

    public final boolean ib() {
        WeakReference<Activity> weakReference = this.By;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        this.By.get().finish();
        return true;
    }

    public final Object ic() {
        WeakReference<Activity> weakReference = this.By;
        FrameLayout frameLayout = null;
        if (weakReference == null || weakReference.get() == null || getJsObj() == null) {
            return null;
        }
        Activity activity = this.By.get();
        View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        if (!(viewFindViewById instanceof ViewGroup)) {
            return Boolean.FALSE;
        }
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        int i = 0;
        while (true) {
            if (i >= viewGroup.getChildCount()) {
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof FrameLayout) && childAt.getContentDescription() != null && "4095".contentEquals(childAt.getContentDescription())) {
                frameLayout = (FrameLayout) childAt;
                break;
            }
            i++;
        }
        if (frameLayout == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout frameLayout2 = new FrameLayout(activity);
            frameLayout2.setContentDescription("4095");
            viewGroup.addView(frameLayout2, layoutParams);
            frameLayout = frameLayout2;
        }
        viewGroup.bringChildToFront(frameLayout);
        if (com.kwad.tachikoma.t.b.c(this.BB)) {
            return this.BB.get();
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdTKContainer");
        c cVar = new c(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        cVar.a(frameLayout);
        v8ObjectProxy.setNativeObject(cVar);
        this.BB = V8Proxy.retainJsValue(v8ObjectProxy, this);
        return v8ObjectProxy;
    }

    public static V8Object a(Activity activity, com.tk.core.bridge.b bVar) {
        if (activity == null || bVar == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(bVar.pj().pi(), "KSAdTKPage");
        e eVar = new e(new NativeModuleInitParams.Builder(bVar, v8ObjectProxy).build());
        eVar.bindActivity(activity);
        v8ObjectProxy.setNativeObject(eVar);
        return v8ObjectProxy;
    }
}
