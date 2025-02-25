package hello.advenced.app.v1;

import hello.advenced.trace.TraceStatus;
import hello.advenced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepositoryV1.save()");
            if("ex".equals(itemId)){
                throw new IllegalStateException("예외 발생!!");
            }
            sleep(1000);
            trace.end(status);
        }
        catch(Exception e){
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }



    }

    private void sleep(int milles) {
        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
