package com.example.lte.restful;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 根据需要，此处可以全局处理
 * 各种异常应该返回的 code/msg信息
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {
    /**
     * 运行时业务异常
     * @param e APIException
     * @return String
     */
    @ExceptionHandler({APIException.class})
    public ResultVO<String> APIExceptionHandler(APIException e) {
        // 注意哦，这里返回类型是自定义响应体
        return new ResultVO<>(e.getCode(), e.getMsg());
    }

    /**
     * 对 jsr303 参数校验失败抛出的MethodArgumentNotValidException全局处理
     * @param e MethodArgumentNotValidException
     * @return String
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCodeEnum.VALIDATE_FAILED, objectError.getDefaultMessage());
    }


//    // UnauthorizedException
//    @ExceptionHandler({UnauthorizedException.class})
//    public ResultVO<String> ErrorHandler2(UnauthorizedException e) {
//        log.error("没有通过权限验证！", e);
//        return new ResultVO<>(ResultCodeEnum.ACCOUNT_DISABLED, e.getMessage());
//    }


    /**
     * 未登录异常
     * @param e AuthorizationException
     * @return ResultVO<String>
     */
//    @ExceptionHandler({AuthorizationException.class})
//    public ResultVO<String> ErrorHandler(AuthorizationException e) {
//        log.error("没有通过权限验证！", e);
//        return new ResultVO<>(ResultCodeEnum.NOT_LOGIN, e.getMessage());
//    }



    /**
     * 处理 ArithmeticException 类的异常 （如除0异常）
     */
    @ExceptionHandler({ ArithmeticException.class })
    public ResultVO arithmeticExceptionHandler(ArithmeticException e) {
        return new ResultVO(ResultCodeEnum.ARITHMETIC_FAILED,e.getMessage());
    }


    @ExceptionHandler({ ArrayIndexOutOfBoundsException.class })
    public ResultVO arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e) {
        return new ResultVO(ResultCodeEnum.ARRAY_INDEX_OUT_OF_BOUNDS_FAILED,e.getMessage());
    }


//    public static String getThrowableStackInfo(Throwable e) {
//        ByteArrayOutputStream buf = new ByteArrayOutputStream();
//        e.printStackTrace(new java.io.PrintWriter(buf, true));
//        String msg = buf.toString();
//        try {
//            buf.close();
//        } catch (Exception t) {
//            return e.getMessage();
//        }
//        return msg;
//    }

//    @ResponseBody
//    @ExceptionHandler(value = ArithmeticException.class)
//    public String handleArithmetic(HttpServletRequest request, HttpServletResponse response, ArithmeticException e)
//            throws IOException {
//        log.info("divide error!");
//        return "divide 0: " + getThrowableStackInfo(e);
//    }

//    @ResponseBody
//    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
//    public String handleArrayIndexOutBounds(HttpServletRequest request, HttpServletResponse response,
//                                            ArrayIndexOutOfBoundsException e) throws IOException {
//        log.info("array index out error!");
//        return "aryIndexOutOfBounds: " + getThrowableStackInfo(e);
//    }


    /**
     * 未知异常
     * @param e
     * @return
     */
    @ExceptionHandler({ Exception.class })
    public ResultVO otherExceptionHandle(Exception e){
        log.error("otherExceptionHandle",e);
        return new ResultVO(ResultCodeEnum.ERROR,e.getMessage());
    }


}
