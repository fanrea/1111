package com.kwad.tachikoma.k;

import android.util.Log;
import com.kuaishou.tk.api.app.ITKLog;
import com.kwad.tachikoma.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements ITKLog {
    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void v(String str, String str2) {
        e.log().v(str, str2);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void v(String str, String str2, Throwable th) {
        e.log().v(str, str2 + getStackTraceString(th));
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void i(String str, String str2) {
        e.log().i(str, str2);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void i(String str, String str2, Throwable th) {
        e.log().i(str, str2 + getStackTraceString(th));
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void d(String str, String str2) {
        e.log().d(str, str2);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void d(String str, String str2, Throwable th) {
        e.log().d(str, str2 + getStackTraceString(th));
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void e(String str, String str2) {
        e.log().e(str, str2);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void e(String str, String str2, Throwable th) {
        e.log().e(str, str2, th);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void w(String str, String str2) {
        e.log().w(str, str2);
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void w(String str, Throwable th) {
        e.log().w(str, getStackTraceString(th));
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final void w(String str, String str2, Throwable th) {
        e.log().w(str, str2 + getStackTraceString(th));
    }

    @Override // com.kuaishou.tk.api.app.ITKLog
    public final String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }
}
