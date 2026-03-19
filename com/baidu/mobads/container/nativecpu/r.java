package com.baidu.mobads.container.nativecpu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.ci;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class r {
    private static final String a = r.class.getSimpleName();
    private a c;
    private ci.b d;
    private JSONObject e;
    private long f;
    private Context i;
    private long j;
    private bq b = bq.a();
    private long g = 1500;
    private boolean h = false;

    public r(a aVar) {
        this.c = aVar;
        a();
    }

    private void a() {
        f fVarJ;
        if (this.c != null && this.c.h != null && (fVarJ = this.c.h.J()) != null) {
            this.g = fVarJ.a().d();
            this.h = fVarJ.a().f();
        }
    }

    public void a(View view) {
        if (view == null || this.c == null) {
            return;
        }
        this.i = view.getContext();
        if (this.h) {
            b(view);
        }
    }

    private void b(View view) throws JSONException {
        try {
            if (this.e == null) {
                this.e = new JSONObject();
                this.e.put("visible_percent", 0);
                this.e.put("window_focus", true);
            }
        } catch (Exception e) {
            this.b.a(a, e.getMessage());
        }
        if (this.d == null) {
            this.d = new s(this);
        }
        ci.a().a(view, this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        if (j > 0) {
            try {
                if (j2 - j >= this.g) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : this.c.j) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str + "&enterScreenTime=" + j + "&exitScreenTime=" + j2);
                        }
                    }
                    com.baidu.mobads.container.nativecpu.a.c.a().a(this.i, arrayList);
                }
            } catch (Exception e) {
                this.b.a(a, e.getMessage());
            }
        }
    }
}
