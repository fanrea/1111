package com.alliance.ssp.ad.o0;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: DownloadUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j {
    public static j b;
    public final OkHttpClient a = new OkHttpClient();

    /* compiled from: DownloadUtil.java */
    public interface b {
        void a(int i);

        void a(File file);

        void a(Exception exc);
    }

    public static j a() {
        if (b == null) {
            b = new j();
        }
        return b;
    }

    /* compiled from: DownloadUtil.java */
    public class a implements Callback {
        public final /* synthetic */ b a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;

        public a(j jVar, b bVar, Context context, String str) {
            this.a = bVar;
            this.b = context;
            this.c = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.a.a(iOException);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00f9 A[Catch: IOException -> 0x00fd, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x00fd, blocks: (B:30:0x00d1, B:53:0x00f9), top: B:84:0x008c }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00fe -> B:83:0x0103). Please report as a decompilation issue!!! */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResponse(okhttp3.Call r12, okhttp3.Response r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 287
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.o0.j.a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    public void a(Context context, String str, String str2, b bVar) {
        this.a.newCall(new Request.Builder().url(str).build()).enqueue(new a(this, bVar, context, str2));
    }
}
