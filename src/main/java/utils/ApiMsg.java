package utils;

import lombok.Data;

@Data
public class ApiMsg {

    String message;
    Object data;

    public ApiMsg(String message, Object data){
        this.message = message;
        this.data = data;

    }

}
