package com.zp.designpattern.chainofresponsibility.demo2;

/**
 * @author zhengpeng
 * @date 2022-04-02 15:13
 **/
public abstract class AbstractClerk {

    //请求链条
    private AbstractClerk superior = null;

    protected String type;

    public void setSuperior(AbstractClerk superior){
        this.superior = superior;
    }

    public void approveRequest(BorrowRequest request){

        if(getLimit() >= request.getRequestMoney()){
            System.out.println(getType() + "同意借款请求");
        }else {
            if(this.superior != null){
                this.superior.approveRequest(request);
            }else {
                System.out.println("没有人能够同意借款请求");
            }
        }


    }


    public abstract int getLimit();
    public String getType() {
        return type;
    }
}
