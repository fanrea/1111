package com.component.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private IOAdEventListener a;

    /* renamed from: com.component.b.a$a, reason: collision with other inner class name */
    private static class C0320a {
        public static final a a = new a();

        private C0320a() {
        }
    }

    private a() {
        ICommonModuleObj iCommonModuleObjK = com.baidu.mobads.container.config.b.a().k();
        if (iCommonModuleObjK != null) {
            Object objCreateModuleObj = iCommonModuleObjK.createModuleObj(ICommonModuleObj.KEY_RESOURCES, null);
            if (objCreateModuleObj instanceof IOAdEventListener) {
                this.a = (IOAdEventListener) objCreateModuleObj;
            }
        }
    }

    public static a a() {
        return C0320a.a;
    }

    public Integer a(String str) {
        return a("drawable", str);
    }

    public Bitmap b(String str) {
        Integer numA;
        Context contextC = com.baidu.mobads.container.config.b.a().c();
        if (contextC != null && (numA = a(str)) != null) {
            return BitmapFactory.decodeResource(contextC.getResources(), numA.intValue());
        }
        return null;
    }

    public void a(ImageView imageView, String str) {
        Integer numA;
        if (imageView != null && !TextUtils.isEmpty(str) && (numA = a(str)) != null) {
            imageView.setImageResource(numA.intValue());
        }
    }

    public Integer c(String str) {
        return a("layout", str);
    }

    public Integer d(String str) {
        return a(TypedValues.Custom.S_STRING, str);
    }

    private Integer a(String str, String str2) {
        if (this.a != null) {
            cm cmVar = new cm(str);
            HashMap<String, Object> data = cmVar.getData();
            data.put("name", str2);
            this.a.run(cmVar);
            Object obj = data.get("id");
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            return null;
        }
        return null;
    }
}
