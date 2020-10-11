
package com.college.domain;

//老师
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String teacherTitle;
    private String teacherHonor;
    private String teacherTeam;
    private String teacherTeamTitle;

    public String getTeacherTeamTitle() {
        return teacherTeamTitle;
    }

    public void setTeacherTeamTitle(String teacherTeamTitle) {
        this.teacherTeamTitle = teacherTeamTitle;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherHonor() {
        return teacherHonor;
    }

    public void setTeacherHonor(String teacherHonor) {
        this.teacherHonor = teacherHonor;
    }

    public String getTeacherTeam() {
        return teacherTeam;
    }

    public void setTeacherTeam(String teacherTeam) {
        this.teacherTeam = teacherTeam;
    }

    public Teacher(Integer teacherId, String teacherName, String teacherTitle, String teacherHonor, String teacherTeam, String teacherTeamTitle) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherTitle = teacherTitle;
        this.teacherHonor = teacherHonor;
        this.teacherTeam = teacherTeam;
        this.teacherTeamTitle = teacherTeamTitle;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherTitle='" + teacherTitle + '\'' +
                ", teacherHonor='" + teacherHonor + '\'' +
                ", teacherTeam='" + teacherTeam + '\'' +
                ", teacherTeamTitle='" + teacherTeamTitle + '\'' +
                '}';
    }
}