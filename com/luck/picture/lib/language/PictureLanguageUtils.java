package com.luck.picture.lib.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.baidu.mobads.container.o.j;
import com.luck.picture.lib.utils.SpUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureLanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private PictureLanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setAppLanguage(Context context, int i, int i2) {
        WeakReference weakReference = new WeakReference(context);
        if (i >= 0) {
            applyLanguage((Context) weakReference.get(), LocaleTransform.getLanguage(i));
        } else if (i2 >= 0) {
            applyLanguage((Context) weakReference.get(), LocaleTransform.getLanguage(i2));
        } else {
            setDefaultLanguage((Context) weakReference.get());
        }
    }

    private static void applyLanguage(Context context, Locale locale) {
        applyLanguage(context, locale, false);
    }

    private static void applyLanguage(Context context, Locale locale, boolean z) {
        if (z) {
            SpUtils.putString(context, KEY_LOCALE, VALUE_FOLLOW_SYSTEM);
        } else {
            SpUtils.putString(context, KEY_LOCALE, locale.getLanguage() + j.a + locale.getCountry());
        }
        updateLanguage(context, locale);
    }

    private static void updateLanguage(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale2 = configuration.locale;
        if (equals(locale2.getLanguage(), locale.getLanguage()) && equals(locale2.getCountry(), locale.getCountry())) {
            return;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(locale);
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void setDefaultLanguage(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(Locale.getDefault());
        context.createConfigurationContext(configuration);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
