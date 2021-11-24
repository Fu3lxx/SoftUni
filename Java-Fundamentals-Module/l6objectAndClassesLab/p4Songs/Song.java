package l6objectAndClassesLab.p4Songs;

public class Song {
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    private String type;
    private String name;
    private String time;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Song(String type, String name, String time) {
        this.type = type;
        this.name = name;
        this.time = time;
    }



}
