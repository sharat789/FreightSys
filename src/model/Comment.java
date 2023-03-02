package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Comment {
    private int id;
    private String commentText;
    private User user;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private List<Comment> replies;

    public Comment(String commentText, User user) {
        this.commentText = commentText;
        this.user = user;
        dateCreated = LocalDate.now();
    }
}
