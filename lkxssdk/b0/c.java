package lkxssdk.b0;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c extends RecyclerView.ViewHolder {
    public final SparseArray<View> a;

    public c(View view) {
        super(view);
        this.a = new SparseArray<>();
    }

    public <T extends View> T a(int i) {
        T t = (T) this.a.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.a.put(i, t2);
        return t2;
    }

    public c a(int i, String str) {
        ((TextView) a(i)).setText(str);
        return this;
    }
}
