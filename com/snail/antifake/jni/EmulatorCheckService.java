package com.snail.antifake.jni;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.snail.antifake.IEmulatorCheck;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EmulatorCheckService extends Service {
    Handler mHandler = new Handler();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new IEmulatorCheck.Stub() { // from class: com.snail.antifake.jni.EmulatorCheckService.1
            @Override // com.snail.antifake.IEmulatorCheck
            public boolean isEmulator() throws RemoteException {
                return EmulatorDetectUtil.isEmulator(EmulatorCheckService.this);
            }

            @Override // com.snail.antifake.IEmulatorCheck
            public void kill() throws RemoteException {
                EmulatorCheckService.this.stopSelf();
                EmulatorCheckService.this.mHandler.postDelayed(new Runnable() { // from class: com.snail.antifake.jni.EmulatorCheckService.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        System.exit(0);
                    }
                }, 500L);
            }
        };
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());
    }
}
