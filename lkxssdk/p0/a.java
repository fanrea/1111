package lkxssdk.p0;

import com.lingku.xuanshang.xutils.http.RequestParams;
import lkxssdk.p0.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements b.InterfaceC0846b {
    public final /* synthetic */ RequestParams a;

    public a(RequestParams requestParams) {
        this.a = requestParams;
    }

    @Override // lkxssdk.p0.b.InterfaceC0846b
    public void onParseKV(String str, Object obj) {
        this.a.addParameter(str, obj);
    }
}
