public class DayOne {

    private final static TxtFileReader READER = new TxtFileReader("input.txt");

    public static void main(String[] args) {

        System.out.println(Processor.processFuleList(READER.getLines()));

    }
}