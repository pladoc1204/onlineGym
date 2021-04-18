package display;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Video{

    private String name;
    private int id;
    private String location;
    private List<String> tag = null;
    private int duration;
    private int calorie;
    private int popularity;
    private int difficulty;
    @SerializedName("body focus")
    private List<String> bodyFocus = null;
    private List<Object> equipment = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Video() {
    }

    /**
     *
     * @param duration
     * @param difficulty
     * @param popularity
     * @param name
     * @param calorie
     * @param equipment
     * @param location
     * @param bodyFocus
     * @param id
     * @param tag
     */
    public Video(String name, int id, String location, List<String> tag, int duration, int calorie, int popularity, int difficulty, List<String> bodyFocus, List<Object> equipment) {
        super();
        this.name = name;
        this.id = id;
        this.location = location;
        this.tag = tag;
        this.duration = duration;
        this.calorie = calorie;
        this.popularity = popularity;
        this.difficulty = difficulty;
        this.bodyFocus = bodyFocus;
        this.equipment = equipment;
    }

    /**
     * Getter and setter
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getBodyFocus() {
        return bodyFocus;
    }

    public void setBodyFocus(List<String> bodyFocus) {
        this.bodyFocus = bodyFocus;
    }

    public List<Object> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Object> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Video.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("tag");
        sb.append('=');
        sb.append(((this.tag == null)?"<null>":this.tag));
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
        sb.append(',');
        sb.append("calorie");
        sb.append('=');
        sb.append(this.calorie);
        sb.append(',');
        sb.append("popularity");
        sb.append('=');
        sb.append(this.popularity);
        sb.append(',');
        sb.append("difficulty");
        sb.append('=');
        sb.append(this.difficulty);
        sb.append(',');
        sb.append("bodyFocus");
        sb.append('=');
        sb.append(((this.bodyFocus == null)?"<null>":this.bodyFocus));
        sb.append(',');
        sb.append("equipment");
        sb.append('=');
        sb.append(((this.equipment == null)?"<null>":this.equipment));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Video video;
    }
}