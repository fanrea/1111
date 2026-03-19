package lkxssdk.h0;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public String a;
    public ExecutorService b;

    public a() {
        try {
            this.a = lkxssdk.a.a.d().getExternalFilesDir("lklib").getAbsolutePath() + File.separator + com.baidu.mobads.container.components.j.a.b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = Executors.newSingleThreadExecutor();
    }
}
