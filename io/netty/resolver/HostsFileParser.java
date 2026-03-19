package io.netty.resolver;

import com.sigmob.sdk.base.n;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class HostsFileParser {
    private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
    private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
    private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HostsFileParser.class);

    private static File locateHostsFile() {
        if (PlatformDependent.isWindows()) {
            File file = new File(System.getenv("SystemRoot") + WINDOWS_HOSTS_FILE_RELATIVE_PATH);
            return !file.exists() ? new File("C:\\Windows\\system32\\drivers\\etc\\hosts") : file;
        }
        return new File(X_PLATFORMS_HOSTS_FILE_PATH);
    }

    public static Map<String, InetAddress> parseSilently() {
        File fileLocateHostsFile = locateHostsFile();
        try {
            return parse(fileLocateHostsFile);
        } catch (IOException e) {
            logger.warn("Failed to load and parse hosts file at " + fileLocateHostsFile.getPath(), (Throwable) e);
            return Collections.emptyMap();
        }
    }

    public static Map<String, InetAddress> parse() {
        return parse(locateHostsFile());
    }

    public static Map<String, InetAddress> parse(File file) {
        ObjectUtil.checkNotNull(file, n.z);
        if (file.exists() && file.isFile()) {
            return parse(new BufferedReader(new FileReader(file)));
        }
        return Collections.emptyMap();
    }

    public static Map<String, InetAddress> parse(Reader reader) throws IOException {
        byte[] bArrCreateByteArrayFromIpAddressString;
        ObjectUtil.checkNotNull(reader, "reader");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            HashMap map = new HashMap();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return map;
                }
                int iIndexOf = line.indexOf(35);
                if (iIndexOf != -1) {
                    line = line.substring(0, iIndexOf);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : strTrim.split("[ \t]+")) {
                        if (!str.isEmpty()) {
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() >= 2 && (bArrCreateByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString((String) arrayList.get(0))) != null) {
                        InetAddress byAddress = InetAddress.getByAddress(bArrCreateByteArrayFromIpAddressString);
                        for (int i = 1; i < arrayList.size(); i++) {
                            String str2 = (String) arrayList.get(i);
                            if (!map.containsKey(str2)) {
                                map.put(str2, byAddress);
                            }
                        }
                    }
                }
            }
        } finally {
            bufferedReader.close();
        }
    }

    private HostsFileParser() {
    }
}
