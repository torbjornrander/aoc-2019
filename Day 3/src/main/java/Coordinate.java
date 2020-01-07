import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Builder
@Getter
@Setter
public class Coordinate {

    private Integer x;
    private Integer y;

    public Integer manhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public void set(Coordinate coordinate) {
        this.x = coordinate.x;
        this.y = coordinate.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

