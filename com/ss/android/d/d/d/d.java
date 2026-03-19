package com.ss.android.d.d.d;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.d.d.b.b;
import com.ss.android.d.d.hc.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements k {
    @Override // com.ss.android.d.d.hc.k
    public void d(int i, Context context, b bVar, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.d.d.hc.k
    public Dialog hc(com.ss.android.d.d.u.b bVar) {
        return d(bVar);
    }

    private static Dialog d(final com.ss.android.d.d.u.b bVar) {
        if (bVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(bVar.d).setTitle(bVar.hc).setMessage(bVar.b).setPositiveButton(bVar.c, new DialogInterface.OnClickListener() { // from class: com.ss.android.d.d.d.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (bVar.gb != null) {
                    bVar.gb.d(dialogInterface);
                }
            }
        }).setNegativeButton(bVar.u, new DialogInterface.OnClickListener() { // from class: com.ss.android.d.d.d.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (bVar.gb != null) {
                    bVar.gb.hc(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(bVar.an);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.d.d.d.d.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (bVar.gb != null) {
                    bVar.gb.b(dialogInterface);
                }
            }
        });
        if (bVar.h != null) {
            alertDialogShow.setIcon(bVar.h);
        }
        return alertDialogShow;
    }
}
