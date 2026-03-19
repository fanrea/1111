package com.sigmob.sdk.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LongClickLayout extends LinearLayout {
    private Runnable a;
    private boolean b;

    public LongClickLayout(Context context) {
        super(context);
        this.b = false;
        a(context);
    }

    public LongClickLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.b = false;
        a(context);
    }

    public LongClickLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.b = true;
        performLongClick();
    }

    private void a(final Context context) {
        this.a = new Runnable() { // from class: com.sigmob.sdk.nativead.LongClickLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        };
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.b = false;
            postDelayed(this.a, 2000);
        } else if (ev.getAction() == 1 || ev.getAction() == 3) {
            removeCallbacks(this.a);
            if (this.b) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
