package web.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VsmVideo {

    private Integer id ;
    private String videoname ;
    private String title ;
    private String keywords ;
    private String content ;
    private String description ;
    private String insertdate ;
    private String type ;
    private String img ;

}
