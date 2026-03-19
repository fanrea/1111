package com.lingku.xuanshang.xutils.config;

import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.ex.DbException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum DbConfigs {
    HTTP(new DbManager.DaoConfig().setDbName("xUtils_http_cache.db").setDbVersion(2).setDbOpenListener(new DbManager.DbOpenListener() { // from class: com.lingku.xuanshang.xutils.config.DbConfigs.b
        @Override // com.lingku.xuanshang.xutils.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }).setDbUpgradeListener(new DbManager.DbUpgradeListener() { // from class: com.lingku.xuanshang.xutils.config.DbConfigs.a
        @Override // com.lingku.xuanshang.xutils.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    })),
    COOKIE(new DbManager.DaoConfig().setDbName("xUtils_http_cookie.db").setDbVersion(1).setDbOpenListener(new DbManager.DbOpenListener() { // from class: com.lingku.xuanshang.xutils.config.DbConfigs.d
        @Override // com.lingku.xuanshang.xutils.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }).setDbUpgradeListener(new DbManager.DbUpgradeListener() { // from class: com.lingku.xuanshang.xutils.config.DbConfigs.c
        @Override // com.lingku.xuanshang.xutils.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    }));

    public DbManager.DaoConfig b;

    DbConfigs(DbManager.DaoConfig daoConfig) {
        this.b = daoConfig;
    }

    public DbManager.DaoConfig getConfig() {
        return this.b;
    }
}
