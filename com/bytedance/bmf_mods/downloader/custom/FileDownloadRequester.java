package com.bytedance.bmf_mods.downloader.custom;

import com.bytedance.ttnet.utils.RetrofitUtils;
import com.component.a.f.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IFileDownloadRequester.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/FileDownloadRequester;", "", "()V", d.b, "Lcom/bytedance/bmf_mods/downloader/custom/IDownloadRequester;", "host", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class FileDownloadRequester {
    public static final FileDownloadRequester INSTANCE = new FileDownloadRequester();

    private FileDownloadRequester() {
    }

    public final IDownloadRequester create(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        Object objCreate = RetrofitUtils.getSsRetrofit(host).create(IDownloadRequester.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "getSsRetrofit(host).crea…oadRequester::class.java)");
        return (IDownloadRequester) objCreate;
    }
}
