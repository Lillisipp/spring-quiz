package ru.yandex.practicum.quiz.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.quiz.model.Question;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@ConfigurationProperties("spring-quiz.questions-settings")
public class QuizConfig {
    private final List<Question> questions;

    public QuizConfig(int defaultAttempts, List<Question> questions) {
        this.questions = questions.stream()
                .peek(question ->
                {
                    if (question.getAttempts() == null) {
                        question.setAttempts(defaultAttempts);
                    }
                })
                .toList();

//        questions.add(new Question(
//                "Что такое Spring Framework?",
//                List.of("Фреймворк для разработки Java-приложений",
//                        "Библиотека для работы с базами данных",
//                        "Язык программирования"),
//                1,
//                1
//        ));
//        questions.add(new Question(
//                "Что означает IoC в Spring Framework?",
//                List.of("Input-output Control",
//                        "Input-output Configuration",
//                        "Inversion of Control",
//                        "Integration of Components"),
//                3,
//                3
//        ));
//
//        questions.add(new Question(
//                "Что такое внешняя конфигурация в Spring Boot?",
//                List.of("Конфигурация внешних библиотек",
//                        "Конфигурация, которая не является частью исполняемого jar-файла",
//                        "Конфигурация через веб-интерфейс"),
//                2,
//                2
//        ));
//
//        questions.add(new Question(
//                "Как можно указать настройки внешней конфигурации в Spring Boot приложении?",
//                List.of("Через Интернет",
//                        "Через файлы .yaml и .properties",
//                        "Через сайт spring.io"),
//                2,
//                1
//        ));
  }
}
