package com.dw.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweicheng
 * @ProjectName gaofenshuo-parent
 * @Package com.gaofenshuo.model
 * @ClassName ResponseHead
 * @description
 * @date created in 2018-07-23 10:49
 * @modified by
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHead {

    private String respStatus;

    private String respCode;

    private String respDesc;
}

