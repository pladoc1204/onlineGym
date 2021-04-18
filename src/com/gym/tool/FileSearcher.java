package com.gym.tool;

import java.io.File;

public class FileSearcher {
    private String HOME;
    private String currentDir;
    private File currentFile;

    public void printFiles(File[] files){
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                //System.out.println(f);
                System.out.println("name:"+f.getName());
            }
        }
        System.out.println("==========");
    }

    public File findFileByNameBFS(String dir,String name){
        File rtn = null;
        File f = new File(dir);
        if(f.isFile()){
            return null;
        }

        File[] listFiles = f.listFiles();
        //printFiles(homeDir);

        for(File file: listFiles){
            if(file.getName().equals(name)&&rtn==null){
                rtn = file;
            }
        }
        for (File file:listFiles){
            if(rtn==null){
                rtn = findFileByNameBFS(file.getAbsolutePath(),name);
            }
        }
        return rtn;
    }

    public File findDirByNameBFS(String dir,String name) {
        File rtn = null;
        File f = new File(dir);
        if (f.isFile()) {
            return null;
        }

        File[] listFiles = f.listFiles();
        //printFiles(homeDir);

        for (File file : listFiles) {
            if (file.getName().equals(name) && rtn == null && file.isDirectory()) {
                rtn = file;
            }
        }
        for (File file : listFiles) {
            if (rtn == null) {
                rtn = findFileByNameBFS(file.getAbsolutePath(), name);
            }
        }
        return rtn;
    }

    public File findFileByNameDFS(String dir,String name){
        File rtn = null;
        File f = new File(dir);
        if(f.isFile()){
            return null;
        }

        File[] listFiles = f.listFiles();
        //printFiles(homeDir);

        for(File file: listFiles){
            if(rtn==null){
                rtn = findFileByNameDFS(file.getAbsolutePath(),name);
            }
            if(file.getName().equals(name)&&rtn==null){
                rtn = file;
            }
        }

        return rtn;
    }

    public int findDirCountsInCurrentDir(String dir){
        int rtn = 0;
        File f = findDirByNameBFS(HOME,dir);
        if(f.isFile()){
            return 0;
        }

        File[] listFiles = f.listFiles();
        for (File file:listFiles){
            if(file.isDirectory()==true){
                rtn++;
            }
        }

        System.out.println("counts:"+rtn);
        return rtn;
    }

    public static void main(String[] args) {
        FileSearcher fs=new FileSearcher();
        fs.HOME=new File("").getAbsolutePath();
        long stime = System.currentTimeMillis();
      String testItem="x.json";
        File resultBFS =fs.findFileByNameDFS(fs.HOME,testItem);
        long etime = System.currentTimeMillis();
        long stime1 = System.currentTimeMillis();
        File resultDFS =fs.findFileByNameDFS(fs.HOME,testItem);
        long etime1 = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        //System.out.println(resultBFS.getAbsolutePath());
        System.out.printf("执行时长：%d 毫秒.", (etime1 - stime1));
        //System.out.println(resultDFS.getAbsolutePath());
        fs.findDirCountsInCurrentDir("cate");
    }
}
