package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    private df a;
    private String b;

    public interface a {
        void a();

        void a(int i, String str, NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i);

        void a(List<NativeResponse> list);

        void b();

        void b(int i, String str, NativeResponse nativeResponse);

        void b(NativeResponse nativeResponse);

        void c();
    }

    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public g(Context context, String str, a aVar, boolean z, int i) {
        this(context, aVar, new df(context, str, "feed", z, i));
    }

    public g(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i) {
        df dfVar = new df(context, str, "feed", z, i);
        this.a = dfVar;
        dfVar.a(expressAdListener);
        this.a.a(1);
    }

    public g(Context context, String str, BaiduNativeManager.EntryAdListener entryAdListener, boolean z, int i) {
        df dfVar = new df(context, str, "sones", z, i);
        this.a = dfVar;
        dfVar.a(entryAdListener);
    }

    public g(Context context, String str, a aVar, boolean z, int i, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("insite")) {
                this.a = new df(context, str, "insite", z, i);
            } else if (str2.equals("sug")) {
                this.a = new df(context, str, "sug", z, i);
            } else if (str2.equals("preroll")) {
                this.a = new df(context, str, "video", z, i);
            } else {
                this.a = new df(context, str, "feed", z, i);
            }
        }
        this.a.a(aVar);
    }

    public g(Context context, a aVar, df dfVar) {
        this.a = dfVar;
        dfVar.a(aVar);
    }

    public void a() {
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.p();
        }
    }

    public void a(b bVar) {
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.a(bVar);
        }
    }

    public void a(int i) {
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.r = i;
        }
    }

    public void a(boolean z) {
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.c(z);
        }
    }

    public String a(RequestParameters requestParameters) {
        if (this.a == null) {
            return null;
        }
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.a.h(this.b);
        this.a.a(requestParameters);
        return this.a.l();
    }

    public void a(String str) {
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.b(str);
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        df dfVar = this.a;
        if (dfVar != null) {
            dfVar.h(this.b);
        }
        this.a.a(requestParameters);
        this.a.a();
    }

    public void b(String str) {
        this.b = str;
    }
}
