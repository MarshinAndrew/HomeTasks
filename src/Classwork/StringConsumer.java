package Classwork;

public class StringConsumer {

    private String value;

    public StringConsumer() {
        this.value = "";
    }
    public void consume (String value){
        this.value= this.value.concat(value);
    }

    public String get(){
        return this.value;
    }
}
