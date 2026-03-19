package lk.repeackage;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.lk.oaid.ErrorCode;
import lk.repeackage.com.android.creator.IdsSupplier;
import lk.repeackage.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class l implements d {
    public final Context a;

    public class a implements t.a {
        public a(l lVar) {
        }

        @Override // lk.repeackage.t.a
        public String a(IBinder iBinder) {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new e("IdsSupplier is null");
        }
    }

    public l(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.a == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
        } else {
            if (!a()) {
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("freeme device Unsupported"));
                return;
            }
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            t.a(this.a, intent, cVar, new a(this));
        }
    }

    @Override // lk.repeackage.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            f.a(e);
            return false;
        }
    }
}
