package com.zp.leetcode.package2022.august.august02;

/**
 * @author zhengpeng
 * @date 2022/8/2 9:40 上午
 * 设计循环队列
 * 循环队列是一种线性数据结构，其操作表现基于FIFO原则并且被连接在队首
 * 之后形成一个循环。它被称为环形缓冲器
 * 循环队列的好处就是我们可以利用这个队列之前用过的空间。在一个普通队列
 * 里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列的前面仍有
 * 空间。但是使用循环队列，我们能使这些空间去存储新的值。
 **/
public class MyCircularQueue {


    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);

        /*
        //新增
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));

        //返回队尾元素
        System.out.println(queue.Rear());

        //判断队列是否是满
        System.out.println(queue.isFull());

        //删除一个元素
        System.out.println(queue.deQueue());

        //再次添加一个元素
        System.out.println(queue.enQueue(4));

        ///返回队尾元素
        System.out.println(queue.Rear());

         */
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(1));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.deQueue());
        System.out.println(queue.Front());

    }


    int[] queue;
    int rear;
    int front;
    int size;

    public MyCircularQueue(int k) {
        //冗余一个空间
        this.size = k + 1;
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    /**
     * 插入一个元素
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        //判断队列是否已满
        if ((rear + 1 ) % size == front) {
            return false;
        }
        queue[rear] = value;
        //rear指针后移
        rear = rear + 1 % size ;
        return true;
    }

    /**
     * 从循环队列中删除一个元素
     * @return
     */
    public boolean deQueue() {

        if(front == rear) {
            return false;
        }
        front = (front + 1) % size;
        return true;
    }

    /**
     * 获取队首元素
     * @return
     */
    public int Front() {
        if(front == rear) {
            return -1;
        }
        return queue[front];
    }

    /**
     * 获取队尾元素
     * @return
     */
    public int Rear() {
        if(front == rear) {
            return -1;
        }
        return queue[(rear + size - 1) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return ((rear + 1) % size == front);
    }
}
