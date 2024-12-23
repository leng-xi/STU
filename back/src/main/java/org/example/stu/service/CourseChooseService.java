package org.example.stu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.stu.mapper.*;
import org.example.stu.pojo.Course;
import org.example.stu.pojo.CourseChoose;
import org.example.stu.pojo.Person;
import org.example.stu.pojo.Student;
import org.example.stu.pojo.vo.CourseChooseVo;
import org.example.stu.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseChooseService {
    @Autowired
    private CourseChooseMapper courseChooseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonMapper personMapper;

    public PageBean page1(Integer page, Integer pageSize, Integer courseId) {
        PageHelper.startPage(page, pageSize);
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByCourseId(courseId);
        for (CourseChoose courseChoose : courseChooseList) {
            Person person = personMapper.selectById(studentMapper.selectById(courseChoose.getStudentId()).getPersonId());
            Course course = courseMapper.selectCourseNumAndCourseNameById(courseChoose.getCourseId());

        }
        Page<CourseChoose> p = (Page<CourseChoose>) courseChooseList;
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    public List<CourseChooseVo> getList2(Integer studentId) {
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByStudentId(studentId);
        List<CourseChooseVo> courseChooseVoList = new ArrayList<>();
        for (CourseChoose courseChoose : courseChooseList) {
            CourseChooseVo courseChooseVo = new CourseChooseVo();
            courseChooseVo.setId(courseChoose.getId());
            courseChooseVo.setStudentId(courseChoose.getStudentId());
            courseChooseVo.setCourseId(courseChoose.getCourseId());
            courseChooseVo.setScore1(courseChoose.getScore1());
            courseChooseVo.setScore2(courseChoose.getScore2());
            courseChooseVo.setScore3(courseChoose.getScore3());
            Course course = courseMapper.selectById(courseChoose.getCourseId());
            courseChooseVo.setCourse(course);
            courseChooseVoList.add(courseChooseVo);
        }
        courseChooseVoList.get(0).setNum1(0);
        courseChooseVoList.get(0).setNum2(0);
        courseChooseVoList.get(0).setNum3(0);
        courseChooseVoList.get(0).setNum4(0);
        courseChooseVoList.get(0).setNum5(0);
        for (CourseChoose courseChoose : courseChooseList) {
            if (courseChoose.getScore3() >= 90) {
                courseChooseVoList.get(0).setNum1(courseChooseVoList.get(0).getNum1() + 1);
            }
            if (courseChoose.getScore3() >= 80 && courseChoose.getScore3() < 90) {
                courseChooseVoList.get(0).setNum2(courseChooseVoList.get(0).getNum2() + 1);
            }
            if (courseChoose.getScore3() >= 60 && courseChoose.getScore3() < 80) {
                courseChooseVoList.get(0).setNum3(courseChooseVoList.get(0).getNum3() + 1);
            }
            if (courseChoose.getScore3() > 0 && courseChoose.getScore3() < 60) {
                courseChooseVoList.get(0).setNum4(courseChooseVoList.get(0).getNum4() + 1);
            }
            if (courseChoose.getScore3() == 0) {
                courseChooseVoList.get(0).setNum5(courseChooseVoList.get(0).getNum5() + 1);
            }
        }
        return courseChooseVoList;
    }

    public List<Course> getList3(Integer studentId) {
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByStudentId(studentId);
        List<Course> courseList = new ArrayList<>();
        for (CourseChoose courseChoose : courseChooseList) {
            Course course = courseMapper.selectById(courseChoose.getCourseId());
            courseList.add(course);
        }
        List<Course> allList = courseMapper.selectAll();
        List<Course> allList2 = courseMapper.selectAll();
        if (allList.size() == courseList.size()) return null;
        for (Course course : allList) {
            for (Course course1 : courseList) {
                if (course.getId() == course1.getId()) {
                    allList2.remove(course1);
                }
            }
        }
        return allList2;
    }

    public Integer addCourseChoose(CourseChoose courseChoose) {
        Course course = courseMapper.selectById(courseChoose.getCourseId());
        if (course.getIsopen().equals(0)) return 0;
        List<CourseChoose> courseChooseList = courseChooseMapper.selectByStudentId(courseChoose.getStudentId());
        for (CourseChoose choose : courseChooseList) {

            if (choose.getCourseId().equals(courseChoose.getCourseId())) return 1;
            if (courseMapper.selectById(choose.getCourseId()).getTime().equals(course.getTime())) return 2;
        }
        courseChooseMapper.insert(courseChoose);
        return 3;
    }

    public Boolean addScore(CourseChoose c) {
        CourseChoose courseChoose = courseChooseMapper.selectById(c.getId());
        Course course = courseMapper.selectById(courseChoose.getCourseId());
        courseChoose.setScore1(c.getScore1());
        courseChoose.setScore2(c.getScore2());
        int score3 = courseChoose.getScore1() * Integer.parseInt(course.getPre1()) + courseChoose.getScore2() * Integer.parseInt(course.getPre2());
        courseChoose.setScore3(score3 / 100);
        courseChooseMapper.updateById(courseChoose);
        return true;
    }

    public boolean delete(CourseChoose courseChoose) {
        courseChooseMapper.deleteByStudentIdAndCourseId(courseChoose);
        return true;
    }

    public List<CourseChoose> getScore(Integer id) {
        List<CourseChoose> courseChooseList = courseChooseMapper.selectAllByCourseId(id);
        courseChooseList.get(0).setNum1(0);
        courseChooseList.get(0).setNum2(0);
        courseChooseList.get(0).setNum3(0);
        courseChooseList.get(0).setNum4(0);
        courseChooseList.get(0).setNum5(0);
        for (CourseChoose courseChoose : courseChooseList) {
            if (courseChoose.getScore3() >= 90) {
                courseChooseList.get(0).setNum1(courseChooseList.get(0).getNum1() + 1);
            }
            if (courseChoose.getScore3() >= 80 && courseChoose.getScore3() < 90) {
                courseChooseList.get(0).setNum2(courseChooseList.get(0).getNum2() + 1);
            }
            if (courseChoose.getScore3() >= 60 && courseChoose.getScore3() < 80) {
                courseChooseList.get(0).setNum3(courseChooseList.get(0).getNum3() + 1);
            }
            if (courseChoose.getScore3() > 0 && courseChoose.getScore3() < 60) {
                courseChooseList.get(0).setNum4(courseChooseList.get(0).getNum4() + 1);
            }
            if (courseChoose.getScore3() == 0) {
                courseChooseList.get(0).setNum5(courseChooseList.get(0).getNum5() + 1);
            }
            Student student = studentMapper.selectById(courseChoose.getStudentId());
            courseChoose.setCourse(courseMapper.selectById(courseChoose.getCourseId()));
            courseChoose.setStudent(student);
            courseChoose.setPerson(personMapper.selectById(student.getPersonId()));
        }
        return courseChooseList;
    }

    public boolean update(CourseChoose courseChoose) {
        return false;
    }
}
