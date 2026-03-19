package com.kuaishou.tk.export;

import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class NativeModuleInitParams {
    public final Object[] args;
    public final ITKContext tkContext;
    public final V8Object v8This;

    public static class Builder {
        private Object[] mArgs;
        private final ITKContext mContext;
        private final V8Object v8This;

        public Builder(ITKContext iTKContext, V8Object v8Object) {
            this.mContext = iTKContext;
            this.v8This = v8Object;
        }

        public Builder setArgs(Object[] objArr) {
            this.mArgs = objArr;
            return this;
        }

        public NativeModuleInitParams build() {
            return new NativeModuleInitParams(this.mContext, this.v8This, this.mArgs);
        }
    }

    public NativeModuleInitParams(ITKContext iTKContext, V8Object v8Object, Object[] objArr) {
        this.tkContext = iTKContext;
        this.v8This = v8Object;
        this.args = objArr;
    }
}
