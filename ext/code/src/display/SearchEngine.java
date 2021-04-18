package display;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchEngine {
    private VideoList videoList;
    private Map<Integer, Video> idToVideo;
    private Map<String, Set> tagToId;
    private Map<String, Set> equipmentToId;
    private Map<String, Set> bodyToId;
    private Map<Integer, Set> diffcultyToId;
    //TODO search by name
    
    public SearchEngine(VideoList videoList){
        this.videoList = videoList;
        idToVideo = new HashMap<>();
        tagToId = new HashMap<>();
        diffcultyToId = new HashMap<>();
        createMaps();
    }

    private void createMaps(){
        int id;
        Set<Integer> idSet;

        for(Video video: videoList.getVideos()){
            id = video.getId();
            idToVideo.put(id, video);

            for(String tag: video.getTag()){
                idSet = tagToId.getOrDefault(tag, new HashSet());
                idSet.add(id);
                tagToId.putIfAbsent(tag, idSet);
            }

            int diffculty = video.getDifficulty();
            idSet = diffcultyToId.getOrDefault(diffculty, new HashSet());
            idSet.add(id);
            diffcultyToId.putIfAbsent(diffculty, idSet);

        }
    }
    public Set<Integer> searchByTag(String tag){
        return tagToId.get(tag);
    }
    public Set<Integer> searchByDifficulty(int difficulty){
        return diffcultyToId.get(difficulty);
    }


}
