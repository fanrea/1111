package com.kwad.tachikoma.o;

import android.app.PendingIntent;
import android.content.Intent;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private PendingIntent Ew;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final V8Object a(int i, V8Object v8Object, int i2) {
        Intent intent;
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdNativePendingIntent");
        NativeModuleInitParams nativeModuleInitParamsBuild = new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build();
        a aVar = (a) getNativeModule(v8Object);
        if (aVar == null || (intent = aVar.getIntent()) == null) {
            return null;
        }
        e eVar = new e(nativeModuleInitParamsBuild);
        eVar.Ew = PendingIntent.getActivity(getContext(), i, intent, i2);
        v8ObjectProxy.setNativeObject(eVar);
        return v8ObjectProxy;
    }

    public final V8Object b(int i, V8Object v8Object, int i2) {
        Intent intent;
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdNativePendingIntent");
        NativeModuleInitParams nativeModuleInitParamsBuild = new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build();
        a aVar = (a) getNativeModule(v8Object);
        if (aVar == null || (intent = aVar.getIntent()) == null) {
            return null;
        }
        e eVar = new e(nativeModuleInitParamsBuild);
        eVar.Ew = PendingIntent.getBroadcast(getContext(), i, intent, i2);
        v8ObjectProxy.setNativeObject(eVar);
        return v8ObjectProxy;
    }

    public final V8Object c(int i, V8Object v8Object, int i2) {
        Intent intent;
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdNativePendingIntent");
        NativeModuleInitParams nativeModuleInitParamsBuild = new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build();
        a aVar = (a) getNativeModule(v8Object);
        if (aVar == null || (intent = aVar.getIntent()) == null) {
            return null;
        }
        e eVar = new e(nativeModuleInitParamsBuild);
        eVar.Ew = PendingIntent.getService(getContext(), i, intent, i2);
        v8ObjectProxy.setNativeObject(eVar);
        return v8ObjectProxy;
    }

    public final V8Object d(int i, V8Object v8Object, int i2) {
        Intent intent;
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdNativePendingIntent");
        NativeModuleInitParams nativeModuleInitParamsBuild = new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build();
        a aVar = (a) getNativeModule(v8Object);
        if (aVar == null || (intent = aVar.getIntent()) == null) {
            return null;
        }
        e eVar = new e(nativeModuleInitParamsBuild);
        eVar.Ew = PendingIntent.getForegroundService(getContext(), i, intent, i2);
        v8ObjectProxy.setNativeObject(eVar);
        return v8ObjectProxy;
    }

    public final PendingIntent getPendingIntent() {
        return this.Ew;
    }
}
