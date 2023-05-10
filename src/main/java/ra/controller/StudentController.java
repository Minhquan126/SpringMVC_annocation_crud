package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.model.Student;
import ra.service.StudentServiceIPM;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    StudentServiceIPM studentServiceIPM = new StudentServiceIPM();
    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Student> list = new ArrayList<>();
        list = studentServiceIPM.findAll();
        model.addAttribute("listStudent",list);
        return "student";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model){
        Student editStudent = new Student();
        editStudent = studentServiceIPM.findById(id);
        System.out.println(editStudent.isSex());
        model.addAttribute("editStudent",editStudent);
        return "editStudent";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id,Model model){
        studentServiceIPM.delete(id);
        return getAll(model);
    }
   @PostMapping("/update")
    public String update(int id,String name,int age,boolean sex,Model model){
        Student updateStudent = new Student(id,name,age,sex);
        studentServiceIPM.update(updateStudent);
        return getAll(model);
   }
   @PostMapping("/add")
    public String add(String name,int age,boolean sex,Model model){
        Student newStudent = new Student(0,name,age,sex);
        studentServiceIPM.save(newStudent);
        return getAll(model);
   }
}
