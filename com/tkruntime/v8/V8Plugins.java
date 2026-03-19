package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class V8Plugins {
    private static volatile ErrorHandler sJSBindingErrorHandler;

    public interface ErrorHandler {
        void onExceptionCaptured(Throwable th);
    }

    static ErrorHandler getJSBindingErrorHandler() {
        return sJSBindingErrorHandler;
    }

    public static void setJSBindingErrorHandler(ErrorHandler errorHandler) {
        sJSBindingErrorHandler = errorHandler;
    }
}
