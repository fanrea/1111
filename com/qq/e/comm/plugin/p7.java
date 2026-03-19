package com.qq.e.comm.plugin;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p7 extends FrameLayout {
    private TextView a;
    private ProgressBar b;
    private ImageView c;
    private ImageView d;

    public p7(Context context) {
        super(context);
        a(context);
    }

    public void a() {
        if (this.b.getVisibility() == 0) {
            this.b.setVisibility(8);
            this.b.setProgress(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    private void a(Context context) {
        this.c = new ImageView(context);
        int iA = yu.a(context, 29);
        int iA2 = yu.a(context, 35);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA2);
        layoutParams.gravity = 19;
        layoutParams.leftMargin = yu.a(context, 7);
        this.c.setLayoutParams(layoutParams);
        int iA3 = (iA2 - yu.a(context, 15)) / 2;
        this.c.setPadding(0, iA3, 0, iA3);
        this.c.setVisibility(4);
        this.c.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAAEEfUpiAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIKADAAQAAAABAAAAIAAAAACshmLzAAACQElEQVRYCdVXP0/jMBS3U3QLQiwsRejWlhbMkCKmWxGsSIidL4IEH4iZBQZggVailNyVheUkGG68SkALMe9FfSZOnNSx1CCy2H7v/f7YtZ2UsfEjxOYs9Vlj1ZdqoGUoKkSrRn2Ltrnq/0+VGYNYpcnHYZkJKPKwcIbzeiZtnAn9N0TrPh7T+s3d3R9aAAaRBAZ936+y+4dBsiAaY7Ip/GHxJCLypqgYp1vElU6igzN7HrJHzvjfoNf+mUirYYpAATkbBbed1MIq5LijCIoCiYjjzyf7D6/cUpGA1EYOcJO8SdmHwSDodeYoadOqKWCxC5FGQIouRITVWljYBSE2lrRgkcHKmr85qX4mq6ApWv0wlDUppcc5/7xrEgB14OJxBAOw5nmVnTwwYlKLGAffda+O48SmvkZQFKw5cAErAldwRAAX4h9Y4joumM2ck+vgAXgeg5K9/0smbcbRIsKd9QjFVe6xX0G3c2EDpBr1K7iSKAJkdCHRCFxIUgRFSYxn4XevswhETzJk53AmjCIoNPFZWWvtTypyYscb/GXITnEDwnujDe+N9UlCWfnM+8QEiIRH/Ox5KKMvFXwTQN2RqdY2ZrUCJIx3FBKjMOeVPZejlzSWa2CawmTEaKAMYaOBMoU1A18hrAzgqzcM2YkKeN5B0L0+pPG022gPjL9EzkCsioIQHMAH8nbRq93FrLYJv8KIZoBmUKYRo4EyjeQaKMOIlYFcIxW+Fdy0L6mmaFvIAJHH9wgQ9OFfxTLlvl37AXeFOzBY4qGXAAAAAElFTkSuQmCC"));
        addView(this.c);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) yu.a(context, 0.67f));
        layoutParams2.gravity = 80;
        view.setLayoutParams(layoutParams2);
        addView(view);
        this.b = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) yu.a(context, 1.34f));
        layoutParams3.gravity = 80;
        this.b.setLayoutParams(layoutParams3);
        this.b.setMax(100);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
        clipDrawable.setLevel(10000);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        this.b.setProgressDrawable(layerDrawable);
        addView(this.b);
        this.a = new TextView(context);
        int iA4 = yu.a(context, 55);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.leftMargin = iA4;
        layoutParams4.rightMargin = iA4;
        this.a.setLayoutParams(layoutParams4);
        this.a.setTextSize(2, 15.33f);
        this.a.setTextColor(Color.parseColor("#ff2a2d33"));
        this.a.setSingleLine();
        this.a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        addView(this.a);
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAAB8AAAAfCAYAAAFoqSavAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAH6ADAAQAAAABAAAAHwAAAABwh9X2AAAC+0lEQVRIDa1XvW/TQBS/56QMwFoxQJH4mJrWUDmUCVTgD+iE2MvHH8DKkokVsbeFuWyIqUNXJJpI4DRZAMGAGECMdKiaHPc7513O57Nju3jo3b33fh/35bhC+J7F5UgivhRFV0yegzrAmVQQmda16I6BtMLob4kBl2TIwKcoIEZchBaFROKQ5kR40Ot9RSzAHzxABKfE1UHcOzM+El+SKBLKGvs2wUlHS4dhdNNN2OPgWNKTxeX2lh1EP2UcBXaRnTSzmBbIjWG/Z+IpZiCnhUnKTBNJRrpFaUPaoOXJNmTrGRasg0/bLnb7WHUmNrNJGOWGELQ97HcfuiCMAZRSnMaW8V4aAgb4iHxArs8QcGJKpE6Mpch5bhvcsVsoqvEqgHJEZ+VIvJo/d/7i718/39p16KccFFmdOkqvkSYoArqKeURuXflxGK5eKl+dVK6s3JrvdDoB8WEYxN2AiPT7pIgMt1OOxR4F4jVJKakVtscAzCIwQKIfqnZBL1wZAhcIMbNtRQQ+YAqMgY8gD5gBuwRqUe7qxZnMEXn7MbbtoO1A7YBeHDvPffNK4QDapevtNR4rogsg47HdZsDOHHUeW+kjSDE6wAWo2FNwz4EB+4BsMY9Ag4uARQRUBphLgItRtB0M5Naawg7HarWE+zwS48+KsaEcbB182n9c5mpWVcPyCCne4bUuiJ4P4+6zZMHD9qYSt34HaHsQ7z/6HyZSosoxlrghgttx/OGbOSrJWt7YVCdL/SjxU9+ET5Tm5Br/kEHBiLPcSU2UEWWtjDgnqpqoIsoaueJcMMtEHVHmninOhT4T6uPyWJ3eJmpwkNw9ZWxeW1qcCSYz3WVRHQ/Em8HH7oOqt6O0uG95Jcn3YizuszE1/0pXdKa4T9ReXt92lDWRKz5LdDrbpFfHREa8quhJTBjxk4rWMUH46DsaHX7XL3zFUOfKuML22LcdJOjpoN99Eayv3/ujpv8SH45NalzGN6D9/rWJ6vRx/fDPi/7+UKKKY6cZ0C64/gH25kow2R+kgwAAAABJRU5ErkJggg=="));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iA, iA2);
        layoutParams5.gravity = 8388629;
        layoutParams5.rightMargin = yu.a(context, 7);
        this.d.setLayoutParams(layoutParams5);
        this.d.setPadding(0, iA3, 0, iA3);
        addView(this.d);
    }

    public void b() {
        if (this.c.getVisibility() != 0) {
            this.c.setVisibility(0);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.c.setClickable(true);
        this.c.setOnClickListener(onClickListener);
    }

    public void b(int i) {
        if (this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
        a(i);
    }

    private void a(int i) {
        ProgressBar progressBar = this.b;
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        progressBar.setProgress(i);
    }

    public void a(String str) {
        this.a.setText(str);
    }
}
