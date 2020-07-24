package com.cloud.BasicSpringboot;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: testLinux
 * @description: 查看并关闭linux内的进程
 * @author: Cloud
 * @create: 2020/7/24 09:11:05
 */
@Component
public class CloseLinuxProcess {
//    public static void main(String[] args) {
//        String PID = getPID("java -jar app.jar");
//        closeLinuxProcess(PID);
//    }

    /**
     * 获取Linux进程的PID
     * @param command
     * @return
     */
    public static String getPID(String command){
        System.out.println(command);
        BufferedReader reader =null;
        try{
            //显示所有进程
            Process process = Runtime.getRuntime().exec("ps -ef");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while((line = reader.readLine())!=null){
                if(line.contains(command)){
                    System.out.println("相关信息 -----> "+command);
                    String[] strs = line.split("\\s+");
                    return strs[1];
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
        return null;
    }

    /**
     * 关闭Linux进程
     * @param Pid 进程的PID
     */
    public static void closeLinuxProcess(String Pid){
        Process process = null;
        BufferedReader reader =null;
        try{
            //杀掉进程
            process = Runtime.getRuntime().exec("kill -9 "+Pid);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while((line = reader.readLine())!=null){
                System.out.println("kill PID return info -----> "+line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(process!=null){
                process.destroy();
            }

            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
