package lkxssdk.i;

import android.view.View;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c implements View.OnLongClickListener {
    public final /* synthetic */ WebViewWrapper a;

    public c(WebViewWrapper webViewWrapper) {
        this.a = webViewWrapper;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        WebViewWrapper webViewWrapper = this.a;
        if (!webViewWrapper.o) {
            return false;
        }
        return this.a.a(webViewWrapper.d.getHitTestResult());
    }
}
