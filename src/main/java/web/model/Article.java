package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Article {
    private Integer id;
    private String title;
    private String keywords;
    private String description;
    private String articlecontent;
    private Integer columnid1;
    private String type;
    private String type2;
    private String typename;
    private String type2name;
    private String image;
    private String columnurlname1;
    private String columnshortname1;
    private Integer columnid2;
    private String columnurlname2;
    private String columnshortname2;
    private String insertdate;
    private String headimg;
    private Integer visitnum;
    private Integer pagenum;
    private Integer limitnum;

    public String getInsertdate() {
        if (insertdate.contains(" ")) {
            return insertdate.split(" ")[0];

        }
        return insertdate;
    }
}
