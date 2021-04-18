package display;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MetaReader {
    private String metaDirName;
    private Gson gson;

    public MetaReader(String dirName){
        metaDirName = dirName;
        gson = new Gson();
    }

    public ArrayList<Video> getVideos(){
        File dir = new File(metaDirName);
        File[] files = dir.listFiles(file -> file.getName().endsWith(".json"));

        Scanner reader;
        ArrayList<Video> videoList = new ArrayList<>();
        String videoJson = "";

        for(File file: files){
            try{
                reader = new Scanner(file);
                while(reader.hasNextLine()){
                    videoJson += reader.nextLine();
                }
                videoList.add(gson.fromJson(videoJson, Video.class));
                videoJson = "";
            }
            catch(FileNotFoundException e){
                System.out.println(file.getName() + "'s meta file cannot be found!");
            }
        }
        return videoList;
    }

//    public static void main(String[] args) {
//        MetaReader meta = new MetaReader("VideoMeta");
//        ArrayList<Video> videos = meta.getVideos();
//    }
}
