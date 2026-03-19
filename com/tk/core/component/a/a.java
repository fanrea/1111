package com.tk.core.component.a;

import com.baidu.mobads.container.util.animation.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static List<String> abH;

    public static List<String> qH() {
        List<String> list = abH;
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            abH = arrayList;
            arrayList.add("translationX");
            abH.add("translationY");
            abH.add("translationZ");
            abH.add("scaleX");
            abH.add("scaleY");
            abH.add("rotationX");
            abH.add("rotationY");
            abH.add("rotation");
            abH.add("width");
            abH.add("height");
            abH.add(j.d);
            abH.add(j.f);
            abH.add("margin");
            abH.add("marginLeft");
            abH.add("marginRight");
            abH.add("marginTop");
            abH.add("marginBottom");
            abH.add("padding");
            abH.add("paddingLeft");
            abH.add("paddingRight");
            abH.add("paddingTop");
            abH.add("paddingBottom");
            abH.add("paddingStart");
            abH.add("paddingEnd");
            abH.add("paddingHorizontal");
            abH.add("paddingVertical");
            abH.add("alpha");
            abH.add(com.baidu.mobads.container.n.f.T);
        }
        return abH;
    }
}
