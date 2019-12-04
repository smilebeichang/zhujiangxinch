package net.wanho.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/7/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Integer cardId;
    private String cardInfo;
    /*private Integer cardSid;*/
}
