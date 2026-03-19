package lkxssdk.l;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.lingku.xuanshang.core.ui.base.BaseActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class v {
    public BaseActivity a;
    public ValueCallback<Uri> b;
    public ValueCallback<Uri[]> c;
    public boolean d;

    public v(BaseActivity baseActivity) {
        this.a = baseActivity;
    }

    public final void a() {
        ValueCallback<Uri> valueCallback = this.b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.b = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.c;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.c = null;
        }
    }
}
