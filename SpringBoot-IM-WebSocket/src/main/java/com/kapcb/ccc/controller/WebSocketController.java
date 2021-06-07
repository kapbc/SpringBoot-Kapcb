
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: WebSockertController </a>
 * <a>Author: Mike Chen <a>
 * <a>Description:  <a>
 *
 * @author Mike Chen
 * @date 2021/6/4-13:30
 */
@Slf4j
@Controller
@RequestMapping("/")
public class WebSocketController {

    @GetMapping("index/{username}")
    public String index(@PathVariable(value = "username") String username, Model model) {
        log.info("the username is : " + username);
        model.addAttribute("username", username);
        return "index";
    }
}
