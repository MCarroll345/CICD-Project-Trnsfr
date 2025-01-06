package ie.atu.bam;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/receipt")
@RestController
@CrossOrigin
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/getAll")
    public List<Receipt> get(){
        return receiptService.getAll();
    }

    @PostMapping("/createRec/{IBAN}/{inout}/{num}")
    public void createReceipt(@PathVariable int IBAN,@PathVariable String inout,@PathVariable float num){
        receiptService.withDepRec(IBAN, inout, num);
    }

    @GetMapping("/getRec/{IBAN}")
    public List<Object> getRecs(@PathVariable int IBAN){
        return receiptService.returnRec(IBAN);
    }

    @PostMapping("/transferRec/{IBAN1}/{IBAN2}/{num}")
    public void transferRec(@PathVariable int IBAN1,@PathVariable int IBAN2,@PathVariable float num){
        receiptService.transferRec(IBAN1,IBAN2,num);
    }


}
