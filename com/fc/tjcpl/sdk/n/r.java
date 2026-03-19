package com.fc.tjcpl.sdk.n;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.fc.tjcpl.sdk.view.CustomViewContent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class r implements DownloadListener {
    public final /* synthetic */ CustomViewContent a;

    public r(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            this.a.a.a().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
