import java.util.LinkedList;
import java.util.List;

public class Router {

    public static Integer findClosestIntersectionDistance(List<String> wireOne, List<String> wireTwo) {
        List<Coordinate> wireOneProgression = parseWireCoordinates(wireOne);
        List<Coordinate> wireTwoProgression = parseWireCoordinates(wireTwo);

        List<Coordinate> intersections = ListUtils.getCommonElements(wireOneProgression, wireTwoProgression);

        return intersections.stream().mapToInt(Coordinate::manhattanDistance).min().getAsInt();
    }

    public static List<Coordinate> parseWireCoordinates(List<String> wire) {
        Coordinate currentCoordinate = Coordinate.builder().x(0).y(0).build();
        List<Coordinate> coordinates = new LinkedList<>();
        wire.forEach(instruction -> {
            char character = instruction.charAt(0);
            int number = Integer.parseInt(instruction.substring(1));
            switch (character) {
                case 'U':
                    for (int k = 0; k < number; k++) {
                        Coordinate nextCoordinate = Coordinate.builder().x(currentCoordinate.getX()).y(currentCoordinate.getY() + 1).build();
                        coordinates.add(nextCoordinate);
                        currentCoordinate.set(nextCoordinate);
                    }
                    break;
                case 'D':
                    for (int k = 0; k < number; k++) {
                        Coordinate nextCoordinate = Coordinate.builder().x(currentCoordinate.getX()).y(currentCoordinate.getY() - 1).build();
                        coordinates.add(nextCoordinate);
                        currentCoordinate.set(nextCoordinate);
                    }
                    break;
                case 'L':
                    for (int k = 0; k < number; k++) {
                        Coordinate nextCoordinate = Coordinate.builder().x(currentCoordinate.getX() - 1).y(currentCoordinate.getY()).build();
                        coordinates.add(nextCoordinate);
                        currentCoordinate.set(nextCoordinate);
                    }
                    break;
                case 'R':
                    for (int k = 0; k < number; k++) {
                        Coordinate nextCoordinate = Coordinate.builder().x(currentCoordinate.getX() + 1).y(currentCoordinate.getY()).build();
                        coordinates.add(nextCoordinate);
                        currentCoordinate.set(nextCoordinate);
                    }
                    break;
            }

        });
        return coordinates;
    }

}
