package di_rover;

import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();

        List<Integer> result = source.stream().filter(number -> {
            if (number < this.threshold) {
                logger.log("The element " + number + " passes");
                return true;
            }
            logger.log("The element " + number + " does not pass");
            return false;
        }).toList();
        return result;
    }
}
