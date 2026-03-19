package com.duoyou.task.sdk.xutils.config;

import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.ex.DbException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum DbConfigs {
    HTTP(new DbManager.DaoConfig().setDbName("xUtils_http_cache.db").setDbVersion(2).setDbOpenListener(new DbManager.DbOpenListener() { // from class: com.duoyou.task.sdk.xutils.config.DbConfigs.2
        @Override // com.duoyou.task.sdk.xutils.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }).setDbUpgradeListener(new DbManager.DbUpgradeListener() { // from class: com.duoyou.task.sdk.xutils.config.DbConfigs.1
        @Override // com.duoyou.task.sdk.xutils.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    })),
    COOKIE(new DbManager.DaoConfig().setDbName("xUtils_http_cookie.db").setDbVersion(1).setDbOpenListener(new DbManager.DbOpenListener() { // from class: com.duoyou.task.sdk.xutils.config.DbConfigs.4
        @Override // com.duoyou.task.sdk.xutils.DbManager.DbOpenListener
        public void onDbOpened(DbManager dbManager) {
            dbManager.getDatabase().enableWriteAheadLogging();
        }
    }).setDbUpgradeListener(new DbManager.DbUpgradeListener() { // from class: com.duoyou.task.sdk.xutils.config.DbConfigs.3
        @Override // com.duoyou.task.sdk.xutils.DbManager.DbUpgradeListener
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    }));

    private DbManager.DaoConfig config;

    DbConfigs(DbManager.DaoConfig daoConfig) {
        this.config = daoConfig;
    }

    public DbManager.DaoConfig getConfig() {
        return this.config;
    }
}
