package com.example.backup.service;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/15 10:24 上午
 * @Version : 1.0
 * @Description :命令行备份、恢复服务、删除备份文件
 **/

public interface MysqlBackupService {

    /**
     *
     * @param host 主机地址 可以是本级也可以是远程地址
     * @param userName 用户名
     * @param password 密码
     * @param backupFolderPath 备份的路径
     * @param fileName  文件名
     * @param database 数据库名
     * @return boolean
     * @throws Exception 异常
     */
    boolean backup(String host,String userName,String password,String backupFolderPath,String fileName,String database)throws Exception;

    /**
     * 恢复数据库
     * @param restoreFilePath  数据库备份文件爱你的脚本路径
     * @param host ip地址
     * @param userName 用户名
     * @param password 密码
     * @param database 数据库名
     * @return
     * @throws Exception
     */
    boolean restore(String restoreFilePath,String host,String userName,String password,String database)throws Exception;

}
