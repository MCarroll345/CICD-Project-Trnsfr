package ie.atu.bam;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RestController
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }


}
