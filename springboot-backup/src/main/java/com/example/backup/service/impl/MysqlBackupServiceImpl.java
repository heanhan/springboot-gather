package com.example.backup.service.impl;

import com.example.backup.service.MysqlBackupService;
import org.springframework.stereotype.Service;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/15 10:33 上午
 * @Version : 1.0
 * @Description :Too
 **/
@Service("mysqlBackupService")
public class MysqlBackupServiceImpl implements MysqlBackupService {

    /**
     * @param host             主机地址 可以是本级也可以是远程地址
     * @param userName         用户名
     * @param password         密码
     * @param backupFolderPath 备份的路径
     * @param fileName         文件名
     * @param database         数据库名
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {

        return false;
    }

    /**
     * 恢复数据库
     *
     * @param restoreFilePath 数据库备份文件爱你的脚本路径
     * @param host            ip地址
     * @param userName        用户名
     * @param password        密码
     * @param database        数据库名
     * @return
     * @throws Exception
     */
    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return false;
    }
}
