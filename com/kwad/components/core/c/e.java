package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e implements i {
    private static volatile e Pt;
    private String Pu;
    private int Pv = 0;
    private int Pw = 1;
    private long Px = 1800;
    private boolean enable = false;

    public static e av(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j = adTemplate.posId;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        e eVar = new e(j);
        eVar.Pv = adInfoEP.adBaseInfo.adCacheStrategy;
        eVar.Px = adInfoEP.adBaseInfo.adCacheSecond;
        eVar.Pw = adInfoEP.adBaseInfo.adCacheSize;
        eVar.enable = adInfoEP.adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    public static synchronized List<e> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(b(cursor));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return arrayList;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        String string = cursor.getString(cursor.getColumnIndex("posId"));
        int i = cursor.getInt(cursor.getColumnIndex("strategyCode"));
        int i2 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
        long j = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
        boolean z = true;
        if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
            z = false;
        }
        eVar = new e();
        eVar.Pu = string;
        eVar.Pv = i;
        eVar.Pw = i2;
        eVar.Px = j;
        eVar.enable = z;
        return eVar;
    }

    private static e on() {
        if (Pt == null) {
            synchronized (e.class) {
                if (Pt == null) {
                    Pt = new e();
                }
            }
        }
        return Pt;
    }

    public static e x(long j) {
        e eVarAi;
        return (a.oh() == null || (eVarAi = a.oh().ai(String.valueOf(j))) == null) ? on() : eVarAi;
    }

    private e() {
    }

    private e(long j) {
        this.Pu = String.valueOf(j);
    }

    public final String oo() {
        return this.Pu;
    }

    public final int op() {
        return this.Pv;
    }

    public final int oq() {
        return this.Pw;
    }

    public final long or() {
        return this.Px;
    }

    public final boolean isEnable() {
        return this.enable;
    }

    public final boolean isDefault() {
        return equals(on());
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues os() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.Pu);
        contentValues.put("strategyCode", Integer.valueOf(this.Pv));
        contentValues.put("cacheSize", Integer.valueOf(this.Pw));
        contentValues.put("cacheSecond", Long.valueOf(this.Px));
        contentValues.put("enable", Integer.valueOf(this.enable ? 1 : 0));
        return contentValues;
    }
}
