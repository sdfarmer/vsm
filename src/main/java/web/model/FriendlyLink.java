package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FriendlyLink {
    private Integer id;
    private String name;
    private String link;
    private Integer status;
    private String created_at;
    private String updated_at;
}
