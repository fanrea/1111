package com.baidu.mobads.container.f;

import android.view.MotionEvent;
import android.view.View;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p implements View.OnClickListener, View.OnTouchListener {
    private final b a;
    private final JSONObject b;

    public p(b bVar, JSONObject jSONObject) {
        this.a = bVar;
        this.b = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            this.a.b(view, this.b);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
