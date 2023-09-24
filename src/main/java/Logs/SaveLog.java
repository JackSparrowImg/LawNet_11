package Logs;

import entity.User;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveLog {

    private static String path = "adminLog.txt";
    public void saveLoginLog(User user) throws IOException {
        //向日志文件中写入
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date);
        String content = "用户：" + user.getUsername() + "在" + time + "登录系统\n";
        FileOutputStream fileOutputStream = new FileOutputStream(path,true);
        byte[] bytes = content.getBytes();
        fileOutputStream.write(bytes);
        File file = new File(path);
        System.out.println(file.getAbsoluteFile());
        fileOutputStream.close();
    }

    public void saveRegisterLog(User user) throws IOException {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date);
        String content = "用户：" + user.getUsername() + "在：" + time + "注册成为中国法网的会员用户";
        FileOutputStream fileOutputStream = new FileOutputStream(path,true);
        byte[] bytes = content.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
        File file = new File(path);
        System.out.println(file.getPath());
    }
}