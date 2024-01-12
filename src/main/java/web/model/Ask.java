package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Ask {
    private Integer id;
    private String ask;
    private String askcontent;
    private String keywords;
    private String bestanswer;
    private Integer bestanswerstate;
    private Integer tosolve;
    private Integer answernum;
    private String insertdate;
    private Integer columnid1;
    private String columnurlname1;
    private String columnshortname1;
    private Integer columnid2;
    private String columnurlname2;
    private String columnshortname2;
    private Integer visitnum;
    private String userid;
    private String userimg;
    private String bestuserid;
    private String bestuserimg;
    private Integer pagenum;
    private Integer limitnum;
    private String username;
    private String bestusername;
    private String urlname;
    private String realname;

    public String getInsertdate() {
        if (insertdate.contains(" ")) {
            return insertdate.split(" ")[0];

        }
        return insertdate;
    }
}
