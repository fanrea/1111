package com.tk.component.a;

import android.graphics.Path;
import android.graphics.RectF;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.o;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class g extends TKBaseNativeModule {
    private final RectF Ex;
    private final Path FC;
    private volatile boolean NZ;

    public g(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ex = new RectF();
        this.FC = new Path();
        this.FC.setFillType(Path.FillType.WINDING);
    }

    public final void w(Object obj) {
        if (this.NZ) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.FC.addRect(this.Ex, Path.Direction.CW);
    }

    public final void x(Object obj) {
        if (this.NZ) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.FC.addOval(this.Ex, Path.Direction.CW);
    }

    public final void f(float f, float f2, float f3) {
        if (this.NZ) {
            return;
        }
        this.FC.addCircle(o.P(f), o.P(f2), o.P(f3), Path.Direction.CW);
    }

    public final void a(Object obj, float f, float f2) {
        if (this.NZ) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.FC.addRoundRect(this.Ex, o.P(f), o.P(f2), Path.Direction.CW);
    }

    public final void b(Object obj, float f, float f2) {
        if (this.NZ) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.FC.addArc(this.Ex, f, f2);
    }

    public final void q(V8Object v8Object) {
        if (this.NZ) {
            return;
        }
        this.FC.addPath(((g) getNativeModule(v8Object)).getPath());
    }

    public final void moveTo(float f, float f2) {
        if (this.NZ) {
            return;
        }
        this.FC.moveTo(o.P(f), o.P(f2));
    }

    public final void lineTo(float f, float f2) {
        if (this.NZ) {
            return;
        }
        this.FC.lineTo(o.P(f), o.P(f2));
    }

    public final void quadTo(float f, float f2, float f3, float f4) {
        if (this.NZ) {
            return;
        }
        this.FC.quadTo(o.P(f), o.P(f2), o.P(f3), o.P(f4));
    }

    public final void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.NZ) {
            return;
        }
        this.FC.cubicTo(o.P(f), o.P(f2), o.P(f3), o.P(f4), o.P(f5), o.P(f6));
    }

    public final void c(Object obj, float f, float f2) {
        if (this.NZ) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.FC.arcTo(this.Ex, f, f2);
    }

    public final void close() {
        if (this.NZ) {
            return;
        }
        this.FC.close();
    }

    public final void reset() {
        if (this.NZ) {
            return;
        }
        this.FC.reset();
    }

    public final Path getPath() {
        return this.FC;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.NZ = true;
    }
}
