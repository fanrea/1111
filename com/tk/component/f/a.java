package com.tk.component.f;

import android.os.Looper;
import android.widget.Toast;
import com.baidu.mobads.container.util.animation.j;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private Toast Xa;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.tk.core.exception.a.a(pO(), new Throwable("create Toast on subThread"));
        }
    }

    public final void r(String str, String str2) {
        this.Xa = Toast.makeText(getContext(), str, "long".equalsIgnoreCase(str2) ? 1 : 0);
        this.Xa.setText(str);
        this.Xa.setGravity(17, 0, 0);
        this.Xa.show();
    }

    public final void a(V8Object v8Object, String str, String str2, int i) {
        e eVar = (e) getNativeModule(v8Object);
        if (eVar == null || eVar.getView() == null) {
            com.tk.core.i.a.a("Toast", "Toast customView is illegal", null);
            return;
        }
        boolean zEqualsIgnoreCase = "long".equalsIgnoreCase(str);
        int i2 = 17;
        if (j.f.equalsIgnoreCase(str2)) {
            i2 = 48;
        } else if (j.g.equalsIgnoreCase(str2)) {
            i2 = 80;
        }
        this.Xa = new Toast(getContext());
        this.Xa.setView(eVar.getView());
        this.Xa.setGravity(i2, 0, o.eb(i));
        this.Xa.setDuration(zEqualsIgnoreCase ? 1 : 0);
        this.Xa.show();
    }

    public final void hide() {
        Toast toast = this.Xa;
        if (toast != null) {
            toast.cancel();
        }
    }
}
