import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OpCode {

    ADD(1),
    MUL(2),
    END(99);

    private Integer value;

    private final static Map<Integer, OpCode> REVERSE_MAP = new HashMap<>();

    static {
        for (OpCode status: values()) {
            REVERSE_MAP.put(status.value, status);
        }
    }

    public static OpCode forValue(int value) {
        return REVERSE_MAP.get(value);
    }

}
