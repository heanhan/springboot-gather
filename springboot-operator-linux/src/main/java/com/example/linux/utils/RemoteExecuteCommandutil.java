package com.example.linux.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.io.*;
/**
 * @Author :zhaojh0912
 * @Date : 2020/12/15 11:00 上午
 * @Version : 1.0
 * @Description :Too
 **/

public class RemoteExecuteCommandutil{
    //字符编码默认是utf-8
    private static String DEFAULTCHART="UTF-8";
    private static Connection conn;

    @Value(value = "192.168.20.128")
    public String ip;

    @Value(value = "root")
    public String userName;

    @Value(value = "123456")
    public String userPwd;


    /**
     * 远程登录linux的主机
     * @author Ickes
     * @since V0.1
     * @return
     *   登录成功返回true，否则返回false
     */
    public static Boolean login(){
        boolean flg=false;
        try {
            conn = new Connection("192.168.20.128");
            conn.connect();//连接
            flg=conn.authenticateWithPassword("root", "123456");//认证
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flg;
    }
    /**
     * @author Ickes
     * 远程执行shll脚本或者命令
     * @param cmd
     *   即将执行的命令
     * @return
     *   命令执行完后返回的结果值
     * @since V0.1
     */
    public static String execute(String cmd){
        String result="";
        try {
            if(login()){
                Session session= conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result=processStdout(session.getStdout(),DEFAULTCHART);
                //如果为得到标准输出为空，说明脚本执行出错了
                if(StringUtils.isEmpty(result)){
                    result=processStdout(session.getStderr(),DEFAULTCHART);
                }
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @author Ickes
     * 远程执行shll脚本或者命令
     * @param cmd
     *   即将执行的命令
     * @return
     *   命令执行成功后返回的结果值，如果命令执行失败，返回空字符串，不是null
     * @since V0.1
     */
    public static String executeSuccess(String cmd){
        String result="";
        try {
            if(login()){
                Session session= conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result=processStdout(session.getStdout(),DEFAULTCHART);
                conn.close();
                session.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解析脚本执行返回的结果集
     * @author Ickes
     * @param in 输入流对象
     * @param charset 编码
     * @since V0.1
     * @return
     *    以纯文本的格式返回
     */
    private static String processStdout(InputStream in, String charset){
        InputStream  stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout,charset));
            String line=null;
            while((line=br.readLine()) != null){
                buffer.append(line+"\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String property = System.getProperty("os.name");
        login();
    }
}
