package com.kwad.components.ct.detail.photo.newui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.core.d.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MarqueeView extends View {
    private static a atJ = new a(40);
    private int Oq;
    private String Xp;
    private Rect anI;
    private String atK;
    private float atL;
    private int atM;
    private float atN;
    private float atO;
    private int atP;
    private boolean atQ;
    private TextPaint atR;
    private int atS;
    private int atT;
    private boolean atU;
    private float atV;
    private b atW;
    private float mSpeed;

    public interface b {
        void Aq();
    }

    static class a implements Handler.Callback {
        private static Handler atY;
        private final Object lock = new Object();
        private List<WeakReference<b>> atZ = new ArrayList();
        private long aua = 40;

        a(long j) {
            if (atY == null) {
                atY = new Handler(Looper.getMainLooper(), this);
            }
        }

        private void start() {
            atY.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.aua);
        }

        private static void stop() {
            atY.removeMessages(0);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 0) {
                if (this.atZ.size() > 0) {
                    try {
                        Ar();
                    } catch (Exception e) {
                        c.printStackTrace(e);
                    }
                }
                atY.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + this.aua);
            }
            return false;
        }

        private void Ar() {
            synchronized (this.lock) {
                Iterator<WeakReference<b>> it = this.atZ.iterator();
                while (it.hasNext()) {
                    b bVar = it.next().get();
                    if (bVar != null) {
                        bVar.Aq();
                    }
                }
            }
        }

        final void a(b bVar) {
            synchronized (this.lock) {
                if (this.atZ.size() == 0) {
                    start();
                }
                boolean z = false;
                Iterator<WeakReference<b>> it = this.atZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<b> next = it.next();
                    if (next.get() == null) {
                        it.remove();
                    } else if (next.get() == bVar) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.atZ.add(new WeakReference<>(bVar));
                }
            }
        }

        final void b(b bVar) {
            synchronized (this.lock) {
                Iterator<WeakReference<b>> it = this.atZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<b> next = it.next();
                    if (next.get() == null) {
                        it.remove();
                    } else if (next.get().equals(bVar)) {
                        it.remove();
                        break;
                    }
                }
                if (this.atZ.size() == 0) {
                    stop();
                }
            }
        }
    }

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpeed = 1.0f;
        this.Oq = -16777216;
        this.atL = 12.0f;
        this.atM = 1;
        this.atN = 1.0f;
        this.atO = 0.0f;
        this.atQ = false;
        this.atT = 0;
        this.atU = true;
        this.Xp = "";
        this.atW = new b() { // from class: com.kwad.components.ct.detail.photo.newui.MarqueeView.1
            @Override // com.kwad.components.ct.detail.photo.newui.MarqueeView.b
            public final void Aq() {
                if (!MarqueeView.this.atQ || TextUtils.isEmpty(MarqueeView.this.Xp)) {
                    return;
                }
                MarqueeView.this.atO -= MarqueeView.this.mSpeed;
                MarqueeView.this.postInvalidate();
            }
        };
        dJ();
    }

    private void dJ() {
        this.anI = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.atR = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.atR.setColor(this.Oq);
        this.atR.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), this.atL));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.atU) {
            float f = this.atN;
            if (f < 0.0f) {
                this.atN = 0.0f;
            } else if (f > 1.0f) {
                this.atN = 1.0f;
            }
            this.atO = getWidth() * this.atN;
            this.atU = false;
        }
        int i = this.atM;
        if (i != 1) {
            if (i == 2) {
                float f2 = this.atO;
                if (f2 < 0.0f) {
                    int i2 = (int) ((-f2) / this.atP);
                    int i3 = this.atT;
                    if (i2 >= i3) {
                        this.atT = i3 + 1;
                        this.atK += this.Xp;
                    }
                }
            } else if (this.atP < (-this.atO)) {
                Ap();
            }
        } else if (this.atP <= (-this.atO)) {
            this.atO = getWidth();
        }
        String str = this.atK;
        if (str != null) {
            canvas.drawText(str, this.atO, (getHeight() / 2.0f) + (this.atV / 2.0f), this.atR);
        }
    }

    public void setRepetType(int i) {
        this.atM = i;
        this.atU = true;
        setContent(this.Xp);
    }

    public final void Ao() {
        if (this.atQ) {
            return;
        }
        atJ.a(this.atW);
        this.atQ = true;
    }

    public final void Ap() {
        this.atQ = false;
        atJ.b(this.atW);
    }

    public void setTextDistance(int i) {
        int blacktWidth = getBlacktWidth();
        int iA = blacktWidth > 0 ? com.kwad.sdk.c.a.a.a(getContext(), i) / blacktWidth : 1;
        int i2 = iA != 0 ? iA : 1;
        this.atS = blacktWidth * i2;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 <= i2; i3++) {
            sb.append(" ");
        }
        setContent(sb.toString());
    }

    private int getBlacktWidth() {
        return by("en en") - by("enen");
    }

    private int by(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        if (this.anI == null) {
            this.anI = new Rect();
        }
        this.atR.getTextBounds(str, 0, str.length(), this.anI);
        this.atV = getContentHeight();
        return this.anI.width();
    }

    private float getContentHeight() {
        Paint.FontMetrics fontMetrics = this.atR.getFontMetrics();
        return Math.abs(fontMetrics.bottom - fontMetrics.top) / 2.0f;
    }

    public void setTextColor(int i) {
        if (i != 0) {
            this.Oq = i;
            this.atR.setColor(i);
        }
    }

    public void setTextSize(float f) {
        if (f > 0.0f) {
            this.atL = f;
            this.atR.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), f));
            this.atP = by(this.Xp) + this.atS;
        }
    }

    public void setTextSpeed(float f) {
        this.mSpeed = f;
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.atO = getWidth() * this.atN;
        if (!str.endsWith("")) {
            str = str + "";
        }
        this.Xp = str;
        int i = this.atM;
        if (i == 2) {
            int iBy = by(str) + this.atS;
            this.atP = iBy;
            this.atT = 0;
            int width = iBy == 0 ? 0 : (getWidth() / this.atP) + 2;
            this.atK = "";
            StringBuilder sb = new StringBuilder(this.atK);
            for (int i2 = 0; i2 <= width; i2++) {
                sb.append(this.Xp);
            }
            this.atK = sb.toString();
            return;
        }
        float f = this.atO;
        if (f < 0.0f && i == 0 && (-f) > this.atP) {
            this.atO = getWidth() * this.atN;
        }
        this.atP = by(this.Xp);
        this.atK = str;
    }

    public void setStartLocationDistance(float f) {
        this.atN = f;
    }
}
