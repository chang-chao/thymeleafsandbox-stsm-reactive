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
package thymeleafsandbox.stsm.web.controller.seedstarter.edit;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import thymeleafsandbox.stsm.business.entities.Feature;
import thymeleafsandbox.stsm.business.entities.SeedStarter;
import thymeleafsandbox.stsm.business.entities.Type;
import thymeleafsandbox.stsm.business.entities.Variety;
import thymeleafsandbox.stsm.business.services.SeedStarterService;
import thymeleafsandbox.stsm.business.services.VarietyService;
import thymeleafsandbox.stsm.web.controller.seedstarter.SeedStarterContoller;

@Controller
public class EditSeedStarterController extends SeedStarterContoller {
  @Autowired
  private VarietyService varietyService;
  @Autowired
  private SeedStarterService seedStarterService;

  @ModelAttribute("allTypes")
  public List<Type> populateTypes() {
    return Arrays.asList(Type.ALL);
  }

  @ModelAttribute("allFeatures")
  public List<Feature> populateFeatures() {
    return Arrays.asList(Feature.ALL);
  }

  @ModelAttribute("allVarieties")
  public List<Variety> populateVarieties() {
    return this.varietyService.findAll();
  }

  @RequestMapping(path = "/edit", method = RequestMethod.GET)
  public String showSeedstarters(final SeedStarter seedStarter) {
    seedStarter.setDatePlanted(Calendar.getInstance().getTime());
    return "starter_add";
  }

  @RequestMapping(path = "/edit", method = RequestMethod.POST)
  public String saveSeedstarter(final SeedStarter seedStarter, final BindingResult bindingResult,
      final ModelMap model) {
    if (bindingResult.hasErrors()) {
      return "seedstartermng";
    }
    this.seedStarterService.add(seedStarter);
    model.clear();
    return "redirect:/list";
  }

}
