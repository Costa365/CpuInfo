package com.costa365.cpuinfo.controllers;

import com.costa365.cpuinfo.models.Cpus;
import com.costa365.cpuinfo.repositories.CpusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.bson.types.ObjectId;

import java.util.List;

@RestController
@RequestMapping("/cpus")
public class CpusController {
  @Autowired
  private CpusRepository repository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Cpus> getAllCpus() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Cpus getCpuById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }

  @CrossOrigin(origins = "*")
  @RequestMapping(value="/search", method = RequestMethod.GET)
  public List<Cpus> getCpuById(@RequestParam("name") String name){
    return repository.findByNameLike(name);
  }
}
