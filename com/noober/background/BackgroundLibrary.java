package com.noober.background;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.LayoutInflaterCompat;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BackgroundLibrary {
    public static LayoutInflater inject(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom;
        if (context instanceof Activity) {
            layoutInflaterFrom = ((Activity) context).getLayoutInflater();
        } else {
            layoutInflaterFrom = LayoutInflater.from(context);
        }
        if (layoutInflaterFrom == null) {
            return null;
        }
        if (layoutInflaterFrom.getFactory2() == null) {
            layoutInflaterFrom.setFactory2(setDelegateFactory(context));
        } else if (!(layoutInflaterFrom.getFactory2() instanceof BackgroundFactory)) {
            forceSetFactory2(layoutInflaterFrom);
        }
        return layoutInflaterFrom;
    }

    private static BackgroundFactory setDelegateFactory(Context context) {
        BackgroundFactory backgroundFactory = new BackgroundFactory();
        if (context instanceof AppCompatActivity) {
            final AppCompatDelegate delegate = ((AppCompatActivity) context).getDelegate();
            backgroundFactory.setInterceptFactory(new LayoutInflater.Factory() { // from class: com.noober.background.BackgroundLibrary.1
                @Override // android.view.LayoutInflater.Factory
                public View onCreateView(String str, Context context2, AttributeSet attributeSet) {
                    return delegate.createView(null, str, context2, attributeSet);
                }
            });
        }
        return backgroundFactory;
    }

    public static LayoutInflater inject2(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom;
        if (context instanceof Activity) {
            layoutInflaterFrom = ((Activity) context).getLayoutInflater();
        } else {
            layoutInflaterFrom = LayoutInflater.from(context);
        }
        if (layoutInflaterFrom == null) {
            return null;
        }
        forceSetFactory2(layoutInflaterFrom);
        return layoutInflaterFrom;
    }

    private static void forceSetFactory2(LayoutInflater layoutInflater) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = LayoutInflaterCompat.class.getDeclaredField("sCheckedField");
            declaredField.setAccessible(true);
            declaredField.setBoolean(LayoutInflaterCompat.class, false);
            Field declaredField2 = LayoutInflater.class.getDeclaredField("mFactory");
            declaredField2.setAccessible(true);
            Field declaredField3 = LayoutInflater.class.getDeclaredField("mFactory2");
            declaredField3.setAccessible(true);
            BackgroundFactory backgroundFactory = new BackgroundFactory();
            if (layoutInflater.getFactory2() != null) {
                backgroundFactory.setInterceptFactory2(layoutInflater.getFactory2());
            } else if (layoutInflater.getFactory() != null) {
                backgroundFactory.setInterceptFactory(layoutInflater.getFactory());
            }
            declaredField3.set(layoutInflater, backgroundFactory);
            declaredField2.set(layoutInflater, backgroundFactory);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
