package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Bxcp {

    private Integer id ;
    private String name ;
    private String type ;
    private String typename ;
    private String t1 ;
    private String t2 ;
    private String t3 ;
    private String img ;
    private String content ;
    private String age ;
    private String riqi ;
    private String money ;
    private String url ;
    private String url2 ;
    private String type2 ;
    private String img2 ;
}
