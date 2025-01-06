package ie.atu.bam;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    public List<Receipt> getCustomers(){
        return receiptRepository.findAll();
    }

    public ReceiptService(ReceiptRepository receiptRepository){
        this.receiptRepository = receiptRepository;
    }

    public List<Receipt> getAll(){
        return receiptRepository.findAll();
    }

    public void withDepRec(int IBAN, String inout, float num){
        Receipt receipt = new Receipt();
        float plusMinus = 0;
        receipt.setAccountIBAN1(IBAN);
        switch (inout){
            case "withdraw":
                plusMinus = 0 - num;
                System.out.println("Receipt created: W");
                receipt.setBalChange(plusMinus);
                receiptRepository.save(receipt);
                break;
            case "deposit":
                System.out.println("Receipt created: D");
                receipt.setBalChange(num);
                receiptRepository.save(receipt);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public void transferRec(int IBAN1, int IBAN2, float num){
        Receipt receipt = new Receipt();
        float plusMinus = 0;
        receipt.setAccountIBAN1(IBAN1);
        receipt.setAccountIBAN2(IBAN2);
        plusMinus = 0 - num;
        System.out.println("Receipt created: W");
        receipt.setBalChange(plusMinus);
        receiptRepository.save(receipt);
    }

    public List<Object> returnRec(int IBAN){
        return receiptRepository.findByAccountIBAN1(IBAN);
    }

}

