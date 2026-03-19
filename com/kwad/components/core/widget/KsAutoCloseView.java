package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String FV = "%s秒后自动关闭";
    private TextView akY;
    private ImageView akZ;
    private a ala;
    private boolean alb;
    private boolean alc;
    private int countDown;

    public interface a {
        void el();

        void em();
    }

    static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.alb = true;
        this.alc = false;
        A(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.alb = true;
        this.alc = false;
        A(context);
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.alb = true;
        this.alc = false;
        A(context);
    }

    public void setViewListener(a aVar) {
        this.ala = aVar;
    }

    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.alb = true;
        this.alc = false;
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_auto_close, this);
        this.akY = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.akZ = imageView;
        imageView.setOnClickListener(this);
    }

    public final void ai(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new bh() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (KsAutoCloseView.this.alb) {
                    if (!KsAutoCloseView.this.alc) {
                        if (KsAutoCloseView.this.countDown == 0) {
                            if (KsAutoCloseView.this.ala != null) {
                                KsAutoCloseView.this.ala.el();
                                return;
                            }
                            return;
                        } else {
                            KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                            ksAutoCloseView.G(ksAutoCloseView.countDown);
                            KsAutoCloseView.e(KsAutoCloseView.this);
                            KsAutoCloseView.this.postDelayed(this, 1000L);
                            return;
                        }
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i) {
        this.akY.setText(String.format(FV, Integer.valueOf(i)));
    }

    public void setCountDownPaused(boolean z) {
        this.alc = z;
    }

    public final void bh(boolean z) {
        this.alb = z;
        int i = z ? 0 : 8;
        TextView textView = this.akY;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ala != null && view.equals(this.akZ)) {
            this.ala.em();
        }
    }
}
