package pl.sda.quiz.Reply;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Reply {

    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    Integer id;
    @Column(name = "open_reply")
    String reply;
    @Column(name = "is_valid")
    boolean isValid;
}
