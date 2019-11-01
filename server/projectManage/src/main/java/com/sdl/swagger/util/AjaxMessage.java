package com.sdl.swagger.util;

import net.sf.json.JSONObject;

import java.io.Serializable;

/**
 * @author sundonglin
 * @date 2019/10/29 15:17
 */
public class AjaxMessage<T> implements Serializable {

    private static final long serialVersionUID = -6568659263635887814L;

    public static final AjaxMessage<?> OPERATION_SUCCESS_MESSAGE = new AjaxMessage<Object>(true, "操作成功！");
    public static final AjaxMessage<?> OPERATION_FAILURE_MESSAGE = new AjaxMessage<Object>(false, "操作失败！");

    private boolean success; // 操作是否成功
    private String description; // 操作结果信息
    private String errorCode;
    private T data; // 操作的数据，可以不设置


    public AjaxMessage() {
    }

    /**
     * 根据业务层异常封装成消息传递类
     * @param e 操作时发生的异常
     */
    public AjaxMessage(Exception e) {
        this.success = false;
        this.description = e.getMessage();
    }

    /**
     * 根据业务层异常封装成消息传递类
     * @param e 操作时发生的异常
     * @param data 操作的数据
     */
    public AjaxMessage(Exception e, T data) {
        this(e);
        this.data = data;
    }

    public AjaxMessage(boolean success, String description) {
        this.success = success;
        this.description = description;
    }

    public AjaxMessage(boolean success, String description, T data) {
        this.success = success;
        this.description = description;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 转换为JSON字符串
     */
    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }

}
