package com.tencent.turingfd.sdk.ams.au;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Lyra {
    public static Lacerta a(Context context) {
        Lacerta lacerta = Lacerta.b;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            Object systemService = context.getSystemService("locale");
            return systemService != null ? new Lacerta(new Lynx(((LocaleManager) systemService).getSystemLocales())) : lacerta;
        }
        Configuration configuration = Resources.getSystem().getConfiguration();
        return i >= 24 ? Lacerta.a(configuration.getLocales().toLanguageTags()) : i >= 21 ? Lacerta.a(configuration.locale.toLanguageTag()) : Lacerta.a(configuration.locale);
    }
}
