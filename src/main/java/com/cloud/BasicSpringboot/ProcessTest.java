package com.cloud.BasicSpringboot;

import lombok.SneakyThrows;

/**
 * @program: ControlLinuxProcess
 * @description:
 * @author: Cloud
 * @create: 2020/7/23 15:04:04
 */
public class ProcessTest implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        getLinuxProcessInfo info = new getLinuxProcessInfo();
        ExecShellCommand command = new ExecShellCommand();
        for (int i = 0; i < 10; i++) {
//            info.run("top");
            System.out.println(command.execCmd("ps -ef",null));
//            System.out.println(command.execCmd("docker ps -a",null));
            CloseLinuxProcess process = new CloseLinuxProcess();
            String pid = process.getPID("java -jar app-0.0.1.jar");
            System.out.println(pid);
            process.closeLinuxProcess(pid);
//            System.out.println(Thread.currentThread().getName() + "-->" + i);

            //休眠一秒钟
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
