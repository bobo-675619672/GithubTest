package com.dw.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweicheng
 * @ProjectName gaofenshuo-parent
 * @Package com.gaofenshuo.model
 * @ClassName ResponseMsg
 * @description
 * @date created in 2018-07-23 10:48
 * @modified by
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg<T> {

    private ResponseHead head;

    private T data;

}
