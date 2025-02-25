package hello.advenced.trace.hellotrace;

import hello.advenced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV1Test {


    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello");
        trace.end(status);
    }

    @Test
    void begin_exception(){

        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus hello = trace.begin("Hello");
        trace.exception(hello , new IllegalStateException("장애발생"));
    }
}