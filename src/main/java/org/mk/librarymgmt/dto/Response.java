package org.mk.librarymgmt.dto;

/**
 * @author Manikandan
 */
public class Response {
    private boolean success;

    public Response() {
    }

    private String respMsg ;

    public Response(boolean success, String respMsg) {
        this.success = success;
        this.respMsg = respMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
