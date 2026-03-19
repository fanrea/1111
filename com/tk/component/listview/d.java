package com.tk.component.listview;

import android.support.v7.widget.al;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    public static void d(al alVar, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = al.class.getDeclaredField("tx");
            declaredField.setAccessible(true);
            declaredField.set(alVar, 4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void p(al alVar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            int scaledMaximumFlingVelocity = ViewConfiguration.get(alVar.getContext()).getScaledMaximumFlingVelocity();
            Field declaredField = al.class.getDeclaredField("tx");
            declaredField.setAccessible(true);
            declaredField.set(alVar, Integer.valueOf(scaledMaximumFlingVelocity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
