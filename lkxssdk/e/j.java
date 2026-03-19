package lkxssdk.e;

import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bi;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class j extends Thread {
    public final /* synthetic */ long a;
    public final /* synthetic */ k b;

    public j(k kVar, long j) {
        this.b = kVar;
        this.a = j;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        k kVar = this.b;
        long j = this.a;
        kVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        a aVar = new a();
        aVar.b = "全部";
        aVar.c = new ArrayList<>();
        arrayList.add(aVar);
        Cursor cursorQuery = kVar.d.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, k.a, null, null, "date_added DESC");
        if (cursorQuery != null) {
            lkxssdk.h0.c.c("getAlbum pic cursor.size==" + cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                if (!TextUtils.isEmpty(string)) {
                    String lowerCase = string.toLowerCase(Locale.getDefault());
                    if (lowerCase.endsWith("jpg") || lowerCase.endsWith("jpeg") || lowerCase.endsWith("png") || lowerCase.endsWith("webp")) {
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                        if (!TextUtils.isEmpty(string2)) {
                            if (!string2.contains(bi.j)) {
                                long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_added"));
                                if (j2 >= j) {
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                                    if (TextUtils.isEmpty(string3)) {
                                        string3 = "sdcard";
                                    }
                                    int i = cursorQuery.getInt(cursorQuery.getColumnIndex("orientation"));
                                    long j3 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_modified"));
                                    e eVar = new e();
                                    eVar.b = string2;
                                    eVar.a = string3;
                                    eVar.e = 1;
                                    eVar.g = i;
                                    eVar.c = j2;
                                    eVar.d = j3;
                                    aVar.c.add(eVar);
                                }
                            }
                        }
                    }
                }
            }
            cursorQuery.close();
        }
        lkxssdk.h0.c.b("get piclist filter take time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        kVar.l = arrayList;
        lkxssdk.i0.b.a().a(25, 1, 0, null);
    }
}
