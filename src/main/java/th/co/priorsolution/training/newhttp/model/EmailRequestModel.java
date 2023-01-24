package th.co.priorsolution.training.newhttp.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmailRequestModel {

    private String name;
    private String mobileNo;
    private String description;
    private MultipartFile file;
}
