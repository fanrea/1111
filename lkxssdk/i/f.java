package lkxssdk.i;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class f implements DownloadListener {
    public final /* synthetic */ WebViewWrapper a;

    public f(WebViewWrapper webViewWrapper) {
        this.a = webViewWrapper;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            this.a.a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
