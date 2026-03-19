package com.bytedance.apm.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LooperPrinterUtils {
    private static final int DEFAULT_MAX_COUNT = 5;
    private static boolean isInit = false;
    private static int mMaxCount = 5;
    private static PrinterListener sListener;
    private static Printer sOriginPrinter;
    private static PrinterWrapper sPrinterWrapper;

    public interface PrinterListener {
        void onDuration(long j);
    }

    private LooperPrinterUtils() {
    }

    static class PrinterWrapper implements Printer {
        private static final char END = '<';
        private static final char START = '>';
        List<Printer> mPrinters = new ArrayList();
        List<Printer> mRemovePrinters = new ArrayList();
        List<Printer> mAddPrinters = new ArrayList();
        boolean haveRemove = false;
        boolean haveAdd = false;

        PrinterWrapper() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long jCurrentTimeMillis = LooperPrinterUtils.sListener != null ? System.currentTimeMillis() : 0L;
            if (str.charAt(0) == '>' && this.haveAdd) {
                for (Printer printer : this.mAddPrinters) {
                    if (!this.mPrinters.contains(printer)) {
                        this.mPrinters.add(printer);
                    }
                }
                this.mAddPrinters.clear();
                this.haveAdd = false;
            }
            if (this.mPrinters.size() > LooperPrinterUtils.mMaxCount) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : this.mPrinters) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            if (str.charAt(0) == '<' && this.haveRemove) {
                for (Printer printer3 : this.mRemovePrinters) {
                    this.mPrinters.remove(printer3);
                    this.mAddPrinters.remove(printer3);
                }
                this.mRemovePrinters.clear();
                this.haveRemove = false;
            }
            if (LooperPrinterUtils.sListener == null || jCurrentTimeMillis <= 0) {
                return;
            }
            LooperPrinterUtils.sListener.onDuration(System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }

    public static void init() throws NoSuchFieldException {
        if (isInit) {
            return;
        }
        isInit = true;
        sPrinterWrapper = new PrinterWrapper();
        Printer currentPrinter = getCurrentPrinter();
        sOriginPrinter = currentPrinter;
        if (currentPrinter != null) {
            sPrinterWrapper.mPrinters.add(sOriginPrinter);
        }
        Looper.getMainLooper().setMessageLogging(sPrinterWrapper);
    }

    public static void release() {
        if (isInit) {
            isInit = false;
            Looper.getMainLooper().setMessageLogging(sOriginPrinter);
            sPrinterWrapper = null;
        }
    }

    public static void addMessageLogging(Printer printer) {
        if (printer == null || sPrinterWrapper.mAddPrinters.contains(printer)) {
            return;
        }
        sPrinterWrapper.mAddPrinters.add(printer);
        sPrinterWrapper.haveAdd = true;
    }

    public static void removeMessageLogging(Printer printer) {
        if (printer == null || sPrinterWrapper.mRemovePrinters.contains(printer)) {
            return;
        }
        sPrinterWrapper.mRemovePrinters.add(printer);
        sPrinterWrapper.haveRemove = true;
    }

    private static Printer getCurrentPrinter() throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setMaxCount(int i) {
        mMaxCount = i;
    }
}
