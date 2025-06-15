package org.example.authclient.controller;

import lombok.RequiredArgsConstructor;
import org.example.authclient.client.AUTHServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthServiceController {

    private final AUTHServiceClient authServiceClient;

}
