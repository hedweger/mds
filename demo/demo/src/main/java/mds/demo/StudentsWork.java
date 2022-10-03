package mds.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class StudentsWork {
    // private List<Student> students = new ArrayList<Student>();
    @GetMapping("student")
    public String studentSet(@RequestParam(defaultValue = "Tomas Hadwiger") String name,
                             @RequestParam(defaultValue = "230252") String id) {
        return " Student: <b>" + name + "</b> ID: <b>" + id + "</b>";
    }


    @GetMapping("students")
    public String studentList(@RequestParam(defaultValue = "0") int vutid) {
        if (vutid == 0) {
            String studentsOut = "";
            for (Student student : students
            ) {
                studentsOut += "Student: <b>" + student.name + " " + student.surname + "</b> ID: <b>" + student.id + "</b> Rok narozeni: <b>" + student.year + "</b> <br>";
            }
            return studentsOut;
        }
        else {
            Optional<Student> result = students.stream().filter(item -> item.id == vutid).findFirst();
            if (result.isEmpty()) return "no student";
            else return
                    "Student: <b>" + result.get().name + " " + result.get().surname + "</b> ID: <b>" + result.get().id + "</b> Rok narozeni: <b>" + result.get().year + "</b> <br>";
        }
    }

    private List<Student> students = new ArrayList<Student>(); {
        students.add(new Student("Meshores","Lev",187396,1996));
        students.add(new Student("Berg","František",211132,1998));
        students.add(new Student("Fanta","Tomáš",217135,2000));
        students.add(new Student("Vojáčková","Veronika",221584,2000));
        students.add(new Student("Macho","Radim",221666,1999));
        students.add(new Student("Gura","Maxim",222062,2000));
        students.add(new Student("Hadwiger","Tomáš",230252,2001));
        students.add(new Student("Horský","Milan",230258,2001));
        students.add(new Student("Beránek","Karel",230533,2000));
        students.add(new Student("Cristovao","Cristovao Matias Pedro",230539,1999));
        students.add(new Student("Hnátek","Michal",230555,2001));
        students.add(new Student("Hrabálek","Matěj",230559,2000));
        students.add(new Student("Ioani","Leida",230569,2001));
        students.add(new Student("Ostrý","Pavel",230624,2001));
        students.add(new Student("Seč","Filip",230656,2000));
        students.add(new Student("Smetana","Martin",230668,2000));
        students.add(new Student("Český","Michal",230789,2000));
        students.add(new Student("Žernovič","Michal",230923,2000));
        students.add(new Student("Hostášek","Josef",231050,1999));
        students.add(new Student("Bielik","Oliver",231229,2000));
        students.add(new Student("Drdulová","Ester",231233,2001));
        students.add(new Student("Takács","Peter",231290,2001));
        students.add(new Student("Vidlařová","Pavla",231300,2001));
        students.add(new Student("Kohout","David",195823,1996));
        students.add(new Student("Číka","Petr",10,1982));
        students.add(new Student("Masaryk","Tomáš",123456,1850));
    }
}
