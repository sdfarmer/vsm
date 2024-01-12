package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Channel {
    private Integer id ;
    private String imageurl ;
    private String content ;
    private String type ;
    private String title ;
    private String description ;
    private String keywords ;
}
