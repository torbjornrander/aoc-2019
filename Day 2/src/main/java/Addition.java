public class Addition extends Operation {

    public Addition(Integer arg1, Integer arg2, Integer target) {
        super.setArg1(arg1);
        super.setArg2(arg2);
        super.setTarget(target);
        super.setResult(calculate());
    }

    private Integer calculate() {
        return getArg1() + getArg2();
    }

}
