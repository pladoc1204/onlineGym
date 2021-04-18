package display;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SearchEngineTest {

    @Test
    void searchByTag() {
        MetaReader reader = new MetaReader("VideoMeta");
        VideoList videoList = new VideoList(reader.getVideos());
        SearchEngine engine = new SearchEngine(videoList);
        Set set;
        assertNull(engine.searchByTag("Stretching"));
        set = engine.searchByTag("Pilates");
        set = engine.searchByTag("Toning");

    }

    @Test
    void searchByDifficulty() {
        MetaReader reader = new MetaReader("VideoMeta");
        VideoList videoList = new VideoList(reader.getVideos());
        SearchEngine engine = new SearchEngine(videoList);
        Set set;
        assertNull(engine.searchByDifficulty(2));
        set = engine.searchByDifficulty(3);
        set = engine.searchByDifficulty(4);

    }
}