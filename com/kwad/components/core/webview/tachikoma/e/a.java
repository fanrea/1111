package com.kwad.components.core.webview.tachikoma.e;

import android.text.TextUtils;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private List<Integer> ajH;
    private final List<Integer> ajI;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.ajH = new ArrayList();
        this.ajI = Arrays.asList(123, 184, 185, 190, 199, 200);
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.e.a$a, reason: collision with other inner class name */
    static class C0499a {
        private static final a ajM = new a(0);
    }

    public static a wk() {
        return C0499a.ajM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i) {
        if (this.ajI.contains(Integer.valueOf(i))) {
            this.ajH.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(String str) {
        int iOptInt;
        try {
            iOptInt = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            iOptInt = Integer.MAX_VALUE;
        }
        if (this.ajI.contains(Integer.valueOf(iOptInt))) {
            this.ajH.add(Integer.valueOf(iOptInt));
        }
    }

    public final void bt(final int i) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.e.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.bs(i);
            }
        });
    }

    public final void bq(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.e.a.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.bp(str);
            }
        });
    }

    public final List<Integer> wl() {
        return this.ajH;
    }

    public final void wm() {
        this.ajH.clear();
    }
}
