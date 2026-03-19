package com.tk.component.container.round;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.tk.core.component.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class RoundTKYogaLayout extends f {
    private final RectF Ex;
    private Path FC;
    private RadiusMode PE;
    private float[] PF;

    public enum RadiusMode {
        NONE,
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT
    }

    public RoundTKYogaLayout(Context context) {
        super(context);
        this.PE = RadiusMode.NONE;
        this.PF = new float[8];
        this.Ex = new RectF();
    }

    public final void a(float f, RadiusMode radiusMode) {
        this.PE = radiusMode;
        int i = AnonymousClass1.PG[this.PE.ordinal()];
        if (i == 1) {
            this.PF = new float[]{f, f, f, f, f, f, f, f};
        } else if (i == 2) {
            float[] fArr = this.PF;
            fArr[0] = f;
            fArr[1] = f;
        } else if (i == 3) {
            float[] fArr2 = this.PF;
            fArr2[2] = f;
            fArr2[3] = f;
        } else if (i == 4) {
            float[] fArr3 = this.PF;
            fArr3[6] = f;
            fArr3[7] = f;
        } else if (i == 5) {
            float[] fArr4 = this.PF;
            fArr4[4] = f;
            fArr4[5] = f;
        } else {
            this.PF = new float[8];
        }
        boolean z = false;
        for (float f2 : this.PF) {
            z |= f2 != 0.0f;
        }
        if (!z || radiusMode == RadiusMode.NONE) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
            updatePath();
        }
    }

    /* renamed from: com.tk.component.container.round.RoundTKYogaLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PG = new int[RadiusMode.values().length];

        static {
            try {
                PG[RadiusMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PG[RadiusMode.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PG[RadiusMode.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PG[RadiusMode.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PG[RadiusMode.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = this.Ex;
        rectF.top = 0.0f;
        rectF.left = 0.0f;
        rectF.right = i;
        rectF.bottom = i2;
        updatePath();
    }

    private void updatePath() {
        Path path = this.FC;
        if (path == null) {
            this.FC = new Path();
        } else {
            path.reset();
        }
        this.FC.setFillType(Path.FillType.EVEN_ODD);
        this.FC.addRoundRect(this.Ex, this.PF, Path.Direction.CW);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.PE == RadiusMode.NONE) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.FC);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
