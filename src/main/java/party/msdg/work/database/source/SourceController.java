package party.msdg.work.database.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import party.msdg.work.base.auth.XHeaders;

import java.util.List;


@RestController
@RequestMapping("/api/source")
public class SourceController {

    @Autowired
    private SourceService sourceService;
    
    @GetMapping("/all")
    public List<Source> sources(
        @RequestHeader(XHeaders.LOGIN_USER_ID) int loginUser
    ) {
        return sourceService.allSources(loginUser);
    }
    
    @GetMapping("/one")
    public Source one(
        @RequestHeader(XHeaders.LOGIN_USER_ID) int loginUser,
        @RequestParam("id") int id
    ) {
        return sourceService.one(loginUser, id);
    }
    
    @PostMapping("/add")
    public void add(@RequestBody Source source) {
        sourceService.add(source);
    }
}
