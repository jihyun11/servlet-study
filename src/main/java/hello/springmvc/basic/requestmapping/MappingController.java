package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info(data);
        return "ok";
    }

    // 특정 파라미터 정보가 있으면 호출됨
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        return "ok";
    }


    // 특정 헤더 정보가 있으면 호출됨
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    // 헤더의 contentType이 json인 경우에만 호출됨
    @GetMapping(value = "/mapping-header", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

  // 헤더의 contentType이 html인 경우에만 호출됨
    @GetMapping(value = "/mapping-header", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
