# 责任链模式

## 目的

### 原文

    Avoid coupling the sender of a request to its receiver by giving more than one object a chance to 
    handle the request. Chain the receiving objects and pass the request along the chain until an object 
    handles it.

### 翻译
    
    使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
    将这些对象连成一条链，并沿着这条链传递该请求，直到有对象能够处理它。
    

## 场景举例

    你要去给某公司借款1万元,当你来到柜台时向柜员发起"借款一万元"的请求时，
    柜员认为金额太多，处理不了这样的请求，他转交这个请求给他的组长，组长也处理不了
    这样的请求，那么他接着向经理转交这样的请求
    
    这时候如果添加了新的职位老版，他的额度为 1000000 元，那么我们只需创建一个新的具体职员类继承抽象职工类即可。

```java

public void test(Request request) {
    int money = request.getRequestMoney();
    if(money <= 1000) {
        Clerk.response(request);	
    } else if(money <= 5000) {
        Leader.response(request);
    } else if(money <= 10000) {
        Manager.response(request);
    }
}

```



 