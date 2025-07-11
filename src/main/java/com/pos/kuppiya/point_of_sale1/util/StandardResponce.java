package com.pos.kuppiya.point_of_sale1.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponce {
    private  int code;
    private String message;
    private Object data;
}
