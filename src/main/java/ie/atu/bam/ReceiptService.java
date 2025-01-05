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



}

