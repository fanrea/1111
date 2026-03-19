package com.tk.core.component.f;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.e.b;
import com.tk.core.e.c.c;
import com.tk.core.o.ac;
import com.tk.core.o.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<Switch> implements CompoundButton.OnCheckedChangeListener {
    private String aeI;
    private String aeJ;
    public boolean aeK;

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return true;
    }

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return M(context);
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        getView().setOnCheckedChangeListener(this);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        if (pQ()) {
            getView().setOnCheckedChangeListener(null);
        }
    }

    private static Switch M(Context context) {
        return new Switch(context);
    }

    public final void setChecked(boolean z) {
        this.aeK = z;
        au(this.aeK);
    }

    public final void ck(String str) {
        this.aeI = str;
        if (getView().isChecked()) {
            cn(str);
        }
    }

    public final void cl(String str) {
        this.aeJ = str;
        if (getView().isChecked()) {
            return;
        }
        cn(str);
    }

    public final void cm(String str) {
        a(getView().getThumbDrawable(), str);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
        this.aeK = z;
        av(z);
        a("switch", new b.a() { // from class: com.tk.core.component.f.a.2
            @Override // com.tk.core.e.b.a
            public final void a(com.tk.core.e.a.b bVar) {
                if (bVar instanceof c) {
                    bVar.bX("switch");
                    ((c) bVar).aD(z);
                }
            }
        });
    }

    private void au(boolean z) {
        if (getView().isChecked() != z) {
            getView().setChecked(z);
            av(z);
        }
    }

    private void a(Drawable drawable, String str) {
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (str == null) {
            drawable.clearColorFilter();
        } else {
            drawable.setColorFilter(numValueOf.intValue(), PorterDuff.Mode.MULTIPLY);
        }
    }

    private void av(boolean z) {
        cn(z ? this.aeI : this.aeJ);
    }

    private void cn(String str) {
        a(getView().getTrackDrawable(), str);
    }
}
