/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package thymeleafsandbox.stsm.web.controller.seedstarter.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import thymeleafsandbox.stsm.business.entities.SeedStarter;
import thymeleafsandbox.stsm.business.services.SeedStarterService;
import thymeleafsandbox.stsm.web.controller.seedstarter.SeedStarterContoller;

@Controller
public class ListSeedStarterController extends SeedStarterContoller{
  @Autowired
  private SeedStarterService seedStarterService;

  @ModelAttribute("allSeedStarters")
  public List<SeedStarter> populateSeedStarters() {
    return this.seedStarterService.findAll();
  }

  @RequestMapping({ "/", "list" })
  public String showSeedstarters(final SeedStarter seedStarter) {
    return "starter_list";
  }
}
