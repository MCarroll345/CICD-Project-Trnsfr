package ie.atu.bam;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/receipt")
@RestController
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/getAll")
    public List<Receipt> get(){
        return receiptService.getAll();
    }

    @PostMapping("/createRec/{IBAN}/{uID}/{inout}/{num}")
    public void createReceipt(@PathVariable int IBAN,@PathVariable Long uID,@PathVariable String inout,@PathVariable float num){
        receiptService.withDepRec(IBAN, uID, inout, num);
    }

    @GetMapping("/getRec/{uID}")
    public List<Object> getRecs(@PathVariable Long uID){
        return receiptService.returnRec(uID);
    }

    @PostMapping("/transferRec/{IBAN1}/{uID1}/{IBAN2}/{uID2}/{num}")
    public void transferRec(@PathVariable int IBAN1,@PathVariable Long uID1, @PathVariable int IBAN2,@PathVariable Long uID2,@PathVariable float num){
        receiptService.transferRec(IBAN1, uID1, IBAN2, uID2, num);
    }


}
