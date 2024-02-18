public class Main {
    public static void main(String[] args) {
        String s = "Add";
        StrategyContext strategyContext = new StrategyContext();
        if(s.equals("Add")){
            strategyContext.setStrategy(new AddStrategy());
        } else {
            strategyContext.setStrategy(new SubStrategy());
        }
        strategyContext.executeStrategy(1,2);
        System.out.println("Hello world!");
    }
}

interface Strategy{
    public int execute(int a, int b);
}


class AddStrategy implements Strategy {

    @Override
    public int execute(int a, int b) {
        return a+b;
    }
}

class SubStrategy implements Strategy {
    @Override
    public int execute(int a, int b){
        return a-b;
    }
}

class StrategyContext{
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int a, int b) {
        System.out.println(strategy.execute(a, b));
    }


}
