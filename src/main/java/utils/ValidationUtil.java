package utils;

import pojo.ValidationQuestion;

/**
 * #Author :Sino
 * #Date   :2021/11/15 23:36
 * #Describe:
 */
public class ValidationUtil {
    private ValidationUtil() {}

    public static String transformTheIndex(int index) {
        String question = null;
        switch (index) {
            case 0:
                question = "母亲的姓名";
                break;
            case 1:
                question = "父亲的姓名";
                break;
            case 2:
                question = "高中班主任老师的姓名";
                break;
            case 3:
                question = "最喜欢的工作";
                break;
            case 4:
                question = "最喜欢的食物";
                break;
        }
        return question;
    }

    public static ValidationQuestion transformTheQuestion(String question) {
        ValidationQuestion validationQuestion = null;
        switch (question) {
            case "母亲的姓名":
                validationQuestion = ValidationQuestion.MOTHER_NAME;
                break;
            case "父亲的姓名":
                validationQuestion = ValidationQuestion.FATHER_NAME;
                break;
            case "高中班主任老师的姓名":
                validationQuestion = ValidationQuestion.HIGH_SCHOOL_TEACHER_NAME;
                break;
            case "最喜欢的工作":
                validationQuestion = ValidationQuestion.FAVORITE_JOB;
                break;
            case "最喜欢的食物":
                validationQuestion = ValidationQuestion.FAVORITE_FOOD;
                break;
        }

        return validationQuestion;
    }
}
