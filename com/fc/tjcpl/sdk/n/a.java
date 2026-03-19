package com.fc.tjcpl.sdk.n;

import android.app.Activity;
import com.fc.tjcpl.sdk.TJActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    public TJActivity a;
    public com.fc.tjcpl.sdk.a.f b;

    public a(TJActivity tJActivity) {
        this.a = tJActivity;
    }

    public a(com.fc.tjcpl.sdk.a.f fVar) {
        this.b = fVar;
    }

    public Activity a() {
        com.fc.tjcpl.sdk.a.f fVar;
        TJActivity tJActivity = this.a;
        return (tJActivity == null && (fVar = this.b) != null) ? fVar.getActivity() : tJActivity;
    }

    public String b() {
        TJActivity tJActivity = this.a;
        if (tJActivity != null) {
            return tJActivity.e;
        }
        com.fc.tjcpl.sdk.a.f fVar = this.b;
        return fVar != null ? fVar.c : "";
    }
}
