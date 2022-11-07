package peaksoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String getStudents(){
        return "all_student";
    }

    @GetMapping("/director_info")
    public String getDirector(){
        return "director";
    }

    @GetMapping("/instructor_info")
    public String getInstructor() {
        return "instructor";
    }
}
