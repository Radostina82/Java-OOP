package Inheritance.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if (!this.data.isEmpty()){
           return this.data.remove(this.data.size()-1);
        }
        return null;
    }
    public String peek(){
        String peekElement = "";
        if (!this.data.isEmpty()){
            peekElement = this.data.remove(this.data.size()-1);
            this.data.add(peekElement);
        }
        return peekElement;
    }
    public  boolean isEmpty(){
        if (this.data.isEmpty()){
            return true;
        }
        return false;
    }
}
