import java.util.*;
import java.io.*;

public class Player{

  String name;
  int mbank,struck;
  int b1 = 0;
  int b3 = 0;
  int b4 = 0;

  public Player(String n, int b,int s,int bb1,int bb2,int bb3)
  {
      
    this.name = n;
    this.mbank = b;
    this.struck = s;
    this.b1 = bb1;
    this.b3 = bb2;
    this.b4 = bb3;
    
  }

public String getName(){
  return name;
}

public int getMBank(){
  return mbank;
}

public int getStruck(){
  return struck;
}
public int getB1(){
    return b1;
}
public int getB3(){
    return b3;
}
public int getB4(){
    return b4;
}
public int updateB1(){
    b1 = 1;
    return b1;
}

public int updateB3(){
    b3 = 1;
    return b3;
}

public int updateB4(){
    b4 = 1;
    return b4;
}

public int updateMBank(String n,int op){
    if(n == "Deposit"){
        mbank += op;    
    }
    else if(n == "Withdraw")
    {
        mbank -= op;
    }

    updateStruck(n,op);
    return mbank;
}

public int updateStruck(String n,int op){
      if(n == "Deposit"){
        struck -= op;
    }
    else if(n == "Withdraw"){
        struck += op;
    }else{
        struck+=op;
    }
    return struck;
}

public void updateMoney(int money)
{
  mbank = money;
}

}
