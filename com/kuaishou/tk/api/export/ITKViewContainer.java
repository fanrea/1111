package com.kuaishou.tk.api.export;

import android.widget.FrameLayout;
import com.kuaishou.tk.api.export.sdk.IFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ITKViewContainer {

    public interface IJS2NativeInvoker {
        Object onJSInvokeNativeWithJSONString(String str, String str2, IFunction iFunction);
    }

    void close();

    ITKViewContainer getContainer();

    FrameLayout getView();

    Object invokeJSFunctionWithJSONString(String str, String str2, IFunction iFunction);

    void setData(Object... objArr);

    void setIJS2NativeInvoker(IJS2NativeInvoker iJS2NativeInvoker);
}
