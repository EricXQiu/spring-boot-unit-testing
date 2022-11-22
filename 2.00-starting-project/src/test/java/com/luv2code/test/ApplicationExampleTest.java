package com.luv2code.test;

import com.luv2code.component.models.CollegeStudent;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.StudentGrades;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int counter = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void beforeEach() {
        counter++;
        System.out.println("Testing" + this.appInfo + " which is " + this.appDescription + " Version: " +
                this.appVersion + ". Execution of test method " + counter);

        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric.roby@luv2code.com");
        this.studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.5, 91.75)));
        student.setStudentGrades(this.studentGrades);
    }

    @Test
    void basicTest() {

    }

    @Test
    public void addGradeResultsForStudentGrades() {
        assertEquals(353.25, this.studentGrades.addGradeResultsForSingleClass(
                this.student.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    public void addGradeResultsForStudentGradesNotEquals() {
        assertNotEquals(0, this.studentGrades.addGradeResultsForSingleClass(
                this.student.getStudentGrades().getMathGradeResults()
        ));
    }
}