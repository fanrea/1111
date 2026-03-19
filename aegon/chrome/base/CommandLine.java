package aegon.chrome.base;

import android.text.TextUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    private static final String TAG = "CommandLine";
    private static final AtomicReference<CommandLine> sCommandLine = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchWithValue(String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String nativeGetSwitchValue(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeHasSwitch(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInit(String[] strArr);

    public abstract void appendSwitch(String str);

    public abstract void appendSwitchWithValue(String str, String str2);

    public abstract void appendSwitchesAndArguments(String[] strArr);

    protected void destroy() {
    }

    protected abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String str);

    public abstract boolean hasSwitch(String str);

    public boolean isNativeImplementation() {
        return false;
    }

    public String getSwitchValue(String str, String str2) {
        String switchValue = getSwitchValue(str);
        return TextUtils.isEmpty(switchValue) ? str2 : switchValue;
    }

    public static boolean isInitialized() {
        return sCommandLine.get() != null;
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    public static void init(String[] strArr) {
        setInstance(new JavaCommandLine(strArr));
    }

    public static void initFromFile(String str) {
        char[] fileAsUtf8 = readFileAsUtf8(str);
        init(fileAsUtf8 == null ? null : tokenizeQuotedArguments(fileAsUtf8));
    }

    public static void reset() {
        setInstance(null);
    }

    static String[] tokenizeQuotedArguments(char[] cArr) {
        if (cArr.length > 65536) {
            throw new RuntimeException("Flags file too big: " + cArr.length);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = null;
        char c = 0;
        for (char c2 : cArr) {
            if ((c == 0 && (c2 == '\'' || c2 == '\"')) || c2 == c) {
                if (sb == null || sb.length() <= 0 || sb.charAt(sb.length() - 1) != '\\') {
                    c = c == 0 ? c2 : (char) 0;
                } else {
                    sb.setCharAt(sb.length() - 1, c2);
                }
            } else if (c != 0 || !Character.isWhitespace(c2)) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(c2);
            } else if (sb != null) {
                arrayList.add(sb.toString());
                sb = null;
            }
        }
        if (sb != null) {
            if (c != 0) {
                android.util.Log.w(TAG, "Unterminated quoted string: " + ((Object) sb));
            }
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static String[] getJavaSwitchesOrNull() {
        CommandLine commandLine = sCommandLine.get();
        if (commandLine != null) {
            return commandLine.getCommandLineArguments();
        }
        return null;
    }

    private static void setInstance(CommandLine commandLine) {
        CommandLine andSet = sCommandLine.getAndSet(commandLine);
        if (andSet != null) {
            andSet.destroy();
        }
    }

    private static char[] readFileAsUtf8(String str) {
        File file = new File(str);
        try {
            FileReader fileReader = new FileReader(file);
            try {
                char[] cArr = new char[(int) file.length()];
                char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, 0, fileReader.read(cArr));
                fileReader.close();
                return cArrCopyOfRange;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private CommandLine() {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class JavaCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        private HashMap<String, String> mSwitches;

        JavaCommandLine(String[] strArr) {
            String str;
            super();
            this.mSwitches = new HashMap<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.mArgs = arrayList;
            this.mArgsBegin = 1;
            if (strArr == null || strArr.length == 0 || (str = strArr[0]) == null) {
                arrayList.add("");
            } else {
                arrayList.add(str);
                appendSwitchesInternal(strArr, 1);
            }
        }

        @Override // aegon.chrome.base.CommandLine
        protected String[] getCommandLineArguments() {
            ArrayList<String> arrayList = this.mArgs;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        @Override // aegon.chrome.base.CommandLine
        public boolean hasSwitch(String str) {
            return this.mSwitches.containsKey(str);
        }

        @Override // aegon.chrome.base.CommandLine
        public String getSwitchValue(String str) {
            String str2 = this.mSwitches.get(str);
            if (str2 == null || str2.isEmpty()) {
                return null;
            }
            return str2;
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitch(String str) {
            appendSwitchWithValue(str, null);
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitchWithValue(String str, String str2) {
            this.mSwitches.put(str, str2 == null ? "" : str2);
            String str3 = "--" + str;
            if (str2 != null && !str2.isEmpty()) {
                str3 = str3 + CommandLine.SWITCH_VALUE_SEPARATOR + str2;
            }
            ArrayList<String> arrayList = this.mArgs;
            int i = this.mArgsBegin;
            this.mArgsBegin = i + 1;
            arrayList.add(i, str3);
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitchesAndArguments(String[] strArr) {
            appendSwitchesInternal(strArr, 0);
        }

        private void appendSwitchesInternal(String[] strArr, int i) {
            boolean z = true;
            for (String str : strArr) {
                if (i > 0) {
                    i--;
                } else {
                    if (str.equals("--")) {
                        z = false;
                    }
                    if (z && str.startsWith("--")) {
                        String[] strArrSplit = str.split(CommandLine.SWITCH_VALUE_SEPARATOR, 2);
                        appendSwitchWithValue(strArrSplit[0].substring(2), strArrSplit.length > 1 ? strArrSplit[1] : null);
                    } else {
                        this.mArgs.add(str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // aegon.chrome.base.CommandLine
        protected String[] getCommandLineArguments() {
            return null;
        }

        @Override // aegon.chrome.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        public NativeCommandLine(String[] strArr) {
            super();
            CommandLine.nativeInit(strArr);
        }

        @Override // aegon.chrome.base.CommandLine
        public boolean hasSwitch(String str) {
            return CommandLine.nativeHasSwitch(str);
        }

        @Override // aegon.chrome.base.CommandLine
        public String getSwitchValue(String str) {
            return CommandLine.nativeGetSwitchValue(str);
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitch(String str) {
            CommandLine.nativeAppendSwitch(str);
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitchWithValue(String str, String str2) {
            CommandLine.nativeAppendSwitchWithValue(str, str2);
        }

        @Override // aegon.chrome.base.CommandLine
        public void appendSwitchesAndArguments(String[] strArr) {
            CommandLine.nativeAppendSwitchesAndArguments(strArr);
        }

        @Override // aegon.chrome.base.CommandLine
        protected void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }
    }
}
