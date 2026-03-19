package com.sigmob.sdk.base.views;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class af extends RelativeLayout {
    int a;
    boolean b;
    private final w c;
    private final w d;
    private int e;

    public af(Context context) {
        super(context);
        this.a = 0;
        this.b = false;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.c = new w(context);
        w wVar = new w(context);
        this.d = wVar;
        setLayoutParams(layoutParams);
        int i = this.a;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(9);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.addRule(20);
        }
        wVar.setId(ClientMetadata.generateViewId());
        addView(wVar, layoutParams2);
    }

    public void a(final int time) {
        this.e = time;
        if (!this.b) {
            if (time > 0) {
                this.d.setText(String.valueOf(time));
            }
        } else if (time > 0) {
            this.c.setText(com.sigmob.sdk.base.k.d(Integer.valueOf(time)));
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
        }
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.b = true;
        SigmobLog.d("show skip widget");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.a);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        w wVar = this.c;
        int i = this.a;
        wVar.setPadding((int) (i / 3.0f), 0, (int) (i / 3.0f), 0);
        int i2 = this.e;
        if (i2 > 0) {
            this.c.setText(com.sigmob.sdk.base.k.d(Integer.valueOf(i2)));
        } else {
            this.c.setText(com.sigmob.sdk.base.k.i());
        }
        addView(this.c, layoutParams);
    }

    public int getTime() {
        return this.e;
    }
}
