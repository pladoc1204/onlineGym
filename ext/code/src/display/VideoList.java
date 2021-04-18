package display;

import java.util.List;

public class VideoList {
    private List<Video> videos;

    public VideoList(List<Video> videos) {
        this.videos = videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }
}
