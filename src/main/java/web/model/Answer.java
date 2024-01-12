package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Answer {
    private Integer id;
    private String answer;
    private Integer type;
    private Integer tosolve;
    private String insertdate;
    private Integer askid;
    private String userid;
    private String userimg;
    private String username ;
}
