package lkxssdk.i0;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b implements Handler.Callback {
    public static b a;
    public Handler c = new Handler(this);
    public List<a> b = new ArrayList();

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public void a(int i, int i2, int i3, Object obj) {
        Message message = new Message();
        message.what = i;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = obj;
        this.c.sendMessage(message);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        List<a> list = this.b;
        if (list == null) {
            return true;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).a(message.what, message.arg1, message.arg2, message.obj);
        }
        return true;
    }
}
