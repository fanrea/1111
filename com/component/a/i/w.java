package com.component.a.i;

import android.view.View;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.x;
import com.component.interfaces.RemoteDelegator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w extends RemoteDelegator<Object> {
    private static final String a = "ViewCompat";
    private static final String b = "generateViewId";

    public w(com.baidu.mobads.container.adrequest.i iVar) {
        super("ViewCompat", iVar, new Object[0]);
        super.addEvent(b, new Class[0]);
    }

    @Override // com.component.interfaces.RemoteDelegator
    protected Object transformInstance(Object obj) {
        return obj;
    }

    public int a() {
        Object objDispatch = dispatch(b, new Object[0]);
        if (objDispatch instanceof Integer) {
            return ((Integer) objDispatch).intValue();
        }
        return cf.a();
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        if (x.a(view.getContext()).a() >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }
}
