package shop.mtcoding.blog._core.error;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import shop.mtcoding.blog._core.error.ex.Exception400;

import java.util.List;

// 관점 - Aspect, PointCut - 실행되는 시점, Advice - 공통 모듈
@Aspect
@Component
public class GlobalValidationHandler {

    // 관심사를 분리시킴
    // PostMapping 혹은 PutMapping이 붙어있는 메서드를 실행하기 직전에 Advice를 호출하라
    // point cut
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void badRequestAdvice(JoinPoint jp) { //jp는 실행될 실제 메서드의 모든 것을 투영하고 있다.
        Object[] args = jp.getArgs(); // 메서드의 매개변수들

        for (Object arg : args) { // 매개변수 개수만큼 반복 (어노테이션은 제외)

            // Errors 타입 매개변수에 존재하고
            if (arg instanceof Errors) {
                System.out.println("에러 400 처리 필요");
                Errors errors = (Errors) arg;

                // 에러가 존재한다면
                if (errors.hasErrors()) { // Errors가 1개 이상이면 ture 아니면 false
                    List<FieldError> fErrors = errors.getFieldErrors(); // list 리턴, 에러를 받아옴

                    for (FieldError fieldError : fErrors) {
                        throw new Exception400(fieldError.getField() + ":" + fieldError.getDefaultMessage());
                    }
                }
            }
        }
    }
}
