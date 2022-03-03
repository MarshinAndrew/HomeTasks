package Classwork;

public class IntegerConsumer {

    private Integer value;

    public IntegerConsumer() {
        this.value = 0;
    }

    public void consume(Integer value){
        this.value+=value;
    }

    public Integer get(){
        return this.value;
    }

    @Override
    public String toString() {
        return "IntegerConsumer{" +
                "value=" + value +
                '}';
    }
}
