package com.style.widget.b;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.activity.v;
import com.baidu.mobads.container.landingpage.ad;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.x;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.style.widget.b.e;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends DialogFragment {
    private static final String a = a.class.getSimpleName();
    private static final String b = "union_download_confirm_dialog";
    private static final String c = "android:savedDialogState";
    private Activity d;
    private com.baidu.mobads.container.adrequest.j e;
    private e i;
    private v j;
    private IOAdEventListener k;
    private String f = "";
    private String g = "";
    private String h = "";
    private boolean l = false;
    private int m = 0;

    public static a a(Activity activity, com.baidu.mobads.container.adrequest.j jVar) {
        a aVar = new a();
        aVar.d = activity;
        aVar.e = jVar;
        aVar.setCancelable(false);
        return aVar;
    }

    public a a(v vVar) {
        this.j = vVar;
        return this;
    }

    public a a(boolean z) {
        this.l = z;
        return this;
    }

    public a a(int i) {
        this.m = i;
        return this;
    }

    public a a(String str, String str2, String str3) {
        this.f = str;
        this.g = str2;
        this.h = str3;
        return this;
    }

    public void a() {
        if (this.d != null && this.e != null) {
            FragmentManager fragmentManager = this.d.getFragmentManager();
            if (fragmentManager != null) {
                show(fragmentManager, b);
                return;
            }
            return;
        }
        bq.a().c("Confirm dialog initialize failed.");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
        if (this.j != null) {
            this.j.d();
        }
        b("download_dialog_open");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        setShowsDialog(false);
        super.onActivityCreated(bundle);
        setShowsDialog(true);
        if (!getShowsDialog()) {
            return;
        }
        View view = getView();
        Dialog dialog = getDialog();
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            dialog.setContentView(view);
        }
        Activity activity = getActivity();
        if (activity != null) {
            dialog.setOwnerActivity(activity);
        }
        dialog.setCancelable(isCancelable());
        if (bundle != null && (bundle2 = bundle.getBundle(c)) != null) {
            dialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.d != null) {
            this.i = new e.a(this.e).a(com.baidu.mobads.container.config.b.a().f()).a(this.f, this.g, this.h).a(new b(this, this.d, this.e)).a(this.d, this.m);
            this.i.a();
        }
        return this.i;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            Window window = dialog.getWindow();
            b(this.l);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(0);
            window.setBackgroundDrawable(gradientDrawable);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z && x.a(null).a() >= 19 && getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        JSONObject originJsonObject;
        if (this.e != null && (originJsonObject = this.e.getOriginJsonObject()) != null && !TextUtils.isEmpty(str)) {
            return originJsonObject.optString(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            by.a.a(this.d.getApplicationContext()).a(803).a(this.e).a(this.f).b(this.h).c(this.g).a("reason", str).a("materialtype", this.e.getMaterialType()).a("dialogtype", this.m).g();
        } catch (Throwable th) {
            bq.a().c(a, th.getMessage());
        }
    }

    /* renamed from: com.style.widget.b.a$a, reason: collision with other inner class name */
    private class C0797a implements IOAdEventListener {
        private C0797a() {
        }

        /* synthetic */ C0797a(a aVar, b bVar) {
            this();
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType()) && a.this.j != null) {
                a.this.j.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (this.j == null) {
            return;
        }
        this.k = new C0797a(this, null);
        ad.a(context).a();
        ad.a(context).addEventListener(com.baidu.mobads.container.components.k.b.F, this.k);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.j != null) {
            this.j.e();
        }
        if (this.d != null && this.k != null) {
            ad.a(this.d.getApplicationContext()).b();
            this.k = null;
            this.j = null;
            this.d = null;
        }
    }
}
