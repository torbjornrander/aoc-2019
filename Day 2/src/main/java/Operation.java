import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Operation {

    private Integer arg1;
    private Integer arg2;
    private Integer target;
    private Integer result;

}
