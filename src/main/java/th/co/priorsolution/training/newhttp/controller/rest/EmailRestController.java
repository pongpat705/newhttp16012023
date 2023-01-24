package th.co.priorsolution.training.newhttp.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.priorsolution.training.newhttp.model.EmailRequestModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.service.EmailService;

@RestController
@Slf4j
public class EmailRestController {

    private EmailService emailService;

    public EmailRestController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/post/email")
    public ResponseModel<Void> sendEmailWithAttachment(@ModelAttribute EmailRequestModel emailRequestModel) {

        return this.emailService.sendEmailWithAttechment(emailRequestModel);
    }
}
