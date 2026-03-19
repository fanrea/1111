package android.support.v7.widget;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v7.a.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class at {
    public PorterDuff.Mode aB;
    public ColorStateList ay;
    public boolean fD;
    public boolean fE;

    at() {
    }

    final void clear() {
        this.ay = null;
        this.fD = false;
        this.aB = null;
        this.fE = false;
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    static final class a {
        public final TextView ys;
        public final TextView yt;
        public final ImageView yu;
        public final ImageView yv;
        public final ImageView yw;

        public a(View view) {
            this.ys = (TextView) view.findViewById(R.id.text1);
            this.yt = (TextView) view.findViewById(R.id.text2);
            this.yu = (ImageView) view.findViewById(R.id.icon1);
            this.yv = (ImageView) view.findViewById(R.id.icon2);
            this.yw = (ImageView) view.findViewById(a.f.edit_query);
        }
    }
}
