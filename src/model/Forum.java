package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Forum {
    private int id;
    private String title;
    private List<Comment> commentList;

    public Forum(String title) {
        this.title = title;
    }
}
