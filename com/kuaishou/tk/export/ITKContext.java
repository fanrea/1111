package com.kuaishou.tk.export;

import android.content.Context;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface ITKContext {
    Context getContext();

    INativeModule getNativeModule(V8Object v8Object);

    String getTag();
}
