package studying.models;


import jakarta.validation.constraints.*;

public class Note {
    @Min(value = 0,message = "id should be greater than 0")
    private int id;
    @NotEmpty(message = "title can't be empty")
    @Size(min=2,max = 100,message = "title should be between 2 and 100")
    private String title;
    @NotEmpty(message = "title can't be empty")
    @Size(min=2,max = 100,message = "title should be between 2 and 100")
    private String content;

    public Note() {
    }

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
