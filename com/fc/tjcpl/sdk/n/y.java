package com.fc.tjcpl.sdk.n;

import android.app.Activity;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class y {
    public z a;
    public Activity b;
    public x c;
    public a0 d;

    public y(Activity activity) {
        this.b = activity;
    }

    public void a() {
        z zVar = this.a;
        if (zVar != null) {
            zVar.cancel();
        }
    }

    public final void a(int i) {
        if (i == 1) {
            ((TextView) this.a.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn"))).setOnClickListener(this.d);
        } else {
            if (i != 2) {
                return;
            }
            TextView textView = (TextView) this.a.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_left"));
            TextView textView2 = (TextView) this.a.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_right"));
            textView.setOnClickListener(this.d);
            textView2.setOnClickListener(this.d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r9, com.fc.tjcpl.sdk.n.x r10) {
        /*
            r8 = this;
            r8.c = r10
            r0 = 11
            r1 = 9
            r2 = 0
            java.lang.String r3 = "layout"
            r4 = 1
            if (r9 != r4) goto L15
            android.app.Activity r5 = r8.b
            java.lang.String r6 = "tj_dialog_normal"
        L10:
            int r3 = com.fc.tjcpl.sdk.b.a.a(r5, r3, r6)
            goto L24
        L15:
            if (r9 != r1) goto L1c
            android.app.Activity r5 = r8.b
            java.lang.String r6 = "tj_dialog_notitle_onebtn"
            goto L10
        L1c:
            if (r9 != r0) goto L23
            android.app.Activity r5 = r8.b
            java.lang.String r6 = "tj_dialog_normal_notitle"
            goto L10
        L23:
            r3 = r2
        L24:
            com.fc.tjcpl.sdk.n.a0 r5 = new com.fc.tjcpl.sdk.n.a0
            android.app.Activity r6 = r8.b
            android.content.Context r6 = r6.getApplicationContext()
            r5.<init>(r6, r10)
            r8.d = r5
            com.fc.tjcpl.sdk.n.z r10 = new com.fc.tjcpl.sdk.n.z
            android.app.Activity r5 = r8.b
            java.lang.String r6 = "style"
            java.lang.String r7 = "TJDialog"
            int r6 = com.fc.tjcpl.sdk.b.a.a(r5, r6, r7)
            r10.<init>(r5, r6, r3)
            r8.a = r10
            r10.setCanceledOnTouchOutside(r2)
            r10 = 2
            if (r9 == r4) goto L53
            if (r9 == r10) goto L4f
            if (r9 == r1) goto L4f
            if (r9 == r0) goto L53
            goto L56
        L4f:
            r8.a(r4)
            goto L56
        L53:
            r8.a(r10)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.n.y.a(int, com.fc.tjcpl.sdk.n.x):void");
    }

    public void a(String str) {
        z zVar = this.a;
        if (zVar != null) {
            ((TextView) zVar.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_content"))).setText(str);
        }
    }

    public void a(boolean z) {
        z zVar = this.a;
        if (zVar != null) {
            zVar.setCancelable(z);
        }
    }

    public void b() {
        if (this.a == null || this.b.isFinishing()) {
            return;
        }
        z zVar = this.a;
        zVar.a = this.c;
        zVar.show();
    }

    public void b(int i) {
        z zVar = this.a;
        if (zVar != null) {
            ((TextView) zVar.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_right"))).setTextColor(i);
        }
    }

    public void b(String str) {
        z zVar = this.a;
        if (zVar != null) {
            ((TextView) zVar.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_left"))).setText(str);
        }
    }

    public void b(boolean z) {
        z zVar = this.a;
        if (zVar != null) {
            zVar.setCanceledOnTouchOutside(z);
        }
    }

    public void c(String str) {
        z zVar = this.a;
        if (zVar != null) {
            ((TextView) zVar.findViewById(com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_right"))).setText(str);
        }
    }
}
