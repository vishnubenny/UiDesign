package lv.com.home.model.pojo;

public class VideoDataPojo {
    private String title;
    private String time;
    private String content;
    private String imageUrl;

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }
}
