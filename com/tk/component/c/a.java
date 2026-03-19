package com.tk.component.c;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.framework.tachikoma.a;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaJustify;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.component.view.TKView;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import com.tkruntime.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private static Boolean PH;
    private AlertDialog PI;
    private final List<V8Value> PJ;
    private JsValueRef<V8Function> PK;
    private JsValueRef<V8Function> PL;
    private boolean PM;
    private TKView PN;
    public boolean PO;
    public boolean PP;
    public String PQ;
    public V8Function PR;
    public V8Function PS;
    public String PT;
    private final Context mContext;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.PM = false;
        this.PO = true;
        this.PP = true;
        this.PT = "none";
        if (Looper.getMainLooper() != Looper.myLooper()) {
            com.tk.core.exception.a.a(pO(), new Throwable("create Dialog on subThread"));
        }
        this.mContext = getContext();
        this.PJ = new ArrayList();
    }

    public final void ap(String str) {
        AlertDialog alertDialog;
        this.PQ = str;
        if (TextUtils.isEmpty(str) || !this.PM || (alertDialog = this.PI) == null || alertDialog.getWindow() == null) {
            return;
        }
        this.PI.getWindow().setBackgroundDrawable(new ColorDrawable(r.parseColor(str)));
    }

    public final void P(V8Function v8Function) {
        V8Proxy.unRetainJsValue(this.PK);
        this.PK = V8Proxy.retainJsValue(v8Function, this);
    }

    public final void Q(V8Function v8Function) {
        V8Proxy.unRetainJsValue(this.PL);
        this.PL = V8Proxy.retainJsValue(v8Function, this);
        this.PS = v8Function;
    }

    public final Object b(String str, String str2, V8Function v8Function) {
        this.PM = false;
        final JsValueRef jsValueRefRetainJsValue = V8Proxy.retainJsValue(v8Function, this);
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mContext.getString(R.string.ok);
        }
        this.PI = new AlertDialog.Builder(mQ()).setCancelable(this.PO).setMessage(str).setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.tk.component.c.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                JsValueRef jsValueRef = jsValueRefRetainJsValue;
                if (jsValueRef == null || jsValueRef.get() == null) {
                    return;
                }
                try {
                    ((V8Function) jsValueRefRetainJsValue.get()).call(null, new Object[0]);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tk.component.c.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (a.this.PK != null && V8Proxy.isV8Valid((V8Object) a.this.PK.get())) {
                        ((V8Function) a.this.PK.get()).call(null, new Object[0]);
                    }
                    V8Proxy.unRetainJsValue(jsValueRefRetainJsValue);
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        }).create();
        this.PI.show();
        this.PI.getButton(-1).setTextColor(-16777216);
        return null;
    }

    public final Object a(String str, String str2, String str3, String str4, V8Function v8Function, V8Function v8Function2) {
        this.PM = false;
        final JsValueRef jsValueRefRetainJsValue = V8Proxy.retainJsValue(v8Function, this);
        final JsValueRef jsValueRefRetainJsValue2 = V8Proxy.retainJsValue(v8Function2, this);
        if (TextUtils.isEmpty(str3)) {
            str3 = this.mContext.getString(R.string.ok);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = this.mContext.getString(R.string.cancel);
        }
        this.PI = new AlertDialog.Builder(mQ()).setCancelable(this.PO).setTitle(str).setMessage(str2).setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.tk.component.c.a.5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (jsValueRefRetainJsValue != null && jsValueRefRetainJsValue.get() != null) {
                        ((V8Function) jsValueRefRetainJsValue.get()).call(null, new Object[0]);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }).setNegativeButton(str4, new DialogInterface.OnClickListener() { // from class: com.tk.component.c.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (jsValueRefRetainJsValue2 != null && jsValueRefRetainJsValue2.get() != null) {
                        ((V8Function) jsValueRefRetainJsValue2.get()).call(null, new Object[0]);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tk.component.c.a.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (a.this.PK != null && V8Proxy.isV8Valid((V8Object) a.this.PK.get())) {
                        ((V8Function) a.this.PK.get()).call(null, new Object[0]);
                    }
                    V8Proxy.unRetainJsValue(jsValueRefRetainJsValue);
                    V8Proxy.unRetainJsValue(jsValueRefRetainJsValue2);
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        }).create();
        this.PI.show();
        this.PI.getButton(-1).setTextColor(-16777216);
        this.PI.getButton(-2).setTextColor(-7829368);
        return null;
    }

    public final Object s(V8Object v8Object) {
        boolean zIsDestroyed;
        this.PM = true;
        e eVar = (e) getNativeModule(v8Object);
        if (eVar == null || eVar.getView() == null) {
            com.tk.core.i.a.a("Dialog", "Dialog customView is illegal", null);
            return null;
        }
        final V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(pP().pi(), "Dialog-customContainer");
        this.PJ.add(v8ObjectProxy);
        this.PN = new TKView(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        v8ObjectProxy.setNativeObject(this.PN);
        this.PN.pR().getYogaNode().setJustifyContent(YogaJustify.CENTER);
        this.PN.pR().getYogaNode().setAlignItems(YogaAlign.CENTER);
        this.PN.pR().getYogaNode().setWidth(o.getDisplayMetrics().widthPixels);
        this.PN.pR().getYogaNode().setHeight(o.getDisplayMetrics().heightPixels);
        this.PN.aC(true);
        this.PN.getView().setInDialog(true);
        this.PN.aq(this.PT);
        this.PN.d(v8Object);
        this.PI = new AlertDialog.Builder(mQ(), a.d.TransparentDialog).setCancelable(this.PO).setView(this.PN.getView()).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tk.component.c.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (a.this.pN()) {
                    return;
                }
                try {
                    if (a.this.PK != null && V8Proxy.isV8Valid((V8Object) a.this.PK.get())) {
                        ((V8Function) a.this.PK.get()).call(null, new Object[0]);
                    }
                    a.this.PN.removeAll();
                    if (a.this.PJ.remove(v8ObjectProxy)) {
                        v8ObjectProxy.setWeak();
                    }
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(a.this.pO(), th);
                }
            }
        }).create();
        try {
            this.PI.show();
            if (this.PI.getWindow() != null) {
                if (mP()) {
                    this.PI.getWindow().clearFlags(131080);
                }
                if (!this.PP) {
                    this.PI.getWindow().setDimAmount(0.0f);
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    this.PI.getWindow().addFlags(67108864);
                }
                WindowManager.LayoutParams attributes = this.PI.getWindow().getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                this.PI.getWindow().setAttributes(attributes);
                if (!TextUtils.isEmpty(this.PQ)) {
                    this.PI.getWindow().setBackgroundDrawable(new ColorDrawable(r.parseColor(this.PQ)));
                }
            }
            if (!eVar.getView().hasOnClickListeners()) {
                eVar.getView().setOnClickListener(null);
            }
            this.PN.getView().setOnClickListener(new View.OnClickListener() { // from class: com.tk.component.c.a.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        if (a.this.PL != null && V8Proxy.isV8Valid((V8Object) a.this.PL.get())) {
                            ((V8Function) a.this.PL.get()).call(null, new Object[0]);
                        }
                    } catch (Throwable th) {
                        com.tk.core.exception.a.a(a.this.pO(), th);
                    }
                    if (a.this.PO) {
                        a.this.PI.dismiss();
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            Context context = this.mContext;
            boolean z = context instanceof Activity;
            boolean zIsFinishing = false;
            if (z) {
                zIsFinishing = ((Activity) context).isFinishing();
                zIsDestroyed = ((Activity) this.mContext).isDestroyed();
            } else {
                zIsDestroyed = false;
            }
            com.tk.core.exception.a.a(pO(), new RuntimeException("context is Activity: " + z + ",isActivityFinishing: " + zIsFinishing + ",isActivityDestroy:" + zIsDestroyed + ",isContainerDestroy:" + pN(), th));
            return null;
        }
    }

    public final Object mO() {
        AlertDialog alertDialog = this.PI;
        if (alertDialog == null) {
            return null;
        }
        alertDialog.dismiss();
        return null;
    }

    public final void aq(String str) {
        this.PT = str;
        TKView tKView = this.PN;
        if (tKView != null) {
            tKView.aq(str);
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        V8Proxy.unRetainJsValue(this.PK);
        V8Proxy.unRetainJsValue(this.PL);
        for (V8Value v8Value : this.PJ) {
            if (v8Value != null) {
                v8Value.setWeak();
            }
        }
        this.PJ.clear();
    }

    private static boolean mP() {
        if (PH == null && com.tk.core.a.oP().getTKSwitch() != null) {
            PH = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
        }
        Boolean bool = PH;
        return bool != null && bool.booleanValue();
    }

    private Context mQ() {
        Activity currentActivity;
        return ((this.mContext instanceof Activity) || (currentActivity = com.tk.core.a.oP().getCommonParams().getCurrentActivity()) == null) ? this.mContext : currentActivity;
    }
}
