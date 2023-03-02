package com.iiht.fse.productservice.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

//    @Autowired
//    private KafkaProducerService kafkaProducerService;


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleArgumentException(MethodArgumentNotValidException e){
//        logger.error("Application Exception : ",e);
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request){
        String errorList = ex.getBindingResult().
                getFieldErrors().get(0).getDefaultMessage();
        logger.error("Application Exception : ",errorList);
        return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e){
        logger.error("Application Exception : ",e);
//        kafkaProducerService.logMessage("Application Exception : "+e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
