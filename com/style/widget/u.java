package com.style.widget;

import android.content.Context;
import android.view.MotionEvent;
import com.baidu.mobads.container.components.e.b;
import com.component.interfaces.RemoteReflectInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class u extends com.component.a.a.d implements com.baidu.mobads.container.components.command.b {
    private static final String d = u.class.getSimpleName();
    private String e;
    private final Context f;
    private boolean g;

    public u(Context context) {
        super(context);
        this.e = "";
        this.g = true;
        this.f = context;
    }

    public void b(String str) {
        this.e = str;
    }

    public void d(boolean z) {
        this.g = z;
    }

    public boolean d() {
        return this.g;
    }

    @Override // com.baidu.mobads.container.components.command.b
    public void a() {
        int downloadStatus = RemoteReflectInterface.getDownloadStatus(this.e);
        if (downloadStatus < 0) {
            this.b = this.c;
            if (!com.baidu.mobads.container.util.j.b(getContext(), this.e)) {
                this.a = "立即下载";
            } else {
                this.a = "去看看";
            }
        } else if (downloadStatus < 101) {
            this.a = downloadStatus + "%";
            this.b = downloadStatus;
        } else if (downloadStatus == 101) {
            this.b = this.c;
            if (!com.baidu.mobads.container.util.j.b(getContext(), this.e)) {
                this.a = "点击安装";
            } else {
                this.a = "去看看";
            }
        } else if (downloadStatus == 102) {
            this.a = "继续下载";
        } else if (downloadStatus == 104) {
            this.a = "重新下载";
            this.b = this.c;
        }
        postInvalidate();
    }

    @Override // com.component.a.a.d, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.f).b(this.e);
        if (bVarB == null) {
            return super.onTouchEvent(motionEvent);
        }
        b.a aVarI = bVarB.i();
        if ((aVarI == b.a.DOWNLOADING || aVarI == b.a.INITING) && d()) {
            bVarB.a(2);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
