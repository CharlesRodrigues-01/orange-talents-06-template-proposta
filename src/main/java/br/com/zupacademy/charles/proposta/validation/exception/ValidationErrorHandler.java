package br.com.zupacademy.charles.proposta.validation.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationErrorHandler {
    private MessageSource messageSource;
    public ValidationErrorHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public List<ValidationMessage> handleBindException(BindException er) {
        List<FieldError> errors = er.getBindingResult().getFieldErrors();

        return errors.stream().map(field -> new ValidationMessage(
                field.getField(),
                getErrorMessage(field)
        )).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationMessage> handleValidationException(MethodArgumentNotValidException e) {
        return handleBindException(e);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionPadronizado> handleApiErroException(ApiException apiException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(apiException.getReason());

        ExceptionPadronizado exceptionPadronizado = new ExceptionPadronizado(mensagens);
        return ResponseEntity.status(apiException.getHttpStatus()).body(exceptionPadronizado);
    }

    public String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }
}
