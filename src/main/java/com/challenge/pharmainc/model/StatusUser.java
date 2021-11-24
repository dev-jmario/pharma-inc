package com.challenge.pharmainc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum StatusUser {

    STT_TRASH(0, "Trash"),
    STT_PUBLISHED(1, "Published");

    @Getter
    private int id;
    private String name;

    public static StatusUser valueOfId(int value){
        StatusUser ret = null;
        for (StatusUser statusUser: StatusUser.values()){
            if(statusUser.id == value ){
                ret = statusUser;
                break;
            }
        }

        return ret;
    }

    public static StatusUser valueOfId(String value){
        StatusUser ret = null;
        for (StatusUser statusUser: StatusUser.values()){
            if(statusUser.name == value ){
                ret = statusUser;
                break;
            }
        }

        return ret;
    }

}
