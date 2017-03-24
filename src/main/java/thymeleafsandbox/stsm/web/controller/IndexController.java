package thymeleafsandbox.stsm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import thymeleafsandbox.stsm.business.entities.SeedStarter;
import thymeleafsandbox.stsm.web.controller.seedstarter.SeedStarterContoller;

@Controller
public class IndexController {
  @RequestMapping({ "/" })
  public String showSeedstarters(final SeedStarter seedStarter) {
    return "redirect:" + SeedStarterContoller.PATH + "/";
  }
}
