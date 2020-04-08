package com.maxn.mockito.services;

import com.maxn.mockito.models.ReportModel;
import org.springframework.stereotype.Service;

@Service
public class ReportEmailSender {

    public void sendReport(ReportModel reportModel) {
        // send email to managers with report information
        System.out.println("sent mail: " + reportModel);
    }

}
