package uk.co.waleed.Main.Model;

import java.util.ArrayList;

public class HomeDTO {

    private final long id;
    private final ArrayList content;

    public HomeDTO(long id, ArrayList content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public ArrayList getContent() {
        return content;
    }

}
