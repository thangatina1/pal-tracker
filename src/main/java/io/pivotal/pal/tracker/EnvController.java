package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String PORT;
    private final String MEMORY_LIMIT;
    private final String CF_INSTANCE_INDEX;
    private final String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:Not set}") String PORT,
                         @Value("${memory.limit:Not set}") String MEMORY_LIMIT,
                         @Value("${cf.instance.index:Not set}") String CF_INSTANCE_INDEX,
                         @Value("${cf.instance.addr:Not set}") String CF_INSTANCE_ADDR) {
        this.PORT = PORT;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", PORT);
        env.put("MEMORY_LIMIT", MEMORY_LIMIT);
        env.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        env.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);

        return env;
    }
}
