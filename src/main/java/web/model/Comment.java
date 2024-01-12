package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment {

    private Integer id ;
    private String txt ;
    private String type ;
    private String insertdate ;
    private String user ;
    private Integer num ;
    private String userimg ;
    private String city ;

}
