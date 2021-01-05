package com.example.backup.utils;

import java.io.File;

/**
 * @Author :zhaojh0912
 * @Date : 2020/12/15 10:34 上午
 * @Version : 1.0
 * @Description :Too
 **/

public class MysqlBackupRestoreUtils {

    public static boolean backup(String host,String userName,String password,String backupFolderPath,String fileName,String database){
        File backupFolderFile = new File(backupFolderPath);
        //判断路径是否存在
        if(backupFolderFile.exists()){
            //不存在
            backupFolderFile.mkdirs();
        }
        return true;
    }
}
