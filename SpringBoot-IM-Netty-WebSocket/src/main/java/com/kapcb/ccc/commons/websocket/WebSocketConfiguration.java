

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.yeauty.standard.ServerEndpointExporter;

/**
 * <a>Title: WebSocketConfiguration </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/3-11:58
 */
@Slf4j
@Configuration
public class WebSocketConfiguration {

    @Bean
    @Scope("singleton")
    public ServerEndpointExporter serverEndpointExporter() {
        log.info("spring will initial server end point exporter");
        return new ServerEndpointExporter();
    }
}
