package cn.list;

/**
 * @ClassName MyIcLinkedList
 * @Description 带头结点的单循环链表
 * @Auther danni
 * @Date 2019/7/26 8:47]
 * @Version 1.0
 **/

public class MyIcLinkedList {
    //头插法
    public Icnode addFrist(Icnode node ,int datas){
        Icnode ic=new Icnode(datas);
        if(node==null){
            node.next=ic;
            ic.next=node;
        }
        else{
            ic.next=node.next;
            node.next=ic;
        }
        return node;
    }
    //尾插法
    public Icnode addLast(Icnode node,int datas){
        Icnode ic=new Icnode(datas);
        Icnode temp=node;
        if(temp==null){
            temp.next=ic;
            ic.next=temp;
        }
        else{
            while(temp.next!=node){
                temp=temp.next;
            }
            temp.next=ic;
            ic.next=node;
        }
        return node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addindex(Icnode node,int index,int datas){
        if(index>this.length(node)+1){
            System.err.println("位置无效，插入失败");
            return false;
        }
        else{
            if(index==1){
                node=this.addFrist(node,datas);
                return true;
            }
            else if(index==this.length(node)+1){
                node=this.addLast(node,datas);
                return true;
            }
            else{
                Icnode temp=node.next;
                Icnode ic=new Icnode(datas);
                int num=1;
               while(num<index-1){
                   temp=temp.next;
                   num++;
                }
                ic.next=temp.next;
               temp.next=ic;
                return true;
            }
        }
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains( Icnode node,int key){
        if(this.isEmpty(node)){
            System.err.println("链表为空！");
            return false;
        }
        Icnode temp=node.next;
        while(temp!=node){
            if(temp.data==key){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public Icnode  remove(Icnode node ,int key){
        if(this.isEmpty(node)){
            System.err.println("链表为空！");
            return node;
        }
        if(!(this.contains(node,key))){
            System.err.println("不存在该数，删除失败！返回原链表。");
            return node;
        }
        Icnode temp=node.next;
        Icnode pre=temp;
        while(temp!=node){
            if(temp.data==key){
                pre.next=temp.next;
            }
            pre=temp;
            temp=temp.next;
        }
        return node;
    }
    //删除所有值为key的节点
    public Icnode removeAllKey(Icnode node,int key){
        if(this.isEmpty(node)){
            System.err.println("链表为空！");
            return node;
        }
        if(!(this.contains(node,key))){
            System.err.println("不存在该数，删除失败！返回原链表。");
            return node;
        }
        Icnode last=null;
        Icnode temp=node.next;
        while(temp!=node){
            if(temp.data==key){
                if(temp==node.next){
                    node.next=node.next.next;
                    temp=node.next;
                }
                else {
                    last.next=temp.next;
                    temp=temp.next;
                }
            }
            else{
             last=temp;
            temp=temp.next;
            }
        }
        return node;
    }
    //打印单循环链表
    public void printList(Icnode node){
        if(this.isEmpty(node)){
            System.err.println("链表为空无法打印");
            return;
        }
        else{
            Icnode m=node.next;
            while(m!=node){
                System.out.print(m);
                m=m.next;
            }
        }
        System.out.println(node.data);
    }
    //对单循环链表判空
    public boolean isEmpty(Icnode node) {
        if (node.next == node) {
            return true;
        } else {
            return false;
        }
    }
    //返回单循环链表的长度
    public  int length(Icnode node){
        if(this.isEmpty(node)){
            return 0;
        }
        Icnode temp=node.next;
        int num=0;
        while(temp!=node){
            num++;
            temp=temp.next;
        }
        return num;
    }
    public static void main(String[] args) {
        MyIcLinkedList n=new MyIcLinkedList();
        Icnode node=new Icnode();
        node=n.addFrist(node,2);
        node=n.addFrist(node,2);
        node=n.addFrist(node,3);
        node=n.addFrist(node,2);
        node=n.addLast(node,5);
        node=n.addLast(node,3);
        node=n.addLast(node,2);
        n.printList(node);
        node=n.removeAllKey(node,3);
        n.printList(node);
       /* if(n.addindex(node,10,10)) {
            n.printList(node);
        }*/
       //System.out.println(n.contains(node,7));
       // node=n.remove(node,7);
        //n.printList(node);
    }

}
class Icnode{
    int data;
    Icnode next=null;

    public Icnode(int data) {
        this.data = data;
    }

    public Icnode() {
        this.data=-1;
        this.next=this;
    }
    //重写toString方法
    public String toString(){
        return String.format("(Node%d)->",data);
    }

}
