package hello.advenced.app.v2;


import hello.advenced.trace.TraceStatus;
import hello.advenced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v2/request")
    public String orderItem(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderControllerV2.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        }
        catch(Exception e){
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
